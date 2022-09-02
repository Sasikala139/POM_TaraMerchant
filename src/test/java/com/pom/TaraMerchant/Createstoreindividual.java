package com.pom.TaraMerchant;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.pages.StoreCreation_Page;
import com.pom.TaraMerchant.pages.add_paymentoption_Page;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

public class Createstoreindividual extends BaseTest {

	@Test
	public void StoreCreation() throws InterruptedException, IOException {
		test = rep.startTest("individualuser");
		test.log(LogStatus.INFO, "Starting the store creation test ");
		launchApp();
		Thread.sleep(4000);
		HomePage hm;
		hm=new HomePage(aDriver, test);
		if(!hm.isElementPresent(TMConstants.Mobile_Text1)){
			
			hm.reportFail("login page is not not loaded");
		}
		Thread.sleep(10000);
		//hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);				
		//Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
        hm.OTPValidation("9885600027","6","0","0","0","2","7");
		add_paymentoption_Page addpay=new add_paymentoption_Page(aDriver,test);
		addpay.navigatetomerchantiflareadyuser();
		StoreCreation_Page storecreate=new StoreCreation_Page(aDriver, test);
		//storecreate.SwithUser("IndividualUser");
		storecreate.create_store();
		
		hm.logout();
		System.out.println("executed sucessfully");

	}

}
