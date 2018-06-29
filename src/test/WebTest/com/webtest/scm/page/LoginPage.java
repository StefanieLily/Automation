package com.webtest.scm.page;

import org.openqa.selenium.By;

import com.webtest.scm.common.Common;
import com.webtest.scm.locator.Locator;

public class LoginPage extends Common{
	
	public void inputUserName(String username) throws Exception {	
        input(By.id(Locator.UserName_Id),username);
	}
	
	public void inputPassword(String password) throws Exception {
		input(By.id(Locator.PassWord_Id),password);
	}
	
	public void clickLoginBtn() throws Exception {		
		click(By.cssSelector(Locator.LoginBtn_Css));
	}
	
}
