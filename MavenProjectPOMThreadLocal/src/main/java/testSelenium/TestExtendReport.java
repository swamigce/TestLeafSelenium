package testSelenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestExtendReport {
public static RemoteWebDriver driver;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver  = new ChromeDriver();
		driver.get("https://www.toolsqa.com/selenium-webdriver/screenshot-in-selenium/");
		String strSSPath = "E:\\Selenium\\TestScreensot\\screen.png";
		takeScreenshot(driver);
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		
		reporter.setAppendExisting(true);
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		ExtentTest testCase = extent.createTest("SimpleExtentTestcase","This test case is to validate Extent Report");
		
		testCase.assignAuthor("Swaminathan");
		testCase.assignCategory("Simple Test");
		
		//Below code is to attach screenshot with the step
		testCase.pass("Simple Extent Report test Pass",MediaEntityBuilder.createScreenCaptureFromPath("E:\\Selenium\\TestScreensot\\screen.png").build());
		
		//Below code is to attach screenshot with the test case
		testCase.pass("Simple Extent Report test Pass").addScreenCaptureFromPath("E:\\Selenium\\TestScreensot\\screen.png");
		
		//Below code is another way to attach screenshot with the step
		testCase.log(Status.PASS, "details",MediaEntityBuilder.createScreenCaptureFromPath(strSSPath,"ExtentTest").build());
		
		extent.flush();
		reporter.flush();
		
		
		System.out.println("Last line of script");

	}
	
	public static void takeScreenshot(WebDriver driver) throws IOException {
		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("E:\\Selenium\\TestScreensot\\screen.png"));
	}
	

}
