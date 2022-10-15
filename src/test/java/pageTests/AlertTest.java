package pageTests;

import org.testng.annotations.Test;

public class AlertTest extends TestBase {

	@Test(groups= {"regression"})
	public void alertTest() {
		secondActions.alertAction();
	}
}
