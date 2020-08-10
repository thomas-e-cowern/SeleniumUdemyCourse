package reports;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class SeleniumLoginTest3 {
	
	private static WebDriver driver;
	private static String baseUrl;
	static ExtentReports reports;
	static ExtentTest test;

	@BeforeClass
	public static void beforeClass() {
		reports = ExtentFactory.getInstance();
		test = reports.startTest("Verify Courses Text");
		baseUrl = "http://www.letskodeit.com/";
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();
		test.log(LogStatus.INFO, "Browser Started");

		// Maximize the browser's window
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser Maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Website opened");
	}
	
	@Test
	public void test1_validLoginTest() throws Exception {
		WebElement signupLink = driver.findElement(By.className("ast-button"));
		signupLink.click();
		test.log(LogStatus.INFO, "Click on signup link");
//		
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("test@email.com");
		test.log(LogStatus.INFO, "Enter email");
//		
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("abcabc");
		test.log(LogStatus.INFO, "Enter password");
//		
		WebElement goButton = driver.findElement(By.xpath("//input[@class='btn btn-default btn-block btn-md dynamic-button']"));
		goButton.click();
		test.log(LogStatus.INFO, "Click go button");
//		
		Thread.sleep(3000);
//		
		WebElement welcomeText = null;
//		
		try {
			welcomeText = driver.findElement(By.xpath("//h1[@class='dynamic-heading margin-bottom-20']"));
			test.log(LogStatus.INFO, "Chekcing text");
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(welcomeText != null);
	}
	
	@AfterClass
	public static void afterClass() {
//		driver.quit();
		System.out.println("We're done here!");
		reports.endTest(test);
		reports.flush();
	}

}
