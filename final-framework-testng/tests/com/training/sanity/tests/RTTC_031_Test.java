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
import com.training.pom.Invalid_Login_POM;
import com.training.pom.Login_POM;
import com.training.pom.Registration_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//TestCase is verifying whether application denies user getting logged in upon entering invalid credentials in required field

public class RTTC_031_Test {

	private WebDriver driver;
	private String baseUrl;
	private Registration_POM registration_POM;
	private Login_POM login_POM;
	private Invalid_Login_POM invalid_Login_POM;
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
		invalid_Login_POM = new Invalid_Login_POM(driver);
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
	public void rTTC_031_Test() {
		
		//Clicking on Account Icon
		registration_POM.clickAccountIcon();
		
		// providing invalid email ID
		login_POM.emailAddress("abcdef@gmail.com"); 
		
		// providing invalid password
		login_POM.password("54321");
		
		//Clicking on Login Button
		login_POM.clickLoginBtn();
		
		//Assertion process
		String actualMsg = invalid_Login_POM.actualMsg();
		// System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "Warning: No match for E-Mail Address and/or Password.");
		screenShot.captureScreenShot("ThirtyOne");
	}

}
