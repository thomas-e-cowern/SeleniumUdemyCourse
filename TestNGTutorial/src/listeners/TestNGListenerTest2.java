package listeners;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Listeners(CustomListener1.class)
public class TestNGListenerTest2 {
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is the code in beforeClass");
  }

  @Test
  public void test1() {
	  System.out.println("This is the code in test1");
	  Assert.assertTrue(true);
  }
  
  @Test
  public void test2() {
	  System.out.println("This is the code in test2");
	  Assert.assertTrue(false);
  }
  
  @AfterClass
  public void afterClass() {
	  System.out.println("This is the code in afterClass");
  }

}
