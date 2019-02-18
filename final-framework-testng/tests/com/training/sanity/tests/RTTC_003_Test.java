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
import com.training.pom.RTTC_003_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_003_Test{

	private WebDriver driver;
	private String baseUrl;
	private RTTC_003_POM rTTC_003_POM;
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
		rTTC_003_POM = new RTTC_003_POM(driver);
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
	public void rTTC_003_Test() {
		rTTC_003_POM.clickAccountIcon();
		rTTC_003_POM.emailAddress("susmita@gmail.com");
		rTTC_003_POM.password("87656");
		rTTC_003_POM.clickLoginBtn();
		rTTC_003_POM.forgottenPassword();
		rTTC_003_POM.recoverPassword("susmita@gmail.com");
		rTTC_003_POM.continueRecovery();
		String actualMsg = rTTC_003_POM.recoveryMsg();
		// System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "An email with a confirmation link has been sent your email address.");
		screenShot.captureScreenShot("Third");

	}

}
