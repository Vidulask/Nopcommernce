package testclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pomclassnopcom.homepagetestclass;
import Pomclassnopcom.loginpagetestclass;

public class verificationforloginpage {
	
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\automation\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriver driverTest = new ChromeDriver();
		
		driverTest.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driverTest.manage().window().maximize();
		
		driverTest.get("https://demo.nopcommerce.com/");
		
		homepagetestclass Homepagetestclass = new homepagetestclass(driverTest);
		
		Homepagetestclass.clickOnLoginButton();
		
		loginpagetestclass Loginpagetestclass = new loginpagetestclass(driverTest);
		
		Loginpagetestclass.sendEmail();
		
		Loginpagetestclass.sendPassword();
		
		Loginpagetestclass.clickOnRememberme();
		
		Loginpagetestclass.clickOnLoginButton();
		
         }
}
