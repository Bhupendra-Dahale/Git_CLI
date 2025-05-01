package z_assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Driver_demo {
	public static void main(String args[]) {
		
//		System.setProperties("webdriver.chrome.driver","path");
//		WebDriverManager.chromedriver().setup();
		
//		WebDriverManager.chromedriver().setup();   //it's not required from new version of selenium
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		driver.close();
		
	}
}