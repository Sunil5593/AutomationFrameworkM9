package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1 
{
public static void main(String[] args) throws Throwable 
{
//Launch the Browser
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//Step 2 : Load the URL
driver.get("http://localhost:8888");

//Step 3 : Login to Application
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();

//Step 4 : Click on Contacts link
driver.findElement(By.linkText("Contacts")).click();

//Step 5 : Click on Create Contact Lookup Image
driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

//Step 6 : Enter Mandatory Details
driver.findElement(By.name("lastname")).sendKeys("Batman");

//Step7 : Save
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//Step 8: Validation
//Create New Contact with Mandatory Details
//Contact is successfully created or not
String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
System.out.println(contactHeader);

if(contactHeader.contains("Batman"))
{
System.out.println("Pass");	
}
else
{
System.out.println("Fail");
}

//Step 9 : Logout of Application
WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

Actions act = new Actions(driver);
act.moveToElement(ele).perform();

Thread.sleep(1000);
driver.findElement(By.linkText("Sign Out")).click();

//Step 10 : close the broswer
driver.quit();
}
}
