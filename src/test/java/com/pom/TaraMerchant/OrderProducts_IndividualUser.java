package com.pom.TaraMerchant;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.AddProduct_Page;
import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.pages.OrderProducts_IndividualUser_Page;
import com.pom.TaraMerchant.pages.StoreCreation_Page;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

public class OrderProducts_IndividualUser extends BaseTest {
	

	@Test
	public void OrderProducts_IndividualUser() throws InterruptedException, IOException {
		test = rep.startTest("order_individual");
		test.log(LogStatus.INFO, "Starting the order_individual test ");
		launchApp();
		Thread.sleep(4000);
		HomePage hm;
		hm=new HomePage(aDriver, test);
		if(!hm.isElementPresent(TMConstants.Mobile_Text1)){
			hm.reportFail("login page is not not loaded");
		}
		hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);				System.out.println("executed sucessfully");
		//Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
//		add_paymentoption_Page addpay=new add_paymentoption_Page(aDriver, test);
//		addpay.navigatetomerchantiflareadyuser();
		
		OrderProducts_IndividualUser_Page OrdProd= new OrderProducts_IndividualUser_Page(aDriver, test);
		OrdProd.NavigationTo_IndividualUser();
		OrdProd.OrderProducts_IndividualUser_Page();		
		
		//addpay.add_creditcard();
		//sp.SwithUser("Merchant");
	

}
}
