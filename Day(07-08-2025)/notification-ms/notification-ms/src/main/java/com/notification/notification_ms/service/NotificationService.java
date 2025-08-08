package com.notification.notification_ms.service;

import java.util.List;

import com.notification.notification_ms.entity.Notification;

public interface NotificationService {
	
    Notification save(Notification notification);
    
    List<Notification> findAll();
    
    Notification findById(int id);
    
    void deleteById(int id);
    
    void update(Notification notification);
    
}
