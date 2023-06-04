package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);

	}


// Sign in link element locator
	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	WebElement RegisterLink;
	
	// Sign out link element locator
	@FindBy(xpath = "(//a[normalize-space()='Logout'])[1]")
	WebElement LogOutLink;
	
	
	//open registration page 
	public void OpenRegisterationPage() {
	
		RegisterLink.click();
	}
	
	// user can log out 
	public void userCanLogot() {
		
		LogOutLink.click();
	}
	
	
}
//"//a[(@href,'https://automationexercise.com/login')]"