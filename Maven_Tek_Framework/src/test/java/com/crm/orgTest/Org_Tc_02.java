package com.crm.orgTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.crm.generic.fileutility.Excel_Utility;
import com.crm.generic.fileutility.File_Utility;
import com.crm.webdriverUtility.Java_Utility;
import com.crm.webdriverUtility.WebDriver_utility;

public class Org_Tc_02 {

	public static void main(String[] args) throws Throwable {
		File_Utility fu= new File_Utility();
		String Browser = fu.getDataFromPropertyFile("browser");
		String URL = fu.getDataFromPropertyFile("url");
		String Username = fu.getDataFromPropertyFile("username");
		String Password = fu.getDataFromPropertyFile("password");
		
		Java_Utility ju= new Java_Utility();
		Excel_Utility eu= new Excel_Utility();
		String orgname = eu.getDataFromExcel("org", 3, 5)+ju.getRandomNumber();
		String phno = eu.getDataFromExcel("org", 3, 8);
				
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
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.id("phone")).sendKeys(phno);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String no = driver.findElement(By.id("dtlview_Phone")).getText();
		if(no.contains(phno)) {
			System.out.println(phno+" is Entered===> Pass");
		}else {
			System.out.println(phno+" is not Entered===> Fail");
		}
		driver.quit();
	}

}
