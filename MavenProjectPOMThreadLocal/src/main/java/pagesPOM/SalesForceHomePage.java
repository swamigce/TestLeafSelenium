package pagesPOM;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.Status;

import baseClasses.SeleniumBaseClass;
import io.cucumber.java.en.Given;
import utilitypackage.Extentreport;

public class SalesForceHomePage extends SeleniumBaseClass{

	/*
	 * public SalesForceHomePage(RemoteWebDriver driver, Properties prop) { // TODO
	 * Auto-generated constructor stub this.driver=driver; this.prop = prop; }
	 */

	@Given ("Click AppLauncher Icon")
	public SalesForceHomePage clickAppLauncher() throws IOException {
		
		try {
			getDriver().findElementByXPath("//*[contains(@class,'salesforceIdentityAppLauncherHeader')]/div").click();
			//getDriver().findElementByXPath("//*[contains(@class,'salesforceIdentityAppLauncherHeader')]/div//img/div").click();
			//System.out.println("Page= SalesForceHomePage - Property File name = "+prop.getProperty("fileName"));
		
			//calling Test Step Status class for reporting
			Extentreport.testStepStatus("Click App Launcher", "PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Extentreport.testStepStatus("Click App Launcher failed", "Fail");
			//System.out.println(" printing error message "+e.getMessage());
			//System.out.println(" Printing ToString method "+e.toString());
			//System.out.println(" Printing GetCause methos"+e.getCause());
			
		}
	
		
		
		return this;
	}
	
	@Given ("Click ViewAll link")
	public AppLauncher clickViewAll() throws IOException {
		try {
			getDriver().findElementByXPath("//lightning-button/button[text()='View All']").click();
			//Extent Step status
			Extentreport.testStepStatus("Click View All button", "PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Extentreport.testStepStatus("Click View All button failed", "Fail");
		}
		return new AppLauncher();
		//return new AppLauncher(driver, prop);
	}
	
}
