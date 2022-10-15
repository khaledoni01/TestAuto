package pageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import pageActions.IndexActions;
import pageActions.SecondActions;

public class TestBase {
	
	public static WebDriver driver = null;
		
	@BeforeSuite(alwaysRun=true)
	@Parameters({"baseURL", "browserVersion"})
	public void launchBrowser(String baseURL, String browserVersion) {
		
		System.setProperty("webdriver.chrome.driver", browserVersion);
		driver = new ChromeDriver();
		driver.get(baseURL);
		
		indexActions = indexActionsObject();
	}
	
//	@AfterSuite(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
		driver.quit();
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
