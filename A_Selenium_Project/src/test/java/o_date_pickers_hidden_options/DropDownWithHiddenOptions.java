package o_date_pickers_hidden_options;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownWithHiddenOptions {

	public static void main(String[] args) {
				
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();


		//Dropwdown
		driver.findElement(By.cssSelector("[href='/pim/viewPimModule']")).click();
		
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[6]/div//div[2]/div/div//div[2]/i")));
		dropdown.click();			// opens the dropdown
		
		List<WebElement> options=driver.findElements(By.xpath("//div[@role='listbox']/div/span"));
		
		for(WebElement option:options)
		{
			System.out.println(option.getText());
			if(option.getText().equals("Finance Manager"))
			{
				option.click();
				break;
			}
		}
		driver.quit();
	}

}
