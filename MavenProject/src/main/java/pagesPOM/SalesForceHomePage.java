package pagesPOM;

import org.openqa.selenium.remote.RemoteWebDriver;

import baseClasses.SeleniumBaseClass;

public class SalesForceHomePage extends SeleniumBaseClass{

	public SalesForceHomePage(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public SalesForceHomePage clickAppLauncher() {
		
		driver.findElementByXPath("//*[contains(@class,'salesforceIdentityAppLauncherHeader')]/div").click();
		return this;
	}
	
	public AppLauncher clickViewAll() {
		driver.findElementByXPath("//lightning-button/button[text()='View All']").click();
		return new AppLauncher(driver);
	}
	
}
