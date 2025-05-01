package o_date_pickers_hidden_options;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo {

	public static void main(String[] args) throws InterruptedException{
				
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0); //switth to frame
		
		//Appraoch 1
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/15/2022"); // mm/dd/yyyy
		
		//Approach2
		String year="2025";
		String month="February";
		String date="4";
				
		driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // will open the date picker
			
		
		//select month & year
		while(true)
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			String mon=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(mon.equals(month) && yr.equals(year))
			{
				break;
			}
			
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();  // Future date
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();   //Past date
		}
		
		
		//select date
		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
		
		//OR
		
		for(int i=0;i<allDates.size();i++)
		{
			if(allDates.get(i).getText().equals(date))
			{
				allDates.get(i).click();
				break;
			}
				
		}
		
		//OR
		int monthNo=0;
		switch(month) {
			case "January": monthNo=1; break;
			case "February": monthNo=2; break;
			case "March": monthNo=3; break;
			case "April": monthNo=4; break;
			case "May": monthNo=5; break;
			case "June": monthNo=6; break;
			case "July": monthNo=7; break;
			case "August": monthNo=8; break;
			case "September": monthNo=9; break;
			case "October": monthNo=10; break;
			case "November": monthNo=11; break;
			case "December": monthNo=12; break;
		}
		
		WebElement calenderdate = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[@data-month='"+ (monthNo-1) +"' and @data-year ='"+year+"']/a[@data-date='"+date+"']"));
		System.out.println(calenderdate.getText());
		calenderdate.click();
		
		Thread.sleep(10000);
		driver.quit();
		
	}

}




