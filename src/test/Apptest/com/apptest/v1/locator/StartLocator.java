package com.apptest.v1.locator;

public class StartLocator {
	
	//Binding page
	public static final String BindingTitle_Css = ".page-layout.bg .vux-header-title";
	public static final String BindingName_Id = "userAccount";
	public static final String BindingPassWord_Id = "userPwd";
	public static final String BindingConfirm_Css = ".weui_btn.weui_btn_warn.weui-btn_main";
	
	//Login page
	public static final String LoginTitle_Css = ".page-layout .vux-header-title";
	public static final String UserName_Id = "userAccount";
	public static final String Password_Id = "userPass";
	public static final String LoginBtn_xpath = "//android.view.View[@content-desc='登录']";
	public static final String LoginBtn_Css = ".weui-btn.weui-btn_main";	
	
	//Release pop up
	public static final String ReleaseIcon_Css = ".icon span";
	public static final String ReleasePop_Css = ".color_con";
	public static final String ReleaseUserName_xpath = "//span[text()='账号：']/ancestor::div/input";
	public static final String ReleasePassword_xpath = "//span[text()='密码：']/ancestor::div/input";
	public static final String ReleaseReason_xpath = "//textarea[@placeholder='请输入解绑原因']";
	public static final String ReleaseConfirm_Css = "a.suc";
	public static final String ReleaseCancel_Css = "a.file";

	
	//Login page sync
	public static final String Sync_xpath = "//span[@class='icon']/img";
	public static final String SyncConfirm_Css = ".weui_btn_dialog.primary";
	public static final String SyncCancle_Css = ".weui_btn_dialog.default";
	public static final String SyncPop_xpath = "//p[text()='正在同步系统时间...']";
	
	//Left Page
	public static final String BackMenu_Css = ".vux-header-back.v-transition";
	public static final String SyncData_xpath = "//p[text()='同步数据']//ancestor::div[@class='weui_cell vux-tap-active']";
	public static final String SyncPop_Css = ".profile.open .vux-dialog-transition";
	public static final String SyncPopConfirm_Css= ".profile.open .vux-dialog-transition .primary";
	public static final String exchange_xpath = "//p[text()='交班']//ancestor::div[@class='weui_cell vux-tap-active']";
    public static final String logOut_xpath = "//p[text()='退出登录']//ancestor::div[@class='weui_cell vux-tap-active']";
}
