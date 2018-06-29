package com.apptest.v1.cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apptest.v1.config.GetTestProperties;
import com.apptest.v1.config.Log;
import com.apptest.v1.locator.OrderLocator;
import com.apptest.v1.base.OrderBase;

public class TestSetOrderCase extends OrderBase{
	    @Test
		public void makeSetOneOrder() throws Exception{
			startcase.login();
			goToOrderPage(GetTestProperties.getConfirm());
			setOrderOne(GetTestProperties.getSet(),GetTestProperties.getSetOnexy(),GetTestProperties.getSetOne());
			clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
			Log.info("Verify food name!");
			Assert.assertTrue(getSetSelect(GetTestProperties.getSetOne()).contains(setselect));
			Log.info("Verify food price!");
			Assert.assertTrue(getFoodPrice(GetTestProperties.getSetOne()));
			
		}
		@Test
		public void makeSetTwoOrder() throws Exception{
			startcase.login();
			goToOrderPage(GetTestProperties.getConfirm());
			setOrderTwo(GetTestProperties.getSet(),GetTestProperties.getSetTwoxy(),GetTestProperties.getSetTwo());
			clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
			Log.info("Verify food name!");
			Assert.assertTrue(getSetTwo(GetTestProperties.getSetTwo()));
			Log.info("Verify food price!");
			Assert.assertTrue(getFoodPrice(GetTestProperties.getSetTwo()));
		}

}
