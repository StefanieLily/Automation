package com.apptest.v1.config;

public class GetTestProperties {
	static TestConfig tc=new TestConfig("src/config.properties");
	
	public static String getTestNumber(){
		String abc=tc.getValue("testnumber");
		return abc;
	}
	
	public static String getPrepareNumber(){

		String abc=tc.getValue("preparenumber");
		return abc;
	}
	
	public static String getOnlineNumber(){
		String abc=tc.getValue("onlinenumber");
		return abc;
	}
	
	public static String getPasswordB(){
		String abc=tc.getValue("passwordB");
		return abc;
	}
	
	public static String Logname(){
		return tc.getValue("logname");
	}
	
	public static String getPasswordL(){
		return tc.getValue("passwordL");
	}
	
	public static String getSyncIcon(){
		return tc.getValue("sync");
	}
	
	public static String getReleaseMes(){
		return tc.getValue("ReleaseM");
	}
	
	public static String getSkuP(){
		return tc.getValue("SkuP");
	}
	
	public static String getSkuZ(){
		return tc.getValue("SkuZ");
	}
	
	public static String getSkuS(){
		return tc.getValue("SkuS");
	}
	
	public static String getDW(){
		return tc.getValue("DW");
	}
	
	public static String getDT(){
		return tc.getValue("DT");
	}
	
	public static String getZP(){
		return tc.getValue("ZP");
	}
	
	public static String getZPxy(){
		return tc.getValue("ZPxy");
	}
	
	public static String getZSkuW(){
		return tc.getValue("ZSkuW");
	}
	
	public static String getWP(){
		return tc.getValue("WP");
	}
	
	public static String getWPxy(){
		return tc.getValue("WPxy");
	}
	
	public static String getTW(){
		return tc.getValue("TW");
	}
	
	public static String getTWxy(){
		return tc.getValue("TWxy");
	}
	
	public static String getSetOne(){
		return tc.getValue("SetOne");
	}
	
	public static String getSetOnexy(){
		return tc.getValue("SetOnexy");
	}
	
	public static String getSetTwo(){
		return tc.getValue("SetTwo");
	}
	
	public static String getSetTwoxy(){
		return tc.getValue("SetTwoxy");
	}
	
	public static String getConfirm(){
		return tc.getValue("Confirm");
	}
	
	public static String getPay(){
		return tc.getValue("Pay");
	}
	
	public static String getSku(){
		return tc.getValue("Sku");
	}
	
	public static String getDouble(){
		return tc.getValue("Double");
	}
	
	public static String getMethod(){
		return tc.getValue("Method");
	}
	
	public static String getWeight(){
		return tc.getValue("Weight");
	}
	
	public static String getTime(){
		return tc.getValue("Time");
	}
	
	public static String getSet(){
		return tc.getValue("Set");
	}
	
	public static String getRecheck(){
		return tc.getValue("Recheckfirst");
	}
	
	public static String getDisSelect(){
		return tc.getValue("discountselection");
	}
	
	public static String getDisConfirm(){
		return tc.getValue("discountConfirm");
	}
	
	public static String getRebate(){
		return tc.getValue("Rebate");
	}
	
	public static String getFoodNote1(){
		return tc.getValue("Foodnote1");
	}
	
	public static String getFoodNote2(){
		return tc.getValue("Foodnote2");
	}

}