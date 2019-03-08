package com.training.sanity.tests;

//This test case is to verify whether application allows multiple user to get registered into the application

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.Registration_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_062_Test {

	private WebDriver driver;
	private String baseUrl;
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

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String FirstName, String LastName, String EMail, String Telephone, String Address1,
			String Address2, String City, String PostalCode, String Country, String Region, String Password,
			String PasswordConfirm) {

		// clicking on Account Icon
		registration_POM.clickAccountIcon();

		// clicking on Register
		registration_POM.clickRegister();

		// Entering firstName
		registration_POM.firstName(FirstName);

		// Entering Last Name
		registration_POM.lastName(LastName);

		// Entering Email ID
		registration_POM.email(EMail);

		// Entering Phone Number
		registration_POM.telephone(Telephone);

		// Entering address 1
		registration_POM.address1(Address1);

		// Entering address 2
		registration_POM.address2(Address2);

		// Entering city
		registration_POM.city(City);

		// Entering Postal code
		registration_POM.postCode(PostalCode);

		// Entering Country
		registration_POM.country(Country);

		// Entering State
		registration_POM.state(Region);

		// creating a Password
		registration_POM.password(Password);

		// Confirming the entered password
		registration_POM.confirmPassword(PasswordConfirm);

		// Clicking on Subscribe Radio Button
		registration_POM.subscribeBtn();

		// Clicking on Privacy Policy Check Box
		registration_POM.policyCheckBox();

		// Clicking on Continue button
		registration_POM.continueBtn();

		// Below codes are for Assertion process
		String actualMsg = registration_POM.welcomeMsg();
		//System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "Congratulations! Your new account has been successfully created!");
		screenShot.captureScreenShot("Sixty Two");

	}

}
