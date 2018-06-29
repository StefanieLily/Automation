package com.webtest.scm.page;

import org.openqa.selenium.By;

import com.webtest.scm.common.Common;
import com.webtest.scm.config.GetTestProperties;
import com.webtest.scm.locator.Locator;

public class DispatchPage extends Common{
	public static String DeliveryCode;
	public static String OrderCode;
	
    public void goToChainPage() throws Exception {
		driver.get(GetTestProperties.getChainUrl());
	}
	
	
	public void goToStoreManage() throws Exception {	
		waitForElementPresent(By.xpath(Locator.StoreManage_Xpath));
		click(By.xpath(Locator.StoreManage_Xpath));
	}
	
	
	public void goToPurchase() throws Exception{	
		waitForElementPresent(By.xpath(Locator.Purchase_Xpath));
		click(By.xpath(Locator.Purchase_Xpath));
	}
	
	public void selectStore() throws Exception {
		waitForElementPresent(By.cssSelector(Locator.SelectStore_Css));
		click(By.cssSelector(Locator.SelectStore_Css));
		input(By.id(Locator.SelectStore_Id),GetTestProperties.getStorename());
		clickEnter();
	}
	
	public void addPurchase() throws Exception{
		waitForElementPresent(By.cssSelector(Locator.AddPurchase_Css));
		click(By.cssSelector(Locator.AddPurchase_Css));
	}
	
	
	public void selectStall() throws Exception {
		waitForElementPresent(By.xpath(Locator.AddPurchasepage_Xpath));	
		click(By.xpath(Locator.SelectStall_Xpath));
		clickEnter();
	}
	
	public void selectGoods() throws Exception {
		click(By.xpath(Locator.CodeInput_Xpath));
		waitForElementPresent(By.xpath(Locator.CodeSearch_Xpath));
		click(By.xpath(Locator.CodeSearch_Xpath));
		waitForElementPresent(By.cssSelector(Locator.SelectGoodsWin_Css));
		click(By.cssSelector(Locator.Selection_Css));
		click(By.cssSelector(Locator.SelectGoodsCon_Css));
	}
	
	public void selectGoodsNum() throws Exception {
		waitForElementPresent(By.xpath(Locator.NumberClick_Xpath));
		click(By.xpath(Locator.NumberClick_Xpath));
		input(By.xpath(Locator.NumberInput_Xpath),GetTestProperties.getGoodsNumber());
		clickEnter();
	}
	
	public void selectDate() throws Exception {
		waitForElementPresent(By.xpath("//td[@title='"+GetTestProperties.getDeliveryDate()+"']"));
		click(By.xpath("//td[@title='"+GetTestProperties.getDeliveryDate()+"']"));
		
	}
	
	public void clickRequest() throws Exception {
		click(By.cssSelector(Locator.Request_Css));
		waitForElementPresent(By.xpath(Locator.PurchaseSuccess_Xpath));
		OrderCode = findElement(By.xpath(Locator.PurchaseSuccess_Xpath)).getAttribute("innerText");
		System.out.println(OrderCode);
	}
	
	public void goToLogisticsManage() throws Exception {
		click(By.xpath(Locator.LogisticsManage_Xpath));
	}
	
	public void goToOrderCenter() throws Exception {
		waitForElementPresent(By.xpath(Locator.OrderCenter_Xpath));
		click(By.xpath(Locator.OrderCenter_Xpath));
	}
	
	public void selectDeliveryCenter() throws Exception {
		waitForElementPresent(By.xpath(Locator.DeliveryCenter_Xpath));
		click(By.xpath(Locator.DeliveryCenter_Xpath));
		input(By.id(Locator.DeliveryName_Id),GetTestProperties.getDispatchName());
		clickEnter();
	}
	
	public void selectPurchaseOrder() throws Exception {
		waitForElementPresent(By.xpath("//td[text()='"+OrderCode+"']/ancestor::tr//span"));
		click(By.xpath("//td[text()='"+OrderCode+"']/ancestor::tr//span"));
	}
	
	public void oneClick() throws Exception {
		click(By.cssSelector(Locator.OneClickCreate_Css));
	}
	
	public void splitOrder() throws Exception {
		waitForElementPresent(By.cssSelector(Locator.Split_Css));
		click(By.cssSelector(Locator.Split_Css));
		waitForElementPresent(By.cssSelector(Locator.SplitConWin_Css));
		click(By.cssSelector(Locator.SplitCon_Css));
		waitForElementPresent(By.xpath(Locator.SplitOk_Xpath));
		DeliveryCode = findElement(By.cssSelector(Locator.DeliveryCode_Css)).getText();
		click(By.cssSelector(Locator.Deliveryok_Css));
	}
	
	public void goToDeliveryManage() throws Exception {
		waitForElementPresent(By.xpath(Locator.Delivery_Xpath));
		click(By.xpath(Locator.Delivery_Xpath));
	}
	
	public void submitDeliveryOrder() throws Exception {
		waitForElementPresent(By.xpath("//td[text()='"+DeliveryCode+"']"));
		click(By.xpath("//td[text()='"+DeliveryCode+"']/ancestor::tr//a[text()='编辑']"));
		waitForElementPresent(By.xpath(Locator.EditDeliveryOrder_Xpath));
		click(By.cssSelector(Locator.DeliverySub_Css));
	}
	
	public void goToOutPage() throws Exception {
		click(By.xpath(Locator.DeliveryOut_Xpath ));
		waitForElementPresent(By.xpath("//td[text()='"+DeliveryCode+"']"));
	}
	
	public void submitOut() throws Exception {
		click(By.xpath("//td[text()='"+DeliveryCode+"']/ancestor::tr//a[text()='出库']"));
		waitForElementPresent(By.xpath(Locator.EditOutOrder_Xpath));
		click(By.cssSelector(Locator.OutBtn_Css));
	}
	
	public void goToAcceptManage() throws Exception {
		click(By.xpath(Locator.Acceptance_Xpath));
		waitForElementPresent(By.xpath(Locator.DeliveryAccept_Xpath));
	}
	
	public void selectStore2() throws Exception {
		click(By.cssSelector(Locator.SelectStore2_Css));
		input(By.id(Locator.InputStore_Id),GetTestProperties.getStorename());
		clickEnter();
	}
	
	public void clickAccept() throws Exception {
		clickByJS(findElement(By.xpath("//td[text()='"+DeliveryCode+"']/ancestor::tr//a[text()='验收']")));
		click(By.xpath("//td[text()='"+OrderCode+"']/ancestor::tr//td[@class='editable-col'][1]/div/div"));
		input(By.cssSelector(Locator.AcceptNumInput_Css),GetTestProperties.getAcceptNumber());
		click(By.cssSelector(Locator.Accept_Css));
	}

}
