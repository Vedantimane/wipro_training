package com.backend.user_ms.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="user_data")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	int userId;
	
	@Column(name = "user_name")
	String userName;
	
	@Column(name = "user_email")
	String userEmail;
	
	@Column(name = "user_password")
	String userPassword;	

}
