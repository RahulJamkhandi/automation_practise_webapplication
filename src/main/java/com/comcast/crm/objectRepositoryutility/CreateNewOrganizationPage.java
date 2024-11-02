package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import lombok.Getter;

@Getter
public class CreateNewOrganizationPage {

	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement OrgName;

//		@FindBy(name = "phone")
//		private WebElement Mobno;

	@FindBy(name = "industry")
	private WebElement Industry;

	@FindBy(name = "accounttype")
	private WebElement Type;

	@FindAll({ @FindBy(id = "phone"), @FindBy(name = "phone") })
	private WebElement PhoneNo;

	@FindAll({ @FindBy(id = "fax"), @FindBy(name = "fax") })
	private WebElement Fax;

	@FindAll({ @FindBy(id = "otherphone"), @FindBy(name = "otherphone") })
	private WebElement OtherPhone;

	@FindAll({ @FindBy(id = "email1"), @FindBy(name = "email1") })
	private WebElement Email;

	@FindAll({ @FindBy(id = "ownership"), @FindBy(name = "ownership") })
	private WebElement Ownership;

	@FindBy(name = "annual_revenue")
	private WebElement AnnualRevenue;

	@FindAll({ @FindBy(id = "jscal_field_support_start_date"), @FindBy(name = "support_start_date") })
	private WebElement StartDate;

	@FindAll({ @FindBy(id = "jscal_field_support_end_date"), @FindBy(name = "support_end_date") })
	private WebElement EndDate;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement Savebtn;

	// Business Methods

	public void createOrg(String name) {
		OrgName.sendKeys(name);
		Savebtn.click();
	}

	public void createOrgWithMobile(String name, String number) {
		OrgName.sendKeys(name);
		PhoneNo.sendKeys(number);
		Savebtn.click();
	}

	public void enterOrganizationName(String name) {
		OrgName.sendKeys(name);
	}

	public void selectIndustry(String industry) {
		Select select = new Select(Industry);
		select.selectByVisibleText(industry);
	}

	public void selectType(String type) {
		Select select = new Select(Type);
		select.selectByVisibleText(type);
	}

	public void otherPhone(String value) {
		OtherPhone.sendKeys(value);
	}

	public void fax(String value) {
		Fax.sendKeys(value);
	}

	public void officePhone(StringBuilder value) {
		PhoneNo.sendKeys(value);
	}

	public void email(String value) {
		Email.sendKeys(value);
	}

	public void annualRevenue(String value) {
		AnnualRevenue.sendKeys(value);
	}

	public void ownership(String value) {
		Ownership.sendKeys(value);
	}

	public void clickSaveButton() {
		Savebtn.click();
	}

	public void startDate(String Date) {
		StartDate.clear();
		StartDate.sendKeys(Date);
	}

	public void endDate(String Date) {
		EndDate.click();
		EndDate.sendKeys(Date);
	}

}
