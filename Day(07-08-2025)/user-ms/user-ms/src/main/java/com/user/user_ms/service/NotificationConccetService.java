package com.user.user_ms.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.user_ms.dto.NotificationDTO;

@FeignClient(name = "notification-ms")
public interface NotificationConccetService {

    @PostMapping("/notify")
    ResponseEntity<String> doNotification(@RequestBody NotificationDTO notificationDTO);

    @GetMapping("/notify")
	
    List<NotificationDTO> getAllNotification();
}
