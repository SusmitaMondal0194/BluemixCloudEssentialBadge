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
import com.training.pom.EditAccountInfoPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditAccountInfoTest {

	private WebDriver driver;
	private String baseUrl;
	private EditAccountInfoPOM editAccountInfoPOM;
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
		editAccountInfoPOM = new EditAccountInfoPOM(driver);
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
	public void editAccountInfoTest() {
		editAccountInfoPOM.clickAccountIcon();
		editAccountInfoPOM.emailAddress("susmita2@gmail.com");
		editAccountInfoPOM.password("12345");
		editAccountInfoPOM.clickLoginBtn();
		editAccountInfoPOM.editAccountInfo();
		editAccountInfoPOM.fname("Susmita1");
		editAccountInfoPOM.lname("Mondal1");
		editAccountInfoPOM.email("susmita@gmail.com");
		editAccountInfoPOM.telephone("9904505451");
		editAccountInfoPOM.clickContinue();
		String actualMsg=editAccountInfoPOM.confirmationMsg();
		//System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "Success: Your account has been successfully updated.");
		screenShot.captureScreenShot("Fifth");

	}

}
