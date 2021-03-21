package edu.scs.vds.controller.api;

import edu.scs.vds.model.Booth;
import edu.scs.vds.service.mail.EmailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.NoSuchElementException;

@RestController
@EnableSwagger2
@Api(value = "Help API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Vaccine Applications"}, description = "API List")
@RequestMapping("/api/v1/")
public class HelpApiController {

    @Autowired
    EmailService emailService;

    @GetMapping("/help")
    public ResponseEntity<?> help() {
        try {
            String from = "no-reply@mahmud.dev";
            String to = "matinwsitaus@gmail.com";
            String subject = "Emergency : Help needed ";
            String body = "Test Body";
            emailService.sendSimpleMessage(from,to,subject,body);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
