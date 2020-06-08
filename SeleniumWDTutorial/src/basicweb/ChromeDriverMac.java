package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverMac {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/tcowern/Documents/SeleniumUdemyCourse/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		String baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.get(baseURL);

	}

}
