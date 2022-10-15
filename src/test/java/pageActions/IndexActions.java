package pageActions;

import org.openqa.selenium.support.PageFactory;

import pageLocators.IndexLocators;
import pageTests.TestBase;

public class IndexActions {

	IndexLocators indexLocators = null;
	
	public IndexActions() {
		indexLocators = new IndexLocators();
		PageFactory.initElements(TestBase.driver, indexLocators);
	}
	
	public void login() {
		indexLocators.username.sendKeys("Username");
		indexLocators.password.sendKeys("Password");
		indexLocators.submitBtn.click();
	}
	
	public void gotoSecondPage() {
		indexLocators.secondPageLink.click();
		
		TestBase.secondActions = TestBase.secondActionsObject();
	}
}
