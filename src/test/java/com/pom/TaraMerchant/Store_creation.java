package com.pom.TaraMerchant;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.AddProduct_Page;
import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.pages.StoreCreation_Page;
import com.pom.TaraMerchant.pages.add_paymentoption_Page;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

public class Store_creation extends BaseTest {
	

	String testName="StoreCreation";

	@Test
	public void StoreCreation() throws InterruptedException, IOException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting the store creation test ");
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
		add_paymentoption_Page addpay=new add_paymentoption_Page(aDriver, test);
        addpay.navigateToSwitchuser();
        Thread.sleep(3000);
		StoreCreation_Page storecreate=new StoreCreation_Page(aDriver, test);
		storecreate.SwithUser("Merchant");
		storecreate.create_store();
		//hm.logout();
		System.out.println("executed sucessfully");

	}
	

}
