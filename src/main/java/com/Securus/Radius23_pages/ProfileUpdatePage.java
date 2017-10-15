package com.Securus.Radius23_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileUpdatePage extends BasePage {

	public ProfileUpdatePage(WebDriver driver) {
		super.driver = driver;
	}

	public WebElement landingPageAccountNavMenu() {
		// return Element("xpath", "//a[@id='profile-firstname']
		// [@name='profile-firstname']");
		return Element("xpath", "//ul[@class='nav navbar-nav navbar-right user-menu']//li[@class='dropdown']");
	}

	public WebElement accountNavProfile() {
		return Element("xpath", "//a[contains(text(),'My Profile')] [@href='#/Profile']");

	}

	public WebElement profilePageLeftSideNav() {
		return Element("xpath", "//div[@class='rad-render-body ng-scope']//ul[@class='col-sm-4 r-nav-side-bar']");

	}

	public WebElement ProfileTile() {
		return Element("xpath", "//a[contains(@ng-click, 'profile/profile.html')]");
	}

	public WebElement ProfileInputFirstName() {
		return Element("Xpath", "//input[@id='profile-firstname'][@name='profile-firstname']");
	}

	public WebElement ProfileInputMiddleName() {
		return Element("Xpath", "//input[@id='profile-middlename'][@name='profile-middlename']");
	}

	public WebElement ProfileInputLastName() {
		return Element("Xpath", "//input[@id='profile-lastname'][@name='profile-lastname']");

	}

	public WebElement ProfileInputDisplayName() {
		return Element("Xpath", "//input[@id='profile-displayname'][@name='profile-displayname']");

	}

	public WebElement ProfileInputEmail() {
		return Element("Xpath", "//input[@id='profile-email'][@name='profile-email']");

	}

	public WebElement ProfileSelectPhonetype1DD() {
		return Element("Xpath", "//select[@id='profile-phonetype1']");

	}

	public WebElement ProfilecellTextfield1() {
		return Element("Xpath", "//input[@id='profile-phone1-phonemask'][not(contains(@class,'ng-hide'))]");

	}

	public WebElement ProfileSelectPhonetype2DD() {
		return Element("Xpath", "//select[@id='profile-phonetype2']");

	}
	
	public WebElement ProfileCellTextField2() {
		return Element("Xpath", "//input[@ng-model='Profile.Phone2'][contains(@class,'ng-hide')]");

	}
	

	public WebElement ProfileInputAddress1() {
		return Element("Xpath", "//input[@id='profile-address1'][@name='profile-address1']");

	}

	public WebElement ProfileInputAddress2() {
		return Element("Xpath", "//input[@id='profile-address2'][@name='profile-address2']");

	}

	public WebElement ProfileInputState() {
		return Element("xpath", "//input[@name='state'][@ng-model='Profile.State']");
	}

	public WebElement ProfileInputCity() {
		return Element("xpath", "//input[@name='city'][@ng-model='Profile.City']");
	}

	public WebElement ProfileInputZipcode() {
		return Element("xpath", "//input[@name='zipcode'][@ng-model='Profile.Zip']");
	}

	public WebElement ProfileSaveButton() {
		return Element("xpath", "//button[@id='save-profile'][@class='rad-button']");
	}
	

	public String firstName;
	public String middleName;
	public String lastName;
	public String DisplayName;
	public String emailAdress;
	public String PhoneNumber1Cell;
	public String phoneNumber2Cell;
	public String address1;
	public String address2;
	public String state;
	public String city;
	public String zipCode;

	public void profilepageofPublicuserOffender() {
		
		ProfileInputFirstName().clear();
		ProfileInputFirstName().sendKeys(firstName);
		
		ProfileInputMiddleName().clear();
		ProfileInputMiddleName().sendKeys(middleName);
		
		ProfileInputLastName().clear();
		ProfileInputLastName().sendKeys(lastName);
		
		ProfileInputDisplayName().clear();
		ProfileInputDisplayName().sendKeys(DisplayName);
		
		ProfileInputEmail().clear();
		ProfileInputEmail().sendKeys(emailAdress);
		
		//ProfileSelectPhonetype1DD().clear();
		selectDropDownoption(ProfileSelectPhonetype1DD(), "Cell");
		
		ProfilecellTextfield1().clear();
		ProfilecellTextfield1().sendKeys(PhoneNumber1Cell);
		
		//ProfileSelectPhonetype2DD().clear();
		selectDropDownoption(ProfileSelectPhonetype2DD(), "Cell");
		ProfileCellTextField2().clear();
		ProfileCellTextField2().sendKeys(phoneNumber2Cell); 
		
		
		ProfileInputAddress1().clear();
		ProfileInputAddress1().sendKeys(address1);
		
		ProfileInputAddress2().clear();
		ProfileInputAddress2().sendKeys(address2);
		
		//clear state text field and enter state
		ProfileInputState().click();
		ProfileInputState().clear();
		ProfileInputState().sendKeys(state);
		selectAjaxDDOption("xpath", "//input[@name='state'][@ng-model='Profile.State']", state);
	
		//clear city text field and enter city
		ProfileInputCity().click();
		ProfileInputCity().clear();
		ProfileInputCity().sendKeys(city);
		selectAjaxDDOption("xpath", "//input[@name='city'][@ng-model='Profile.City']", city);
		
		
		//clear Zipcode text field and enter Zipcode
		ProfileInputZipcode().click();
		ProfileInputZipcode().clear();
		ProfileInputZipcode().sendKeys(zipCode);
		selectAjaxDDOption("xpath", "//input[@name='zipcode'][@ng-model='Profile.Zip']", zipCode);
				
		ProfileSaveButton().click();

	}

	
}
