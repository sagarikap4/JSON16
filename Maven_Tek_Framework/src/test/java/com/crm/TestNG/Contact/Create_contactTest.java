package com.crm.TestNG.Contact;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.ObjectRepositoryUtility.Create_contact;
import com.crm.ObjectRepositoryUtility.Creating_New_Organization_page;
import com.crm.ObjectRepositoryUtility.Home_page;
import com.crm.baseclass.Base_Class;

public class Create_contactTest extends Base_Class{
	Home_page hp;
	Create_contact cc;
	Creating_New_Organization_page cop;
//	@Test(groups ="Smoke Testing")
//	public void createContact() throws Throwable {
//	String contact = eu.getDataFromExcel("contact", 1, 2)+ ju.getRandomNumber();
//	hp=new Home_page(driver);
//	hp.getContactlink().click();
//	
//	cc=new Create_contact(driver);
//	cc.getCreatecontactimg().click();
//	cc.getContactLastnameTF().sendKeys(contact);
//	cc.getSavebtn().click();
//	}
	
	@Test(groups="Regration Testing")
	public void CreateContactWithOrgNameTest() throws Exception {
		String orgname = eu.getDataFromExcel("org", 1, 5)+ ju.getRandomNumber();
		hp=new Home_page(driver);
		hp.getOrganizationlink().click();
		cop= new Creating_New_Organization_page(driver);
		cop.getCreateorgimg().click();
		cop.getOrgnametf().sendKeys(orgname);
		cop.getSavebtn().click();
		
		Thread.sleep(3000);
		String contact = eu.getDataFromExcel("contact", 1, 2)+ju.getRandomNumber();
		hp.getContactlink().click();
		cc=new Create_contact(driver);
		cc.getCreatecontactimg().click();
		cc.getContactLastnameTF().sendKeys(contact);
		String pid = driver.getWindowHandle();
		cc.getAddorgnameimg().click();
		wu.switchToTabOnUrl(driver,"form=TasksEditView");
		cc.getSearchtf().sendKeys(orgname);
		wu.select(cc.getOrgnodd(),"Organization Name");
		cc.getSearchbtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		driver.switchTo().window(pid);
		cc.getSavebtn().click();
	
	}
}
