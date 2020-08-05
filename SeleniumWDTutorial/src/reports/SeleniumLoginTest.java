package reports;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumLoginTest {
	
	private static WebDriver driver;
	private static String baseUrl;

	@BeforeClass
	public static void beforeClass() {
		baseUrl = "http://www.letskodeit.com/";
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void test1_validLoginTest() throws Exception {
		WebElement signupLink = driver.findElement(By.className("ast-button"));
		signupLink.click();
		
		WebElement loginLink = driver.findElement(By.linkText("Sign Up"));
		loginLink.click();
//		
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("test@email.com");
//		
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("abcabc");
//		
		WebElement goButton = driver.findElement(By.xpath("//input[@class='btn btn-default btn-block btn-md dynamic-button']"));
		goButton.click();
//		
//		Thread.sleep(3000);
//		
//		WebElement welcomeText = null;
//		
//		try {
//			welcomeText = driver.findElement(By.xpath("//div[text()='Hello test@email.com']"));
//		}
//		catch (NoSuchElementException e) {
//			System.out.println(e.getMessage());
//		}
//		Assert.assertTrue(welcomeText != null);
	}
	
	@AfterClass
	public static void afterClass() {
//		driver.quit();
		System.out.println("We're done here!");
	}
}