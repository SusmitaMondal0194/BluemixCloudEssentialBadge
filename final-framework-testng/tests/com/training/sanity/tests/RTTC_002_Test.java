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
import com.training.pom.RTTC_002_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_002_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_002_POM rTTC_002_POM;
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
		rTTC_002_POM = new RTTC_002_POM(driver);
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
	public void rTTC_002_Test() {
		rTTC_002_POM.clickAccountIcon();
		rTTC_002_POM.emailAddress("susmita@gmail.com");
		rTTC_002_POM.password("12345");
		rTTC_002_POM.clickLoginBtn();
		String actualTitle = driver.getTitle();
		//System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "My Account");
		screenShot.captureScreenShot("Second");
	}

}
