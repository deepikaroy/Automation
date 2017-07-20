package com.nexus.tests;
import org.testng.annotations.Test;

import com.nexus.pages.LoginPage;

import generics.BaseTest;
import generics.UtilityLib;

public class InvalidLoginLogout extends BaseTest
{
	@Test(priority=2, groups={"smoke","functional"})
	public void testInvalidLoginLogout()
	{
		//Read the data from excel sheet(input.xlsx)
		int rc = UtilityLib.getRowCount(INPUT_PATH, "InvalidLoginLogout");
		for(int i=1; i<=rc; i++)
		{
			String un = UtilityLib.getCellValue(INPUT_PATH, "InvalidLoginLogout", i, 0);
			String pw = UtilityLib.getCellValue(INPUT_PATH, "InvalidLoginLogout", i, 1);	

			//enter invalid username
			LoginPage l = new LoginPage(driver);
			l.setUserName(un);

			//enter invalid password
			l.setPassword(pw);

			//click on login
			l.clickLogin();

			//verify errmsg is displayed
			l.verifyErrMsgIsDisplayed();
		}
	}
}
