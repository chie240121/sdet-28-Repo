package com.crm.comcast.GenricUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass extends BaseClass implements ITestListener {

	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testCaseName = result.getMethod().getMethodName();
		System.out.println(testCaseName);

		
		// take screen shot code
		EventFiringWebDriver event = new EventFiringWebDriver(BaseClass.sdriver);
		File source = event.getScreenshotAs(OutputType.FILE);
		File destination = new File("./errorshot/"+testCaseName+ jUtility.getsystemDateAndTime() +".png");
		try {
			FileUtils.copyFile(source, destination);
			// source.renameTo(destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
	
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	}

}
