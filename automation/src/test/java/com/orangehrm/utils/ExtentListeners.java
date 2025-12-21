package com.orangehrm.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.orangehrm.base.BaseTest;

public class ExtentListeners implements ITestListener{
	
	WebDriver driver;
	private static ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = ExtentManager.getReporter().createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed", null);
		test.log(Status.FAIL, result.getThrowable());
	
	try {
		WebDriver driver = ((BaseTest) result.getInstance()).driver;
		String screenshotPath = ScreenshotUtils.takeScreenShot(driver, result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(screenshotPath);
	}catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) { // --> this line tells that the method is overridden from ITestListener interface
		test.log(Status.SKIP, "Test Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.getReporter().flush();
	}
	}