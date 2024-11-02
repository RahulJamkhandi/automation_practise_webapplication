package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;

	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(name = "Vendors")
	private WebElement vendorLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement admistratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement logout;

	public void navigateToLeadsPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(leadsLink).perform();
		leadsLink.click();
	}
	public void navigateToCampaignPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(campaignLink).perform();
		campaignLink.click();
	}

	public void navigateToContactsPage() {
		Actions actions = new Actions(driver);
		actions.moveToElement(contactLink).perform();
		contactLink.click();
	}

	public void navigateToMoreLink() {
		Actions actions = new Actions(driver);
		actions.moveToElement(moreLink).perform();
		moreLink.click();

	}

	public void navigateToVendors() {
		Actions actions = new Actions(driver);
		actions.moveToElement(vendorLink).perform();
		vendorLink.click();
	}
	public void logout() throws InterruptedException {
		Actions actions = new Actions(driver);
		Thread.sleep(5000);
		actions.moveToElement(admistratorImg).perform();
		logout.click();
	}
}
