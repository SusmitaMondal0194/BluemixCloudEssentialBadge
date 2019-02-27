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
import com.training.pom.RTTC_035_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_035_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_035_POM rTTC_035_POM;
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
		rTTC_035_POM = new RTTC_035_POM(driver);
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
	public void rTTC_035_Test() throws InterruptedException {

		// Providing user name
		rTTC_035_POM.userName("admin");

		// Providing password
		rTTC_035_POM.password("admin@123");

		// Clicking on Login button
		rTTC_035_POM.clickLoginBtn();

		// Clicking on Catalog
		rTTC_035_POM.catalog();

		// Clicking on Product list
		rTTC_035_POM.productList();

		// Clicking on Add symbol
		rTTC_035_POM.addProduct();

		// Providing product name
		rTTC_035_POM.productName("Samsung");

		// Providing metaTagTitle
		rTTC_035_POM.metaTagTitle("Samsung Phone");

		// Clicking on data tab
		rTTC_035_POM.dataTab();

		// Providing model no
		rTTC_035_POM.model("SKU-012");

		// Providing price
		rTTC_035_POM.price("15000");

		// Providing Quantity
		rTTC_035_POM.quantity("50");

		// Clicking on links tab
		rTTC_035_POM.linksTab();

		// clicking on categories
		rTTC_035_POM.clickCategories();

		// Selecting values from categories
		rTTC_035_POM.selectCategories();

		// Clicking on discount tab
		rTTC_035_POM.discountTab();

		// Clicking on add symbol
		rTTC_035_POM.addDiscount();

		// Providing Quantity
		rTTC_035_POM.disQuantity("1");

		// Providing price
		rTTC_035_POM.disPrice("500");

		// Choosing Start date
		rTTC_035_POM.startDate();

		// Choosing end date from system date
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 1);
		String newDate = dateFormat.format(cal.getTime());
		rTTC_035_POM.endDate(newDate);

		// Clicking on Reward tab
		rTTC_035_POM.rewardTab();

		// Providing points
		rTTC_035_POM.points("20");

		// Clicking on Save
		rTTC_035_POM.saveBtn();

		// Assertion process
		String actualMsg = rTTC_035_POM.actualMsg();
		// System.out.println(actualMsg);
		String expectedMsg = "Success: You have modified products!";
		// Assert.assertEquals(actualMsg, " Success: You have modified
		// products!"+"\nx");
		Assert.assertTrue(actualMsg.contains(expectedMsg));
		screenShot.captureScreenShot("ThirtyFive");
	}

}
