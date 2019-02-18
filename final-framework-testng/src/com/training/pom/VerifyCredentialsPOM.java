package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyCredentialsPOM {
	private WebDriver driver;

	public VerifyCredentialsPOM(WebDriver driver) {
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

	
}
