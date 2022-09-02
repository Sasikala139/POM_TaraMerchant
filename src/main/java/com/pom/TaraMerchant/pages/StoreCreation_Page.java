package com.pom.TaraMerchant.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pom.TaraMerchant.pages.base.BasePage;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class StoreCreation_Page extends BasePage {

	
	@FindBy(xpath="//android.widget.EditText[@index='4']")
    public WebElement Store_Name; 
	
	@FindBy(xpath="//android.view.View[@index='5']")
    public WebElement Category;
	
	@FindBy(xpath="//android.view.View[@index='6']")
    public WebElement subcategory; 
	
	@FindBy(xpath="//android.widget.EditText[@index='9']")
    public WebElement Name; 
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Store Logo\"]")
    public WebElement StoreLogo; 
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Upload Store Banner\"]")
    public WebElement StoreBanner; 
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Gallery\"]")
    public WebElement Gallary; 
	
	@FindBy(id="com.google.android.documentsui:id/icon_thumb")
    public WebElement Select_img;
    
    @FindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public WebElement Permission;
        
    @FindBy(xpath="//android.widget.TextView[@content-desc=\"Crop\"]")
    public WebElement Crop;
	
	@FindBy(xpath="//android.view.View[@index='1']")
    public WebElement Camera; 
	
	@FindBy(xpath="//android.widget.Button[@index='1']")
    public WebElement Next_NavigationButton; 
	
	@FindBy(xpath="//android.widget.ImageView[@index='2']")
    public WebElement MerchantUser;
	
	
	@FindBy(xpath="//android.widget.ImageView[@index='1']")
    public WebElement IndividualUser;
	
	@FindBy(xpath="//android.view.View[@index='2']")
    public WebElement SkipCreateWebStore ;
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Profile\"]")
    public WebElement profile ;
	

	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Switch To Seller Profile\"]")
    public WebElement switchtoseller ;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"FMCG\"]")
    public WebElement category_FMCG ;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Fruits\"]")
    public WebElement SubCategory_Fruits ;
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Select\"]")
    public WebElement DoneButton ;
	
	@FindBy(xpath="//android.widget.ImageView[@index='4']")
    public WebElement AddButton ;
	
	@FindBy(xpath="//android.widget.Button[@index='1']")
    public WebElement allowonetime;
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Select location\"]")
    public WebElement SelectLocation;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button")
    public WebElement Next_address_but;
	
	@FindBy(xpath="//android.widget.EditText[@index='1']")
    public WebElement City;
	
	@FindBy(xpath="//android.widget.EditText[@index='2']")
    public WebElement pin;
	
	@FindBy(xpath="//android.widget.ImageView[@index='3']")
    public WebElement currentFocus_Map;
	
	@FindBy(xpath="//android.view.View[@content-desc=\"Skip to Home\"]")
    public WebElement SkipToHome;
	
	//android.view.View[@content-desc="Skip to Home"]


	public StoreCreation_Page(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
	 super(aDriver,test);
	   
	}
		
	public void SwithUser(String SelectUser) throws InterruptedException
	{
		Thread.sleep(2000);
		
		if(SelectUser=="Merchant") { 
			
			waitForElementforClick(MerchantUser, 20);
			test.log(LogStatus.INFO, "Switched to merchant ");
}
		else {
			click(IndividualUser);
			test.log(LogStatus.INFO, "Switched to Individual User "); }

	}
	
	public void create_store() throws InterruptedException {
		
	
		 Thread.sleep(2000);
			
		 waitForElementforClick(SkipCreateWebStore, 20);
		 waitForElementforClick(StoreLogo, 20);
		 waitForElementforClick(Gallary, 20);
		 waitForElementforClick(Select_img, 20);
		 waitForElementforClick(Crop, 20);
		Thread.sleep(3000);
		waitForElementforClick(StoreBanner, 20);
		waitForElementforClick(Gallary, 20);
		waitForElementforClick(Select_img, 20);
		waitForElementforClick(Crop, 20);
		Thread.sleep(3000);
		waitForElementforClick(Store_Name, 20);
		typeText(Store_Name,"store18 New");
		Thread.sleep(5000);
		click(Category);
		Thread.sleep(5000);
		waitForElementforClick(category_FMCG, 20);
	
		Thread.sleep(5000);
		click(subcategory);
		Thread.sleep(5000);
		waitForElementforClick(SubCategory_Fruits, 10);
		click(DoneButton);
		typeText(Name,"Vardhan");
		aDriver.hideKeyboard();
		waitForElementforClick(Next_NavigationButton, 10);
	//adress locating
		
		Thread.sleep(4000);
		OnlywaitForElement(allowonetime,20);
		if(isElementDisplayed(allowonetime)) {
			test.log(LogStatus.INFO, "Navigated To Select Adrress ");
             reportPass("Navigated To Select Adrress");
             takeScreenshot(); }
		else
		{
			test.log(LogStatus.INFO, "Not Navigated To Select Address ");
            reportFail("Not Navigated To Select Address");
		}
		
		waitForElementforClick(allowonetime, 20);
	       Thread.sleep(30000);    

		//waitForElement(currentFocus_Map, 20);
	   TouchAction action = new TouchAction(aDriver);
	   //action.press(500, 1100).release().perform().press(500, 1100).release().perform();
	   Thread.sleep(2000);
	  // action.press(500, 1100).release().perform().press(500, 1100).release().perform();
	   action.longPress(500, 1100).moveTo(500, 1150).release().perform();
	   Thread.sleep(5000);

	   waitForElementforClick(SelectLocation, 10);
		
	   Thread.sleep(5000);
	   
	   waitForElementforClick(Next_address_but, 20);
		
		Thread.sleep(10000);
		
		if(isElementPresent(TMConstants.AddProductButton))
		{
			
			reportPass("Congrats! store created successfully");
			
		}
		else
		{
			reportFail("Store creation is failed");
			test.log(LogStatus.INFO, "store creation failed ");
			
		}
		
		if(isElementDisplayed(SkipToHome))
		
		   waitForElementforClick(SkipToHome, 20);
				

	}	
}
