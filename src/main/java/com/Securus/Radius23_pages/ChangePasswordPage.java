package com.Securus.Radius23_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.Securus.Radius23_utilities.Log;

public class ChangePasswordPage extends BasePage{
	
  
	@FindBy(how=How.NAME, using="username")
	private WebElement user_name;

	public ChangePasswordPage(WebDriver driver)
  {
	  super.driver=driver;
  }
	
	public WebElement changePassword_LeftNavTile() {
		Log.log.info("ChangePasswordPage page:changePassword_LeftNavTile");
		return Element("xpath", "//a[contains(@ng-click,'changepassword.html')]");
	}
	
	public WebElement currentPasswordText() {
		Log.log.info("ChangePasswordPage page:currentPasswordText");
		return Element("xpath", "//input[@id='password']");
	}
	public WebElement newPasswordText() {
		Log.log.info("ChangePasswordPage page:newPasswordText element");
		return Element("xpath", "//input[@id='newpassword']");
	}
	
	public WebElement confirmPasswordText() {
		Log.log.info("ChangePasswordPage page:confirmPasswordText");
		return Element("xpath", "//input[@id='confirmpassword']");
	}
	
	public WebElement ChangepasswordSavebutton_click() {
		Log.log.info("ChangePasswordPage page:ChangepasswordSavebutton_click");
		return Element("xpath", "//button[@id='change-password']");
	}
	
	public WebElement inValidpopupError_changepassword() {
		Log.log.info("ChangePasswordPage page:inValidpopupError_changepassword");
		return Element("xpath", "//div[contains(text(),'Please enter valid New Password')]");
	}
	public WebElement successChangePasswordMessage() {
		Log.log.info("ChangePasswordPage page:successChangePasswordMessage()");
		return Element("xpath", "//div[@id='toast-container']//div[contains(text(),'Record saved successfully')]");
	}
	
	
	
	public void changePasswordPage(String currentpassword, String newpassword, String confirmpassword) 
	{    Log.log.info("entering values in change password page");
		 currentPasswordText().sendKeys( currentpassword);
		 newPasswordText().sendKeys(newpassword);
		 confirmPasswordText().sendKeys(confirmpassword);
		 ChangepasswordSavebutton_click().click();
		 Log.log.info("Clciked on save button in change password page");
		
	}
}


