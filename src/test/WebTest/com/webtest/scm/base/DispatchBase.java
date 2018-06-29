package com.webtest.scm.base;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.webtest.scm.config.Log;
import com.webtest.scm.locator.Locator;
import com.webtest.scm.page.DispatchPage;

public class DispatchBase extends DispatchPage {
	
	public static String DeliveryStatus;
	public static String OutStatus;
	public static String OutCode;
	
	public void openChainPage() throws Exception {
		goToChainPage();
		waitForElementPresent(By.cssSelector(Locator.LeftMenu_Css));
	}
	
	public void addPurchaseOrder() throws Exception {
		
		goToStoreManage();
		goToPurchase();
		selectStore();
		addPurchase();
		selectStall();
		selectGoods();
		selectGoodsNum();
		selectDate();
		clickRequest();
	}
	
	
	public void verifyPurchaseOrder() throws Exception {		
//		if(elementExist(By.xpath(Locator.PurchaseSuccess_Xpath))) {
//			Log.info("Purchase order create successfully!");
//		}else {				
//		    Log.error("Purchase order create failed!");
//		}	
		try {
			Assert.assertTrue(elementExist(By.xpath(Locator.PurchaseSuccess_Xpath)));
		}catch(Error e) {
			throw new Exception(e);
		}
	}
	
	public void splitDeliveryOrder() throws Exception {
		//Logistics Manage
		goToLogisticsManage();
		//Order center
		goToOrderCenter();
		//select delivery center
		selectDeliveryCenter();
		//select purchaseOrder
		selectPurchaseOrder();
		oneClick();
		//split
		splitOrder();
	}
	
	public void deliveryConfirm() throws Exception {
		//Delivery Order
		goToDeliveryManage();
		//submit delivery Order
		submitDeliveryOrder();
	}
	
	public void verifyStatus(String locator,String status) throws Exception {
		waitForElementPresent(By.xpath(locator));
		String Status = findElement(By.xpath(locator)).getText();

		try {
			Assert.assertEquals(status, Status);
			Log.info("Order status is right!"+" And Status is: " + status);
		}catch(Error e) {
			Log.error("Order status is wrong!");
			throw e;
		}
			
	}
	
	public void deliveryOut() throws Exception {
		goToOutPage();
		submitOut();
	}
	
	public void deliveryAccept() throws Exception {
		//Store Accept
		goToStoreManage();
		goToAcceptManage();
		//select store
		selectStore2();
		clickAccept();
		OutCode = findElement(By.xpath("//td[text()='"+DeliveryCode+"']/ancestor::tr/td[1]")).getText();
	}

}
