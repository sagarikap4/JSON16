package testng_dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.generic.fileutility.Excel_Utility;

public class Dp_ExcelTest {
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
		public Object[][] getData() throws Throwable{
			Excel_Utility eu= new Excel_Utility();
			int rowcount = eu.getRowCount("product");
			Object[][] objarray=new Object[rowcount][2];
			for(int i=0;i<rowcount;i++) {
			objarray[i][0]=eu.getDataFromExcel("product", 1, 0);
			objarray[i][1]=eu.getDataFromExcel("product", 1, 1);
			}
			return objarray;	
		}
}
