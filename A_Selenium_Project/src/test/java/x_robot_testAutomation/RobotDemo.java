package x_robot_testAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	
public class RobotDemo {
	
	public static void main(String[] args) throws AWTException {
		
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.findElement(By.className("gLFyf")).sendKeys("myntra");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		
		}
}
