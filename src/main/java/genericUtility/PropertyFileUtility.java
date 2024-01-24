package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class consists of reusable methods related to property file 
 * @author DELL 
 */
public class PropertyFileUtility 
{
/**
 * This method will read data from property file and return value to caller
 * @param key
 * @return
 * @throws Throwable
 */
public String readDataFromPropertyFile(String key) throws Throwable		
{
FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
Properties p = new Properties();
p.load(fis);
String value = p.getProperty(key);
return value;
}
}
