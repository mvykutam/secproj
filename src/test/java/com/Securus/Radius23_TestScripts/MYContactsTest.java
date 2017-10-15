package com.Securus.Radius23_TestScripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.Securus.Radius23_pages.HomePage;
import com.Securus.Radius23_pages.LoginPage;
import com.Securus.Radius23_pages.MyContactsPage;
import com.Securus.Radius23_pages.TestBaseSetup;
import com.Securus.Radius23_utilities.Log;

public class MYContactsTest extends TestBaseSetup{
	
	@Test(dataProvider ="excelData")
	public void VerifyMyContactsofProfilePage(String UserName,String Password ,String FirstName,String MiddleName,String  LastName, String Phone1, String Phone2, String Address1, String Addres2, String State, String City, String Zip, String Email, String From, String To)
	{
		HomePage homepage =new HomePage(driver);
		homepage.loginLink().click();
		Log.log.info("Clicked on login link on homepage");
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.loginToApplication(UserName, Password);
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
		Log.log.info("Clicked on myContactsdetailsAddButton in mycontacts page");
		//Checking contactDetailsModalHeader element  is displayed or not.
		boolean statusofcontactdetailspage = mycontactspage.isElementDisplayed(mycontactspage.contactDetailsModalHeader());
		String text = mycontactspage.contactDetailsModalHeader().getText();
		Log.log.info("Naviagted to contact details model");
		System.out.println("Text of the model header of mycontact page is:"+ text);
		mycontactspage.addNewContact(FirstName, MiddleName, LastName, Phone1, Phone2, Address1, Addres2, State, City, Zip, Email, From, To);
		Log.log.info("added data to input fields");
	//checking success toast element dispayed or not
		boolean status2 = mycontactspage.isElementDisplayed(mycontactspage.myContactSaveRecordSaved_Successtoast());
		String successtext = mycontactspage.myContactSaveRecordSaved_Successtoast().getText();
		Log.log.info("Checking success toast");
		assertEquals(successtext, "Record saved successfully");
		}
		
  }


	
	

