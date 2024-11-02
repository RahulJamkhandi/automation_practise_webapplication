package com.crm.comcast.ContactTestNgTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverUtility.UtilityObject;
import com.comcast.crm.objectRepositoryutility.ContactsPage;
import com.comcast.crm.objectRepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.crm.comcast.generic.baseUtility.BaseClass;

@Listeners(com.comcast.crm.listnerUtilty.ListnerImpl.class)
public class CreateContactTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createContact() throws Throwable {

		int randomInt = javaUtility.getRandomNumber();
		UtilityObject.getLocal().log(Status.INFO, "Fetch Data From Excel");
		String salutation = excelUtility.getDataFromExcel("Sheet4", 1, 1);
		String firstName = excelUtility.getDataFromExcel("Sheet4", 3, 0);
		String lastName = excelUtility.getDataFromExcel("Sheet4", 3, 1) + randomInt;

		UtilityObject.getLocal().log(Status.INFO, "Login to HOMEPAGE");
		HomePage homePage = new HomePage(driver);
		homePage.getContactLink().click();

		UtilityObject.getLocal().log(Status.INFO, "Navigate to Contat page");
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.createNewContact();

		UtilityObject.getLocal().log(Status.INFO, "Naviagate to New Contact Page");
		CreateNewContactPage newContactPage = new CreateNewContactPage(driver);
		newContactPage.enterContactName(salutation, firstName, lastName);
		newContactPage.saveContact();

		String actualHeader = newContactPage.getContactHeader().getText();
		boolean result = actualHeader.contains(lastName);
		Assert.assertTrue(result);

		SoftAssert assert1 = new SoftAssert();
		String lastNameActual = newContactPage.getLastNameSaved().getText();
		assert1.assertEquals(lastNameActual, lastName);

	}

	@Test(groups = "regressionTest")
	public void createContactWithDate() throws Throwable {
		int randomInt = javaUtility.getRandomNumber();
		UtilityObject.getLocal().log(Status.INFO, "Fetch Data From Excel");
		String salutation = excelUtility.getDataFromExcel("Sheet4", 1, 1);
		String firstName = excelUtility.getDataFromExcel("Sheet4", 3, 0);
		String lastName = excelUtility.getDataFromExcel("Sheet4", 3, 1) + randomInt;
		System.out.println("Execute create contact with date and verify");

		UtilityObject.getLocal().log(Status.INFO, "Login to HOMEPAGE");
		HomePage homePage = new HomePage(driver);
		homePage.getContactLink().click();

		UtilityObject.getLocal().log(Status.INFO, "Navigate to Contat page");
		ContactsPage contactsPage = new ContactsPage(driver);
		contactsPage.createNewContact();

		UtilityObject.getLocal().log(Status.INFO, "Naviagate to New Contact Page");
		CreateNewContactPage newContactPage = new CreateNewContactPage(driver);
		newContactPage.enterContactName(salutation, firstName, lastName);
		newContactPage.setCurrentDate();
		newContactPage.setFutureDate();
		newContactPage.saveContact();

		String actualHeader = newContactPage.getContactHeader().getText();
		boolean result = actualHeader.contains(lastName);
		Assert.assertTrue(result);

		SoftAssert assert1 = new SoftAssert();
		String lastNameActual = newContactPage.getLastNameSaved().getText();
		assert1.assertEquals(lastNameActual, lastName);
	}
}
