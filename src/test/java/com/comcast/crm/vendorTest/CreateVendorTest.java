package com.comcast.crm.vendorTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;
import com.comcast.crm.objectRepositoryutility.CreateVendorPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;

public class CreateVendorTest {
	
	public static void main(String[] args)throws Throwable {
		FileUtility fileUtility = new FileUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		JavaUtility javaUtility = new JavaUtility();
		WebdriverUtility webdriverUtility = new WebdriverUtility();
		
		String BROWSER = fileUtility.getDataFromPropertiesFile("browser");
		String URL = fileUtility.getDataFromPropertiesFile("url");
		String USERNAME = fileUtility.getDataFromPropertiesFile("username");
		String PASSWORD = fileUtility.getDataFromPropertiesFile("password");
		int randomInt = javaUtility.getRandomNumber();
		
		String vendorname = excelUtility.getDataFromExcel("Sheet3", 3, 0)+randomInt;

		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();
		webdriverUtility.maximizeScreen(driver);
		webdriverUtility.waitForPageToLoad(driver);
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME,PASSWORD);
		
		HomePage homePage = new HomePage(driver);
		homePage.navigateToMoreLink();
		homePage.navigateToVendors();
		
		CreateVendorPage createVendorPage = new CreateVendorPage(driver);
		createVendorPage.createNewVendor(vendorname);
		createVendorPage.clickSaveButton();
	}

}
