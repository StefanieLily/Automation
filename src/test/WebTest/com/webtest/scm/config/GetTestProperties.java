package com.webtest.scm.config;

public class GetTestProperties {
	static TestConfig tc=new TestConfig("src/config2.properties");
	
	public static String getURL(){
		String abc=tc.getValue("url");
		return abc;
	}
	
	public static String getBroswser(){
		String abc=tc.getValue("browser");
		return abc;
	}
	
	public static String getUsername(){
		String abc=tc.getValue("username");
		return abc;
	}
	
	public static String getPassword(){
		String abc=tc.getValue("password");
		return abc;
	}
	
	public static String getStorename() {
		String abc=tc.getValue("storename");
		return abc;
	}
	
	public static String getChainUrl() {
		String abc=tc.getValue("chainurl");
		return abc;
	}
	
	public static String getStallName() {
		String abc=tc.getValue("stallname");
		return abc;
	}
	
	public static String getGoodsNumber() {
		String abc=tc.getValue("goodsNumber");
		return abc;
	}
	
	public static String getDeliveryDate() {
		String abc=tc.getValue("deliveryDate");
		return abc;
	}
	
	public static String getDispatchName() {
		String abc=tc.getValue("dispatchName");
		return abc;
	}
	
	public static String getAcceptNumber() {
		String abc=tc.getValue("acceptNumber");
		return abc;
	}
	
	public static String getStatusB() {
		String abc=tc.getValue("statusB");
		return abc;
	}
	
	public static String getStatusA() {
		String abc=tc.getValue("statusA");
		return abc;
	}
	
	public static String getStatusY() {
		String abc=tc.getValue("statusY");
		return abc;
	}

}