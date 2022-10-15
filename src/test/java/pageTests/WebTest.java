package pageTests;

import org.testng.annotations.Test;

import pageActions.IndexActions;

public class WebTest extends TestBase {

	@Test(groups={"regression"})
	public void testOne() {
		indexActions.login();
		indexActions.gotoSecondPage();
	}
	
}
