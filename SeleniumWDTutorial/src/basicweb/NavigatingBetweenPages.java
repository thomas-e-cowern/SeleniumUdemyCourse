package basicweb;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigatingBetweenPages {
	
	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		System.out.println("Get page title...");
		String title = driver.getTitle();
		System.out.println("The page title is " + title);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The page url is " + currentUrl);
		
		System.out.println("Navigate forward...");
		String stringToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
		driver.navigate().to("https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1");
		
		currentUrl = driver.getCurrentUrl();
		System.out.println("The page url is " + currentUrl);
		Thread.sleep(5000);
		
		System.out.println("Navigate back...");
		driver.navigate().back();
		currentUrl = driver.getCurrentUrl();
		System.out.println("The page url is " + currentUrl);
		Thread.sleep(5000);
		
		System.out.println("Navigate forward...");
		driver.navigate().forward();
		currentUrl = driver.getCurrentUrl();
		System.out.println("The page url is " + currentUrl);	
		
		System.out.println("Navigate back...");
		driver.navigate().back();
		currentUrl = driver.getCurrentUrl();
		System.out.println("The page url is " + currentUrl);
		Thread.sleep(5000);
		
		System.out.println("Refreshing the page...");
		driver.navigate().refresh();
		driver.get(baseUrl);
		
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
		System.out.println("Done!");
	}


}
