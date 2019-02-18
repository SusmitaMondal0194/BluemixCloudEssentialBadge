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
import com.training.pom.OrderDetailsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class OrderDetailsTest {

	private WebDriver driver;
	private String baseUrl;
	private OrderDetailsPOM orderDetailsPOM;
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
		orderDetailsPOM = new OrderDetailsPOM(driver);
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
	public void orderDetailsTest() {
		orderDetailsPOM.clickAccountIcon();
		orderDetailsPOM.emailAddress("susmita@gmail.com");
		orderDetailsPOM.password("12345");
		orderDetailsPOM.clickLoginBtn();
		orderDetailsPOM.moveToAccountIcon();
		orderDetailsPOM.myOrders();
		orderDetailsPOM.viewOrders();
		String actualTitle = driver.getTitle();
		// System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Order Information");
		screenShot.captureScreenShot("Fourth");
	}

}
