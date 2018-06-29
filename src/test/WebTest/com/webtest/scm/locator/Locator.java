package com.webtest.scm.locator;

public class Locator {
	
	
	//Login 
	public static final String FirstPage_Css = ".form-signin-heading";
	public static final String UserName_Id = "username";
	public static final String PassWord_Id = "password";
	public static final String LoginBtn_Css = ".btn.btn-success.btn-block";
	public static final String LoginTitle_Css = ".header___1166V";
	public static final String SupplyChain_Css = "//a[contains(@href,'taxRate')]";
	
	//Left Menu
	public static final String LeftMenu_Css = "ul.ant-menu.ant-menu-inline.ant-menu-light";
	public static final String SupplyManage_Xpath = "//span[text()='供应商管理']";
	
	public static final String StoreManage_Xpath = "//div[@aria-owns='sub5$Menu']/span/span";
	public static final String Purchase_Xpath = "//a[text()='采购管理']";
	public static final String Acceptance_Xpath = "//a[text()='验收管理']";
	public static final String Settlement_Xpath = "//a[text()='结算管理']";
	
	public static final String LogisticsManage_Xpath = "//span[text()='物流管理']";
	public static final String OrderCenter_Xpath = "//a[text()='订单中心']";
	public static final String Purchase2_Xpath = "//a[text()='采购管理']";
	public static final String Delivery_Xpath = "//a[text()='配送管理']";
	
	public static final String StoreSettlement_Xpath = "//span[text()='门店结算']";
	
	public static final String SupplySetttlement_Xpath = "//span[text()='供应商结算']";
	
	//Purchase Management page
	public static final String PurchaseTitle_Css = ".ant-breadcrumb-link";
	public static final String SelectStore_Css = ".ant-select-selection__rendered";
	public static final String SelectStore_Id = "shopName";
	public static final String AddPurchase_Css = ".float-top .ant-btn.ant-btn-primary.ant-btn-lg";
	public static final String AddPurchasepage_Xpath = "//span[text()='新增请购单']";
	public static final String SelectStall_Xpath = "//div[@title='[object Object]']";
    public static final String CodeInput_Xpath = "//div[@class='ant-table-scroll']//tr[@class='ant-table-row editable-row ant-table-row-level-0']/td[2]/div[1]/div";
	public static final String CodeSearch_Css = ".anticon.anticon-search";
	public static final String CodeSearch_Xpath = "//div[@class='editing-field']//button[1]";
	public static final String SelectGoodsWin_Css = ".ant-modal-content";
	public static final String Selection_Css = ".ant-table-row .ant-table-selection-column";
	public static final String SelectGoodsCon_Css = ".ant-btn.ant-btn-primary.ant-btn-lg";
	public static final String NumberClick_Xpath = "//div[@class='ant-table-scroll']//tr[@class='ant-table-row editable-row ant-table-row-level-0']/td[5]/div[1]/div";
	public static final String NumberInput_Xpath = "//input[@class='ant-input']";
	public static final String Request_Css = ".ant-btn.ant-btn-primary";
	public static final String PurchaseSuccess_Xpath = "//tbody[@class='ant-table-tbody']//tr[1]/td[1]";
	
	
	//Accept Manage
	public static final String DeliveryAccept_Xpath = "//div[text()='配送验收']";
	public static final String SelectStore2_Css = ".ant-select-lg .ant-select-selection__rendered";
	public static final String InputStore_Id = "storeId";
	public static final String Accept_Css = ".ant-btn.ant-btn-primary";
	public static final String AcceptNumInput_Css = "div.editing-field input.ant-input";
	
	//Order Center
	public static final String DeliveryCenter_Xpath = "//div[@title='请选择配送中心']";
	public static final String DeliveryName_Id = "shopName";
	public static final String OneClickCreate_Xpath = "//span[text()='一键生成订单']";
	public static final String OneClickCreate_Css = ".float-top .ant-btn.ant-btn-lg";
	public static final String Split_Css = ".ant-btn.ant-btn-primary";
	public static final String SplitConWin_Css = ".ant-popover-inner-content";
	public static final String SplitCon_Css = ".ant-btn.ant-btn-primary.ant-btn-sm";
	public static final String SplitOk_Xpath = "//span[text()='拆分成功']";
	
	//Delivery Manage
	public static final String DeliveryCode_Css = ".ant-tag-text";
	public static final String Deliveryok_Css = ".ant-btn.ant-btn-primary.ant-btn-lg";
	public static final String EditDeliveryOrder_Xpath = "//span[text()='编辑配送订单']";
	public static final String DeliverySub_Css = ".ant-btn.ant-btn-primary";
	public static final String DeliveryOut_Xpath = "//div[text()='配送出库']";
	public static final String EditOutOrder_Xpath = "//span[text()='编辑出库单']";
	public static final String OutBtn_Css = ".ant-btn.ant-btn-primary";
}
