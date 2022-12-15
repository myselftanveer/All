package libraryApi;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners  implements ITestListener {
	
	

	public static ExtentTest test;
	ExtentReports extent = resources.LibraryApiExtentReport.getApiReport();

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Test Passed");
	

	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.fail(result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
