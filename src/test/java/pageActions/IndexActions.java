package pageActions;

import org.openqa.selenium.support.PageFactory;

import pageLocators.IndexLocators;
import pageTests.TestBase;
import utility.CommonActions;

public class IndexActions {

	IndexLocators indexLocators = null;
	
	public IndexActions() {
		indexLocators = new IndexLocators();
		PageFactory.initElements(TestBase.driver, indexLocators);
	}
	
	public void login(String username, String password) {
		CommonActions.sendKeys(indexLocators.username, username);
		CommonActions.sendKeys(indexLocators.password, password);
		CommonActions.click(indexLocators.submitBtn);
		CommonActions.report("Login steps are done");
	}
	
	public void gotoSecondPage() {
		indexLocators.secondPageLink.click();
		CommonActions.report("Link is clicked");
		
		TestBase.secondActions = TestBase.secondActionsObject();
	}
}
