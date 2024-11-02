package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import lombok.Getter;

@Getter
public class CreateLeadsPage {

	WebDriver driver;

	public CreateLeadsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstname")
	private WebElement leadFirstNameTF;

	@FindBy(name = "lastname")
	private WebElement leadLastNameTF;

	@FindBy(name = "company")
	private WebElement companyTF;

	@FindBy(name = "leadsource")
	private WebElement leadSourceDD;

	@FindBy(name = "industry")
	private WebElement industryDD;

	@FindBy(name = "leadstatus")
	private WebElement leadstatusDD;

	@FindBy(name = "rating")
	private WebElement ratingDD;
	
	@FindBy(id = "mobile")
	private WebElement mobileNumber;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement Savebtn;

	public void enterFirstName(String first_Name) {
		leadFirstNameTF.sendKeys(first_Name);
	}

	public void enterLastName(String last_Name) {
		leadLastNameTF.sendKeys(last_Name);
	}
	
	public void enterCompanyName(String comp_Name) {
		companyTF.sendKeys(comp_Name);
	}
	
	public void enterMobileNumber(StringBuilder moNumber) {
		mobileNumber.sendKeys(moNumber);
	}

	public void selectLeadSource(String ls) {
		Select select = new Select(leadSourceDD);
		select.selectByVisibleText(ls);
	}

	public void selectLeadIndustry(String ind) {
		Select select = new Select(industryDD);
		select.selectByVisibleText(ind);
	}

	public void selectLeadStatus(String stat) {
		Select select = new Select(leadstatusDD);
		select.selectByVisibleText(stat);
	}

	public void selectLeadRating(String rating) {
		Select select = new Select(ratingDD);
		select.selectByVisibleText(rating);
	}

	public void saveLead() {
		Savebtn.click();
	}

}
