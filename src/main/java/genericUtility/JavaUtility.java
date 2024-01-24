package genericUtility;

import java.util.Date;
/**
 * 
 */
public class JavaUtility 
{
/**
 * 
 * @return
 */
public String getSystemDate()
{
Date d = new Date();
String[] dArr = d.toString().split(" ");
String currentDate = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+"_"+dArr[3].replace(":", "-");
return currentDate;
}

}
