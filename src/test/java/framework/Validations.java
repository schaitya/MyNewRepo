package framework;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomeObjects;
import resources.Base;

public class Validations extends Base{
	
	@BeforeClass
	public void getHomeUrl() throws IOException {
	driver = initializeDriver();
		
		driver.get(pro.getProperty("url"));
	}
	@Test
	public void home() {
		
		HomeObjects home = new HomeObjects(driver);
		
		Assert.assertEquals(home.getTitle().getText(),"FEATURED COURSES123");
		log.info("title is correct");
		Assert.assertTrue(home.getNavbar().isDisplayed());
		log.info("Nav Bar is Displaying");

	}
	
	@AfterClass
	public void closeValidWindow() {
		driver.close();
		driver=null;
	}
}
