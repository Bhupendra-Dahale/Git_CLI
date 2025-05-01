package z_assignments;

import org.testng.annotations.*;

public class Annotation {
		@BeforeSuite
		void bs() {
			System.out.println("this is before suite method");
		}
		
		@BeforeTest
		void bt() {
			System.out.println("this is before test method");
		}
		
		@BeforeClass
		void bc() {
			System.out.println("this is before class method");
		}
		
		//@BeforeMethod
		void bm() {
			System.out.println("this is before method");
		}
		
		@Test(priority=1)
		void test1() {
			System.out.println("this is test1");
		}
		
		@Test(priority=2)
		void test2() {
			System.out.println("this is test2");
		}
	
}
