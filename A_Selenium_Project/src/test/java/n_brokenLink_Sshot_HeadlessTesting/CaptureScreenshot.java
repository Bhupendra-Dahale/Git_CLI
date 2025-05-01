package n_brokenLink_Sshot_HeadlessTesting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * FILE:
 * use when you need to save file on to the disk for logging and debugging purposes
 * 	pros:
 * 		Simplicity: ss already saved as file and no need of processing
 * 		Widely used: ss need to stored on disk for later use
 * 		Performance: no extra memory used after saving the file
 * 	cons:
 * 		Disk Dependency: method depends on disk I/O, which is slow comparative to in-memory processing
 * 		Limited Usage: we can only use file locally or upload it later
 * 
 * BYTES:
 * use when you need ss for dynamic purpose like embedding into the report, sending it over network or integrating with APIs
 * 	pros:
 * 		In-Memory Processing: return byte[] - real-time processing - easy to embed into report and send over a network
 * 		Flexibility: save it as file, attach it to email's, or use it in custom logging frameworks
 * 	cons:
 * 		Higher Memory Usage: entire ss is stored in memory, problematic for large ss or frequent calls
 * 		Additional Processing: extra coding steps required to save the file
 * 
 * BASE64:
 * use when need to embed directly to reports, logs, and send via API
 * 	pros:
 * 		Compact Encoding: return base64 string, directly embed into HTML, logs, or APIs
 * 		Web/Report Friendly: ideal for embed images into HTML report or JSON payload without needing separate file
 * 		No Disk Dependency: no temp file created - lightweight for system with limited disk access
 * 	cons:
 * 		Performance Overhead: Base64 encoding increases the size of ss by 33% (need to decode)
 * 
 * Note: Bytes for flexibility	(writing the file explicitly to store it)
 * 		 File for simplicity	(Automatically save the file on local system)
 * 		 Base64 for embedding	(Decoding and then writing file explicitly to store it)
 */
public class CaptureScreenshot {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();
		
		Random ranNo = new Random();
		
		//Capture full page screenshot - selenium 3 & 4
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(System.getProperty("user.dir")+"/src/test/resources/Screenshots/fullpage"+ranNo.nextInt()+".png");
		FileUtils.copyFile(src, trg);
		
		System.out.println(System.getProperty("user.dir"));
		
		// capture screenshot of specific area from webpage -- selenium 4+
		
		WebElement featuredproducts=driver.findElement(By.cssSelector(".homepage-slider-bottom"));
		
		File src1=featuredproducts.getScreenshotAs(OutputType.FILE);
		File trg1=new File(System.getProperty("user.dir")+"/src/test/resources/Screenshots/featureproducts"+ranNo.nextInt()+".png");
		FileUtils.copyFile(src1, trg1);
		
		
		// capture screenshot of specific Web element -- selenium 4+
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='OrangeHRM Logo']//parent::a"));
		
		File src2=logo.getScreenshotAs(OutputType.FILE);
		File trg2=new File(System.getProperty("user.dir")+"/src/test/resources/Screenshots/logo"+ranNo.nextInt()+".png");
		FileUtils.copyFile(src2, trg2);
		
		//Taking Screenshot as BYTES
		byte sshot[] = logo.getScreenshotAs(OutputType.BYTES);
		FileOutputStream fileoutput = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/Screenshots/logo_byte_"+ranNo.nextInt()+".png");
		fileoutput.write(sshot);
		
		//Taking Screenshot as Base64
		String sshot2 = logo.getScreenshotAs(OutputType.BASE64);
		byte[] decode = Base64.getDecoder().decode(sshot2);				//decoding the encoded base64 string to byte array for writing
		FileOutputStream fileoutput2 = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/Screenshots/logo_base64_"+ranNo.nextInt()+".png");
		fileoutput2.write(decode);
		
		
		driver.quit();
	}
}
