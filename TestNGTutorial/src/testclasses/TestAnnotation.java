package testclasses;

import org.testng.annotations.Test;
import appcode.SomeClassToTest;

public class TestAnnotation {
	
  @Test
  public void testMethod1() {
	  SomeClassToTest obj = new SomeClassToTest();
	  int result = obj.sumNumbers(1, 2);
	  System.out.println("Running test method 1");
	  
  }
  
  @Test
  public void testMethod2() {
	  System.out.println("Running test method 2");
  }
  
  @Test
  public void testMethod3() {
	  System.out.println("Running test method 3");
  }

}
