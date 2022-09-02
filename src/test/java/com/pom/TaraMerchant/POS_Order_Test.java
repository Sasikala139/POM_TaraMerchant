package com.pom.TaraMerchant;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.AddProduct_Page;
import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.pages.POS_Order;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

public class POS_Order_Test extends BaseTest{

		
		String testName="posOrdering";

		@Test (priority=1)
		
		public void POS_Order_Cash() throws InterruptedException, IOException {
			test = rep.startTest(testName);
			test.log(LogStatus.INFO, "Starting the test ");

			launchApp();
			Thread.sleep(4000);
			HomePage hm;
			hm=new HomePage(aDriver, test);
			if(!hm.isElementPresent(TMConstants.Mobile_Text1)){
				
				hm.reportFail("login page is not not loaded");
			}
			Thread.sleep(10000);
			hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);				
			//Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
			
			//adding product to create order.
			AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
			//sp.SwithUser("Merchant");
			addprod.NavigationTo_addProduct();
			addprod.AddProductfororder("product1", "1000", "10");
			
			Thread.sleep(5000);
			aDriver.navigate().back();
			POS_Order pos= new POS_Order(aDriver, test);

			Thread.sleep(4000);
			pos.SearchProduct("product1");
			pos.OrderThroughPos_cash();
			
				
		}
		
		@Test (priority=2)
		public void POS_Order_Link() throws InterruptedException, IOException {
			
			test = rep.startTest("POS order with generated Link ");
			test.log(LogStatus.INFO, "Starting POS order with generated Link test ");
			POS_Order pos= new POS_Order(aDriver, test);

			pos.SearchProduct("product1");
			pos.OrderThroughPos_Link();
		
		
		
		}
		
}

