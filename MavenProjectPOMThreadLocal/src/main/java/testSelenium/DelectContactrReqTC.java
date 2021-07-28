package testSelenium;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClasses.SeleniumBaseClass;
import pagesPOM.SalesForceHomePage;

public class DelectContactrReqTC extends SeleniumBaseClass{
	@Test
	public void deleteContactReq(String strDelReq) throws IOException {
		new SalesForceHomePage()
		.clickAppLauncher()
		.clickViewAll()
		.ClickContactReq()
		.clickDownIcon(strDelReq)
		.clickDelete()
		.clickDeleteBtn()
		.verifyDelSuccess(strDelReq);
	}

}
