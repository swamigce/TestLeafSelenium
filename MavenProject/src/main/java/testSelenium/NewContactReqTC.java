package testSelenium;

import org.testng.annotations.Test;

import baseClasses.SeleniumBaseClass;
import pagesPOM.SalesForceHomePage;

public class NewContactReqTC extends SeleniumBaseClass{
	
	@Test (dataProvider = "FetchData1")
	public void testContactReq(String strFN, String strLN) throws InterruptedException {
		new SalesForceHomePage(driver).clickAppLauncher().clickViewAll()
		.ClickContactReq()
		.clickNew()
		.clickSearchContacts()
		.clickNewContIcon()
		.clickSalutation()
		.clickMr()
		.enterFName(strFN)
		.enterLName(strLN)
		.clickSave()
		.clickMainSave()
		.verifySuccess()
		.getContactReqNumber();
		
	}

}
