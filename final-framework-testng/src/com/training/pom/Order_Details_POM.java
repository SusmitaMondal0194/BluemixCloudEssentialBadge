package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order_Details_POM {
	private WebDriver driver;

	public Order_Details_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Inspecting the element Account Icon
	@FindBy(xpath = "//*[@class='fa fa-user-o']")
	private WebElement accountIcon;
	
	/*

	@FindBy(id = "input-email")
	private WebElement emailAddress;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//*[@value='Login']")
	private WebElement loginBtn;
	*/
	
	//Inspecting the element My Orders
	@FindBy(xpath = "//*[@class='tb_link tb_menu_system_account_order']")
	private WebElement myOrders;

	//Inspecting the element View Orders
	@FindBy(xpath = "//a[@title='View']")
	private WebElement viewOrders;

	
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

	//Moving mouse to Account Icon
	public void moveToAccountIcon() {
		Actions act = new Actions(driver);
		act.moveToElement(accountIcon).build().perform();
	}

	//Clicking on My orders 
	public void myOrders() {
		this.myOrders.click();
	}

	//Clicking on View Orders
	public void viewOrders() {
		this.viewOrders.click();
	}

}
