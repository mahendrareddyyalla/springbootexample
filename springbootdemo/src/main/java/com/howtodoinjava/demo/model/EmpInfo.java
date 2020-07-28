package com.howtodoinjava.demo.model;

public class EmpInfo {
	 /**
     * Id for the User.
     */
    private String userId;

    /**
     * Username for the User.
     */
    private String userName;

    /**
     * First Name for the User.
     */
    private String firstName;

    /**
     * Last Name for the User.
     */
    private String lastName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
