package assertionsPractiseTest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest {

	@Test
	public void verifyUserInHomePageTest(Method method) {
		System.out.println(method.getName() + " Test START");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();

		String actualTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		String expectedTitle = "Home";
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.close();
		System.out.println(method.getName() + " Test END");
	}

	@Test
	public void verifYHomePageLogoDisplayedTest(Method method) {
		System.out.println(method.getName() + " Test START");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();

		boolean logo = driver.findElement(By.xpath("//img[@title = 'vtiger-crm-logo.gif']")).isEnabled();
		Assert.assertTrue(logo);
		driver.close();
		System.out.println(method.getName() + " Test END");
	}

}
