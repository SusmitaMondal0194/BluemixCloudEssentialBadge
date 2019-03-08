package com.training.sanity.tests;

//TestCase is to verify whether application allows user to place an order as guest user

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Checkout_WO_login_POM1;
import com.training.pom.Checkout_With_login_POM;
import com.training.pom.Checkout_as_Guest_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_034_Test {

	private WebDriver driver;
	private String baseUrl;
	private Checkout_WO_login_POM1 checkout_WO_login_POM1;
	private Checkout_With_login_POM checkout_With_login_POM;
	private Checkout_as_Guest_POM checkout_as_Guest_POM;
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
		checkout_With_login_POM = new Checkout_With_login_POM(driver);
		checkout_as_Guest_POM = new Checkout_as_Guest_POM(driver);
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
	public void rTTC_034_Test() throws InterruptedException {
		// Moving to Shop now
		checkout_WO_login_POM1.moveToShopNow();

		// Clicking on Ethnic
		checkout_WO_login_POM1.clickEthnic();

		// Clicking on Integer Vitae Iaculis Massa product
		checkout_WO_login_POM1.clickItem();

		//Switching to New Window
		for (String newWindow : driver.getWindowHandles()) {
			driver.switchTo().window(newWindow);
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

		//Clicking on Guest
		checkout_as_Guest_POM.clickGuest();
		
		//Clicking on continue
		checkout_as_Guest_POM.continueAsGuest();
		
		//Providing All details of user and address
		checkout_as_Guest_POM.firstName("Susmita");
		checkout_as_Guest_POM.lastName("Mondal");
		checkout_as_Guest_POM.email("susmita011@gmail.com");
		checkout_as_Guest_POM.telephone("9998888777");
		checkout_as_Guest_POM.address1("GARDEN REACH");
		checkout_as_Guest_POM.address2("KOLKATA");
		checkout_as_Guest_POM.city("KOLKATA");
		checkout_as_Guest_POM.postCode("700020");
		checkout_as_Guest_POM.country("India");
		checkout_as_Guest_POM.state("West Bengal");

		//below code is to verify if My delivery and billing addresses are the same checkbox is selected or not , if not selected then it should be checked
		boolean actual = driver.findElement(By.xpath("//input[@name='shipping_address']")).isSelected();
		boolean expected = true;
		if (actual != expected) {
			checkout_as_Guest_POM.addressCheck();
		} else {
			// System.out.println("Moving to continue part");
		}
		//Clicking on Continue
		checkout_as_Guest_POM.continueToShipping();
		
		// Clicking on Continue
		checkout_With_login_POM.continueDeliveryMethod();

		// Adding comment
		checkout_With_login_POM.addComment("This product is nice");

		// Clicking on check box
		checkout_With_login_POM.checkTNC();

		// Clicking on Continue
		checkout_With_login_POM.continueCOD();

		// Clicking on Confirm order
		checkout_With_login_POM.confirmBtn();
		
		//Assertion Process
		String actualMsg = checkout_as_Guest_POM.actualMsg();
		// System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, "Your order has been successfully processed!");
		screenShot.captureScreenShot("ThirtyFour");
	}

}
