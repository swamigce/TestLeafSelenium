package pagesPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import baseClasses.SeleniumBaseClass;
import utilitypackage.UtilityWrapperMethods;

public class NewContactReqPage extends SeleniumBaseClass{

	
	public NewContactReqPage(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public NewContactReqPage clickSearchContacts() {
		driver.findElementByXPath("//input[@title='Search Contacts']").click();
		return this;
	}
	public NewContactReqPage clickNewContIcon() {
		driver.findElementByXPath("//span[@title='New Contact']").click();
		return this;
	}
	public NewContactReqPage clickSalutation() {
		driver.findElementByXPath("//span[text()='Salutation']/parent::span/following-sibling::div//a").click();
		return this;
	}
	 public NewContactReqPage clickMr() {
		 driver.findElementByXPath("//a[@title='Mr.']").click();
		 return this;
	 }
	public NewContactReqPage enterFName(String strFN) {
		driver.findElementByXPath("//input[contains(@class,'firstName')]").sendKeys(strFN);
		return this;
	}
	
	public NewContactReqPage enterLName(String strLN) {
		driver.findElementByXPath("//input[contains(@class,'lastName')]").sendKeys(strLN);
		return this;
	} 
	
	public NewContactReqPage clickSave() {
		driver.findElementByXPath("//div[contains(@class,'modal-footer')]//span[text()='Save']").click();
		return this;
	}
	public NewContactReqPage verifySuccess() throws InterruptedException {
		WebElement eleSuccess = driver.findElementByXPath("//div[@data-key='success']/div//span");
		System.out.println("Contact Create success "+eleSuccess.getText());
		Thread.sleep(3000);
		return this;
	}	
	public ContactRequestPage clickMainSave() throws InterruptedException {
		Thread.sleep(6000);
		WebElement eleMainSave = driver.findElementByXPath("//div[@class='inlineFooter']//span[text()='Save']");
		UtilityWrapperMethods.eleClick(driver, eleMainSave);
		return new ContactRequestPage(driver);
	}
}
