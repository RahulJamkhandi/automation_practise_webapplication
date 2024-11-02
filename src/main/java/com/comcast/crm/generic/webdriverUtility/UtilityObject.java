package com.comcast.crm.generic.webdriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityObject {
	
	private static ThreadLocal<ExtentTest> local = new ThreadLocal<ExtentTest>();
	
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();

	public static ExtentTest getLocal() {
		return local.get();
	}

	public static void setLocal(ExtentTest actTest) {
		local.set(actTest);
	}

	public static WebDriver getDriverLocal() {
		return driverLocal.get();
	}

	public static void setDriverLocal(WebDriver actDriver) {
		driverLocal.set(actDriver);
	}
	
	

}
