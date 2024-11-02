package com.comcast.crm.organisationTestNGTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectRepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectRepositoryutility.OrganizationsPage;
import com.crm.comcast.generic.baseUtility.BaseClass;

@Listeners(com.comcast.crm.listnerUtilty.ListnerImpl.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createOrganizationTest() throws Throwable {
		int randomInt = javaUtility.getRandomNumber();
		String organizationName = excelUtility.getDataFromExcel("Sheet1", 2, 1);
		HomePage homePage = new HomePage(driver);
		homePage.getOrganizationLink().click();

		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateOrg().click();

		CreateNewOrganizationPage createNewOrganization = new CreateNewOrganizationPage(driver);
		createNewOrganization.createOrg(organizationName + randomInt);
		OrganizationInfoPage infoPage = new OrganizationInfoPage(driver);
		infoPage.verifyPage(organizationName);

		String headerTextString = infoPage.getHeaderText().toString();
		boolean result = headerTextString.contains(organizationName);
		Assert.assertTrue(result);
	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithType() throws Throwable {
		int randomInt = javaUtility.getRandomNumber();
		String organizationName = excelUtility.getDataFromExcel("Sheet1", 2, 1) + randomInt;
		String industry = excelUtility.getDataFromExcel("Sheet1", 12, 1);
		String organizationType = excelUtility.getDataFromExcel("Sheet1", 13, 1);

		HomePage homePage = new HomePage(driver);
		homePage.getOrganizationLink().click();

		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateOrg().click();

		CreateNewOrganizationPage createNewOrganization = new CreateNewOrganizationPage(driver);
		createNewOrganization.enterOrganizationName(organizationName + randomInt);
		createNewOrganization.selectIndustry(industry);
		createNewOrganization.selectType(organizationType);
		createNewOrganization.clickSaveButton();

		OrganizationInfoPage infoPage = new OrganizationInfoPage(driver);
		infoPage.verifyPage(organizationName);

		String headerTextString = infoPage.getHeaderText().toString();
		boolean result = headerTextString.contains(organizationName);
		Assert.assertTrue(result);

		String savedType = infoPage.getTypeName().getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(savedType, organizationType);
	}

	@Test(groups = "regressionTest")
	public void createOrganizationWithPoneNumber() throws Throwable {
		int randomInt = javaUtility.getRandomNumber();
		String organizationName = excelUtility.getDataFromExcel("Sheet1", 2, 1) + randomInt;
		StringBuilder phonumber = javaUtility.generatePhonumber();
		HomePage homePage = new HomePage(driver);
		homePage.getOrganizationLink().click();

		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
		organizationsPage.getCreateOrg().click();

		CreateNewOrganizationPage createNewOrganization = new CreateNewOrganizationPage(driver);
		createNewOrganization.enterOrganizationName(organizationName + randomInt);
		createNewOrganization.officePhone(phonumber);
		createNewOrganization.clickSaveButton();
		OrganizationInfoPage infoPage = new OrganizationInfoPage(driver);
		String savedPhoneNumber = infoPage.getPhoneNum().getText();

		String headerTextString = infoPage.getHeaderText().toString();
		boolean result = headerTextString.contains(organizationName);
		Assert.assertTrue(result);

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(savedPhoneNumber, phonumber);
	}

}
