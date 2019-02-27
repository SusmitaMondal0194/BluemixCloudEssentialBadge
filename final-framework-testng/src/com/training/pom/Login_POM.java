package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_POM {
	private WebDriver driver;

	public Login_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * @FindBy(xpath = "//*[@class='fa fa-user-o']") private WebElement accountIcon;
	 */

	//Searching fo rthe Element Email ID
	@FindBy(id = "input-email")
	private WebElement emailAddress;

	//Searching fo rthe Element Password
	@FindBy(id = "input-password")
	private WebElement password;

	//Searching fo rthe Element Login Button
	@FindBy(xpath = "//*[@value='Login']")
	private WebElement loginBtn;

	/*
	 * public void clickAccountIcon() { this.accountIcon.click(); }
	 * 
	 */

	// Providing Email Address
	public void emailAddress(String emailAddress) {
		this.emailAddress.sendKeys(emailAddress);
	}

	// Providing Password
	public void password(String password) {
		this.password.sendKeys(password);
	}

	// Clicking on Login Button
	public void clickLoginBtn() {
		this.loginBtn.click();
	}

}
