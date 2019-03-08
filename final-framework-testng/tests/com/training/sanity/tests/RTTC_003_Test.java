package com.training.sanity.tests;

//Below test case is to verify whether application allows the user to recover password

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
import com.training.pom.Recover_PW_POM;
import com.training.pom.Registration_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_003_Test{

	private WebDriver driver;
	private String baseUrl;
	private Registration_POM registration_POM;
	private Login_POM login_POM;
	private Recover_PW_POM recover_PW_POM;
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
		recover_PW_POM = new Recover_PW_POM(driver);
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
		
		//Clicking on Account Icon
		registration_POM.clickAccountIcon();
		
		//Getting the Email ID
		login_POM.emailAddress("susmita@gmail.com");
		
		//Providing Password
		login_POM.password("87656");
		
		//Clicking on Login Button
		login_POM.clickLoginBtn();
		
		//Clicking on forgotten Password link
		recover_PW_POM.forgottenPassword();
		
		//Providing Email ID to recover Password
		recover_PW_POM.recoverPassword("susmita@gmail.com");
		
		//Clicking continue to recovery
		recover_PW_POM.continueRecovery();
		
		//Below codes are for Assertion process
		String actualMsg = recover_PW_POM.recoveryMsg();
		// System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "An email with a confirmation link has been sent your email address.");
		screenShot.captureScreenShot("Third");

	}

}
