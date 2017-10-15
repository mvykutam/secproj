package com.Securus.Radius23_TestScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Securus.Radius23_pages.DashboardPage;
import com.Securus.Radius23_pages.HomePage;
import com.Securus.Radius23_pages.LoginPage;
import com.Securus.Radius23_pages.TestBaseSetup;
import com.Securus.Radius23_utilities.ExcelUtil;

public class LoginPageTest extends TestBaseSetup {
	
	
     //Public login user
	@Test(dataProvider = "excelData")
	public void verifyPublicLoginWithValidInput(String userName, String password) {
		HomePage home = new HomePage(driver);
		home.loginLink().click();
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(userName, password);
		boolean status = home.isElementDisplayed(home.landingPageAccountNavMenu());
		home.public_Offender_logout();
		System.out.println("public user logout successfull");
		assertTrue(status);
	}

	@Test(dataProvider = "excelData")
	public void verifyPublicLoginWithInValidInput(String userName, String password, String verificationString) {

		HomePage home = new HomePage(driver);
		home.loginLink().click();
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(userName, password);
		assertTrue(login.inValidPopup().getText().contains(verificationString));
	}
     //Offender Login user
	@Test(dataProvider = "excelData")
	public void verifyOffenderLoginWithValidInput(String userName, String password) {
		HomePage home = new HomePage(driver);
		home.loginLink().click();
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(userName, password);
		boolean status = home.isElementDisplayed(home.landingPageAccountNavMenu());
		home.public_Offender_logout();
		System.out.println("Offender user logout successfull");
		assertTrue(status);
	}

	// Resource login user
	@Test(dataProvider = "excelData")
	public void verifyResourceLoginWithValidInput(String userName, String password) {
		HomePage home = new HomePage(driver);
		home.loginLink().click();
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(userName, password);
		boolean applicationtile = home.isElementDisplayed(home.ResourceApplicationTile());
		home.Resource_Admin_Client_Logout();;
		System.out.println("Resource user logout successfull");
		assertTrue(applicationtile);
	}

	
	// After login different webpage Expirience for below users.
	 //Client login user

	@Test(dataProvider = "excelData")
	public void verifyClientLoginWithValidInput(String userName, String password) {
		HomePage home = new HomePage(driver);
		home.loginLink().click();
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(userName, password);
		boolean admintileofclientpresent = home.isElementDisplayed(home.admin_Client_TileAdmin());
		home.Resource_Admin_Client_Logout();
		System.out.println("Client user logout successfull");
		assertTrue(admintileofclientpresent);
	}

	//Admin login user
	@Test(dataProvider = "excelData")
	public void verifyAdminLoginWithValidInput(String userName, String password) {
		HomePage home = new HomePage(driver);
		home.loginLink().click();
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(userName, password);
		boolean admintilepresent = home.isElementDisplayed(home.admin_Client_TileAdmin());
		home.Resource_Admin_Client_Logout();
		System.out.println("Admin user logout successfull");
		assertTrue(admintilepresent) ;
	}

}

/*
 * @BeforeClass public void beforeClass() { module="Login"; }
 * 
 * @Test(dataProvider="excelData") public void verifyLogin(String
 * userName,String password,String verificationString) {
 * 
 * HomePage home=new HomePage(driver); home.loginLink().click(); LoginPage login
 * = new LoginPage(driver); login.loginToApplication(userName, password);
 * if(verificationString.startsWith("success")) { boolean
 * status=home.isElementDisplayed(home.landingPageAccountNavMenu());
 * home.logout(); assertTrue(status); } else {
 * assertTrue(login.inValidPopup().getText().contains(verificationString.split(
 * ":")[1])); }
 * 
 * 
 * }
 */
