package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import objectRepoistory.HomePage;
import objectRepoistory.LoginPage;

/**
 * This class consists of all basic configuration annotations of TestNG
 */
public class BaseClass 
{
public ExcelFileUtility eUtil = new ExcelFileUtility();
public JavaUtility jUtil = new JavaUtility();
public PropertyFileUtility pUtil = new PropertyFileUtility();
public SeleniumUtility sUtil = new SeleniumUtility();

public WebDriver driver;
//For Listeners
public static WebDriver sDriver;

@BeforeSuite(alwaysRun=true)
public void bsConfig()
{
System.out.println("=============DB Connection Successful==========");	
}
@BeforeClass(alwaysRun=true)
public void bcConfig() throws Throwable
{
	String URL = pUtil.readDataFromPropertyFile("url");
	driver = new EdgeDriver();
	sUtil.maximizeWindow(driver);
	sUtil.addImplicitlyWait(driver);
	
	driver.get(URL);
	System.out.println("Launch the browser successfully");

	//For listeners
	sDriver=driver;
}

@BeforeMethod(alwaysRun=true)
public void bmConfig() throws Throwable	
{
String USERNAME = pUtil.readDataFromPropertyFile("username");
String PASSWORD = pUtil.readDataFromPropertyFile("password");

LoginPage lp = new LoginPage(driver);
lp.LogintoApp(USERNAME, PASSWORD);

System.out.println("Login to the app Successfull");	
}

@AfterMethod(alwaysRun=true)
public void amConfig() throws Throwable
{
HomePage hp = new HomePage(driver);
hp.logoutOfApp(driver);

System.out.println("Logout to the app Sucessfull");	
}
@AfterClass(alwaysRun=true)
public void acConfig()
{
driver.quit();	
System.out.println("Close the browser");	
}

@AfterSuite(alwaysRun=true)
public void asConfig()
{
System.out.println("==============DB closed Successfully");	
}
}
