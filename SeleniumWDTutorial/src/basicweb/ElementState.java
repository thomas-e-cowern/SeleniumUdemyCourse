package basicweb;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ElementState {
	
	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
//		driver = new FirefoxDriver();
		driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		baseUrl = "https://www.google.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement element = driver.findElement(By.name("q"));
		System.out.println("element is enabled? " + element.isEnabled());
		element.sendKeys("Test search...");
		String testText = driver.findElement(By.name("q")).getAttribute("value");
		System.out.println("Test text is " + testText);
				
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
		System.out.println("Done!");
	}

	

}
