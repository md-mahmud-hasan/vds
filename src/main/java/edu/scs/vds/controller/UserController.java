package edu.scs.vds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserWebController {

    @GetMapping("/index")
    public String login() {
        return "index";
    }

}
