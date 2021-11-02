package framework;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

import resources.Base;

public class listnerNew extends Base implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("it is working");
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		extent.flush();
	}

	public void onTestFailure(ITestResult result) {
		try {
			System.out.println("This is working");
			takeScreenshot(result.getName());
			test.fail(result.getThrowable(), MediaEntityBuilder
					.createScreenCaptureFromPath(currentDir + "//screenshot//" + result.getName() + "ss.png").build());
			extent.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
