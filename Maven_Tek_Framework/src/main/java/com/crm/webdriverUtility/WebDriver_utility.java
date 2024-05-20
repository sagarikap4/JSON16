package com.crm.webdriverUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriver_utility {
	public void waitforPageTpLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchToTabOnUrl(WebDriver driver, String partialurl) {
		Set<String> allid = driver.getWindowHandles();
		for(String id:allid) {
			driver.switchTo().window(id);
			String acturl = driver.getCurrentUrl();
			if(acturl.contains(partialurl)) {
				break;
			   }
	        }
		}
	public void switchToTabTitle(WebDriver driver, String partialtitle) {
		Set<String> allid = driver.getWindowHandles();
		for(String id:allid) {
			driver.switchTo().window(id);
			String acttitle = driver.getTitle();
			System.out.println(acttitle);
			if(acttitle.contains(partialtitle)) {
				break;
			   }
	        }
		}
	public void SwitchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void SwitchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	public void SwitchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	public void SwitchToFrame(WebDriver driver, String nameid) {
		driver.switchTo().frame(nameid);
	}
	public void SwitchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void select(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	public void select(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	public void select(String value,WebElement element) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void mouseMoveOnElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	public void rigthClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
}
