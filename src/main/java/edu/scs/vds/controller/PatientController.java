package edu.scs.vds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "patient")
public class PatientController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "patient/index";
    }
}
