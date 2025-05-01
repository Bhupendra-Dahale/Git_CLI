package z_assignments;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependentMethodTest {
	
	@Test(priority=1)
	void openapp() {
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = "openapp")
	void login() {
		Assert.assertTrue(true);
	}
	
	@Test(dependsOnMethods = "login")
	void search() {
		Assert.assertTrue(true);
	}
	
	@Test(dependsOnMethods = "search")
	void logout() {
		Assert.assertTrue(true);
	}

}
