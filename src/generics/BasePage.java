package generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;



public class BasePage 
{
	public WebDriver driver;

	public BasePage(WebDriver driver)
	{
		/**
		 * initializing the driver whenever an instance of browser is created
		 */
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void verifyTitle(String eTitle)
	{
		/**
		 * verifying whether title of a particular page is valid or not
		 */
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,30);
			Reporter.log("line 34", true);
			wait.until(ExpectedConditions.titleIs(eTitle));
			String aTitle = driver.getTitle();
			
			Assert.assertEquals(eTitle, aTitle);
			Reporter.log(aTitle + " Title is matching", true);
		}
		catch(Exception e)
		{
			Reporter.log("Title is not matching", true);
		}
	}

	public void verifyElementIsPresent(WebElement element)
	{
		/**
		 * verifying whether a particular element is present or not
		 */
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log(element.getText() + " Element is present", true);
		}
		catch(Exception e)
		{
			Reporter.log("Element is not present", true);
		}
	}

}
