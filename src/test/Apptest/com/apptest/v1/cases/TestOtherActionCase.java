package com.apptest.v1.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apptest.v1.config.GetTestProperties;
import com.apptest.v1.locator.OrderLocator;
import com.apptest.v1.base.OrderBase;


public class TestOtherActionCase extends OrderBase{

	//@Test
	public void makeOrder() throws Exception{
		startcase.login();
		goToOrderPage(GetTestProperties.getConfirm());
		setOrderTwo(GetTestProperties.getSet(),GetTestProperties.getSetTwoxy(),GetTestProperties.getSetTwo());
		clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
		String money = waitForElementPresent(By.cssSelector(OrderLocator.moneySum_Css)).getText();
		clickBtn(By.xpath(OrderLocator.placeOrder_xpath));
		String moneyp = waitForElementPresent(By.cssSelector(OrderLocator.checkPageMoney_Css)).getText();
		WebElement success = waitForElementPresent(By.cssSelector(OrderLocator.orderSuc_Css));
		Assert.assertTrue(success.isDisplayed());
		Assert.assertEquals(money, moneyp);
	}
	
	//@Test
	public void checkOut() throws Exception{
		startcase.login();
		goToOrderPage(GetTestProperties.getConfirm());
		setOrderOne(GetTestProperties.getSet(),GetTestProperties.getSetOnexy(),GetTestProperties.getSetOne());
		clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
		clickBtn(By.xpath(OrderLocator.placeOrder_xpath));
		checkOutByCash();
		WebElement All = waitForElementPresent(By.cssSelector(OrderLocator.All_Css));
		Assert.assertTrue(All.isDisplayed());
	}
	
	//@Test
	public void reCheckOut() throws Exception{
		startcase.login();
		reCheck(GetTestProperties.getRecheck());
		WebElement All = waitForElementPresent(By.cssSelector(OrderLocator.All_Css));
		Assert.assertTrue(All.isDisplayed());
	}
	
	//@Test
	public void discount() throws Exception{
		startcase.login();
		goToOrderPage(GetTestProperties.getConfirm());
		skuOrder(GetTestProperties.getSku(),GetTestProperties.getSkuP());
		clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
		clickBtn(By.xpath(OrderLocator.placeOrder_xpath));
		clickBtnW(By.cssSelector(OrderLocator.orderBill_Css));
		goDiscount();
		goRebate();
		Assert.assertTrue(waitForElementPresent(By.xpath("//p[text()='"+selectedDiscount+"']")).isDisplayed());
		Assert.assertTrue(waitForElementPresent(By.xpath("//p[text()='"+GetTestProperties.getRebate()+"']")).isDisplayed());
		Assert.assertTrue(discountPrice());
	}
	
	//@Test
	public void changeWeight() throws Exception{
		startcase.login();
		goToOrderPage(GetTestProperties.getConfirm());
		weightOrder(GetTestProperties.getWeight(),GetTestProperties.getWPxy(),GetTestProperties.getWP(),"2");
		clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
		clickBtnW(By.xpath("//p[text()='"+GetTestProperties.getWP()+"']"));
		editWeight();
		String weight = waitForElementPresent(By.xpath("//p[text()='"+GetTestProperties.getWP()+"']/ancestor::div[@class='dishContainer']//div[@class='dish-num']")).getText().substring(1);
		Assert.assertEquals(newnumber, weight);
	}
	
	//@Test
	public void foodNote() throws Exception{
		startcase.login();
		goToOrderPage(GetTestProperties.getConfirm());
		skuOrder(GetTestProperties.getSku(),GetTestProperties.getSkuP());
		clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
		clickBtnW(By.xpath("//p[text()='"+GetTestProperties.getSkuP()+"']"));
		addFoodNote();
		Assert.assertTrue(waitForElementPresent(By.cssSelector(OrderLocator.foodNotedisplay_Css)).isDisplayed());
		Assert.assertTrue(getNote(OrderLocator.foodNoteselection_Css));
	}
	
	@Test
	public void allNote() throws Exception{
		startcase.login();
		goToOrderPage(GetTestProperties.getConfirm());
		methodOrder(GetTestProperties.getMethod(),GetTestProperties.getZPxy(),GetTestProperties.getZP());
		clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
		addAllNote();
		Assert.assertTrue(waitForElementPresent(By.cssSelector(OrderLocator.allNotedisplay_Css)).isDisplayed());
		Assert.assertTrue(getNote(OrderLocator.allNoteselection_Css));
	}
	
	//@Test
	public void cancelBill() throws Exception{
		startcase.login();
		goToOrderPage(GetTestProperties.getConfirm());
		weightOrder(GetTestProperties.getWeight(),GetTestProperties.getWPxy(),GetTestProperties.getWP(),"2");
		clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
		goCancelBill();
		WebElement All = waitForElementPresent(By.cssSelector(OrderLocator.All_Css));
		Assert.assertTrue(All.isDisplayed());
	}

}
