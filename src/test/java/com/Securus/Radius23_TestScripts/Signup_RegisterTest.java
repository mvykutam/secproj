package com.Securus.Radius23_TestScripts;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Securus.Radius23_pages.HomePage;
import com.Securus.Radius23_pages.LoginPage;
import com.Securus.Radius23_pages.SignupRegisterPage;
import com.Securus.Radius23_pages.TestBaseSetup;

public class Signup_RegisterTest extends TestBaseSetup{
	
	@Test(dataProvider="excelData")
	public void verifyingRegisterWithValidInputs(String fname,String lname,String pVisibleName,String email,String pwd,
			String PNumber1Cell,String pNumber2Home,String address1,String address2,String country,String state,String city,String zipCode,String status)
	{
		HomePage hp = new HomePage(driver);
		hp.signUpLink().click();
		System.out.println("Clicked on signuplink on home page");
		SignupRegisterPage signup =new SignupRegisterPage(driver);	
	    
	    signup.firstName=fname;
	    signup.lastName=lname;
	    signup.publicVisibleName=pVisibleName;
	    signup.emailAdress=email;
	    signup.password=pwd;
	    signup.PhoneNumber1Cell=PNumber1Cell;
	    signup.phoneNumber2Home=pNumber2Home;
	    signup.address1=address1;
	    signup.address2=address2;
	    signup.country=country;
	    signup.state=state;
	    signup.city=city;
	    signup.zipCode=zipCode;
	    System.out.println(signup.zipCode);
	    signup.signupRadious23Account_Creation();
        assertTrue(new LoginPage(driver).successSignupMessage().getText().equals(status));   
	    }
}
	    
	    
	    
	    
	   
	
	

