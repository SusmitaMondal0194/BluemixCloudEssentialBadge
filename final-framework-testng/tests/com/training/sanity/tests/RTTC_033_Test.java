package com.training.sanity.tests;

//Below testcase is to verify whether application allows user to place an order with Pre Logging in

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Checkout_WO_login_POM1;
import com.training.pom.Checkout_With_login_POM;
import com.training.pom.Login_POM;
import com.training.pom.Registration_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_033_Test {

	private WebDriver driver;
	private String baseUrl;
	private Registration_POM registration_POM;
	private Login_POM login_POM;
	private Checkout_WO_login_POM1 checkout_WO_login_POM1;
	private Checkout_With_login_POM checkout_With_login_POM;
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
		checkout_WO_login_POM1 = new Checkout_WO_login_POM1(driver);
		checkout_With_login_POM = new Checkout_With_login_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();
	}

	@Test
	public void rTTC_033_Test() throws InterruptedException {
		// clicking on Account Icon
		registration_POM.clickAccountIcon();

		// Getting the Email ID
		login_POM.emailAddress("susmita@gmail.com");

		// Providing Password
		login_POM.password("12345");

		// Clicking on Login Button
		login_POM.clickLoginBtn();

		// Moving to Shop now
		checkout_WO_login_POM1.moveToShopNow();

		// Clicking on Ethnic
		checkout_WO_login_POM1.clickEthnic();

		checkout_With_login_POM.clickItem();

		// Switching to new window
		for (String newWindow : driver.getWindowHandles()) {
			driver.switchTo().window(newWindow);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			Thread.sleep(5000);
		}

		// Clicking on add to cart
		checkout_WO_login_POM1.clickAddToCart();

		// Moving to cart icon
		checkout_WO_login_POM1.moveToCart();

		// Clicking on view cart
		checkout_WO_login_POM1.clickViewCart();

		// Clicking on checkout
		checkout_WO_login_POM1.clickCheckOut();

		//Clicking on Continue
		checkout_With_login_POM.continueBilling();
		
		//Clicking on Continue
		checkout_With_login_POM.continueDeliveryDetails();
		
		//Clicking on Continue
		checkout_With_login_POM.continueDeliveryMethod();
		
		//Adding comment
		checkout_With_login_POM.addComment("This product is nice");
		
		//Clicking on check box
		checkout_With_login_POM.checkTNC();
		
		//Clicking on Continue
		checkout_With_login_POM.continueCOD();
		
		//Clicking on Confirm order
		checkout_With_login_POM.confirmBtn();
		
		//Assertion process
		String actualMsg = checkout_With_login_POM.actualMsg();
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "Your order has been successfully processed!");
		screenShot.captureScreenShot("Thirtythree");
	}

}
