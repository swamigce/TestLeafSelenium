package pagesPOM;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.openqa.selenium.WebElement;

import baseClasses.SeleniumBaseClass;
import io.cucumber.java.en.Given;

public class NewCreatedLocationPage extends SeleniumBaseClass{
	
	@Given("Verify the Created Location as {string}")
	public NewCreatedLocationPage verifyNewLocation(String strLName) {
		////div[@title='TestLocation']
		WebElement ele=getDriver().findElementByXPath("//div[@title='"+strLName+"']");
		if(ele.isDisplayed()) {
			System.out.println("This test case pass");
		}else System.out.println("Test case failed");
		
		return this;
	}

}
