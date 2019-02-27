package com.training.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration_POM{

	private WebDriver driver;

	public Registration_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Searching for the element Account Icon
	@FindBy(xpath = "//*[@class='fa fa-user-o']")
	private WebElement clickAccountIcon;

	//Searching for the element Register Link
	@FindBy(xpath = "//*[@class='btn btn-primary']")
	private WebElement registerLink;

	//Searching for the element FirstName
	@FindBy(id = "input-firstname")
	private WebElement firstName;

	//Searching for the element LastName
	@FindBy(id = "input-lastname")
	private WebElement lastName;

	//Searching for the element Email ID
	@FindBy(id = "input-email")
	private WebElement email;

	//Searching for the element Telephone Number
	@FindBy(id = "input-telephone")
	private WebElement telephone;

	//Searching for the element Address1
	@FindBy(id = "input-address-1")
	private WebElement address1;

	//Searching for the element Address2
	@FindBy(id = "input-address-2")
	private WebElement address2;

	//Searching for the element city
	@FindBy(id = "input-city")
	private WebElement city;

	//Searching for the element Postal Code
	@FindBy(id = "input-postcode")
	private WebElement postCode;

	//Searching for the element Country
	@FindBy(id = "input-country")
	private WebElement country;

	//Searching for the element State
	@FindBy(id = "input-zone")
	private WebElement state;

	//Searching for the element Password
	@FindBy(id = "input-password")
	private WebElement password;

	//Searching for the element Confirm Password
	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;
	
	//Searching for the element Subscribe Button
	@FindBy(xpath = "//*[@value='0']")
	private WebElement subscribeBtn;
	
	//Searching for the element Privacy policy check box
	@FindBy(xpath = "//*[@name='agree']")
	private WebElement policyCheckBox;
	
	//Searching for the element Continue Button
	@FindBy(xpath = "//*[@value='Continue']")
	private WebElement continueBtn;
	
	//Checking for Assertion message
	@FindBy(xpath = "//*[@class='tb_text_wrap tb_sep']/p")
	private WebElement welcomeMsg;
	
	//Clicking on Account button
	public void clickAccountIcon() {
		this.clickAccountIcon.click();
	}

	//Clicking on Register Link
	public void clickRegister() {
		this.registerLink.click();
	}
	
	//Providing firstname
	public void firstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
		
	//Providing lastname
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
		//this.country.clear();
		Select s= new Select(this.country);
		s.selectByVisibleText(country);
	}
	
	//Providing State
	public void state(String state) {
		//this.state.clear();
		Select s= new Select(this.state);
		s.selectByVisibleText(state);
	}
	
	//Providing Password
	public void password(String password) {
		this.password.clear();
		this.password.sendKeys(password);
		}
	
	//Providing Confirm Password
	public void confirmPassword(String confirmPassword) {
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword);
		}
	
	//Providing Subscribe Button
	public void subscribeBtn() {
		this.subscribeBtn.click();
		}
	
	//Providing Privacy policy check box
	public void policyCheckBox() {
		this.policyCheckBox.click();
		}
	
	//Clicking on continue button
	public void continueBtn() {
		this.continueBtn.click();
		}
	
	//Returning Assertion message
	public String welcomeMsg() {
		return this.welcomeMsg.getText();	
		
	}

}
