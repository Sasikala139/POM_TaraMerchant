package com.pom.TaraMerchant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pom.TaraMerchant.pages.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Dashboard_Page extends BasePage {
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Today\"]")
    public WebElement Filter_Today; 
    
	@FindBy(xpath="//android.view.View[@content-desc=\"Week\"]")
    public WebElement Filter_Week; 
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Month\"]")
    public WebElement Filter_Month; 	
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Custom\"]")
    public WebElement Filter_Custom;
	
	@FindBy(xpath="//android.view.View[contains(@content-desc,'Inflow')]")
    public WebElement InFLow; 
    
	@FindBy(xpath="//android.view.View[contains(@content-desc,'Outflow')]")
    public WebElement OutFlow; 
	
	@FindBy(xpath="//android.view.View[contains(@content-desc,'Orders')]")
    public WebElement Orders; 	
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Top 5 inventory items\"]")
    public WebElement Top5InventoryItems;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Top 5 customers\"]")
    public WebElement Top5Customers;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Top Voucher\"]")
    public WebElement TopVouchers;
	
	@FindBy(xpath= "//android.view.View[@content-desc=\"Payment Modes\"]")
    public WebElement PaymentModes;
	
	@FindBy(xpath="//android.view.View[contains(@content-desc,'Sales')]")
    public WebElement Sales;
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Transaction\"]")
    public WebElement Transaction_Menu;
	 
    public Dashboard_Page (AndroidDriver<AndroidElement> aDriver, ExtentTest test){
         super(aDriver,test);
           
        }
	
    public void Top5InventoryItems() throws InterruptedException {
        
    	waitForElementforClick(Transaction_Menu, 20);
        Thread.sleep(6000);
        waitForElementforClick(Top5InventoryItems, 20);
        Thread.sleep(3000);
        WebElement validation=aDriver.findElementByAccessibilityId("Top 5 inventory items");
        if(isElementDisplayed(validation)) {
          reportPass("Top 5 inventory items displayed");
        }
        else {
            reportFail("Top 5 inventory items  not displayed");

        }
        
        aDriver.navigate().back();
    }
    
    public void Top5Customers() throws InterruptedException {
     
    	//waitForElementforClick(Transaction_Menu, 20);
        Thread.sleep(2000);
        waitForElementforClick(Top5Customers, 20);
        Thread.sleep(3000);
        WebElement validation=aDriver.findElementByAccessibilityId("Top 5 customers");
        if(isElementDisplayed(validation)) {
          reportPass("Top 5 customers displayed");
        }
        else {
        	reportFail("Top 5 customers not displayed");

        }
        
        aDriver.navigate().back();    
    	
    	
    }
 public void TopVouchers() throws InterruptedException {
    	
	//waitForElementforClick(Transaction_Menu, 20);
     Thread.sleep(2000);
     waitForElementforClick(TopVouchers, 20);
     Thread.sleep(3000);
     WebElement validation=aDriver.findElementByAccessibilityId("Voucher applied");
     if(isElementDisplayed(validation)) {
       reportPass("Top Vourchers displayed");
     }
     else {
    	 reportFail("Top vouchers not displayed");
     }
     
     aDriver.navigate().back();  
  }
 
 public void PaymentModes() throws InterruptedException {
	//waitForElementforClick(Transaction_Menu, 20);
     Thread.sleep(2000);
     waitForElementforClick(PaymentModes, 20);
     Thread.sleep(3000);
     WebElement validation=aDriver.findElementByAccessibilityId("Payment Modes");
     if(isElementDisplayed(validation)) {
       reportPass("Payment Modes displayed");
     }
     else {
    	 reportFail("Payment Modes not displayed");

     }
       aDriver.navigate().back();  
	 }
 
 public void Sales() {
	 	
 }
 
 public void inflow() throws InterruptedException {
	 Thread.sleep(2000);
	 waitForElementforClick(InFLow, 20);
     waitForElementforClick(Filter_Week, 20);

     Thread.sleep(3000);
     WebElement validation=aDriver.findElementByAccessibilityId("Inflow");
     if(isElementDisplayed(validation)) {
       reportPass("Inflow displayed");
     }
     else {
    	 reportFail("InflowPayment Modes not displayed");

     }
       aDriver.navigate().back();  	
	 
	 
 }
 public void OutFlow() throws InterruptedException{
	 Thread.sleep(2000);
	 
     waitForElementforClick(OutFlow, 20);
     waitForElementforClick(Filter_Week, 20);

     Thread.sleep(3000);
     WebElement validation=aDriver.findElementByAccessibilityId("Outflow");
     if(isElementDisplayed(validation)) {
       reportPass("Outflow displayed");
     }
     else {
    	 reportFail("Outflow not displayed");

     }
       aDriver.navigate().back();  	
 }
 public void Orders() {
	 	
	 
	 
 }
 
 public void Today_Orders() {
	 
	 
	 	
 }
 
 public void week_Orders() {
	 
	 
	 	
 }
 
 
    
    
    
    
 }


