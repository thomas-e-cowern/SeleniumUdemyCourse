package Data;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UsingExcel_SingleDataSet {
	
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.URL);
		driver.findElement(By.xpath("//div[@class='ast-button']")).click();
		// Tell the code about the location of Excel file
		ExcelUtility_SingleDataSet.setExcelFile(
				Constants.File_Path + Constants.File_Name_Write, "Sheet1");
	}

	@Test
	public void testUsingExcel() throws Exception {
		String username = ExcelUtility_SingleDataSet.getCellData(1, 0);
		String password = ExcelUtility_SingleDataSet.getCellData(1, 1);
		// Click login button
//		driver.findElement(By.xpath("//div[@id='navbar']//a[contains(text(),'Login')]")).click();
//		Thread.sleep(2000);
		// Enter username
		driver.findElement(By.xpath("//div[@class='text-center zen-login']//input[@id='email']")).sendKeys(username);
		// Enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		// Click Login button
		driver.findElement(By.xpath("//input[@class='btn btn-default btn-block btn-md dynamic-button']")).click();
		Thread.sleep(2000);
		
		// Find if error messages exist
		String text = driver.findElement(By.xpath("//span[@class='dynamic-text help-block']")).getText();
		  
		System.out.println("Error Text: " + text);
		
		Assert.assertEquals(text, "Your username or password is invalid. Please try again.");
		
		// Set the test result in the Excel file
		ExcelUtility_SingleDataSet.setCellData("Pass", 1, 2);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
	    driver.quit();
	}
	
}
