package steps;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClasses.SeleniumBaseClass;
import io.cucumber.java.en.Given;
import utilitypackage.UtilityWrapperMethods;

public class AppLauncher extends CucumberBase{
	
	/*
	 * public AppLauncher(RemoteWebDriver driver, Properties prop) { // TODO
	 * Auto-generated constructor stub this.driver=driver; this.prop = prop; }
	 */

	@Given ("Click Contact Request link")
	public void ClickContactReq() {
		//driver.findElementByXPath("//p[text()='Contact Requests']").click();
		WebElement eleContactReqLink = getDriver().findElementByXPath("//p[text()='Contact Requests']");
		UtilityWrapperMethods.eleClick(getDriver(), eleContactReqLink);
		//return new ContactRequestDashBoardPage();
	}
}
