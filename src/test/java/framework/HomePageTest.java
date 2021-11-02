package framework;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentTest;
import pageObjects.HomeObjects;
import pageObjects.LoginObjects;
import resources.Base;

public class HomePageTest extends Base {
	public HomePageTest() {
		super();
	}

	@BeforeClass
	public void getUrl() throws IOException {
		driver = initializeDriver();
	}

	@Test(dataProvider = "getData")
	public void home(String uname, String pass) throws IOException {
		driver.get(pro.getProperty("url"));
		HomeObjects home = new HomeObjects(driver);

		home.clickLogin().click();

		LoginObjects lpage = new LoginObjects(driver);

		test.info("Entering username");
		lpage.emailInput().sendKeys(uname);
		test.pass("Username entered");

		test.info("Entering Password");
		lpage.passInput().sendKeys(pass);
		test.pass("password entered");

		test.info("Clicking button");
		lpage.loginButton().click();
		test.pass("button clicked");
	}

	@AfterClass
	public void closeWindow() {
		driver.close();
		driver = null;
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "chaityacoolj@gmail.com";
		data[0][1] = "12345678";

		data[1][0] = "harikdshah604@gmail.com";
		data[1][1] = "123456";

		return data;
	}

	@AfterSuite
	public void flush() {
		extent.flush();
	}
}
