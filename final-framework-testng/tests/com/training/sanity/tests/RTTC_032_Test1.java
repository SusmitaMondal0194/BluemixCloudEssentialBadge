package com.training.sanity.tests;

//TestCase is verifying whether application displays Login screen upon checking out the product without Pre Logging in

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Checkout_WO_login_POM1;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_032_Test1 {

	private WebDriver driver;
	private String baseUrl;
	private Checkout_WO_login_POM1 checkout_WO_login_POM1;
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
		checkout_WO_login_POM1 = new Checkout_WO_login_POM1(driver);
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
	public void rTTC_032_Test1() throws InterruptedException {
		
		//Moving to Shop now
		checkout_WO_login_POM1.moveToShopNow();
		
		//Clicking on Ethnic
		checkout_WO_login_POM1.clickEthnic();
		
		//Clicking on Integer Vitae Iaculis Massa product
		checkout_WO_login_POM1.clickItem();

		for (String newWindow : driver.getWindowHandles()) {
			driver.switchTo().window(newWindow);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			Thread.sleep(5000);
		}
		
		//Clicking on add to cart
		checkout_WO_login_POM1.clickAddToCart();
		
		//Moving to cart icon
		checkout_WO_login_POM1.moveToCart();
		
		//Clicking on view cart
		checkout_WO_login_POM1.clickViewCart();
		
		//Clicking on checkout
		checkout_WO_login_POM1.clickCheckOut();
		
		//Assertion process
		String actualMsg = checkout_WO_login_POM1.actualMsg();
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "Login");
		screenShot.captureScreenShot("Thirtytwo");
	}

}
