package com.crm.TestNG.Contact;

import org.testng.annotations.Test;

import com.crm.ObjectRepositoryUtility.Create_contact;
import com.crm.ObjectRepositoryUtility.Creating_New_Organization_page;
import com.crm.ObjectRepositoryUtility.Home_page;
import com.crm.baseclass.Base_Class;

public class Simple_ContactTest extends Base_Class{
	Home_page hp;
	Create_contact cc;
	Creating_New_Organization_page cop;
	@Test(groups ="Smoke Testing")
	public void createContact() throws Throwable {
	String contact = eu.getDataFromExcel("contact", 1, 2)+ ju.getRandomNumber();
	hp=new Home_page(driver);
	hp.getContactlink().click();
	
	cc=new Create_contact(driver);
	cc.getCreatecontactimg().click();
	cc.getContactLastnameTF().sendKeys(contact);
	cc.getSavebtn().click();
	}
	}
