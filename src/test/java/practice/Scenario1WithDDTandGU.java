package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.SeleniumUtility;
import objectRepoistory.LoginPage;

public class Scenario1WithDDTandGU
{
	public static void main(String[] args) throws Throwable 
	{
	//Read all the Required Data
	
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
	
	/*Read the common data from Property File*/
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	/*Read Data from excel file*/
	String LASTNAME = eUtil.readDataFromExcelFile("Contact", 1, 2);
	
	//Launch the Browser
	WebDriver driver = new EdgeDriver();
	sUtil.maximizeWindow(driver);
	sUtil.addImplicitlyWait(driver);

	//Step 2 : Load the URL
	driver.get(URL);

	//Step 3 : Login to Application
	//lp.getUsernameEdt().sendKeys(USERNAME);
	//lp.getPasswordEdt().sendKeys(PASSWORD);
	//lp.getLoginBtn().click();

	LoginPage lp = new LoginPage(driver);
	lp.LogintoApp(USERNAME, PASSWORD);
	
	//Step 4 : Click on Contacts link
	driver.findElement(By.linkText("Contacts")).click();

	//Step 5 : Click on Create Contact Lookup Image
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

	//Step 6 : Enter Mandatory Details
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

	//Step7 : Save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	//Step 8: Validate
	//Create New Contact with Mandatory Details
	//Contact is successfully created or not
	String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	System.out.println(contactHeader);

	if(contactHeader.contains(LASTNAME))
	{
	System.out.println("Pass");	
	}
	else
	{
	System.out.println("Fail");
	}

	//Step 9 : Logout of Application
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

	sUtil.mouseoveraction(driver, ele); 
	Thread.sleep(1000);
	driver.findElement(By.linkText("Sign Out")).click();

	//Step 10 : close the broswer
	driver.quit();
	}
	}


