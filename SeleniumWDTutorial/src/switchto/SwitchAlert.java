package switchto;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import waittypes.WaitTypes;

public class SwitchAlert {
	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/p/practice";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
//		System.setProperty("webdriver.chrome.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/chromedriver");
		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

	}
	
	@Test
	public void test1() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys("Testing");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	public void test2() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys("Testing");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		System.out.println("This test file is completed");
	}
}
