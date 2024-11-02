package com.comcast.crm.vendorTestNGTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.objectRepositoryutility.CreateVendorPage;
import com.comcast.crm.objectRepositoryutility.HomePage;
import com.comcast.crm.objectRepositoryutility.VendorInfoPage;
import com.crm.comcast.generic.baseUtility.BaseClass;

@Listeners(com.comcast.crm.listnerUtilty.ListnerImpl.class)
public class CreateVendorTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createVendor() throws Throwable {
		int randomInt = javaUtility.getRandomNumber();

		String vendorname = excelUtility.getDataFromExcel("Sheet3", 3, 0) + randomInt;

		HomePage homePage = new HomePage(driver);
		homePage.navigateToMoreLink();
		homePage.navigateToVendors();

		CreateVendorPage createVendorPage = new CreateVendorPage(driver);
		createVendorPage.createNewVendor(vendorname);
		createVendorPage.clickSaveButton();

		VendorInfoPage infoPage = new VendorInfoPage(driver);
		String vendorHeaderText = infoPage.getVendorHeader().getText();

		boolean result = vendorHeaderText.contains(vendorname);
		Assert.assertTrue(result);
	}

	@Test(groups = "regressionTest")
	public void createAndDuplicateVendor() throws Throwable {
		int randomInt = javaUtility.getRandomNumber();

		String vendorname = excelUtility.getDataFromExcel("Sheet3", 3, 0) + randomInt;
		HomePage homePage = new HomePage(driver);
		homePage.navigateToMoreLink();
		homePage.navigateToVendors();

		CreateVendorPage createVendorPage = new CreateVendorPage(driver);
		createVendorPage.createNewVendor(vendorname);
		createVendorPage.clickSaveButton();

		VendorInfoPage infoPage = new VendorInfoPage(driver);
		infoPage.clickDuplicateVendor();
		infoPage.clickSaveButton();

		VendorInfoPage infoPage1 = new VendorInfoPage(driver);
		String vendorHeaderText = infoPage1.getVendorHeader().getText();

		boolean result = vendorHeaderText.contains(vendorname);
		Assert.assertTrue(result);
	}

}
