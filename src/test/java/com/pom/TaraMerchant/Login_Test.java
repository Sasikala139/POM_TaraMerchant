package com.pom.TaraMerchant;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.pages.StoreCreation_Page;
import com.pom.TaraMerchant.pages.add_paymentoption_Page;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

public class Login_Test extends BaseTest {

	String testName="LoginTest";

	@Test
	public void logintest() throws InterruptedException, IOException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting the test ");
		launchApp();
		HomePage hm;
		hm=new HomePage(aDriver, test);
		if(!hm.isElementPresent(TMConstants.Mobile_Text1)){
			hm.reportFail("login page is not not loaded");
		}
		//PageFactory.initElements(aDriver, this);
		Thread.sleep(10000);
		hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP0);
		if(!hm.isElementPresent(TMConstants.allowmsgpopup))
		{
			//hm.reportFail("Login failed");
			test.log(LogStatus.INFO, "login failed with invalid OTP ");
		
			hm.OTP(TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);
						
		}
		else
		{
			test.log(LogStatus.INFO, "logged in successfully");
		}
			
	//	hm.logout();
		aDriver.resetApp();
	//Runtime.getRuntime().exec("taskkill /F /IM appium");
	//Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	//	System.out.println("appium server closed successfully");

	}
	
	
	
}
