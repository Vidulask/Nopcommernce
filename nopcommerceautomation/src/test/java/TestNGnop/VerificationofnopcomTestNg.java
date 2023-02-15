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
import Pomclassnopcom.loginpagetestclass;
import Pomclassnopcom.registrationpagetestclass;
import Utils.Utility;

public class VerificationofnopcomTestNg extends Browser  {

	private WebDriver driver;
	private homepagetestclass Homepagetestclass;
	private registrationpagetestclass Registrationpagetestclass;
	private loginpagetestclass Loginpagetestclass;
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
		 Registrationpagetestclass = new registrationpagetestclass(driver);
		 Loginpagetestclass = new loginpagetestclass(driver);
	}

	@BeforeMethod
	public void lunchbrowser() {
		System.out.println("Before Method");
		driver.get("https://demo.nopcommerce.com/");
	}
	
	
	   @Test (priority = 1 )
	    public void testregistration() throws InterruptedException {
		   TestID ="NopT04";
		System.out.println("Test2");
		Thread.sleep(3000);
		Homepagetestclass.clickOnRegisterButton();
		
		Registrationpagetestclass.clickOnFemalebutton();
		

		Registrationpagetestclass.sendFname("vidula");
		Registrationpagetestclass.sendLname("shah");
		Registrationpagetestclass.SelectOnDateOfBirth("2");
		Registrationpagetestclass.SelectOnMonthOfBirth("March");
		Registrationpagetestclass.SelectOnYearOfBirth("2000");
		Registrationpagetestclass.sendemail("amruta.933@gmail.com");
		Registrationpagetestclass.sendcompany("Zebion infotech pvt ltd");
		Registrationpagetestclass.clickOnNewsletterbutton();
		Registrationpagetestclass.sendpassword("vidulashah@66");
		Registrationpagetestclass.sendconfirmpasswrd("vidulashah@66");
		Registrationpagetestclass.clickOnregisterbutton();
		
		//ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
	    //driver.switchTo().window(addr.get(0));
	}
		
		
	@Test (priority = 2 )
	public void testlogin() {
		TestID ="NopT05";
		System.out.println("Test4");
		
		Homepagetestclass.clickOnLoginButton();
        String email = Utility.getDataFromExcel(LoginNopCom, 1, 2);
		Loginpagetestclass.sendEmail(email);
		
		Loginpagetestclass.sendPassword();
		
		Loginpagetestclass.clickOnRememberme();
		
		Loginpagetestclass.clickOnLoginButton();
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
		Registrationpagetestclass= null;
		Loginpagetestclass = null;
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		driver.close();
		driver=null;
		System.gc();
	}
	

}
