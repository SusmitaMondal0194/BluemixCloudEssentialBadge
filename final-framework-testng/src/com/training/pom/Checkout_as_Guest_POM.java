package com.training.pom;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Checkout_as_Guest_POM {
	private WebDriver driver;

	public Checkout_as_Guest_POM(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}

	/*
	@FindBy(xpath = "//li[@id='menu_all_categories_Menu_VIfWm2LT_Ytne9']/a/span")
	private WebElement moveToShopNow;

	@FindBy(linkText = "Ethnic")
	private WebElement clickEthnic;

	@FindBy(xpath = "//*[@alt='Integer vitae iaculis massa']")
	private WebElement clickItem;

	@FindBy(xpath = "//*[@id='button-cart']")
	private WebElement clickAddToCart;

	@FindBy(xpath = "//*[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement moveToCart;

	@FindBy(xpath = "//div[@class='dropdown-menu']/div/div[3]/a[1]")
	private WebElement clickViewCart;

	@FindBy(xpath = "//div[@class='pull-right']/a")
	private WebElement clickCheckOut;
	*/
	
	//Inspecting Guest radio button
	@FindBy(xpath = "//input[@value='guest']")
	private WebElement clickGuest;

	//Inspecting continue
	@FindBy(xpath = "//*[@id='button-account']")
	private WebElement continueAsGuest;
	
	//Inspecting FirstName
	@FindBy(id = "input-payment-firstname")
	private WebElement firstName;

	//Inspecting LastName
	@FindBy(id = "input-payment-lastname")
	private WebElement lastName;

	//Inspecting Email
	@FindBy(id = "input-payment-email")
	private WebElement email;

	//Inspecting Telephone
	@FindBy(id = "input-payment-telephone")
	private WebElement telephone;
	
	//Inspecting Address1
	@FindBy(id = "input-payment-address-1")
	private WebElement address1;

	//Inspecting Address2
	@FindBy(id = "input-payment-address-2")
	private WebElement address2;

	//Inspecting City
	@FindBy(id = "input-payment-city")
	private WebElement city;

	//Inspecting Postal code
	@FindBy(id = "input-payment-postcode")
	private WebElement postCode;

	//Inspecting Country
	@FindBy(id = "input-payment-country")
	private WebElement country;

	//Inspecting State
	@FindBy(id = "input-payment-zone")
	private WebElement state;
	
	//Inspecting My delivery and billing addresses are the same checkbox
	@FindBy(xpath = "//input[@name='shipping_address']")
	private WebElement addressCheck;
	
	//Inspecting continue
	@FindBy(xpath = "//*[@id='button-guest']")
	private WebElement continueToShipping;
		
	/*
	@FindBy(xpath = "//*[@id='button-shipping-method']")
	private WebElement continueDeliveryMethod;
	
	@FindBy(xpath = "//*[@class='panel-body']/p[3]/textarea[@name='comment']")
	private WebElement addComment;
	
	@FindBy(xpath = "//*[@name='agree']")
	private WebElement checkTNC;
	
	@FindBy(xpath = "//*[@id='button-payment-method']")
	private WebElement continueCOD;
	
	@FindBy(xpath = "//*[@id='button-confirm']")
	private WebElement confirmBtn;
	*/
	
	//Assertion message
	@FindBy(xpath = "//div[@class='tb_text_wrap tb_sep']/p")
	private WebElement actualMsg;

	/*
	public void moveToShopNow() {
		Actions act = new Actions(driver);
		act.moveToElement(moveToShopNow).build().perform();
	}

	public void clickEthnic() {
		this.clickEthnic.click();
	}

	public void clickItem() {
		this.clickItem.click();
	}

	public void clickAddToCart() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.clickAddToCart.click();
		//Thread.sleep(5000);
	}

	public void moveToCart() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(moveToCart).build().perform();
	}

	public void clickViewCart() {
		this.clickViewCart.click();
	}

	public void clickCheckOut() {
		this.clickCheckOut.click();
	}
	*/
	
	//Clicking on guest
	public void clickGuest() {
		this.clickGuest.click();
	}
	
	//Clicking on continue
	public void continueAsGuest(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.continueAsGuest.click();
	}
	
	//Providing First Name
	public void firstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
		
	//Providing last name
	public void lastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	
	//Providing Email
	public void email(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	//Providing Telephone
	public void telephone(String telephone) {
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}
	
	//Providing Address1
	public void address1(String address1) {
		this.address1.clear();
		this.address1.sendKeys(address1);
	}
	
	//Providing Address2
	public void address2(String address2) {
		this.address2.clear();
		this.address2.sendKeys(address2);
	}
	
	//Providing city
	public void city(String city) {
		this.city.clear();
		this.city.sendKeys(city);
		}
	
	//Providing Postal code
	public void postCode(String postCode) {
		this.postCode.clear();
		this.postCode.sendKeys(postCode);
		}
	
	//Providing country
	public void country(String country) {
		Select s= new Select(this.country);
		s.selectByVisibleText(country);
	}
	
	//Providing State
	public void state(String state) {
		Select s= new Select(this.state);
		s.selectByVisibleText(state);
	}
	
	//checking My delivery and billing addresses are the same or not
	public void addressCheck() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		this.addressCheck.click();
	}
	
	//Clicking on continue
	public void continueToShipping() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		this.continueToShipping.click();
	}
	
	/*
	public void continueDeliveryMethod() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.continueDeliveryMethod.click();
	}
	
	public void addComment(String addComment) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		//this.addComment.click();
		this.addComment.sendKeys(addComment);
		System.out.println(addComment);
		
	}
		
	public void checkTNC() throws InterruptedException{
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		this.checkTNC.click();
	}
	
	public void continueCOD() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		this.continueCOD.click();
	}
	
	public void confirmBtn() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		this.confirmBtn.click();
	}
	*/
	
	//Returning Assertion message
	public String actualMsg() {
		return this.actualMsg.getText();
	}

}
