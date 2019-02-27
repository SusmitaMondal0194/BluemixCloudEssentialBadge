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
import com.training.pom.Registration_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_001_Test {

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

	@Test
	public void rTTC_001_Test() {
		
		//clicking on Account Icon
		registration_POM.clickAccountIcon();
		
		//clicking on Register
		registration_POM.clickRegister();
		
		//Entering firstName
		registration_POM.firstName("Susmita");
		
		//Enetring Last Name
		registration_POM.lastName("Mondal");
		
		//Entering Email ID
		registration_POM.email("susmitaa@gmail.com");
		
		//Entering Phone Number
		registration_POM.telephone("9854451235");
		
		//Entering address 1
		registration_POM.address1("GARDEN REACH");
		
		//Entering address 2
		registration_POM.address2("KOLKATA");
		
		////Entering city
		registration_POM.city("KOLKATA");
		
		//Entering Postal code
		registration_POM.postCode("777765");
		
		//Entering Country
		registration_POM.country("India");
		
		//Entering State
		registration_POM.state("West Bengal");
		
		//creating a Password
		registration_POM.password("12345");
		
		//Confirming the entered password
		registration_POM.confirmPassword("12345");
		
		//Clicking on Subscribe Radio Button
		registration_POM.subscribeBtn();
		
		//Clicking on Privacy Policy Check Box
		registration_POM.policyCheckBox();
		
		//Clicking on Continue button
		registration_POM.continueBtn();
		
		//Below codes are for Assertion process
		String actualMsg = registration_POM.welcomeMsg();
		// System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "Congratulations! Your new account has been successfully created!");
		screenShot.captureScreenShot("First");
	}

}
