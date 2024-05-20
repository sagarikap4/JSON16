package com.crm.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Parameters;

import com.crm.DatabaseUtility.DataBase_Utility;
import com.crm.ObjectRepositoryUtility.Home_page;
import com.crm.ObjectRepositoryUtility.Login_page;
import com.crm.generic.fileutility.Excel_Utility;
import com.crm.generic.fileutility.File_Utility;
import com.crm.webdriverUtility.Java_Utility;
import com.crm.webdriverUtility.WebDriver_utility;

public class Base_Class {
	public  WebDriver driver;
	public DataBase_Utility du = new DataBase_Utility();
	public File_Utility fu = new File_Utility();
	public Java_Utility ju= new Java_Utility();
	public Excel_Utility eu = new Excel_Utility();
	public WebDriver_utility wu= new WebDriver_utility();
	public Login_page lp;
	
	@BeforeSuite//(groups= {"Smoke Testing","Regration Testing"})
	public void connectToDatabase() throws Throwable {
		du.getConnection();
	}
	@Parameters("BROWSER")
	@BeforeClass//(groups= {"Smoke Testing","Regration Testing"})
	public void lunchTheBrowser(String browser) throws Throwable {
		String Browser =browser;// fu.getDataFromPropertyFile("browser");
		if(Browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if (Browser.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else if (Browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}else {
			driver= new ChromeDriver();
		}
	}
	@BeforeMethod//(groups= {"Smoke Testing","Regration Testing"})
	public void login() throws Throwable {
		String URL = fu.getDataFromPropertyFile("url");
		String Username = fu.getDataFromPropertyFile("username");
		String Password = fu.getDataFromPropertyFile("password");
		lp= new Login_page(driver);
		lp.loginToApp(URL, Username, Password);	
	}
	@AfterMethod//(groups= {"Smoke Testing","Regration Testing"})
	public void logout() throws InterruptedException {
		
		Thread.sleep(3000);
		Home_page hp = new Home_page(driver);
		//hp.logout();
		WebDriver_utility wu= new WebDriver_utility();
		wu.mouseMoveOnElement(driver, hp.getLogoutimg());
		hp.getSignoutlink().click();
		System.out.println("Sign out");
	}
	@AfterClass//(groups= {"Smoke Testing","Regration Testing"})
	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser closed");
	}
	
	@AfterSuite//(groups= {"Smoke Testing","Regration Testing"})
	public void disconnectToDatabase() throws Throwable {
		du.closeConnection();
		System.out.println("connection close");
	}
}
