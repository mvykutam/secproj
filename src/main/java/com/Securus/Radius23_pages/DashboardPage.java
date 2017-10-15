package com.Securus.Radius23_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage{

	
	public DashboardPage(WebDriver driver)
	{
		super.driver=driver;
	}
	
	
	public WebElement landingPageAccountNavMenuClick()
	{
		return Element("xpath","//a[@class='dropdown-toggle pull-right link'][@data-toggle='dropdown']");
	}
	
	
	public WebElement accountNavProfile()
	{
		return Element("xpath","//a[contains(text(),'My Profile')] [@href='#/Profile']");
		
	}
	
	public WebElement accountNavMyCases()
	{
		return Element("xpath","//a[contains(text(),'My Cases')] [@href='#/Case/Case']");
		
	}
	
	public WebElement accountNavMyPrograms()
	{
		return Element("xpath","//a[contains(text(),'My Programs')] [@href='#/Program/MyProgram']");
	}
	
	public WebElement accountNavMyDocuments()
	{
		return Element("xpath","//a[contains(text(),'My Documents')][@href='#/Document/DocumentUpload']");
	}
	
	public WebElement accountNavMyFavorities()
	{
		return Element("xpath","//a[contains(text(),'My Favorites')][@href='#/Profile/MyFavorite']");
	}
	
	public WebElement accountNavMySelfAssessment()
	{
		return Element("xpath","//a[contains(text(),'Self Assessment')] [@href='#/DischargePlan/SelfAssesment']");
	}
	
	public WebElement accountNavReleaseOfInformation()
	{
		return Element("xpath","//a[contains(text(),'Release of Information')] [@href='#/DischargePlan/DischargeROI']");
	}
	
	public WebElement accountNavLifePlan()
	{
		return Element("xpath","//a[contains(text(),'Life Plan')] [@href='#/DischargePlan/LifePlanDetail']");
	}
	
	public WebElement accountNavMessageCenter()
	{
		return Element("xpath","//a[contains(text(),'Message Center')] [@href='#/MessageCenter/MailMessage']");
	}
	
	public WebElement accountNavlogOut()
	{
		return Element("xpath","//a[contains(text(),'Logout')] [@href='# ng-click=']");
	}
	
}

