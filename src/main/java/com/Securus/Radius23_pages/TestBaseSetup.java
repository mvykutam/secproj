package com.Securus.Radius23_pages;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.Securus.Radius23_utilities.ExcelUtil;
import com.Securus.Radius23_utilities.Log;
import com.Securus.Radius23_utilities.PropertyUtil;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseSetup {

	public String module = null;

	public WebDriver driver = null;
	

	private void setDriver(String browserType, String appURL) {
		Log.log.info("setting the browser:"+browserType);
		ChromeDriverManager.getInstance().setup();
		FirefoxDriverManager.getInstance().setup();
		OperaDriverManager.getInstance().setup();
		PhantomJsDriverManager.getInstance().setup();
		EdgeDriverManager.getInstance().setup();
		InternetExplorerDriverManager.getInstance().setup();
		
		driver = initChromeDriver(appURL);

		if (browserType.equalsIgnoreCase("chrome")) {
			Log.log.info("Initilizition chrome browser");
			driver = initChromeDriver(appURL);
		} else if (browserType.equalsIgnoreCase("firefox")) {
			Log.log.info("Initilizition firefox browser");
			driver = initChromeDriver(appURL);
		} else if (browserType.equals("ie")) {
			Log.log.info("Initilizition ie browser");
			driver = initIEDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
//		driver.get(appURL);
		return driver;
	}

	private static WebDriver initIEDriver(String appURL) {
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
//		driver.get(appURL);
		return driver;
	}

	@BeforeClass
	public void initializeTestBaseSetup() {
		
		Log.log.info("In before class for initializing browser");
		setDriver(PropertyUtil.getValuforKey("browser"), PropertyUtil.getValuforKey("url"));
		
	}

	@AfterClass
	public void closeBrowser() {
		Log.log.info("In After class to Quit the browser");
		driver.quit();
	}

	@BeforeMethod
	public void setApplicationToPreviousState() {
		
		try {
			Log.log.info("In Before method, Waiting for some time to load the URL");
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.log.info("In Before method to load the URL");
		driver.navigate().to(PropertyUtil.getValuforKey("url"));
	}
	
	
	
	@DataProvider(name = "excelData")
	public Object[][] getData(Method method) {
		int totalRowRount=0;
		List<List<Object>> allRowsData=null;
		Object[][] excelData = null;
		ExcelUtil excelUtil = new ExcelUtil("src/main/resources/TestDataFile.xls");
		allRowsData = new ArrayList<List<Object>>();
		String module = this.getClass().getSimpleName();
		String testName = method.getName();
		totalRowRount=excelUtil.getRowCount(module);
		for (int row = 0; row < totalRowRount; row++) {
			int columnCount=0;
			
			if (excelUtil.getCellData(module, row, 0).trim().equalsIgnoreCase(testName)) {
				columnCount=excelUtil.getColumnCount(module, row); //sheetname ,rowcount
				List<Object> rowData=new ArrayList<Object>();
				for(int column=1;column<columnCount;column++)
				{
					rowData.add(excelUtil.getCellData(module, row, column));
				}
				allRowsData.add(rowData);
			}			
			
		}
		
		
		excelData = new Object[allRowsData.size()][];
		int i=0;
		
		for(List<Object> rowData:allRowsData)
		{
			excelData[i++]=rowData.toArray(new Object[rowData.size()]);//excelData[0]=rowData1, excelData[1]=rowData2
		}
		
		return excelData;
		
	}

//	@DataProvider(name = "excelData")
//	public Object[][] getData(Method method) {
//		int columnCount = 0;
//		int rowNumber = 0;
//		String module = this.getClass().getSimpleName();
//		String testName = method.getName();
//		Log.log.info("I am Reading data for Testclass:" + module + ",TestName:" + testName);
//		Object[][] excelData = null;
//		ExcelUtil excelUtil = new ExcelUtil("src/main/resources/TestDataFile.xls");
//		for (int i = 1; i < excelUtil.getRowCount(module); i++) {
//			if (excelUtil.getCellData(module, i, 0).trim().equalsIgnoreCase(testName)) {
//				columnCount = excelUtil.getColumnCount(module, i); //sheetname ,rowcount
//				rowNumber = i;
//				break;
//			}
//		}
//		excelData = new String[1][columnCount - 1];
//		for (int j = 1; j < columnCount; j++) {
//			excelData[0][j-1] = excelUtil.getCellData(module, rowNumber, j); 
//
//		}
//
//		return excelData;
//
//	}
//
	public WebDriver getDriver() {
		return driver;
	}

	
	
	
	
	
}
