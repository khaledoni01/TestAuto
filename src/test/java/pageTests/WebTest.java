package pageTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageActions.IndexActions;
import utility.ExcelUtil;

public class WebTest extends TestBase {

	
	@DataProvider(name="loginData")
	public static Object[][] loginData() {
		return ExcelUtil.getExcelData("./data/testing.xlsx", "Sheet1");
	}
	
	@Test(groups={"regression"}, dataProvider = "loginData")
	public void testOne(String username, String password) {
		indexActions.login(username, password);
	}
	
}
