package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile 
{
public static void main(String[] args) throws Throwable 
{
//Open the data in java readable format
FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");

//Create a Workbook
Workbook wb = WorkbookFactory.create(fis);

//Navigate to required sheet
Sheet sh = wb.getSheet("Contact");

//Navigate to required row
Row rw = sh.getRow(1);
//Navigate to required cell
Cell cl = rw.getCell(2);
//Capture the data in the cell
String value = cl.getStringCellValue();
System.out.println(value);	
}
}
