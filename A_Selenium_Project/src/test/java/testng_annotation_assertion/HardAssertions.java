package testng_annotation_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

/*
 * Hard Assertion: [Assert] it stop the execution if Test case not true
 * 					all methods are static
 * Soft Assertion [Verify] it carry on the execution if Test case not true
 * 
 */
public class HardAssertions {

	@Test
	void test()
	{
		int x=10;
		int y=15;
		
		if(x==y)
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
		
		Assert.assertEquals(x,y);
		
		Assert.assertTrue(true);  //pass
		Assert.assertTrue(false);  //pass
		
		int a=10;
		int b=20;
		
		// Assert.assertEquals(actual, expected, description)
		Assert.assertEquals(a>b,true,"a is not greater than b");  //false
		
		
		String s1="abc";
		String s2="abc";
		
		Assert.assertEquals(s1,s2,"string are not equal"); // pass
		
		Assert.assertNotEquals(s1, s2);  // fail
		
		if(s1==s2)
		{
			Assert.assertTrue(true);
			Verify.verify(s1==s2, "values are not equal");
		}
		else
		{
//			Assert.assertTrue(false);
			Assert.fail();
			Verify.verify(s1!=s2, "values are equal");
			
		}
		
			
		
	}
	
}
