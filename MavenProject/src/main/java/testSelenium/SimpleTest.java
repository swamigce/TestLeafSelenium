package testSelenium;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilitypackage.UtilityWrapperMethods;

public class SimpleTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * System.out.println("Hello World"); WebDriverManager.chromedriver().setup();
		 * ChromeDriver driver = new ChromeDriver();
		 * driver.get("https://www.amazon.in/"); System.out.println("Test completed");
		 */
		
		String strPath = "C:\\Users\\user\\Documents\\TestLeafTest.xlsx";
		
		String [][] data = 	UtilityWrapperMethods.readExcel(strPath);
		System.out.println(data[0][0]);
		System.out.println(data[0][1]);
		System.out.println(data[1][0]);
		System.out.println(data[2][1]);
		
		
		
	}

}
