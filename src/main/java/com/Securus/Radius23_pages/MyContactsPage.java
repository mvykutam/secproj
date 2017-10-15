package com.Securus.Radius23_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Securus.Radius23_utilities.Log;

public class MyContactsPage extends BasePage {

	public MyContactsPage(WebDriver driver) {
		super.driver = driver;
	}

	public WebElement myContactsTile() {
		Log.log.info(" myContactsTile Element");
		return Element("xpath", "//a[contains(@ng-click, 'profile/mycontacts.html')]");
	}

	public WebElement myContactsdetailsAddButton() {
		Log.log.info(" myContactsdetailsAddButto Element");
		return Element("xpath", "//button[@id='mycontactdetails']");
	}

	public WebElement contactDetailsModalHeader() {
		Log.log.info("contactDetailsModalHeader Element");
		return Element("xpath", "//div[@class='modal-header']//h3[contains(text(),'Contact Detail')]");
	}

	public WebElement mycontactFirstName() {
		Log.log.info(" mycontactFirstName Element");
		return Element("xpath", "//input[@id='mycontact-firstname'][@name='mycontact-firstname']");
	}

	public WebElement mycontactMiddleName() {
		Log.log.info("mycontactMiddleName Element");
		return Element("xpath", "//input[@id='mycontact-middlename'][@name='mycontact-middlename']");
	}

	public WebElement mycontactLastName() {
		Log.log.info(" mycontactLastName Element");
		return Element("xpath", "//input[@id='mycontact-lastname'][@name='mycontact-lastname']");
	}

	public WebElement mycontactSelectPhonetype1DD() {
		Log.log.info(" mycontactSelectPhonetype1DD Element");
		return Element("Xpath", "//select[@id='mycontact-phonetype1']");

	}

	public WebElement mycontactcellTextfield1() {
		Log.log.info(" mycontactcellTextfield1 Element");

		return Element("Xpath", "//input[@id='mycontact-phone1-cellmask'][not(contains(@class,'ng-hide'))]");

	}

	public WebElement mycontactSelectPhonetype2DD() {
		Log.log.info(" mycontactSelectPhonetype2DD Element");
		return Element("Xpath", "//select[@id='mycontact-phonetype2']");

	}

	public WebElement mycontactcellTextfield2() {
		Log.log.info(" mycontactcellTextfield2 Element");
		return Element("Xpath", "//input[@id='mycontact-phone2-cellmask']");

	}

	public WebElement mycontactAddress1() {
		Log.log.info(" mycontactAddress1 Element");
		return Element("Xpath", "//input[@id='mycontact-address1'][@name='mycontact-address1']");

	}

	public WebElement mycontactAddress2() {
		Log.log.info(" mycontactAddress2 Element");
		return Element("Xpath", "//input[@id='mycontact-address2'][@name='mycontact-address2']");

	}

	public WebElement myContactInputState() {
		Log.log.info(" myContactInputState Element");
		return Element("xpath", "//input[@name='state'][@ng-model='MyContact.State']");
	}

	public WebElement myContactInputCity() {
		Log.log.info(" myContactInputCity Element");
		return Element("xpath", "//input[@name='city'][@ng-model='MyContact.City']");
	}

	public WebElement myConatctInputZipcode() {
		Log.log.info(" myConatctInputZipcode Element");
		return Element("xpath", "//input[@name='zipcode'][@ng-model='MyContact.Zip']");
	}

	// dropdown for type of Contact type Applicant.
	public WebElement myContactType_DD() {
		Log.log.info(" myContactType_DD Element");
		return Element("xpath", "//select[@id='mycontact-contacttypeid']");
	}

	public WebElement myContactInputEmail() {
		Log.log.info("Clicked myContactInputEmail Element");
		return Element("xpath", "//input[@name='contactEmail'][@id='contactemail']");
	}

	// dropdown with yes and no options
	public WebElement myContactActive_DD() {
		Log.log.info("Clicked myContactActive_DD Element");
		return Element("xpath", "//select[@ng-model='MyContact.IsActive']");
	}

	// checkbox to asssign permissions
	public WebElement myContactAssignPermissions_CheckBox() {
		Log.log.info("Clicked myContactAssignPermissions_CheckBox Element");
		return Element("xpath", "//input[@id='mycontact-allowlogin']");
	}

	public WebElement myContactFromDateInput() {
		Log.log.info(" myContactFromDateInput Element");
		return Element("xpath", "//input[@id='mycontact-fromdate'][@name='mycontact-fromdate']");
	}

	public WebElement myContactToDateInput() {
		Log.log.info("myContactToDateInput Element");
		return Element("xpath", "//input[@id='mycontact-todate'][@name='mycontact-todate']");
	}

	// check box to my cases permissions

	public WebElement myContactSelectMYCases_CheckBox() {
		Log.log.info(" myContactSelectMYCases_CheckBox Element");
		return Element("xpath", "//label[contains(text(),'My Cases')]/input");
	}

	public WebElement myContactSave_Button() {
		Log.log.info("myContactSave_Button Element");
		return Element("xpath", "//input[@id='save-contactdetail'][@name='save-contactdetail']");
	}
	
	public WebElement myContactSaveRecordSaved_Successtoast() {
		Log.log.info("Record saved successfully");
		return Element("xpath", "//div[contains(text(),'Record saved successfully')]");
	}
	
	public WebElement myContact_NoConatctsAvailable(){
		Log.log.info(" myContact_NoConatctsAvaibul Element");
		return Element("xpath", "//h6[contains(text(),'No contacts available')]");
	}
	

	
	/*
	 * Method:addNewContact
	 * Auther:Madhavi
	 * User Of Method: for adding new contact into mycontacts page
	 */
	public void addNewContact(String FirstName, String MiddleName, String LastName, String Phone1,
			String Phone2, String Address1, String Addres2, String State, String City, String Zip, String Email,
			String From, String To)
	{
		mycontactFirstName().sendKeys(FirstName);
		mycontactMiddleName().sendKeys(MiddleName);
		mycontactLastName().sendKeys(LastName);
		//selecting dropdown as cell for phone type 1
		selectDropDownoption(mycontactSelectPhonetype1DD(), "Cell");
		mycontactcellTextfield1().sendKeys(Phone1);

		//selecting dropdown as cell for phonttype2
		selectDropDownoption(mycontactSelectPhonetype2DD(), "Cell");
		mycontactcellTextfield2().sendKeys(Phone2);
		mycontactAddress1().sendKeys(Address1);
		mycontactAddress2().sendKeys(Addres2);

		myContactInputState().sendKeys(State);
		/*
		 * jax Dropdown selection for state field.
		 * myContactInputState().click(); myContactInputState().sendKeys(State);
		 * selectAjaxDDOption("Xpath",
		 * "//input[@name='state'][@ng-model='MyContact.State']", "State");
		 */

		myContactInputCity().sendKeys(City);
		/*
		 * Ajax Dropdown selection for city field. myContactInputCity().click();
		 * myContactInputCity().sendKeys(City); selectAjaxDDOption("Xpath",
		 * "//input[@name='city'][@ng-model='MyContact.City']", "State");
		 */

		myConatctInputZipcode().sendKeys(Zip);
		/*
		 * Ajax Dropdown selection for Zip Field
		 * myConatctInputZipcode().click();
		 * myConatctInputZipcode().sendKeys(Zip); selectAjaxDDOption("Xpath",
		 * "//input[@name='zipcode'][@ng-model='MyContact.Zip']", "Zip");
		 */

		// selecting dropdown for contact type
		selectDropDownoption(myContactType_DD(), "Friend");
		myContactInputEmail().sendKeys(Email);
		// selecting dropdown mycontact active
		selectDropDownoption(myContactActive_DD(), "Yes");
		// checkbox operation
		myContactAssignPermissions_CheckBox().click();
		myContactFromDateInput().click();
		selectDate(From);
		myContactToDateInput().click();
		//Specific method for date  
		selectDate(To);
		// checkbox operation
		myContactSelectMYCases_CheckBox().click();
		myContactSave_Button().click();
	}
}
