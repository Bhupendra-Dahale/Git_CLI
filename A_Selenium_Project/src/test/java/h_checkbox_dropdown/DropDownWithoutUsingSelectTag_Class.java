package h_checkbox_dropdown;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutUsingSelectTag_Class {
		public static void main(String args[]) throws InterruptedException {
			
			WebDriver driver=new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.manage().window().maximize();
			driver.get("https://bugbug.io/blog/testing-frameworks/best-selenium-practice-websites/");
			
			driver.findElement(By.xpath("//span[text()='Resources']")).click();
			List<WebElement> myList=driver.findElements(By.xpath("//ul[@class='ContentMenu_ContentMenu__nestedMenu__YGG1z']/li/a/span"));
//			OR
//			ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.xpath("//ul[@class='ContentMenu_ContentMenu__nestedMenu__YGG1z']/li/a/span"));
			
			System.out.println("total no of elements are:" + myList.size());
			
			
			for(WebElement ele:myList) {
				
				String dropdown=ele.getText();
				System.out.println(dropdown);
				
				if(dropdown.equals("Test Automation Guides")) {
				ele.click();
				}
			}
			
			Thread.sleep(3000);
			
			driver.close();
		}
}
