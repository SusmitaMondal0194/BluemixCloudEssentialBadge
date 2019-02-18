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
//import com.training.pom.EditAccountInfoPOM;
import com.training.pom.RTTC_005_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_005_Test{

	private WebDriver driver;
	private String baseUrl;
	private RTTC_005_POM rTTC_005_POM;
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
		rTTC_005_POM = new RTTC_005_POM(driver);
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
	public void rTTC_005_Test() {
		rTTC_005_POM.clickAccountIcon();
		rTTC_005_POM.emailAddress("susmita@gmail.com");
		rTTC_005_POM.password("12345");
		rTTC_005_POM.clickLoginBtn();
		rTTC_005_POM.editAccountInfo();
		rTTC_005_POM.fname("Susmita1");
		rTTC_005_POM.lname("Mondal1");
		rTTC_005_POM.email("susmita@gmail.com");
		rTTC_005_POM.telephone("9904505451");
		rTTC_005_POM.clickContinue();
		String actualMsg=rTTC_005_POM.confirmationMsg();
		//System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "Success: Your account has been successfully updated.");
		screenShot.captureScreenShot("Fifth");

	}

}
