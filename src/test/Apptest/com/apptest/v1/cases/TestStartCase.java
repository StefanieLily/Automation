package com.apptest.v1.cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apptest.v1.config.GetTestProperties;
import com.apptest.v1.config.Log;
import com.apptest.v1.locator.OrderLocator;
import com.apptest.v1.locator.StartLocator;
import com.apptest.v1.base.StartBase;



public class TestStartCase extends StartBase {	
	
	@Test(priority = 1)
    public void login() throws Exception{
		if(elementExist(By.cssSelector(StartLocator.BindingTitle_Css))){
			startToBinding(GetTestProperties.getOnlineNumber(),GetTestProperties.getPasswordB());
			waitForElementPresent(By.cssSelector(StartLocator.LoginTitle_Css));
			Log.info("Bonding successfully!");
		}
		if(elementExist(By.xpath(OrderLocator.TangShi_xpath))){
			Log.info("User has been login successfully!");
		}else if(elementExist(By.cssSelector(StartLocator.LoginTitle_Css))){
			Log.info("Start to Log in!");
			startToLogin(GetTestProperties.Logname(),GetTestProperties.getPasswordL());
			FoundElement = waitForElementPresent(By.xpath(OrderLocator.TangShiW_xpath));
			Assert.assertTrue(FoundElement.isDisplayed());
			Log.info("User has been login successfully!");
		}else{  
			Log.error("Login failed!");
			}
	}
	
	//@Test(priority = 2)
	public void sync() throws Exception{	
			if(elementExist(By.cssSelector(StartLocator.LoginTitle_Css))){
				syncOnLoginPage();
				FoundElement = waitForElementPresent(By.cssSelector(StartLocator.LoginTitle_Css));
				Assert.assertTrue(FoundElement.isDisplayed());
				Log.info("Snyc successfully!");
			}else if(elementExist(By.cssSelector(StartLocator.BackMenu_Css))){
				startToSync("292,470");
				FoundElement = waitForElementPresent(By.cssSelector(StartLocator.LoginTitle_Css));
				Assert.assertTrue(FoundElement.isDisplayed());
				Log.info("Snyc successfully!");
			}	
					
	}
	
	//@Test(priority = 3)
	public void release() throws Exception{	
			if(elementExist(By.cssSelector(StartLocator.LoginTitle_Css))){
				startToRelease(GetTestProperties.getPrepareNumber(),GetTestProperties.getPasswordB(),GetTestProperties.getReleaseMes());
				FoundElement = waitForElementPresent(By.cssSelector(StartLocator.BindingTitle_Css));
				Assert.assertTrue(FoundElement.isDisplayed());
				Log.info("Release successfully!");
			}else{
				startToLogout();
				waitForElementPresent(By.cssSelector(StartLocator.ReleaseIcon_Css));
				startToRelease(GetTestProperties.getPrepareNumber(),GetTestProperties.getPasswordB(),GetTestProperties.getReleaseMes());
				FoundElement = waitForElementPresent(By.cssSelector(StartLocator.BindingTitle_Css));
				Assert.assertTrue(FoundElement.isDisplayed());
				Log.info("Release successfully!");
			}	   
	}	
}
