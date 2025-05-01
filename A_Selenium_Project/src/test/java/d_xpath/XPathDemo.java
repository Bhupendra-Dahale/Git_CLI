package d_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Absolute Xpath - html/body/form/input[3]
 * Relative Xpath - //form/input[3]
 * Chained Xpath - //form[@id='loginForm']//input[@name='username']
 * By tag (id, class, name, etc.) - //input[@id='username']
 *  
 * Functions ():
 * Contains() - 	//tag_name[contains(@attribute,"value_of_attribute")]
 * text()  -		//tag_name[text()= "Text of the element"]
 * starts-with() - //tag_name[starts-with(@attribute,"Part_of_Attribute_value")]
 * 
 * Operator:
 * And - //input[@id='username' and @class='xyz']
 * Or -  //input[@id='username' or @class='xyz']
 * */
public class XPathDemo {

	public static void main(String[] args) {
		
	
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		String relativeXpathproductname= driver.findElement(By.xpath("//a[normalize-space()='MacBook']")).getText(); 
		
		String absoluteXpathproductname= driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/h4[1]/a[1]")).getText();
				
		System.out.println(relativeXpathproductname);
		System.out.println(absoluteXpathproductname);
		
	}

}
