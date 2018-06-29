package com.apptest.v1.cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apptest.v1.config.GetTestProperties;
import com.apptest.v1.config.Log;
import com.apptest.v1.locator.OrderLocator;
import com.apptest.v1.base.OrderBase;

public class TestWeightOrderCase extends OrderBase{
	    @Test
		public void makeWeightOrder() throws Exception{
			startcase.login();
			goToOrderPage(GetTestProperties.getConfirm());
			weightOrder(GetTestProperties.getWeight(),GetTestProperties.getWPxy(),GetTestProperties.getWP(),"2");
			//weightSkuTime("sku˫ʱ","2,2,2");
			clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
			Log.info("Verify food name!");
			Assert.assertTrue(getFoodName().contains(GetTestProperties.getWP()));
			Log.info("Verify food price!");
			Assert.assertTrue(getFoodPrice(GetTestProperties.getWP()));
		}
		
		@Test
		public void makeTimeWeightOrder() throws Exception{
			startcase.login();
			goToOrderPage(GetTestProperties.getConfirm());
			timeWeightOrder(GetTestProperties.getTime(),GetTestProperties.getTWxy(),GetTestProperties.getTW(),"100,2");
			clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
			Log.info("Verify food name!");
			Assert.assertTrue(getFoodName().contains(GetTestProperties.getTW()));
			Log.info("Verify food price!");
			Assert.assertTrue(getFoodPrice(GetTestProperties.getTW()));
		}

}
