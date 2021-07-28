package POMTests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClasses.SeleniumBaseClass;
import pagesPOM.SalesForceHomePage;

public class DelectContactrReqTC extends SeleniumBaseClass{
	
	@BeforeTest
	public void TestCaseDetails() {
		testName = "Delete Contact Request";
		testDescription = "This test case is to validate Delete Contact Request";
		testAuthor = "Swaminathan";
		testCategory = "Regression";
		
	}
	@Test (dataProvider = "FetchData1")
	public void deleteContactReq(String strDelReq) throws IOException {
		System.out.println("Test Data = "+strDelReq);
		new SalesForceHomePage()
		.clickAppLauncher()
		.clickViewAll()
		.ClickContactReq()
		.clickDownIcon(strDelReq)
		.clickDelete()
		.clickDeleteBtn();
		//.verifyDelSuccess(strDelReq);
	}

}
