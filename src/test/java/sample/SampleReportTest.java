package sample;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {

	public ExtentReports extentReports;

	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report.html");
		spark.config().setDocumentTitle("Sample CRM Test Suites");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);

		// Envi Info
		extentReports = new ExtentReports();
		extentReports.attachReporter(spark);
		extentReports.setSystemInfo("OS", "Windows-11");
		extentReports.setSystemInfo("BROWSER", "Chrome-110");
	}

	@AfterSuite
	public void configAS() {
		extentReports.flush();
	}

	@Test
	public void createContact() {
		ExtentTest test = extentReports.createTest("Create Contact");
		test.log(Status.INFO, "Login To Application");
		test.log(Status.INFO, "Navigate To Contact Page");
		test.log(Status.INFO, "Create Contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is created");
		} else {
			test.log(Status.FAIL, "Contact is  not created");
		}

	}

	@Test
	public void createWithOrganizationContact() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		String filePath = screenshot.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = extentReports.createTest("Create Contact");
		test.log(Status.INFO, "Login To Application");
		test.log(Status.INFO, "Navigate To Contact Page");
		test.log(Status.INFO, "Create Contact");
		if ("HDC".equals("HDFC")) {
			test.log(Status.PASS, "Contact is created with Organization");
		} else {
			test.addScreenCaptureFromBase64String(filePath,"ErrorFile");
		}
		driver.close();
	}

}
