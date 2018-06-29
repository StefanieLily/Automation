package com.webtest.scm.cases;

import org.testng.annotations.Test;

import com.webtest.scm.base.LoginBase;
import com.webtest.scm.config.GetTestProperties;

public class LoginCase extends LoginBase {	

	@Test
	public void loginCase() throws Exception{
	
	try {
		OpenBrowser(GetTestProperties.getBroswser());
	    
		goToURL();
		
		verifyFirstPage();
			
		login(GetTestProperties.getUsername(),GetTestProperties.getPassword());
			
		verifyLoginSuccessfully();
		
	}catch(Exception e){
		e.printStackTrace();
		failAndScreenshot(e);
	}
  }
}
