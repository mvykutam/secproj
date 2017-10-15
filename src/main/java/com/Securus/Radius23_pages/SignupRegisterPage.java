package com.Securus.Radius23_pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignupRegisterPage extends BasePage{

	
	public SignupRegisterPage(WebDriver driver)
	{
		super.driver=driver;
	}
	
	public WebElement signupFirstName()
	{
		return Element("xpath","//input[@name='firstName']");
	}
	
	public WebElement signupLastName()
	{
		return Element("xpath","//input[@name='lastName']");	
	}
	
	public WebElement signupPublicVisibleName()
	{
		return Element("xpath","//input[@id='register-displayname']");	
	}
	
	public WebElement signupEmailAddress()
	{
		return Element("xpath","//input[@name='userName']");	
	}
	
	public WebElement signupPassword()
	{
		return Element("xpath","//input[@name='password']");	
	}
	
	public WebElement signupPhoneNumber1Cell()
	{
		return Element("xpath", "//input[@name='phone1']");	
	}
	
	public WebElement signupPhoneNumber2Home()
	{
		return Element("xpath","//input[@name='phone2']");	
	}
	
	public WebElement signupAddress1()
	{
		return Element("xpath","//input[@name='address1']");	
	}
	
	public WebElement signupAddress2()
	{
		return Element("xpath","//input[@id='address2']");	
	}
	
	public WebElement signupCountry()
	{
		return Element("xpath","//input[@name='country'][@required='required']");	
	}
	
	public WebElement signupState()
	{
		return Element("xpath","//input[@name='state'][@required='required']");	
	}
	
	public WebElement signupCity()
	{
		return Element("xpath","//input[@id='city'][@required='required']");	
	}
	
	public WebElement signupZipcode()
	{
		return Element("xpath","//input[@name='zipcode'][@required='required']");	
	}
	
	public WebElement signupAccountCreateButton()
	{
		return Element("xpath","//button[@id='register-click']");	
	}
	
	//Invalid scenariou element methods 
	public WebElement SignupEnterFirstnameErrorMsg()
	{
		return Element("xpath","//div[contains(@ng-class,'registerForm.firstName')]//div[contains(text(),'Please enter First Name.')]//small");
	}
	
	public WebElement SignupEnterLastnameErrorMsg()
	{
		return Element("xpath","//div[contains(@ng-class,'registerForm.lastName')]//div[contains(text(),'Please enter Last name.')]//small");
	}
	
	public WebElement SignupEnterEmailErrorMsg()
	{
		return Element("xpath","//div[contains(@ng-class,'registerForm.userName')]//div[contains(text(),'Please enter Email.')]//small");
	}
	
	public WebElement SignupEnterValidEmailErrorMsg()
	{
		return Element("xpath","//div[contains(@ng-class,'registerForm.userName')]//div[contains(text(),'Please enter valid Email.')]//small");
	}
	
	public WebElement SignupEnterPasswordErrorMsg()
	{
		return Element("xpath","//div[contains(@ng-class,'registerForm.password')]//small[contains(text(),'Please enter Password.')]");
	}
	
	public WebElement SignupEnterValidPasswordErrorMsg()
	{
		return Element("xpath","//div[contains(@ng-class,'registerForm.password')]//small[contains(text(),'Password must be atleast 6 characters')]");
	}
	
	
	public String firstName;
	public String lastName;
	public String publicVisibleName;
	public String emailAdress;
	public String password;
	public String PhoneNumber1Cell;
	public String phoneNumber2Home;
	public String address1;
	public String address2;
	public String country;
	public String state;
	public String city;
	public String zipCode;
	
	public void  signupRadious23Account_Creation()
	{	
		signupFirstName().sendKeys(firstName);
		signupLastName().sendKeys(lastName);
		signupPublicVisibleName().sendKeys(publicVisibleName);
		signupEmailAddress().sendKeys(emailAdress);
		signupPassword().sendKeys(password);
		signupPhoneNumber1Cell().sendKeys(PhoneNumber1Cell);
		signupPhoneNumber2Home().sendKeys(phoneNumber2Home);
		signupAddress1().sendKeys(address1);
		signupAddress2().sendKeys(address2);
		
		signupCountry().click();
		signupCountry().clear();
		
//		signupState().sendKeys(country);
		selectAjaxDDOption("xpath", "//ul[@class='dropdown-menu ng-isolate-scope']", country);
		
		signupState().click();
		signupState().sendKeys(state);
		selectAjaxDDOption("xpath", "//ul[@class='dropdown-menu ng-isolate-scope']", state);
			
		signupCity().click();
		signupCity().sendKeys(city);
		selectAjaxDDOption("xpath", "//ul[@class='dropdown-menu ng-isolate-scope']", city);

		signupZipcode().click();
		signupZipcode().sendKeys(zipCode);
		selectAjaxDDOption("xpath", "//ul[@class='dropdown-menu ng-isolate-scope']", zipCode);
		
		signupAccountCreateButton().click();
		
		
	}
	
}
	
	
	
	
	