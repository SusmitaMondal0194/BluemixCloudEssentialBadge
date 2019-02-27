package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recover_PW_POM {
	private WebDriver driver;
	//public static boolean flag = false;

	public Recover_PW_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*

	@FindBy(xpath = "//*[@class='fa fa-user-o']")
	private WebElement accountIcon;

	@FindBy(id = "input-email")
	private WebElement emailAddress;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//*[@value='Login']")
	private WebElement loginBtn;

*/

	//Inspecting the element Forgotten Password
	@FindBy(linkText = "Forgotten Password")
	private WebElement forgottenPassword;

	//Inspecting the element Recover Password link
	@FindBy(xpath = "//*[@class='form-control']")
	private WebElement recoverPassword;

	//Inspecting the element Forgotten Password
	@FindBy(xpath = "//*[@class='btn btn-primary']")
	private WebElement continueRecovery;

	////Inspecting the Assertion message
	@FindBy(xpath = "//*[@class='alert alert-success']")
	public WebElement recoveryMsg;

	
	/*
	public void clickAccountIcon() {
		this.accountIcon.click();
	}

	public void emailAddress(String emailAddress) {
		// this.emailAddress.clear();
		this.emailAddress.sendKeys(emailAddress);
	}

	public void password(String password) {
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		this.loginBtn.click();
	}
	*/
	
	
	//Clicking on Forgotten Password
	public void forgottenPassword() {
		this.forgottenPassword.click();
	}

	//Proving Email ID for recovery of Password
	public void recoverPassword(String recoverPassword) {
		this.recoverPassword.clear();
		this.recoverPassword.sendKeys(recoverPassword);
	}

	//Clicking on Continue
	public void continueRecovery() {
		this.continueRecovery.click();
	}
	
	//Returning Assertion message
	public String recoveryMsg() {
		return this.recoveryMsg.getText();
	}
	
}
