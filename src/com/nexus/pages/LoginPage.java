package com.nexus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generics.BasePage;

public class LoginPage extends BasePage
{
	//Declaration of Objects/WebElements
	@FindBy(id="username")
	private WebElement unTXB;
	
	@FindBy(name="pwd")
	private WebElement pwTXB;

	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//span[contains(text(),'is invalid')]")
	private WebElement errMsg;
	
	@FindBy(xpath="//nobr[contains(text(),'actiTIME')]")
	private WebElement actiTIMEVersion;
	
	//Initialization of Webdriver/Browser
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	//Utilization/performing actions on the WebElements
	public void setUserName(String un)
	{
		unTXB.sendKeys(un);
	}
	public void setPassword(String pw)
	{
		pwTXB.sendKeys(pw);
	}
	public void clickLogin()
	{
		loginBTN.click();
	}
	public void verifyErrMsgIsDisplayed()
	{
		verifyElementIsPresent(errMsg);
	}
	public String getVersion()
	{
		return actiTIMEVersion.getText();
	}
}
