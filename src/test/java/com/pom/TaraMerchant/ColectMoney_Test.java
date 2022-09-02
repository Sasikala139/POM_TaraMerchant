package com.pom.TaraMerchant;


	import java.io.IOException;

	import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.CollectMoney_Page;
import com.pom.TaraMerchant.pages.HomePage;
	import com.pom.TaraMerchant.util.TMConstants;
	import com.relevantcodes.extentreports.LogStatus;

	public class ColectMoney_Test extends BaseTest {

		String testName="collectmoney";
		@Test
		public void ColletMoney() throws InterruptedException, IOException {
			test = rep.startTest(testName);
			test.log(LogStatus.INFO, "Starting the test ");
			launchApp();
			Thread.sleep(4000);
			HomePage hm;
			hm=new HomePage(aDriver, test);
			if(!hm.isElementPresent(TMConstants.Mobile_Text1)){
				hm.reportFail("login page is not not loaded");
			}
			//PageFactory.initElements(aDriver, this);
			Thread.sleep(10000);
			hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);				
			 
			
			CollectMoney_Page CMP=new CollectMoney_Page(aDriver, test);
			CMP.AddCollectMoney();
		}	
	
}
