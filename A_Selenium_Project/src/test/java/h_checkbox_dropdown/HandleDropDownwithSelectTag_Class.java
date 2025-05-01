package h_checkbox_dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDownwithSelectTag_Class {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/dropdown");
		driver.manage().window().maximize();
		
		
		WebElement drpCountryEle=driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select drpCountry=new Select(drpCountryEle);
		
		//1) Selecting an option from the dropdown
		drpCountry.selectByVisibleText("Option 1");
		drpCountry.selectByValue("2"); // use this only if value attribute is present for option tag
		drpCountry.selectByIndex(1); //France
		
		// 2) Find total options in dropdown
		List<WebElement> options=drpCountry.getOptions();
		System.out.println("total number of options:"+options.size());
		
		//3) print options in console window
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
		
		//using enhanced loop
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
			
	}

}

