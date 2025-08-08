package com.notification.notification_ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notification.notification_ms.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

	
}
