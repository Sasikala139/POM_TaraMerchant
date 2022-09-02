package com.pom.TaraMerchant;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.TaraMerchant.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;

public class ChangeLanguage_Test extends BaseTest{

	String testName="ChangeLaguage";

	@Test
	public void ChangeLanguage() throws InterruptedException, IOException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting the Change Laguage test ");
		launchApp();
		HomePage hm;
		hm=new HomePage(aDriver, test);
		hm.changeLanguage();
		Thread.sleep(6000);
		hm.changeLanguage();

}
}