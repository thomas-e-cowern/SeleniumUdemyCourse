package Data;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.junit.Assert;

public class UsingExcel {
	
  private static WebDriver driver;
  private static String baseUrl;
  
  @BeforeClass
  public void beforeClass() throws Exception {
	  	
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();
		
//		// Location of the Excel file
//		String path = Constants.File_Path;
//		String name = Constants.File_Name;
//		String sheetName = "Sheet1";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.URL);
		
		ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTests");
		
		driver.findElement(By.xpath("//div[@class='ast-button']")).click();
  }

  @DataProvider(name = "loginData")
  public Object [][] dataProvider() {
	  Object [][] testData = ExcelUtility.getTestData("Invalid_Login"); 
	  return testData;
  }
  
  @Test(dataProvider = "loginData")
  public void testUsindExcel(String username, String password) {
	  
	  driver.findElement(By.xpath("//div[@class='text-center zen-login']//input[@id='email']")).sendKeys(username);
	  
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	  
	  driver.findElement(By.xpath("//input[@class='btn btn-default btn-block btn-md dynamic-button']")).click();
  
	  String text = driver.findElement(By.xpath("//span[@class='dynamic-text help-block']")).getText();
	  
	  System.out.println("Error Text: " + text);
	  
	  Assert.assertEquals(text, "Your username or password is invalid. Please try again.");
	 
  }
  
  @AfterClass
  public void afterClass() {
  }

}
