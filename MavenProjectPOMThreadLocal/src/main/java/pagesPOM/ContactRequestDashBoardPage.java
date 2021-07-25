package pagesPOM;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.SeleniumBaseClass;
import utilitypackage.Extentreport;
import utilitypackage.UtilityWrapperMethods;

public class ContactRequestDashBoardPage extends SeleniumBaseClass{
	//WebDriverWait wait = new WebDriverWait(driver, 20);
	
	/*
	 * public ContactRequestDashBoardPage(RemoteWebDriver driver, Properties prop) {
	 * // TODO Auto-generated constructor stub this.driver = driver; this.prop =
	 * prop; }
	 */
	public NewContactReqPage clickNew() throws IOException {
		try {
			getDriver().findElementByXPath("//div[@title='New']").click();
			
			Extentreport.testStepStatus("click New Button", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("click New Button", "Fail");
		}
		return new NewContactReqPage();
		
	}
	public ContactRequestDashBoardPage verifySuccess() throws IOException {
		try {
			WebElement eleSuccess = getDriver().findElementByXPath("//div[@data-key='success']/div//span");
			System.out.println(eleSuccess.getText());
			Extentreport.testStepStatus("Verification", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("Verification", "Fail");
		}
		
		return this;
	}
	
	public ContactRequestDashBoardPage getContactReqNumber() throws IOException {
		try {
			WebElement eleContactNum = getDriver().findElementByXPath("//div[text()='Contact Request']/following-sibling::div");
			System.out.println(eleContactNum.getAttribute("title"));
			strContactReq = eleContactNum.getAttribute("title");
			
			Extentreport.testStepStatus("ContactReqNumber: "+strContactReq, "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("ContactReqNumber", "fail");
		}
		return this;
	}
	
	public ContactRequestDashBoardPage clickDownIcon(String strdelReq) throws IOException {
		System.out.println("Contact Req# for DownIcon= "+strdelReq);
		//WebElement eleDownIcon = driver.findElementByXPath("//a[@title='"+strContactReq+"']/ancestor::th/following-sibling::td//a");
		try {
			Thread.sleep(3000);
			WebElement eleDownIcon = getDriver().findElementByXPath("//a[@title='"+strdelReq+"']/ancestor::th/following-sibling::td//a");
			UtilityWrapperMethods.eleClick(getDriver(), eleDownIcon);
			Extentreport.testStepStatus("Click on Down Icon", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("Click on Down Icon", "Fail");
			
		}
		return this;
	}
	
	public ContactRequestDashBoardPage clickDelete() throws IOException {
		try {
			WebElement eleDeleteLink = getDriver().findElementByXPath("//li/a[@title='Delete']");
			UtilityWrapperMethods.eleClick(getDriver(), eleDeleteLink);
			Extentreport.testStepStatus("clickDelete", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("clickDelete", "Fail");
		}
		return this;
	}
	
	public NewContactReqPage clickEdit() throws IOException {
		try {
			WebElement eleDeleteLink = getDriver().findElementByXPath("//li/a[@title='Edit']");
			UtilityWrapperMethods.eleClick(getDriver(), eleDeleteLink);
			Extentreport.testStepStatus("clickDelete", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("clickDelete", "Fail");
		}
		return new NewContactReqPage();
		//return new NewContactReqPage(driver, prop);
	}
	
	public ContactRequestDashBoardPage clickDeleteBtn() throws IOException {
		try {
			WebElement eleDelBtn = getDriver().findElementByXPath("//span[text()='Delete']");
			//UtilityWrapperMethods.eleClick(getDriver(), eleDelBtn);
			
			Extentreport.testStepStatus("click Confirm Delete", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("click Confirm Delete", "Fail");
		}
		return this;
	}
	
	public ContactRequestDashBoardPage verifyDelSuccess(String strDelReq) throws IOException {
		WebElement eleSuccess = getDriver().findElementByXPath("//div[@data-key='success']/div//span");
		System.out.println(eleSuccess.getText());
		String strTostrMsg = eleSuccess.getText();
		if(strTostrMsg.contains(strDelReq)) {
			if(strTostrMsg.contains("was deleted")) {
				System.out.println("Contact Request Deleted successfully, Hence Test is pass");
				Extentreport.testStepStatus("Contact Request Deleted successfully", "Pass");
			}else {
				System.out.println("Test Failed. Not deleted");
				Extentreport.testStepStatus("Contact Request not Deleted", "Fail");
			}
		}else {
			System.out.println("Test Failed. Not deleted request ");
			Extentreport.testStepStatus("Contact Request not Deleted", "Fail");
		}
		
		return this;
		}

	public ContactRequestDashBoardPage verifyCloneSuccess() throws IOException {
		WebElement eleSuccess = getDriver().findElementByXPath("//div[@data-key='success']/div//span");
		System.out.println(eleSuccess.getText());
		String strTostrMsg = eleSuccess.getText();
		if(strTostrMsg.contains("Contact Request")) {
			if(strTostrMsg.contains("was created")) {
				System.out.println("Contact Request Cloned successfully, Hence Test is pass");
				Extentreport.testStepStatus("verifyCloneSuccess", "Pass");
			}else {
				System.out.println("Test Failed. Not Cloned");
				Extentreport.testStepStatus("verifyClone Failed", "Fail");
			}
		}else {
			System.out.println("Test Failed. Not Cloned request ");
			Extentreport.testStepStatus("verifyClone Failed", "Fail");
		}
		
		return this;
		}
	
	
	public ContactRequestDashBoardPage verifyReqStatus(String strEditReq, String strReqStatusValue) throws IOException {
		WebElement eleReqStatusLabel  = getDriver().findElementByXPath("//a[@title='"+strEditReq+"']/ancestor::th/following-sibling::td[1]//span/span");
		if(eleReqStatusLabel.getText().equalsIgnoreCase(strReqStatusValue)) {
			System.out.println("Request Status is updated, Hence This test cases is pass");
			Extentreport.testStepStatus("Request Status is updated", "Pass");
		}else {
			System.out.println("Request Status is not updated, Hence This test cases is Failed ");
			Extentreport.testStepStatus("Request Status is not updated", "Fail");
		}
		return this;
	}
	
	public ContactRequestDashBoardPage clickRecentlyViewed() throws IOException {
		try {
			WebElement eleRecentlyViewedLink = getDriver().findElementByXPath("//*[text()='Contact Requests']/following-sibling::span[text()='Recently Viewed']");
			UtilityWrapperMethods.eleClick(getDriver(), eleRecentlyViewedLink);
			
			Extentreport.testStepStatus("Click on Recently Viewed", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("Click on Recently Viewed", "Fail");
		}
		return this;
	}
	public ContactRequestDashBoardPage clickAllContactsReqs() throws IOException {
		try {
			WebElement eleAllContactReqsLink = getDriver().findElementByXPath("//span[text()='All Contact Requests']");
			UtilityWrapperMethods.eleClick(getDriver(), eleAllContactReqsLink);
			Extentreport.testStepStatus("click On All Contacts Reqs", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("click On All Contacts Reqs", "Fail");
		}
		return this;
	}
	public ContactRequestPage clickContactReq(String strdelReq) throws IOException {
		System.out.println("Contact Req# = "+strdelReq);
		//WebElement eleDownIcon = driver.findElementByXPath("//a[@title='"+strContactReq+"']/ancestor::th/following-sibling::td//a");
		try {
			
			Thread.sleep(3000);
			WebElement eleContReqNum = getDriver().findElementByXPath("//a[@title='"+strdelReq+"']");
			UtilityWrapperMethods.eleClick(getDriver(), eleContReqNum);
			Extentreport.testStepStatus("clickContactReq", "Pass");
		} catch (Exception e) {
			Extentreport.testStepStatus("clickContactReq", "Fail");
		}
		return new ContactRequestPage();
		//return new ContactRequestPage(driver, prop);
	}
}
