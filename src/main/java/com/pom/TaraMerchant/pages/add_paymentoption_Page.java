package com.pom.TaraMerchant.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pom.TaraMerchant.pages.base.BasePage;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class add_paymentoption_Page extends BasePage {

	@FindBy(xpath="//android.widget.Button[@index='0']")
    public WebElement mngcalls_allow_button;
		
	@FindBy(xpath="//android.widget.Button[@index='1']")
    public WebElement mngcalls_Notallow_button;

	@FindBy(xpath="//android.widget.Button[@index='0']")
    public WebElement mngSMS_allow_button;
	
	@FindBy(xpath="//android.widget.Button[@index='1']")
    public WebElement mngSMS_Notallow_button;
	
	@FindBy(xpath="//android.widget.Button[@index='8']")
    public WebElement Verify_SMS_button;
	
	@FindBy(xpath="//android.widget.Button[@index='9']")
    public WebElement Cancel_verifySMS_button;
	
	@FindBy(xpath="//android.widget.Button[@index='1']")
    public WebElement sendsms_OK_Button;
	
	@FindBy(xpath="//android.widget.Button[@index='0']")
    public WebElement sendsms_Cancel_Button;
	
	@FindBy(xpath="//android.view.View[@index='3']")
	public WebElement Proceed_Button;
	
	@FindBy(xpath="//android.widget.Button[@index='1']")
    public WebElement addBankAccount_Button;
	
	@FindBy(xpath="//android.widget.ImageView[@index='8']")
    public WebElement profile_menu_button;
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Profile\"]")
    public WebElement profile_individual;
	
	
	//Bank Account elements
	
	@FindBy(xpath="//android.view.ViewGroup[@index='2']")
    public WebElement BankVicotia;
	
	@FindBy(xpath="//android.view.ViewGroup[@index='1']")
    public WebElement BankBTN;
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Switch To Seller Profile\"]")
    public WebElement SwitchToSeller;
	
	
	@FindBy(xpath="//android.view.ViewGroup[@index=''0]")
    public WebElement BankBRI;
	
	

	
	public add_paymentoption_Page(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
		 super(aDriver,test);
		   
		}
	
public void navigateToSwitchuser() throws InterruptedException {
		
	
	waitForElementforClick(Proceed_Button, 30);

		if(isElementDisplayed(mngcalls_allow_button))
		{	
		   System.out.println("in if block");
		   click(mngcalls_allow_button);
  	  	   click(mngSMS_allow_button);
		   System.out.println("clicked on calls allow");
		}

	    if(isElementDisplayed(Verify_SMS_button))
	    {
	    	waitForElementforClick(Verify_SMS_button, 20);
			Alert alert = aDriver.switchTo().alert(); 
		     alert.accept();
	    }

	}
		
	public void NavigatedTo_BankAccount() throws InterruptedException
	{
		
		test.log(LogStatus.INFO, "Navigating to add Payment OPtion ");
		Thread.sleep(10000);

//		if(isElementDisplayed(mngcalls_allow_button))
//		{	
//		   System.out.println("in if block");
//		   click(mngcalls_allow_button);
//  	  	   click(mngSMS_allow_button);
//		   System.out.println("clicked on calls allow");
//	
//		}
//
//	    if(isElementDisplayed(Verify_SMS_button))
//	    {
//		     waitForElement(Verify_SMS_button, 20);
//			Alert alert = aDriver.switchTo().alert(); 
//		     alert.accept();
//	    }
	    
		waitForElementforClick(Proceed_Button, 20);

		if(isElementDisplayed(mngcalls_allow_button))
		{	
		   System.out.println("in if block");
		   click(mngcalls_allow_button);
  	  	   click(mngSMS_allow_button);
		   System.out.println("clicked on calls allow");
	
		}

	    if(isElementDisplayed(Verify_SMS_button))
	    {
	    	waitForElementforClick(Verify_SMS_button, 20);
			Alert alert = aDriver.switchTo().alert(); 
		     alert.accept();
	    }
	    waitForElementforClick(addBankAccount_Button,20);
		
	}
	
	public void navigatetomerchantiflareadyuser() {
		if(isElementDisplayed(mngcalls_allow_button))
		{	
			click(mngcalls_allow_button);
  	  	click(mngSMS_allow_button);
		System.out.println("clicked on calls allow");
		}
	    if(isElementDisplayed(Verify_SMS_button))
		{	
		waitForElementforClick(Verify_SMS_button, 20);
		Alert alert = aDriver.switchTo().alert(); 
		alert.accept();
		}
		waitForElementforClick(profile_individual, 20);
        waitForElementforClick(SwitchToSeller, 20);
	}
	
	public void add_creditcard() throws InterruptedException
	{
	 
		waitForElementforClick(BankBTN,10);
		test.log(LogStatus.INFO, "Selected BankBTN ");

		Thread.sleep(3000);
		aDriver.findElementByAccessibilityId("app.tara.tara_app:id/tv_card_holder_name").sendKeys("John");
		aDriver.findElementByAccessibilityId("app.tara.tara_app:id/et_card_number").sendKeys("4811 1111 1111 1114");
		aDriver.findElementByAccessibilityId("app.tara.tara_app:id/et_add_expiryMM").sendKeys("03");
		aDriver.findElementByAccessibilityId("app.tara.tara_app:id/et_add_expiryYY").sendKeys("23");
		aDriver.findElementByAccessibilityId("app.tara.tara_app:id/et_add_CVV").sendKeys("123");
		test.log(LogStatus.INFO, "Entered all the card details");
	
		aDriver.findElementByAccessibilityId("app.tara.tara_app:id/button_continue").click();
		
		test.log(LogStatus.INFO, "Card added successfully");
				
	}
	
	public void add_BankAccount() throws InterruptedException
	{
		test.log(LogStatus.INFO, "Bank Vicotoria account adding ");

		waitForElementforClick(BankVicotia,10);
		Thread.sleep(3000);

		aDriver.findElementByXPath("//android.widget.EditText[@index='1']").sendKeys("1234567890");
	    Thread.sleep(10000);
		test.log(LogStatus.INFO, "Entered Bank account number ");

		aDriver.findElementByXPath("//android.widget.Button[@index='0']").click();
		
		Thread.sleep(5000); 
		aDriver.findElementByXPath("//android.widget.EditText[@index='0']").click();
				//aDriver.findElementByXPath("//android.widget.EditText[@index='0']").sendKeys("999999");
		Thread.sleep(5000);
			
		WebElement eleindex9=aDriver.findElementByXPath("//android.widget.ImageButton[@index='8']");
     	WebElement eleindex11=aDriver.findElementByXPath("//android.widget.ImageButton[@index='11']");
		Thread.sleep(5000);
     	click(eleindex9);
     	click(eleindex9);
     	click(eleindex9);
     	click(eleindex9);
     	click(eleindex9);
     	click(eleindex9);
		test.log(LogStatus.INFO, "Entered OTP");

		Thread.sleep(5000);
     	click(eleindex11);
    	//		System.out.println(eleindex11.getLocation().getX());
//		System.out.println(eleindex11.getLocation().getY());
	//	TouchAction action = new TouchAction(aDriver);
		//action.tap(969, 2194).perform();
	//	action.press(969, 2194).release().perform().press(969, 2194).release().perform();
		
		Thread.sleep(5000);
		aDriver.findElementByXPath("//android.widget.Button[@index='0']").click();
		
		Thread.sleep(10000);
		if(isElementPresent(TMConstants.Swithch_Sellar_button))
		{
			reportFail("Account added failed");
			test.log(LogStatus.INFO, "Account added failed ");
		
		}
		else
		{
			test.log(LogStatus.INFO, "Account added successfully"); 
		}
		
	}
}


