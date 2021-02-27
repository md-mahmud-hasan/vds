package edu.scs.vds.controller.api;

import edu.scs.vds.model.Application;
import edu.scs.vds.model.User;
import edu.scs.vds.service.ApplicationService;
import edu.scs.vds.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@EnableSwagger2
@Api(value = "Test API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Vaccine Applications"}, description = "API List")
public class ApplicationApiController {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    UserService userService;

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
    public Application addApplication(@RequestBody Application application){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        Optional<User> user = userService.getUser(userDetail.getUsername());
        Application existingApplication = applicationService.getByUser(user.get());
        if(!existingApplication.equals(null))
            application.setId(existingApplication.getId());
        applicationService.save(application);
        return application;
    }

    @PutMapping("/application/{id}")
    public ResponseEntity<?> update(@RequestBody Application application, @PathVariable Integer id) {
        try {
            Application existingApplication = applicationService.get(id);
            if(!existingApplication.equals(null))
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

}
