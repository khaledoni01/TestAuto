package pageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends TestBase {

	@Test(groups= {"regression"})
	public void alertTest() {
		indexActions.gotoSecondPage();
		secondActions.alertAction();
	}
}
