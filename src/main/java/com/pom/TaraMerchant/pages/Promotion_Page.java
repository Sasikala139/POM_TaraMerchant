package com.pom.TaraMerchant.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pom.TaraMerchant.pages.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Promotion_Page extends BasePage {
	 
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Promotion\"]")
	    public WebElement PromotonMenu; 
	    
	    @FindBy(xpath= "//android.widget.ImageView[@content-desc=\"Add Template\"]")
	    public WebElement AddTemplate; 
	    
	    @FindBy(xpath="//android.view.View[@index='1']")
	    public WebElement AddVoucher;
	    
	    @FindBy(xpath="//android.widget.EditText[@index='3']")
	    public WebElement Title;
	    
	    @FindBy(xpath="//android.widget.EditText[@index='5']")
	    public WebElement Description;
	    
	    @FindBy(xpath="//android.view.View[@index='7']")
	    public WebElement BackgroudColor;
	    
	    @FindBy(xpath="//android.view.View[@index='2']")
	    public WebElement SelectBackgroudColor;
	    	    
	    @FindBy(xpath="//android.view.View[@index='14']")
	    public WebElement StartDate;
	    
	    @FindBy(xpath=" //android.widget.Button[@content-desc=\"OK\"]")
	    public WebElement Ok_Calender;
	 	    
	    @FindBy(xpath="//android.view.View[@index='15']")
	    public WebElement EndDate;
	    
	    @FindBy(xpath="//android.view.View[@index='37']")
	    public WebElement selectendDate; 
	    
	    @FindBy(xpath="//android.widget.ImageView[@content-desc=\"Continue\"]")
		
	    public WebElement Continue_button;
	    
     
	    public Promotion_Page (AndroidDriver<AndroidElement> aDriver, ExtentTest test){
	         super(aDriver,test);
	           
	        }
	    
	    public void addPromotion() throws InterruptedException {
	    
	        waitForElementforClick(PromotonMenu, 20);
                Thread.sleep(5000);
                
                if(isElementDisplayed(AddTemplate))
    			{
    	  			test.log(LogStatus.INFO, "clicking add addTemplate"); 
	  	        waitForElementforClick(AddTemplate, 20);
	  			test.log(LogStatus.INFO, "Entering promotion  details"); 
	  			//waitForElementforClick(AddVoucher, 20);
	  	        typeText(Title, "DemoPromotion2");
	  	        aDriver.hideKeyboard();

	  	        typeText(Description, "Description of Promotion1");
	  	        aDriver.hideKeyboard();

	  	        waitForElementforClick(BackgroudColor, 10);
	  	        Thread.sleep(200);
	  	        waitForElementforClick(SelectBackgroudColor, 10);

	  	       
	  	        waitForElementforClick(StartDate, 20);
	  	       // waitForElementforClick(selectstartDate, 20);
	  	        
	  	        waitForElementforClick(Ok_Calender, 20);
	  	        
	  	        aDriver.hideKeyboard();
	  	        
	  	        waitForElementforClick(EndDate, 20);
	  	        waitForElementforClick(selectendDate, 20);
	  	        
	  	        waitForElementforClick(Ok_Calender, 20);
	  	  	
	  	        aDriver.hideKeyboard();
	  			test.log(LogStatus.INFO, "clicking next"); 

	  	        waitForElementforClick(Continue_button, 10);
     	  	      Alert alert = aDriver.switchTo().alert(); 
			     alert.accept();
			     
	  	        Thread.sleep(6000);
	  	        waitForElementforClick(Continue_button, 10);

	  	      String toastmessage=captureToastmessage();
	  	      Thread.sleep(2000);
	  		if(toastmessage.toLowerCase().contains("Template Added".toLowerCase())) 
	  		{
	  			reportPass(toastmessage);
	  		  }
	  		else {
	  			reportFail("Promotional template not added");
	  		     }
	  		
    		aDriver.navigate().back();	
      		
    		}
	               
                
	    else {
	    	reportFail("Promotions page not loaded");
	    	}
}
}
	  	        

	  	   
	  	    


