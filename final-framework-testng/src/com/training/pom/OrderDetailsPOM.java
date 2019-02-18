package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPOM {
	private WebDriver driver;

	public OrderDetailsPOM(WebDriver driver) {
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

	@FindBy(xpath = "//*[@class='tb_link tb_menu_system_account_order']")
	private WebElement myOrders;

	@FindBy(xpath = "//a[@title='View']")
	private WebElement viewOrders;

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

	public void moveToAccountIcon() {
		Actions act = new Actions(driver);
		act.moveToElement(accountIcon).build().perform();
	}

	public void myOrders() {
		this.myOrders.click();
	}

	public void viewOrders() {
		this.viewOrders.click();
	}

	/*public boolean orderInformationPage() {
		String expectedTitle = "Order Information";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println(driver.getTitle());
			flag = true;
		}

		return flag;

	}*/

}
