package testclasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNGReportsAndLogs {
 
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Reports and Logs Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Reports and Logs After Method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Reports and Logs Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Reports and Logs After Class");
  }
  
  @Test
  public void testOne() {
	  System.out.println("Reports and Logs Test One");
  }
  
  @Test
  public void testTwo() {
	  System.out.println("Reports and Logs Test Two");
	  Assert.assertTrue(false);
  }
  
  @Test(dependsOnMethods= { "testTwo" })
  public void testThree() {
	  System.out.println("Reports and Logs Test Three");
  }

}
