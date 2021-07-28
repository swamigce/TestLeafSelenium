package POMTests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClasses.SeleniumBaseClass;
import pagesPOM.SalesForceHomePage;

public class EditContactrReqSAL149 extends SeleniumBaseClass{
	
	@BeforeTest
	public void TestCaseDetails() {
		testName = "Edit Contact Request";
		testDescription = "This test case is to validate Edit Contact Request";
		testAuthor = "Swaminathan";
		testCategory = "Regression";
		
	}
	
	@Test (dataProvider = "FetchData1")
	public void editContactReq(String strEditReq, String strReqStatusVal) throws InterruptedException, IOException {
		new SalesForceHomePage()
		.clickAppLauncher()
		.clickViewAll()
		.ClickContactReq()
		.clickDownIcon(strEditReq)
		.clickEdit()
		.enterReqDescription("TestEditDescription")
		.clickReqStatusDropDown()
		.clickReqStatusAttempted()
		.getLastModUser()
		.getLastModDateTime()
		.clickMainSave()
		.verifyReqStatus(strEditReq, strReqStatusVal);
		
	}

}
