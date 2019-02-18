package com.training.pom;

//TestCase ID: RTTC_005

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountInfoPOM {
	private WebDriver driver;
	public static boolean flag = false;

	public EditAccountInfoPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='fa fa-user-o']")
	private WebElement accountIcon;

	@FindBy(id = "input-email")
	private WebElement emailAddress;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//*[@value='Login']")
	private WebElement loginBtn;

	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountInfo;

	@FindBy(id = "input-firstname")
	private WebElement fname;

	@FindBy(id = "input-lastname")
	private WebElement lname;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-telephone")
	private WebElement telephone;

	@FindBy(xpath = "//*[@value='Continue']")
	private WebElement clickContinue;

	@FindBy(xpath = "//*[@class='alert alert-success']")
	private WebElement confirmationMsg;

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

	public void editAccountInfo() {
		this.editAccountInfo.click();
	}

	public void fname(String fname) {
		this.fname.clear();
		this.fname.sendKeys(fname);
	}

	public void lname(String lname) {
		this.lname.clear();
		this.lname.sendKeys(lname);
	}

	public void email(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public void telephone(String telephone) {
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}

	public void clickContinue() {
		this.clickContinue.click();
	}

	public String confirmationMsg() {
		return this.confirmationMsg.getText();
	}

}
