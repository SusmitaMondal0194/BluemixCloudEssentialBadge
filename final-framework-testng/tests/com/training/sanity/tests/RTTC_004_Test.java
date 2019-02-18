package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_004_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_004_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_004_POM rTTC_004_POM;
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
		rTTC_004_POM = new RTTC_004_POM(driver);
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
	public void rTTC_004_Test() {
		rTTC_004_POM.clickAccountIcon();
		rTTC_004_POM.emailAddress("susmita@gmail.com");
		rTTC_004_POM.password("12345");
		rTTC_004_POM.clickLoginBtn();
		rTTC_004_POM.moveToAccountIcon();
		rTTC_004_POM.myOrders();
		rTTC_004_POM.viewOrders();
		String actualTitle = driver.getTitle();
		// System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Order Information");
		screenShot.captureScreenShot("Fourth");
	}

}
