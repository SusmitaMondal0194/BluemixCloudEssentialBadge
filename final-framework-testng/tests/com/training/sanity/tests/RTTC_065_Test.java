package com.training.sanity.tests;

//Below test case is to verify whether added product details get displayed in home screen

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Admin_RewardPt_POM;
import com.training.pom.Checkout_WO_login_POM1;
import com.training.pom.SearchProduct_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_065_Test {

	private WebDriver driver;
	private String baseUrl;
	private Admin_RewardPt_POM admin_RewardPt_POM;
	private Checkout_WO_login_POM1 checkout_WO_login_POM1;
	private SearchProduct_POM searchProduct_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		admin_RewardPt_POM = new Admin_RewardPt_POM(driver);
		checkout_WO_login_POM1 = new Checkout_WO_login_POM1(driver);
		searchProduct_POM = new SearchProduct_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	

	@Test
	public void rTTC_065_Test() throws InterruptedException {

		// Providing user name
		admin_RewardPt_POM.userName("admin");

		// Providing password
		admin_RewardPt_POM.password("admin@123");

		// Clicking on Login button
		admin_RewardPt_POM.clickLoginBtn();

		// Clicking on Catalog
		admin_RewardPt_POM.catalog();

		// Clicking on Product list
		admin_RewardPt_POM.productList();

		// Clicking on Add symbol
		admin_RewardPt_POM.addProduct();

		// Providing product name
		admin_RewardPt_POM.productName("LED TV");

		// Providing metaTagTitle
		admin_RewardPt_POM.metaTagTitle("Sony LED TVs");

		// Clicking on data tab
		admin_RewardPt_POM.dataTab();

		// Providing model no
		admin_RewardPt_POM.model("SKU-012");

		// Providing price
		admin_RewardPt_POM.price("40000");

		// Providing Quantity
		admin_RewardPt_POM.quantity("20");

		// Clicking on links tab
		admin_RewardPt_POM.linksTab();

		// clicking on categories and typing the Keyword Electronics of Electronics Goods
		admin_RewardPt_POM.clickCategories("Electronics G");

		// Selecting values from categories
		admin_RewardPt_POM.selectCategories();

		// Clicking on Save
		admin_RewardPt_POM.saveBtn();

		// Clicking on Save
		admin_RewardPt_POM.logoutBtn();

		// Navigating to user home page
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("http://retail.upskills.in/");

		// Moving to Shop now
		checkout_WO_login_POM1.moveToShopNow();

		// Clicking on Ethnic
		searchProduct_POM.clickElectronicsGoods();

		// Searching products
		searchProduct_POM.clickSearchBtn("LED TV");

		// Assertion process
		String actualMsg = searchProduct_POM.actualMsg();
		String expectedMsg = "Search: LED TV";
		System.out.println(actualMsg);
		Assert.assertTrue(actualMsg.contains(expectedMsg));
		screenShot.captureScreenShot("SixtyFive");
		
		
	}

}
