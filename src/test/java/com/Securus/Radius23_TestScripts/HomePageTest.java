package com.Securus.Radius23_TestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Securus.Radius23_pages.HomePage;
import com.Securus.Radius23_pages.LoginPage;
import com.Securus.Radius23_pages.TestBaseSetup;
import com.Securus.Radius23_utilities.Log;

public class HomePageTest extends TestBaseSetup{

	
	@Test
	public void verifyLoginLinkOnHome()
	{
		 
		 HomePage home=new HomePage(driver);
		 home.loginLink().click();
		 Log.log.info("signup link is clicked");
		 assertTrue(home.getCurrentURL().endsWith("#/login"));	
	}
	
	@Test
	public void verifySignUpLinkonHome()
	{
		
		HomePage home=new HomePage(driver);
		home.signUpLink().click();
		Log.log.info("signup link is clicked");
		assertTrue(home.getCurrentURL().endsWith("#/signup"));
		
	}
	
	
}
