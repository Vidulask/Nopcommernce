package testclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pomclassnopcom.homepagetestclass;
import Pomclassnopcom.loginpagetestclass;
import Pomclassnopcom.registrationpagetestclass;

public class verificationforregisterpage {

public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\automation\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriver driverTest = new ChromeDriver();
		
		driverTest.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driverTest.manage().window().maximize();
		
		driverTest.get("https://demo.nopcommerce.com/");
		
		homepagetestclass Homepagetestclass = new homepagetestclass(driverTest);
		Homepagetestclass.clickOnRegisterButton();
		
		registrationpagetestclass Registrationpagetestclass = new registrationpagetestclass(driverTest);
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
		
     }
}
