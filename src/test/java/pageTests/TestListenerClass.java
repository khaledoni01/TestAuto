package pageTests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;


public class TestListenerClass extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = extent.startTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, "Test Case Passed is: "+result.getName());
		extent.endTest(test);
	}

	public void onTestFailure(ITestResult result) {
		
//		String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		
		String filePath = System.getProperty("user.dir")+"/screenshot/failed_"+ result.getMethod().getMethodName()+".png";
		TakesScreenshot scrShot = (TakesScreenshot) TestBase.driver;
		File scrFile= scrShot.getScreenshotAs(OutputType.FILE);
		File desFile = new File(filePath);
		try {
			FileUtils.copyFile(scrFile, desFile);
		} 
		catch (IOException e) {
			e.printStackTrace(); 
		}
        String base64FailedScreenshot = "data:image/png;base64," + ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BASE64);
        test.log(LogStatus.FAIL, "Test Case Failed is: "+result.getName() + test.addBase64ScreenShot(base64FailedScreenshot));
		test.log(LogStatus.FAIL, "Exception: "+result.getThrowable());
		extent.endTest(test);
	}

	public void onTestSkipped(ITestResult result) {
		
		if(TestBase.driver != null) {
	      String base64SkippedScreenshot = "data:image/png;base64," + ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BASE64);
	      test.log(LogStatus.SKIP, "Test Case Skipped is: "+result.getName() + test.addBase64ScreenShot(base64SkippedScreenshot));		
		}
        test.log(LogStatus.SKIP, "Test Case Skipped is: "+result.getName()+" - "+ result.getThrowable());
		extent.endTest(test);
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

}
