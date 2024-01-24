package practice;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;

public class GenericUtilityPractice 
{
public static void main(String[] args) throws Throwable 
{
PropertyFileUtility pUtil = new PropertyFileUtility();
String value = pUtil.readDataFromPropertyFile("password");
System.out.println(value);

ExcelFileUtility eUtil = new ExcelFileUtility();
String value1 = eUtil.readDataFromExcelFile("Contact", 1, 2);
System.out.println(value1);

JavaUtility jUtil = new JavaUtility();
System.out.println(jUtil.getSystemDate());
}
}
