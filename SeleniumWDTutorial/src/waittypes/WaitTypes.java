package waittypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
	
	WebDriver driver;
	
	public WaitTypes(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForElement (By locator, int timeout) {
		WebElement element = null;
		try {
			System.out.println("Watiing for " + timeout + " seconds");
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element appeared on the page");
		} catch (Exception e) {
			System.out.println("Element is not on the webpage");
		}
		return element;
	}
	
	public void clickWhenReady (By locator, int timeout) {
		WebElement element = null;
		try {
			System.out.println("Watiing for " + timeout + " seconds");
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("Element on the page clicked");
		} catch (Exception e) {
			System.out.println("Element is not on the webpage");
		}
	}
	
	
}
