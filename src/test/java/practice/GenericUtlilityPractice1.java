package practice;

import genericUtility.ExcelFileUtility;

public class GenericUtlilityPractice1 
{

public static void main(String[] args) throws Throwable 
{
	ExcelFileUtility eUtil = new ExcelFileUtility();
	String value = eUtil.readDataFromExcelFile("Contact", 1, 1);
	System.out.println(value);
}
}

