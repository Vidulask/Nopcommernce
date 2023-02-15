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
import Pomclassnopcom.homepagetestclass;
import Utils.Utility;


public class Verificationoflink extends Browser {
	
	private WebDriver driver;
	private homepagetestclass Homepagetestclass;
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
	public void beforeclass() {
		 Homepagetestclass = new homepagetestclass(driver);
	}

	@BeforeMethod
	public void lunchbrowser() {
		System.out.println("Before Method");
		driver.get("https://demo.nopcommerce.com/");
		
	}
	

	@Test
	public void testregistration() throws InterruptedException {
		TestID ="NopT02";
		System.out.println("Test1");
		Thread.sleep(3000);
		
		Homepagetestclass.clickOnRegisterButton();
		
		String actaulURL = driver.getCurrentUrl();
		String expectedURL = "https://demo.nopcommerce.com/register?returnUrl=%2F";
		
		if(expectedURL.equals(actaulURL))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
	}

	@Test
	public void testLOGIN() {
		TestID ="NopT03";
		System.out.println("Test2");
	
		Homepagetestclass.clickOnLoginButton();
	
	String actaulURL = driver.getCurrentUrl();
	String expectedURL = "https://demo.nopcommerce.com/login?returnUrl=%2F";
	
	if(expectedURL.equals(actaulURL))
	{
		System.out.println("PASS");
	}
	else
	{
		System.out.println("FAIL");
	}
			
}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
		Homepagetestclass = null;
		
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
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		driver.close();
		driver=null;
		System.gc();
	}
	
}
