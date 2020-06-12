package basicweb;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ElementDisplayed {
	
	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/p/practice";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
//		System.setProperty("webdriver.chrome.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/chromedriver");
		driver = new FirefoxDriver();
//		driver = new SafariDriver();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Textbox displayed: " + textBox.isDisplayed());
		
		Thread.sleep(1000);
		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		hideButton.click();
		System.out.println("Hiding text box");
		
		Thread.sleep(1000);
		System.out.println("Textbox displayed: " + textBox.isDisplayed());
		
		Thread.sleep(1000);
		WebElement showButton = driver.findElement(By.id("show-textbox"));
		showButton.click();
		System.out.println("Showing text box");

	}
	
	@After
	public void tearDown() throws Exception {
//		driver.quit();
		System.out.println("Done with select elements");
	}

	

}
