package com.crm.orgTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepositoryUtility.Create_contact;
import com.crm.ObjectRepositoryUtility.Creating_New_Organization_page;
import com.crm.ObjectRepositoryUtility.Home_page;
import com.crm.ObjectRepositoryUtility.Login_page;
import com.crm.generic.fileutility.Excel_Utility;
import com.crm.generic.fileutility.File_Utility;
import com.crm.webdriverUtility.Java_Utility;
import com.crm.webdriverUtility.WebDriver_utility;

public class Create_org_Delet {
	public static void main(String[] args) throws Throwable {
		
		//read data from property file(comman data)
		File_Utility fu = new File_Utility();
		String Browser = fu.getDataFromPropertyFile("browser");
		String URL = fu.getDataFromPropertyFile("url");
		String Username = fu.getDataFromPropertyFile("username");
		String Password = fu.getDataFromPropertyFile("password");
		
		WebDriver driver;
		if(Browser.equalsIgnoreCase("chrome")) {
		   driver= new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("edge")) {
		   driver= new EdgeDriver();
		}else {
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		WebDriver_utility wu = new WebDriver_utility();
		wu.waitforPageTpLoad(driver);
		
		//login to application
		driver.get(URL);
		Login_page lp = new Login_page(driver);
		lp.getUsername().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLoginButton().click();
		
		//click on org link
		Home_page hp= new Home_page(driver);
		hp.getOrganizationlink().click();
		Java_Utility ju= new Java_Utility();
		
		//read data from excel file(script data)
		Excel_Utility eu= new Excel_Utility();
		String orgname = eu.getDataFromExcel("org", 1, 5)+ju.getRandomNumber();
		
		//create new 
		Creating_New_Organization_page cn= new Creating_New_Organization_page(driver);
		cn.getCreateorgimg().click();
		cn.getOrgnametf().sendKeys(orgname);
		cn.getSavebtn().click();
		Thread.sleep(3000);
		
		//go back to home page and search org name delete it
		hp.getOrganizationlink().click();
		Create_contact cc= new Create_contact(driver);
		cc.getSearchtf().sendKeys(orgname);
		wu.select(cc.getOrgnodd(), "Organization Name");
		cc.getSearchbtn().click();		
		driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		
		driver.switchTo().alert().accept();
		hp.logout();
		Thread.sleep(3000);
		driver.quit();
	}

}
