package com.crm.orgTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.crm.generic.fileutility.Excel_Utility;
import com.crm.generic.fileutility.File_Utility;
import com.crm.webdriverUtility.Java_Utility;
import com.crm.webdriverUtility.WebDriver_utility;

public class Create_Org_TC01 {
	public static void main(String[] args) throws Throwable {
		
		File_Utility fu = new File_Utility();
		Excel_Utility eu = new Excel_Utility();
		String Browser = fu.getDataFromPropertyFile("browser");
		String URL = fu.getDataFromPropertyFile("url");
		String Username = fu.getDataFromPropertyFile("username");
		String Password = fu.getDataFromPropertyFile("password");
		
		Java_Utility ju = new Java_Utility();
		
		String orgname = eu.getDataFromExcel("org", 1, 5)+ ju.getRandomNumber();
		
		WebDriver driver=null;
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
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(orgname)) {
			System.out.println(orgname+" is created===> Pass");
		}else {
			System.out.println(orgname+" is not created===> Fail");
		}
		String orgnameverify = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(orgnameverify.contains(orgname)) {
			System.out.println(orgname+ " Name is Present==> Pass");
		}else {
			System.out.println(orgname+" Name is not present==> Fail");
		}
		driver.quit();
	}
}
