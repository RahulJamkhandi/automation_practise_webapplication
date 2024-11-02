package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class OrganizationsPage {

	WebDriver driver;

	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrg;
	@FindBy(name = "search_text")
	private WebElement SearchOrg;
	@FindBy(name = "submit")
	private WebElement SearchBtn;
	@FindBy(partialLinkText = "Advanced")
	private WebElement AdvancedSearch;
	@FindAll({ @FindBy(id = "bas_searchfield"), @FindBy(name = "search_field") })
	private WebElement OrgDropdown;

	public WebElement getCreateOrg() {
		return CreateOrg;
	}

	public WebElement getSearchOrg() {
		return SearchOrg;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getOrgDropdown() {
		return OrgDropdown;
	}

	public WebElement getAdvancedSearch() {
		return AdvancedSearch;
	}

	// Business Methods

	public void createOrg() {
//		getCreateOrg().click();
		CreateOrg.click();
	}

	public void searchOrg(String OrgName) {
//		getSearchOrg().sendKeys(OrgName);
		SearchOrg.sendKeys(OrgName);
	}

	public void searchButton() {
//		getSearchBtn().click();
		SearchBtn.click();
	}

}
