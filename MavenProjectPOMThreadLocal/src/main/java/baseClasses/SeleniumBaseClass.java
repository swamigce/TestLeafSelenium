package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBaseClass extends AbstractTestNGCucumberTests{
	
	///////////Below ThreadLocal code is for parallel Execution/////////////
	//ThreadLocal<EventFiringWebDriver> localDriver = new ThreadLocal<EventFiringWebDriver>();
	
	private static final ThreadLocal<RemoteWebDriver> localDriver = new ThreadLocal<RemoteWebDriver>();
	public void setUp(RemoteWebDriver driver) {
		localDriver.set(driver);
	}

	public RemoteWebDriver getDriver() {
		return localDriver.get();
	}
	
	/////////////ThreadLocal for Extent report/////////////////////////////
	
	/*
	 * private static final ThreadLocal<ExtentHtmlReporter> localReporter = new
	 * ThreadLocal<ExtentHtmlReporter>(); public void setUp(ExtentHtmlReporter
	 * reporter){ localReporter.set(reporter); }
	 * 
	 * public ExtentHtmlReporter getReporter() { return localReporter.get(); }
	 */
	
	//////////////////////////////////////////////////////////////////////
	
	//public String strTestPath = "C:\\Users\\user\\OneDrive\\SeleniumProjects\\TestLeafSelenium\\MavenProjectPOMParallel\\Data";
	public String strTestPath = "./Data";
	//public  RemoteWebDriver driver;
	public  static RemoteWebDriver driver;
	public String appURL = "https://login.salesforce.com/";
	public String userName = "mercury.bootcamp@testleaf.com";
	public String passWord = "Bootcamp@123";
	public static String strContactReq;
	public String strContactReqDel;
	public Properties prop;
	public String testName, testDescription, testAuthor, testCategory;
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public  static ExtentTest testCase, node;
	
	@BeforeSuite
	public void startExtentReport() {
		reporter = new ExtentHtmlReporter("./reports/results.html");
		//setUp(reporter);
		//getReporter();
		//Append earlier reports
		//reporter.setAppendExisting(true);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		//extent.attachReporter(getReporter());
		

	}
	
	@BeforeClass
	public void testDetails() {
		//testCase = extent.createTest(testName,testDescription);
		
		testCase = extent.createTest(testName,testDescription);
		testCase.assignAuthor(testAuthor);
		testCase.assignCategory(testCategory);
		
		}
	
	
	@BeforeMethod
	@Parameters({"browser","PropertyFile"})
	public void loginSFDC(@Optional ("Chrome") String strBrowser, @Optional ("config") String strProp) throws IOException {
		//Code for Properties File read.
		node = testCase.createNode(testName);
		FileInputStream fs = new FileInputStream("./src/main/resources/"+strProp+".properties");
		prop= new Properties();
		prop.load(fs);
		System.out.println("Property File name = "+prop.getProperty("fileName"));
		
		if(strBrowser.equalsIgnoreCase("Chrome")) {
	//Setup Chrome driver
			WebDriverManager.chromedriver().setup(); 
			//Setting options for blocking notifications
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(options);
			
			
		}else if(strBrowser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver(options);
			
		}else {
			System.out.println("No Browser details mentioned, so starting Chrome browser");
		}
		
		//getDriver()
		setUp(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		///Getting appURL, UserName and Password from Properties file
		getDriver().get(prop.getProperty("appURL"));
		getDriver().findElementByXPath("//*[@id='username']").sendKeys(prop.getProperty("userName"));
		getDriver().findElementByXPath("//*[@id='password']").sendKeys(prop.getProperty("passWord"));
		
//		driver.findElementByXPath("//*[@id='username']").sendKeys(userName);
//		driver.findElementByXPath("//*[@id='password']").sendKeys(passWord);
		
		getDriver().findElementByXPath("//*[@id='Login']").click();
		
	}
	
	@AfterMethod
	public void logoutSFDC() {
		driver.close();
		
	}
	
	@DataProvider (name = "FetchData")
	public String[][] ReadData() throws IOException{
		String [][] data = utilitypackage.UtilityWrapperMethods.readExcel(strTestPath);
		
		return data;
	}
	
	//@DataProvider (name = "FetchData1", indices = {1,3})
	@DataProvider (name = "FetchData1")
	public String[][] ReadDataWithMethod(Method m) throws IOException{
		String strTestDataPath = strTestPath+"\\"+m.getName()+".xlsx";
		System.out.println("Test Data file path = "+strTestDataPath);
		String [][] data = utilitypackage.UtilityWrapperMethods.readExcel(strTestDataPath);
		
		return data;
	}
	
	
	
	@AfterSuite
	public void stopReport() {
		extent.flush();

	}
	
	
	
	
	
	/////////////////////////////////////////////////////////////
}
