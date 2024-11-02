package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
@Getter
public class CreateVendorPage {
	
	WebDriver driver;

	public CreateVendorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath = "//img[@title='Create Vendor...']")
	private WebElement newVendor;
	
	@FindBy(name = "vendorname")
	private WebElement vendorName;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement Savebtn;
	
	public void createNewVendor(String vandorName) {
		newVendor.click();
		vendorName.sendKeys(vandorName);
	}
	public void clickSaveButton() {
		Savebtn.click();
	}

}
