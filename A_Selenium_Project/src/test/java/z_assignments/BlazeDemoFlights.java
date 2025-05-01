package z_assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlazeDemoFlights {
	public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		
		//From Flights
		List<WebElement> depart=driver.findElements(By.xpath("//select[@name=\"fromPort\"]/option"));
		System.out.println("Flights from cities are :");
		for(WebElement city:depart) {
			String c=city.getText();
			System.out.println(c);
			if(c.equals("Mexico City")) {
				city.click();
			}
		}
		System.out.println();
		
		//To Flights
		List<WebElement> dest=driver.findElements(By.xpath("//select[@name=\"toPort\"]/option"));
		System.out.println("Flights to cities are :");
		for(WebElement citty:dest) {
			String d=citty.getText();
			System.out.println(d);
			if(d.equals("New York")) {
				citty.click();
			}
		}
		
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		
		//Number of Rows
		List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println(rows.size());
		
		//List of select button
		List<WebElement> buttons=driver.findElements(By.xpath("//table/tbody/tr/td[1]/input"));
		
		List<Double> amt=new ArrayList<Double>();
		
		for(int r=1; r<=rows.size(); r++) {
			WebElement price=driver.findElement(By.xpath("//table/tbody/tr["+r+"]/td[6]"));
			String p=price.getText();
//			System.out.println(p);
			double amount=Double.parseDouble(p.substring(p.indexOf("$")+1));
//			System.out.println(amount);
			amt.add(amount);
			Collections.sort(amt);
//			System.out.println(amt);
		}
		
		Thread.sleep(3000);
		for(int r=1; r<=rows.size(); r++) {
			WebElement bt=driver.findElement(By.xpath("body > div.container > table > tbody > tr:nth-child("+r+") > td:nth-child(1) > input"));
			System.out.println(bt.getDomAttribute("class"));
			WebElement price=driver.findElement(By.xpath("//table/tbody/tr["+r+"]/td[6]"));
			String p=price.getText();
			double amount=Double.parseDouble(p.substring(p.indexOf("$")+1));
			for(double x:amt) {
					if(x==amount) {
						bt.click();
						break;
					}	
				}
			}
		
		
//		Collections.sort(amt,Collections.reverseOrder());
//		System.out.println(amt);
		
		
	}
	
}
