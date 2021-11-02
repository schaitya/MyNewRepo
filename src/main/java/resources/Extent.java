package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent {
	
	public static ExtentReports extent;
	
	public static ExtentReports ExtentInital() {
		String current = System.getProperty("user.dir");
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(current+"\\target\\spark\\home.html");
		extent.attachReporter(spark);
		spark.config().setDocumentTitle("Test Reports");
		spark.config().setReportName("Qa Click Academy");
		
		return extent;
	}

}
