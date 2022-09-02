package com.pom.TaraMerchant;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.Dashboard_Page;
import com.pom.TaraMerchant.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;

public class DashBoard_Test extends BaseTest {

	@Test
	public void Test1_addproduct() throws InterruptedException, IOException {
		test = rep.startTest("DashBoard Test:");
		test.log(LogStatus.INFO, "Starting the add voucher test ");
		launchApp();
		Thread.sleep(4000);
		HomePage hm;
		hm=new HomePage(aDriver, test);
		//hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);		
		hm.OTPValidation("9885500013","5","0","0","0","1","3");
	    Dashboard_Page DP=new Dashboard_Page(aDriver, test);
        DP.Top5InventoryItems();
        DP.Top5Customers();
        DP.TopVouchers();
        DP.PaymentModes();
        DP.inflow();
        DP.OutFlow();
        
      
      
      
	}
	
	
}
