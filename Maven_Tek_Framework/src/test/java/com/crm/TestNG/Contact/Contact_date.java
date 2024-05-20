package com.crm.TestNG.Contact;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.ObjectRepositoryUtility.Create_Contact_Date_Repo;
import com.crm.baseclass.Base_Class;
import com.crm.generic.fileutility.Excel_Utility;
import com.crm.webdriverUtility.Java_Utility;

public class Contact_date extends Base_Class {
	 @Test 
	    public void createContactWithDate() throws Throwable {
				
		Java_Utility ju = new Java_Utility();
		Excel_Utility eu = new Excel_Utility();
		String contact = eu.getDataFromExcel("contact", 1, 2)+ju.getRandomNumber();
				
		Create_Contact_Date_Repo cd = new Create_Contact_Date_Repo(driver);
		cd.getContactlink().click();
		cd.getContactIMG().click();
		cd.getLastnameTF().sendKeys(contact);
		
		String startdate = ju.getSystemDateyyyymmdd();
		System.out.println("Starting date is "+startdate);
		cd.getStartdateDD().clear();
		cd.getStartdateDD().sendKeys(startdate);
		
		String enddate = ju.getRequiredDateyyyymmdd(30);
		System.out.println("end date "+enddate);
		cd.getEnddateDD().clear();
		cd.getEnddateDD().sendKeys(enddate);
		cd.getSavebutton().click();
		String start = cd.getStartsave().getText();
		System.out.println("entered start date "+start);
		Assert.assertEquals(startdate, start);

		String end = cd.getEndsave().getText().trim();
		System.out.println("entered end date "+end);
		Assert.assertEquals(enddate, end);

 }
}
