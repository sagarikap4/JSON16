package testng_dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP_amazon_searchTest {
	@Test(dataProvider = "getData")
	public void getProductPrice(String brandname, String productname) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		String xpath= "//span[text()='"+productname+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span[1]";
		String proinfo = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(proinfo);
		driver.quit();
	}
		@DataProvider
		public Object[][] getData(){
			Object[][] objarray=new Object[3][2];
			objarray[0][0]="iphone";
			objarray[0][1]="Apple iPhone 13 (128GB) - Starlight";
			objarray[1][0]="iphone";
			objarray[1][1]="Apple iPhone 15 (128 GB) - Black";
			objarray[2][0]="iphone";
			objarray[2][1]="Apple iPhone 13 (128GB) - Pink";
			return objarray;	
		}
}
