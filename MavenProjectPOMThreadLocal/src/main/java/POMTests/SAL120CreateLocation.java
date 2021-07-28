package POMTests;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClasses.SeleniumBaseClass;
import pagesPOM.SalesForceHomePage;

public class SAL120CreateLocation extends SeleniumBaseClass{

	public String strLocationName="TestLocationJuly10";
	public String strLocationType="Site";
	@Test
	public void CreateNewLocation() throws InterruptedException, IOException {
		
		new SalesForceHomePage().clickAppLauncher().clickViewAll()
		.ClickLocations()
		.clickNewBtn()
		.enterLocationName(strLocationName)
		.enterLocationType(strLocationType)
		.enterExternalReference("TestExtRef")
		.clickMainSave()
		.verifyNewLocation(strLocationName);
	}
	
}
