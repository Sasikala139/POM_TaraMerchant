package com.pom.TaraMerchant;

import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.AddProduct_Page;
import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.pages.POS_Order;
import com.pom.TaraMerchant.pages.base.BasePage;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

public class Inventorymgt_Test extends BaseTest {

	
	@Test
	public void Test1_addproduct() throws InterruptedException, IOException {
		test = rep.startTest("Product count check");
		test.log(LogStatus.INFO, "Starting inventory mgt test ");
		launchApp();
		Thread.sleep(4000);
		HomePage hm;
		hm=new HomePage(aDriver, test);
		if(!hm.isElementPresent(TMConstants.Mobile_Text1)){
			hm.reportFail("login page is not not loaded");
		}
		hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);				
		//Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
//		add_paymentoption_Page addpay=new add_paymentoption_Page(aDriver, test);
//		addpay.navigatetomerchantiflareadyuser();
		//addpay.add_creditcard();
		AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
		//sp.SwithUser("Merchant");
		addprod.NavigationTo_addProduct();
		addprod.AddProductfororder("TestProductforOrder", "1000", "10");
		Thread.sleep(5000);
		WebElement productstirng=aDriver.findElementByXPath("//android.view.View[contains(@content-desc,'TestProductforOrder')]");
		String beforeorderquantity=productstirng.getTagName();
		aDriver.navigate().back();
		POS_Order pos= new POS_Order(aDriver, test);
		Thread.sleep(4000);
		pos.SearchProduct("TestProductforOrder");
		pos.OrderThroughPos_cash();
		addprod.NavigationTo_addProduct();
		Thread.sleep(12000);
	
		WebElement productstirng1=aDriver.findElementByXPath("//android.view.View[contains(@content-desc,'TestProductforOrder')]");
		String afterrderquantity=productstirng1.getTagName();
		
		//spliting beforequantity
		 String datasplit[];
		 datasplit = beforeorderquantity.split("\\n");
		 
		 System.out.println(" split by new line"+Arrays.toString(datasplit));
		 String datasplit1[];
		 datasplit1 = datasplit[1].split(":");
		 String val_str = datasplit1[1].trim(); 	
		 int befor_quantity = Integer.parseInt(val_str);
		 test.log(LogStatus.INFO, "After Order quantity of product is "+befor_quantity);

		 System.out.println(" beforequantity"+befor_quantity);

		 //spliting after quantity
		 
		 String afterdatasplit1[];
		 afterdatasplit1 = afterrderquantity.split("\\n");
		 
		 System.out.println(" split by new line"+Arrays.toString(datasplit));
		 String afterdatasplit2[] ;
		 afterdatasplit2 = afterdatasplit1[1].split(":");
		 String val_str1 = afterdatasplit2[1].trim();
		 int after_quantity = Integer.parseInt(val_str1);
		 test.log(LogStatus.INFO, "After Order quantity of product is "+after_quantity);

		 
		 System.out.println("after quantity"+after_quantity);
		 BasePage BP=new BasePage(aDriver, test);
		 int exp_quantity= befor_quantity-1;
		 if(exp_quantity==after_quantity) {
			 BP.reportPass("Count is changed");
		 }
		 else{
			 BP.reportFail("Ooops! Count is not changed");
		 }
		 	
		
				
			
}
}
