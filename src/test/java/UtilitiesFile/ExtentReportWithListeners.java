package UtilitiesFile;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCaseFile.TestCase1;

public class ExtentReportWithListeners extends TestCase1 implements ITestListener {

	ExtentSparkReporter createReport;
	ExtentReports createtest;
	ExtentTest createlog;
	
	void setup() {
	createReport=new ExtentSparkReporter("MyProjectReport.html");
	createtest=new ExtentReports();
	createtest.attachReporter(createReport);
	
	createtest.setSystemInfo("Os", "Windows");
	createtest.setSystemInfo("Browser", "Chrome");
	createtest.setSystemInfo("user", "Shreya");
	
	createReport.config().setDocumentTitle("MyExtentReport");
	createReport.config().setReportName("ExtentReportToday");
	createReport.config().setTheme(Theme.STANDARD);
	}
	public void onStart(ITestContext Result) {
		setup();
		System.out.println("onStart");
	}
	public void onFinish(ITestContext Result) {
		createtest.flush();
		System.out.println("onFinish call");
	}
	public void onTestStart(ITestResult Result) {
		System.out.println("ontestStart");
	}
	public void onTestSuccess(ITestResult Result) {
		createlog=createtest.createTest(Result.getName());
		createlog.log(Status.PASS,MarkupHelper.createLabel("Test Case Pass", ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult Result) {
		try {
			ScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = "D:\\Shreya_code\\Eclipse_workspace\\MyFirstDDProject\\ScreenshotFolder\\ProjectReport.png";
		createlog = createtest.createTest(Result.getName());
		createlog.log(Status.FAIL,MarkupHelper.createLabel("Test Case Fail", ExtentColor.RED));
		createlog.fail("myscreenshot"+createlog.addScreenCaptureFromPath(path));
		}
	public void onTestSkipped(ITestResult Result) {
		createlog=createtest.createTest(Result.getName());
	createlog.log(Status.SKIP, MarkupHelper.createLabel("Test case skip", ExtentColor.YELLOW));
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		
	}
		
}


