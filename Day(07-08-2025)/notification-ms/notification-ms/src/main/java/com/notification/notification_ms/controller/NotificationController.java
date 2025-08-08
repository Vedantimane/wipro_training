package com.notification.notification_ms.controller;

import com.notification.notification_ms.entity.Notification;
import com.notification.notification_ms.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public String saveNotification(@RequestBody Notification notification) {
        notificationService.save(notification);
        return "Notification saved successfully";
    }

    @GetMapping
    public List<Notification> findAll() {
        return notificationService.findAll();
    }

    @GetMapping("/{id}")
    public Notification findById(@PathVariable int id) {
        return notificationService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable int id) {
        notificationService.deleteById(id);
        return "Notification deleted successfully";
    }
    @PutMapping
    public void update(@RequestBody Notification notification) {
         notificationService.update(notification) ;
    }
}
