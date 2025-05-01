package g_nevigation_waits;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//Fluent wait declaration
		
		//this is given notification to add generic type which is define in the OR example but this will also work
		
//		FluentWait mywait=new FluentWait(driver)
//		.withTimeout(Duration.ofSeconds(30))
//	    .pollingEvery(Duration.ofSeconds(5))
//	    .ignoring(NoSuchElementException.class);
		
	    //OR
//	    Wait is Interface and FluentWait is Class hence we need to use FluentWait to create Object
//		and it is called Upcasting : ParentClass() obj = new ChildClass();
		
		
	    Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)	
	    .withTimeout(Duration.ofSeconds(20))
	    .pollingEvery(Duration.ofSeconds(10))
	    .ignoring(NoSuchElementException.class);
			
		//usage
	    WebElement username=(WebElement) mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		username.sendKeys("Admin");
		
	}

}
