package com.apptest.v1.cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apptest.v1.config.GetTestProperties;
import com.apptest.v1.locator.OrderLocator;
import com.apptest.v1.base.OrderBase;


public class TestSkuOrderCase extends OrderBase{
	
	    @Test
		public void makeSkuOrder() throws Exception{
			startcase.login();
			goToOrderPage(GetTestProperties.getConfirm());
			skuOrder(GetTestProperties.getSku(),GetTestProperties.getSkuP());			
			clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
			Assert.assertTrue(getFoodName().contains(GetTestProperties.getSkuP()));
			Assert.assertTrue(getFoodSelect(GetTestProperties.getSkuP()));
			Assert.assertTrue(getFoodPrice(GetTestProperties.getSkuP()));			
	    }
		
		//@Test
		public void makeSkuMethodOrder() throws Exception{
			startcase.login();
			goToOrderPage(GetTestProperties.getConfirm());			
			skuMethod(GetTestProperties.getSku(),GetTestProperties.getSkuZ());
			clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
			Assert.assertTrue(getFoodName().contains(GetTestProperties.getSkuZ()));
			Assert.assertTrue(getFoodSelect(GetTestProperties.getSkuZ()));
			Assert.assertTrue(getFoodPrice(GetTestProperties.getSkuZ()));	
			Assert.assertTrue(getFoodMethod(GetTestProperties.getSkuZ()));
		}
		
		//@Test
		public void makeSkuDoubleOrder() throws Exception{		
			startcase.login();
			goToOrderPage(GetTestProperties.getConfirm());			
			skuDouble(GetTestProperties.getSku(),GetTestProperties.getSkuS(),"2,2");
			clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
			Assert.assertTrue(getFoodName().contains(GetTestProperties.getSkuS()));
			Assert.assertTrue(getFoodSelect(GetTestProperties.getSkuS()));
			Assert.assertTrue(getFoodPrice(GetTestProperties.getSkuS()));	
			Assert.assertTrue(getDoubleUnit(GetTestProperties.getSkuS()));
		}

}
