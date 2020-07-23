package listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class CustomListener1 implements IInvokedMethodListener {
	
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		//Before every method in the test class
		System.out.println("before invocation: " + testResult.getTestClass().getName() + " => " + method.getTestMethod().getMethodName());
	}
	
	public void afterInvocation(IInvokedMethod method, ITestResult testResults) {
		//After every method in the test class
		System.out.println("after invocation: " + method);
	}
	
	
}
