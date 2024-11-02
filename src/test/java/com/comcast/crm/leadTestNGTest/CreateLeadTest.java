package com.comcast.crm.leadTestNGTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.objectRepositoryutility.CreateLeadsPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.LeadsInfoPage;
import com.comcast.crm.objectRepositoryutility.LeadsPage;
import com.crm.comcast.generic.baseUtility.BaseClass;

@Listeners(com.comcast.crm.listnerUtilty.ListnerImpl.class)
public class CreateLeadTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createLead() throws Throwable {
		int randomInt = javaUtility.getRandomNumber();
		String firstName = excelUtility.getDataFromExcel("Sheet2", 3, 0);
		String lastName = excelUtility.getDataFromExcel("Sheet2", 3, 1) + randomInt;
		String companyName = excelUtility.getDataFromExcel("Sheet2", 3, 2);
		HomePage homePage = new HomePage(driver);
		homePage.navigateToLeadsPage();

		LeadsPage leadPage = new LeadsPage(driver);
		leadPage.createNewLead();

		CreateLeadsPage leadsPage = new CreateLeadsPage(driver);
		leadsPage.enterFirstName(firstName);
		leadsPage.enterLastName(lastName);
		leadsPage.enterCompanyName(companyName);
		leadsPage.saveLead();

		LeadsInfoPage infoPage = new LeadsInfoPage(driver);
		boolean result = infoPage.getLeadHeader().getText().contains(lastName);
		Assert.assertTrue(result);

	}

	@Test(groups = "regressionTest")
	public void createLeadWithPhoneNumber() throws Throwable {
		int randomInt = javaUtility.getRandomNumber();
		String firstName = excelUtility.getDataFromExcel("Sheet2", 3, 0);
		String lastName = excelUtility.getDataFromExcel("Sheet2", 3, 1) + randomInt;
		String companyName = excelUtility.getDataFromExcel("Sheet2", 3, 2);
		StringBuilder phonumber = javaUtility.generatePhonumber();

		HomePage homePage = new HomePage(driver);
		homePage.navigateToLeadsPage();

		LeadsPage leadPage = new LeadsPage(driver);
		leadPage.createNewLead();

		CreateLeadsPage leadsPage = new CreateLeadsPage(driver);
		leadsPage.enterFirstName(firstName);
		leadsPage.enterLastName(lastName);
		leadsPage.enterCompanyName(companyName);
		leadsPage.enterMobileNumber(phonumber);
		leadsPage.saveLead();

		LeadsInfoPage infoPage = new LeadsInfoPage(driver);
		String savedPhoneNumber = infoPage.getMobileNumber().getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(savedPhoneNumber, phonumber);
	}

	@Test(groups = "regressionTest")
	public void createLeadWithSource() throws Throwable {
		int randomInt = javaUtility.getRandomNumber();
		String firstName = excelUtility.getDataFromExcel("Sheet2", 3, 0);
		String lastName = excelUtility.getDataFromExcel("Sheet2", 3, 1) + randomInt;
		String companyName = excelUtility.getDataFromExcel("Sheet2", 3, 2);
		String lead_Source = excelUtility.getDataFromExcel("Sheet2", 3, 3);
		String industry = excelUtility.getDataFromExcel("Sheet2", 3, 4);
		StringBuilder phonumber = javaUtility.generatePhonumber();

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
		leadsPage.saveLead();

		LeadsInfoPage infoPage = new LeadsInfoPage(driver);
		String savedSource = infoPage.getLeadSource().getText();
		String savedIndustry = infoPage.getLeadIndustry().getText();
		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals(savedSource, lead_Source);
		assert1.assertEquals(savedIndustry, industry);
	}

	@Test(groups = "regressionTest")
	public void createLeadWithRating() throws Throwable {
		int randomInt = javaUtility.getRandomNumber();
		String firstName = excelUtility.getDataFromExcel("Sheet2", 3, 0);
		String lastName = excelUtility.getDataFromExcel("Sheet2", 3, 1) + randomInt;
		String companyName = excelUtility.getDataFromExcel("Sheet2", 3, 2);
		String lead_Source = excelUtility.getDataFromExcel("Sheet2", 3, 3);
		String industry = excelUtility.getDataFromExcel("Sheet2", 3, 4);
		String status = excelUtility.getDataFromExcel("Sheet2", 3, 5);
		String rating = excelUtility.getDataFromExcel("Sheet2", 3, 6);
		StringBuilder phonumber = javaUtility.generatePhonumber();

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

		LeadsInfoPage infoPage = new LeadsInfoPage(driver);
		String savedRating = infoPage.getLeadRating().getText();
		String savedStatus = infoPage.getLeadStatus().getText();

		SoftAssert assert1 = new SoftAssert();
		assert1.assertEquals(savedRating, rating);
		assert1.assertEquals(savedStatus, status);
	}

}
