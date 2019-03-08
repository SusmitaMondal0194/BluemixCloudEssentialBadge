package com.training.sanity.tests;

//Below Testcase is to verify whether registered user details stored in database
//Note to run this testcase successfully line#2 of sql.properties should be active and line#3 should be disable.

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.Registration_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_061_Test {

	private WebDriver driver;
	private String baseUrl;
	private Registration_POM registration_POM;
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

	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void rTTC_061_Test(String FIRSTNAME, String LASTNAME,String EMAIL, String TELEPHONE,String ADDRESS1, String ADDRESS2,String CITY, String POSTCODE,String COUNTRY,String STATE, String PASSWORD,String CONFIRMPASSWORD) {

		
		// clicking on Account Icon
		registration_POM.clickAccountIcon();

		// clicking on Register
		registration_POM.clickRegister();

		// Entering firstName
		String firstName = registration_POM.firstName("Susmita");

		// Entering Last Name
		String lastName = registration_POM.lastName("Mondal");

		// Entering Email ID
		String email = registration_POM.email("susmitamondal0101@gmail.com");

		// Entering Phone Number
		String telephone = registration_POM.telephone("9854451235");

		// Entering address 1
		String address1 =  registration_POM.address1("GARDEN REACH");

		// Entering address 2
		String address2 = registration_POM.address2("KOLKATA");

		//// Entering city
		String city =registration_POM.city("KOLKATA");

		// Entering Postal code
		String postCode = registration_POM.postCode("777765");

		// Entering Country
		String country= registration_POM.country("India");

		// Entering State
		String state = registration_POM.state("West Bengal");

		// creating a Password
		String password = registration_POM.password("12345");

		// Confirming the entered password
		//registration_POM.confirmPassword("12345");
		String confirmPassword= registration_POM.confirmPassword("12345");

		// Clicking on Subscribe Radio Button
		registration_POM.subscribeBtn();

		// Clicking on Privacy Policy Check Box
		registration_POM.policyCheckBox();

		// Clicking on Continue button
		registration_POM.continueBtn();
		
		// Below codes are for Assertion process matching all the values from retail DB and System
		Assert.assertEquals(firstName, FIRSTNAME);
		Assert.assertEquals(lastName, LASTNAME);
		Assert.assertEquals(email, EMAIL);
		Assert.assertEquals(telephone, TELEPHONE);
		Assert.assertEquals(address1, ADDRESS1);
		Assert.assertEquals(address2, ADDRESS2);
		Assert.assertEquals(city, CITY);
		Assert.assertEquals(postCode, POSTCODE);
		Assert.assertEquals(country, COUNTRY);
		Assert.assertEquals(state, STATE);
		Assert.assertEquals(password, PASSWORD);
		Assert.assertEquals(confirmPassword, CONFIRMPASSWORD);
	
		screenShot.captureScreenShot("Sixty One");
	}

}
