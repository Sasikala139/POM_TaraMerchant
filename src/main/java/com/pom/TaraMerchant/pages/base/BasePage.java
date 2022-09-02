package com.pom.TaraMerchant.pages.base;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.pom.TaraMerchant.util.ExtentManager;
import com.pom.TaraMerchant.util.TMConstants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.org.apache.xerces.internal.dom.DeferredTextImpl;

public class BasePage {
	public  ExtentTest test;
	public  AndroidDriver<AndroidElement> aDriver;
	
//	//int level=0;
//
	public BasePage(AndroidDriver<AndroidElement> aDriver,ExtentTest test) {
		//PageFactory.initElements(new AppiumFieldDecorator(aDriver), this);
		PageFactory.initElements(aDriver, this);

		this.aDriver = aDriver;
		this.test=test;
	}
	
	public void click(WebElement Element) {
		Element.click();
	}
	
	public void typeText(WebElement element, String value) {
		element.click();
		element.clear();
		element.sendKeys(value);
	}
	
	public void selectValuefromDropDown(WebElement element, int value) {
		Select sel = new Select(element);
		sel.selectByIndex(value);
	}

	public boolean isElementDisplayed(WebElement element) {
       
		try {
		return element.isDisplayed();
        }
        catch(Exception e)
        {
        	return false;
        }
    }

	public String captureToastmessage() {
		
		WebDriverWait wait = new WebDriverWait(aDriver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
		String toastmessage= aDriver.findElementByXPath("/hierarchy/android.widget.Toast").getText();
        System.out.println("toastmessage="+toastmessage);
        return toastmessage;
		
	}
	
	public void runJavaScript(String command) {
		JavascriptExecutor js = (JavascriptExecutor) aDriver;
		js.executeScript(command);
	}

	public void uploadfile(WebElement element, String path) {
		element.sendKeys(path);
	}
	
	public void OnlywaitForElement(WebElement element, int maxTimeout) {
		WebDriverWait wait = new WebDriverWait(aDriver, maxTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void waitForElementforClick(WebElement element, int maxTimeout) {
		WebDriverWait wait = new WebDriverWait(aDriver, maxTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void waitForElementforType(WebElement element, int maxTimeout, String value) {
		WebDriverWait wait = new WebDriverWait(aDriver, maxTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(value);
	}
	


	public boolean isElementPresent(String locator){
		
		//test.log(LogStatus.INFO, "Finding presence of element "+locator);
		int s=aDriver.findElements(By.xpath(locator)).size();
		if(s==0)
		
			return false;
	
		else
			return true;
	}
	
	public boolean verifyText(String locator,String expectedText){
		return false;
	}
	
	//Touch Actions(swipe)
	
	
	public enum DIRECTION {
	    DOWN, UP, LEFT, RIGHT;
	}
	public static void swipe(AndroidDriver<AndroidElement> aDriver, DIRECTION direction) {
	    Dimension size = aDriver.manage().window().getSize();

	    int startX = 0;
	    int endX = 0;
	    int startY = 0;
	    int endY = 0;

	    switch (direction) {
	        case RIGHT:
	            startY = (int) (size.height / 2);
	            startX = (int) (size.width * 0.90);
	            endX = (int) (size.width * 0.05);
	            new TouchAction(aDriver)
	                    .press(startX, startY)
	                    .moveTo(endX, startY)
	                    .release()
	                    .perform();
	            break;

	        case LEFT:
	            startY = (int) (size.height / 2);
	            startX = (int) (size.width * 0.05);
	            endX = (int) (size.width * 0.90);
	            new TouchAction(aDriver)
	                    .press(startX, startY)
	                    .moveTo(endX, startY)
	                    .release()
	                    .perform();

	            break;

	        case UP:
	            endY = (int) (size.height * 0.70);
	            startY = (int) (size.height * 0.30);
	            startX = (size.width / 2);
	            new TouchAction(aDriver)
	                    .press(startX, startY)
	                    .moveTo(startX, endY)
	                    .release()
	                    .perform();
	            break;


	        case DOWN:
	            startY = (int) (size.height * 0.70);
	            endY = (int) (size.height * 0.30);
	            startX = (size.width / 2);
	            new TouchAction(aDriver)
	                    .press(startX, startY)
	                    .moveTo(startX, endY)
	                    .release()
	                    .perform();

	            break;

	    }
	}
	
	
	/*****************************Reporting functions*****************************************/
	
	public void reportPass(String passMsg){
		 test.log(LogStatus.PASS, passMsg);
		 takeScreenshot();


	}
	
	public void reportFail(String failureMsg){
		 test.log(LogStatus.FAIL, failureMsg);
		 takeScreenshot();


		// Assert.fail(failureMsg);
	}
	
	
	//Screen shot
	public void takeScreenshot(){
		// decide the file name
		Date d = new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ","_")+".png";
		String path=TMConstants.SCREENSHOT_PATH+screenshotFile;
		// take screenshot
		File scrFile = ((TakesScreenshot)aDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//add screenshot to report
		test.log(LogStatus.INFO,"Snapshot below: ("+screenshotFile+")"+
				 test.addScreenCapture(path));
	}
	
	

	
//	public Node initXML() {
//		aDriver.findElement(By.xpath(TMConstants.NAVIGATION_MENU_IMAGE)).click();
//		File fXmlFile = new File(System.getProperty("user.dir")+"//menu.xml");
//		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder dBuilder=null;
//		try {
//			dBuilder = dbFactory.newDocumentBuilder();
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Document doc=null;
//		try {
//			doc = dBuilder.parse(fXmlFile);
//		} catch (SAXException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		doc.getDocumentElement().normalize();
//
//		
//		Node baseNode = doc.getChildNodes().item(0);
//		return baseNode;
//	}
//	
//	public  void verifyChildValues(Node currentNode) {
//		
//		if(! (currentNode instanceof DeferredTextImpl)){
//			Element e = (Element)currentNode;
//
//			if(!e.getAttribute("id").equals("")){ // expanded/clicked
//				
//					if(!e.getAttribute("id").equals("mainmenu")){
//						boolean res=verifyElement(e.getAttribute("id"));
//						System.out.println("Level - "+level+".Verifying Node "+e.getAttribute("id")+" -result -> "+ res);
//						if(!res)
//							reportFail("Item not found in menu - "+e.getAttribute("id"));
//		
//						aDriver.findElement(By.xpath("//android.widget.TextView[@text='"+e.getAttribute("id")+"']")).click();
//						try {
//							Thread.sleep(2000);
//						} catch (InterruptedException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//						level++;
//						
//					}
//			
//			Node child = currentNode.getFirstChild();
//			while(child!=null){
//				verifyChildValues(child);
//				child=child.getNextSibling();
//			}
//			System.out.println();
//			level--;
//			if(level==0){
//				aDriver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
//				aDriver.findElement(By.xpath(FKConstants.NAVIGATION_MENU_IMAGE)).click();
//
//			}
//		
//			
//		}else{// value is present
//			
//			boolean res=verifyElement(e.getTextContent());
//			System.out.println("Level - "+level+". Verifying "+e.getTextContent()+" -result -> "+ res);
//			if(!res)
//				reportFail("Item not found in menu - "+e.getTextContent());
//			
//				currentNode = currentNode.getNextSibling();
//				verifyChildValues(currentNode);			
//		}
//		}
//		
//	}
	

}
