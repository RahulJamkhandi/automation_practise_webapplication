package com.crm.comcast.generic.baseUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseUtility.DatabaseUtility;
import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.UtilityObject;
import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;

public class BaseClass {

	public DatabaseUtility databaseUtility = new DatabaseUtility();
	public FileUtility fileUtility = new FileUtility();
	public ExcelUtility excelUtility = new ExcelUtility();
	public JavaUtility javaUtility = new JavaUtility();
	public WebdriverUtility webdriverUtility = new WebdriverUtility();
	public WebDriver driver = null;
	public static WebDriver static_driver;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBeforeSuite() {
		System.out.println("===Connect to DB & Report Config===");

	}

	// @Parameters("browser")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBeforeClass() throws Exception {
		System.out.println("===Launch browser===");
		String BROWSER = fileUtility.getDataFromPropertiesFile("browser");
		// String BROWSER = browser;
		System.out.println("hello:" + BROWSER);
		if (BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();
		webdriverUtility.maximizeScreen(driver);
		driver.get(fileUtility.getDataFromPropertiesFile("url"));
		static_driver = driver;
		UtilityObject.setDriverLocal(driver);
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configureBeforeMethod() throws Exception {
		System.out.println("===Login===");
		LoginPage loginPage = new LoginPage(driver);
		String USERNAME = fileUtility.getDataFromPropertiesFile("username");
		String PASSWORD = fileUtility.getDataFromPropertiesFile("password");
		loginPage.loginToApp(USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configureAfterMethod() throws InterruptedException {
		System.out.println("===Logout===");
		HomePage homePage = new HomePage(driver);
		homePage.logout();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAfterClass() {
		System.out.println("===Close browser===");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAfterSuite() {
		System.out.println("===Close DB & Report BackUp===");
	}

}
