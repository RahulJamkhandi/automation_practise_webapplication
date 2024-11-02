package com.comcast.crm.contactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;
import com.comcast.crm.objectRepositoryutility.ContactsPage;
import com.comcast.crm.objectRepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LoginPage;

public class CreateContactWithSupportDateTest {

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
		String salutation = excelUtility.getDataFromExcel("Sheet4", 1, 1);
		String firstName = excelUtility.getDataFromExcel("Sheet4", 3, 0);
		String lastName = excelUtility.getDataFromExcel("Sheet4", 3, 1)+randomInt;

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
		 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 * 
		 * driver.findElement(By.partialLinkText("Organizations")).click();
		 * driver.findElement(By.xpath("//img[@title='Create Organization...']")).click(
		 * ); driver.findElement(By.linkText("Contacts")).click();
		 * driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		 * Select select = new Select(driver.findElement(By.name("salutationtype")));
		 * select.selectByValue("Mr.");
		 * driver.findElement(By.name("firstname")).sendKeys(firstName);
		 * driver.findElement(By.name("lastname")).sendKeys(lastName);
		 * driver.findElement(By.name("support_start_date")).clear();
		 * driver.findElement(By.name("support_start_date")).sendKeys(currentDate.
		 * toString());
		 * 
		 * driver.findElement(By.name("support_end_date")).clear();
		 * driver.findElement(By.name("support_end_date")).sendKeys(futureDate.toString(
		 * ));
		 * 
		 * driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		 * driver.quit();
		 */
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME,PASSWORD);
		
		HomePage homePage = new HomePage(driver);
		homePage.getContactLink().click();
		
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.createNewContact();
		
		CreateNewContactPage newContactPage = new CreateNewContactPage(driver);
		newContactPage.enterContactName(salutation, firstName, lastName);
		newContactPage.setCurrentDate();
		newContactPage.setFutureDate();
		newContactPage.saveContact();
	}

}
