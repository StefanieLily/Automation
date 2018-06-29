package com.apptest.v1.common;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.apptest.v1.config.Log;


public class Common {
    public static AndroidDriver<AndroidElement> driver;
    public static WebElement FoundElement;
    public static List<AndroidElement> FoundElements;
    
	@BeforeTest
	public void setup() throws Exception{
    
	DesiredCapabilities capabilities = new DesiredCapabilities();
	//capabilities.setCapability(CapabilityType.BROWSER_NAME, "");// ��䲻�Ǳ����
	capabilities.setCapability("deviceName", "Android Emulator");
	capabilities.setCapability("platformVersion", "5.1");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("appPackage", "com.choicesoft.mobile.ipos");
	capabilities.setCapability("appActivity", ".activity.MainActivity");
	/*capabilities.setCapability("noReset", "True");
	capabilities.setCapability("noSign","true");
	capabilities.setCapability("nativeWebTap", true);*/
	driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(5000);
	switchWebView();
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() throws Exception {		
	    driver.quit();
	}
	
	
	public void switchWebView(){
		Set<String> contextSet = driver.getContextHandles();
		for(String context : contextSet){
		    //System.out.println("ҳ���ϵ�context����Ϊ��" + context);
		    if(context.contains("WEBVIEW")){
		        driver.context(context);
		        System.out.println("Switch sucessfully!");
		        break;
		    }
		}
		//System.out.println("ҳ������Ϊ��" + driver.getPageSource());
	}
	
	
	public void failAndScreenshot(Exception e) throws Exception {
		
			String contextName = driver.getContext();
			driver.context("NATIVE_APP");
			File screenShot = driver.getScreenshotAs(OutputType.FILE);
			driver.context(contextName);
			FileUtils.copyFile(screenShot, new File("img\\Screenshot.png"));
			e.printStackTrace();
			throw e;
	}
	
	public WebElement waitForElementPresent(By by) throws Exception{
		
		//(new WebDriverWait(driver,20)).until(ExpectedConditions.presenceOfElementLocated(by));
		try{
			Thread.sleep(5000);
			FoundElement = driver.findElement(by);
			if(FoundElement != null){
				Log.info("The element is found!");
				return FoundElement;
			}
		}catch(Exception e){
			    Log.error("Element no find!");
			    throw new Exception(e);
			}
		return FoundElement;
	}	
	
	public void findElement(By by) throws Exception{
		try{
			Thread.sleep(5000);
			FoundElement = driver.findElement(by);
			if(FoundElement != null){
				Log.info("The element is found!");
			}
		}catch(Exception e){
			    Log.error("Element no find!");
			    throw new Exception(e);
			}
	}
	
    public List<AndroidElement> findElements(By by) throws Exception{
    	try{
			Thread.sleep(5000);
			FoundElements = driver.findElements(by);
			if(FoundElement != null){
				Log.info("The elements are found!");
				return FoundElements;
			}
		}catch(Exception e){
			    Log.error("Elements no find!");
			    throw new Exception(e);
			}
    	return FoundElements;
	}

	public boolean elementExist(By by) throws Exception{
		Boolean flag = false;
		try{
			Thread.sleep(2000);
			WebElement e = driver.findElement(by);
			if(e != null){
				Log.info("The element is exist!");
				flag = true;
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;	
	}
	
	public boolean elementNotExist(By by) throws Exception{
		Boolean flag = false;
		try{
			WebElement e = driver.findElement(by);
			if(!e.isDisplayed()){
				Log.info("The element is not exist!");
				flag = true;
				return flag;
			}
		}catch(NoSuchElementException e){
			return flag;
		}
		return flag;	
	}
	
	
	public void inputText(By by, String text) throws Exception{
		waitForElementPresent(by);
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(text);
	}
	
	public void clickBtn(By by) throws Exception{	
		String contextName = driver.getContext();
		driver.context("NATIVE_APP");
		waitForElementPresent(by);
		driver.findElement(by).click();	
		driver.context(contextName);
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.document.getElementById('weui-btn weui-btn_main').click()");
		js.executeScript("arguments[0].click();", FoundElement);*/
	}
	
	public void clickBtnW(By by) throws Exception{
		waitForElementPresent(by);
		driver.findElement(by).click();			
	}
	
	public void clickBtnByTp(String xy) throws Exception{
		String[] num = xy.split(",");
		int x = Integer.parseInt(num[0]);
		int y = Integer.parseInt(num[1]);
		String contextName = driver.getContext();
		driver.context("NATIVE_APP");
		TouchAction action = new TouchAction(driver);
		action.tap(x,y).perform();
		driver.context(contextName);
	}
	
	public void implicitWait(long i) throws InterruptedException{
		/*AppiumFieldDecorator decorator = new AppiumFieldDecorator(driver);
		decorator.DEFAULT_IMPLICITLY_WAIT_TIMEOUT = i;
		decorator.DEFAULT_TIMEUNIT = TimeUnit.SECONDS;*/
		//PageFactory.initElements(new AppiumFieldDecorator(driver, i, TimeUnit.SECONDS), this);
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}
		
	public void inputByIndex(By by,String text) throws Exception{
		List<AndroidElement> inputBoxes = driver.findElements(by);
		String[] inputText = text.split(",");
		for(int i=0;i<inputBoxes.size();i++){
			inputBoxes.get(i).click();
			inputBoxes.get(i).sendKeys(inputText[i]);
		}    
	}
	
	public void swipeToDown() throws Exception {
		String contextName = driver.getContext();
		driver.context("NATIVE_APP");
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, 100);
        Thread.sleep(2000);
        driver.context(contextName);
    }
	
	public List<String> stringConnect(List<String> a,String b) throws Exception{
		List<String> doubleunits = new ArrayList<String>();
		String[] c = b.split(",");
		for(int i=0;i<a.size();i++){
			doubleunits.add(i,c[i]+a.get(i));	
		}
		return doubleunits;
	}	
	
}
