package com.notification.notification_ms.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notification.notification_ms.entity.Notification;
import com.notification.notification_ms.repository.NotificationRepository;
import com.notification.notification_ms.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	@Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification save(Notification notification) {
       return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification findById(int id) {
        Optional<Notification> result = notificationRepository.findById(id);
        return result.orElse(null);
    }

    

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		 notificationRepository.deleteById(id);
		
	}

	@Override
	public void update(Notification notification) {
		// TODO Auto-generated method stub
		if (notificationRepository.existsById(notification.getUserId())) {
			notificationRepository.save(notification);
            ;
        }
	}
}
