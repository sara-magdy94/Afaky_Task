package Tests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.ExtentReports.reporter.extentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPase {


	public static WebDriver driver;
	public static   ExtentReports	extent;
	public static ExtentHtmlReporter htmlReporter;


	@BeforeSuite
	public void startDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/ChromeDriversLatest/chromedriver.exe");


		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		htmlReporter = new ExtentHtmlReporter("extentreport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("Create Account successfully then logout" );
		test1.log(Status.INFO, "Starting TesCase");
		ExtentTest test2 = extent.createTest("open registration page" ); 
		test2.pass(" open registration page ");
		test2.log(Status.INFO, "open registration page");		
		ExtentTest test3 = extent.createTest("fill data in registration page" ); 
		test3.pass("Data Filled successfully");
		ExtentTest test4 = extent.createTest("navigate to registration page" ); 
	 test4.pass("User user navigated to registration page successfully");
		ExtentTest test5 = extent.createTest("User Can Logout" ); 
		 test5.pass("User logged out successfully");
		 ExtentTest test6 = extent.createTest("User Can LogIn" ); 
			test6.pass("User logged in successfully");
			ExtentTest test7 = extent.createTest("User Can Logout Again" ); 
			 test7.pass("User logged out successfully");
	}
	
	
@AfterClass
	public void flushReport() {
		
		extent.flush();
	}



	@AfterSuite
	public void stopDriver() {
		driver.quit();	
		extent.flush();
	}
}
