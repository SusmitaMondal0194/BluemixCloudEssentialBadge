package com.training.bean;

public class LoginBean {
	private String emailAddress;
	private String password;

	public LoginBean() {
	}

	public LoginBean(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public String getemailAddress() {
		return emailAddress;
	}

	public void setUserName(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [emailAddress=" + emailAddress + ", password=" + password + "]";
	}


}
