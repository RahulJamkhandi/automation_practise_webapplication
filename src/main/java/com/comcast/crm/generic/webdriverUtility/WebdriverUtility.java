package com.comcast.crm.generic.webdriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	
	public void minimizeScreen(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public void maximizeScreen(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForAlertToBePresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchToTabOnURL(WebDriver driver, String parrialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String windowID = (String) iterator.next();
			driver.switchTo().window(windowID);

			String actURL = driver.getCurrentUrl();
			if (actURL.contains(parrialURL)) {
				break;
			}
		}
	}

	public void switchToTabOnTitle(WebDriver driver, String parrialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String windowID = (String) iterator.next();
			driver.switchTo().window(windowID);

			String actTitle = driver.getTitle();
			if (actTitle.contains(parrialTitle)) {
				break;
			}
		}
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
		
	}
	
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void sendKeysToPopUp(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public void select(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void deSelect(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	
	public void deSelect(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}
	
	public void deSelectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
	public List getAllSelectedElements(WebElement element) {
		Select select = new Select(element);
		return select.getAllSelectedOptions();
	}
	
	public List getAllOptions(WebElement element) {
		Select select = new Select(element);
		return select.getOptions();
	}
	
	public void mouseMoveOnElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	public void scrollTo(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.scrollToElement(element).perform();
	}
	
}
