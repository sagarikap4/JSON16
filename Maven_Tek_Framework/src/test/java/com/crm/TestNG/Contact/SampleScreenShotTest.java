package com.crm.TestNG.Contact;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleScreenShotTest {
	
	@Test
	public void toTakeScreenShot() throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		EventFiringWebDriver eDriver= new EventFiringWebDriver(driver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./SS/test.png"));
		
	}
	

}
