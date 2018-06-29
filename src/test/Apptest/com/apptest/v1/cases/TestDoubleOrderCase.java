package com.apptest.v1.cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apptest.v1.config.GetTestProperties;
import com.apptest.v1.config.Log;
import com.apptest.v1.locator.OrderLocator;
import com.apptest.v1.base.OrderBase;

public class TestDoubleOrderCase extends OrderBase{
	    @Test
		public void makeDoubleWeiOrder() throws Exception{
			startcase.login();
			goToOrderPage(GetTestProperties.getConfirm());
			doubleWeight(GetTestProperties.getDouble(),GetTestProperties.getDW(),"2,2");
			clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
			Assert.assertTrue(getFoodName().contains(GetTestProperties.getDW()));
			Assert.assertTrue(getFoodPrice(GetTestProperties.getDW()));
			
		}
		
		@Test
		public void makeDoubleTimeOrder() throws Exception{
			startcase.login();
			goToOrderPage(GetTestProperties.getConfirm());
			doubleTime(GetTestProperties.getDouble(),GetTestProperties.getDT(),"100,2,2");
			clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
			Log.info("Verify food name!");
			Assert.assertTrue(getFoodName().contains(GetTestProperties.getDT()));
			Log.info("Verify food price!");
			Assert.assertTrue(getFoodPrice(GetTestProperties.getDT()));
			Log.info("Verify food unit!");
			Assert.assertTrue(getDoubleUnit(GetTestProperties.getDT()));
		}

}
