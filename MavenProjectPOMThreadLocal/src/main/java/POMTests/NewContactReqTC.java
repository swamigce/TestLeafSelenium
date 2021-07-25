package POMTests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClasses.SeleniumBaseClass;
import pagesPOM.SalesForceHomePage;

public class NewContactReqTC extends SeleniumBaseClass{
	@BeforeTest
	public void TestCaseDetails() {
		testName = "Create Contact Request";
		testDescription = "This test case is to validate Create Contact Request";
		testAuthor = "Swaminathan";
		testCategory = "Regression";
		
	}
	
	@Test (dataProvider = "FetchData1")
	public void testContactReq(String strFN, String strLN) throws InterruptedException, IOException {
		new SalesForceHomePage().clickAppLauncher().clickViewAll()
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
