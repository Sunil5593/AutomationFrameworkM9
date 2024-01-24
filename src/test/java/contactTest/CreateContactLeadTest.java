package contactTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.SeleniumUtility;
import objectRepoistory.ContactInfoPage;
import objectRepoistory.ContactsPage;
import objectRepoistory.CreateNewContactPage;
import objectRepoistory.HomePage;
import objectRepoistory.LoginPage;

public class CreateContactLeadTest
{
	@Test
	public void createContactWithLeadSource() throws Throwable
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
	String LASTNAME = eUtil.readDataFromExcelFile("Contact", 4, 2);
	String LEADSOURCE = eUtil.readDataFromExcelFile("Contact", 4, 3);
	
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
	HomePage hp = new HomePage(driver);
	hp.clickOnContactsLink();

	//Step 5 : Click on Create Contact Lookup Image
	ContactsPage cp = new ContactsPage(driver);
	cp.clickOnCreateContactLookupImg();
	
	//Step 6 : Enter Mandatory Details
	CreateNewContactPage cncp = new CreateNewContactPage(driver);
	cncp.createNewContact(LASTNAME, LEADSOURCE);

	//Step 8: Validate
	//Create New Contact with Mandatory Details
	//Contact is successfully created or not
	ContactInfoPage cip = new ContactInfoPage(driver);
	String contactHeader = cip.CaptureHeaderText();
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
	hp.logoutOfApp(driver);

	//Step 10 : close the browser
	driver.quit();
	}
	}



