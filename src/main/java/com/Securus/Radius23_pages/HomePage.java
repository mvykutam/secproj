package com.Securus.Radius23_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Securus.Radius23_utilities.Log;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		Log.log.info("HomePage page driver");
		super.driver = driver;
	}

	public WebElement loginLink() {
		Log.log.info("loginlink element");
		//return Element("xpath", "//a[@ng-click='login()']"); --old link
		return Element("xpath", "//ul[@class='nav navbar-nav navbar-right']//a[@href='#/login']");
		
	}

	public WebElement signUpLink() {
		Log.log.info("Signuplink element");
		//return Element("xpath", "//a[@href='#/signup']");old singp link
		return Element("xpath","//ul[@class='nav navbar-nav navbar-right']//a[@href='#/signup']");
        //return Element("xpath","//a[@href='#/signup']//button[@class='btn btn-primary']");
	}

	public WebElement landingPageAccountNavMenu() {
		// return Element("xpath", "//a[@id='profile-firstname']
		// [@name='profile-firstname']");
		Log.log.info("Accountnav element");
		return Element("xpath", "//ul[@class='nav navbar-nav navbar-right user-menu']//li[@class='dropdown']");
	}

	public WebElement accountNavProfile() {
		Log.log.info("Accountnav element");
		return Element("xpath", "//a[contains(text(),'My Profile')] [@href='#/Profile']");

	}

	public WebElement accountNavMyCases() {
		Log.log.info("accountNavMyCases link element");
		return Element("xpath", "//a[contains(text(),'My Cases')] [@href='#/Case/Case']");

	}

	public WebElement accountNavMyPrograms() {
		Log.log.info("accountNavMyPrograms link element");
		return Element("xpath", "//a[contains(text(),'My Programs')] [@href='#/Program/MyProgram']");
	}

	public WebElement accountNavMyDocuments() {
		Log.log.info("accountNavMyDocuments link element");
		return Element("xpath", "//a[contains(text(),'My Documents')][@href='#/Document/DocumentUpload']");
	}

	public WebElement accountNavMyFavorities() {
		Log.log.info("accountNavMyFavorities link  element");
		return Element("xpath", "//a[contains(text(),'My Favorites')][@href='#/Profile/MyFavorite']");
	}

	public WebElement accountNavMySelfAssessment() {
		Log.log.info("accountNavMySelfAssessment link element");
		return Element("xpath", "//a[contains(text(),'Self Assessment')] [@href='#/DischargePlan/SelfAssesment']");
	}

	public WebElement accountNavReleaseOfInformation() {
		Log.log.info("accountNavReleaseOfInformation link element");
		return Element("xpath",
				"//a[contains(text(),'Release of Information')] [@href='#/DischargePlan/DischargeROI']");
	}

	public WebElement accountNavLifePlan() {
		Log.log.info("accountNavLifePlan link element");
		return Element("xpath", "//a[contains(text(),'Life Plan')] [@href='#/DischargePlan/LifePlanDetail']");
	}

	public WebElement accountNavMessageCenter() {
		Log.log.info("accountNavMessageCenter link element");
		return Element("xpath", "//a[contains(text(),'Message Center')] [@href='#/MessageCenter/MailMessage']");
	}

	public WebElement accountNavlogOut() {
		Log.log.info("accountNavlogOut link element");
		return Element("xpath", "//a[@id='usermenu-logout']");
	}

	//below method for checking Admin tile for after login of admin&client
	
	public WebElement admin_Client_TileAdmin() {
		Log.log.info("admin_Client_TileAdmin element");
		return Element("xpath", "//a[@id='admin']");
	}
	
	// below method checking application tile for Resource user after login

	public WebElement ResourceApplicationTile() {
		Log.log.info("ResourceApplicationTile  element");
		return Element("xpath", "//a[@name='application']");
	}

	// below method for rightnav image icon clicking of resource, Admin, client for logout
	
	public WebElement Resource_Admin_Client_ImgIconClick() {
		Log.log.info("Resource_Admin_Client_ImgIconClick element");
		return Element("xpath", "//img[@id='admin-profile']");

	}

	// below method for logout button rightnav image icon of resource, Admin,
	// client
	public WebElement ResourceAdminClientLogout_link() {
		Log.log.info("ResourceAdminClientLogout_link element");
		return Element("xpath", "//a[@id='index-logout']");

	}
	

	// offender and public logout
	public void public_Offender_logout() {
		landingPageAccountNavMenu().click();
		accountNavlogOut().click();
		Log.log.info("public_Offender_logout method");
	}
	

	// Logout operation for Resource, Admin, client
	public void Resource_Admin_Client_Logout() {
		Resource_Admin_Client_ImgIconClick().click();
		ResourceAdminClientLogout_link().click();
		Log.log.info("Resource_Admin_Client_Logout method");
	}

}
