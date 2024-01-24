package contactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.SeleniumUtility;
import objectRepoistory.ContactInfoPage;
import objectRepoistory.ContactsPage;
import objectRepoistory.CreateNewContactPage;
import objectRepoistory.HomePage;
import objectRepoistory.LoginPage;

public class CreateContactTest extends BaseClass
{
@Test(groups = "RegressionSuite")
public void createContactWithMandatoryField() throws Throwable
{
	//Read all the Required Data
		/*Read Data from excel file*/
	String LASTNAME = eUtil.readDataFromExcelFile("Contact", 1, 2);
	
	//Step 1 : Click on Contacts link
	HomePage hp = new HomePage(driver);
	hp.clickOnContactsLink();

	//Step 2 : Click on Create Contact Lookup Image
	ContactsPage cp = new ContactsPage(driver);
	cp.clickOnCreateContactLookupImg();
	
	//Step 3 : Enter Mandatory Details
	CreateNewContactPage cncp = new CreateNewContactPage(driver);
	cncp.createNewContact(LASTNAME);

	//Step 4: Validate
	//Create New Contact with Mandatory Details
	//Contact is successfully created or not
	ContactInfoPage cip = new ContactInfoPage(driver);
	String contactHeader = cip.CaptureHeaderText();
	Assert.assertTrue(contactHeader.contains(LASTNAME));
	System.out.println(contactHeader);
	}
	}
	



