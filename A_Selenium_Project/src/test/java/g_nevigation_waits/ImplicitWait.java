package g_nevigation_waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


/*
 * Implicit Wait:
 * 		1. It is global wait applied to all element
 * 		2. give "NoSuchElementException" if element is not visible after timeout
 */

public class ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit command //will apply for all elements
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
					
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	
	}

}
