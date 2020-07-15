package exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParallelExercise {
	
	WebDriver driver;
	String baseUrl;

  
  	@BeforeClass
  	@Parameters({"browser"})
 	public void beforeClass(String browser) {
  		System.out.println("The browser is " + browser);
  		if (browser.equalsIgnoreCase("firefox")) {
  			System.out.println("Inside firefox");
	  		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  		} else {
  			System.out.println("Inside chrome");
	  		System.setProperty("webdriver.chrome.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  		}

  		
  	}
  
  	@Test
  	public void f() {
  		System.out.println("This is the test");
  	}

  	@AfterClass
  	public void afterClass() {
  		driver.quit();
  	}

}
	