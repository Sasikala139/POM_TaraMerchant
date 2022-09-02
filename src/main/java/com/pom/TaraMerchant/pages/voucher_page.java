package com.pom.TaraMerchant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pom.TaraMerchant.pages.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class voucher_page extends BasePage{

	 @FindBy(xpath="//android.widget.ImageView[@content-desc=\"Coupons\"]")
	    public WebElement coupons; //android.widget.ImageView[@content-desc="Coupons"]

	   @FindBy(xpath="//android.widget.ImageView[@content-desc=\"Add Voucher\"]")
	    public WebElement addVoucherBtn;
	    
	    @FindBy(xpath="//android.widget.EditText[@index='2']")
	    public WebElement titleTextbox;
	    
	    @FindBy(xpath="(//android.widget.EditText[@index='0'])[2]")
	    public WebElement maxCapTextbox;
	    
	    @FindBy(xpath="(//android.widget.EditText[@index='0'])[3]")
	    public WebElement voucherValue;
	    
	    @FindBy(xpath="(//android.widget.EditText[@index='0'])[4]")
	    public WebElement min_amt;
	    
	    @FindBy(xpath="//android.view.View[17]")
	    public WebElement no_of_times;
	    
	    @FindBy(xpath="//android.view.View[@index='22']")
	    public WebElement startDate;
	    
	    @FindBy(xpath="//android.view.View[@content-desc=TMConstants.todayDate]")
	    public WebElement selectstartDate;
	    
	    @FindBy(xpath="//android.widget.Button[@content-desc='OK']")
	    public WebElement clickok; 
	    @FindBy(xpath="//android.widget.Button[@content-desc='Next month']")
	    public WebElement NextMonth; 
	    
	    @FindBy(xpath="//android.view.View[@index='36']")
	    public WebElement endDate;
	    
		
	  //android.view.View[@content-desc="29, Thursday, September 29, 2022"]
	    
	    @FindBy(xpath="(//android.view.View)[46]")
	    public WebElement selectendDate; 
	    
	    @FindBy(xpath= "//android.widget.ImageView[@content-desc=\"Profile\"]")
	    public WebElement SellerProfileMenu; 
	    @FindBy(xpath="//android.widget.ImageView[@content-desc='Next']")
	    public WebElement next;
	    
	    @FindBy(xpath="//android.view.View[@content-desc=\"Select all\"]")
	    public WebElement SelectAll_Products;
	    @FindBy(xpath="//android.widget.ImageView[@content-desc=\"Continue\"]")
	    public WebElement Continue_Button;
	    
	    @FindBy(xpath="(//android.view.View[@index='4'])[1]")
	    public WebElement percent_button;
	    
	    //Edit
	    @FindBy(xpath="(//android.view.View[@content-desc=\"EDIT\"])[1]")
	    public WebElement EditButton;
	    
	    
	    	     
	    public voucher_page(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
	         super(aDriver,test);
	           
	        }
	    
	    public void NavigationTo_voucher() throws InterruptedException {
			
			waitForElementforClick(SellerProfileMenu, 20);
            Thread.sleep(2000);
			
            TouchAction action = new TouchAction(aDriver);

			//int endy=aDriver.manage().window().getSize().getHeight()/7;
	        int x = aDriver.manage().window().getSize().getWidth()/2;
	        int y = aDriver.manage().window().getSize().getHeight()/2;
	        action.longPress(x, y).moveTo(x, y-(y)).release().perform();
	        Thread.sleep(3000);


		}
	     
	    public void AddVoucherRP() throws InterruptedException
	    {
	    	        
	        waitForElementforClick(coupons, 20);
			test.log(LogStatus.INFO, "clicking add Voucher"); 

	        waitForElementforClick(addVoucherBtn, 20);
			test.log(LogStatus.INFO, "Entering add Voucher details"); 
						
	      //  waitForElementforClick(percent_button, 20);

	        waitForElementforClick(titleTextbox, 20);
	        typeText(titleTextbox, "DemoVoucherRP2");
	        
	        typeText(maxCapTextbox, "500");
	        
	        typeText(voucherValue, "50");
	        aDriver.hideKeyboard();

	        waitForElementforClick(min_amt, 10);
	        typeText(min_amt, "10");
	        
	        aDriver.hideKeyboard();
	        waitForElementforClick(no_of_times, 20);
	        
	        aDriver.hideKeyboard();
	        Thread.sleep(200);
	        waitForElementforClick(startDate, 20);
	       // waitForElementforClick(selectstartDate, 20);
	        
	        waitForElementforClick(clickok, 20);
	        
	        aDriver.hideKeyboard();
	        
	        waitForElementforClick(endDate, 20);
	        
	        waitForElementforClick(NextMonth, 20);
        
	        waitForElementforClick(selectendDate, 20);
	        
	        waitForElementforClick(clickok, 20);
	        
	        aDriver.hideKeyboard();
	        waitForElementforClick(next, 10);
	        
			test.log(LogStatus.INFO, "clicking next"); 
			Thread.sleep(4000);

	        waitForElementforClick(SelectAll_Products, 10);
	        
	        waitForElementforClick(Continue_Button, 10);
			Thread.sleep(8000);

	        String voucherPage=aDriver.getPageSource();
	        if(voucherPage.contains("DemoVoucherRP2")) {
	        	reportPass("voucher created");
	        	        	
	        }
	        else{
	        	reportFail("Voucher Created Failed.");
	        	
	        }
	     			
	    }
	    
	    public void AddVoucher_percent() throws InterruptedException
	    {
	    	        
			test.log(LogStatus.INFO, "clicking add Voucher to create % type voucher"); 

	        waitForElementforClick(addVoucherBtn, 20);
			test.log(LogStatus.INFO, "Entering add Voucher details"); 
            
		   waitForElementforClick(percent_button, 20);

			
	        waitForElementforClick(titleTextbox, 20);
	        typeText(titleTextbox, "DemoVoucherPercent2");
	        
	        typeText(maxCapTextbox, "500");
	        
	        typeText(voucherValue, "50");
	        aDriver.hideKeyboard();

	        waitForElementforClick(min_amt, 10);
	        typeText(min_amt, "10");
	        
	        aDriver.hideKeyboard();
	        waitForElementforClick(no_of_times, 20);
	        
	        aDriver.hideKeyboard();
	        Thread.sleep(200);
	        waitForElementforClick(startDate, 20);
	       // waitForElementforClick(selectstartDate, 20);
	        
	        waitForElementforClick(clickok, 20);
	        
	        aDriver.hideKeyboard();
	        
	        waitForElementforClick(endDate, 20);
	        waitForElementforClick(NextMonth, 20);

	        waitForElementforClick(selectendDate, 20);
	        
	        waitForElementforClick(clickok, 20);
	        
	        aDriver.hideKeyboard();
	        waitForElementforClick(next, 10);
	        
			test.log(LogStatus.INFO, "clicking next"); 
			Thread.sleep(4000);

	        waitForElementforClick(SelectAll_Products, 10);
	        
	        waitForElementforClick(Continue_Button, 10);
			Thread.sleep(8000);

	        String voucherPage=aDriver.getPageSource();
	        System.out.println(voucherPage);
	        if(voucherPage.contains("DemoVoucherPercent2")) {
	        	reportPass("voucher created");
	        	        	
	        }
	        else{
	        	reportFail("Voucher Created Failed.");
	        	
	        }
	  			
	    }
	    
	    public void EditVoucher() throws InterruptedException
	    {
	    	        
			test.log(LogStatus.INFO, "clicking Edit Voucher"); 

	        waitForElementforClick(EditButton, 20);
			Thread.sleep(6000);
			
			if(isElementDisplayed(titleTextbox))
			{
				test.log(LogStatus.INFO, "Editing Voucher details"); 
				waitForElementforClick(titleTextbox, 20);
		        typeText(titleTextbox, "DemoVoucherPercent1Edited");
		        
		      //  typeText(maxCapTextbox, "500");
		        
		        typeText(voucherValue, "51");
		        aDriver.hideKeyboard();

//		        waitForElementforClick(min_amt, 10);
//		        typeText(min_amt, "10");
		        
//		        aDriver.hideKeyboard();
//		        waitForElementforClick(no_of_times, 20);
//		        
//		        aDriver.hideKeyboard();
//		        Thread.sleep(200);
//		        waitForElementforClick(startDate, 20);
//		       // waitForElementforClick(selectstartDate, 20);
//		        
//		        waitForElementforClick(clickok, 20);
//		        
//		        aDriver.hideKeyboard();
//		        
//		        waitForElementforClick(endDate, 20);
//		        waitForElementforClick(selectendDate, 20);
//		        
//		        waitForElementforClick(clickok, 20);
//		        
//		        aDriver.hideKeyboard();
//		        waitForElementforClick(next, 10);
		        
				test.log(LogStatus.INFO, "clicking next"); 
				Thread.sleep(4000);

		        waitForElementforClick(SelectAll_Products, 10);
		        
		        waitForElementforClick(Continue_Button, 10);
				Thread.sleep(8000);

		        String voucherPage=aDriver.getPageSource();
		        Thread.sleep(5000);
		        if(voucherPage.contains("VoucherPercent1Edited")) {
		        	reportPass("Voucher Edited");
		        	        	
		        }
		        else{
		        	reportFail("Voucher Edit Failed.");
		        	
		        }
			}
			else
			{
				reportFail("Edit Page Not Loaded");
			}
  
	    }
	    
	    public void AddVoucherRP_mapcategory() throws InterruptedException
	    {
	    	        
	        waitForElementforClick(coupons, 20);
			test.log(LogStatus.INFO, "clicking add Voucher"); 

	        waitForElementforClick(addVoucherBtn, 20);
			test.log(LogStatus.INFO, "Entering add Voucher details"); 
						

	        waitForElementforClick(titleTextbox, 20);
	        typeText(titleTextbox, "DemoVoucherRP2");
	        
	        typeText(maxCapTextbox, "500");
	        
	        typeText(voucherValue, "50");
	        aDriver.hideKeyboard();

	        waitForElementforClick(min_amt, 10);
	        typeText(min_amt, "10");
	        
	        aDriver.hideKeyboard();
	        waitForElementforClick(no_of_times, 20);
	        
	        aDriver.hideKeyboard();
	        Thread.sleep(200);
	        waitForElementforClick(startDate, 20);
	       // waitForElementforClick(selectstartDate, 20);
	        
	        waitForElementforClick(clickok, 20);
	        
	        aDriver.hideKeyboard();
	        
	        waitForElementforClick(endDate, 20);
	        waitForElementforClick(NextMonth, 20);

	        waitForElementforClick(selectendDate, 20);
	        
	        waitForElementforClick(clickok, 20);
	        
	        aDriver.hideKeyboard();
	        waitForElementforClick(next, 10);
	        
			test.log(LogStatus.INFO, "clicking next"); 
			Thread.sleep(4000);

	        waitForElementforClick(SelectAll_Products, 10);
	        
	        waitForElementforClick(Continue_Button, 10);
			Thread.sleep(8000);

	        String voucherPage=aDriver.getPageSource();
	        if(voucherPage.contains("DemoVoucherRP2")) {
	        	reportPass("voucher created");
	        	        	
	        }
	        else{
	        	reportFail("Voucher Created Failed.");
	        	
	        }
	     			
	    }
	    
}
	

