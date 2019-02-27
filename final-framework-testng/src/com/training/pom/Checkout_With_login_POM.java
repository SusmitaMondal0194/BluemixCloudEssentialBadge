package com.training.pom;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_With_login_POM {

	private WebDriver driver;

	public Checkout_With_login_POM(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

	/*
	@FindBy(xpath = "//li[@id='menu_all_categories_Menu_VIfWm2LT_Ytne9']/a/span")
	private WebElement moveToShopNow;

	@FindBy(linkText = "Ethnic")
	private WebElement clickEthnic;
	*/

	//Inspecting Integer Vitae Iaculis Massa product
	@FindBy(xpath = "//a[@href='http://retail.upskills.in/ethnic/integer-vitae-iaculis-massa']")
	private WebElement clickItem;

	/*
	@FindBy(xpath = "//*[@id='button-cart']")
	private WebElement clickAddToCart;

	@FindBy(xpath = "//*[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement moveToCart;

	@FindBy(xpath = "//div[@class='dropdown-menu']/div/div[3]/a[1]")
	private WebElement clickViewCart;

	@FindBy(xpath = "//div[@class='pull-right']/a")
	private WebElement clickCheckOut;
	*/
	

	// Inspecting continue
	@FindBy(xpath = "//*[@id='button-payment-address']")
	private WebElement continueBilling;
	
	// Inspecting continue
	@FindBy(xpath = "//*[@id='button-shipping-address']")
	private WebElement continueDeliveryDetails;
	
	// Inspecting continue
	@FindBy(xpath = "//*[@id='button-shipping-method']")
	private WebElement continueDeliveryMethod;
	
	// Inspecting Comment box
	@FindBy(xpath = "//*[@class='panel-body']/p[3]/textarea[@name='comment']")
	private WebElement addComment;
	
	// Inspecting the check box
	@FindBy(xpath = "//*[@name='agree']")
	private WebElement checkTNC;
	
	// Inspecting continue
	@FindBy(xpath = "//*[@id='button-payment-method']")
	private WebElement continueCOD;
	
	// Inspecting Confirm order button
	@FindBy(xpath = "//*[@id='button-confirm']")
	private WebElement confirmBtn;
	
	// Inspecting Assertion Message
	@FindBy(xpath = "//div[@id='System_gqgg2zel']/div/p")
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
	
	/*
	public void moveToShopNow() {
		Actions act = new Actions(driver);
		act.moveToElement(moveToShopNow).build().perform();
	}

	public void clickEthnic(){
		this.clickEthnic.click();
	}
	*/

	//Clicking on Integer Vitae Iaculis Massa product
	public void clickItem() {
		this.clickItem.click();
	}

	
	/*
	public void clickAddToCart() {
		this.clickAddToCart.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void moveToCart() {
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
	
	//Clicking on Continue
	public void continueBilling() {
		this.continueBilling.click();
	}
	
	//Clicking on Continue
	public void continueDeliveryDetails() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.continueDeliveryDetails.click();
	}
	
	//Clicking on Continue
	public void continueDeliveryMethod() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.continueDeliveryMethod.click();
	}
	
	//Adding comment
	public void addComment(String addComment) {
		this.addComment.sendKeys(addComment);
	}
		
	//Clicking on check box
	public void checkTNC() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.checkTNC.click();
	}
	
	//Clicking on Continue
	public void continueCOD() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.continueCOD.click();
	}
	
	//Clicking on Confirm order
	public void confirmBtn() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.confirmBtn.click();
	}
	
	//Returning Assertion message
	public String actualMsg() {
		return this.actualMsg.getText();
	}

	
}
