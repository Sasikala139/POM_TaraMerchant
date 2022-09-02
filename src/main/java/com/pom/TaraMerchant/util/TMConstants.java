package com.pom.TaraMerchant.util;

import java.sql.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TMConstants {

	// App parameters
		//public static final String APK_PATH = System.getProperty("user.dir")+"\\apk\\merchant-release-uat-Rel-2.1.0.apk";
	  
	    public static final String APK_PATH = System.getProperty("user.dir")+"\\apk\\UnifiedApp-release_uat-3.0.0(7).apk";
	    public static final String DEVICE_NAME ="emulator-5554";
		
	    
		public static final String APPACTIVITY = "app.tara.tara_app";
		public static final String PLATFORM = "android";
		public static final String APPWAITACTIVITY = "app.tara.tara_app.MainActivity";
		
	//Mobile number and OTP
		public static final String todayDate="19, Friday, August 19, 2022";
		public static final String endDate="26, Friday, August 26, 2022";

		public static final String MobileNumber = "9885500013";
		public static final String OTP0 = "5";
		public static final String OTP1 = "0";
		public static final String OTP2 = "0";
		public static final String OTP3 = "0";
		public static final String OTP4= "1";
		public static final String OTP5= "3";
		
		//http://localhost:4444/wd/hub
		public static final String HUB_URL = "http://127.0.0.1:4723/wd/hub";
		
		public static final String REPORT_PATH = "D:\\report\\";
		public static final String XLS_PATH = System.getProperty("user.dir")+"//data//TestData.xlsx";
		public static final String SCREENSHOT_PATH = "D:\\screenshots\\";

		// elements
		public static final String NAVIGATION_ARROW_IMAGE = "//android.widget.Button[@index='4']";
		public static final String Mobile_Text1= "//android.widget.EditText[@index='3']";
		public static final String allowmsgpopup= "//android.widget.Button[@index='0']";
		public static final String ProceedButton = "//android.view.View[@index='3']";
		public static final String Swithch_Sellar_button = "//android.widget.ImageView[@index='1']";
		public static final String AddProductButton = "//android.widget.ImageView[@index='4']";
		public static final String Confirm_msg = "//android.view.View[@content-desc='Order Placed\r\n"
                + "Successfully!']";

			
		public static final String countrycode = "//android.widget.ImageView[@index='0']";
		public static final String Mobile_Text = "//android.widget.EditText[@index='1']";
		public static final String TC_checkbox = "//android.widget.CheckBox[@index='2']";
		public static final String nextbutton = "//android.widget.Button[@index='0']";
		public static final String OTP_text = "//android.view.View[@index='2']";
	
		
}
