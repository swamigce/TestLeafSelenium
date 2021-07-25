package pagesPOM;

import java.io.IOException;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.openqa.selenium.WebElement;

import baseClasses.SeleniumBaseClass;
import io.cucumber.java.en.Given;
import utilitypackage.Extentreport;

public class NewCreatedLocationPage extends SeleniumBaseClass{
	
	@Given("Verify the Created Location as {string}")
	public NewCreatedLocationPage verifyNewLocation(String strLName) throws IOException {
		////div[@title='TestLocation']
		WebElement ele=getDriver().findElementByXPath("//div[@title='"+strLName+"']");
		if(ele.isDisplayed()) {
			System.out.println("This test case pass");
			Extentreport.testStepStatus("verifyNewLocation", "Pass");
			
		}else {
			System.out.println("Test case failed");
			Extentreport.testStepStatus("verifyNewLocation", "Fail");
		}
		
		return this;
	}

}
