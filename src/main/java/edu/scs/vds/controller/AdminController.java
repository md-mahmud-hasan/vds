package edu.scs.vds.controller;

import edu.scs.vds.model.User;
import edu.scs.vds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping(path = "admin")
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/index");
        UserDetails userDetail = (UserDetails) principal;
        Optional<User> user = userService.getUser(userDetail.getUsername());
        modelAndView.addObject("user",user.get());
        return modelAndView;
    }




}
