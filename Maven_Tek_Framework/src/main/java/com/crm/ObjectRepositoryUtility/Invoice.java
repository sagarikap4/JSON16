package com.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Invoice {

	public Invoice(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreDD;
	
	@FindBy(linkText  ="Invoice")
	private WebElement invoiceLink;
	
	@FindBy(xpath ="//img[@title='Create Invoice...']")
	private WebElement createInvoiceImg;
	
	@FindBy(name ="subject")
	private WebElement subjectTF;
	
	public WebElement getMoreDD() {
		return moreDD;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getCreateInvoiceImg() {
		return createInvoiceImg;
	}

	public WebElement getSubjectTF() {
		return subjectTF;
	}

	public WebElement getSaveBTN() {
		return saveBTN;
	}

	public WebElement getOrgImg() {
		return orgImg;
	}

	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgImg;
}
