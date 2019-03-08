package com.training.sanity.tests;

// Below code is to verify whether application displays order details upon Clicking My Orders link

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
import com.training.pom.Order_Details_POM;
import com.training.pom.Registration_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_004_Test {

	private WebDriver driver;
	private String baseUrl;
	private Registration_POM registration_POM;
	private Login_POM login_POM;
	private Order_Details_POM order_Details_POM;
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
		order_Details_POM = new Order_Details_POM(driver);
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
	public void rTTC_004_Test() {
		// clicking on Account Icon
		registration_POM.clickAccountIcon();

		// Getting the Email ID
		login_POM.emailAddress("susmita@gmail.com");

		// Providing Password
		login_POM.password("12345");

		// Clicking on Login Button
		login_POM.clickLoginBtn();
		
		//Again moving to Account Icon
		order_Details_POM.moveToAccountIcon();
		
		//Clicking on my orders
		order_Details_POM.myOrders();
		
		//Clicking on view icon
		order_Details_POM.viewOrders();
		
		//Below codes are for Assertion process
		String actualTitle = driver.getTitle();
		// System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Order Information");
		screenShot.captureScreenShot("Fourth");
	}

}
