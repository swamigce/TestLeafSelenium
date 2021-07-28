package pagesPOM;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClasses.SeleniumBaseClass;
import utilitypackage.Extentreport;
import utilitypackage.UtilityWrapperMethods;

public class ContactRequestPage extends SeleniumBaseClass{
	/*
	 * public ContactRequestPage(RemoteWebDriver driver, Properties prop) {
	 * this.driver=driver; this.prop=prop;
	 * 
	 * }
	 */

	public NewContactReqPage clickCloneBtn() throws IOException {
		try {
			WebElement eleCloneBtn = getDriver().findElementByXPath("//div[@title='Clone']");
			UtilityWrapperMethods.eleClick(getDriver(), eleCloneBtn);
			
			Extentreport.testStepStatus("clickCloneBtn", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("clickCloneBtn", "Fail");
		}
		return new NewContactReqPage();
		//return new NewContactReqPage(driver, prop);
	}
	
}
