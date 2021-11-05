package framework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;

import pageObjects.HomeObjects;
import resources.Base;

public class ValidateHome extends Base{
	public ValidateHome() {
		super();
	}
	
	@BeforeClass
	public void inital() throws IOException {
		driver = initializeDriver();
	}
	
	@Test
	public void HomeValidation() throws InterruptedException {
		
		driver.get(pro.getProperty("url"));
		
		HomeObjects home = new HomeObjects(driver);
		
		test.info("Comparing Title");
		Assert.assertEquals(home.getTitle().getText(),"FEATURED COURSES123");
		Thread.sleep(5000);
		test.pass("Comparison successfull");
		
		test.info("Vaidating if NavBar is displayed ");
		Assert.assertTrue(home.getNavbar().isDisplayed());
		test.pass("NavBar is displayed");

		
	}
	
	@AfterClass
	public void tear() {
		driver.close();
	}
	

	
	
}
