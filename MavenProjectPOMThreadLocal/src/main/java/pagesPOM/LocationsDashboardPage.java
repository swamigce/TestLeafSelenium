package pagesPOM;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import baseClasses.SeleniumBaseClass;
import io.cucumber.java.en.Given;
import utilitypackage.Extentreport;
import utilitypackage.UtilityWrapperMethods;

public class LocationsDashboardPage extends SeleniumBaseClass {

	
	@Given("Click on New button")
	  public NewLocationPage clickNewBtn() throws IOException { 
				
		try {
			WebElement eleCloneBtn = getDriver().findElementByXPath("//div[@title='New']");
  UtilityWrapperMethods.eleClick(getDriver(), eleCloneBtn);
  Extentreport.testStepStatus("clickNewBtn", "Pass");
		} catch (Exception e) {
			 Extentreport.testStepStatus("clickNewBtn", "Fail");
		} 
	  
	  return new NewLocationPage(); //return new NewContactReqPage(driver, prop); }
	  
	  }
	  
	@Given("Click on DownIcon button for {string}")
	  public LocationsDashboardPage clickDownIcon(String strReq) throws IOException {
		  System.out.println("Contact Req# for DownIcon= "+strReq);
			//WebElement eleDownIcon = driver.findElementByXPath("//a[@title='"+strContactReq+"']/ancestor::th/following-sibling::td//a");
			try {
				WebElement eleDownIcon = getDriver().findElementByXPath("//a[@title='"+strReq+"']/ancestor::th/following-sibling::td//a");
				UtilityWrapperMethods.eleClick(getDriver(), eleDownIcon);
				 Extentreport.testStepStatus("clickDownIcon", "Pass");
			} catch (Exception e) {
				Extentreport.testStepStatus("clickDownIcon", "Fail");
			}
			return this;
	  }
	 
	@Given("Click on Edit Link")
	  public NewLocationPage clickEdit() throws IOException {
			try {
				WebElement eleEditLink = getDriver().findElementByXPath("//li/a[@title='Edit']");
				UtilityWrapperMethods.eleClick(getDriver(), eleEditLink);
				Extentreport.testStepStatus("click on Edit", "Pass");
			} catch (Exception e) {
				Extentreport.testStepStatus("click on Edit", "Fail");
			}
			return new NewLocationPage();
			//return new NewContactReqPage(driver, prop);
		}
	  
	@Given("Verify the LocationType updated for {string} as {string}")
	  public LocationsDashboardPage verifyLocationType(String strLName, String strLType) throws InterruptedException, IOException {
		Thread.sleep(2000); 
		String Ltype = getDriver().findElementByXPath("//a[@title='"+strLName+"']/ancestor::th/following-sibling::td//span/span").getText();
		 System.out.println("User provided Type = "+strLType+" for Location: "+strLName);
		  System.out.println("Type in application = "+Ltype);
		  if(strLType.equalsIgnoreCase(Ltype)) {
			  System.out.println("Location Type updated");
			  Extentreport.testStepStatus("verifyLocationType", "Pass");
		  }else {
			  System.out.println("Location type has not updated");
			  Extentreport.testStepStatus("verifyLocationType", "Fail");
		  }
		  
		  return this;
	  }
	  
	  
}
