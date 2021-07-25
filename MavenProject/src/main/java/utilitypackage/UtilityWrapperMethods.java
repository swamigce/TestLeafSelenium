package utilitypackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityWrapperMethods {
	

	public static void eleClick(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}catch (Exception e) {
			
			js.executeScript("arguments[0].click();", element);
		}
	}
	
	public static void eleSendKeys(WebDriver driver, WebElement element, String strValue) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.clear();
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(strValue);
		
	}
	
	public static void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		action.moveToElement(element).build().perform();
		
	}
	public static String[][] readExcel(String strPath) throws IOException {
		FileInputStream fs = new FileInputStream (new File(strPath));
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		String [][] data = new String[lastRow][lastCell];
		for (int i=1; i<=lastRow; i++) {
			Row row=sheet.getRow(i);
			
			
			for (int j=0; j<lastCell;j++) {
				
				data[i-1][j] = row.getCell(j).getStringCellValue();
				System.out.println(row.getCell(j).getStringCellValue());
				
				
			}
		}
		
	workbook.close();
	fs.close();
		return data;
		
	}
	
	
	/////////////End of Class//////////////
}



