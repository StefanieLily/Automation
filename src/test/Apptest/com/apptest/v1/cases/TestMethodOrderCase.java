package com.apptest.v1.cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apptest.v1.config.GetTestProperties;
import com.apptest.v1.config.Log;
import com.apptest.v1.locator.OrderLocator;
import com.apptest.v1.base.OrderBase;

public class TestMethodOrderCase extends OrderBase{
	    @Test
		public void makeMethodOrder() throws Exception{
			startcase.login();
			goToOrderPage(GetTestProperties.getConfirm());
			methodOrder(GetTestProperties.getMethod(),GetTestProperties.getZPxy(),GetTestProperties.getZP());
			clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
			Log.info("Verify food name!");
			Assert.assertTrue(getFoodName().contains(GetTestProperties.getZP()));
			Log.info("Verify food method!");
			Assert.assertTrue(getFoodMethod(GetTestProperties.getZP()));
			Log.info("Verify food price!");
			Assert.assertTrue(getFoodPrice(GetTestProperties.getZP()));
		}
		
		@Test
		public void makeMethodSWOrder() throws Exception{
			startcase.login();
			goToOrderPage(GetTestProperties.getConfirm());
			methodSkuWeight(GetTestProperties.getMethod(),GetTestProperties.getZSkuW(),"2");
			clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
			Log.info("Verify food name!");
			Assert.assertTrue(getFoodName().contains(GetTestProperties.getZSkuW()));
			Log.info("Verify food method!");
			Assert.assertTrue(getFoodMethod(GetTestProperties.getZSkuW()));
			Log.info("Verify food price!");
			Assert.assertTrue(getFoodPrice(GetTestProperties.getZSkuW()));
		}

}
