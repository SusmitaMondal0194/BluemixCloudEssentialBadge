package com.training.sanity.tests;

//in below test case we are going to test three sets of data as below
//with improper mail id:: RTTC063Test("manzoor", "mehadi", "manzoor", "8906543210", "electronic city", "bangalore", "bangalore", "560100", "India", "Karnataka", "manzoor", "manzoor")
//with Improper confirm password :: RTTC063Test("priya", "prabhu", "priya@gmail.com", "8906754321", "hyderabad", "hyderabad", "hyderabad", "9876547", "India", "Telangana", "priya", "priya1") 
//all correct data:: RTTC063Test("priya", "prabhu", "priya15@gmail.com", "8906754321", "hyderabad", "hyderabad", "hyderabad", "9876547", "India", "Telangana", "priya", "priya")


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
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

public class RTTC_063_Test {

	private WebDriver driver;
	private String baseUrl;
	private Registration_POM registration_POM;
	private static Properties properties;
	private String actualMsg;
	private String color;
	private String hex;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
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

	@Test(dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	public void RTTC063Test(String FirstName, String LastName, String EMail, String Telephone, String Address1,
			String Address2, String City, String PostalCode, String Country, String Region, String Password,
			String PasswordConfirm) {

		// clicking on Account Icon
		registration_POM.clickLoginReg();

		// clicking on Register
		registration_POM.clickRegister();

		// Entering firstName
		registration_POM.firstName(FirstName);

		// Enetring Last Name
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

		// Assertion part
		String actualMsg = registration_POM.welcomeMsg();
		// System.out.println(actualMsg);

		// Below code is for successful registration checking
		if (actualMsg.startsWith("Congratulations")) {
			actualMsg = registration_POM.welcomeMsg();
			// System.out.println(actualMsg);
			Assert.assertEquals(actualMsg, "Congratulations! Your new account has been successfully created!");

		}

		else {
			// Below code is checking for Invalid email inputs which cause a background
			// color change
			color = driver.findElement(By.xpath("//*[@id='input-email']")).getCssValue("color");
			// System.out.println(color);
			hex = Color.fromString(color).asHex();
			// System.out.println(hex);

			// Assertion process for wrong email, if email is in proper format it will go to
			// next part of codes for confirm password section
			if (hex.equals("#333333")) {
				Assert.assertEquals(hex, "#333333");

			}

			else {
				// Below code is checking for mismatched confirm password inputs which cause a
				// background color change that is other than #000000

				color = driver.findElement(By.xpath("//*[@id='input-confirm']")).getCssValue("color");
				// System.out.println(color);
				hex = Color.fromString(color).asHex();
				// System.out.println(hex);
				String normalHex = "#000000";
				Assert.assertNotEquals(hex, normalHex);
				// Assert.assertEquals(hex, "#621e07");

			}
		}
		screenShot.captureScreenShot("Sixty Three");
	}
}
