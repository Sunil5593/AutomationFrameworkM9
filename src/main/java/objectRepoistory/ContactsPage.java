package objectRepoistory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 		//Rule 1
{
//declaration			Rule 2
	
@FindBy(xpath = "//img[@title='Create Contact...']") 
private WebElement CreateContactLookupImg;

//Initialization		Rule 3
public ContactsPage(WebDriver driver)
{
PageFactory.initElements(driver, this);
}
//Utilization			Rule 4

public WebElement getCreateContactLookupImg() 
{
	return CreateContactLookupImg;
}
//Business Library		Rule 5
public void clickOnCreateContactLookupImg()
{
CreateContactLookupImg.click();	
}
}
