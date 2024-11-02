package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class OrganizationInfoPage {
	WebDriver driver;

	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement HeaderText;

	@FindBy(id = "dtlview_Organization Name")
	private WebElement OrgName;

	@FindBy(id = "dtlview_Website")
	private WebElement WebsiteName;

	@FindBy(id = "id=dtlview_Ticker Symbol")
	private WebElement TickerSymbol;

	@FindBy(id = "dtlview_Employees")
	private WebElement Employees;

	@FindBy(id = "dtlview_Industry")
	private WebElement IndustryName;

	@FindBy(id = "dtlview_Type")
	private WebElement TypeName;

	@FindBy(id = "dtlview_Phone")
	private WebElement PhoneNum;

	@FindBy(id = "dtlview_Fax")
	private WebElement FaxNum;

	@FindBy(id = "dtlview_Other Phone")
	private WebElement AlternateNum;

	@FindBy(id = "dtlview_Email")
	private WebElement EmailId;

	@FindBy(id = "dtlview_Ownership")
	private WebElement OwnerName;

	public WebElement getElementText() {
		return HeaderText;
	}

	public void verifyPage(String Value) {
		if ((HeaderText.getText()).contains(Value))
			System.out.println(Value + " is added to Database");
		else
			System.out.println(Value + " is not added to Database");
	}

	public void verifyOrgName(String value) {
		if (OrgName.getText().equalsIgnoreCase(value))
			System.out.println("Organization is created");
		else
			System.out.println("Organization is not created");
	}

	public void verifyIndustry(String Value) {
		if (IndustryName.getText().equalsIgnoreCase(Value))
			System.out.println(Value + " is added...");
		else
			System.out.println(Value + " is not added...");
	}

	public void verifyType(String value) {
		if (TypeName.getText().equalsIgnoreCase(value))
			System.out.println(value + " is added...");
		else
			System.out.println(value + " is not added...");
	}

	public void verifyContact(String value) {
		if (PhoneNum.getText().equalsIgnoreCase(value))
			System.out.println(value + " is added...");
		else
			System.out.println(value + " is not added...");
	}
}
