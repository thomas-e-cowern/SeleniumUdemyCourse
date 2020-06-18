package advancedinteractions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import waittypes.WaitTypes;

public class ScrollingElementIntoView {
	
	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/p/practice";
	WaitTypes wt;
	JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
//		System.setProperty("webdriver.chrome.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/chromedriver");
		driver = new FirefoxDriver();
//		driver = new ChromeDriver();

		wt = new WaitTypes(driver);
		js = (JavascriptExecutor) driver;
//		driver.manage().window().maximize();

		js.executeScript("window.location = 'https://letskodeit.teachable.com/p/practice\'");
	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0, 1900)");
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -1900)");
		
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("mousehover"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -190)");
	}
	
	@After
	public void tearDown() throws Exception {
//		driver.close();
		System.out.println("This test file is completed");
	}
}
