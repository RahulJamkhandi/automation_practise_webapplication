package com.comcast.crm.objectRepositoryutility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import lombok.Getter;

@Getter
public class CreateNewContactPage {
	WebDriver driver;

	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "salutationtype")
	private WebElement salutationType;

	@FindBy(name = "firstname")
	private WebElement contactFirstName;

	@FindBy(name = "lastname")
	private WebElement contactLastName;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement Savebtn;

	@FindBy(name = "salutationtype")
	private WebElement salutation;

	@FindBy(name = "support_start_date")
	private WebElement supportStartDate;

	@FindBy(name = "support_end_date")
	private WebElement supportEndDate;
	
	@FindBy(xpath = "//span[contains(text(),'Contact Information')]")
	private WebElement contactHeader;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastNameSaved;

	public void enterContactName(String salut, String firstName, String lastName) {
		Select select = new Select(salutation);
		select.selectByVisibleText(salut);
		contactFirstName.sendKeys(firstName);
		contactLastName.sendKeys(lastName);
	}

	public void setCurrentDate() {
		// Define the date format as yyyy-MM-dd
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// Fetch the current date
		LocalDate currentDate = LocalDate.now();
		supportStartDate.sendKeys(currentDate.toString());
	}

	public void setFutureDate() {
		// Define the date format as yyyy-MM-dd
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	    // Fetch the current date and add 30 days
	    LocalDate currentDate = LocalDate.now().plusDays(30);

	    // Format the date to the desired pattern and send it as input
	    supportStartDate.sendKeys(currentDate.format(formatter));
	}

	public void saveContact() {
		Savebtn.click();
	}

}