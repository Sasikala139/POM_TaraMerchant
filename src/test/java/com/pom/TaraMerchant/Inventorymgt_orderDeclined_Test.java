package com.pom.TaraMerchant;
	import java.io.IOException;
	import java.util.Arrays;

	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;

	import com.pom.TaraMerchant.pages.AddProduct_Page;
	import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.pages.OrderMgt_Page;
import com.pom.TaraMerchant.pages.POS_Order;
	import com.pom.TaraMerchant.pages.base.BasePage;
	import com.pom.TaraMerchant.util.TMConstants;
	import com.relevantcodes.extentreports.LogStatus;

	public class Inventorymgt_orderDeclined_Test extends BaseTest{
	

		
		@Test
		public void Test1_addproduct() throws InterruptedException, IOException {
			test = rep.startTest("Product count check when Order declined");
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
//			add_paymentoption_Page addpay=new add_paymentoption_Page(aDriver, test);
//			addpay.navigatetomerchantiflareadyuser();
			//addpay.add_creditcard();
			AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
			//sp.SwithUser("Merchant");
			addprod.NavigationTo_addProduct();
			addprod.AddProductfororder("TestProductforOrderdeclined", "1000", "10");
			Thread.sleep(5000);
			WebElement productstirng=aDriver.findElementByXPath("//android.view.View[contains(@content-desc,'TestProductforOrderdeclined')]");
			String beforeorderquantity=productstirng.getTagName();
			aDriver.navigate().back();
			POS_Order pos= new POS_Order(aDriver, test);
			Thread.sleep(4000);
			pos.SearchProduct("TestProductforOrderdeclined");
			pos.OrderThroughPos_cash();
			
			//Declining order
			addprod.NavigationTo_Orders();
			Thread.sleep(3000);
			//WebElement productToDeclineele=aDriver.findElementByXPath("//android.widget.ImageView[contains(@content-desc,'TestProductforOrderdeclined')]");
            OrderMgt_Page ordpage=new OrderMgt_Page(aDriver, test);
            ordpage.Decline_Order("TestProductforOrderdeclined");
            addprod.NavigationTo_addProduct();
			Thread.sleep(12000);
            WebElement productstirng1=aDriver.findElementByXPath("//android.view.View[contains(@content-desc,'TestProductforOrderdeclined')]");
			String afterrderquantity=productstirng1.getTagName();
			aDriver.navigate().back();
            			
			//spliting beforequantity
			 String datasplit[];
			 datasplit = beforeorderquantity.split("\\n");
			 
			 System.out.println(" split by new line"+Arrays.toString(datasplit));
			 String datasplit1[];
			 datasplit1 = datasplit[1].split(":");
			 String val_str = datasplit1[1].trim(); 	
			 int befor_quantity = Integer.parseInt(val_str);
		    test.log(LogStatus.INFO, "Before Order quantity of product is "+befor_quantity);

			 System.out.println(" beforequantity"+befor_quantity);

			 //spliting after decline
			 
			 String afterdatasplit1[];
			 afterdatasplit1 = afterrderquantity.split("\\n");
			 
			 System.out.println(" split by new line"+Arrays.toString(datasplit));
			 String afterdatasplit2[] ;
			 afterdatasplit2 = afterdatasplit1[1].split(":");
			 String val_str1 = afterdatasplit2[1].trim();
			 int after_quantity = Integer.parseInt(val_str1);
			 test.log(LogStatus.INFO, "After Order quantity of product is "+after_quantity);

			 System.out.println(" after quantity"+after_quantity);
			 //test.log(LogStatus.INFO,"quantity is "+val_str1);
			  
			 BasePage BP=new BasePage(aDriver, test);
			 if(after_quantity == befor_quantity) {
				 
					test.log(LogStatus.PASS, "TestPass: Count is not changed ");

		 	 }
			 else{
				 
					test.log(LogStatus.FAIL, "Ooops! Count is changed ");

			 }
			 	
			
					
				
	}


	
}
