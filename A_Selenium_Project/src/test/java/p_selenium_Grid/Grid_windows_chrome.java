package p_selenium_Grid;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Grid_windows_chrome {
		
	WebDriver driver;
	
	@Test(priority=1)
	void setup() throws MalformedURLException, URISyntaxException {
		
		String nodeURL="http://10.217.233.251:61865/wd/hub";		// The URL will be
																	//  IP Address of Hub Machine + Hub Port + /wd/hub
																	// "http://192.168.13.1:4444/wd/hub"
																	// Here Hub and Node are same machines
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setBrowserName("chrome");
//		cap.setPlatform(Platform.WIN11);
		//OR
		ChromeOptions option=new ChromeOptions();
		option.setCapability("browserName","chrome");
		option.setCapability("platformName","windows 11");
		
		driver=new RemoteWebDriver(new URI(nodeURL).toURL(), option);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	@Test(priority=2)
	void Login() {
		
		driver.get("http://practice.automationtesting.in/my-account/");
		driver.findElement(By.id("username")).sendKeys("bhupendra_dahale");
		driver.findElement(By.id("password")).sendKeys("Bhu@1234#1234");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		String captext=driver.findElement(By.xpath("//strong[normalize-space()='bhupendra_dahale']")).getText();
		
		if(captext.contains("bhupendra_dahale")) {
			System.out.println("Test is passed :" + "Welcome " + captext);
		}else {
			System.out.println("Test is failed :");
		}
		
		driver.quit();
	}

}
