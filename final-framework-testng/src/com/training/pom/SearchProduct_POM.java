package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct_POM {

	private WebDriver driver;

	public SearchProduct_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Inspecting Ethnic
	@FindBy(linkText = "Electronics Goods")
	private WebElement clickElectronicsGoods;

	// Searching for the element Account Icon
	@FindBy(id = "search_button")
	private WebElement moveToSearch;

	@FindBy(id = "mfilter-opts-search")
	private WebElement clickSearchBtn;

	@FindBy(xpath = "//div[@class='mfilter-selected-filters-cnt']/a/span")
	private WebElement actualMsg;

	// Clicking on Ethnic
	public void clickElectronicsGoods() {
		this.clickElectronicsGoods.click();
	}

	//Searching products
	public void clickSearchBtn(String clickSearchBtn) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.clickSearchBtn.sendKeys(clickSearchBtn);
		this.clickSearchBtn.sendKeys(Keys.ENTER);
	}

	// Returning Assertion message
	public String actualMsg() {
		return this.actualMsg.getText();

	}

}