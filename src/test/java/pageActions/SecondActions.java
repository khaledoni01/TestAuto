package pageActions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageLocators.SecondLocators;
import pageTests.TestBase;

public class SecondActions {

	SecondLocators secondLocators = null;

	
	public SecondActions() {
		secondLocators = new SecondLocators();
		PageFactory.initElements(TestBase.driver, secondLocators);
	}
	
	public void alertAction() {
		WebDriverWait wait = new WebDriverWait(TestBase.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(secondLocators.alertBtn));
		
		secondLocators.alertBtn.click();
		TestBase.driver.switchTo().alert().accept();
	}
	
}
