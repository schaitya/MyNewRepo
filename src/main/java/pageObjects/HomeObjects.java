package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeObjects {
	
	
	public WebDriver driver;
	
	public HomeObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	you can use asterisk sign * as regular expression if it conatins that than it will display the results
	@FindBy(css="a[href*='sign_in']")
	WebElement login;

	@FindBy(xpath="//section[@id='content']/div/div/h2")
	WebElement title;
	
	@FindBy(css="div[role='navigation']")
	WebElement nav;

	public WebElement clickLogin() {
		return login;
	}
	
	public WebElement getTitle() {
		return title;
	}
	public WebElement getNavbar() {
		return nav;
	}
}
