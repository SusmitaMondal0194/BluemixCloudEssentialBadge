package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Invalid_Login_POM {

	private WebDriver driver;

	public Invalid_Login_POM(WebDriver driver) {
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

	//Inspecting the Assertion message
	@FindBy(xpath = "//*[@class='alert alert-danger']")
	private WebElement actualMsg;
	
	/*
	public void clickAccountIcon() {
		this.accountIcon.click();
	}

	public void emailAddress(String emailAddress) {
		this.emailAddress.sendKeys(emailAddress);
	}

	public void password(String password) {
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		this.loginBtn.click();
	}
	*/
	
	//Returning the Assertion message
	public String actualMsg() {
		return this.actualMsg.getText();
	}
}
