package com.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_contact {
	//WebDriver driver;
	public Create_contact(WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createcontactimg;
	
	@FindBy(name ="lastname")
	private WebElement contactLastnameTF;
	
	@FindBy(id = "mobile")
	private WebElement phnnoTF;
	
	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement startdateDD;
	
	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement enddateDD;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement addorgnameimg;
	
	public WebElement getAddorgnameimg() {
		return addorgnameimg;
	}
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;
	
	@FindBy(name = "search_text")
	private WebElement searchtf;
	
	@FindBy(name = "search_field")
	private WebElement orgnodd;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchbtn;
	
	public WebElement getSearchtf() {
		return searchtf;
	}

	public WebElement getOrgnodd() {
		return orgnodd;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	
	
	public WebElement getCreatecontactimg() {
		return createcontactimg;
	}

	public WebElement getContactLastnameTF() {
		return contactLastnameTF;
	}

	public WebElement getPhnnoTF() {
		return phnnoTF;
	}

	public WebElement getStartdateDD() {
		return startdateDD;
	}

	public WebElement getEnddateDD() {
		return enddateDD;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

}
