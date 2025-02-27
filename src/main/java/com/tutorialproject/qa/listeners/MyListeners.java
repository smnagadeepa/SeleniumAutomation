package com.tutorialproject.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorials.qa.utils.ExtentReporter;
import com.tutorials.qa.utils.Utilities;

public class MyListeners implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;
	WebDriver driver=null;
	
	@Override
	public void onTestStart(ITestResult result) {
		extentTest=extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName()+" has started execution");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest=extentReport.createTest(result.getName());
		extentTest.log(Status.PASS, result.getName()+" has successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(Utilities.captureScreenshot(driver, result.getName()));
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName()+" has failed to execute");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+" got skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		extentReport=ExtentReporter.generateExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		String pathForExtentReport=System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.html";
		File extentReport=new File(pathForExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

