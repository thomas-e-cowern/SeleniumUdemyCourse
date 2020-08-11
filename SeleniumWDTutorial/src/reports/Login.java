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

public class Login {
	
	private static WebDriver driver;
	private static String baseUrl;
	static ExtentReports reports;
	static ExtentTest test;
	static HomePage hp;

	@BeforeClass
	public static void beforeClass() {
		reports = ExtentFactory.getInstance();
		test = reports.startTest("Verify Courses Text");
		baseUrl = "http://www.letskodeit.com/";
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();
		hp = new HomePage(driver, test);
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
		
//		hp.clickSignupLink();
//			
//		hp.enterEmail("test@email.com");
//	
//		hp.enterPassword("abcabc");
//	
//		hp.clickGoButton();
		
		hp.login("test@email.com", "abcabc");
		
		Thread.sleep(3000);
	
		boolean result = hp.isCoursesTextPresent();
		
		Assert.assertTrue(result);
		
	}
	
	@AfterClass
	public static void afterClass() {
		driver.quit();
		System.out.println("We're done here!");
		reports.endTest(test);
		reports.flush();
	}

}
