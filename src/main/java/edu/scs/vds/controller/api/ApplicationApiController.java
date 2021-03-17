package edu.scs.vds.controller.api;

import edu.scs.vds.model.Application;
import edu.scs.vds.model.User;
import edu.scs.vds.model.dto.ApplicationDto;
import edu.scs.vds.model.dto.ConfirmApplication;
import edu.scs.vds.model.enums.ApplicationStatus;
import edu.scs.vds.service.ApplicationService;
import edu.scs.vds.service.BoothService;
import edu.scs.vds.service.S3FileUploaderService;
import edu.scs.vds.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@EnableSwagger2
@Api(value = "Test API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Vaccine Applications"}, description = "API List")
@RequestMapping("/api/v1/")
public class ApplicationApiController {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    UserService userService;

    @Autowired
    BoothService boothService;

    @Autowired
    S3FileUploaderService s3FileUploaderService;

    @GetMapping("/applications")
    public List<Application> list() {
        return applicationService.listAll();
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> get(@PathVariable Integer id) {
        try {
            Application application = applicationService.get(id);
            return new ResponseEntity<Application>(application, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Application>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/application")
    public Application addApplication(@RequestBody Application application) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        Optional<User> user = userService.getUser(userDetail.getUsername());
        Application existingApplication = applicationService.getByUser(user.get());
        if (!existingApplication.equals(null))
            application.setId(existingApplication.getId());
        applicationService.save(application);
        return application;
    }

    @PostMapping("/apply")
    public Application apply(@RequestParam(value = "file", required = false) MultipartFile file, ApplicationDto applicationDto) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        Optional<User> user = userService.getUser(userDetail.getUsername());
        User currentUser = user.get();
        Application application = applicationService.getByUser(user.get());
        if (application == null)
            application = new Application();
        application.setStatus(ApplicationStatus.NEW);
        application.setActive(true);
        application.setUser(currentUser);

        if (applicationDto.getStep() == 1) {
            //STEP-1:Set location
            application.setEmergencyContact(applicationDto.getEmergencyContact());
            application.setBooth(boothService.get(applicationDto.getBoothId()));

        }else if (applicationDto.getStep() == 2){
            //STEP-2:Required Medical Report
            //do nothing

        }else if (applicationDto.getStep() == 3) {
            //STEP-3:Upload Medical Report
            try {
                String uploadedFileUrl = s3FileUploaderService.fileUploader(file, "pdf");
                application.setTestReport(uploadedFileUrl);
                System.out.println(uploadedFileUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(applicationDto.getStep()==4){
            //STEP-4:Recent Health Status
            application.setHasChronicDisease(applicationDto.getHasChronicDisease());
            application.setHasHeartDisease(applicationDto.getHasHeartDisease());
            application.setHasAllergy(applicationDto.getHasAllergy());
            application.setHasLungDisease(applicationDto.getHasLungDisease());
            application.setNote(applicationDto.getNote());

        }else if(applicationDto.getStep()==5){
            //STEP-5:Preferred Appointment & Schedule
            application.setPreferredAppointmentDate(applicationDto.getPreferredAppointmentDate());
        }

        if (currentUser.getAppointmentStep() < applicationDto.getStep()) {
            currentUser.setAppointmentStep(applicationDto.getStep());
            userService.save(currentUser);
        }
        applicationService.save(application);
        return application;
    }

    @PutMapping("/application/{id}")
    public ResponseEntity<?> update(@RequestBody Application application, @PathVariable Integer id) {
        try {
            Application existingApplication = applicationService.get(id);
            if (!existingApplication.equals(null))
                application.setId(existingApplication.getId());
            applicationService.save(application);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/applications/{id}")
    public void delete(@PathVariable Integer id) {
        applicationService.delete(id);
    }

    @RequestMapping(value = "/data/applications", method = RequestMethod.POST)
    public DataTablesOutput<Application> getApplications(@Valid @RequestBody DataTablesInput input) {
        Integer appointmentStep = 5;
        return applicationService.listAllDatatable(input,appointmentStep);
    }

    @RequestMapping(value = "/data/confirmed-applications", method = RequestMethod.POST)
    public DataTablesOutput<Application> getConfirmedApplications(@Valid @RequestBody DataTablesInput input) {
        Integer appointmentStep = 7;
        return applicationService.listAllDatatable(input,appointmentStep);
    }

    @PostMapping("/confirm-application")
    public Boolean confirmApplication(@RequestBody ConfirmApplication confirmApplication) {
        try {
            for (Integer id : confirmApplication.getApplicationIds()) {
                Application application = applicationService.get(id);
                application.setDoseOneDate(confirmApplication.getApplicationDate());
                User user = application.getUser();
                user.setAppointmentStep(6);
                applicationService.save(application);
                userService.save(user);
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }



}
