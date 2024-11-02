package com.comcast.crm.leadTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;
import com.comcast.crm.objectRepositoryutility.CreateLeadsPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LeadsPage;
import com.comcast.crm.objectRepositoryutility.LoginPage;

public class CreateLeadWithRating {
	public static void main(String[] args) throws Throwable{
		FileUtility fileUtility = new FileUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		JavaUtility javaUtility = new JavaUtility();
		WebdriverUtility webdriverUtility = new WebdriverUtility();

		String BROWSER = fileUtility.getDataFromPropertiesFile("browser");
		String URL = fileUtility.getDataFromPropertiesFile("url");
		String USERNAME = fileUtility.getDataFromPropertiesFile("username");
		String PASSWORD = fileUtility.getDataFromPropertiesFile("password");
		int randomInt = javaUtility.getRandomNumber();
		String firstName = excelUtility.getDataFromExcel("Sheet2", 1, 0);
		String lastName = excelUtility.getDataFromExcel("Sheet2", 1, 1) + randomInt;
		String companyName = excelUtility.getDataFromExcel("Sheet2", 1, 2);
		String lead_Source = excelUtility.getDataFromExcel("Sheet2", 1, 3);
		String industry = excelUtility.getDataFromExcel("Sheet2", 1, 4);
		String status = excelUtility.getDataFromExcel("Sheet2", 1, 5);
		String rating = excelUtility.getDataFromExcel("Sheet2", 1, 6);
		StringBuilder phonumber = javaUtility.generatePhonumber();
		
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();

		driver.manage().window().maximize();
		webdriverUtility.waitForPageToLoad(driver);
		driver.get(URL);

		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);

		HomePage homePage = new HomePage(driver);
		homePage.navigateToLeadsPage();

		LeadsPage leadPage = new LeadsPage(driver);
		leadPage.createNewLead();

		CreateLeadsPage leadsPage = new CreateLeadsPage(driver);
		leadsPage.enterFirstName(firstName);
		leadsPage.enterLastName(lastName);
		leadsPage.enterCompanyName(companyName);
		leadsPage.enterMobileNumber(phonumber);
		leadsPage.selectLeadSource(lead_Source);
		leadsPage.selectLeadIndustry(industry);
		leadsPage.selectLeadStatus(status);
		leadsPage.selectLeadRating(rating);
		leadsPage.saveLead();
	}


}
