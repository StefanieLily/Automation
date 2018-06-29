package com.apptest.v1.base;

import org.openqa.selenium.By;

import com.apptest.v1.config.GetTestProperties;
import com.apptest.v1.config.Log;
import com.apptest.v1.locator.StartLocator;
import com.apptest.v1.page.StartPage;

public class StartBase extends StartPage{
	
	public void startToBinding(String username,String password) throws Exception{
		Log.info("Start to binding!");
		InputUserName(By.id(StartLocator.BindingName_Id),username);
		InputPassword(By.id(StartLocator.BindingPassWord_Id),password);
		//inputByIndex(By.className(StartLocator.Binding_className), BindingInfo);
		//clickBtnW(By.cssSelector(StartLocator.BindingConfirm_Css));
		clickBtnByTp("285,430");
	}
	
	public void startToLogin(String username,String password) throws Exception{
		Log.info("Start to input Employee number!");
		InputJobNum(By.id(StartLocator.UserName_Id),username);
		InputPassword(By.id(StartLocator.Password_Id),password);
		//inputByIndex(By.className(StartLocator.Login_className),LoginInfo);
		clickBtn(By.xpath(StartLocator.LoginBtn_xpath));
		implicitWait(5);
	}
	
	public void syncOnLoginPage() throws Exception{
		Log.info("Start to sync in login page!");
		//clickBtnW(By.xpath(StartLocator.Sync_xpath));
		clickBtnByTp(GetTestProperties.getSyncIcon());
		clickBtnW(By.cssSelector(StartLocator.SyncConfirm_Css));
	}
	
	public void startToSync(String xy) throws Exception{
		Log.info("Start to sync!");
		clickBtn(By.cssSelector(StartLocator.BackMenu_Css));
		implicitWait(2);
		clickBtnByTp(xy);
		waitForElementPresent(By.cssSelector(StartLocator.SyncPop_Css));
		clickBtn(By.cssSelector(StartLocator.SyncPopConfirm_Css));
		implicitWait(10);
	}
	
	public void startToLogout() throws Exception{
		Log.info("Start to logout!");
		clickBtn(By.cssSelector(StartLocator.BackMenu_Css));
		clickBtn(By.xpath(StartLocator.logOut_xpath));
	}
	
	public void startToRelease(String username,String password,String reason) throws Exception{
		Log.info("Start to release!");
		//clickBtn(By.cssSelector(StartLocator.ReleaseIcon_Css));
		clickBtnByTp("438,37");
		waitForElementPresent(By.cssSelector(StartLocator.ReleasePop_Css));
		InputUserName(By.xpath(StartLocator.ReleaseUserName_xpath),username);
		InputPassword(By.xpath(StartLocator.ReleasePassword_xpath),password);
		inputText(By.xpath(StartLocator.ReleaseReason_xpath),reason);
		//inputByIndex(By.cssSelector(StartLocator.Release_xpath),ReleaseInfo);
		clickBtn(By.cssSelector(StartLocator.ReleaseConfirm_Css));		
	}
	
}
