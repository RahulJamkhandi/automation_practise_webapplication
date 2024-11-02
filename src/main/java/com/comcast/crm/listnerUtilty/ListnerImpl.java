package com.comcast.crm.listnerUtilty;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverUtility.UtilityObject;
import com.crm.comcast.generic.baseUtility.BaseClass;

public class ListnerImpl extends BaseClass implements ITestListener, ISuiteListener {
	public static ExtentReports extentReports;
	public ExtentSparkReporter spark;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		System.out.println("Report Configuration");
		
		String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());

		spark = new ExtentSparkReporter("./AdvanceReports/report"+timestamp+".html");
		spark.config().setDocumentTitle("Sample CRM Test Suites");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);

		// Envi Info
		extentReports = new ExtentReports();
		extentReports.attachReporter(spark);
		extentReports.setSystemInfo("OS", "Windows-11");
		extentReports.setSystemInfo("BROWSER", "Chrome-130.0.6723.70");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		System.out.println("Report BackUp");
		extentReports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		System.out.println(result.getMethod().getMethodName() + " Start");
		test = extentReports.createTest(result.getMethod().getMethodName());
		UtilityObject.setLocal(test);
		// Get the method name
		String methodName = result.getMethod().getMethodName();

		
		test.log(Status.INFO, methodName+"===> STARTED");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println(result.getMethod().getMethodName() + " End");
		test.log(Status.PASS, result.getMethod().getMethodName() + "===> COMPLETED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Call the super method
		ITestListener.super.onTestFailure(result);

		// Get the method name
		String methodName = result.getMethod().getMethodName();

		// Get the current timestamp with spaces and colons replaced by underscores
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		// Take a screenshot
		TakesScreenshot screenshot = (TakesScreenshot) BaseClass.static_driver;
		String filePath = screenshot.getScreenshotAs(OutputType.BASE64);

		test.addScreenCaptureFromBase64String(filePath, methodName + "_" + timestamp);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "===> FAILED");
		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		test.log(Status.SKIP, result.getMethod().getMethodName() + "===> SKIPPED");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
