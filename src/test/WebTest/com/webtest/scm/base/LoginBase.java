package com.webtest.scm.base;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.webtest.scm.config.Log;
import com.webtest.scm.locator.Locator;
import com.webtest.scm.page.LoginPage;

public class LoginBase extends LoginPage{
	
	//login
	public void login(String username,String password) throws Exception {			
		inputUserName(username);
		inputPassword(password);
		clickLoginBtn();		
		}
	
	//verify login successfully
	public void verifyLoginSuccessfully() throws Exception {		
		try {
			Assert.assertTrue(elementExist(By.cssSelector(Locator.LoginTitle_Css)));
		}catch(Error e) {
			Log.error("Login failed!");
			throw e;
		}
				
	}
	
	//verify fist page display well
	public void verifyFirstPage() throws Exception {		
		try {
			Assert.assertTrue(elementExist(By.cssSelector(Locator.FirstPage_Css)));
		}catch(Exception e) {
			Log.error("First page open failed!");
			throw e;
		}
	}

}
