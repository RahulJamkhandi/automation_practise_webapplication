package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.WebdriverUtility;

public class AmazonProdcutInfoTest {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brand, String product) throws Throwable {
		FileUtility fileUtility = new FileUtility();
		WebdriverUtility webdriverUtility = new WebdriverUtility();
		String BROWSER = fileUtility.getDataFromPropertiesFile("browser");
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();

		System.out.println(brand + ": " + product);
		driver.get("https://www.amazon.in/");
		webdriverUtility.maximizeScreen(driver);
		webdriverUtility.waitForPageToLoad(driver);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brand, Keys.ENTER);
		String xpth = "//span[text()='" + product
				+ "']/../../../../div[3]/div[1]/div/div/div/div/a/span/span[2]/span[2]";
		String text = driver.findElement(By.xpath(xpth)).getText();
		System.out.println(text);
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility excelUtility = new ExcelUtility();
		int rowCount = excelUtility.rowCount("Sheet5");
		Object[][] objArr = new Object[rowCount][2];

		for (int i = 0; i < rowCount; i++) {
			objArr[i][0] = excelUtility.getDataFromExcel("Sheet5", i + 1, 0);
			objArr[i][1] = excelUtility.getDataFromExcel("Sheet5", i + 1, 1);
		}
		/*
		 * objArr[0][0] = "iphone"; objArr[0][1] =
		 * "Apple iPhone 16 (128 GB) - Ultramarine";
		 * 
		 * objArr[1][0] ="iphone"; objArr[1][1] ="Apple iPhone 15 (128 GB) - Yellow";
		 * 
		 * objArr[2][0] ="iphone"; objArr[2][1] ="Apple iPhone 13 (128GB) - Starlight";
		 */
		return objArr;
	}

}
