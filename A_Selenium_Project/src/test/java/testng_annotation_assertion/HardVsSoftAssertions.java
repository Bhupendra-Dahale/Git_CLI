package testng_annotation_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

public class HardVsSoftAssertions {

	//@Test
	void test_hardassertions()
	{
		
		System.out.println("testing....");

		Assert.assertEquals(1, 2);  // if it will fail then below statement will not be executed..
		
		System.out.println("hard assertion completed.....");
		Assert.assertEquals(1, 1);
	}
	
	@Test
	void test_softassertions()
	{
		System.out.println("testing....");

		SoftAssert sa=new SoftAssert();
		sa.assertEquals(1, 2); 
		
		System.out.println("soft assertion completed.....");
		//sa.assertEquals(1, 1);
		
		sa.assertAll(); // mandatory to execute all asserts
		
		
		String s1="abc";
		String s2="abc";
		
		Assert.assertEquals(s1,s2,"string are not equal"); // pass
		
		Assert.assertNotEquals(s1, s2);  // fail					//Assert: if element not present it fail the test
		
		if(s1==s2)
		{
			Verify.verify(s1==s2, "values are not equal");			//Verify: if element not present test carry on executing
		}
		else
		{
			Verify.verify(s1!=s2, "values are equal");
		}
	
	}
	
}


