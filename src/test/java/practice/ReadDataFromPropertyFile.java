package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile 
{
public static void main(String[] args) throws IOException 
{
//Open the document in Java readable Format
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
//Create an Object of Properties class from java.util
	Properties p = new Properties();

//Load the file input stream into properties
p.load(fis);

//Load the key and read the value
String value = p.getProperty("url");
System.out.println(value);
}
}