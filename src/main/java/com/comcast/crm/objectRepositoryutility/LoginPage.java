package com.comcast.crm.objectRepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;

import lombok.Getter;

@Getter
public class LoginPage extends WebdriverUtility{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement usernameTF;
	
	@FindBy(name = "user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement loginBTN;

	public void loginToApp(String username, String password) throws Exception {
		System.out.println("Hiii:"+username+" "+password);
		Thread.sleep(10);
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginBTN.click();
	}

	
}
