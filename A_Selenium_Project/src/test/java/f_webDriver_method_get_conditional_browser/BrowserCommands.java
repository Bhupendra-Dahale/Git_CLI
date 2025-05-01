package f_webDriver_method_get_conditional_browser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCommands {

	public static void main(String[] args) throws InterruptedException {
		
//		WebDriver driver=new ChromeDriver();
		WebDriver driver=new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Thread.sleep(5000);	
		
		WebElement linkedin = driver.findElement(By.cssSelector("a[href*='www.linkedin.com']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView();",linkedin);
		linkedin.click();
		
		Thread.sleep(5000);
		//driver.close();  // single browser window

		driver.quit(); // all browser windows
	}

}
