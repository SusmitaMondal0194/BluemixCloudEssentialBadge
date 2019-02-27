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
import com.training.pom.Login_POM;
import com.training.pom.Registration_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_002_Test {

	private WebDriver driver;
	private String baseUrl;
	private Login_POM login_POM;
	private Registration_POM registration_POM;
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
		registration_POM = new Registration_POM(driver);
		login_POM = new Login_POM(driver);
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
		
		//clicking on Account Icon
		registration_POM.clickAccountIcon();
		
		//Getting the Email ID
		login_POM.emailAddress("susmita@gmail.com");
		
		//Providing Password
		login_POM.password("12345");
		
		//Clicking on Login Button
		login_POM.clickLoginBtn();
		
		//Below codes are for Assertion process
		String actualTitle = driver.getTitle();
		//System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "My Account");
		screenShot.captureScreenShot("Second");
	}

}
