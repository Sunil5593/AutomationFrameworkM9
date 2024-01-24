package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/** This class consists of reusable methods related to Excel file 
 * @author DELL 
 */
 
public class ExcelFileUtility
{
/**
 * This file will be created for read data from excel file	
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return
 * @throws Throwable
 */
public String readDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws Throwable
{
FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
Workbook wb = WorkbookFactory.create(fis1);

String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
return value ;
}
}
