package pagesPOM;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClasses.SeleniumBaseClass;
import utilitypackage.Extentreport;
import utilitypackage.UtilityWrapperMethods;

public class NewContactReqPage extends SeleniumBaseClass{

	
	/*
	 * public NewContactReqPage(RemoteWebDriver driver, Properties prop) { // TODO
	 * Auto-generated constructor stub this.driver = driver; this.prop = prop; }
	 */
	public NewContactReqPage clickSearchContacts() throws IOException {
		try {
			getDriver().findElementByXPath("//input[@title='Search Contacts']").click();
			Extentreport.testStepStatus("clickSearchContacts", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("clickSearchContacts", "Fail");
		}
		return this;
	}
	public NewContactReqPage clickNewContIcon() throws IOException {
		try {
			getDriver().findElementByXPath("//span[@title='New Contact']").click();
			Extentreport.testStepStatus("clickNewContIcon", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("clickNewContIcon", "Fail");
		}
		return this;
	}
	public NewContactReqPage clickSalutation() throws IOException {
		try {
			getDriver().findElementByXPath("//span[text()='Salutation']/parent::span/following-sibling::div//a").click();
			Extentreport.testStepStatus("clickSalutation", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("clickSalutation", "Pass");
		}
		return this;
	}
	 public NewContactReqPage clickMr() throws IOException {
		 try {
			getDriver().findElementByXPath("//a[@title='Mr.']").click();
			Extentreport.testStepStatus("Select Mr.", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("Select Mr.", "Pass");
		}
		 return this;
	 }
	public NewContactReqPage enterFName(String strFN) throws IOException {
		try {
			getDriver().findElementByXPath("//input[contains(@class,'firstName')]").sendKeys(strFN);
			Extentreport.testStepStatus("Enter First Name", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("Enter First Name", "Fail");
		}
		return this;
	}
	
	public NewContactReqPage enterLName(String strLN) throws IOException {
		try {
			getDriver().findElementByXPath("//input[contains(@class,'lastName')]").sendKeys(strLN);
			Extentreport.testStepStatus("Enter Last Name", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("Enter Last Name", "Fail");
		}
		return this;
	} 
	
	public NewContactReqPage clickSave() throws IOException {
		try {
			getDriver().findElementByXPath("//div[contains(@class,'modal-footer')]//span[text()='Save']").click();
			Extentreport.testStepStatus("clickSave", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("clickSave", "Fail");
		}
		return this;
	}
	public NewContactReqPage verifySuccess() throws InterruptedException, IOException {
		try {
			WebElement eleSuccess = getDriver().findElementByXPath("//div[@data-key='success']/div//span");
			System.out.println("Contact Create success "+eleSuccess.getText());
			Thread.sleep(3000);
			Extentreport.testStepStatus("verifySuccess", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("verifySuccess", "Fail");
		}
		return this;
	}	
	public ContactRequestDashBoardPage clickMainSave() throws InterruptedException, IOException {
		Thread.sleep(6000);
		try {
			WebElement eleMainSave = getDriver().findElementByXPath("//div[@class='inlineFooter']//span[text()='Save']");
			UtilityWrapperMethods.eleClick(getDriver(), eleMainSave);
			Extentreport.testStepStatus("click Save", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("click Save", "Fail");
		}
		return new ContactRequestDashBoardPage();
		//return new ContactRequestDashBoardPage(driver, prop);
	}
	public NewContactReqPage enterReqDescription(String strDesc) throws IOException {
		try {
			WebElement eleReqDescTextArea = getDriver().findElementByXPath("//span[text()='Request Description']/parent::label/following-sibling::textarea");
			UtilityWrapperMethods.eleSendKeys(getDriver(), eleReqDescTextArea, strDesc);
			Extentreport.testStepStatus("enterReqDescription", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("enterReqDescription", "Fail");
		} 
		
		return this;
	}
	
	public NewContactReqPage enterPreferredPhone(String strDesc) throws IOException {
		try {
			WebElement elePreferredPhone = getDriver().findElementByXPath("//span[text()='Preferred Phone Number']/parent::label/following-sibling::input");
			UtilityWrapperMethods.eleSendKeys(getDriver(), elePreferredPhone, strDesc);
			
			Extentreport.testStepStatus("enterPreferredPhone", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("enterPreferredPhone", "Fail");
		} 
		
		return this;
	}
	
	public NewContactReqPage clickReqReasonDropDown() throws IOException {
		try {
			WebElement eleReqReasonDropDown = getDriver().findElementByXPath("//*[text()='Request Reason']/parent::span/following-sibling::*//a");
			UtilityWrapperMethods.eleClick(getDriver(), eleReqReasonDropDown);
			
			Extentreport.testStepStatus("clickReqReasonDropDown", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("clickReqReasonDropDown", "Fail");
		}
		return this;
	}
	
	public NewContactReqPage clickReqReasonValue(String strReqReasonVal) throws IOException {
		try {
			WebElement eleReqReasonValue = getDriver().findElementByXPath("//a[@title='"+strReqReasonVal+"']");
			UtilityWrapperMethods.eleClick(getDriver(), eleReqReasonValue);
			
			Extentreport.testStepStatus("clickReqReasonValue", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("clickReqReasonValue", "Fail");
		}
		return this;
	}
	
	public NewContactReqPage clickReqStatusDropDown() throws InterruptedException, IOException {
		Thread.sleep(6000);
		try {
			WebElement eleReqStatusDropDown = getDriver().findElementByXPath("//span[text()='Request Status']/parent::span/following-sibling::div//a");
			UtilityWrapperMethods.eleClick(getDriver(), eleReqStatusDropDown);
			Extentreport.testStepStatus("clickReqStatusDropDown", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("clickReqStatusDropDown", "Fail");
		}
		return this;
	}
	public NewContactReqPage clickReqStatusAttempted() throws IOException {
		try {
			WebElement eleAttemptedLink = getDriver().findElementByXPath("//a[@title='Attempted']");
			UtilityWrapperMethods.eleClick(getDriver(), eleAttemptedLink);
			Extentreport.testStepStatus("clickReqStatusAttempted", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("clickReqStatusAttempted", "Fail");
		}
		return this;
	}
	
	
	public NewContactReqPage getLastModUser() throws IOException {
		try {
			WebElement eleLastModUserlabel = getDriver().findElementByXPath("//*[text()='Last Modified By']/parent::div/following-sibling::div//span[contains(@class,'OutputText')]");
			System.out.println("Last Modified by = "+eleLastModUserlabel.getText());
			Extentreport.testStepStatus("LastModUser: "+eleLastModUserlabel.getText(), "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("LastModUser: ", "Fail");
		}
		return this;
		
	}
	
	public NewContactReqPage getLastModDateTime() throws IOException {
		try {
			WebElement eleLastModDateTimelabel = getDriver().findElementByXPath("//*[text()='Last Modified By']/parent::div/following-sibling::div//span[contains(@class,'OutputDateTime')]");
			System.out.println("Last Modified by = "+eleLastModDateTimelabel.getText());
			Extentreport.testStepStatus("LastModified Time: "+eleLastModDateTimelabel.getText(), "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("LastModified Time: ", "Fail");
		}
		return this;
		
	}
	
}
