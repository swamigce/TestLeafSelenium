package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberSFDCLobin extends CucumberBase{
	
	public String appURL = "https://login.salesforce.com/";
	//public String userName = "mercury.bootcamp@testleaf.com";
	//public String passWord = "Bootcamp@123";
	
	@Given ("Launch the ChromeBworser")
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Given ("Load SFDC URL")
	public void loadAppUrl() {
		getDriver().get(appURL);
		
	}

	@Given ("Enter userName as {string}")
	public void enterUserName(String struserName) {
		getDriver().findElementByXPath("//*[@id='username']").sendKeys(struserName);
		
		
//		driver.findElementByXPath("//*[@id='username']").sendKeys(userName);
//		driver.findElementByXPath("//*[@id='password']").sendKeys(passWord);
		
		
	
	}

	@Given ("Enter Password as {string}")
	public void enterPassword(String strPassword) {
		getDriver().findElementByXPath("//*[@id='password']").sendKeys(strPassword);
	}
	
	@Given  ("Click Loging button")
	public void clickLogin() {
		getDriver().findElementByXPath("//*[@id='Login']").click();
	}
	
	@Given ("Validate HomePage")
	public void verifyHomePage() {
		System.out.println("SFDC Login success ");
		WebElement ele = getDriver().findElementByXPath("//*[contains(@class,'salesforceIdentityAppLauncherHeader')]/div");
		if(ele.isDisplayed()) {
			System.out.println("test case pass");
		}else System.out.println("Test case failed");
	}
	
	@Given ("Validate LoginPage")
	public void verifyLoginPage() {
		System.out.println("SFDC negative TC ");
		WebElement ele = getDriver().findElementByXPath("//*[@id='Login']");
		if(ele.isDisplayed()) {
			System.out.println("test case pass");
		}else System.out.println("Test case failed");
	}

}
