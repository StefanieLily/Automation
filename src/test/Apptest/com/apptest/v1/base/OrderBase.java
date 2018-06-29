package com.apptest.v1.base;


import io.appium.java_client.android.AndroidElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.apptest.v1.cases.TestStartCase;
import com.apptest.v1.config.GetTestProperties;
import com.apptest.v1.config.Log;
import com.apptest.v1.locator.OrderLocator;
import com.apptest.v1.page.OrderPage;

public class OrderBase extends OrderPage{
	protected TestStartCase startcase = new TestStartCase();
	/*public static int price1;*/
	public static String method1;
	public static String setselect;
	public static String[] setselects = new String[10];
	public static List<AndroidElement> setselected;
	public static String selectedDiscount;
	public static String newnumber;
	public static String[] noteList;
	public static List<String> noteSelection = new ArrayList<String>();
	
	public void goToOrderPage(String xy) throws Exception{
		Log.info("Go to order page!");
		clickBtn(By.xpath(OrderLocator.TangShi_xpath));
		openTable();
		inputText(By.id(OrderLocator.NumInput_Id), "2");
		//clickBtn(By.xpath(OrderLocator.NumConfirm_xpath));
		clickBtnByTp(xy);
		waitForElementPresent(By.cssSelector(OrderLocator.orderPage_Css));
	}
	
	public void skuOrder(String xy, String skuname) throws Exception{	
		Log.info("Start sku order!");
		//ѡ��sku��
		clickBtnByTp(xy);
		//clickBtnW(By.xpath(OrderLocator.skufood_xpath));
		//ѡ��fawef��ͨ����
		//clickBtnByTp(515,296);
		clickBtnW(By.xpath("//div[text()='"+skuname+"']/ancestor::div/div[@class='dish-bottom']//span"));
		waitForElementPresent(By.cssSelector(OrderLocator.skuSelectPop_Css));
		selectSkuByRandom(By.cssSelector(OrderLocator.skuSelection_Css));
		createSelectedSkuList(By.cssSelector(OrderLocator.skuSelect_Css));
		getSkuPrice(By.cssSelector(OrderLocator.skuPrice_Css));
		clickBtnW(By.xpath(OrderLocator.skuSelectConfirm_xpath));
		waitForElementPresent(By.cssSelector(OrderLocator.Search_Css));
	}
	
    public void skuMethod(String xy,String skuMethod) throws Exception{
    	Log.info("Start skuMethod order!");
    	clickBtnByTp(xy);
    	//ѡ��sku������
    	clickBtnW(By.xpath("//div[text()='"+skuMethod+"']/ancestor::div/div[@class='dish-bottom']//span"));
    	waitForElementPresent(By.cssSelector(OrderLocator.skuSelectPop_Css));
    	selectSkuByRandom(By.cssSelector(OrderLocator.skuSelection_Css));
    	createSelectedSkuList(By.cssSelector(OrderLocator.skuSelect_Css));
    	getSkuPrice(By.cssSelector(OrderLocator.skuPrice_Css));
    	clickBtnW(By.xpath(OrderLocator.skuSelectConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.methodPop_Css));   	
    	selectMethod(By.xpath(OrderLocator.methodSelect_xpath));
    	method1 = waitForElementPresent(By.cssSelector(OrderLocator.methodSelected_Css)).getText();
    	clickBtnW(By.xpath(OrderLocator.methodConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.Search_Css));
    }
    
    public void skuDouble(String xy,String skuDouble,String n) throws Exception{
    	//ѡ��sku˫��λ��
    	Log.info("Start skuDouble order!");
    	clickBtnByTp(xy);
    	clickBtnW(By.xpath("//div[text()='"+skuDouble+"']/ancestor::div/div[@class='dish-bottom']//span"));
    	waitForElementPresent(By.cssSelector(OrderLocator.skuSelectPop_Css));
    	selectSkuByRandom(By.cssSelector(OrderLocator.skuSelection_Css));
    	createSelectedSkuList(By.cssSelector(OrderLocator.skuSelect_Css));
    	getSkuPrice(By.cssSelector(OrderLocator.skuPrice_Css));
    	clickBtnW(By.xpath(OrderLocator.skuSelectConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.doublePage_Css));
    	inputByIndex(By.xpath(OrderLocator.doubleInput_xpath), n);
    	createDoubleUnitList(By.xpath(OrderLocator.doubleunit_xpath),n);
    	units = stringConnect(doubleunits,n);
    	clickBtnW(By.xpath(OrderLocator.doubleConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.Search_Css));
    	int number = Integer.parseInt(driver.findElement(By.xpath("//div[text()='"+skuDouble+"']/ancestor::div//div[@class='changeNum']/div[not(contains(@class,'icon'))]")).getText());
    	price1 *= number;
    }
	
    public void doubleOrder(String xy,String doublename,String n) throws Exception{
    	Log.info("Start double order!");
    	//ѡ����˫
    	clickBtnByTp(xy);
    	clickBtnW(By.xpath("//div[text()='"+doublename+"']/ancestor::div/div[@class='dish-bottom']//span"));
    	waitForElementPresent(By.cssSelector(OrderLocator.doublePage_Css));
    	inputByIndex(By.xpath(OrderLocator.doubleInput_xpath), n);
    	createDoubleUnitList(By.xpath(OrderLocator.doubleunit_xpath),n);
    	units = stringConnect(doubleunits,n);
    	clickBtnW(By.xpath(OrderLocator.doubleConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.Search_Css));
	}
    
    public void doubleWeight(String xy,String doubleWeight,String n) throws Exception{
    	Log.info("Start doubleWeight order!");
    	//ѡ��˫��λ����
    	clickBtnByTp(xy);
    	clickBtnW(By.xpath("//div[text()='"+doubleWeight+"']/ancestor::div/div[@class='dish-bottom']//span"));
    	waitForElementPresent(By.xpath(OrderLocator.weightPage_xpath));
    	inputByIndex(By.xpath(OrderLocator.doubleInput_xpath), n);
    	clickBtnW(By.xpath(OrderLocator.doubleConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.Search_Css));
    	getdoubleWeightPrice(doubleWeight);
    	/*WebElement e = waitForElementPresent(By.xpath("//div[text()='"+doubleWeight+"']/ancestor::div//div[@class='changeNum']/div[not(contains(@class,'icon'))]"));
    	int number = Integer.parseInt(e.getText());
    	String price = waitForElementPresent(By.xpath("//div[text()='"+doubleWeight+"']/ancestor::div/div[@class='dish-bottom']/div[@class='price']/div")).getText();
    	price = price.substring(1,price.indexOf("."));
    	price1 = Integer.parseInt(price);
    	price1 *= number;*/
    }
    
    public void doubleTime(String xy,String doubleTime,String n) throws Exception{
    	Log.info("Start doubleTime order!");
    	//ѡ��˫��λʱ��
    	clickBtnByTp(xy);
    	clickBtnW(By.xpath("//div[text()='"+doubleTime+"']/ancestor::div/div[@class='dish-bottom']//span"));
    	waitForElementPresent(By.xpath(OrderLocator.timePage_xpath));
    	inputByIndex(By.xpath(OrderLocator.timeDoubleInput_xpath), n);
    	createDoubleUnitList(By.xpath(OrderLocator.doubleunit_xpath),n);
    	units = stringConnect(doubleunits,n.substring(n.indexOf(",")+1, n.length()));
    	price1 = Integer.parseInt(n.split(",")[0]);
    	price1 *= Integer.parseInt(n.split(",")[1]);
    	clickBtnW(By.xpath(OrderLocator.doubleConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.Search_Css));
    }

    public void methodOrder(String xy,String methodnamexy,String methodname) throws Exception{
    	Log.info("Start method order!");
    	//��ͨ������
    	clickBtnByTp(xy);
    	clickBtnByTp(methodnamexy);
    	//clickBtnW(By.xpath("//div[text()='"+methodname+"']/ancestor::div/div[@class='dish-bottom']/div[@class='handle-box']"));
    	waitForElementPresent(By.cssSelector(OrderLocator.methodPop_Css));
    	selectMethod(By.xpath(OrderLocator.methodSelect_xpath));
    	method1 = waitForElementPresent(By.cssSelector(OrderLocator.methodSelected_Css)).getText();
    	clickBtnW(By.xpath(OrderLocator.methodConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.Search_Css));
    	getPriceSP(methodname);
    	/*WebElement e = waitForElementPresent(By.xpath("//div[text()='"+methodname+"']//ancestor::div//div[@class='handle-value']/span"));
    	int number = Integer.parseInt(e.getText());
    	String price = waitForElementPresent(By.xpath("//div[text()='"+methodname+"']/ancestor::div/div[@class='dish-bottom']/div[@class='price']/div")).getText();
    	price = price.substring(1,price.indexOf("."));
    	price1 = Integer.parseInt(price);
    	price1 *= number;*/
    }
    
    public void methodSkuWeight(String xy,String methodSW,String n) throws Exception{
    	Log.info("Start methodSkuWeight order!");
    	//����sku����
    	clickBtnByTp(xy);
    	clickBtnW(By.xpath("//div[text()='"+methodSW+"']/ancestor::div/div[@class='dish-bottom']/div[@class='price']"));
    	waitForElementPresent(By.cssSelector(OrderLocator.skuSelectPop_Css));
    	selectSkuByRandom(By.cssSelector(OrderLocator.skuSelection_Css));
    	String price = waitForElementPresent(By.cssSelector(OrderLocator.skuPrice_Css)).getText();
    	price1 = Integer.parseInt(price.substring(1,price.length()));
    	price1 *= Integer.parseInt(n);
    	clickBtnW(By.xpath(OrderLocator.skuSelectConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.methodWeight_Css));
    	inputText(By.xpath(OrderLocator.weightInput_xpath), n);
    	method1 = waitForElementPresent(By.cssSelector(OrderLocator.methodSelect_Css)).getText();
    	clickBtnW(By.xpath(OrderLocator.weightConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.Search_Css));
    }
    
    public void weightOrder(String xy,String weightnamexy,String weightname,String n) throws Exception{
    	Log.info("Start Weight order!");
    	//��ͨ����
    	clickBtnByTp(xy);
    	clickBtnByTp(weightnamexy);
    	//clickBtnW(By.xpath("//div[text()='"+weithtname+"']/ancestor::div/div[@class='dish-bottom']/div[@class='handle-box']"));
    	waitForElementPresent(By.xpath(OrderLocator.weightPage_xpath));
    	inputText(By.xpath(OrderLocator.weightInput_xpath), n);
    	clickBtnW(By.xpath(OrderLocator.weightConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.Search_Css));
    	getPriceSP(weightname);
    	/*WebElement e = waitForElementPresent(By.xpath("//div[text()='"+weightname+"']//ancestor::div//div[@class='handle-value']/span"));
    	int number = Integer.parseInt(e.getText());
    	String price = waitForElementPresent(By.xpath("//div[text()='"+weightname+"']/ancestor::div/div[@class='dish-bottom']/div[@class='price']/div")).getText();
    	price = price.substring(1,price.indexOf("."));
    	price1 = Integer.parseInt(price);
    	price1 *= number;*/
    }
    
    public void weightSkuTime(String weitgtST,String n) throws Exception{
    	Log.info("Start weightSkuTime order!");
    	//����skuʱ��
    	//clickBtnByTp(521,687);
    	clickBtnW(By.xpath("//div[text()='"+weitgtST+"']/ancestor::div/div[@class='dish-bottom']/div[@class='handle-box']"));
    	waitForElementPresent(By.cssSelector(OrderLocator.skuSelectPop_Css));
    	selectSkuByRandom(By.cssSelector(OrderLocator.skuSelection_Css));
    	clickBtnW(By.xpath(OrderLocator.skuSelectConfirm_xpath));
    	waitForElementPresent(By.xpath(OrderLocator.weightPage_xpath));
    	inputByIndex(By.xpath(OrderLocator.timeDoubleInput_xpath), n);
    	clickBtnW(By.xpath(OrderLocator.weightConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.Search_Css));
    }
    
    public void timeWeightOrder(String xy,String timenamexy,String timename,String n) throws Exception{
    	Log.info("Start time order!");
    	//��ͨʱ��
    	clickBtnByTp(xy);
    	clickBtnByTp(timenamexy);
    	//clickBtnW(By.xpath("//div[text()='"+timename+"']/ancestor::div/div[@class='dish-bottom']/div[@class='handle-box']"));
    	waitForElementPresent(By.xpath(OrderLocator.timePage_xpath));
    	inputByIndex(By.xpath(OrderLocator.timeDoubleInput_xpath), n);
    	clickBtnW(By.xpath(OrderLocator.timeConfirm_xpath));
    	WebElement e = waitForElementPresent(By.xpath("//div[text()='"+timename+"']//ancestor::div//div[@class='handle-value']/span"));
    	int number = Integer.parseInt(e.getText());
    	price1 = Integer.parseInt(n.substring(0, n.indexOf(",")));
    	price1 *= number;
    }
    
    public void setOrderOne(String xy,String setnamexy,String setname) throws Exception{
    	Log.info("Start set one order!");
    	//��Ŀ���ײ�
    	clickBtnByTp(xy);
    	clickBtnByTp(setnamexy);
    	//clickBtnW(By.xpath("//div[text()='"+setname+"']/ancestor::div/div[@class='dish-bottom']/div[@class='handle-box']"));
    	waitForElementPresent(By.xpath(OrderLocator.setPage_xpath));
    	clickBtnByTp("512,350");
    	setselect = waitForElementPresent(By.xpath(OrderLocator.setSelected_xpath)).getText();
    	clickBtnW(By.xpath(OrderLocator.setConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.Search_Css));
    	getPriceSP(setname);
    	/*WebElement e = waitForElementPresent(By.xpath("//div[text()='"+setname+"']//ancestor::div//div[@class='handle-value']/span"));
    	int number = Integer.parseInt(e.getText());
    	String price = waitForElementPresent(By.xpath("//div[text()='"+setname+"']/ancestor::div/div[@class='dish-bottom']/div[@class='price']/div")).getText();
    	price = price.substring(1,price.indexOf("."));
    	price1 = Integer.parseInt(price);
    	price1 *= number;*/
    }
    
    public void setOrderTwo(String xy,String setnamexy,String setname) throws Exception{
    	Log.info("Start set two order!");
    	//��Ŀ���ײ�2
    	clickBtnByTp(xy);
    	swipeToDown();
    	clickBtnByTp(setnamexy);
    	//clickBtnW(By.xpath("//div[text()='"+setname+"']/ancestor::div/div[@class='dish-bottom']/div[@class='handle-box']"));
    	waitForElementPresent(By.xpath(OrderLocator.setPage_xpath));
    	clickBtnByTp("512,350");
    	clickBtnByTp("512,667");
    	setselected = findElements(By.xpath(OrderLocator.setSelected_xpath));
    	for(int i=0;i<setselected.size();i++){
    		System.out.println(setselected.get(i).getText());
    		setselects[i] = setselected.get(i).getText();
    	}  
    	clickBtnW(By.xpath(OrderLocator.setConfirm_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.Search_Css));
    	getPriceSP(setname);
    	/*WebElement e = waitForElementPresent(By.xpath("//div[text()='"+setname+"']//ancestor::div//div[@class='handle-value']/span"));
    	int number = Integer.parseInt(e.getText());
    	String price = waitForElementPresent(By.xpath("//div[text()='"+setname+"']/ancestor::div/div[@class='dish-bottom']/div[@class='price']/div")).getText();
    	price = price.substring(1,price.indexOf("."));
    	price1 = Integer.parseInt(price);
    	price1 *= number;*/
    }   
    
    public List<String> getFoodName() throws Exception{
    	List<String> foodnames = new ArrayList<String>();
    	List<AndroidElement> foodNames = driver.findElements(By.xpath(OrderLocator.dishName_xpath));
    	for(int i=0;i<foodNames.size();i++){
    		String name = foodNames.get(i).getText();
    		foodnames.add(i,name);
    	}   	
		return foodnames;	
    }
    
    public boolean getFoodSelect(String skuname) throws Exception{
    	Boolean flag =false; 
    	String chooseNames = waitForElementPresent(By.xpath("//p[text()='"+skuname+"']/ancestor::div/p[@class='choose_name']")).getText();
    	String choosenames = chooseNames.substring(chooseNames.indexOf("(")+1, chooseNames.indexOf(")"));
		String[] choosename = choosenames.split("��");
		if(foodselections.size()!=choosename.length){
		   Log.error("Sku selections number is wrong!");
		   return flag;
		}else{
			for(int j=0;j<choosename.length;j++){
				if(foodselections.contains(choosename[j])){
					flag = true;
				}else{
					flag = false;
					break;
				}
		    }			
		}
		return flag;	
    }
    
    public boolean getDoubleUnit(String skuname) throws Exception{
    	
    	WebElement e = waitForElementPresent(By.xpath("//p[text()='"+skuname+"']/ancestor::div/div[@class='dish-num']"));
    	String DoubleUnit = e.getText().substring(1, e.getText().length());
    	String firstUnit = DoubleUnit.substring(0, DoubleUnit.indexOf("/"));
    	String secondUnit = DoubleUnit.substring(DoubleUnit.indexOf("/")+1, DoubleUnit.length());
    	if(units.contains(firstUnit)&&units.contains(secondUnit)){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public boolean getFoodPrice(String skuname) throws Exception{
    	//String price1 = waitForElementPresent(By.cssSelector(OrderLocator.skuPrice_Css)).getText();
    	String price = waitForElementPresent(By.xpath("//p[text()='"+skuname+"']/ancestor::div/div[@class='dish-price']")).getText();
    	int price2 = Integer.parseInt(price.substring(price.indexOf("��")+1, price.indexOf(".")));
    	if(price1 == price2){
    		return true;
    	}else{
    		return false;
    	}	
    }
    
    public boolean getFoodMethod(String skuname) throws Exception{
    	String method2 = waitForElementPresent(By.xpath("//p[text()='"+skuname+"']/ancestor::div//dl[@class='dish-item-tips']//span")).getText();
    	if(method1.equals(method2)){
    		return true;
    	}else{
    		return false;
    	}		
    }
    
    public List<String> getSetSelect(String setname) throws Exception{
    	List<String> setselections = new ArrayList<>();
    	List<AndroidElement> setselection = findElements(By.xpath("//p[text()='"+setname+"']/ancestor::li/div[@class='combo']//span[@class='sub-item-name']"));
    	for(int i=0;i<setselection.size();i++){
    		String name = setselection.get(i).getText();
    		setselections.add(i,name);
    	}   	
		return setselections;    	
    }
    
    public boolean getSetTwo(String setname) throws Exception{
    	Boolean flag =false; 
    	List<String> setSelects = getSetSelect(setname);
    	for(int i=0;i<setSelects.size();i++){
    		if(setSelects.contains(setselects[i])){
				flag = true;
			}else{
				break;
			}   		
    	} 	
		return flag;   	
    }
    
    public void makeOrder() throws Exception{
    	//�µ�
    	clickBtn(By.xpath(OrderLocator.confirmOrder_xpath));
    	clickBtn(By.xpath(OrderLocator.placeOrder_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.orderSuc_Css));
    } 
    
    public void checkOutByCash() throws Exception{
    	Log.info("Start to check out by cash.");
    	//����
    	clickBtnW(By.cssSelector(OrderLocator.orderBill_Css));
    	waitForElementPresent(By.xpath(OrderLocator.checkPage_xpath));
    	clickBtn(By.xpath(OrderLocator.more_xpath));
    	clickBtnW(By.xpath(OrderLocator.cash_xpath));
    	//clickBtn(By.xpath(OrderLocator.pay_xpath));
    	clickBtnByTp(GetTestProperties.getPay());
    }
    
    public void checkOutByCard() throws Exception{
    	Log.info("Start to check out by card.");
    	//����
    	clickBtn(By.cssSelector(OrderLocator.orderBill_Css));
    	waitForElementPresent(By.xpath(OrderLocator.checkPage_xpath));
    	clickBtn(By.xpath(OrderLocator.more_xpath));
    	clickBtnW(By.xpath(OrderLocator.card_xpath));
    	//clickBtn(By.xpath(OrderLocator.pay_xpath));
    	clickBtnByTp(GetTestProperties.getPay());
    }
    
    public void reCheck(String xy) throws Exception{
    	Log.info("Start to recheck.");
    	clickBtn(By.xpath(OrderLocator.Bill_xpath));
    	clickBtnByTp(xy);
    	clickBtn(By.xpath(OrderLocator.reCheck_xpath));
    	selectReason(By.cssSelector(OrderLocator.reCheckReason_Css));
    	clickBtnW(By.xpath(OrderLocator.reCheckCon_xpath));
    	clickBtn(By.xpath(OrderLocator.more_xpath));
    	clickBtnW(By.xpath(OrderLocator.card_xpath));
    	clickBtnByTp(GetTestProperties.getPay());
    }	
    
    public void goDiscount() throws Exception{
    	Log.info("Start to select discount.");
    	clickBtnW(By.cssSelector(OrderLocator.discountMore_Css));
		clickBtnW(By.xpath(OrderLocator.discount_xpath));
		waitForElementPresent(By.cssSelector(OrderLocator.discountselect_Css));
		clickBtnByTp(GetTestProperties.getDisSelect());
		selectedDiscount = waitForElementPresent(By.cssSelector(OrderLocator.discountselected_Css)).getText();
		clickBtnByTp(GetTestProperties.getDisConfirm());
    }
    
    public void goRebate() throws Exception{
    	Log.info("Start to select rebate.");
    	clickBtnW(By.cssSelector(OrderLocator.discountMore_Css));
		clickBtnW(By.xpath(OrderLocator.rebate_xpath));
		selectReason(By.cssSelector(OrderLocator.rebatetselect_Css));
		String MaxPrice = waitForElementPresent(By.cssSelector(OrderLocator.rebateMax_Css)).getText();
		int discountMax = Integer.parseInt(MaxPrice.substring(MaxPrice.indexOf("��")+1, MaxPrice.length()));
		inputText(By.id(OrderLocator.rebateInput_Id), Integer.toString((new Random()).nextInt(discountMax)));
		clickBtnByTp(GetTestProperties.getConfirm());
    }
    
    public boolean discountPrice() throws Exception{
    	String sum = waitForElementPresent(By.cssSelector(OrderLocator.checkAll_Css)).getText();
    	double sumprice = Double.parseDouble(sum.substring(sum.indexOf("��")+1, sum.length()));
    	String price1 = waitForElementPresent(By.xpath("//p[text()='"+selectedDiscount+"']//ancestor::div[@class='weui-cell']//div[@class='weui-cell__ft']")).getText();
    	double discountprice = Double.parseDouble(price1.substring(price1.indexOf("��")+1, price1.length()));
    	String price2 = waitForElementPresent(By.xpath("//p[text()='"+GetTestProperties.getRebate()+"']//ancestor::div[@class='weui-cell']//div[@class='weui-cell__ft']")).getText();
    	double rebateprice = Double.parseDouble(price2.substring(price2.indexOf("��")+1, price2.length()));
    	String price3 = waitForElementPresent(By.cssSelector(OrderLocator.checkEnd_Css)).getText();
    	double payprice = Double.parseDouble(price3.substring(price3.indexOf("��")+1, price3.length()));
    	if(sumprice == discountprice+rebateprice+payprice){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public void editWeight() throws Exception{
    	clickBtnW(By.xpath(OrderLocator.changeWeight_xpath));
    	newnumber = Integer.toString((new Random()).nextInt(100));
    	inputText(By.id(OrderLocator.weightInput_Id), newnumber);
    	clickBtnByTp(GetTestProperties.getConfirm());
    }
    
    public void addFoodNote() throws Exception{
    	clickBtnW(By.xpath(OrderLocator.foodNote_xpath));
		waitForElementPresent(By.cssSelector(OrderLocator.notePage_Css));
		clickBtnByTp(GetTestProperties.getFoodNote1());
		clickBtnByTp(GetTestProperties.getFoodNote2());
		List<AndroidElement> notes = findElements(By.cssSelector(OrderLocator.noteSelected_Css));
		noteList = new String[notes.size()];
		for(int i=0;i<notes.size();i++){			
    		noteList[i] = notes.get(i).getText();
    	} 
		clickBtnW(By.xpath(OrderLocator.noteConfirm_xpath));		
    }
    
    public boolean getNote(String noteType) throws Exception{	
    	Boolean flag = false;
    	List<AndroidElement> e = findElements(By.cssSelector(noteType));
    	for(int i=0;i<e.size();i++){
    	  String note = e.get(i).getText();
    	  if(note.contains(",")){
    		note = note.substring(0, note.length()-1);
    	  }
    	noteSelection.add(i,note);
    	}
    	if(noteList.length == noteSelection.size()){
    		for(int j=0;j<noteSelection.size();j++){
    			//String t = noteList[j];
    			if(noteSelection.contains(noteList[j])){
    				flag = true;
    			}else{
    				flag = false;
    				break;
    			}
    		}
    	}else{
    		Log.error("Note information is wrong!");
    	}
		return flag;
    }
    
    public void addAllNote() throws Exception{
    	clickBtnW(By.cssSelector(OrderLocator.rightMenu_Css));
    	clickBtnW(By.xpath(OrderLocator.allNote_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.notePage_Css));
    	clickBtnByTp(GetTestProperties.getFoodNote1());
		clickBtnByTp(GetTestProperties.getFoodNote2());
		List<AndroidElement> notes = findElements(By.cssSelector(OrderLocator.noteSelected_Css));
		noteList = new String[notes.size()];
		for(int i=0;i<notes.size();i++){			
    		noteList[i] = notes.get(i).getText();
    	} 
		clickBtnW(By.xpath(OrderLocator.noteConfirm_xpath));
    }
    
    public void goCancelBill() throws Exception{
    	clickBtnW(By.cssSelector(OrderLocator.rightMenu_Css));
    	clickBtnW(By.xpath(OrderLocator.cancelBill_xpath));
    	waitForElementPresent(By.cssSelector(OrderLocator.cancelPage_Css));
    	selectReason(By.cssSelector(OrderLocator.cancelReanson_Css));
    	clickBtnW(By.xpath(OrderLocator.cancelConfirm_xpath));
    }

}
