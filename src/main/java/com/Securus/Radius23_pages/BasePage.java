package com.Securus.Radius23_pages;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Securus.Radius23_utilities.PropertyUtil;

public class BasePage {

	WebDriver driver = null;

	public WebElement Element(String locatorType, String locator) // "xpath',
																	/// "//input[contains(text()='abc')]"
	{
//		waitForElement("xpath", "//div[@id='ajax-loader']");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitForElement(locatorType, locator);
		return driver.findElement(elementByLocator(locatorType, locator));
	}

	public By elementByLocator(String locatorType, String locator) {
		By by = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			by = By.xpath(locator);
		} else if (locatorType.equalsIgnoreCase("cssSelector")) {
			by = By.cssSelector(locator);
		} else if (locatorType.equalsIgnoreCase("id")) {
			by = By.id(locator);
		} else if (locatorType.equalsIgnoreCase("name")) {
			by = By.name(locator);
		} else if (locatorType.equalsIgnoreCase("className")) {
			by = By.className(locator);
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			by = By.linkText(locator);
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			by = By.partialLinkText(locator);
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			by = By.tagName(locator);
		}
		return by;
	}

	// To get title of the page.
	public String getTitle() {
		return driver.getTitle();
	}

	// To get the current url of the page.
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	//Getting wait time from property file.
	public void waitForElement(String locatorType, String locator) {
		//System.out.println("waiting for element...");
		int waitTime = Integer.parseInt(PropertyUtil.getValuforKey("maxElementwaitTimeInSeconds"));
		(new WebDriverWait(driver, waitTime))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementByLocator(locatorType, locator)));
	}

	//Another way of writing wait method by passing time as parameter.
	public void waitForElement(String locatorType, String locator, int waitTime) {
		(new WebDriverWait(driver, waitTime))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementByLocator(locatorType, locator)));
	}
	

	//Another way of writing explicit wait. 
	public void waitForElement(WebElement element, int waitTime) {
		(new WebDriverWait(driver, waitTime)).until(ExpectedConditions.visibilityOf(element));
		
	}

	// To check weather Element is displayed or not.
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();	
	}
	
	// To check weather Element is Enabled or not.
	public boolean iselementEnabled(WebElement element)
    {
    return element.isEnabled();	
    }
	
	
	// To check weather Element is Selected or not.
	public boolean iselementSelected(WebElement element)
    {
       return element.isSelected();
       
    }
	
	
		//Ajax drop down selection for state and county fields for register
		public void selectAjaxDDOption(String dropDownLocatorType,String dropdownLocator, String optionToSelect)
	{
		List<WebElement> alloptions=(List<WebElement>) Element(dropDownLocatorType,dropdownLocator).findElements(By.tagName("//ul[@class='dropdown-menu ng-isolate-scope ng-hide']"));
		for(WebElement option:alloptions)
		{
			if(option.getText().contains(optionToSelect))
			{
				option.click();
			}
		}
	}
		//Selenium dropdown another way of writing
	public void selectDropDownoption(String dropDownLocatorType,String dropdownLocator, String optionToSelect)
	{
			
		Select dd= new Select(Element(dropDownLocatorType,dropdownLocator));
		dd.selectByVisibleText(optionToSelect);
			
	}
	 //selenium Dropdown selection 
	public void selectDropDownoption(WebElement ddElement, String optionToSelect)
	{
			
		Select dd= new Select(ddElement);
		dd.selectByVisibleText(optionToSelect);			
	}
	
	public void selectDate(String date)
	 
	{
		   
		String wantingYear=date.split("/")[2];
		String wantingMonth=null;
		String wantingDate=date.split("/")[1];
		
		switch (Integer.valueOf(date.split("/")[0])) {
			case 1:  wantingMonth = "January";       break;
			case 2:  wantingMonth = "February";      break;
			case 3:  wantingMonth = "March";         break;
			case 4:  wantingMonth = "April";         break;
			case 5:  wantingMonth = "May";           break;
			case 6:  wantingMonth = "June";          break;
			case 7:  wantingMonth = "July";          break;
	        case 8:  wantingMonth = "August";        break;
	        case 9:  wantingMonth = "September";     break;
	        case 10: wantingMonth = "October";       break;
	        case 11: wantingMonth = "November";      break;
	        case 12: wantingMonth = "December";      break;
	        default: wantingMonth = "Invalid month"; break;
		}
		
		Element("xpath","//table[contains(@aria-activedescendant,'datepicker')]//button[contains(@id,'datepicker')]").click();

		while(true)
		{
			if(Integer.valueOf(Element("xpath","//table[contains(@aria-activedescendant,'datepicker')]//button[contains(@id,'datepicker')]").getText())>Integer.valueOf(wantingYear))
			{
				Element("xpath","//table[contains(@aria-activedescendant,'datepicker')]//i[contains(@class,'glyphicon-chevron-left')]").click();
			}
			else if(Integer.valueOf(Element("xpath","//table[contains(@aria-activedescendant,'datepicker')]//button[contains(@id,'datepicker')]").getText())<Integer.valueOf(wantingYear))
			{
				Element("xpath","//table[contains(@aria-activedescendant,'datepicker')]//i[contains(@class,'glyphicon-chevron-right')]").click();
			}
			else
			{
				break;
			}
		}
		
		System.out.println("done with year selection");
		
		Element("xpath","//table[contains(@aria-activedescendant,'datepicker')]//td[contains(@id,'datepicker')]//span[text()='"+wantingMonth+"']").click();
		
		Element("xpath","//table[contains(@aria-activedescendant,'datepicker')]//td[contains(@id,'datepicker')]//span[text()='"+wantingDate+"'][not(contains(@class,'text-muted'))]").click();
		
	}	
	
}
	
	
	
	

