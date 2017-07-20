package com.nexus.tests;

import org.testng.annotations.Test;

import com.nexus.pages.EnterTimeTrackPage;
import com.nexus.pages.LicensePage;
import com.nexus.pages.LoginPage;

import generics.BaseTest;
import generics.UtilityLib;

public class VerifyVersion extends BaseTest
{
	@Test(priority=3, groups={"functional"})
	public void testVerifyVerison() throws InterruptedException
	{
		//read data from excel 
		String un = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 0);
		String pw = UtilityLib.getCellValue(INPUT_PATH, "ValidLoginLogout", 1, 1);
				
		LoginPage l = new LoginPage(driver);
		
		//get the version on login page
		String loginPageVersion = l.getVersion();
		
		//enter valid username
		l.setUserName(un);
		
		//enter valid password
		l.setPassword(pw);
		//click login
		l.clickLogin();
		//click settings
		EnterTimeTrackPage e = new EnterTimeTrackPage(driver);
		e.clickSettings();
		//click licenses
		e.clickLicenses();
		//verify version on login page and product edition on license page is same
		LicensePage lp = new LicensePage(driver);
		lp.verifyProductVersion(loginPageVersion);

	}
}
