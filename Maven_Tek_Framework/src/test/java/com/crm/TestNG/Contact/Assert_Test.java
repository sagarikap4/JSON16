package com.crm.TestNG.Contact;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.baseclass.Base_Class;




public class Assert_Test extends Base_Class {
	@Test
	public void homePageTest(Method mt) {
		String ExpectedTitle ="Home";
		System.out.println(mt.getName() + "Test Started");
		String actTitle=driver.findElement(By.partialLinkText("Home")).getText();
		Assert.assertEquals(ExpectedTitle, actTitle);
		System.out.println(mt.getName() + "Test End");
	}
	
	@Test
	public void verifyHomePageLogoTest(Method mt) {
		System.out.println(mt.getName() + " Logo verification Test Started");
		boolean logo = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isDisplayed();
		Assert.assertTrue(logo);
		System.out.println(mt.getName() + " Logo verification Test ended");
	}
}
