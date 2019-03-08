package com.training.sanity.tests;

//Below TestCase were modified from RTTC_064 : To verify whether application allows admin to add multiple category in categories page , by ignoring the excel input part and 
//only with DB validation part with single category input given in the code
//Note to run this testcase successfully line#3 of sql.properties should be active.



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.dataproviders.CategoryDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.Admin_Categories_POM;
import com.training.pom.Admin_RewardPt_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_064_Test {

	private static WebDriver driver;
	private static String baseUrl;
	private static Admin_RewardPt_POM admin_RewardPt_POM;
	private static Admin_Categories_POM admin_Categories_POM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		admin_RewardPt_POM = new Admin_RewardPt_POM(driver);
		admin_Categories_POM = new Admin_Categories_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(dataProvider = "db-inputs1", dataProviderClass = CategoryDataProviders.class)
	public void rTTC_064_Test(String CATEGORYNAME, String CATEGORYDESC, String METATAGTITLE, String METATAGDESC) {

		// Providing user name
		admin_RewardPt_POM.userName("admin");

		// Providing password
		admin_RewardPt_POM.password("admin@123");

		// Clicking on Login button
		admin_RewardPt_POM.clickLoginBtn();

		// Clicking on Catalog
		admin_RewardPt_POM.catalog();

		// Clicking on Catalog
		admin_Categories_POM.categoryList();

		// Clicking on Product list
		admin_Categories_POM.addNew();

		// Clicking on Add symbol
		String categoryName = admin_Categories_POM.categoryName("Electronics Goods");

		// Providing product name
		String categoryDesc = admin_Categories_POM.categoryDesc("Electronics Goods");

		// Providing metaTagTitle
		String metaTagTitle = admin_Categories_POM.metaTagTitle("Electronics Goods");

		// Providing metaTagDesc
		String metaTagDesc = admin_Categories_POM.metaTagDesc("Electronics Goods");

		// Clicking on Save
		admin_Categories_POM.saveBtn();

		System.out.println(metaTagDesc);

		Assert.assertEquals(categoryName, CATEGORYNAME);
		Assert.assertEquals(categoryDesc, CATEGORYDESC);
		Assert.assertEquals(metaTagTitle, METATAGTITLE);
		Assert.assertEquals(metaTagDesc, METATAGDESC);

		screenShot.captureScreenShot("Sixty Four");

	}

}
