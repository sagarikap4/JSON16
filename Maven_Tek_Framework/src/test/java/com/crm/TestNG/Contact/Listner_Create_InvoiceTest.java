package com.crm.TestNG.Contact;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.ObjectRepositoryUtility.Create_contact;
import com.crm.ObjectRepositoryUtility.Creating_New_Organization_page;
import com.crm.ObjectRepositoryUtility.Home_page;
import com.crm.ObjectRepositoryUtility.Invoice;
import com.crm.baseclass.Base_Class_Listener;
import com.crm.generic.fileutility.Excel_Utility;
import com.crm.webdriverUtility.UtilityClassObject;
import com.crm.webdriverUtility.WebDriver_utility;

@Listeners(com.crm.ListenersUtility.Listenersclass.class)
public class Listner_Create_InvoiceTest extends Base_Class_Listener{

	@Test
	public void CreateInvoice() throws Exception {
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		Excel_Utility eu = new Excel_Utility();
		String subject = eu.getDataFromExcel("invoice", 1, 0)+ju.getRandomNumber();
		String orgname = eu.getDataFromExcel("org", 1, 5)+ ju.getRandomNumber();

		Creating_New_Organization_page cnorg= new Creating_New_Organization_page(driver);
		Home_page hp = new Home_page(driver);
		
		//creating org
		hp.getOrganizationlink().click();
		cnorg.getCreateorgimg().click();
		cnorg.getOrgnametf().sendKeys(orgname);
		cnorg.getSavebtn().click();
		Thread.sleep(3000);
		
		//creatring invoice
		Invoice in = new Invoice(driver);
		WebDriver_utility wu = new WebDriver_utility();
		//wu.mouseMoveOnElement(driver, in.getMoreDD());
		driver.findElement(By.xpath("//a[text()='More']")).click();
		
		in.getInvoiceLink().click();
		in.getCreateInvoiceImg().click();
		in.getSubjectTF().sendKeys(subject);
		String pid = driver.getWindowHandle();
		in.getOrgImg().click();
		
		//adding org name in invoice
		Create_contact cc = new Create_contact(driver);
		wu.switchToTabOnUrl(driver,"action=Popup");
		cc.getSearchtf().sendKeys(orgname);
		cc.getSearchbtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		driver.switchTo().window(pid);
		in.getSaveBTN().click();
		wu.switchToAlertAndAccept(driver);
		System.out.println("Invoice Created");
	}
}
