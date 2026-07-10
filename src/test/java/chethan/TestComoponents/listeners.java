package chethan.TestComoponents;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import chethan.resources.ExtendReportNG;

public class listeners implements ITestListener{
	String sc;
	BaseTest bt = new BaseTest();
	WebDriver driver;
	ExtentTest test;
	ExtentReports er=ExtendReportNG.getReport();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	@Override
    public void onTestStart(ITestResult result) {
      test= er.createTest(result.getMethod().getMethodName());
      extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
//        System.out.println("PASSED: " + result.getMethod().getMethodName());
    	
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	try {
    		
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        System.out.println("FAILED: " + result.getMethod().getMethodName());
    	try {
			 sc =bt.getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	test.addScreenCaptureFromPath(sc,result.getMethod().getMethodName());
        System.out.println("Exception: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Execution Started");
    }

    @Override
    public void onFinish(ITestContext context) {
       er.flush();
    }
}
