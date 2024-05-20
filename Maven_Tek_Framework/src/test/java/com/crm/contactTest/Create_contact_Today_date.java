package com.crm.contactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.crm.generic.fileutility.Excel_Utility;
import com.crm.generic.fileutility.File_Utility;
import com.crm.webdriverUtility.Java_Utility;
import com.crm.webdriverUtility.WebDriver_utility;

public class Create_contact_Today_date {
	    @Test 
	    public void createContactWithDate() throws Throwable {
		File_Utility fu= new File_Utility();
		String Browser = fu.getDataFromPropertyFile("browser");
		String URL = fu.getDataFromPropertyFile("url");
		String Username = fu.getDataFromPropertyFile("username");
		String Password = fu.getDataFromPropertyFile("password");
		
		Java_Utility ju = new Java_Utility();
		Excel_Utility eu = new Excel_Utility();
		String contact = eu.getDataFromExcel("contact", 1, 2)+ju.getRandomNumber();
		WebDriver driver;
		if(Browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (Browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		WebDriver_utility wu= new WebDriver_utility();
		wu.waitforPageTpLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contact);
		
		String startdate = ju.getSystemDateyyyymmdd();
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		
		String enddate = ju.getRequiredDateyyyymmdd(30);
		driver.findElement(By.id("jscal_field_support_end_date")).clear();
		driver.findElement(By.id("jscal_field_support_end_date")).sendKeys(enddate);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String start = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(start.contains(startdate)) {
			System.out.println(startdate+" contact created with start Date successfully==> Pass");
		}else {
			System.out.println(contact+" contact not created with start Date==> Fail");
		}
		String end = driver.findElement(By.id("mouseArea_Support End Date")).getText();
		if(end.contains(enddate)) {
			System.out.println(startdate+" contact created with end Date successfully==> Pass");
		}else {
			System.out.println(contact+" contact not created with end Date==> Fail");
		}
		driver.quit();
	}
}
