package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {

	public static String getDataFromExcel(String sheet,int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Sachin\\Desktop\\amazon.xlsx");
	    String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	
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
	public static void captureScreenshot()
	{
		
	}
}
