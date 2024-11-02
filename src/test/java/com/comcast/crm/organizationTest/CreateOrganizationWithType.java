package com.comcast.crm.organizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;
import com.comcast.crm.objectRepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;
import com.comcast.crm.objectRepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectRepositoryutility.OrganizationsPage;

public class CreateOrganizationWithType {
	public static void main(String[] args) throws Throwable {
		FileUtility fileUtility = new FileUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		JavaUtility javaUtility = new JavaUtility();
		WebdriverUtility webdriverUtility = new WebdriverUtility();
		
		String BROWSER = fileUtility.getDataFromPropertiesFile("browser");
		String URL = fileUtility.getDataFromPropertiesFile("url");
		String USERNAME = fileUtility.getDataFromPropertiesFile("username");
		String PASSWORD = fileUtility.getDataFromPropertiesFile("password");

		int randomInt = javaUtility.getRandomNumber();

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
		/*
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.partialLinkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(dataFromExcel1);
		driver.findElement(By.id("email1")).sendKeys(dataFromExcel2);
		driver.findElement(By.name("bill_street")).sendKeys(dataFromExcel3);
		driver.findElement(By.name("ship_street")).sendKeys(dataFromExcel4);

		WebElement industry_dp = driver.findElement(By.name("industry"));
		webdriverUtility.select(industry_dp, "Banking");

		WebElement accounttype = driver.findElement(By.name("accounttype"));
		webdriverUtility.select(accounttype, "Investor");

		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();*/
		
		String organizationName = excelUtility.getDataFromExcel("Sheet1", 2, 1)+ randomInt;
		String industry = excelUtility.getDataFromExcel("Sheet1", 12, 1);
		String type = excelUtility.getDataFromExcel("Sheet1", 13, 1);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME,PASSWORD);
		
		HomePage homePage = new HomePage(driver);
		homePage.getOrganizationLink().click();
		
		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateOrg().click();
		
		CreateNewOrganizationPage createNewOrganization = new CreateNewOrganizationPage(driver);
		createNewOrganization.enterOrganizationName(organizationName+randomInt);
		createNewOrganization.selectIndustry(industry);
		createNewOrganization.selectType(type);
		createNewOrganization.clickSaveButton();
		
		OrganizationInfoPage infoPage = new OrganizationInfoPage(driver);
		infoPage.verifyPage(organizationName);
	}

}
