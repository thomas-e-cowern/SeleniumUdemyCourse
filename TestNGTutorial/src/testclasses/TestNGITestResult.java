package testclasses;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TestNGITestResult {
	
  @Test
  public void testMethod1() {
	  System.out.println("Running --> Test Method One");
	  Assert.assertTrue(false);
  }
  
  @Test
  public void testMethod2() {
	  System.out.println("Running --> Test Method Two");
	  Assert.assertTrue(true);
  }
  
  @AfterMethod
  public void afterMethod(ITestResult result) {
	  System.out.println(result.getMethod().getMethodName());
  }

}
