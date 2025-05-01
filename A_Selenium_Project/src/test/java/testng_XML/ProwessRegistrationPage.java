package testng_XML;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ProwessRegistrationPage {
		
		WebDriver driver;
		@Test(priority=1)
		void firstTest() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://prowessapps.in/testing/register");
		driver.findElement(By.id("firstname")).sendKeys("Harry");
		driver.findElement(By.id("lastname")).sendKeys("Potter");
		driver.findElement(By.id("email")).sendKeys("Harry@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9123448790");
		driver.findElement(By.id("male")).click();
		
		List <WebElement>hobbies=driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(hobbies.size());
		for(WebElement x:hobbies) {
			String z=x.getDomProperty("id");
//			System.out.println(z);
			if(z.equals("cricket")) {
				x.click();
			}
			if(z.equals("movies")) {
				x.click();
			}
			if(z.equals("cooking")) {
				x.click();
			}
		}
//		driver.findElement(By.xpath("//select[@id='Skills']")).click();
		List <WebElement>skills=driver.findElements(By.xpath("//*[@id=\"Skills\"]/option"));
		System.out.println(skills.size());
		for(WebElement skill:skills){
			String s=skill.getText();
			if(s.equals("Java")) {
				skill.click();
			}
		}
		
		
	}
		@Test(priority=2)
		void DOB() {
			List<WebElement> dates=driver.findElements(By.xpath("//select[@id='day']/option"));
			for(WebElement date:dates) {
				String d=date.getText();
				if(d.equals("12")) {
					date.click();
				}
			}
			
			List<WebElement> months=driver.findElements(By.xpath("//select[@id='month']/option"));
			for(WebElement month:months) {
				String m=month.getText();
				if(m.equals("December")) {
					month.click();
				}
			}
			
			List<WebElement> years=driver.findElements(By.xpath("//select[@id='year']/option"));
			for(WebElement year:years) {
				String y=year.getText();
				if(y.equals("1990")) {
					year.click();
				}
			}
			
		}
		@Test(priority=3)
		void address() {
		driver.findElement(By.id("address")).sendKeys("Shivaji Chowk, Phase 1,Hinjewadi, Pune, 411057");
		driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
		}
		
		@Test(priority=4)
		void register(){
			driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
		}

}