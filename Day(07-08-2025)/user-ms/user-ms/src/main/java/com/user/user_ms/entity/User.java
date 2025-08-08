package com.user.user_ms.entity;

import com.user.user_ms.dto.NotificationDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	
	String userName;
	String userPassword;
	String userAddress;
	
	 @Transient
	 NotificationDTO notificationDTO;

}
