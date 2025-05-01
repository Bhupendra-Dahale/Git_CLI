package n_brokenLink_Sshot_HeadlessTesting;

import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessMode {
	
	@Test
	public void setup() {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");
	
	//OR

	//	options.setHeadless(true);
	options.setCapability("headless", true);
	}
	
}


//options.addArguments("--headless") - Arguments that are passed with cmd line args when executing the file e.g HeadlessMode.java --headless

//options.setHeadless(true); options.setCapability("headless", true); these option goes with chrome and execute with driver
