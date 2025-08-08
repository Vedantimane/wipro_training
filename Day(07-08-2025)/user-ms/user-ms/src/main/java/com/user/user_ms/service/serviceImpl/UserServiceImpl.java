package com.user.user_ms.service.serviceImpl;

import java.util.List;

import com.user.user_ms.dto.NotificationDTO;
import com.user.user_ms.entity.User;
import com.user.user_ms.repository.UserRepository;
import com.user.user_ms.service.NotificationConccetService;
import com.user.user_ms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationConccetService notificationService;

    @Override
    public User save(User user) {
      
        User savedUser = userRepository.save(user);

        String notificationMessage = "New user created: " + savedUser.getUserName();

        try {
   
            List<NotificationDTO> allNotifications = notificationService.getAllNotification();

     
            NotificationDTO existingNotification = allNotifications.stream()
                .filter(n -> n.getUserId() == savedUser.getUserId())
                .findFirst()
                .orElse(null);

            if (existingNotification != null) {
                notificationMessage = existingNotification.getNotificationString(); 
            }

        } catch (Exception e) {
           
        }

       
        NotificationDTO notification = new NotificationDTO();
        notification.setUserId(savedUser.getUserId());
        notification.setNotificationString(notificationMessage);

        notificationService.doNotification(notification);

        return savedUser;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();

        try {
            List<NotificationDTO> allNotifications = notificationService.getAllNotification();

            for (User user : users) {
                NotificationDTO matchedNotification = null;
                if (allNotifications != null) {
                    matchedNotification = allNotifications.stream()
                            .filter(n -> n.getUserId() == user.getUserId())
                            .findFirst()
                            .orElse(null);
                }
                user.setNotificationDTO(matchedNotification);
            }
        } catch (Exception e) {
            users.forEach(user -> user.setNotificationDTO(null));
        }

        return users;
    }

    @Override
    public User findById(int id) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            try {
                List<NotificationDTO> allNotifications = notificationService.getAllNotification();

                NotificationDTO matchedNotification = null;
                if (allNotifications != null) {
                    matchedNotification = allNotifications.stream()
                            .filter(n -> n.getUserId() == user.getUserId())
                            .findFirst()
                            .orElse(null);
                }

                user.setNotificationDTO(matchedNotification);
            } catch (Exception e) {
                user.setNotificationDTO(null);
            }
        }

        return user;
    }

    @Override
    public boolean deleteById(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);

            NotificationDTO notification = new NotificationDTO();
            notification.setNotificationString("User deleted: ID " + id);
            notification.setUserId(id);
            notificationService.doNotification(notification);

            return true;
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        if (userRepository.existsById(user.getUserId())) {
            userRepository.save(user);

            NotificationDTO notification = new NotificationDTO();
            notification.setNotificationString("User updated: " + user.getUserName());
            notification.setUserId(user.getUserId());

            notificationService.doNotification(notification);

            return true;
        }
        return false;
    }
}
