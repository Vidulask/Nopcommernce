package testclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pomclassnopcom.homepagetestclass;

public class VerificationofShoppingcartPage {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\automation\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriver driverTest = new ChromeDriver();
		
		driverTest.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driverTest.manage().window().maximize();
		
		driverTest.get("https://demo.nopcommerce.com/");
		
		homepagetestclass Homepagetestclass = new homepagetestclass(driverTest);
		
	}
	
}
