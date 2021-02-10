package edu.scs.vds.controller;

import edu.scs.vds.model.User;
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
import java.util.Optional;

@Controller
@RequestMapping(path = "patient")
public class PatientController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "patient/index";
    }

    @RequestMapping(value = "/application", method = RequestMethod.GET)
    public String application() {
        return "patient/get-appointment";
    }


    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security + Hibernate Example");
        model.addObject("message", "This is default page!");
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
