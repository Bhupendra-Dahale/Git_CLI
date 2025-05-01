package z_assignments;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page_Object_Test {
		WebDriver driver;
		Page_Object_model POM;
	
	@BeforeClass
	void setup() 
	{
		System.out.println("setting up the environment");
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://ijmeet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("setup is done");
	}
	
	@Test
	void login() 
	{
		System.out.println("login started");
		
		POM=new Page_Object_model(driver);
		POM.Email("john221@gmail.com");
		POM.pass("Axa@999Hyd");
		POM.sign_in();
		
		System.out.println("login successful");
	}
	
	@Test
	void verification() 
	{
		System.out.println("verification is progress");
		
		POM.verification();
		
		System.out.println("verification is done");
	}
	
	@AfterClass
	void logout() {
		POM.sign_out();
		
		System.out.println("logged out successfully");
	}

}
