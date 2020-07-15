package exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParallelExercise {
	
	WebDriver driver;
	String baseUrl;

  
  	@BeforeClass
  	@Parameters({"browser"})
 	public void setUp(String browser) {
  		baseUrl = "https://letskodeit.teachable.com/";
  		if (browser.equalsIgnoreCase("firefox")) {
  			System.out.println("Inside firefox");
	  		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
			driver = new FirefoxDriver();
  		} else {
  			System.out.println("Inside chrome");
	  		System.setProperty("webdriver.chrome.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/chromedriver");
			driver = new ChromeDriver();
  		}
  		
  		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
  	}
  
  	@Test
  	public void testLogin() throws InterruptedException {
  		System.out.println("This is the test");
  		WebElement loginLink = driver.findElement(By.xpath("//a[contains(@href,'/sign_in')]"));
		loginLink.click();
		WebElement emailField = driver.findElement(By.id("user_email"));
		emailField.sendKeys("test@email.com");
		WebElement passwordField = driver.findElement(By.id("user_password"));
		passwordField.sendKeys("abcabc");
		WebElement loginButton = driver.findElement(By.name("commit"));
		loginButton.click();
  		
  	}

  	@AfterClass
  	public void cleanUp() {
//  		driver.quit();
  	}

}
	