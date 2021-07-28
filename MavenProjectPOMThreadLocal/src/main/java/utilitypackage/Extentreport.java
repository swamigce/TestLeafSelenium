package utilitypackage;

import java.io.IOException;
import java.lang.reflect.Method;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import baseClasses.SeleniumBaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class Extentreport extends SeleniumBaseClass{
	
	
	
	public static void testStepStatus(String strMessage, String strStatus) throws IOException {
		//System.out.println("Method Name = "+m);
		if(strStatus.equalsIgnoreCase("Pass")) {
			
			//testCase.pass(strMessage);
			node.pass(strMessage,MediaEntityBuilder.createScreenCaptureFromPath(".././screenshots/Img"+UtilityWrapperMethods.takeTestStepScreenshot()+".png").build());
		}else if (strStatus.equalsIgnoreCase("Fail")) {
			//testCase.fail(strMessage);
			node.fail(strMessage,MediaEntityBuilder.createScreenCaptureFromPath(".././screenshots/Img"+UtilityWrapperMethods.takeTestStepScreenshot()+".png").build());
			throw new RuntimeException();
		}

	}
	
	

}
