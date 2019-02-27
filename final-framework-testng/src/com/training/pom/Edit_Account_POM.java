package com.training.pom;

//TestCase ID: RTTC_005

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Edit_Account_POM {
	private WebDriver driver;
	public static boolean flag = false;

	public Edit_Account_POM(WebDriver driver) {
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

	
	//Moving to Edit Account Info
	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountInfo;

	//Moving to FirstName
	@FindBy(id = "input-firstname")
	private WebElement fname;

	//Moving to LastName
	@FindBy(id = "input-lastname")
	private WebElement lname;

	//Moving to Email
	@FindBy(id = "input-email")
	private WebElement email;

	//Moving to Telephone
	@FindBy(id = "input-telephone")
	private WebElement telephone;

	//Clicking on Continue
	@FindBy(xpath = "//*[@value='Continue']")
	private WebElement clickContinue;

	//Getting the Assertion message
	@FindBy(xpath = "//*[@class='alert alert-success']")
	private WebElement confirmationMsg;

	
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

	//Clicking on Edit Account info Link
	public void editAccountInfo() {
		this.editAccountInfo.click();
	}

	//Providing FirstName
	public void fname(String fname) {
		this.fname.clear();
		this.fname.sendKeys(fname);
	}

	//Providing LastName
	public void lname(String lname) {
		this.lname.clear();
		this.lname.sendKeys(lname);
	}

	//Providing Email ID
	public void email(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	//Providing Telephone Number
	public void telephone(String telephone) {
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}

	//Clicking on Continue
	public void clickContinue() {
		this.clickContinue.click();
	}

	//returning Assertion message
	public String confirmationMsg() {
		return this.confirmationMsg.getText();
	}

}
