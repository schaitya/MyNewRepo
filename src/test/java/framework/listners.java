package framework;
import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import resources.Base;

public class listners extends Base implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName());
		test = extent.createTest(result.getName());
	}

	public void onTestFailure(ITestResult result) {
		try {
			System.out.println("This is working");
			takeScreenshot(result.getName());
			test.fail(result.getThrowable());
			test.addScreenCaptureFromPath("C:\\Users\\M1073035\\firstproject\\screenshot\\"+result.getName()+"ss.png",result.getName()+"ss.png");
			extent.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}
	
}