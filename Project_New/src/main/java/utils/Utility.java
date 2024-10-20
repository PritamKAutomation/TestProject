package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String getDataFromExcel(String sheet,int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Sachin\\Desktop\\amazon.xlsx");
	    String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	System.out.println("");
	    return data;
	}
//	    public static String getDataFromExcelSheet(String sheetname,int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
//			
//	    	{
//			
//		    Workbook workbook = null;
//		    
//			FileInputStream file = new FileInputStream("//Users//shyam//Desktop//TestData.xlsx");
//			//double data = WorkbookFactory.create(file).getSheet("sheet1").getRow(4).getCell(3).getNumericCellValue();
//			//System.out.println(data);
//			
//			workbook = WorkbookFactory.create(file);
//			
//		   String testdata =workbook.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getStringCellValue();
//		   
//		   workbook.close();
//		   file.close();
//		   
//		   
//		   return testdata;
//	}
	
//		public static void captureScreenshot() throws IOException 
//		{
//			WebDriver driver = new ChromeDriver(); 
//			driver.get("https://www.google.co.in/");
//			
//			File source = ((TakesScreenshot )driver).getScreenshotAs(OutputType.FILE);
//			File dest = new File("C:\\Users\\Sachin\\Desktop\\New folder\\Takescreenshot4.jpeg");
//			FileHandler.copy(source, dest);
//			// Creating object of date class 
//			
//	        Date d1 = new Date(); 
//	        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
//
//	        String CurrentDate=sdf.format(d1);
//	        System.out.println(CurrentDate);
//	       
//		}
	
}
