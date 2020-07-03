package page.classes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NoFrameworkTest {

	private WebDriver driver;
	private String baseUrl;
	String testUrl;

	@Before
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", 
				"/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		testUrl = driver.getCurrentUrl();
		System.out.println("Url: " + testUrl);
	}

	@Test
	public void test() {
		
		if (testUrl.equals("https://www.expedia.com/?pwaLob=wizard-hotel-pwa-v2")) {
			System.out.println("Test one");
			driver.findElement(By.id("//button[@id='tab-flight-tab-hp']//span[@class='icons-container']")).click();
			driver.findElement(By.id("//button[@id='tab-flight-tab-hp']")).click();
			driver.findElement(By.id("flight-origin")).sendKeys("New York");
			driver.findElement(By.id("flight-destination")).sendKeys("Chicago");
			driver.findElement(By.id("flight-departing")).sendKeys("10/28/2014");
			driver.findElement(By.id("flight-returning")).sendKeys("10/31/2014");
			driver.findElement(By.id("search-button")).click();
		} else {
			System.out.println("Test two");
			driver.findElement(By.id("//button[@id='tab-flight-tab-hp']")).click();
			
		}	
	}


	@After
	public void afterClass() {
	}

}
