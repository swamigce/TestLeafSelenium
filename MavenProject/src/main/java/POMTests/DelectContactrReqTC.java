package POMTests;

import org.testng.annotations.Test;

import baseClasses.SeleniumBaseClass;
import pagesPOM.SalesForceHomePage;

public class DelectContactrReqTC extends SeleniumBaseClass{
	@Test (dataProvider = "FetchData1")
	public void deleteContactReq(String strDelReq) {
		new SalesForceHomePage(driver)
		.clickAppLauncher()
		.clickViewAll()
		.ClickContactReq()
		.clickDownIcon(strDelReq)
		.clickDelete()
		.clickDeleteBtn()
		.verifyDelSuccess(strDelReq);
	}

}
