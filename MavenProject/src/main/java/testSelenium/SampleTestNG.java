package testSelenium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClasses.SeleniumBaseClass;

@Listeners(testSelenium.TestListeners.class)	

public class SampleTestNG extends SeleniumBaseClass{

	@Test (dataProvider = "FetchData")
	public void testSelenium(String a, String b) {
		System.out.println("Sample TestNG class");
		System.out.println(Test.class.getName());
		//Assert.assertTrue(false);
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("@@BeforeTest");
		
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
	}
	
	@Test (dependsOnMethods = {"testSelenium"})
	public void sampleTest2() {
		
		System.out.println("This is second test");
		
	}
}

