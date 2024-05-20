package com.crm.TestNG.Contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.crm.ListenersUtility.Listenersclass;

@Listeners(com.crm.ListenersUtility.Listenersclass.class)
public class ExtentReport {
	public ExtentReports report;
	@Test
	public void generateExtentReport()  {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");

		
		
		Listenersclass.test.log(Status.INFO, "Navigated to the url");
	//	Assert.assertEquals("Home", "ome");
		driver.quit();
		//System.out.println("nkjhudiugscdy");
		//driver.close();
	}	
}
