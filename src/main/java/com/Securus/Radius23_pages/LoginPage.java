package com.Securus.Radius23_pages;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginPage extends BasePage{

	
	public LoginPage(WebDriver driver) {
		super.driver=driver;
	}
	
	public WebElement userName()
	{
		return Element("name", "userName");
		
	}
	public WebElement password()
	{
		return Element("name", "password");
	}
	
	public WebElement loginButton()
	{
		return Element("xpath", "//button[@ng-click='login()']");
	}
	public WebElement inValidPopup()
	{
		return Element("xpath","//div[@id='toast-container']//div[@class='toast-message']");
	}
	
	public WebElement successSignupMessage()
	{
		return Element("xpath","//div[@class='alert alert-success text-center status-text ng-scope']//span");
	}
		
	public void loginToApplication(String emailAddress, String password)  {
		
		userName().sendKeys(emailAddress);
		password().sendKeys(password);
		loginButton().click();
		
		
		
		
	}
}
