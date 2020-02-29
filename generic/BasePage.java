package com.craftsvilla.generic;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage 
{
	
	public WebDriver driver = null;
	
	public Logger log = Logger.getLogger(BasePage.class);
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;					//initialising
	}
	

	public void verifyTitle(String exp_title)
	{
		WebDriverWait w = new WebDriverWait(driver, 10);
		String act_title=null;
		try
		{
			w.until(ExpectedConditions.titleIs(exp_title));
			act_title = driver.getTitle();
			Assert.assertEquals(act_title, exp_title);
			log.info("Page title validation : "+act_title +" and "+exp_title+" are matched");
			
		}
		catch (Exception e) 
		{
			log.error("Page title validation : "+act_title +" and "+exp_title +" didnot match - "+e);
		}
		
	}
	
	
	public void verifyElementPresent(WebElement ele)
	{
		WebDriverWait w = new WebDriverWait(driver, 10);
		try
		{
			w.until(ExpectedConditions.visibilityOf(ele));
			log.info("Verify element visible : "+ele + " found");
		}
		catch (Exception e) 
		{
			log.error("Verify element visible : "+ele + " not found - "+e);
		}
	}
	
	
	
	public void mouseHover(WebElement ele)
	{
		WebDriverWait w = new WebDriverWait(driver, 10);
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			log.info("Mouse hover event : Mousehovered on "+ ele);
		}
		catch (Exception e) 
		{
			log.error("Mouse hover event : Unable to mousehovere on "+ ele+" - " +e);
		}
	}
}
