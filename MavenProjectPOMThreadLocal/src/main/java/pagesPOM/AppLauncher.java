package pagesPOM;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClasses.SeleniumBaseClass;
import io.cucumber.java.en.Given;
import utilitypackage.Extentreport;
import utilitypackage.UtilityWrapperMethods;

public class AppLauncher extends SeleniumBaseClass {
	
	/*
	 * public AppLauncher(RemoteWebDriver driver, Properties prop) { // TODO
	 * Auto-generated constructor stub this.driver=driver; this.prop = prop; }
	 */

	public ContactRequestDashBoardPage ClickContactReq() throws IOException {
		//driver.findElementByXPath("//p[text()='Contact Requests']").click();
		try {
			WebElement eleContactReqLink = getDriver().findElementByXPath("//p[text()='Contact Requests']");
			UtilityWrapperMethods.eleClick(getDriver(), eleContactReqLink);
			Extentreport.testStepStatus("Click on Contact Request", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("Click on Contact Request Failed", "Fail");
		}
		return new ContactRequestDashBoardPage();
	}
	//Click on Locations
	@Given ("Click on Locations link")
	public LocationsDashboardPage ClickLocations() throws IOException {
		//driver.findElementByXPath("//p[text()='Contact Requests']").click();
		try {
			WebElement eleContactReqLink = getDriver().findElementByXPath("//p[text()='Locations']");
			UtilityWrapperMethods.eleClick(getDriver(), eleContactReqLink);
			Extentreport.testStepStatus("Click on Location", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("Click on Location failed", "Fail");
		}
		return new LocationsDashboardPage();
	}
}
