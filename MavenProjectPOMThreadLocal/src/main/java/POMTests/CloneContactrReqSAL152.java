package POMTests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClasses.SeleniumBaseClass;
import pagesPOM.SalesForceHomePage;

public class CloneContactrReqSAL152 extends SeleniumBaseClass{
	
	@BeforeTest
	public void TestCaseDetails() {
		testName = "Clone Contact Request";
		testDescription = "This test case is to validate Clone Contact Request";
		testAuthor = "Swaminathan";
		testCategory = "Regression";
		
	}
	
	
	@Test (dataProvider = "FetchData1")
	public void cloneContactReq(String strCloneReq, String strPrefPhone) throws InterruptedException, IOException {
		new SalesForceHomePage()
		.clickAppLauncher()
		.clickViewAll()
		.ClickContactReq()
		.clickRecentlyViewed()
		.clickAllContactsReqs()
		.clickContactReq(strCloneReq)
		.clickCloneBtn()
		.enterPreferredPhone(strPrefPhone)
		.clickReqReasonDropDown()
		.clickReqReasonValue("General")
		.clickMainSave()
		.verifyCloneSuccess();
		
	}

}
