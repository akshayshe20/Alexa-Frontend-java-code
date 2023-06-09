package com.bookmycon.model;

public class User {


    private int userId;


    private String userName;


    private String userEmail;

 
    private String userPassword;

   
    private String userRole;

    
    private String userContact;


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


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


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public String getUserContact() {
		return userContact;
	}


	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userRole=" + userRole + ", userContact=" + userContact + "]";
	}


	public User(int userId, String userName, String userEmail, String userPassword, String userRole,
			String userContact) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userContact = userContact;
	}


	public User() {
		super();
	}
    
}
