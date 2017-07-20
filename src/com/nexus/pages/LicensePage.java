package com.nexus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import generics.BasePage;

public class LicensePage extends BasePage
{
	//Declaration of Objects/WebElements
	@FindBy(xpath="//nobr[text()='Product Edition:']/../..//td/b")
	private WebElement productVersion;

	//Initialization of Webdriver/Browser
	public LicensePage(WebDriver driver)
	{
		super(driver);
	}
	//Utilization/performing actions on the WebElements
	public void verifyProductVersion(String eValue)
	{
		String aValue = productVersion.getText();
		Assert.assertEquals(aValue, eValue);
	}
}
