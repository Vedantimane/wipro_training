package com.springboot.demo.entity;

public class User {

	String userName;
	String userEmail;
	String userPhone;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userEmail=" + userEmail + ", userPhone=" + userPhone + "]";
	}
	public User(String userName, String userEmail, String userPhone) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}
	public User() {
		super();
	}
	
}
