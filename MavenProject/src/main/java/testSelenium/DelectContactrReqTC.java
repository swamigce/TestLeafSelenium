package testSelenium;

import org.testng.annotations.Test;

import baseClasses.SeleniumBaseClass;
import pagesPOM.SalesForceHomePage;

public class DelectContactrReqTC extends SeleniumBaseClass{
	@Test
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
