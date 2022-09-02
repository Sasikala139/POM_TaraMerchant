package com.pom.TaraMerchant;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.AddProduct_Page;
import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.pages.base.BasePage;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

public class OutOfStock_Test extends BaseTest {

	@Test
	public void Test1_addproduct() throws InterruptedException, IOException {
		test = rep.startTest("Out of stock test");
		test.log(LogStatus.INFO, "Starting Out of stock test ");
		launchApp();
		Thread.sleep(4000);
		HomePage hm;
		hm=new HomePage(aDriver, test);
		if(!hm.isElementPresent(TMConstants.Mobile_Text1)){
			hm.reportFail("login page is not not loaded");
		}
		hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);				
		//Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	
	AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
	//sp.SwithUser("Merchant");
	addprod.NavigationTo_addProduct();
	addprod.AddProductfororderoutofstock("TestOutOfStok", "1000", "10");
	//ord.orderthroughPos();
	Thread.sleep(4000);
	WebElement outStockproduct=aDriver.findElementByXPath("//android.widget.ImageView[contains(@content-desc,'TestOutOfStok')]");
	Thread.sleep(2000);
	BasePage BP=new BasePage(aDriver, test);
	String producttext=outStockproduct.getTagName();
	if(producttext.contains("Out of stock")){
	     BP.reportPass("Testpass:outofstock is displayed");
	}
        else{
             BP.reportFail("outofstock is not displayed"); }

}
	
}
