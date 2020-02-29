package com.craftsvilla.testcripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.craftsvilla.generic.BaseTest;
import com.craftsvilla.pompage.CartPage;
import com.craftsvilla.pompage.CheckOutPage;
import com.craftsvilla.pompage.HomePage;
import com.craftsvilla.pompage.LinenSareesPage;
import com.craftsvilla.pompage.ProductDescriptionPage;
import com.craftsvilla.pompage.SareesPage;

public class LinenSareesScripts extends BaseTest
{
	
	HomePage  homePage=null;
	SareesPage sareesPage = null;
	LinenSareesPage linensarees = null;
	ProductDescriptionPage prodescpage = null;
	CheckOutPage checkoutpage = null;
	
	@Test
	public void tc_01_buyLinenSaree()
	{
		homePage = new HomePage(driver);
		sareesPage = new SareesPage(driver);
		linensarees = new LinenSareesPage(driver);
		prodescpage  = new ProductDescriptionPage(driver);
		checkoutpage = new CheckOutPage(driver);
		
		try
		{
			homePage.goToSareesLink();
			sareesPage.clickOnLinenSarees();
			Assert.fail();
			linensarees.goToProduct1537544423();
			prodescpage.clickOnBuyNow();
			checkoutpage.setMobile("9663069665");
			checkoutpage.captureOTPMessage();
			checkoutpage.setOTP("9635");
			checkoutpage.clickOnLogin();
		
			Reporter.log("tc_01_buyLinenSaree executed suucessfully");
		
		}
		catch(Exception e)
		{
			Reporter.log("tc_01_buyLinenSaree failed "+e);
		}
		
		
		
		
		
		
	}

}
