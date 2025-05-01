package z_assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

public class Page_Object_model {
		WebDriver driver;
		
	public Page_Object_model(WebDriver driver) {
		this.driver=driver;
//		PageFactory.initElements(this.driver, driver);
	}
	
	By btn=By.xpath("//a[@class='nav-link nav-right-cutom-bg font-weight-bold']");
	By txt_email=By.id("email");
	By txt_pass=By.id("password");
	By btn_signin=By.xpath("//button[normalize-space()='Sign In']");
//	By btn_signin=By.xpath("//button[contains(text(),' Sign In ')]");
	By lable=By.xpath("//span[normalize-space()='My Account']");
	
	//this is using pagefactory method
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lable1;
	
	public void Email(String email) {
		driver.findElement(btn).click();
		driver.findElement(txt_email).sendKeys(email);
	}
	
	public void pass(String pass) {
		driver.findElement(txt_pass).sendKeys(pass);
	}
	
	public void sign_in() {
		driver.findElement(btn_signin).click();
	}
	
	public boolean verification() {
		boolean status=driver.findElement(lable).isDisplayed();
		return status;
	}
	
	public void sign_out() {
		driver.close();
	}

}
