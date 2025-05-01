package m_javaScript_keyboard_scroll_tabsandwindows;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractwithElementsUsingJS {

	public static void main(String[] args) throws InterruptedException  {
		
		WebDriver driver=new ChromeDriver();
		
		//ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
				
//		Casting object driver as object JavascriptExecutor
		JavascriptExecutor js=(JavascriptExecutor) driver;
//		JavascriptExecutor js=driver;
		
		
		//First name - inputbox
		WebElement inputbox=driver.findElement(By.id("name"));
		js.executeScript("arguments[0].setAttribute('value','john')", inputbox);
		
		Thread.sleep(3000);
		
		//Radio button
		WebElement male_Rd=driver.findElement(By.id("male"));
		js.executeScript("arguments[0].scrollIntoView();", male_Rd);
		js.executeScript("arguments[0].click();",male_Rd);
		
		Thread.sleep(3000);
		
		//Checkbox
		WebElement chkbox=driver.findElement(By.id("friday"));
		js.executeScript("arguments[0].scrollIntoView();", chkbox);
		js.executeScript("arguments[0].click();",chkbox);
		
		Thread.sleep(5000);
		
		//button
		WebElement color=driver.findElement(By.cssSelector("[href*='opensource-demo.orangehrmlive.com']"));
		js.executeScript("arguments[0].scrollIntoView();", color);
		js.executeScript("arguments[0].click();",color);
		
				
	}

}
