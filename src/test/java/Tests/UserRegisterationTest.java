package Tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.javafaker.Faker;

import Pages.HomePage;
import Pages.PageBase;
import Pages.UserRegisterationPage;

import org.testng.annotations.Test;
public class UserRegisterationTest extends TestPase {




	HomePage homeObject;
	UserRegisterationPage registerationObject;


	Faker fakeData = new Faker();
	String Name = fakeData.name().fullName();
	String FirstName = fakeData.name().firstName();
	String LastName = fakeData.name().lastName();
	String MobileNum = fakeData.phoneNumber().cellPhone();
	String ZipCode = fakeData.address().zipCode();
	String Email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(8).toString();
	int Day = fakeData.number().numberBetween(1, 30);
	int Month = fakeData.number().numberBetween(1, 12);
	int Year = fakeData.number().numberBetween(2010, 2021);


	String city = fakeData.address().city();
	String State = fakeData.address().state();
	String Country = fakeData.address().country();
	String Address1 = fakeData.address().fullAddress();


	@Test (priority = 1)
	public void UserCanRegisterSuccessfully() throws Throwable {
		homeObject = new HomePage(driver);
		registerationObject = new UserRegisterationPage(driver);
		
		//navigate to registeration page 
		homeObject.OpenRegisterationPage();

		//fill all fields in sign up page
		registerationObject.UserRegisteration(Name,Email, password , Day ,Month , FirstName , LastName , city , State , Address1  , ZipCode , MobileNum );

		//click on create account btn and assert on successful msg shown
		 registerationObject.click_on_Create_accoutn(driver);
	}

	@Test (priority = 2)
		 public void UserCanLogin_And_LogOutSuccessfully() 
		 {
		//navigate to registeration page 
			homeObject.OpenRegisterationPage();
		
			//click on logout btn
		homeObject.userCanLogot();
			
		// try to sign in 
		registerationObject.UserCanlogin(Email, password);
		
		//print out user data
		System.out.println("the user Data is: " + Name + "\n" + Email + "\n" + FirstName + "\n"  + LastName + "\n" + city + "\n" + State + "\n" + Country + "\n" + ZipCode + "\n" + MobileNum + "\n");

		//click on logout btn again
		homeObject.userCanLogot();
		
		//print out the current title in last page after sign out
		System.out.println("Current title is: " + driver.getCurrentUrl() + "\n" + "current URl is : " + ""  + driver.getCurrentUrl());
		System.out.println("User Logged Out!");
		
		

	}



}
