package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_RewardPt_POM {

	private WebDriver driver;

	public Admin_RewardPt_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Inspecting UserName
	@FindBy(id = "input-username")
	private WebElement userName;

	// Inspecting Password
	@FindBy(id = "input-password")
	private WebElement password;

	// Inspecting Login Button
	@FindBy(xpath = "//*[@class='btn btn-primary']")
	private WebElement loginBtn;

	// Inspecting Catalog
	@FindBy(xpath = "//*[@id='menu-catalog']/a[@class='parent']")
	private WebElement catalog;

	// Inspecting Product list
	@FindBy(xpath = "//*[@id='menu-catalog']/ul/li[2]/a")
	private WebElement productList;

	// Inspecting add symbol
	@FindBy(xpath = "//div[@id='content']/div/div/div/a[@class='btn btn-primary']")
	private WebElement addProduct;

	// Inspecting Product name
	@FindBy(id = "input-name1")
	private WebElement productName;

	// Inspecting MetaTagTitle
	@FindBy(id = "input-meta-title1")
	private WebElement metaTagTitle;

	// Inspecting Data tab
	@FindBy(xpath = "//*[@class='nav nav-tabs']/li[2]/a[@href='#tab-data']")
	private WebElement dataTab;

	// Inspecting Model
	@FindBy(id = "input-model")
	private WebElement model;

	// Inspecting price
	@FindBy(id = "input-price")
	private WebElement price;

	// Inspecting Quantity
	@FindBy(id = "input-quantity")
	private WebElement quantity;

	// Inspecting link tab
	@FindBy(xpath = "//*[@class='nav nav-tabs']/li[3]/a[@href='#tab-links']")
	private WebElement linksTab;

	// Inspecting categories
	@FindBy(name = "category")
	private WebElement clickCategories;

	// Inspecting options under categories
	@FindBy(xpath = "//*[@class='col-sm-10']/ul/li[2]")
	private WebElement selectCategories;

	// Inspecting Dsicount tab
	@FindBy(xpath = "//*[@class='nav nav-tabs']/li[7]/a[@href='#tab-discount']")
	private WebElement discountTab;

	// Inspecting add sign
	@FindBy(xpath = "//*[@data-original-title='Add Discount']")
	private WebElement addDiscount;

	// Inspecting quantity
	@FindBy(name = "product_discount[0][quantity]")
	private WebElement disQuantity;

	// Inspecting price
	@FindBy(name = "product_discount[0][quantity]")
	private WebElement disPrice;

	// Inspecting Start date
	@FindBy(xpath = "//tr[@id='discount-row0']/td[5]/div/span/button/i")
	private WebElement startDate;

	// Inspecting end date
	@FindBy(xpath = "//*[@name='product_discount[0][date_end]']")
	private WebElement endDate;

	// Inspecting Reward tab
	@FindBy(xpath = "//a[@href='#tab-reward']")
	private WebElement rewardTab;

	// Inspecting Points
	@FindBy(xpath = "//*[@id='input-points']")
	private WebElement points;

	// Inspecting save icon
	@FindBy(xpath = "//*[@class='pull-right']/button[@type='submit']")
	private WebElement saveBtn;

	// Inspecting assertion message
	@FindBy(xpath = "//*[@class='alert alert-success']")
	private WebElement actualMsg;

	// Providing user name
	public void userName(String userName) {
		this.userName.sendKeys(userName);
	}

	// Providing password
	public void password(String password) {
		this.password.sendKeys(password);
	}

	// Clicking on Login button
	public void clickLoginBtn() {
		this.loginBtn.click();
	}

	// Clicking on Catalog
	public void catalog() {
		this.catalog.click();
	}

	// Clicking on Product list
	public void productList() {
		this.productList.click();
	}

	// Clicking on Add symbol
	public void addProduct() {
		this.addProduct.click();
	}

	// Providing product name
	public void productName(String productName) {
		this.productName.sendKeys(productName);
	}

	// Providing metaTagTitle
	public void metaTagTitle(String metaTagTitle) {
		this.metaTagTitle.sendKeys(metaTagTitle);
	}

	// Clicking on data tab
	public void dataTab() {
		this.dataTab.click();
	}

	// Providing model no
	public void model(String model) {
		this.model.sendKeys(model);
	}

	// Providing price
	public void price(String price) {
		this.price.sendKeys(price);
	}

	// Providing Quantity
	public void quantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}

	// Clicking on links tab
	public void linksTab() throws InterruptedException {
		// Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.linksTab.click();
	}

	// clicking on categories
	public void clickCategories() throws InterruptedException {
		// Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.clickCategories.click();
	}

	// Selecting values from categories
	public void selectCategories() throws InterruptedException {
		// Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.selectCategories.click();
	}

	// Clicking on discount tab
	public void discountTab() throws InterruptedException {
		// Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.discountTab.click();
	}

	// Clicking on add symbol
	public void addDiscount() {
		this.addDiscount.click();
	}

	// Providing Quantity
	public void disQuantity(String disQuantity) {
		this.disQuantity.clear();
		this.disQuantity.sendKeys(disQuantity);
	}

	// Providing price
	public void disPrice(String disPrice) {
		this.disPrice.clear();
		this.disPrice.sendKeys(disPrice);
	}

	// Choosing start date
	public void startDate() {
		this.startDate.click();
	}

	// Choosing end date
	public void endDate(String endDate) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.endDate.click();
		this.endDate.sendKeys(endDate);
	}

	// Clicking on Reward tab
	public void rewardTab() throws InterruptedException {
		// Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.rewardTab.click();

	}

	// Providing points
	public void points(String points) {
		this.points.clear();
		this.points.sendKeys(points);
	}

	// Clicking on Save
	public void saveBtn() {
		this.saveBtn.click();

	}

	// Returning assertion message
	public String actualMsg() {
		return this.actualMsg.getText();
	}
}
