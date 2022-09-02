package com.pom.TaraMerchant;

import java.io.IOException;
import org.testng.annotations.Test;
import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

public class Logout_Test extends BaseTest {
	
	@Test
	public void Logout() throws InterruptedException, IOException {
		test = rep.startTest("Logout test");
		test.log(LogStatus.INFO, "Starting the Logout test ");
		launchApp();
		Thread.sleep(4000);
		HomePage hm;
		hm=new HomePage(aDriver, test);
		Thread.sleep(10000);
		hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);
	
		
		hm.logout();
	
}
}
