package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**This class consists of all reusable methods related to selenium 
 * @author DELL
 */
public class SeleniumUtility 
{
/**
 * This method will maximize the window	
 * @param driver
 */
public void maximizeWindow(WebDriver driver)
{
driver.manage().window().maximize();	
}
/**
 * This method will minimize the window
 * @param driver
 */
public void minimizeWindow(WebDriver driver)
{
driver.manage().window().minimize();	
}

/**
 * This method will add 10 seconds for Implicitly Wait
 * @param driver
 */
public void addImplicitlyWait(WebDriver driver)
{
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
}

/**
 * This method will wait for 10 seconds for element to be visible
 * @param driver
 * @param element
 */
public void waitForElementToBeVisible(WebDriver driver, WebElement element)
{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(element));
}

/**
 * This method will handle drop down based on index
 * @param element
 * @param index
 */
public void handleDropDown(WebElement element, int index)
{
Select sel = new Select(element);
sel.selectByIndex(index);
}

/**
 * This method will handle drop down based on value
 * @param element
 * @param value
 */
public void handleDropDown(WebElement element, String value)
{
Select sel = new Select(element);
sel.selectByValue(value);
}

/**
 * This method will handle dropdown based on visible text
 * @param text
 * @param element
 */
public void handleDropDown(String text, WebElement element)
{
Select sel = new Select(element);
sel.deselectByVisibleText(text);
}

/**
 * This method will perform mouse hovering action on a web element
 * @param driver
 * @param element
 */
public void mouseoveraction(WebDriver driver, WebElement element)
{
Actions act = new Actions(driver);
act.moveToElement(element).perform();
}

/**
 * This method will perform Right Click action on a Web element
 * @param driver
 * @param element
 */
public void rightClickAction(WebDriver driver, WebElement element)
{
Actions act = new Actions(driver);
act.contextClick(element).perform();
}

/**
 * This method will perform Double Click action on a Web Element
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver, WebElement element)
{
Actions act = new Actions(driver);
act.doubleClick(element).perform();
}

/**
 * This method will perform Drag and Drop action on two elements
 * @param driver
 * @param ele1
 * @param ele2
 */
public void dragAndDrop(WebDriver driver, WebElement ele1, WebElement ele2)
{
Actions act = new Actions(driver);
act.dragAndDrop(ele1, ele2).perform();
}

/**
 * This method will perform Scroll Down Action
 * @param driver
 */
public void scrollAction(WebDriver driver)
{
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("Windows.scrollBy(0, 500);","");
}

/**
 * This method will perform Scroll Up Action
 * @param driver
 */
public void scrollAction1(WebDriver driver)
{
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("Windows.scrollBy(0, -500);","");
}

/**
 * This method will perform Scroll right Action
 * @param driver
 */
public void scrollAction2(WebDriver driver)
{
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("Windows.scrollBy(500, 0);","");
}

/**
 * This method will perform Scroll left Action
 * @param driver
 */
public void scrollAction3(WebDriver driver)
{
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("Windows.scrollBy(-500, 0);","");
}

/**
 * This method will click OK in Alert Pop-Up
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
driver.switchTo().alert().accept();	
}

/**
 * This method will click Cancel in Alert pop-up
 * @param driver
 */
public void cancelAlert(WebDriver driver)
{
driver.switchTo().alert().dismiss();
}

/**
 * This method will capture the alert text and return it to caller
 * @param driver
 * @return
 */
public String getAlertText(WebDriver driver)
{
return driver.switchTo().alert().getText();	
}

/**
 * This method will handle frame based on index
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver, int index)
{
driver.switchTo().frame(index);
}

/**
 * This method will handle frame based on name or ID
 * @param driver
 * @param nameorId
 */
public void handleFrame1(WebDriver driver, String nameorId)
{
driver.switchTo().frame(nameorId);
}

/**
 * This method will handle frame based on frame element
 * @param driver
 * @param element
 */
public void handleFrame2(WebDriver driver, WebElement element)
{
driver.switchTo().frame(element);	
}

/**
 * This method will capture the screenshot and return the path to caller
 * @param driver
 * @param screenshotName
 * @return
 * @throws Throwable
 */
public String captureScreenShot(WebDriver driver, String screenshotName) throws Throwable
{
TakesScreenshot ts = (TakesScreenshot) driver;
File src = ts.getScreenshotAs(OutputType.FILE);
File dst = new File(".\\Screenshot\\"+screenshotName+".png");

Files.copy(src, dst);

return dst.getAbsolutePath();//extents reports
}
}