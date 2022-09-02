package com.pom.TaraMerchant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pom.TaraMerchant.pages.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class OrderMgt_Page extends BasePage {
	
	 @FindBy(xpath="//android.widget.ImageView[@content-desc=\"Orders\"]")
	    public WebElement Orders_menu;
	 
	 @FindBy(xpath="//android.widget.Button[@index='10']")
	    public WebElement DeclineOrder;
	 
	 @FindBy(xpath="//android.widget.Button[@index='11']")
	    public WebElement ConfirmOrder;
	
	 @FindBy(xpath="//android.widget.Button[@index='10']")
	    public WebElement Deliver;
	 
	 @FindBy(xpath="//android.view.View[@index='2']")
	    public WebElement Inprogress;
	 
	 @FindBy(xpath="//android.view.View[@index='3']")
	    public WebElement Completed;
			   
	public OrderMgt_Page(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
	 super(aDriver,test);
	}
	
	
public void Confirm_Order(String productToConfirm) throws InterruptedException {
	    
	    String xpathofele="//android.widget.ImageView[contains(@content-desc,"+productToConfirm+")]";
	    WebElement productToConfirmele=aDriver.findElementByXPath(xpathofele);
		waitForElementforClick(productToConfirmele, 20);
		test.log(LogStatus.INFO, "Confirmed the order");

		Thread.sleep(2000);
		waitForElementforClick(ConfirmOrder, 20);
		
		   Thread.sleep(3000);

		   waitForElementforClick(Inprogress, 20);
		   Thread.sleep(2000);

		  String xpathofele1="//android.widget.ImageView[contains(@content-desc,"+productToConfirm+")]";
		   WebElement productToDeliverele=aDriver.findElementByXPath(xpathofele1);
		   
		   if (isElementDisplayed(productToDeliverele))
			   reportPass("Confirmed the Order, inprogress");
		   else
			   reportFail("Order is not inprogress");
	
		Thread.sleep(5000);
	//	aDriver.navigate().back();
	}
	
	
	public void Decline_Order(String productToDecline) throws InterruptedException {
		
		String xpathofele="//android.widget.ImageView[contains(@content-desc,"+productToDecline+")]";
		WebElement productToDeclineele=aDriver.findElementByXPath(xpathofele);
		waitForElementforClick(productToDeclineele, 20);
		Thread.sleep(2000);
		waitForElementforClick(DeclineOrder, 20);
		Thread.sleep(2000);
		if(isElementDisplayed(productToDeclineele)) 
			reportPass("order is declined");
		else
			reportFail("Order is not declined");
		
		aDriver.navigate().back();
	}
	
public void Deliver_Order(String productToDeliver) throws InterruptedException {
		
	   
	   waitForElementforClick(Inprogress, 20);
	   Thread.sleep(2000);

	  String xpathofele="//android.widget.ImageView[contains(@content-desc,"+productToDeliver+")]";
	   WebElement productToDeliverele=aDriver.findElementByXPath(xpathofele);
	 

	   waitForElementforClick(productToDeliverele, 20);
		Thread.sleep(2000);
		waitForElementforClick(Deliver, 20);
		Thread.sleep(5000);
		waitForElementforClick(Completed, 20);
		String validation=aDriver.getPageSource();
		if((validation.contains("Shyam")) && (validation.contains("ProductTestStatus"))) 
			reportPass("Order is Delivered , In Completed status");
		else
			reportFail("Order is not moved to Completed status");

		}
		
	}
	
	
	
