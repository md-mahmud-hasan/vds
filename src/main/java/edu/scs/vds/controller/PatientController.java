package edu.scs.vds.controller;

import edu.scs.vds.model.Application;
import edu.scs.vds.model.Booth;
import edu.scs.vds.model.User;
import edu.scs.vds.service.ApplicationService;
import edu.scs.vds.service.BoothService;
import edu.scs.vds.service.MyUserDetailsService;
import edu.scs.vds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "patient")
public class PatientController {

    @Autowired
    UserService userService;

    @Autowired
    BoothService boothService;

    @Autowired
    ApplicationService applicationService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {


        ModelAndView model = new ModelAndView();
        model.setViewName("patient/index");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        Optional<User> user = userService.getUser(userDetail.getUsername());
        Application application = applicationService.getByUser(user.get());
        model.addObject("vaccineApplication",application);
        model.addObject("user",user.get());
        return model;
    }

    @RequestMapping(value = "/application", method = RequestMethod.GET)
    public ModelAndView application() {

        ModelAndView model = new ModelAndView();
        model.setViewName("patient/get-appointment");
        List<Booth> booths = boothService.listAll();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        User user = userService.getUser(userDetail.getUsername()).get();
        Application application = applicationService.getByUser(user);
        if (application == null)
            application = new Application();
        model.addObject("vaccineApplication",application);
        model.addObject("user",user);
        model.addObject("booths",booths);
        return model;
    }


    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.setViewName("patient/profile");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) auth.getPrincipal();
        Optional<User> user = userService.getUser(userDetail.getUsername());
        model.addObject("user",user.get());
        return model;
    }


    @RequestMapping(value = "/vaccine", method = RequestMethod.GET)
    public String vaccine() {
        return "patient/vaccine-dose";
    }


    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help() {
        return "patient/ask-for-help";
    }



}
