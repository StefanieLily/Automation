package com.apptest.v1.common;

import org.testng.log4testng.Logger;

public class Log {

    public static Logger logger = Logger.getLogger(Log.class);
    public static void startTestCase(String sTestCaseName){

    	logger.info("---------------------------------------------------");
    	logger.info("----------   "+sTestCaseName+"    ----------------");
    }
    public static void endTestCase(String sTestCaseName){
    	logger.info("---------------------------------------------------");        
    	logger.info("----------------------------------------------------");
    }
    public static void info(String message){
    	logger.info(message);      
    }
    public static void warn(String message){
    	logger.warn(message);      
    }
    public static void error(String message){
    	logger.error(message);     
    }
    public static void fatal(String message){
    	logger.fatal(message);     
    }
    public static void debug(String message){
    	logger.debug(message);     
    }

}