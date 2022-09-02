package com.pom.TaraMerchant.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pom.TaraMerchant.pages.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AddProduct_Page extends BasePage{
	
	@FindBy(xpath="//android.widget.ImageView[@index='0']")
    public WebElement ProductImage; 

	@FindBy(xpath="//android.widget.EditText[@index='1']")
	public WebElement ProductName; 

	@FindBy(xpath="//android.widget.EditText[@index='2']")
    public WebElement ProductPrice; 
	
	@FindBy(xpath="//android.widget.EditText[@index='3']")
    public WebElement DiscountPrice; 
	
	@FindBy(xpath="//android.widget.EditText[@index='4']")
    public WebElement ItemCount; 
	
	@FindBy(xpath="//android.view.View[@index='0']")
    public WebElement Currently_showstock; 
	
	@FindBy(xpath="//android.view.View[@index='6']")
    public WebElement Category; 
		
	@FindBy(xpath="//android.view.View[@content-desc=\"Fruits and Vegetables\"]")
    public WebElement category_item;
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Select\"]")
    public WebElement category_item_DoneButton;
	
	@FindBy(xpath="//android.widget.EditText[@index='7']") 
    public WebElement Description; 
	
	@FindBy(xpath="//android.widget.ImageView[@index='2']")
    public WebElement Done_Button; 
	
	@FindBy(xpath="//android.view.View[index='0']")
    public WebElement AddAnother_Button; 
	
	@FindBy(xpath="//android.widget.ImageView[@content-desc=\"Inventory\"]")
    public WebElement Inventory_menu; 
	
	@FindBy(xpath="//android.widget.ImageView[@index='9']")
    public WebElement Delevery_settings; 
	
	@FindBy(xpath="//android.widget.ImageView[@index='6']")
    public WebElement sellerInventory_menu; 

	@FindBy(xpath= "//android.view.View[@content-desc=\"ADD PRODUCT\"]")
    public WebElement Addproduct_Button; 
	
	@FindBy(xpath= "//android.widget.ImageView[@content-desc=\"Profile\"]")
    public WebElement SellerProfileMenu; 
	
	@FindBy(xpath= "//android.widget.ImageView[@index='2']")
    public WebElement Addproduct_Button_afterstore; 
	
	@FindBy(xpath= "//android.widget.ImageView[@index='1']")
    public WebElement EditProduct_Button; 
	
	@FindBy(xpath="//android.widget.Button[@index='0']")
    public WebElement access_allow_button;
	//uplode image Elements
	   @FindBy(xpath="(//android.widget.ImageView[@index='0'])[2]")
	    public WebElement Gallery;
	   
	   @FindBy(id="com.google.android.documentsui:id/icon_thumb")
	    public WebElement Select_img;
	    
	    @FindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	    public WebElement Permission;
	    	     
	    @FindBy(xpath="//android.widget.ImageButton[@content-desc=\"Done\"]")
	    public WebElement Done;
	    
	    @FindBy(xpath="//android.widget.TextView[@content-desc=\"Crop\"]")
	    public WebElement Crop;
	
	  //delete element
	    @FindBy(xpath="(//android.view.View[@index='2'])[2]")
	    public WebElement delete_icon;
	    
	  //search elements
	    @FindBy(xpath="//android.widget.EditText[@index='0']")
	    public WebElement searchText;
	    
	    @FindBy(xpath="//android.widget.ImageView[@content-desc=\"Orders\"]")
	    public WebElement Orders_menu;
	    
	    @FindBy(xpath="//android.widget.ImageView[@content-desc='POS']")
	    public WebElement POS;  
		
		@FindBy(xpath="//android.view.View[@content-desc='Show out of stock']")
	    public WebElement OutOfStocks; 
		
		@FindBy(xpath="//android.widget.ImageView[contains(@content-desc,'Out of stock')]")
	    public WebElement OutOfStocksMsg; 
	  
		   
	public AddProduct_Page(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
	 super(aDriver,test);
	 
	}
	
	public void NavigationTo_addProduct() throws InterruptedException {
		
		waitForElementforClick(SellerProfileMenu, 20);

		TouchAction action = new TouchAction(aDriver);

		//int endy=aDriver.manage().window().getSize().getHeight()/7;
        int x = aDriver.manage().window().getSize().getWidth()/2;
        int y = aDriver.manage().window().getSize().getHeight()/2;
        action.longPress(x, y).moveTo(x, y-(y)).release().perform();
        Thread.sleep(3000);
		waitForElementforClick(Inventory_menu, 20); 
}
	
public void NavigationTo_Orders() throws InterruptedException {
		
		waitForElementforClick(SellerProfileMenu, 20);

		waitForElementforClick(Orders_menu, 20); 
}


	public void AddProduct() throws InterruptedException
	{
		System.out.println("in addproduct block");
		waitForElementforClick(Addproduct_Button, 10);
		test.log(LogStatus.INFO, "Adding Product");
//Adding image
		waitForElementforClick(ProductImage, 10);
		waitForElementforClick(Gallery, 20);
		waitForElementforClick(Select_img, 20);
		waitForElementforClick(Crop, 20);
	        //waitForElement(Permission, 20);
  		System.out.println("Image uploaded successfully");
        Thread.sleep(4000);
        click(ProductName);
        ProductName.sendKeys("Orange1");
        Thread.sleep(2000);
        typeText(ProductPrice,"200");
		typeText(DiscountPrice,"150");
		aDriver.hideKeyboard();
		typeText(ItemCount,"10");
		aDriver.hideKeyboard();
    	Thread.sleep(2000);
		click(Category);
		Thread.sleep(2000);
		click(category_item);
		click(category_item_DoneButton);
		aDriver.hideKeyboard();

		Thread.sleep(2000);
		//action1.tap(948,2152).perform();
				
	    //action.longPress(954, 2084).release().perform();
		typeText(Description,"description of productname1");
		aDriver.hideKeyboard();
		//action1.tap(990,2150).perform();
		waitForElementforClick(Done_Button, 10);
		String toastmessage=captureToastmessage();
		if(toastmessage.toLowerCase().contains("Added Successfully".toLowerCase())) 
		{
			reportPass(toastmessage);
		   takeScreenshot(); }
		else {
			reportFail("Product not added failed");
		    aDriver.navigate().back(); }
		}
		
	public void EditProduct() throws InterruptedException
	{
		test.log(LogStatus.INFO, "Editing Product");
		System.out.println("Editing Product");

		click(EditProduct_Button);
		ProductName.sendKeys("OrangeEdited");
        Thread.sleep(2000);
        typeText(ProductPrice,"300");
		typeText(DiscountPrice,"250");
		aDriver.hideKeyboard();

		typeText(ItemCount,"20");
		aDriver.hideKeyboard();
		Thread.sleep(1000);
		typeText(Description,"description of product edited");
		aDriver.hideKeyboard();
		waitForElementforClick(Done_Button, 10);
		String toastmessageEdit=captureToastmessage();
		System.out.println("toastmessage="+toastmessageEdit);
		if(toastmessageEdit.toLowerCase().contains("Added Successfully".toLowerCase())) 
		{
			reportPass(toastmessageEdit);
		    takeScreenshot(); }
		else {
			reportFail("Product Edited failed");
		    aDriver.navigate().back(); }
		}
	public void DeleteProduct() throws InterruptedException {
		System.out.println("deleting product");
        Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicking delete product icon");
		click(delete_icon);
		WebDriverWait wait = new WebDriverWait(aDriver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/hierarchy/android.widget.Toast")));
		String toastmessage= aDriver.findElementByXPath("/hierarchy/android.widget.Toast").getText();   
		Thread.sleep(2000);
		if(toastmessage.toLowerCase().contains("successfully".toLowerCase())) 
		{
			reportPass(toastmessage);
		   takeScreenshot(); }
		else {
			reportFail("Product deleted failed"); }
		

}
		
	public void uploadCSVFile() throws InterruptedException {
        Thread.sleep(2000);
		System.out.println("Uploading CSV");
		aDriver.findElementByXPath("//android.view.View[@content-desc=\"Upload CSV\"]").click();
		 test.log(LogStatus.INFO, "clicked on upload CSV");

		aDriver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Upload CSV\"]").click();
	 
		if(isElementDisplayed(access_allow_button))
        {    
            click(access_allow_button);
            
           
         }        
		Thread.sleep(2000);
		//aDriver.findElementById("com.google.android.documentsui:id/icon_mime").click();
		aDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout").click();
		 test.log(LogStatus.INFO, "Selected file");
    	
	   	aDriver.findElementByXPath("//android.view.View[@content-desc=\"Upload\"]").click();
	   	Thread.sleep(3000);
	     String uploadcsvpage=aDriver.getPageSource();
	     if(uploadcsvpage.contains("cake") && uploadcsvpage.contains("apple"))
		{
			reportPass("Uploaded CSV successfully");
		}
		else
		{
			reportFail("Uploaded CSV Failed");
			//aDriver.navigate().back();
		}
		}
		
		
//       // aDriver.pushFile("/storage/emulated/0/Download/sample_updated1.csv", new File("C:\\Users\\SasikalaMukkara\\Downloads\\sample_updated1.csv"));
//        //Add a simple assertion
//        By nextPageHeader = By.cssSelector("h1");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(nextPageHeader));
//        Assert.assertTrue(driver.findElement(nextPageHeader).getText().equals("File Upload Results"));
	
public void AddProductWithoutName() throws InterruptedException
{
    System.out.println("adding product with out Name");
	waitForElementforClick(Addproduct_Button, 10);
	test.log(LogStatus.INFO, "Adding Product with out product name");
    Thread.sleep(2000);
    typeText(ProductPrice,"200");
	typeText(DiscountPrice,"150");
	aDriver.hideKeyboard();
	typeText(ItemCount,"10");
	aDriver.hideKeyboard();
	Thread.sleep(2000);
	click(Category);
	Thread.sleep(2000);
	click(category_item);
	click(category_item_DoneButton);
	aDriver.hideKeyboard();
	Thread.sleep(2000);
	typeText(Description,"description of productname1");
	aDriver.hideKeyboard();
	waitForElementforClick(Done_Button, 10);
	String toastmessagenamerequired=captureToastmessage();
	test.log(LogStatus.INFO, toastmessagenamerequired);
	if(!toastmessagenamerequired.toLowerCase().contains("name is required".toLowerCase())) 
	{   
		reportFail("Test Failed: Should ask for procut Name");
	   takeScreenshot();
	}
	else
		reportPass("Not allowed adding product without product Name");
	    takeScreenshot(); 
	    aDriver.navigate().back();
	}


public void AddproductmoreDiscountthanprice() throws InterruptedException
{
    System.out.println("adding product with more discount than price");

waitForElementforClick(Addproduct_Button, 10);
test.log(LogStatus.INFO, "Adding Product with more discount than price");
Thread.sleep(2000);
typeText(ProductName,"mango");
Thread.sleep(2000);
typeText(ProductPrice,"250");
typeText(DiscountPrice,"350");
aDriver.hideKeyboard();
typeText(ItemCount,"10");
aDriver.hideKeyboard();
Thread.sleep(2000);
click(Category);
Thread.sleep(2000);
click(category_item);
click(category_item_DoneButton);
aDriver.hideKeyboard();
Thread.sleep(2000);
typeText(Description,"description of productname1");
aDriver.hideKeyboard();
waitForElementforClick(Done_Button, 10);
String toastmessage=captureToastmessage();
test.log(LogStatus.INFO, toastmessage);
if(!toastmessage.toLowerCase().contains("Discounted price cannot be greater than MRP".toLowerCase())) 
{   
	reportFail("Test Failed: Discounted price cannot be greater than MRP");
   takeScreenshot();
}
else
	reportPass("Not allowed as Discounted price is greater than MRP");
    takeScreenshot(); 
    aDriver.navigate().back();
}

public void SearchProduct() throws InterruptedException
{
    System.out.println("Searching  product ");

	test.log(LogStatus.INFO, "Searching for the Product");
    Thread.sleep(2000);
    typeText(searchText,"cake");
	aDriver.hideKeyboard();
   if(aDriver.getPageSource().toLowerCase().contains("cake".toLowerCase())){
	   reportPass("search product successfully"); }
	   else {
		   reportFail("Found search product error.");
	   }

	  
   }
 
public void AddProductfororder(String productname, String price, String quantity) throws InterruptedException {
	
	
		waitForElementforClick(Addproduct_Button, 10);
		test.log(LogStatus.INFO, "Adding Product");
      
        Thread.sleep(4000);
        click(ProductName);
        ProductName.sendKeys(productname);
        Thread.sleep(2000);
        typeText(ProductPrice,price);
		aDriver.hideKeyboard();
		typeText(ItemCount,quantity);
		aDriver.hideKeyboard();
    	Thread.sleep(2000);
		click(Category);
		Thread.sleep(2000);
		click(category_item);
		click(category_item_DoneButton);
		aDriver.hideKeyboard();
		Thread.sleep(2000);
//		String countis=ItemCount.getText();
//		System.out.println("Product quantity befor ordering is "+countis);
	
//		test.log(LogStatus.INFO, "product quantity before ordering "+ItemCount.getText());
 
		waitForElementforClick(Done_Button, 10);
		
		}

public void AddProductfororderoutofstock(String productname, String price, String quantity) throws InterruptedException {
    
//	waitForElement(Addproduct_Button, 10);
    
    waitForElementforClick(Addproduct_Button, 10);
    test.log(LogStatus.INFO, "Adding Product");
  
    Thread.sleep(4000);
    click(ProductName);
    ProductName.sendKeys(productname);
    Thread.sleep(2000);
    typeText(ProductPrice,price);
    aDriver.hideKeyboard();
    typeText(ItemCount,quantity);
    Thread.sleep(2000);
    waitForElementforClick(OutOfStocks, 10);
    aDriver.hideKeyboard();
    Thread.sleep(2000);
    click(Category);
    Thread.sleep(2000);
    click(category_item);
    click(category_item_DoneButton);
    aDriver.hideKeyboard();
    Thread.sleep(2000);
//    String countis=ItemCount.getText();
//    System.out.println("Product quantity befor ordering is "+countis);

//    test.log(LogStatus.INFO, "product quantity before ordering "+ItemCount.getText());

    waitForElementforClick(Done_Button, 10);
    Thread.sleep(4000);
    aDriver.navigate().back();
    waitForElementforClick(POS, 30);
    Thread.sleep(2000);
}
    
//    
//    
//    if(isElementDisplayed(OutOfStocksMsg)){
//	     reportPass("outofstocks message displayed");
//	}
//        else{
//             reportFail("outofstocks message displayed");
//
//
//
//    }
    
    public void AddProductforexceedlimit(String productname, String price, String quantity) throws InterruptedException {
        
//    	waitForElement(Addproduct_Button, 10);
        
        waitForElementforClick(Addproduct_Button, 10);
        test.log(LogStatus.INFO, "Adding Product");
      
        Thread.sleep(4000);
        click(ProductName);
        ProductName.sendKeys(productname);
        Thread.sleep(2000);
        typeText(ProductPrice,price);
        aDriver.hideKeyboard();
        typeText(ItemCount,quantity);
        
        aDriver.hideKeyboard();
        click(Category);
        Thread.sleep(2000);
        click(category_item);
        click(category_item_DoneButton);
        aDriver.hideKeyboard();
        Thread.sleep(2000);
        waitForElementforClick(Done_Button, 10);
        Thread.sleep(4000);
        aDriver.navigate().back();
        waitForElementforClick(POS, 30);
        Thread.sleep(2000);
        
  

}
	
}





	



