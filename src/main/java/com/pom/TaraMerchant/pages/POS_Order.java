package com.pom.TaraMerchant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pom.TaraMerchant.pages.base.BasePage;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class POS_Order extends BasePage{
	

	@FindBy(xpath="//android.widget.ImageView[@content-desc='POS']")
    public WebElement POS;  
	
	@FindBy(xpath="(//android.widget.ImageView)[3]")
    public WebElement Increment;  
	
	@FindBy(xpath="(//android.widget.Button)[2]")
    public WebElement Cart;  
	
	@FindBy(xpath="(//android.widget.EditText)[1]")
    public WebElement Mobile_NO;  
	
	@FindBy(xpath="(//android.widget.EditText)[2]")
    public WebElement customer_Name; 
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc='Cash']")
    public WebElement Pay_cash; 
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc='Generate Payment Link']")
    public WebElement GeneratePaymentLink; 
		
	@FindBy(xpath="(//android.widget.EditText)[1]")
    public WebElement SearchText; 
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc='Home']")
    public WebElement Homebtn; 
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc='Continue']")
    public WebElement continuebtn; 
	
	@FindBy(id="Order Placed Successfully!")
    public WebElement Confmessage; 
	
	
	public POS_Order(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
		 super(aDriver,test);
		   
		}
	public void SearchProduct(String product) throws InterruptedException
	{
	Thread.sleep(3000);	
	waitForElementforClick(POS, 30);
	test.log(LogStatus.INFO, "Clicking On POS");
	System.out.println("Searching Product");
	test.log(LogStatus.INFO,"Searching for the Product");
	Thread.sleep(2000);
	typeText(SearchText,product);
	aDriver.hideKeyboard();
	if(aDriver.getPageSource().contains(product))
	{
	reportPass("search Product Successfully");}
	else{
	reportFail("Found search Product error.");
	}
	}
	
	public void OrderThroughPos_cash() throws InterruptedException
	{
		
		
		waitForElementforClick(Increment, 30);
		
		test.log(LogStatus.INFO, "Increment No of Quantity");
		
		waitForElementforClick(Cart, 20);
		test.log(LogStatus.INFO, "Click On Cart Icon");
		
		waitForElementforClick(Mobile_NO, 20);
		test.log(LogStatus.INFO, "Enter Mobile Number");
		typeText(Mobile_NO, "9885500017");
		
		waitForElementforClick(customer_Name, 20);
		test.log(LogStatus.INFO, "Enter Customer Name");
		typeText(customer_Name, "Shyam");
		
		waitForElementforClick(continuebtn, 20);
		test.log(LogStatus.INFO, "Click on Continue Button");
		Thread.sleep(6000);
		waitForElementforClick(Pay_cash, 20);
		test.log(LogStatus.INFO, "Select Pay With Cash Option");
		Thread.sleep(5000);
		
		String confirmsource=aDriver.getPageSource();
	  

		Thread.sleep(1000);

		 if(!confirmsource.toLowerCase().contains("Successfully".toLowerCase()))
		{
			reportFail("Order Creation Failed!");
									
		}
		else
		{
			reportPass("Order Placed Successfully with cash!");
		}
		
		waitForElementforClick(Homebtn, 30);
				
	}
	
	public void OrderThroughPosexceedlimit() throws InterruptedException
	{
		
		
		waitForElementforClick(Increment, 20);
		Thread.sleep(2000);
		waitForElementforClick(Increment, 20);

		test.log(LogStatus.INFO, "Increment No of Quantity");
		waitForElementforClick(Cart, 20);
		test.log(LogStatus.INFO, "Click On Cart Icon");
		
		waitForElementforClick(Mobile_NO, 20);
		test.log(LogStatus.INFO, "Enter Mobile Number");
		typeText(Mobile_NO, "9885500017");
		
		waitForElementforClick(customer_Name, 20);
		test.log(LogStatus.INFO, "Enter Customer Name");
		typeText(customer_Name, "Nan");
		
		waitForElementforClick(continuebtn, 20);
		test.log(LogStatus.INFO, "Click on Continue Button");
		Thread.sleep(6000);
		waitForElementforClick(Pay_cash, 20);
		test.log(LogStatus.INFO, "Select Pay With Cash Option");
		String toastmessage=captureToastmessage();
		if(toastmessage.toLowerCase().contains("not in stock".toLowerCase())) 
		{
			reportPass(toastmessage);
		   takeScreenshot(); }
		else {
			reportFail("should display error message.");
		    aDriver.navigate().back(); }
		}		
		
	
	public void OrderThroughPos_Link() throws InterruptedException
	{
		

		waitForElementforClick(Increment, 30);
		
		test.log(LogStatus.INFO, "Increment No of Quantity");
		
		waitForElementforClick(Cart, 20);
		test.log(LogStatus.INFO, "Click On Cart Icon");
		
		waitForElementforClick(Mobile_NO, 20);
		test.log(LogStatus.INFO, "Enter Mobile Number");
		typeText(Mobile_NO, "9885500017");
		
		waitForElementforClick(customer_Name, 20);
		test.log(LogStatus.INFO, "Enter Customer Name");
		typeText(customer_Name, "Syam");
		
		waitForElementforClick(continuebtn, 20);
		test.log(LogStatus.INFO, "Click on Continue Button");
		Thread.sleep(7000);
		waitForElementforClick(GeneratePaymentLink, 20);
		test.log(LogStatus.INFO, "Select Pay With Generate Payment Link Option");
		Thread.sleep(5000);
		
		String confirmsource=aDriver.getPageSource();
	  

		Thread.sleep(1000);

		 if(!confirmsource.toLowerCase().contains("Payment link".toLowerCase()))
		{
			reportFail("Generate link is Failed!");
									
		}
		else
		{
			reportPass("Generated link Successfully!");
		}
		
		waitForElementforClick(Homebtn, 20);
				
	}
	}	
	
	
	


