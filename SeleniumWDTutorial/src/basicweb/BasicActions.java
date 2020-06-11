package basicweb;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicActions {
	
	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		System.out.println("Click on Login Link");
		driver.findElement(By.xpath("//a[@class='navbar-link fedora-navbar-link']")).click();
		System.out.println("Select email field and enter text...");
		driver.findElement(By.xpath("//input[@id='user_email']")).clear();
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("Billy@billy.com");
		System.out.println("Select password field and enter text...");
		driver.findElement(By.xpath("//input[@id='user_password']")).clear();
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@id='user_password']")).clear();
	}

}
