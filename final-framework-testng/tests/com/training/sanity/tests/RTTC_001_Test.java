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
import com.training.pom.RTTC_001_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_001_Test {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_001_POM rTTC_001_POM;
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
		rTTC_001_POM = new RTTC_001_POM(driver);
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
		rTTC_001_POM.clickAccountIcon();
		rTTC_001_POM.clickRegister();
		rTTC_001_POM.firstName("Susmita");
		rTTC_001_POM.lastName("Mondal");
		rTTC_001_POM.email("susmita011@gmail.com");
		rTTC_001_POM.telephone("9854451235");
		rTTC_001_POM.address1("GARDEN REACH");
		rTTC_001_POM.address2("KOLKATA");
		rTTC_001_POM.city("KOLKATA");
		rTTC_001_POM.postCode("777765");
		rTTC_001_POM.country("India");
		rTTC_001_POM.state("West Bengal");
		rTTC_001_POM.password("12345");
		rTTC_001_POM.confirmPassword("12345");
		rTTC_001_POM.subscribeBtn();
		rTTC_001_POM.policyCheckBox();
		rTTC_001_POM.continueBtn();
		String actualMsg = rTTC_001_POM.welcomeMsg();
		// System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "Congratulations! Your new account has been successfully created!");
		screenShot.captureScreenShot("First");
	}

}
