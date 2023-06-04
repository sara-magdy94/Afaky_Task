package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByClassName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//import Tests.TestPase;
import Utilities.ElementInteractionsUtilities;

public class UserRegisterationPage extends PageBase {

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
		
	}

	// NameTxtBox field locator
	@FindBy(name = "name")
		WebElement NameTxtBox;

	// SignUpEmailTxtBox field locator
	@FindBy(xpath = "(//input[@data-qa='signup-email'])[1]")
	WebElement SignUpEmailTxtBox;
	
	// SignInPasswordlTxtBox field locator
	@FindBy(xpath = "(//input[@data-qa='login-password'])[1]")
	WebElement SignInPasswordlTxtBox;
	
	// loginEmailTxtBox field locator
	@FindBy(xpath = "(//input[@data-qa='login-email'])[1]")
	WebElement loginEmailTxtBox;
	
	//SignUpBtn locator
	@FindBy(xpath = "(//button[normalize-space()='Signup'])[1]")
	WebElement SignUpBtn;
	
	//LoginBtn locator
	@FindBy(xpath = "//button[@data-qa='login-button']")
	WebElement LoginBtn;
	
	//GenderBtn locator
	@FindBy(id = "id_gender2")
	WebElement GenderBtn;
	
	//PasswordTxt field locator
	@FindBy(id = "password")
	WebElement PasswordTxt;
	
	//Days dropdown value locator
	@FindBy(id = "days")
	WebElement Days;
	
	//Months dropdown value locator
	@FindBy(id = "months")
	WebElement Months;
	
	//Years dropdown value locator
	@FindBy(id = "years")
	WebElement Years;
	
	// first_name field locator
	@FindBy(id = "first_name")
	WebElement first_name;
	
	// last_name field locator
	@FindBy(id = "last_name")
	WebElement last_name;
	
	// address1 text field locator
	@FindBy(id = "address1")
	WebElement address1;
	
	//Country dropdown value locator
	@FindBy(id = "country")
	WebElement country;
	
	//state field locator
	@FindBy(id = "state")
	WebElement state;
	
	//city field locator
	@FindBy(id = "city")
	WebElement city;
	
	//zipcode field locator
	@FindBy(id = "zipcode")
	WebElement zipcode;
	
	//mobile_number field locator
	@FindBy(id = "mobile_number")
	WebElement mobile_number;
	
	//Create Account Btn locator
	@FindBy(xpath = "//button[contains(text(),'Create Account')]")
	WebElement CreateAccountBtn;
		
	public void UserRegisteration( String Name ,String Email , String Password ,int Day, int Month , String FirstName , String LastName , String Address1 , String State , String City, String Zipcode , String MobileNumber) {
		
		SetTextElementText(NameTxtBox , Name);
		SetTextElementText(SignUpEmailTxtBox , Email);
		Clickbtn(SignUpBtn);
		Clickbtn(GenderBtn);
		SetTextElementText(PasswordTxt , Password);
		selectIndexFromDropDown(Days , Day);
		selectIndexFromDropDown(Months , Month);
		selectValueFromDropDown(Years , "2021");
		SetTextElementText(first_name , FirstName);
		SetTextElementText(last_name , LastName);
		SetTextElementText(address1 , Address1);
		SetTextElementText(country , "Canada");
		SetTextElementText(state , State);
		SetTextElementText(city , City);
		SetTextElementText(zipcode , Zipcode);
		SetTextElementText(mobile_number , MobileNumber);
	
		
	}
	
	
	public void click_on_Create_accoutn(WebDriver driver ) throws Throwable {
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		WebDriverWait wait = new WebDriverWait(driver,(100));
			wait.until(ExpectedConditions.elementToBeClickable(CreateAccountBtn));
			CreateAccountBtn.click();
			WebElement Success_msg = driver.findElement(By.xpath("(//h2[@data-qa='account-created'])"));
			
			//assert on success msg shown
			Assert.assertEquals(Success_msg.getText() , "ACCOUNT CREATED!");
			System.out.println(Success_msg.getText());
	}
	
	
	
	public void UserCanlogin(String Email , String Password ) {
		SetTextElementText(loginEmailTxtBox , Email);
		SetTextElementText(SignInPasswordlTxtBox , Password);
		Clickbtn(LoginBtn);
		
		
	}
	

	}
	
