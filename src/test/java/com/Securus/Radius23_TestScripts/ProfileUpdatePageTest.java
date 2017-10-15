package com.Securus.Radius23_TestScripts;

import org.testng.annotations.Test;

import com.Securus.Radius23_pages.HomePage;
import com.Securus.Radius23_pages.LoginPage;
import com.Securus.Radius23_pages.ProfileUpdatePage;
import com.Securus.Radius23_pages.TestBaseSetup;
import com.Securus.Radius23_utilities.Log;

public class ProfileUpdatePageTest extends TestBaseSetup{
	
	@Test(dataProvider = "excelData")
	public void verifyProfileUpdatePagewithValidInput(String fname,String middlename,String lname,String DisplayName,String Email,
			String Phone1Cell,String Phone2Cell,String Address1,String Address2,String state,String city,String zipCode)
	{
		HomePage homepage=new HomePage(driver);
		
		homepage.loginLink().click();
		Log.log.info("clicked on login link");
		
		LoginPage login=new LoginPage(driver);
		login.loginToApplication("vt.madhavi@gmail.com", "Chandu123@");
		homepage.landingPageAccountNavMenu().click();
		homepage.accountNavProfile().click();
		Log.log.info("Naviagted to profile page");
		ProfileUpdatePage profile=new ProfileUpdatePage(driver);
		boolean profileleftnav=profile.isElementDisplayed(profile.profilePageLeftSideNav());
		System.out.println("profile account left nav is displayed "+profileleftnav);
		profile.ProfileTile().click();
		profile.firstName=fname;
		profile.middleName=middlename;
		profile.lastName=lname;
		profile.DisplayName=DisplayName;
		profile.emailAdress=Email;
		profile.PhoneNumber1Cell=Phone1Cell;
		profile.phoneNumber2Cell=Phone2Cell;
		profile.address1=Address1;
		profile.address2=Address2;
		profile.state=state;
		profile.zipCode=state;
		profile.profilepageofPublicuserOffender();	
		Log.log.info("profile has been saved");
		homepage.public_Offender_logout();
		Log.log.info("Profile update is done and user loged out");	 		
	}

    
}
