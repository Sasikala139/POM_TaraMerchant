package com.pom.TaraMerchant;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.pages.StoreCreation_Page;
import com.pom.TaraMerchant.pages.add_paymentoption_Page;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

public class Onboarding_Test extends BaseTest {

	String testName="addPayment";
	@Test
	public void Add_PaymentTest() throws InterruptedException, IOException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting addPayment test ");
		HomePage hm;
		launchApp();
		Thread.sleep(4000);
		hm=new HomePage(aDriver, test);
		if(!hm.isElementPresent(TMConstants.Mobile_Text1)){
			hm.reportFail("login page is not not loaded");
		}
		//PageFactory.initElements(aDriver, this);
		Thread.sleep(5000);
		hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);		
		System.out.println("Login sucessfully");
	
		add_paymentoption_Page addpay=new add_paymentoption_Page(aDriver, test);
		addpay.NavigatedTo_BankAccount();
		addpay.add_BankAccount();
	    Thread.sleep(5000);
		//Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
//         hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);		
// 	     Thread.sleep(4000);
        addpay.navigateToSwitchuser();
//        StoreCreation_Page sp=new StoreCreation_Page(aDriver, test);
//        sp.SwithUser("Merchant");
//    	sp.create_store();
//    	hm.logout();
	
	}
	
}
