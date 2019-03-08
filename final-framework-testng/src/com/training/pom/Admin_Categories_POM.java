package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Categories_POM {

	private WebDriver driver;

	public Admin_Categories_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// tag testcases 64
	
	// Inspecting Categories
	@FindBy(xpath = "//*[@id='menu-catalog']/ul/li[1]/a")
	private WebElement categoryList;

	// Inspecting add symbol
	@FindBy(xpath = "//div[@class='pull-right']/a[@data-original-title='Add New']")
	private WebElement addNew;

	// Inspecting Category name
	@FindBy(id = "input-name1")
	private WebElement categoryName;

	// Inspecting Category Description
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	private WebElement categoryDesc;

	// Inspecting MetaTagTitle
	@FindBy(name = "category_description[1][meta_title]")
	private WebElement metaTagTitle;

	// Inspecting MetaTag Description
	@FindBy(name = "category_description[1][meta_description]")
	private WebElement metaTagDesc;

	// Inspecting save icon
	@FindBy(xpath = "//*[@class='pull-right']/button[@type='submit']")
	private WebElement saveBtn;

	// Inspecting assertion message
	@FindBy(xpath = "//*[@class='alert alert-success']")
	private WebElement actualMsg;

	// Clicking on Product list
	public void categoryList() {
		this.categoryList.click();
	}

	// Clicking on Add symbol
	public void addNew() {
		this.addNew.click();
	}

	// Providing Category name
	public String categoryName(String categoryName) {
		this.categoryName.sendKeys(categoryName);
		return categoryName;
	}

	// Providing Category name
	public String categoryDesc(String categoryDesc) {
		this.categoryDesc.sendKeys(categoryDesc);
		return categoryDesc;
	}

	// Providing metaTagTitle
	public String metaTagTitle(String metaTagTitle) {
		this.metaTagTitle.sendKeys(metaTagTitle);
		return metaTagTitle;
	}

	// Providing metaTag Description
	public String metaTagDesc(String metaTagDesc) {
		this.metaTagDesc.sendKeys(metaTagDesc);
		return metaTagDesc;
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
