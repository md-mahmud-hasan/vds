package edu.scs.vds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}
