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

public class JavascriptClick {
	
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
		Thread.sleep(3000);
		WebElement checkbox = driver.findElement(By.id("bmwcheck"));
		js.executeScript("arguments[0].click()", checkbox);	
	}
	
	@After
	public void tearDown() throws Exception {
//		driver.close();
		System.out.println("This test file is completed");
	}
}
