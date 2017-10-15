package com.Securus.Radius23_TestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.Securus.Radius23_pages.ChangePasswordPage;
import com.Securus.Radius23_pages.HomePage;
import com.Securus.Radius23_pages.LoginPage;
import com.Securus.Radius23_pages.ProfileUpdatePage;
import com.Securus.Radius23_pages.TestBaseSetup;
import com.Securus.Radius23_utilities.Log;

public class ChangePasswordTest extends TestBaseSetup{

	
	@Test(dataProvider = "excelData")
	public void verifyChangePassword(String Username ,String Password, String currentPassword,String newPassword,String confirmPassword) 
	{
		HomePage homepage=new HomePage(driver);
		homepage.loginLink().click();
		Log.log.info("clicked on login link");
		
		LoginPage login=new LoginPage(driver);
		login.loginToApplication(Username, Password);
		Log.log.info("Loged in to application");
		homepage.landingPageAccountNavMenu().click();
		Log.log.info("clicked on Accountnav menu");
		homepage.accountNavProfile().click();
		Log.log.info("Naviagted to profile page");
		
		ChangePasswordPage changepassword =new ChangePasswordPage(driver);
		changepassword.changePassword_LeftNavTile().click();
		Log.log.info("clicked on change password tile");
		changepassword.changePasswordPage(currentPassword, newPassword, confirmPassword);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean displayed= changepassword.isElementDisplayed(changepassword.successChangePasswordMessage());
		Log.log.info("sucess change password element displayed:"+displayed);
		String successpopuptext = changepassword.successChangePasswordMessage().getText();
		Log.log.info("Asserting sucess toast actual and expected messages");
		homepage.landingPageAccountNavMenu().click();
		homepage.accountNavlogOut().click();
		assertEquals(successpopuptext, "Record saved successfully");
		assertTrue(displayed);
	}
	
	@Test(dataProvider = "excelData")
	public void verifyChangePasswordwithInvalidinput(String Username,String Password, String currentPassword,String newPassword,String confirmPassword) 
	{
		HomePage homepage=new HomePage(driver);
		homepage.loginLink().click();
		Log.log.info("clicked on login link from homepage");
		
		LoginPage login=new LoginPage(driver);
		Log.log.info("Navigated to login page");
		login.loginToApplication(Username, Password);
		Log.log.info("Entering login credetails");
		homepage.landingPageAccountNavMenu().click();
		Log.log.info("clicked on Accountnav menu");
		homepage.accountNavProfile().click();
		Log.log.info("Naviagted to profile page");
		
		ChangePasswordPage changepassword =new ChangePasswordPage(driver);
		changepassword.changePassword_LeftNavTile().click();
		Log.log.info("Navigated to changePassword page");
		Log.log.info("values entering change password page");
		changepassword.changePasswordPage(currentPassword, newPassword, confirmPassword);
		//checking invalid pop up error element displayed or not.
		try {
			Log.log.info("waiting for innvalid popup message");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean status= changepassword.isElementDisplayed(changepassword.inValidpopupError_changepassword());
		Log.log.info("invalid popup error element displayed:"+ status);
		String errorpopuptoast = changepassword.inValidpopupError_changepassword().getText();
		Log.log.info("Password changed");
		assertEquals(errorpopuptoast, "Please enter valid New Password");
		
	}
	
}


