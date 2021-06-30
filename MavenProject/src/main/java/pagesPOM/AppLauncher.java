package pagesPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClasses.SeleniumBaseClass;
import utilitypackage.UtilityWrapperMethods;

public class AppLauncher extends SeleniumBaseClass{
	
	public AppLauncher(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public ContactRequestPage ClickContactReq() {
		//driver.findElementByXPath("//p[text()='Contact Requests']").click();
		WebElement eleContactReqLink = driver.findElementByXPath("//p[text()='Contact Requests']");
		UtilityWrapperMethods.eleClick(driver, eleContactReqLink);
		return new ContactRequestPage(driver);
	}
}
