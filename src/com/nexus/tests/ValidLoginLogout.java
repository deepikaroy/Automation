package com.nexus.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.nexus.pages.EnterTimeTrackPage;
import com.nexus.pages.LoginPage;

import generics.BaseTest;
import generics.UtilityLib;

public class ValidLoginLogout extends BaseTest
{
	@Test(priority=1, groups={"valid"})
	public void testValidLoginLogout() throws InterruptedException
	{
		//Read the data from excel sheet(input.xlsx)
		String un = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 0);
		String pw = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 1);	
		String lpTitle = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 2);
		String hpTitle = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 3);	
		
		//enter valid username
		LoginPage l = new LoginPage(driver);
		l.setUserName(un);
		
		//enter valid password
		l.setPassword(pw);
		
		//click on login button
		Thread.sleep(2000);
		l.clickLogin();
		
		//verify home page is displayed
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.verifyTitle(hpTitle);	
		
		//click on logout
		e.clickLogout();
		//Reporter.log("After logout", true);
		//Thread.sleep(9000);
		//verify login page is displayed
		l.verifyTitle(lpTitle);
	}
}
