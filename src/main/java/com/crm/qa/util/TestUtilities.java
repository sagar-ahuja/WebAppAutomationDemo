package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.base.TestBase;

public class TestUtilities extends TestBase{
	
	public static long PAGELOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static String TESTDATA_FILE_PATH = "C:\\Users\\hp\\eclipse-workspace\\FreeCRMTest\\"
			+ "src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	// JavaScript Executor	
	public static void clickElement(WebDriver d, WebElement ele) {
		JavascriptExecutor js =  (JavascriptExecutor)d;
		js.executeScript("arguments[0].click()", ele);
	}
	
	//Reading from TestData file
	public static Object[][] readDataFile(String sheetName){
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_FILE_PATH);	
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);		
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0; i<sheet.getLastRowNum(); i++) {
			for(int j = 0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
	}
	
	public static void takeScreenshotOnError() throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File(System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis()+".png"));
	}

}
