package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class VendorInfoPage {
	WebDriver driver;

	public VendorInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "Duplicate")
	private WebElement duplicateBtn;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement Savebtn;
	
	@FindBy(id = "dtlview_Vendor Name")
	private WebElement vendorName;
	
	@FindBy(className = "lvtHeaderText")
	private WebElement vendorHeader;
	
	public void clickDuplicateVendor() {
		duplicateBtn.click();
	}

	public void clickSaveButton() {
		Savebtn.click();
	}

}
