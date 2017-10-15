package com.Securus.Radius23_utilities;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Securus.Radius23_pages.TestBaseSetup;

public class MyListener implements ITestListener{
	
			
	String filePath = "src/test/resources/screenshots/";

	public void onTestStart(ITestResult result) {
		Log.log.info("Starting Test:"+result.getName()+" in class:"+result.getInstanceName());				
	}

	public void onTestSuccess(ITestResult result) {
		
		Log.log.info("\n Success Test:"+result.getName()+" in class:"+result.getInstanceName());
		
	}

	public void onTestFailure(ITestResult result) {
		
		Log.log.error("\n Test Name:"+result.getName()+" fail in class:"+result.getInstanceName()+" and taking screenshot");
		
    	String methodName=result.getName().toString().trim();
    	String className=result.getInstanceName();
    	Object currentClass = result.getInstance();
        WebDriver driver =  ((TestBaseSetup) currentClass).getDriver();
    	DateFormat dateFormat = new SimpleDateFormat("MM_dd_YYYY_HH_mm_ss");
		Date date = new Date();
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
				FileUtils.copyFile(scrFile, new File(filePath+className+File.separator+methodName+dateFormat.format(date)+".png"));
			} catch (Exception e) {
				e.printStackTrace();
				Log.log.error("\n Test Name:"+result.getName()+" fail in class:"+result.getInstanceName()+" while taking screenshot");
			}
	}

	
	public void onTestSkipped(ITestResult result) {
		Log.log.info("\n Skipped Test:"+result.getName()+" in class:"+result.getInstanceName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub	
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
