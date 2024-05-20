package com.crm.contactTest;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

import com.crm.ObjectRepositoryUtility.Creating_New_Organization_page;
import com.crm.ObjectRepositoryUtility.Home_page;
import com.crm.ObjectRepositoryUtility.Login_page;
import com.crm.generic.fileutility.Excel_Utility;
import com.crm.generic.fileutility.File_Utility;
import com.crm.webdriverUtility.Java_Utility;
import com.crm.webdriverUtility.WebDriver_utility;

public class Contect_orgName_02 {
	public static void main(String[] args) throws Throwable {
		File_Utility fu = new File_Utility();
		String Browser = fu.getDataFromPropertyFile("browser");
		String URL = fu.getDataFromPropertyFile("url");
		String Username = fu.getDataFromPropertyFile("username");
		String Password = fu.getDataFromPropertyFile("password");
		
		Java_Utility ju = new Java_Utility();
		Excel_Utility eu= new Excel_Utility();
		String orgname = eu.getDataFromExcel("org", 1, 5)+ ju.getRandomNumber();
		WebDriver_utility wu = new WebDriver_utility();

		WebDriver driver;
		if(Browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (Browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		wu.waitforPageTpLoad(driver);
		//driver.get(URL);
		Login_page lp= new Login_page(driver);
		lp.loginToApp(URL, Username, Password);
		
		Home_page hp= new Home_page(driver);
		hp.getOrganizationlink().click();
		
		Creating_New_Organization_page cnorg= new Creating_New_Organization_page(driver);
		cnorg.getCreateorgimg().click();
		cnorg.getOrgnametf().sendKeys(orgname);
		 cnorg.getSavebtn().click();
		
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(orgname)) {
			System.out.println(orgname+" is created===> Pass");
		}else {
			System.out.println(orgname+" is not created===> Fail");
		}
		
		String contact = eu.getDataFromExcel("contact", 1, 2)+ju.getRandomNumber();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contact);
		String pid = driver.getWindowHandle();
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		wu.switchToTabOnUrl(driver,"form=TasksEditView");
		
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		driver.switchTo().window(pid);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		 String orgcontact = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		 TakesScreenshot tk= (TakesScreenshot) driver;
		 File temp = tk.getScreenshotAs(OutputType.FILE);
		 File f = new File("./ss/contact_orgname.png");
		 FileHandler.copy(temp, f);
		if(orgcontact.trim().contains(orgname)) {
			System.out.println(orgname+" contact created with organization name====> Pass");
		}else {
			System.out.println(orgname+" contact not created with organization name====> Fail");
		}
		driver.quit();
	}
}
