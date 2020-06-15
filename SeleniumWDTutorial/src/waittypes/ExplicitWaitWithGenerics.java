package waittypes;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitWithGenerics {
	
	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/p/practice";
	WaitTypes wt;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		wt = new WaitTypes(driver);
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		WebElement loginLink = driver.findElement(By.linkText("Login"));
		loginLink.click();
		WebElement emailField = wt.waitForElement(By.id("user_email"), 3);
		emailField.sendKeys("Test Explicit wait");
		wt.clickWhenReady(By.name("commit"), 3);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
//		driver.quit();
		System.out.println("This test file is completed");
	}
}
