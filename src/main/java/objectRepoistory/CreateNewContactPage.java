package objectRepoistory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility			//Rule 1 
{
//Rule 2 Declaration	
@FindBy(name="lastname") private WebElement LastNameEdt;
@FindBy(name="leadsource") private WebElement leadSourceDropDown;
@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement SaveBtn;

//Rule 3 
//Initialization
public CreateNewContactPage(WebDriver driver)
{
PageFactory.initElements(driver, this);
}


//Rule 4 Utilization
public WebElement getLastNameEdt() {
	return LastNameEdt;
}

public WebElement getLeadSourceDropDown() {
	return leadSourceDropDown;
}
public WebElement getSaveBtn() {
	return SaveBtn;
}

//Rule 5 Business Logic
/**
 * This method will create a new contact with mandatory details
 * @param LASTNAME
 */
public void createNewContact(String LASTNAME)
{
LastNameEdt.sendKeys(LASTNAME);
SaveBtn.click();
}

/**
 * This method will create a new contact with Lead source drop down
 * @param LASTNAME
 * @param LEADSOURCE
 */
public void createNewContact(String LASTNAME, String LEADSOURCE)
{
LastNameEdt.sendKeys(LASTNAME);
handleDropDown(leadSourceDropDown, LEADSOURCE);
SaveBtn.click();
}
}