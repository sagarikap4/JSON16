package com.crm.contactTest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

import com.crm.ObjectRepositoryUtility.Login_page;
import com.crm.generic.fileutility.Excel_Utility;
import com.crm.generic.fileutility.File_Utility;
import com.crm.webdriverUtility.Java_Utility;
import com.crm.webdriverUtility.WebDriver_utility;

public class Contect_TestCase_01 {
	public static void main(String[] args) throws Throwable {
		File_Utility fu =new File_Utility();
		String Browser = fu.getDataFromPropertyFile("browser");
		String URL = fu.getDataFromPropertyFile("url");
		String Username = fu.getDataFromPropertyFile("username");
		String Password = fu.getDataFromPropertyFile("password");
		
		Java_Utility ju= new Java_Utility();
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
		Login_page lp = new Login_page(driver);
		//lp.loginToApp(Username, Password);
		lp.getUsername().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.getLoginButton().click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contact);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		File temp = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getScreenshotAs(OutputType.FILE);
		File source = new File("./ss/contact.png");
		FileHandler.copy(temp, source);
		if(headerinfo.contains(contact)) {
			System.out.println(contact+" contact created successfully==> Pass");
		}else {
			System.out.println(contact+" contact not created==> Fail");
		}
		driver.quit();
	}
}
