package pagesPOM;

import org.openqa.selenium.WebElement;

import baseClasses.SeleniumBaseClass;
import io.cucumber.java.en.Given;
import utilitypackage.UtilityWrapperMethods;

public class LocationsDashboardPage extends SeleniumBaseClass {

	
	@Given("Click on New button")
	  public NewLocationPage clickNewBtn() { WebElement eleCloneBtn =
	  getDriver().findElementByXPath("//div[@title='New']");
	  UtilityWrapperMethods.eleClick(getDriver(), eleCloneBtn); return new
	  NewLocationPage(); //return new NewContactReqPage(driver, prop); }
	  
	  }
	  
	  
	 
}
