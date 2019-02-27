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
import com.training.pom.Edit_Account_POM;
import com.training.pom.Login_POM;
import com.training.pom.Registration_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_005_Test {

	private WebDriver driver;
	private String baseUrl;
	private Registration_POM registration_POM;
	private Login_POM login_POM;
	private Edit_Account_POM edit_Account_POM;
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
		edit_Account_POM = new Edit_Account_POM(driver);
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
		// clicking on Account Icon
		registration_POM.clickAccountIcon();

		// Getting the Email ID
		login_POM.emailAddress("susmita@gmail.com");

		// Providing Password
		login_POM.password("12345");

		// Clicking on Login Button
		login_POM.clickLoginBtn();

		//Clicking on Edit Account Info
		edit_Account_POM.editAccountInfo();
		
		//Modify Firstname
		edit_Account_POM.fname("Susmita1");
		
		//Modify Lastname
		edit_Account_POM.lname("Mondal1");
		
		//Modify Email ID
		edit_Account_POM.email("susmita@gmail.com");
		
		//Modify Phone number
		edit_Account_POM.telephone("9904505451");
		
		//Clicking on Continue button
		edit_Account_POM.clickContinue();
		
		//Below codes are for Assertion process
		String actualMsg = edit_Account_POM.confirmationMsg();
		// System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "Success: Your account has been successfully updated.");
		screenShot.captureScreenShot("Fifth");

	}

}
