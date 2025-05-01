package z_assignments;

import org.testng.annotations.*;

public class Annotation2{
		@Test(priority=3)
		void testA() {
			System.out.println("this is testA from another class");
		}
		
		@Test(priority=4)
		void testB() {
			System.out.println("this is testB from another class");
		}
		//@AfterMethod
		void am() {
			System.out.println("this is after method");
		}
		
		@AfterClass
		void ac() {
			System.out.println("this is after class method");
		}
		
		@AfterTest
		void at() {
			System.out.println("this is after test method");
		}
		
		@AfterSuite
		void as() {
			System.out.println("this is after suite method");
		}
	
}
