package x_robot_testAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleClass {
	
	public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(5000);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(5000);
		
		/*
		//Getting the dash-board title and comparing with the expected title "OrangeHRM"
		
		String act_title=driver.getTitle();
		String exp_title="OrangeHRM";
		
		if(act_title.equals(exp_title)) {
			System.out.println("Title matched test is passed");
		}
		else {
			System.out.println("Title didn't matched test is failed");
		}
		*/
		
		//validation of successful login by using dash-board tag
		
		String act_title="";
		try {
			act_title=driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
			}
		catch (NoSuchElementException e) { }
		
		String exp_title="Dashboard";
		
		if(act_title.equals(exp_title)) {
			System.out.println("Title "+act_title+" is matched so test is passed");
		}
		else {
			System.out.println("Title didn't matched test is failed");
		}
		
		driver.close();
	}

}
