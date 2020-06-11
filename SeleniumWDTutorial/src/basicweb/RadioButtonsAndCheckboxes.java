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

public class RadioButtonsAndCheckboxes {
	
	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/p/practice";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/geckodriver");
		driver = new FirefoxDriver();
//		driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		
		driver.get(baseUrl);
		
		WebElement bmwRadioBtn = driver.findElement(By.id("bmwradio"));
		bmwRadioBtn.click();
		
		Thread.sleep(1000);
		
		WebElement benzRadioBtn = driver.findElement(By.id("benzradio"));
		benzRadioBtn.click();

		Thread.sleep(1000);
		
		WebElement hondaRadioBtn = driver.findElement(By.id("hondaradio"));
		hondaRadioBtn.click();
		
		WebElement bmwCheck = driver.findElement(By.id("bmwcheck"));
		bmwCheck.click();
		
		Thread.sleep(1000);
		
		WebElement benzCheck = driver.findElement(By.id("benzcheck"));
		benzCheck.click();

		Thread.sleep(1000);
		
		WebElement hondaCheck = driver.findElement(By.id("hondacheck"));
		hondaCheck.click();
		
		benzCheck.click();
		
		System.out.println("bmw radio is selected: " + bmwRadioBtn.isSelected());
		System.out.println("benz radio is selected: " + benzRadioBtn.isSelected());
		System.out.println("honda radio is selected: " + hondaRadioBtn.isSelected());
		System.out.println("bwm checkbox is selected: " + bmwCheck.isSelected());
		System.out.println("benz checkbox is selected: " + benzCheck.isSelected());
		System.out.println("honda checkbox is selected: " + hondaCheck.isSelected());
	}
	

	@After
	public void tearDown() throws Exception {
		driver.quit();
		System.out.println("Done with radio buttons and checkboxes");
	}

	

}
