package com.pom.TaraMerchant.pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pom.TaraMerchant.pages.base.BasePage;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends BasePage {
	
	@FindBy(xpath="//android.widget.Button[@index='2']")
    public WebElement Country_Code;
		
	@FindBy(xpath="//android.view.View[@index='1']")
    public WebElement Country_Code91;
	
	@FindBy(xpath="//android.view.View[@index='0']")
    public WebElement Country_Code62;
		
	@FindBy(xpath="//android.widget.EditText[@index='3']")
    public WebElement MobileNumber_Text;

	@FindBy(xpath="//android.view.View[@content-desc=\"Send SMS\"]")
    public WebElement Send_SMS_Button; 
	
	@FindBy(xpath="//android.widget.EditText[@index='4']")
    public WebElement OTP_Text_1; 
	
	@FindBy(xpath="//android.widget.EditText[@index='5']")
    public WebElement OTP_Text_2; 
	
	@FindBy(xpath="//android.widget.EditText[@index='6']")
    public WebElement OTP_Text_3; 
	
	@FindBy(xpath="//android.widget.EditText[@index='7']")
    public WebElement OTP_Text_4;
	
	@FindBy(xpath="//android.widget.EditText[@index='8']")
    public WebElement OTP_Text_5; 
	
	@FindBy(xpath="//android.widget.EditText[@index='9']")
    public WebElement OTP_Text_6; 
	
	@FindBy(xpath="//android.view.View[@index='12']")
    public WebElement Validate_Button; 
	
	@FindBy(xpath="//android.widget.Button[@index='0']")
    public WebElement mngcalls_allow_button;
	
	//Display Language change elements
	
	@FindBy(xpath="//android.view.View[@content-desc=\"We'll send you a one time password on this mobile number\"]")
    public WebElement English_InDisplay;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Kami akan mengirimkan Anda kata sandi satu kali di nomor ponsel ini\"]")
    public WebElement Indonesia_InDisplay;

	@FindBy(xpath="//android.view.View[@content-desc=\"Change Language\"]")
    public WebElement ChangeLanguage;
	
	@FindBy(xpath="//android.view.View[@index='1']")
    public WebElement English;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Indonesian\"]")
    public WebElement Indonesian;
	
	//	
	@FindBy(xpath="//android.widget.ImageView[@index='18']")
    public WebElement Logout;
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Log Out\"]")
    public WebElement Logout1;
	
	
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Profile\"]")
    public WebElement ProfileMenu;
	
	
	public HomePage(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
	 super(aDriver,test);
	   
	}
	
	public void OTPValidation(String MobileNumber, String OTP1,String OTP2,String OTP3,String OTP4, String OTP5,String OTP6 ) throws InterruptedException{
			
		if(!isElementDisplayed(English_InDisplay))
		{ 
			test.log(LogStatus.INFO, "Changing display language");
			aDriver.findElementByXPath("//android.view.View[@content-desc=\"Change Language\"]").click();
			aDriver.findElementByXPath("//android.view.View[@content-desc=\"English\"]").click();
			test.log(LogStatus.INFO, "Changed display language to english");

		}
		waitForElementforClick(Country_Code, 10);
		waitForElementforClick(Country_Code91, 20);
		waitForElementforClick(MobileNumber_Text, 20);
		typeText(MobileNumber_Text,MobileNumber);
		reportPass("Entered MobileNumber");
		click(Send_SMS_Button);
		Thread.sleep(2000);
		if(isElementDisplayed(OTP_Text_1))
		{
			test.log(LogStatus.INFO, "Navigated to OTP Page");
		}
		else
		{
			reportFail("Not Navigated to OTP Page");
			Assert.assertEquals(isElementDisplayed(OTP_Text_1),true,"Navigated to OTP Page");
		}
		//Assert.assertEquals(isElementDisplayed(myaccounttext),true,"FAIL:Login failed");
		typeText(OTP_Text_1, OTP1);
		typeText(OTP_Text_2,OTP2);
		typeText(OTP_Text_3,OTP3);
		typeText(OTP_Text_4,OTP4);
		typeText(OTP_Text_5, OTP5);
		typeText(OTP_Text_6,OTP6);
		click(Validate_Button);
		
//		if(!isElementPresent(TMConstants.ProceedButton))
//		{
//			reportFail("Login failed");
//									
//		}
//		else
//		{
//			test.log(LogStatus.INFO, "logged in successfully");
//		}
												
		}
	  public void OTP( String OTP1,String OTP2,String OTP3,String OTP4, String OTP5,String OTP6) {
		  
			test.log(LogStatus.INFO, "Entering Valid OTP ");

		    typeText(OTP_Text_1, OTP1);
			typeText(OTP_Text_2,OTP2);
			typeText(OTP_Text_3,OTP3);
			typeText(OTP_Text_4,OTP4);
			typeText(OTP_Text_5, OTP5);
			typeText(OTP_Text_6,OTP6);
			click(Validate_Button);
			if(!isElementPresent(TMConstants.ProceedButton))
			{
				reportFail("Login failed");
										
			}
			else
			{
				test.log(LogStatus.INFO, "logged in successfully");
			}
					
	  }
	  public void changeLanguage() throws InterruptedException
	  {
		  if(!isElementDisplayed(English_InDisplay))
			{ 
				test.log(LogStatus.INFO, "Displayed Language is Bahasa, changing to English");
				ChangeLanguage.click();
			    Thread.sleep(2000);

				English.click();
			    Thread.sleep(5000);
				if(isElementDisplayed(English_InDisplay))
					reportPass("Changed display language to english successfully");
				else
				    reportFail("change language is not done");
			}
		  
		  else
		  {
			    test.log(LogStatus.INFO, "Displayed Language is English, changing to Bahasa");
			    ChangeLanguage.click();
			    Thread.sleep(2000);
			    Indonesian.click();
			    Thread.sleep(5000);
				if(isElementDisplayed(Indonesia_InDisplay))
					reportPass("Changed display language to Bahasa successfully");
				else
					reportFail("change language is not done");
			  
		  }
			  
	  }
	
	 public void logout() throws InterruptedException
     {
				    
		    test.log(LogStatus.INFO, "Navigating to Logout");
			waitForElementforClick(ProfileMenu, 20);
		    Thread.sleep(2000);
		    TouchAction action = new TouchAction(aDriver);
			//int endy=aDriver.manage().window().getSize().getHeight()/7;
	        int x = aDriver.manage().window().getSize().getWidth()/2;
	        int y = aDriver.manage().window().getSize().getHeight()/2;
	     action.longPress(x, y).moveTo(x, y-(y)).release().perform();
	        Thread.sleep(3000);
		    test.log(LogStatus.INFO, "Clicking Logout");

			waitForElementforClick(Logout1, 20);

	  	  if(isElementDisplayed(MobileNumber_Text)) {
			reportPass("logged out successfully");
		    System.out.println("logged out successfully");}

		  else {
		    reportFail("log out not done");
		    System.out.println("log out not done");}
	  	  

     }


}
