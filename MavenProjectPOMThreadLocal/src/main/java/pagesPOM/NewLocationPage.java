package pagesPOM;

import org.openqa.selenium.WebElement;

import baseClasses.SeleniumBaseClass;
import io.cucumber.java.en.Given;
import utilitypackage.UtilityWrapperMethods;

public class NewLocationPage extends SeleniumBaseClass{

	@Given ("Enter Location Name as {string}")
	public NewLocationPage enterLocationName(String strLN) {
		getDriver().findElementByXPath("//*[text()='Location Name']/parent::label/following-sibling::input").sendKeys(strLN);
		return this;
	} 
	
	@Given("Select Location Type as {string}")
	public NewLocationPage enterLocationType(String strLT) {
		getDriver().findElementByXPath("//*[text()='Location Type']/parent::span/following-sibling::*//a").click();
		WebElement ele = getDriver().findElementByXPath("//li/a[text()='"+strLT+"']");
		UtilityWrapperMethods.eleClick(getDriver(), ele);
		return this;
	} 
	
	@Given("Enter External Referance as {string}")
	public NewLocationPage enterExternalReference(String strExtRef) {
		getDriver().findElementByXPath("//*[text()='External Reference']/parent::label/following-sibling::input").sendKeys(strExtRef);
		return this;
	} 
	
	@Given("Click on Save button")
	public NewCreatedLocationPage clickMainSave() throws InterruptedException {
		Thread.sleep(6000);
		WebElement eleMainSave = getDriver().findElementByXPath("//div[@class='inlineFooter']//span[text()='Save']");
		UtilityWrapperMethods.eleClick(getDriver(), eleMainSave);
		return new NewCreatedLocationPage();
		//return new ContactRequestDashBoardPage(driver, prop);
	}
	
	@Given("Get Last Modified User")
	public NewLocationPage getLastModUser() {
		WebElement eleLastModUserlabel = getDriver().findElementByXPath("//*[text()='Last Modified By']/parent::div/following-sibling::div//span[contains(@class,'OutputText')]");
		System.out.println("Last Modified by = "+eleLastModUserlabel.getText());
		return this;
		
	}
	
	@Given("Get Last modifies Date and Time")
	public NewLocationPage getLastModDateTime() {
		WebElement eleLastModDateTimelabel = getDriver().findElementByXPath("//*[text()='Last Modified By']/parent::div/following-sibling::div//span[contains(@class,'OutputText')]/following-sibling::span");
		System.out.println("Last Modified by = "+eleLastModDateTimelabel.getText());
		return this;
		
	}
	
	
}
