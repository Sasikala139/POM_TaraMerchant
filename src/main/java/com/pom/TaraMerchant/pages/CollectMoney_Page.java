package com.pom.TaraMerchant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.pom.TaraMerchant.pages.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CollectMoney_Page extends BasePage{

	@FindBy(xpath="//android.widget.ImageView[@content-desc='Collect Money']")
    public WebElement CollectMoneybtn; 
	
	@FindBy(xpath="(//android.widget.EditText)[1]")
    public WebElement Amounttxt; 
	
	@FindBy(xpath="(//android.widget.EditText)[2]")
    public WebElement AddNotes;
	
	@FindBy(xpath="//android.widget.Button[@content-desc='+62']")
    public WebElement Country_Code;

	@FindBy(xpath="//android.view.View[@content-desc='+91']")
    public WebElement Country_Code91;
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc='Home']")
    public WebElement Homebtn;
	
 	@FindBy(xpath="(//android.widget.EditText)[3]")
    public WebElement MobileNumber_Text; 
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc='Generate Payment Link']")
    public WebElement GenaratePaymentLink; 
	
	@FindBy(xpath="//android.widget.ImageView[contains(@content-desc,'https://taraapp.page.link/')]")
    public WebElement PaymentLink;
	
	@FindBy(xpath="(//android.widget.TextView[@index='0'])[1]")
    public WebElement Share;
	
	public CollectMoney_Page(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
		 super(aDriver,test);
		   
		}
	
	public void AddCollectMoney() throws InterruptedException
	{
 

		waitForElementforClick(CollectMoneybtn, 20);
		test.log(LogStatus.INFO, "Click on Collect Money");
		
		waitForElementforClick(Amounttxt, 10);
		test.log(LogStatus.INFO, "Enter Amount");
		typeText(Amounttxt, "500");

		waitForElementforClick(AddNotes, 20);
		test.log(LogStatus.INFO, "Adding Notes");
		typeText(AddNotes, "Adding some notes");
		
		waitForElementforClick(Country_Code, 10);
		
		waitForElementforClick(Country_Code91, 20);
		
		waitForElementforClick(MobileNumber_Text, 20);
		test.log(LogStatus.INFO, "Enter mobile Number ");
		typeText(MobileNumber_Text, "9885500021"); 
		
		waitForElementforClick(GenaratePaymentLink, 20);
		test.log(LogStatus.INFO, "Clicked on Genarate Payment Link");
		
		Thread.sleep(2000);
		
		if(isElementDisplayed(PaymentLink))
		{
			reportPass("Payment Link Created");
		}
		else
		{
			reportFail("Payment Link Not Found!");
			Assert.assertEquals(isElementDisplayed(PaymentLink),true,"Payment Link Created");
		}
		
		waitForElementforClick(PaymentLink, 30);
		test.log(LogStatus.INFO, "Clicked on Payment Link");
		
		if(isElementDisplayed(Share))
		{
			reportPass("Share Page displayed");
		}
		else
		{
			reportFail("Share Page Not Found!");
			Assert.assertEquals(isElementDisplayed(Share),true,"Share Page displayed");
		}
	     aDriver.resetApp();        
}

}
