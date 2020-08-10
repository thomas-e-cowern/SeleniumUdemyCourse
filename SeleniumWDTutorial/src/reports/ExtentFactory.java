package reports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = "/Users/tcowern/Documents/SeleniumUdemyCourse/EReports/logintest.html";
		extent = new ExtentReports(Path, false);
		extent
	     .addSystemInfo("Selenium Version", "Who Knows?")
	     .addSystemInfo("Platform", "Mac");

		return extent;
	}
}
