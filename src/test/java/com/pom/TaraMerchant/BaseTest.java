package com.pom.TaraMerchant;
//https://drive.google.com/open?id=0B6ou87zaWpBkUnJnV2lMbkQ3Tjg
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.pom.TaraMerchant.util.ExtentManager;
import com.pom.TaraMerchant.util.TMConstants;
import com.pom.TaraMerchant.util.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest extends TMConstants {

	public static ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static WebDriver driver;
	public static AndroidDriver<AndroidElement> aDriver;
	//public static Xls_Reader xls = new Xls_Reader(TMConstants.XLS_PATH);
	
    @SuppressWarnings("deprecation")
	public void launchApp() throws InterruptedException, IOException{
		 	File app = new File(TMConstants.APK_PATH);
	     	DesiredCapabilities capabilities =new DesiredCapabilities();
	     	//with real device
	     	
	     	capabilities.setCapability("deviceName", "Redmi Sasi");
	     	capabilities.setCapability("udid", "9ecba005");
	     	capabilities.setCapability("platformVersion", "11");
	 	
	 		//with emulator
	     	
	 	//capabilities.setCapability("deviceName",TMConstants.DEVICE_NAME);

	 		
	     	capabilities.setCapability(CapabilityType.BROWSER_NAME,"");
			capabilities.setCapability("platformName",TMConstants.PLATFORM);
	 		capabilities.setCapability("appActivity", TMConstants.APPWAITACTIVITY);
			capabilities.setCapability("appPackage", TMConstants.APPACTIVITY);
			capabilities.setCapability("autoGrantPermissions", "true");
			capabilities.setCapability("noReset", "true");
			capabilities.setCapability("fullReset", "false");
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,180);
  		    capabilities.setCapability("app", app.getAbsolutePath());
		 try {
			test.log(LogStatus.INFO, "Launching app ");
			//Start Appium server
			//Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723\"");
			//Thread.sleep(20000);
			driver = new AndroidDriver<AndroidElement>(new URL(TMConstants.HUB_URL), capabilities);
			aDriver = (AndroidDriver<AndroidElement>)driver;
			System.out.println("application launched successfully");
		} catch (MalformedURLException e) {
			test.log(LogStatus.FAIL, "Application did not launch "+ e.getMessage());
			e.printStackTrace();
			Assert.fail("Application did not launch"+ e.getMessage());
		}
		aDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}
	
    @AfterTest
	public void quit(){
		if(rep!=null){
			rep.endTest(test);
			rep.flush();
		}
    }
	@AfterClass
		public void reseting() {
		
			if(aDriver!=null) 
				
			aDriver.resetApp();
		
	}


	
}
