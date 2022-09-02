package com.pom.TaraMerchant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.pom.TaraMerchant.pages.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class OrderProducts_IndividualUser_Page extends BasePage{

	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Store\"]")
    public WebElement Store; 
    
	@FindBy(xpath= "//android.widget.ImageView[@content-desc=\"Profile\"]")
    public WebElement SellerProfileMenu; 
	
	@FindBy(xpath= "//android.widget.ImageView[@content-desc=\"Switch To Individual Profile\"]")
    public WebElement SwitchToIndual; 
	
	@FindBy(id= "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public WebElement allowPermission; 
	
	@FindBy(id= "(//android.view.View[@index='0'])[9]")
    public WebElement StoreSelect; 
		
    
    public OrderProducts_IndividualUser_Page(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
         super(aDriver,test);
           
        }
    
public void NavigationTo_IndividualUser() throws InterruptedException {
		
		waitForElementforClick(SellerProfileMenu, 20);

		Thread.sleep(2000);
		TouchAction action = new TouchAction(aDriver);

		//int endy=aDriver.manage().window().getSize().getHeight()/7;
        int x = aDriver.manage().window().getSize().getWidth()/2;
        int y = aDriver.manage().window().getSize().getHeight()/2;
        action.longPress(x, y).moveTo(x, y-(y)).release().perform();
        Thread.sleep(3000);
		waitForElementforClick(SwitchToIndual, 20);
}
    
    public void OrderProducts_IndividualUser_Page() throws InterruptedException  {
		
		waitForElementforClick(Store, 20);
        Thread.sleep(2000);
        if(isElementDisplayed(allowPermission))
		{
        	allowPermission.click();
		}
        Thread.sleep(3000);
		      
	//	waitForElementforClick(StoreSelect, 20);
		
		//productselection
		//waitForElementforClick(StoreSelect, 20);
		
		Thread.sleep(3000);
		aDriver.findElementByXPath("//android.view.View[contains(@content-desc,'store')]").click();
		
		Thread.sleep(3000);

		
		//aDriver.findElementByXPath("//android.view.View[contains(@content-desc,'ADD')]").click();
		
		aDriver.findElementByXPath("//label[text()='ADD']").click();

        
		//label[text()='Outstanding Balance:']

        
        
        
     	
	
    }	
}
