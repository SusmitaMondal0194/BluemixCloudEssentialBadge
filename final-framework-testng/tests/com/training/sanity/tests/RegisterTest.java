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
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterTest {

	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
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
		registerPOM = new RegisterPOM(driver);
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
	public void ValidRegisterTest() {
		registerPOM.clickAccountIcon();
		registerPOM.clickRegister();
		registerPOM.firstName("Susmita");
		registerPOM.lastName("Mondal");
		registerPOM.email("susmita002@gmail.com");
		registerPOM.telephone("9854451235");
		registerPOM.address1("GARDEN REACH");
		registerPOM.address2("KOLKATA");
		registerPOM.city("KOLKATA");
		registerPOM.postCode("777765");
		registerPOM.country("India");
		registerPOM.state("West Bengal");
		registerPOM.password("12345");
		registerPOM.confirmPassword("12345");
		registerPOM.subscribeBtn();
		registerPOM.policyCheckBox();
		registerPOM.continueBtn();
		String actualMsg = registerPOM.welcomeMsg();
		// System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "Congratulations! Your new account has been successfully created!");
		screenShot.captureScreenShot("First");
	}

}
