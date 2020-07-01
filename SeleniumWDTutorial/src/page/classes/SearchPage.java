package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

public static WebElement element = null;
	
	/**
	 * Returns the flight origin text box element
	 * @param driver
	 * @return
	 */
	public static WebElement originTextBox(WebDriver driver) {
//		element = driver.findElement(By.id("flight-origin"));
		element = driver.findElement(By.xpath("//div[@id='location-field-leg1-origin-menu']//button[@class='uitk-faux-input']"));
		return element;
	}
	
	public static void fillOriginTextBox(WebDriver driver, String origin) {
		element = originTextBox(driver);
		element.sendKeys(origin);
	}

	/**
	 * Returns the flight destination text box element
	 * @param driver
	 * @return
	 */
	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-destination"));
		return element;
	}

	/**
	 * Returns the departure date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement departureDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-departing"));
		return element;
	}

	/**
	 * Returns the return date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement returnDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-returning"));
		return element;
	}

	/**
	 * Returns the search button box element
	 * @param driver
	 * @return
	 */
	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.id("search-button"));
		return element;
	}

	/**
	 * Click on search button
	 * @param driver
	 */
	public static void clickOnSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
	}
	
	/**
	 * Navigate to flights tab
	 * @param driver
	 */
	public static void navigateToFlightsTab(WebDriver driver) {
//		driver.findElement(By.id("header-history")).click();
//		element = driver.findElement(By.id("tab-flight-tab"));
		element = driver.findElement(By.xpath("//body[@class='uitk-no-outline']/div[@id='app']/div/div[@class='app-layer-base--active']/div[@class='uitk-grid pageWhiteBackground']/div[@class='uitk-cell Storefront-Homepage']/div[@class='StorefrontWizardRegionBEX all-b-margin-twelve']/div/figure[@class='uitk-image bexHeroImageFigure']/div[@class='wizardCard all-t-padding-twelve all-x-padding-six SimpleContainer']/div[@class='uitk-card uitk-grid all-cell-1-1 elevation-4']/div[@class='uitk-cell lobFormInCard']/div[@class='uitk-tabs-container']/ul[@class='uitk-tabs uitk-tabs-natural background-white uitk-tabs-default uitk-tabs-icon-text lobNavigationFormWithTabs formAlignedTabs all-x-padding-six']/li[2]/a[1]/*[1]"));
		element.click();
	}

}
