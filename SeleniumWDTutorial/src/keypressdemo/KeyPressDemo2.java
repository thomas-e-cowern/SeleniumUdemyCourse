package keypressdemo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyPressDemo2 {

	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/p/practice";
	JavascriptExecutor jse;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
//		System.setProperty("webdriver.chrome.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/chromedriver");
		driver = new FirefoxDriver();
		jse = (JavascriptExecutor)driver;
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	
	@Test
	public void test() throws InterruptedException {
		Thread.sleep(2000);
		String selectAll = Keys.chord(Keys.COMMAND + "a");
//		driver.findElement(By.id("openwindow")).sendKeys(Keys.COMMAND + "a");
//		driver.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.COMMAND + "a"));
		driver.findElement(By.id("openwindow")).sendKeys(selectAll);
		Thread.sleep(2000);

	}

	@After
	public void tearDown() throws Exception {
//		driver.close();
		System.out.println("This test file is completed");
	}

	

}
