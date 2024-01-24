package objectRepoistory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class HomePage extends SeleniumUtility 		//Rule 1
{
//Rule2
//Declaration
@FindBy(linkText="Contacts") private WebElement ContactsLnk;
@FindBy(xpath=("//img[@src='themes/softed/images/user.PNG']")) private WebElement administrationImg;
@FindBy(linkText="Sign Out") private WebElement SignoutLnk;

//Rule 3
//Initialization
public HomePage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

//Rule 4
//Utilization
public WebElement getContactsLnk() 
{
	return ContactsLnk;
}
public WebElement getAdministrationImg() {
	return administrationImg;
}
public WebElement getSignoutLnk() {
	return SignoutLnk;
}
//Rule 5
//Business Library
/**
 * This method will click on contacts link in home page
 */
public void clickOnContactsLink()
{
ContactsLnk.click();
}

/**
 * This method will logout of application
 * @param driver
 * @throws Throwable 
 */
public void logoutOfApp(WebDriver driver) throws Throwable
{
mouseoveraction(driver, administrationImg );
Thread.sleep(1000);
SignoutLnk.click();
}
}
