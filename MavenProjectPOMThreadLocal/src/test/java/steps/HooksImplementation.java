package steps;
/////////////////////////////////////////////////////////////////////////////
/////////This Class is user to have Pre and Post condition of test///////////
/////////This is similar to Before and After Method ////////////////////////
/////////////////////////////////////////////////////////////////////////

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksImplementation extends CucumberBase{
	
	//public  RemoteWebDriver driver;
	public String appURL = "https://login.salesforce.com/";
	
	@Before
	public void preCondition() {
		
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		setUp(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().get(appURL);
		System.out.println("Hooks Class is running");
	}
	
	
	@After
	public void postCondition() {
		
		getDriver().close();
	}
	

}
