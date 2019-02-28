package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Admin_RewardPt_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_035_Test {

	private WebDriver driver;
	private String baseUrl;
	private Admin_RewardPt_POM admin_RewardPt_POM;
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
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}

	@Test
	public void rTTC_035_Test() throws InterruptedException {

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
		admin_RewardPt_POM.productName("Samsung");

		// Providing metaTagTitle
		admin_RewardPt_POM.metaTagTitle("Samsung Phone");

		// Clicking on data tab
		admin_RewardPt_POM.dataTab();

		// Providing model no
		admin_RewardPt_POM.model("SKU-012");

		// Providing price
		admin_RewardPt_POM.price("15000");

		// Providing Quantity
		admin_RewardPt_POM.quantity("50");

		// Clicking on links tab
		admin_RewardPt_POM.linksTab();

		// clicking on categories
		admin_RewardPt_POM.clickCategories();

		// Selecting values from categories
		admin_RewardPt_POM.selectCategories();

		// Clicking on discount tab
		admin_RewardPt_POM.discountTab();

		// Clicking on add symbol
		admin_RewardPt_POM.addDiscount();

		// Providing Quantity
		admin_RewardPt_POM.disQuantity("1");

		// Providing price
		admin_RewardPt_POM.disPrice("500");

		// Choosing Start date
		admin_RewardPt_POM.startDate();

		// Choosing end date from system date
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 1);
		String newDate = dateFormat.format(cal.getTime());
		admin_RewardPt_POM.endDate(newDate);

		// Clicking on Reward tab
		admin_RewardPt_POM.rewardTab();

		// Providing points
		admin_RewardPt_POM.points("20");

		// Clicking on Save
		admin_RewardPt_POM.saveBtn();

		// Assertion process
		String actualMsg = admin_RewardPt_POM.actualMsg();
		// System.out.println(actualMsg);
		String expectedMsg = "Success: You have modified products!";
		// Assert.assertEquals(actualMsg, " Success: You have modified
		// products!"+"\nx");
		Assert.assertTrue(actualMsg.contains(expectedMsg));
		screenShot.captureScreenShot("ThirtyFive");
	}

}
