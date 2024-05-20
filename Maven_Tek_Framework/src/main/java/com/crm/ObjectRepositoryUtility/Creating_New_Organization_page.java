package com.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Creating_New_Organization_page {
	public Creating_New_Organization_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindAll({@FindBy(name="accountname"),@FindBy(xpath = "//input[@type='text']")})
	private WebElement orgnametf;
	
	@FindBy(name="phone")
	private WebElement phnnotf;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorgimg;
	
	
	
	public WebElement getCreateorgimg() {
		return createorgimg;
	}

	public WebElement getOrgnametf() {
		return orgnametf;
	}

	public WebElement getPhnnotf() {
		return phnnotf;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
}
