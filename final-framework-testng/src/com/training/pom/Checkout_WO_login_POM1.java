package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout_WO_login_POM1 {

	private WebDriver driver;

	public Checkout_WO_login_POM1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	//Inspecting Shop Now
	@FindBy(xpath = "//li[@id='menu_all_categories_Menu_VIfWm2LT_Ytne9']/a/span")
	private WebElement moveToShopNow;

	//Inspecting Ethnic
	@FindBy(linkText = "Ethnic")
	private WebElement clickEthnic;

	//Inspecting Integer vitae iaculis massa
	@FindBy(xpath = "//*[@alt='Integer vitae iaculis massa']")
	private WebElement clickItem;

	//Inspecting Add to cart
	@FindBy(xpath = "//*[@id='button-cart']")
	private WebElement clickAddToCart;

	//Inspecting cart icon
	@FindBy(xpath = "//*[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement moveToCart;

	//Inspecting view cart
	@FindBy(xpath = "//div[@class='dropdown-menu']/div/div[3]/a[1]")
	private WebElement clickViewCart;

	//Inspecting check out
	@FindBy(xpath = "//div[@class='pull-right']/a")
	private WebElement clickCheckOut;

	//Inspecting Assertion Message
	@FindBy(id = "button-login")
	private WebElement actualMsg;

	//Moving to Shop now
	public void moveToShopNow() {
		Actions act = new Actions(driver);
		act.moveToElement(moveToShopNow).build().perform();
	}

	//Clicking on Ethnic
	public void clickEthnic() {
		this.clickEthnic.click();
	}

	//Clicking on Integer Vitae Iaculis Massa product
	public void clickItem() {
		this.clickItem.click();
	}

	//Clicking on add to cart
	public void clickAddToCart() throws InterruptedException {
		this.clickAddToCart.click();
	
	}

	//Moving to cart icon
	public void moveToCart() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		act.moveToElement(moveToCart).build().perform();
	}

	//Clicking on view cart
	public void clickViewCart() {
		this.clickViewCart.click();
	}

	//Clicking on checkout
	public void clickCheckOut() {
		this.clickCheckOut.click();
	}

	//Returning Assertion message
	public String actualMsg() {
		return this.actualMsg.getAttribute("value");
	}
}
