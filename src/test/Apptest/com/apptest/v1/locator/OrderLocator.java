package com.apptest.v1.locator;

public class OrderLocator {
	
	//First page
	public static final String TopLeftMenu_xpath = "//android.view.View[@index='0']";
	public static final String TangShi_xpath = "//android.view.View[@content-desc='堂食']";
	public static final String TangShiW_xpath = "//p[text()='堂食']";
	public static final String TakeOut_xpath = "//p[text()='外卖']";
	public static final String Bill_xpath = "//android.view.View[@content-desc='账单']";
	
	//Select page
	public static final String BackTo_Css = ".vux-header-back.v-transition";
	public static final String All_Css = ".vux-tab-item.vux-tab-selected";
	public static final String TableEmpty_xpath = "//div[@class='table']";
	public static final String TableLocked_xpath = "//div[@class='table locked']";
	public static final String TableOrdered_xpath = "//div[@class='table ordered']";
		
	//Order page
	public static final String Peoplepop_Id= "weui-actionsheet";
	public static final String NumInput_Id = "kb-input";
	public static final String NumConfirm_xpath = "//android.view.View[@content-desc='确定']";
	public static final String Search_Css = ".weui-icon-search";
	
	public static final String skufood_xpath = "//span[text()='sku菜']";
	public static final String doubblefood_xpath = "//span[text()='双单位菜']";
	public static final String methodfood_xpath = "//span[text()='做法菜']";
	public static final String weightfood_xpath = "//span[text()='称重菜']";
	public static final String timefood_xpath = "//span[text()='时价菜']";
	public static final String setfood_xpath = "//span[text()='套餐']";
	public static final String skuSelectPop_Css = ".color_title";
	public static final String skuSelection_Css = ".color_detail";
	public static final String skuStandardS_xpath = "";
	public static final String skuSelectConfirm_xpath = "//a[text()='选好了']";
	public static final String skuPrice_Css = ".nomalcss";
	public static final String skuSelect_Css = ".item.select";
	
	//˫��λ
	public static final String doubleAdd_xpath = "//android.view.View[@index='0']/android.view.View[@content-desc='添加数量']";
	public static final String doublePage_Css = ".doubleUint";
	public static final String doubleunit_xpath = "//div[@class='doubleUint']//label";
	public static final String doubleInput_xpath = "//input[@data-float='3']";
	public static final String doubleConfirm_xpath = "//span[text()='确定']";
	public static final String methodPop_Css = ".dialog-mian";
	public static final String methodSelected_Css = ".dialog-body.scroll .active";
	public static final String methodSelect_Css = ".weigh-box .active";
	public static final String methodSelect_xpath = "//ul[@class='dialog-body scroll']/li";
	public static final String methodConfirm_xpath = "//div[text()='确定']";
	public static final String methodWeight_Css = ".container.flex.flex-column";
	public static final String weightPage_xpath = "//label[text()='菜品重量：']";
	public static final String weightInput_xpath = "//input[@data-float='3']";
	public static final String weightConfirm_xpath = "//span[text()='确定']";
	public static final String timePage_xpath = "//label[text()='菜品价格：']";
	public static final String timeDoubleInput_xpath = "//input[@data-float='3']";
	public static final String timeConfirm_xpath = "//span[text()='确定']";
	public static final String setPage_xpath = "//div[text()='固定单品']";
	public static final String setSelected_xpath = "//div[@class='container']//span[text()='1']/ancestor::li//div[@class='dish-name']";
	public static final String setConfirm_xpath = "//span[text()='确定']";
	
	//�µ�
	public static final String orderPage_Css = ".coder-section.scroll";
	public static final String confirmOrder_xpath = "//android.view.View[contains(@content-desc,'确定')]";
	public static final String placeOrder_xpath = "//android.view.View[contains(@content-desc,'下单')]";
	public static final String moneySum_Css = ".total-box .price";
	public static final String orderSuc_Css = ".weui-msg__title";
	public static final String orderContinue_xpath = "//a[text()='继续点菜']";
	public static final String orderCheck_xpath = "//android.view.View[@content-desc='查看已下单菜品')]";
	public static final String orderBill_Css = ".weui-btn.weui-btn_main";
	
	public static final String dishName_xpath = "//div[@class='dish-name']/p";
	public static final String chooseName_xpath = "//p[text()='sku普通菜']/ancestor::div/p[@class='choose_name']";
	public static final String dishPrice_xpath = "//p[text()='sku普通菜']/ancestor::div[@class='dishContainer']/div[@class='dish-price']";
	
	//����
	public static final String checkPage_xpath = "//p[text()='消费合计 ']";
	public static final String checkPageMoney_Css = ".weui-msg__desc";
	public static final String more_xpath = "//android.view.View[@content-desc='更多']";
	public static final String cash_xpath = "//p[text()='现金']";
	public static final String card_xpath = "//p[text()='银行卡']";
	public static final String pay_xpath = "//android.view.View[@content-desc='支付']";
	public static final String reCheck_xpath = "//android.view.View[@content-desc='反结']";
	public static final String reCheckReason_Css = ".dialog-body.scroll li";
	public static final String reCheckCon_xpath = "//div[text()='确定']";
	public static final String checkAll_Css = "p.sub em";
	public static final String checkEnd_Css = ".weui-cell__ft.color-org";
	
	//�ۿ�
	public static final String discountMore_Css = ".vux-header-more";
	public static final String discount_xpath = "//div[text()='折扣']";
	public static final String rebate_xpath = "//div[text()='折让']";
	public static final String discountselect_Css = ".weui-cells";
	public static final String discountselected_Css = ".weui-cell.selected p";
	public static final String rebatetselect_Css = ".page-container.bg-gray .weui-cell__bd";
	public static final String rebateMax_Css = ".keyboard-back.flex .flex-item";
	public static final String rebateInput_Id = "kb-input";
	
	//
	public static final String changeWeight_xpath = "//div[text()='修改重量']";
	public static final String weightInput_Id = "kb-input";
	public static final String foodNote_xpath = "//div[text()='备注']";
	public static final String notePage_Css = ".coder-box.scroll";
	public static final String noteSelected_Css = "div.coder-box.scroll .active";
	public static final String noteConfirm_xpath = "//span[text()='确定']";
	public static final String foodNotedisplay_Css = ".dish-item-tips dt";
	public static final String foodNoteselection_Css = ".dish-item-tips dd span";
	public static final String rightMenu_Css = ".vux-header-more";
	public static final String allNote_xpath = "//div[text()='整单备注']";
	public static final String allNoteselection_Css = ".all-remarks span";
	public static final String allNotedisplay_Css = ".all-remarks";
	public static final String cancelBill_xpath = "//div[text()='取消账单']";
	public static final String cancelPage_Css = ".dialog-mian";
	public static final String cancelReanson_Css = ".dialog-body.scroll li";
	public static final String cancelConfirm_xpath = "//div[text()='确定']";
}
