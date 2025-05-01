package p_ssl_Certificate;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSLCertification {

	public static void main(String[] args) {
		
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		
		//need to set proxy
		Proxy proxy = new Proxy();
		proxy.setAutodetect(false);
		proxy.setHttpProxy("proxy_url:port"); 
		proxy.setSslProxy("proxy_url:port");
		proxy.setNoProxy("no_proxy-var");
		
		option.setCapability("proxy", proxy);
		
		WebDriver driver=new ChromeDriver(option);
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println("Title of the page :"+ driver.getTitle());
		
		driver.quit();

	}

}
