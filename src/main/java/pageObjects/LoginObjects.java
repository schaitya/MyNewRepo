package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjects {
	public WebDriver driver;

	public LoginObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	you can use asterisk sign * as regular expression if it conatins that than it will display the results
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(id="user_password")
	WebElement pass;
	
	@FindBy(css="input[value='Log In']")
	WebElement login;

	public WebElement emailInput() {
		return email;
	}
	
	public WebElement passInput() {
		return pass;
	}
	
	public WebElement loginButton() {
		return login;
	}
}
