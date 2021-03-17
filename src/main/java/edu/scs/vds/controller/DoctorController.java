package edu.scs.vds.controller;

import edu.scs.vds.model.Application;
import edu.scs.vds.model.Booth;
import edu.scs.vds.model.User;
import edu.scs.vds.service.ApplicationService;
import edu.scs.vds.service.BoothService;
import edu.scs.vds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "doctor")
public class DoctorController {

    @Autowired
    UserService userService;

    @Autowired
    BoothService boothService;

    @Autowired
    ApplicationService applicationService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {


        ModelAndView model = new ModelAndView();
        model.setViewName("doctor/index");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        Optional<User> user = userService.getUser(userDetail.getUsername());
        model.addObject("user",user.get());
        return model;
    }


    @RequestMapping(value = "/application-details/{id}", method = RequestMethod.GET)
    public ModelAndView application(@PathVariable Integer id) {

        ModelAndView model = new ModelAndView();
        model.setViewName("doctor/application-details");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        Optional<User> user = userService.getUser(userDetail.getUsername());
        model.addObject("user",user.get());
        Application application = applicationService.getByUser(user.get());
        model.addObject("vaccineApplication",application);
        return model;
    }

}
