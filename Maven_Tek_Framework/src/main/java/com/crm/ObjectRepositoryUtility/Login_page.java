package com.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.webdriverUtility.WebDriver_utility;

public class Login_page extends WebDriver_utility{
	WebDriver driver;
	public Login_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernametf;
	
	@FindBy(name="user_password")
	private WebElement passwordtf;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	public WebElement getUsername() {
		return usernametf;
	}

	public WebElement getPassword() {
		return passwordtf;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	//Business Librariy
	public void loginToApp(String url,String username, String password) {
	
		driver.manage().window().maximize();
		waitforPageTpLoad(driver);
		driver.get(url);
		usernametf.sendKeys(username);
		passwordtf.sendKeys(password);
		loginButton.click();
	}
	
}
