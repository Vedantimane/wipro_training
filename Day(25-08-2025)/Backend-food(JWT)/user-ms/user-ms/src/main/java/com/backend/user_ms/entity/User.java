package com.backend.user_ms.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="user")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name = "user_name")
	String userName;
	
	@Column(name = "user_email")
	@Unq
	String userEmail;
	
	@Column(name = "user_password")
	String passWord;
	
	@Column
	String salt;

}