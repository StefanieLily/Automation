package com.apptest.v1.page;

import io.appium.java_client.android.AndroidElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.apptest.v1.common.Common;
import com.apptest.v1.config.GetTestProperties;
import com.apptest.v1.locator.OrderLocator;


public class OrderPage extends Common{
	public static List<AndroidElement> foodSelections;
	public static List<String> foodselections = new ArrayList<String>();
	public static List<AndroidElement> doubleUnits;
	public static List<String> doubleunits = new ArrayList<String>();
	public static List<String> units = new ArrayList<String>();
	public static int price1;
	
	//open table
	public void openTable() throws Exception{
		if(elementNotExist(By.xpath(OrderLocator.TableEmpty_xpath))){
			clearTable();
		}	
		List<AndroidElement> table = findElements(By.xpath(OrderLocator.TableEmpty_xpath));
		if(table.size()==1){
			clickBtnW(By.xpath(OrderLocator.TableEmpty_xpath));
		}else{
			int i = table.size();
			table.get((new Random()).nextInt(i)).click();			
		}	
	}
	
	//clear table
	public void clearTable() throws Exception{
		List<AndroidElement> table = findElements(By.xpath(OrderLocator.TableOrdered_xpath));
		int i = table.size();
		table.get((new Random()).nextInt(i)).click();
		clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
    	clickBtn(By.xpath(OrderLocator.placeOrder_xpath));
    	clickBtnW(By.cssSelector(OrderLocator.orderBill_Css));
    	waitForElementPresent(By.xpath(OrderLocator.checkPage_xpath));
    	clickBtn(By.xpath(OrderLocator.more_xpath));
    	clickBtnW(By.xpath(OrderLocator.cash_xpath));
    	clickBtnByTp(GetTestProperties.getPay());
	}
	
	//select sku standard
	public void selectSkuByRandom(By by)throws Exception{
		int num = driver.findElements(by).size();
		for(int i=1;i<=num;i++){
			List<AndroidElement> selections = findElements(By.xpath("//div[@class='color_detail']"+"["+i+"]//li[@class='item']"));
			int num2 = selections.size();
			selections.get((new Random()).nextInt(num2)).click();
		}
	}
	
	//get sku price
	public void getSkuPrice(By by) throws Exception{
		String price = waitForElementPresent(By.cssSelector(OrderLocator.skuPrice_Css)).getText();
		price = price.substring(1,price.length());
		price1 = Integer.parseInt(price);
	}
	
	//get double weight price on select food page
	public void getdoubleWeightPrice(String foodname) throws Exception{
		WebElement e = waitForElementPresent(By.xpath("//div[text()='"+foodname+"']/ancestor::div//div[@class='changeNum']/div[not(contains(@class,'icon'))]"));
    	int number = Integer.parseInt(e.getText());
    	String price = waitForElementPresent(By.xpath("//div[text()='"+foodname+"']/ancestor::div/div[@class='dish-bottom']/div[@class='price']/div")).getText();
    	price = price.substring(1,price.indexOf("."));
    	price1 = Integer.parseInt(price);
    	price1 *= number;
	}
	
	//get price on select food page
	public void getPriceSP(String foodname) throws Exception{
		WebElement e = waitForElementPresent(By.xpath("//div[text()='"+foodname+"']//ancestor::div//div[@class='handle-value']/span"));
    	int number = Integer.parseInt(e.getText());
    	String price = waitForElementPresent(By.xpath("//div[text()='"+foodname+"']/ancestor::div/div[@class='dish-bottom']/div[@class='price']/div")).getText();
    	price = price.substring(1,price.indexOf("."));
    	price1 = Integer.parseInt(price);
    	price1 *= number;
	}
	
	//create sku selected
	public void createSelectedSkuList(By by) throws Exception{
		foodSelections = findElements(by);
		for(int i=0;i<foodSelections.size();i++){
    		AndroidElement e = foodSelections.get(i);
    		String select = e.getText();	
    		foodselections.add(i,select);
    	} 
	}
	
	//create double unit list
	public void createDoubleUnitList(By by,String n) throws Exception{
		doubleUnits = findElements(by);
    	for(int i=0;i<doubleUnits.size();i++){
    		AndroidElement e = doubleUnits.get(i);
    		String select = e.getText().substring(e.getText().indexOf("(")+1, e.getText().indexOf(")"));;	
    		doubleunits.add(i,select);
    	}   	
	}
	
	//select method
	public void selectMethod(By by) throws Exception{
		List<AndroidElement> selections = driver.findElements(by);
		int num = selections.size();
		selections.get((new Random()).nextInt(num)).click();
	}
	
	//select reason
	public void selectReason(By by) {
		List<AndroidElement> reasons = driver.findElements(by);
		int num = reasons.size();
		reasons.get((new Random()).nextInt(num)).click();		
	}	

}
