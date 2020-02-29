package com.craftsvilla.testcripts;

import org.testng.annotations.Test;

import com.craftsvilla.generic.BaseTest;
import com.craftsvilla.generic.ReadExcel;
import com.craftsvilla.pompage.HomePage;
import com.craftsvilla.pompage.SignInPage;

//This class holds all the testcases for Login Module
public class LogInScripts extends BaseTest
{
	HomePage homepage = null;
	SignInPage signInpage = null;
	
	@Test
	public void TC_01_login()
	{
		homepage = new HomePage(driver);
		signInpage = new SignInPage(driver);
		
		
		try
		{
			String[][] credentials = ReadExcel.getData(FILE_PATH, "Sheet1");
			for(int i = 1; i<credentials.length; i++)
			{
				String email = credentials[i][0];
				String password = credentials[i][1];
				
				homepage.clickOnSignInLink();
				signInpage.setEmail(email);
				signInpage.clickOnContinue();
				signInpage.enterPassword(password);
				signInpage.clickOnLoginButton();
				homepage.gotoAccount();
				homepage.clickOnLogout();
			}
			
			System.out.println();
		}
		catch(Exception e)
		{
			
		}
	}

}
