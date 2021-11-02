package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {
	public static WebDriver driver;
	
	public Logger log = LogManager.getLogger(Base.class.getName());
	
	public static Properties pro = new Properties();
	
	public static ExtentReports extent;
	
	public ExtentSparkReporter spark;
	
	public static ExtentTest test;
	
		
	protected String currentDir = System.getProperty("user.dir");
	
	public Base() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(currentDir+"\\target\\spark\\home.html");
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
	}
	
	public WebDriver initializeDriver() throws IOException {		
		 
		
		FileInputStream fis = new FileInputStream(currentDir + "\\src\\main\\java\\resources\\data.properties");

		pro.load(fis);
		
		String browser = pro.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",currentDir +"\\resources\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",currentDir +"\\resources\\firefoxdriver.exe");
			 driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("internetExplorer")) {
			System.setProperty("webdriver.chrome.driver",currentDir +"\\resources\\internetExplorer.exe");
			 driver = new InternetExplorerDriver();
		}
		return driver;
		
	}
	
	
	public void takeScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\M1073035\\firstproject\\screenshot\\"+result+"ss.png"));
	}
	
	

}
