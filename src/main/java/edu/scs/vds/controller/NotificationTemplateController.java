package edu.scs.vds.controller;

import edu.scs.vds.model.NotificationTemplate;
import edu.scs.vds.service.NotificationTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class NotificationTemplateController {

    @Autowired
    NotificationTemplateService notificationTemplateService;

    @GetMapping("/notificationTemplates")
    public List<NotificationTemplate> list() {
        return notificationTemplateService.listAll();
    }

    @GetMapping("/notificationTemplate/{id}")
    public ResponseEntity<NotificationTemplate> get(@PathVariable Integer id) {
        try {
            NotificationTemplate notificationTemplate = notificationTemplateService.get(id);
            return new ResponseEntity<NotificationTemplate>(notificationTemplate, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<NotificationTemplate>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/notificationTemplate")
    public NotificationTemplate addNotificationTemplate(@RequestBody NotificationTemplate notificationTemplate){
        notificationTemplateService.save(notificationTemplate);
        return notificationTemplate;
    }

    @PutMapping("/notificationTemplate/{id}")
    public ResponseEntity<?> update(@RequestBody NotificationTemplate notificationTemplate, @PathVariable Integer id) {
        try {
            NotificationTemplate existingNotificationTemplate = notificationTemplateService.get(id);
            notificationTemplateService.save(notificationTemplate);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/notificationTemplates/{id}")
    public void delete(@PathVariable Integer id) {
        notificationTemplateService.delete(id);
    }

}
