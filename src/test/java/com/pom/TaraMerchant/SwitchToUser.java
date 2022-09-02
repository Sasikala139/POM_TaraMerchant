package com.pom.TaraMerchant;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.AddProduct_Page;
import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.pages.StoreCreation_Page;
import com.pom.TaraMerchant.pages.add_paymentoption_Page;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

public class SwitchToUser extends BaseTest {


	@Test
	public void Test1_switchtouser() throws InterruptedException, IOException {
		test = rep.startTest("AddProductFromIndividualAccount");
		test.log(LogStatus.INFO, "Starting the add product test ");
		launchApp();
		Thread.sleep(4000);
		HomePage hm;
		hm=new HomePage(aDriver, test);
		if(!hm.isElementPresent(TMConstants.Mobile_Text1)){
			hm.reportFail("login page is not not loaded");
		}
		hm.OTPValidation("9885600022","6","0","0","0","2","2");		
		//Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		add_paymentoption_Page addpay=new add_paymentoption_Page(aDriver, test);
		
		//addpay.add_creditcard();
		AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
		StoreCreation_Page sp=new StoreCreation_Page(aDriver, test);
		sp.SwithUser("IndividualUser");
		addpay.navigatetomerchantiflareadyuser();

		addprod.NavigationTo_addProduct();
		
		addprod.AddProduct();
	}
	
}
