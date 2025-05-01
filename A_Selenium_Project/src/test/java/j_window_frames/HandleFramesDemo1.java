package j_window_frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFramesDemo1 {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
				
		WebElement frame = driver.findElement(By.id("mce_0_ifr"));
		
		driver.switchTo().frame(frame);
		
		String editor = driver.findElement(By.xpath("//body[@id='tinymce']/p")).getText();// frame1
		
		System.out.println("Frame content : "+editor);
		
		driver.switchTo().defaultContent();// switch back to page

	}

}
