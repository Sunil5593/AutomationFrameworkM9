package objectRepoistory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 		//Rule 1

//Rule 2 Declaration
{
@FindBy(xpath="//span[@class='dvHeaderText']") private WebElement ContactHeaderText;

//Rule 3 Initialization
public ContactInfoPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}
//Rule 4 Utilization

public WebElement getContactHeaderText() 
{
	return ContactHeaderText;
}
//Rule 5 Business Library

/**
 * This method is capture the Contact Header and return it to caller
 * @return
 */
public String CaptureHeaderText()
{
return ContactHeaderText.getText();	
}
}
