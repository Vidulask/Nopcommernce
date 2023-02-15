package TestNGnop;

import java.io.IOException;
import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Browser;
import Pomclassnopcom.Bookpurchasetestclass;
import Pomclassnopcom.Shoppingcartclass;
import Pomclassnopcom.homepagetestclass;
import Utils.Utility;


public class VerificationofbookTestNG extends Browser {
	
	private WebDriver driver;
	private Bookpurchasetestclass bookpurchasetestclass;
	private homepagetestclass Homepagetestclass;
	private Shoppingcartclass shoppingcartclass;
	String TestID ;
	
	@Parameters("browser")
	@BeforeTest
	public void Lunchbrowser(String browser) {
	System.out.println("startbrowser");
	
	if(browser.equals("Chrome"))
	{
		driver = openChromeBrowser();
	}
	
	if(browser.equals("Firefox"))
	{
		driver = openFirefoxBrowser();
	}
	
	/*if(browser.equals("Edge"))
	{
		driver = openEgdeBrowser();
	}*/
	
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}

	@BeforeClass
	public void CreatPomObjects() {
		 Homepagetestclass = new homepagetestclass(driver);
		 bookpurchasetestclass = new Bookpurchasetestclass(driver);
		 shoppingcartclass = new Shoppingcartclass(driver);
	}

	@BeforeMethod
	public void lunchbrowser() {
		System.out.println("Before Method");
		driver.get("https://demo.nopcommerce.com/");
			
	}

	@Test
    public void testVerificationofBookPurchase() throws InterruptedException {
     TestID = "NopT01";
	System.out.println("Test2");
	Thread.sleep(3000);
	Homepagetestclass.clickOnBookButton();
	
	bookpurchasetestclass.ClickonsortbyButton();
	bookpurchasetestclass.ClickondisplayButton();
	
	Thread.sleep(3000);
	bookpurchasetestclass.ClickonaddtocartButton();
	bookpurchasetestclass.ClickonbooknameButton();
	
	Homepagetestclass.clickOnShoppingCartButton();
	
	shoppingcartclass.clearOnQuntityButton();
	shoppingcartclass.clickOnQuntityButton();
	shoppingcartclass.clickOnUpdatecartButton();
	
	shoppingcartclass.clickOnEstimateshippingButton();
	
	Thread.sleep(3000);
	shoppingcartclass.clickOnselectcountryButton();
	shoppingcartclass.clickOnZipPostalCodeButton();
	
	Thread.sleep(5000);
	shoppingcartclass.clickOnApplynowButton();
	shoppingcartclass.clickOnIagreeButton();
	shoppingcartclass.clickOnCheckOutButton();
	}
	
	@AfterMethod
	public void afterMethod() {
	   System.out.println("After Method");
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(0));
	
	}
	public void tearDown(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(TestID);
		}
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
		Homepagetestclass = null;
		bookpurchasetestclass = null;
		shoppingcartclass = null;
		
		
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		driver.close();
		driver=null;
		System.gc();
	}
}
