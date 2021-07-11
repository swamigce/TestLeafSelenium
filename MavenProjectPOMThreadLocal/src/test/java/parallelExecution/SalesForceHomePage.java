package parallelExecution;

import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;

import baseClasses.SeleniumBaseClass;
import io.cucumber.java.en.Given;
import steps.CucumberBase;

public class SalesForceHomePage extends CucumberBase{

	/*
	 * public SalesForceHomePage(RemoteWebDriver driver, Properties prop) { // TODO
	 * Auto-generated constructor stub this.driver=driver; this.prop = prop; }
	 */

	@Given ("Click AppLauncher Icon")
	public void clickAppLauncher() {
		
		driver.findElementByXPath("//*[contains(@class,'salesforceIdentityAppLauncherHeader')]/div").click();
		//System.out.println("Page= SalesForceHomePage - Property File name = "+prop.getProperty("fileName"));
		
	}
	
	@Given ("Click ViewAll link")
	public void clickViewAll() {
		driver.findElementByXPath("//lightning-button/button[text()='View All']").click();
		//return new AppLauncher();
		//return new AppLauncher(driver, prop);
	}
	
}
