package edu.scs.vds.controller.api;

import edu.scs.vds.model.Notification;
import edu.scs.vds.service.NotificationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Api(value = "API Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Notifications"}, description = "API List")
public class NotificationApiController {

    @Autowired
    NotificationService notificationService;

    @GetMapping("/notifications")
    public List<Notification> list() {
        return notificationService.listAll();
    }

    @GetMapping("/notification/{id}")
    public ResponseEntity<Notification> get(@PathVariable Integer id) {
        try {
            Notification notification = notificationService.get(id);
            return new ResponseEntity<Notification>(notification, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Notification>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/notification")
    public Notification addNotification(@RequestBody Notification notification){
        notificationService.save(notification);
        return notification;
    }

    @PutMapping("/notification/{id}")
    public ResponseEntity<?> update(@RequestBody Notification notification, @PathVariable Integer id) {
        try {
            Notification existingNotification = notificationService.get(id);
            notificationService.save(notification);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/notifications/{id}")
    public void delete(@PathVariable Integer id) {
        notificationService.delete(id);
    }

}
