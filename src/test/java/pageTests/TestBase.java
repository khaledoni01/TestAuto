package pageTests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageActions.IndexActions;
import pageActions.SecondActions;

public class TestBase {
	
	public static WebDriver driver = null;
	public static ExtentReports extent;
	public static ExtentTest test;

		
	@BeforeSuite(alwaysRun=true)
	@Parameters({"baseURL", "browserVersion"})
	public void launchBrowser(String baseURL, String browserVersion) {
		TestBase.setupExtentReport();
		System.setProperty("webdriver.chrome.driver", browserVersion);
		driver = new ChromeDriver();
		driver.get(baseURL);
		
		indexActions = indexActionsObject();
	}
	
	@AfterSuite(alwaysRun=true)
	public void closeBrowser() {
		TestBase.tearDownReport();
//		driver.close();
//		driver.quit();
	}
	
	public static void setupExtentReport() {
		extent = new ExtentReports(
				System.getProperty("user.dir") + "/extentReport/Automation_Report.html", true);

		extent.addSystemInfo("Host Name", "Test Project")
				.addSystemInfo("Environment", "QA Automation Testing")
				.addSystemInfo("User Name", "Khaled");
		extent.loadConfig(new File(System.getProperty("user.dir") + "/src/test/resources/extent-config.xml"));
	}
	public static void tearDownReport() {
		extent.flush();
		extent.close();
	}

	public static IndexActions indexActions = null;
	public static SecondActions secondActions = null;
	
	public static SecondActions secondActionsObject() {
		return new SecondActions();
	}
	public static IndexActions indexActionsObject() {
		return new IndexActions();
	}
	
}
