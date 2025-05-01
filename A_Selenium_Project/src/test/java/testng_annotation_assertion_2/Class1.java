package testng_annotation_assertion_2;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1 {

	@Test
	void abc()
	{
		System.out.println("this is abc test from Class 1");
	}
	
	@BeforeTest
	void m()
	{
		System.out.println("this is before test...");
	}
	
	@BeforeSuite
	void bs()
	{
	 System.out.println(" this is Before suite...");	
	}
	
	@AfterSuite
	void as()
	{
		System.out.println("this is After suite...");
	}
}
