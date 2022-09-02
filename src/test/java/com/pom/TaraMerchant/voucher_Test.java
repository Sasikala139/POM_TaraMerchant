package com.pom.TaraMerchant;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.AddProduct_Page;
import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.pages.voucher_page;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

public class voucher_Test extends BaseTest{

	@Test
	public void Test1_addproduct() throws InterruptedException, IOException {
		test = rep.startTest("Voucher Test:");
		test.log(LogStatus.INFO, "Starting the add voucher test ");
		launchApp();
		Thread.sleep(4000);
		HomePage hm;
		hm=new HomePage(aDriver, test);
		if(!hm.isElementPresent(TMConstants.Mobile_Text1)){
			hm.reportFail("login page is not not loaded");
		}
		hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);		
	  voucher_page vou=new voucher_page(aDriver, test);
      vou.NavigationTo_voucher();
      vou.AddVoucherRP();
      vou.AddVoucher_percent();
      vou.EditVoucher();
}
}
