package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class LeadsInfoPage {
	WebDriver driver;

	public LeadsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement leadHeader;

	@FindBy(id = "dtlview_First Name")
	private WebElement firstName;

	@FindBy(id = "dtlview_Last Name")
	private WebElement lastName;

	@FindBy(id = "dtlview_Mobile")
	private WebElement mobileNumber;

	@FindBy(id = "dtlview_Lead Source")
	private WebElement leadSource;

	@FindBy(id = "dtlview_Industry")
	private WebElement leadIndustry;

	@FindBy(id = "dtlview_Lead Status")
	private WebElement leadStatus;

	@FindBy(id = "dtlview_Rating")
	private WebElement leadRating;
}
