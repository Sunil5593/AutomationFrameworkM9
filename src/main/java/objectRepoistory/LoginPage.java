package objectRepoistory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage //Rule 1
{
//Rule 2
//Declaration
@FindBy(name="user_name") private WebElement usernameEdt;
@FindBy(name="user_password") private WebElement passwordEdt;
@FindBy(id="submitButton") private WebElement LoginBtn;

//Rule 3
//Initialization
public LoginPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

//Rule 4
//Utilization
public WebElement getUsernameEdt() {
	return usernameEdt;
}

public WebElement getPasswordEdt() {
	return passwordEdt;
}
public WebElement getLoginBtn() {
	return LoginBtn;
}

//Rule 5
//Business Library
public void LogintoApp(String USERNAME, String PASSWORD)
{
usernameEdt.sendKeys(USERNAME);
passwordEdt.sendKeys(PASSWORD);
LoginBtn.click();
}
}