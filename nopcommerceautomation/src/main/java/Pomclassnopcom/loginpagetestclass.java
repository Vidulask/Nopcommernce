package Pomclassnopcom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpagetestclass {
	
	@FindBy (xpath = "//input[@id='Email']") 
    private WebElement Email ;
	
	@FindBy (xpath = "//input[@id='Password']") 
    private WebElement Password ;

	@FindBy (xpath = "//input[@id='RememberMe']") //input[@id='RememberMe']
    private WebElement Rememberme ;
	
	@FindBy (xpath = "//button[text()='Log in']") //a[text()='Log in']
    private WebElement Login ;

	
	//Constructor
  	public loginpagetestclass (WebDriver driver)       //driver =driverTest = new ChromeDriver()
  	{
  		PageFactory.initElements(driver, this);
  	}
  	
  	//method
  	public void sendEmail(String email) {
  		Email.sendKeys(email);
  	}
  	
  	public void sendPassword() {
  		Password.sendKeys("vidulashah@66");
  	}
  	
  	public void clickOnRememberme() {
  		Rememberme.click();
	}
    
  	public void clickOnLoginButton() {
  		Login.click();
	}
  	
  	
}
