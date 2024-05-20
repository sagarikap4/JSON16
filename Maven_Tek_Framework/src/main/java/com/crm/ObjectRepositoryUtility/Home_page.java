package com.crm.ObjectRepositoryUtility;
/*
 * 
 * @author Nikitaba Parmar
 * 
 * */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
	WebDriver driver;
	public Home_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*CRM Home Page Web Elements*/
	@FindBy(linkText="Organizations")
	private WebElement Organizationlink;
	
	@FindBy(linkText ="Contacts")
	private WebElement contactlink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;

	public WebElement getOrganizationlink() {
		return Organizationlink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLogoutimg() {
		return logoutimg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	/*
	 * Url:https://www.Localhost:8888.com
	 * username: admin
	 * Password : admin
	 * 
	 * */
	public void logout() {
		Actions a = new Actions(driver);
		a.moveToElement(logoutimg);
		a.click(signoutlink);
	}
}
