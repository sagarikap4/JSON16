package com.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Contact_Date_Repo {
	public Create_Contact_Date_Repo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement contactIMG;
	
	@FindBy(name = "lastname")
	private WebElement lastnameTF;
	
	@FindBy(name = "support_start_date")
	private WebElement startdateDD;
	
	@FindBy(id = "jscal_field_support_end_date")
	private WebElement enddateDD;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startsave;

	@FindBy(id = "mouseArea_Support End Date")
	private WebElement endsave;

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getContactIMG() {
		return contactIMG;
	}

	public WebElement getLastnameTF() {
		return lastnameTF;
	}

	public WebElement getStartdateDD() {
		return startdateDD;
	}

	public WebElement getEnddateDD() {
		return enddateDD;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getStartsave() {
		return startsave;
	}

	public WebElement getEndsave() {
		return endsave;
	}
}
