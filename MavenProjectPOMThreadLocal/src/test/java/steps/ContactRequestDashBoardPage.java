package steps;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.SeleniumBaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilitypackage.UtilityWrapperMethods;

public class ContactRequestDashBoardPage extends CucumberBase{
	//WebDriverWait wait = new WebDriverWait(driver, 20);
	
	/*
	 * public ContactRequestDashBoardPage(RemoteWebDriver driver, Properties prop) {
	 * // TODO Auto-generated constructor stub this.driver = driver; this.prop =
	 * prop; }
	 */
	public void clickNew() {
		driver.findElementByXPath("//div[@title='New']").click();
		//return new NewContactReqPage();
		
	}
	public void verifySuccess() {
		WebElement eleSuccess = driver.findElementByXPath("//div[@data-key='success']/div//span");
		System.out.println(eleSuccess.getText());
		
		//return this;
	}
	
	public void getContactReqNumber() {
		WebElement eleContactNum = driver.findElementByXPath("//div[text()='Contact Request']/following-sibling::div");
		System.out.println(eleContactNum.getAttribute("title"));
		//strContactReq = eleContactNum.getAttribute("title");
		//return this;
	}
	
	@Given ("Click on Down icon for request as {string}")
	public void clickDownIcon(String strdelReq) {
		System.out.println("Contact Req# for DownIcon= "+strdelReq);
		//WebElement eleDownIcon = driver.findElementByXPath("//a[@title='"+strContactReq+"']/ancestor::th/following-sibling::td//a");
		WebElement eleDownIcon = driver.findElementByXPath("//a[@title='"+strdelReq+"']/ancestor::th/following-sibling::td//a");
		UtilityWrapperMethods.eleClick(driver, eleDownIcon);
		//return this;
	}
	
	@Given ("Click on Delete Link")
	public void clickDelete() {
		WebElement eleDeleteLink = driver.findElementByXPath("//li/a[@title='Delete']");
		UtilityWrapperMethods.eleClick(driver, eleDeleteLink);
		//return this;
	}
	
	public void clickEdit() {
		WebElement eleDeleteLink = driver.findElementByXPath("//li/a[@title='Edit']");
		UtilityWrapperMethods.eleClick(driver, eleDeleteLink);
		//return new NewContactReqPage();
		//return new NewContactReqPage(driver, prop);
	}
	
	@When ("Click on Delete Button")
	public void clickDeleteBtn() {
		WebElement eleDelBtn = driver.findElementByXPath("//span[text()='Delete']");
		//UtilityWrapperMethods.eleClick(getDriver(), eleDelBtn);
		//return this;
	}
	
	public void verifyDelSuccess(String strDelReq) {
		WebElement eleSuccess = driver.findElementByXPath("//div[@data-key='success']/div//span");
		System.out.println(eleSuccess.getText());
		String strTostrMsg = eleSuccess.getText();
		if(strTostrMsg.contains(strDelReq)) {
			if(strTostrMsg.contains("was deleted")) {
				System.out.println("Contact Request Deleted successfully, Hence Test is pass");
			}else {
				System.out.println("Test Failed. Not deleted");
			}
		}else {
			System.out.println("Test Failed. Not deleted request ");
		}
		
		//return this;
		}

	public void verifyCloneSuccess() {
		WebElement eleSuccess = driver.findElementByXPath("//div[@data-key='success']/div//span");
		System.out.println(eleSuccess.getText());
		String strTostrMsg = eleSuccess.getText();
		if(strTostrMsg.contains("Contact Request")) {
			if(strTostrMsg.contains("was created")) {
				System.out.println("Contact Request Cloned successfully, Hence Test is pass");
			}else {
				System.out.println("Test Failed. Not Cloned");
			}
		}else {
			System.out.println("Test Failed. Not Cloned request ");
		}
		
		//return this;
		}
	public void verifyReqStatus(String strEditReq, String strReqStatusValue) {
		WebElement eleReqStatusLabel  = driver.findElementByXPath("//a[@title='"+strEditReq+"']/ancestor::th/following-sibling::td[1]//span/span");
		if(eleReqStatusLabel.getText().equalsIgnoreCase(strReqStatusValue)) {
			System.out.println("Request Status is updated, Hence This test cases is pass");
		}else {
			System.out.println("Request Status is not updated, Hence This test cases is Failed ");
		}
		//return this;
	}
	
	public void clickRecentlyViewed() {
		WebElement eleRecentlyViewedLink = driver.findElementByXPath("//*[text()='Contact Requests']/following-sibling::span[text()='Recently Viewed']");
		UtilityWrapperMethods.eleClick(driver, eleRecentlyViewedLink);
		//return this;
	}
	public void clickAllContactsReqs() {
		WebElement eleAllContactReqsLink = driver.findElementByXPath("//span[text()='All Contact Requests']");
		UtilityWrapperMethods.eleClick(driver, eleAllContactReqsLink);
		//return this;
	}
	public void clickContactReq(String strdelReq) {
		System.out.println("Contact Req# = "+strdelReq);
		//WebElement eleDownIcon = driver.findElementByXPath("//a[@title='"+strContactReq+"']/ancestor::th/following-sibling::td//a");
		WebElement eleContReqNum = driver.findElementByXPath("//a[@title='"+strdelReq+"']");
		UtilityWrapperMethods.eleClick(driver, eleContReqNum);
		//return new ContactRequestPage();
		//return new ContactRequestPage(driver, prop);
	}
}
