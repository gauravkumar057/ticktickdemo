package org.gauravdemo.Listeners;

import java.io.IOException;
import org.gauravdemo.Reports.ExtentLogger;
import org.gauravdemo.Reports.ExtentManager;
import org.gauravdemo.Reports.ExtentReport;
import org.gauravdemo.utils.ScreenshotUtils;
import org.gaurvademo.annotations.FrameworkAnnotation;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumDriver;


public class CustomTestListener implements ITestListener, ISuiteListener {
	
	ExtentTest test;
	AppiumDriver driver;
	

	@Override
    public void onStart(ITestContext context) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            ExtentReport.flushReports();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
        ExtentReport.addAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Do nothing
		ExtentLogger.pass(result.getMethod().getMethodName() +" is passed");
		
		// Capture and add a screenshot to the extent report
        try {
            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
            
            String screenshotPath = ScreenshotUtils.getScreenshotPath(result.getMethod().getMethodName(), driver);
            ExtentManager.getExtentTest().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
 
           // String screenshotPath = ScreenshotUtils.getScreenshotPath(result.getMethod().getMethodName(), driver);
           // test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
        } catch (Exception e) {
            e.printStackTrace();
        }	
    }

    @Override
    public void onTestFailure(ITestResult result) {
        
    	// Get the ExtentTest instance from the ExtentManager (assuming it's correctly implemented)
        //ExtentTest test = ExtentManager.getExtentTest();

        // Log the test failure in the extent report
       // test.fail(result.getThrowable());

        // Log the test failure in custom log (assuming ExtentLogger is correctly implemented)
        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed");
        ExtentLogger.fail(result.getThrowable().toString());

        // Capture and add a screenshot to the extent report
        try {
            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
            
            String screenshotPath = ScreenshotUtils.getScreenshotPath(result.getMethod().getMethodName(), driver);
            ExtentManager.getExtentTest().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
 
           // String screenshotPath = ScreenshotUtils.getScreenshotPath(result.getMethod().getMethodName(), driver);
           // test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
        } catch (Exception e) {
            e.printStackTrace();
        }	
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Do nothing
    	//test.log(Status.SKIP, "Test Skipped");
    	ExtentLogger.skip(result.getMethod().getMethodName() + " is skiped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Do nothing
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // Do nothing
    }
}
