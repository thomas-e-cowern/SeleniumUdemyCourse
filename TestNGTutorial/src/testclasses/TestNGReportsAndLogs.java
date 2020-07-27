package testclasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class TestNGReportsAndLogs {
 
  @BeforeMethod
  public void beforeMethod() {
	  Reporter.log("Reports and Logs Before Method", false);
  }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log("Reports and Logs After Method", false);
  }

  @BeforeClass
  public void beforeClass() {
	  Reporter.log("Reports and Logs Before Class", false);
  }

  @AfterClass
  public void afterClass() {
	  Reporter.log("Reports and Logs After Class", false);
  }
  
  @Test
  public void testOne() {
	  Reporter.log("Reports and Logs Test One", false);
  }
  
  @Test
  public void testTwo() {
	  Reporter.log("Reports and Logs Test Two", false);
	  Assert.assertTrue(false);
  }
  
  @Test(dependsOnMethods= { "testTwo" })
  public void testThree() {
	  Reporter.log("Reports and Logs Test Three", false);
  }

}
