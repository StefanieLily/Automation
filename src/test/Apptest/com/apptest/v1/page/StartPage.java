package com.apptest.v1.page;

import org.openqa.selenium.By;

import com.apptest.v1.common.Common;

public class StartPage extends Common{
	
	public void InputJobNum(By by,String jobnum) throws Exception{
		inputText(by,jobnum);
	}
	
	public void InputPassword(By by,String password) throws Exception{		
		inputText(by,password);
	}
	
	public void InputUserName(By by,String username) throws Exception{
		inputText(by,username);
	}
	

}
