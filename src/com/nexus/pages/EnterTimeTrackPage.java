package com.nexus.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import generics.BasePage;

public class EnterTimeTrackPage extends BasePage 
{
	//Declaration of Objects/WebElements
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;

	@FindBy(xpath="//div[contains(text(),' Settings')]")
	private WebElement settings;

	@FindBy(linkText="Licenses")
	private WebElement licenses;

	//Initialization of Webdriver/Browser
	public EnterTimeTrackPage(WebDriver driver) 
	{
		super(driver);
	}

	//Utilization/performing actions on the WebElements
	public void clickLogout()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(logout));	
		logout.click();
	}
	public void clickLicenses()
	{
		licenses.click();
	}
	public void clickSettings() 
	{
		settings.click();
	}
}
