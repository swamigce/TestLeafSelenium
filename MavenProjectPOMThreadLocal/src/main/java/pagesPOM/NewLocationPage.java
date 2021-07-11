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
		getDriver().findElementByXPath("//li/a[text()='"+strLT+"']").click();
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
	
}
