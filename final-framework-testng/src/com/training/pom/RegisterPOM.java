package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPOM {

	private WebDriver driver;
	public static boolean flag=false;

	public RegisterPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='fa fa-user-o']")
	private WebElement accountIcon;

	@FindBy(xpath = "//*[@class='btn btn-primary']")
	private WebElement registerLink;

	@FindBy(id = "input-firstname")
	private WebElement firstName;

	@FindBy(id = "input-lastname")
	private WebElement lastName;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-telephone")
	private WebElement telephone;

	@FindBy(id = "input-address-1")
	private WebElement address1;

	@FindBy(id = "input-address-2")
	private WebElement address2;

	@FindBy(id = "input-city")
	private WebElement city;

	@FindBy(id = "input-postcode")
	private WebElement postCode;

	@FindBy(id = "input-country")
	private WebElement country;

	@FindBy(id = "input-zone")
	private WebElement state;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@value='0']")
	private WebElement subscribeBtn;
	
	@FindBy(xpath = "//*[@name='agree']")
	private WebElement policyCheckBox;
	
	@FindBy(xpath = "//*[@value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//*[@class='tb_text_wrap tb_sep']/p")
	private WebElement welcomeMsg;
	

	public void clickAccountIcon() {
		this.accountIcon.click();
	}

	public void clickRegister() {
		this.registerLink.click();
	}
	
	public void firstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
		
	public void lastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	
	public void email(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public void telephone(String telephone) {
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}
	
	public void address1(String address1) {
		this.address1.clear();
		this.address1.sendKeys(address1);
	}
	
	public void address2(String address2) {
		this.address2.clear();
		this.address2.sendKeys(address2);
	}
	
	public void city(String city) {
		this.city.clear();
		this.city.sendKeys(city);
		}
	
	public void postCode(String postCode) {
		this.postCode.clear();
		this.postCode.sendKeys(postCode);
		}
	
	public void country(String country) {
		//this.country.clear();
		Select s= new Select(this.country);
		s.selectByVisibleText(country);
	}
	
	public void state(String state) {
		//this.state.clear();
		Select s= new Select(this.state);
		s.selectByVisibleText(state);
	}
	
	public void password(String password) {
		this.password.clear();
		this.password.sendKeys(password);
		}
	
	public void confirmPassword(String confirmPassword) {
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword);
		}
	
	public void subscribeBtn() {
		this.subscribeBtn.click();
		}
	
	public void policyCheckBox() {
		this.policyCheckBox.click();
		}
	
	public void continueBtn() {
		this.continueBtn.click();
		}
	
	public String welcomeMsg() {
		return this.welcomeMsg.getText();	
		
	}

}
