package com.Securus.Radius23_TestScripts;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Securus.Radius23_pages.HomePage;
import com.Securus.Radius23_pages.LoginPage;
import com.Securus.Radius23_pages.MyContactsPage;
import com.Securus.Radius23_pages.TestBaseSetup;
import com.Securus.Radius23_utilities.Log;


public class Dummy extends TestBaseSetup{
	
//	
//	
//	
//	@Test(dataProvider = "excelData")
//	public void verifyingLoginWithInValidInput(String x,String y,String z)
//	{
//		System.out.println(System.getProperty("buildtimestamp"));
//		System.out.println(x);
//		System.out.println(y);
//		System.out.println(z);
//		Log.log.info("Testing with dummy.test1 test");
//
//		assertTrue(false);
//	}
//	
//	@Test
//	public void test2()
//	{
//		Log.log.info("Testing with dummy.test2 test");
//
//		assertTrue(true);
//	}
	
	
	@Test
	public void test()
	{
		String date="01/30/2020";
		HomePage homepage =new HomePage(driver);
		homepage.loginLink().click();
		Log.log.info("Clicked on login link on homepage");
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.loginToApplication("vt.madhavi@gmail.com", "Chandu123@");
		Log.log.info("Logged in to applicationand naviagted to homepage");
		System.out.println(driver.findElement(By.xpath("//div[@id='ajax-loader']")).getAttribute("style"));
		System.out.println(driver.findElement(By.xpath("//div[@id='ajax-loader']")).getAttribute("style"));

		homepage.landingPageAccountNavMenu().click();
		Log.log.info("Clicked on  account nav menu");
		homepage.accountNavProfile().click();
		Log.log.info("Clicked on profile link on account nav menu ");
		

		MyContactsPage mycontactspage = new MyContactsPage(driver);
		mycontactspage.myContactsTile().click();
		Log.log.info("Clicked on Mycontacts tile in profile page");
		//checking myContactsdetailsAddButton element is displayed or not.
		boolean status = mycontactspage.isElementDisplayed(mycontactspage.myContactsdetailsAddButton());
		Log.log.info("Add mycontact details button is displayed");
		mycontactspage.myContactsdetailsAddButton().click();
		mycontactspage.myContactAssignPermissions_CheckBox().click();
		mycontactspage.myContactFromDateInput().click();
		mycontactspage.selectDate(date);
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
		
		
		HomePage homepage =new HomePage(driver);
		homepage.loginLink().click();
		Log.log.info("Clicked on login link on homepage");
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.loginToApplication("vt.madhavi@gmail.com", "Chandu123@");
		Log.log.info("Logged in to applicationand naviagted to homepage");
		
		homepage.landingPageAccountNavMenu().click();
		Log.log.info("Clicked on  account nav menu");
		homepage.accountNavProfile().click();
		Log.log.info("Clicked on profile link on account nav menu ");
		

		MyContactsPage mycontactspage = new MyContactsPage(driver);
		mycontactspage.myContactsTile().click();
		Log.log.info("Clicked on Mycontacts tile in profile page");
		//checking myContactsdetailsAddButton element is displayed or not.
		boolean status = mycontactspage.isElementDisplayed(mycontactspage.myContactsdetailsAddButton());
		Log.log.info("Add mycontact details button is displayed");
		mycontactspage.myContactsdetailsAddButton().click();
		mycontactspage.myContactAssignPermissions_CheckBox().click();
		mycontactspage.myContactFromDateInput().click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

				
		driver.findElement(By.xpath("//table[contains(@aria-activedescendant,'datepicker')]//button[contains(@id,'datepicker')]")).click();

		while(true)
		{
			if(Integer.valueOf(driver.findElement(By.xpath("//table[contains(@aria-activedescendant,'datepicker')]//button[contains(@id,'datepicker')]")).getText())>Integer.valueOf(wantingYear))
			{
				driver.findElement(By.xpath("//table[contains(@aria-activedescendant,'datepicker')]//i[contains(@class,'glyphicon-chevron-left')]")).click();
			}
			else if(Integer.valueOf(driver.findElement(By.xpath("//table[contains(@aria-activedescendant,'datepicker')]//button[contains(@id,'datepicker')]")).getText())<Integer.valueOf(wantingYear))
			{
				driver.findElement(By.xpath("//table[contains(@aria-activedescendant,'datepicker')]//i[contains(@class,'glyphicon-chevron-right')]")).click();
			}
			else
			{
				break;
			}
		}
		
		System.out.println("done with year selection");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//table[contains(@aria-activedescendant,'datepicker')]//td[contains(@id,'datepicker')]//span[text()='"+wantingMonth+"']")).click();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//table[contains(@aria-activedescendant,'datepicker')]//td[contains(@id,'datepicker')]//span[text()='"+wantingDate+"'][not(contains(@class,'text-muted'))]")).click();
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
