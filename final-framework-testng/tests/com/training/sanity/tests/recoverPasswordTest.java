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
import com.training.pom.RecoverPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class recoverPasswordTest {

	private WebDriver driver;
	private String baseUrl;
	private RecoverPasswordPOM recoverPasswordPOM;
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
		recoverPasswordPOM = new RecoverPasswordPOM(driver);
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
	public void RecoverPasswordTest() {
		recoverPasswordPOM.clickAccountIcon();
		recoverPasswordPOM.emailAddress("susmita@gmail.com");
		recoverPasswordPOM.password("87656");
		recoverPasswordPOM.clickLoginBtn();
		recoverPasswordPOM.forgottenPassword();
		recoverPasswordPOM.recoverPassword("susmita@gmail.com");
		recoverPasswordPOM.continueRecovery();
		String actualMsg = recoverPasswordPOM.recoveryMsg();
		// System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "An email with a confirmation link has been sent your email address.");
		screenShot.captureScreenShot("Third");

	}

}
