package com.webtest.scm.common;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.webtest.scm.cases.LoginCase;
import com.webtest.scm.config.GetTestProperties;
import com.webtest.scm.config.Log;

public class Common {
	public static WebDriver driver;
	public static WebElement FoundElement;
	public static final int TimeOut = 6000;
	public StopWatch Time = new StopWatch();
	
	@BeforeTest
	public void beforeTest() throws Exception {
		LoginCase login = new LoginCase();
		login.loginCase();
	}
	
	@AfterTest
	public void quitBrowser() {		
		driver.quit();
	}
	
	public void OpenBrowser(String browser) {		
		if(browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
						
		}else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
				
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.firefox.bin", "C:\\Driver\\geckodriver64.exe");
			driver = new FirefoxDriver();		
			
		}else {
			Log.error("Browser name is wrong!");
		}
	}
		
	public void goToURL() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		driver.get(GetTestProperties.getURL());
	}
	
	public Boolean elementExist(By locator) throws Exception {
		Boolean flag = true;
		Time.start();
		try {	
			while(true) {			
				FoundElement = driver.findElement(locator);
				if(FoundElement.isDisplayed()) {
					Log.info("The elment " + FoundElement.getText() + " is exist!");	
					break;
				}
				
				if(Time.getTime() > TimeOut) {
					flag = false;
					Log.error("Element no find in TimeOut!");
					break;
				}
			}					
		}catch (Exception e) {
			Time.reset();
			throw new Exception(e);
		}
		Time.reset();
		return flag;												
	}
	
	public WebElement waitForElementPresent(By locator) throws Exception {
		Time.start();
		try {	
			while(true) {
				Thread.sleep(1000);
				FoundElement = driver.findElement(locator);
				if(FoundElement.isDisplayed()) {
					Log.info("The elment " + FoundElement.getText() + " is present!");	
					break;
				}	
				
				
				if(Time.getTime() > TimeOut) {
					Log.error("Wait for Element failed!");
					break;
				}
			}
			
		}catch (Exception e) {
			Log.error("Wait for Element error!");
			Time.reset();
		    throw new Exception(e);
		}
		Time.reset();
		return FoundElement;
	}
	

	public WebElement findElement(By locator) throws Exception {
		try {
			FoundElement = driver.findElement(locator);
			Log.info("The element is found!");
		}catch(Exception e) {
			 Log.error("Element no find!");
			throw new Exception(e);
		}
		return FoundElement;		 
	}
	
	public void click(By locator) throws Exception {
		 try {
			 findElement(locator).click();
		 }catch(Exception e) {
			 throw new Exception(e);
		 }
	}
	
	public void clickEnter() throws Exception {
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
		}catch(Exception e){
			throw new Exception(e);
		}	
	}
	
	public void clickByJS(WebElement element) throws Exception {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		}catch(Exception e) {
			throw new Exception(e);
		}
	}
	
	public void input(By locator,String input) throws Exception {
		try {
			findElement(locator).sendKeys(input);
		}catch(Exception e) {
			throw new Exception(e);
		}
	}
	
	public void failAndScreenshot(Exception e) throws Exception {
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("img\\Screenshot.png"));
		throw e;

	}	
}
