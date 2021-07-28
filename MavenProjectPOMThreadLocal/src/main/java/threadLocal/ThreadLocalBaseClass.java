package threadLocal;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class ThreadLocalBaseClass {
	//ThreadLocal<WebDriverManager> driver =new ThreadLocal<WebDriverManager>();
	
	ThreadLocal<ChromeDriver> driver = new ThreadLocal<ChromeDriver>();
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup(); 
		driver.set(new ChromeDriver());					
	}
	
	public WebDriver getDriver() {
		return driver.get();
		
	}
	
}
