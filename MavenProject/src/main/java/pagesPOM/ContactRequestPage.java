package pagesPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.SeleniumBaseClass;
import utilitypackage.UtilityWrapperMethods;

public class ContactRequestPage extends SeleniumBaseClass{
	//WebDriverWait wait = new WebDriverWait(driver, 20);
	
	public ContactRequestPage(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public NewContactReqPage clickNew() {
		driver.findElementByXPath("//div[@title='New']").click();
		return new NewContactReqPage(driver);
		
	}
	public ContactRequestPage verifySuccess() {
		WebElement eleSuccess = driver.findElementByXPath("//div[@data-key='success']/div//span");
		System.out.println(eleSuccess.getText());
		
		return this;
	}
	
	public ContactRequestPage getContactReqNumber() {
		WebElement eleContactNum = driver.findElementByXPath("//div[text()='Contact Request']/following-sibling::div");
		System.out.println(eleContactNum.getAttribute("title"));
		strContactReq = eleContactNum.getAttribute("title");
		return this;
	}
	
	public ContactRequestPage clickDownIcon(String strdelReq) {
		System.out.println("Delete Req# = "+strdelReq);
		//WebElement eleDownIcon = driver.findElementByXPath("//a[@title='"+strContactReq+"']/ancestor::th/following-sibling::td//a");
		WebElement eleDownIcon = driver.findElementByXPath("//a[@title='"+strdelReq+"']/ancestor::th/following-sibling::td//a");
		UtilityWrapperMethods.eleClick(driver, eleDownIcon);
		return this;
	}
	
	public ContactRequestPage clickDelete() {
		WebElement eleDeleteLink = driver.findElementByXPath("//li/a[@title='Delete']");
		UtilityWrapperMethods.eleClick(driver, eleDeleteLink);
		return this;
	}
	
	public ContactRequestPage clickDeleteBtn() {
		WebElement eleDelBtn = driver.findElementByXPath("//span[text()='Delete']");
		UtilityWrapperMethods.eleClick(driver, eleDelBtn);
		return this;
	}
	
	public ContactRequestPage verifyDelSuccess(String strDelReq) {
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
		
		return this;
		
	}
}
