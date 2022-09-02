package com.pom.TaraMerchant;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.AddProduct_Page;
import com.pom.TaraMerchant.pages.HomePage;
import com.pom.TaraMerchant.pages.StoreCreation_Page;
import com.pom.TaraMerchant.pages.add_paymentoption_Page;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AddProduct_Test extends BaseTest
{

	String testName1="Test1_addproduct";
	String testName2="Test2_EditProduct";
	String testName3="Test3_Deleteproduct";
	String testName4="Test4_UploadCSV";

	@Test
	public void Test1_addproduct() throws InterruptedException, IOException {
		test = rep.startTest(testName1);
		test.log(LogStatus.INFO, "Starting the add product test ");
		launchApp();
		Thread.sleep(4000);
		HomePage hm;
		hm=new HomePage(aDriver, test);
		if(!hm.isElementPresent(TMConstants.Mobile_Text1)){
			hm.reportFail("login page is not not loaded");
		}
		hm.OTPValidation(TMConstants.MobileNumber,TMConstants.OTP0,TMConstants.OTP1,TMConstants.OTP2,TMConstants.OTP3,TMConstants.OTP4,TMConstants.OTP5);				System.out.println("executed sucessfully");
		//Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
//		add_paymentoption_Page addpay=new add_paymentoption_Page(aDriver, test);
//		addpay.navigatetomerchantiflareadyuser();
		
		//addpay.add_creditcard();
		AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
		//sp.SwithUser("Merchant");
		addprod.NavigationTo_addProduct();
		addprod.AddProduct();
	}
	@Test
	public void Test2_EditProduct() throws InterruptedException, IOException {
		test = rep.startTest(testName2);
		test.log(LogStatus.INFO, "Starting the edit product test ");
		
		AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
		//sp.SwithUser("Merchant");
		addprod.EditProduct();
	}
	
	@Test
	public void Test3_Deleteproduct() throws InterruptedException
	{
		test = rep.startTest(testName3);
		test.log(LogStatus.INFO, "Starting the delete product test ");
		
		AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
		addprod.DeleteProduct();
	}
	
	@Test
	public void Test4_AddproductmoreDiscountthanprice() throws InterruptedException
	{
		test = rep.startTest("AddproductmoreDiscountthanprice");
		test.log(LogStatus.INFO, "Starting the Addproduct more Discount than price ");
		
		AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
		addprod.AddproductmoreDiscountthanprice();
	}
	
	
	@Test 
	public void Test6_SearchProduct() throws InterruptedException
	{
		test = rep.startTest("Searching Product");
		test.log(LogStatus.INFO, "Starting the Search Product test");
		
		AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
		addprod.SearchProduct();
           

		aDriver.resetApp();
	}
	
	@Test 
	public void Test5_AddProductWithoutName() throws InterruptedException
	{
		test = rep.startTest("AddProductWithoutName");
		test.log(LogStatus.INFO, "Starting the AddProduct Without Name");
		
		AddProduct_Page addprod=new AddProduct_Page(aDriver, test);
		addprod.AddProductWithoutName();
//        aDriver.navigate().back();
//        Thread.sleep(2000);

        
	}


	
	
	
}
		

