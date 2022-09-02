package com.pom.TaraMerchant;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.AddProduct_Page;
import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.pages.OrderMgt_Page;
import com.pom.TaraMerchant.pages.POS_Order;
import com.pom.TaraMerchant.pages.StoreCreation_Page;
import com.pom.TaraMerchant.pages.add_paymentoption_Page;
import com.pom.TaraMerchant.pages.base.BasePage;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

public class practice  extends BaseTest {

	@Test
	public void InventoryOutOfStocks() throws InterruptedException, IOException {
		test = rep.startTest("outofstock");
		test.log(LogStatus.INFO, "Starting the test ");
		launchApp();
		Thread.sleep(4000);
		HomePage hm;
		hm=new HomePage(aDriver, test);
		
		//PageFactory.initElements(aDriver, this);
		Thread.sleep(10000);
		hm.OTPValidation("9885500013","5","0","0","0","1","3");
		AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
		//sp.SwithUser("Merchant");
		String phonenumber="9885500013";
		test.log(LogStatus.INFO, "Mobile Number is "+phonenumber);

		
		
			
    }

	}
