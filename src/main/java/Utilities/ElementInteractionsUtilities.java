package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.interactions.Actions;
//import com.aventstack.extentreports.extenttest;

public class ElementInteractionsUtilities {
	
	

    //Handling Conditions Of WebDriver Waiting (Visibility)
    public WebElement waitForElementVisibility(WebDriverWait wait, By by) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public WebElement waitForWebElementVisibility(WebDriverWait wait, WebElement element) {

        return wait.until(ExpectedConditions.visibilityOf(element));

    }

    //Handling Conditions Of WebDriver Waiting (Clickable)
    public WebElement waitForElementToBeClickable(WebDriverWait wait, By by) {

        return wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    public WebElement waitForWebElementToBeClickable(WebDriverWait wait, WebElement element) {

        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    //Handling Conditions Of WebDriver Waiting (Presence)
    public WebElement waitForElementToBePresent(WebDriverWait wait, By by) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    //Handling Conditions Of WebDriver Waiting (Invisibility)
    public boolean waitForElementInvisibility(WebDriverWait wait, By by) {

        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

    }

    //Send Text
    public void sendKeysToElement(WebDriver driver, WebDriverWait wait, By by, String text) {

        //scrollToElement (driver, by);
        waitForElementToBePresent(wait, by);
        waitForElementVisibility(wait, by).sendKeys(text);

    }

    public void sendKeysToElementWithoutScroll(WebDriver driver, WebDriverWait wait, By by, String text) {

        waitForElementToBePresent(wait, by);
        waitForElementVisibility(wait, by).sendKeys(text);

    }
    //Click An Element
    public void clickOnElement(WebDriver driver, WebDriverWait wait, By by) {

       // scrollToElement (driver, by);
        waitForElementToBePresent(wait, by);
        waitForElementToBeClickable(wait, by);
        waitForElementVisibility(wait, by).click();

    }
}
