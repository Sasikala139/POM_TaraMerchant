package com.pom.TaraMerchant;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.AddProduct_Page;
import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

public class uploadCSV_Test extends BaseTest {

	String testName="UploadCSV";
	
	@Test
	public void UploadCSV() throws InterruptedException, IOException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting the test ");
		launchApp();
		Thread.sleep(4000);
		HomePage hm;
		hm=new HomePage(aDriver, test);
		hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);				//Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
		addprod.NavigationTo_addProduct();
		addprod.uploadCSVFile();
	}
	
}

