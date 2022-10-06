package com.learning.selenium.pages;

import com.learning.selenium.utils.LocatorHelper;
import com.learning.selenium.utils.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final int WAIT_TIMEOUT_SECONDS = 15;
    protected Actions actions;
    protected JavascriptExecutor jsExecutor;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriver driver, Actions actions) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        PageFactory.initElements(driver, this);
        this.actions = actions;
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    protected abstract void open();

    protected WebElement getElementByTwoSteps(By locatorOne, By locatorTwo) {
        WebElement elementOne = getElement(locatorOne);
        return elementOne.findElement(locatorTwo);
    }

    protected WebElement getElement(By locator) {
        Log.info(String.format("Getting this element %s", locator));
        return driver.findElement(locator);
    }

    protected List<WebElement> getElementsByTwoSteps(By locatorOne, By locatorTwo) {
        Log.info(String.format("Getting this element %s from that element %s", locatorTwo, locatorOne));
        WebElement elementOne = getElement(locatorOne);
        return elementOne.findElements(locatorTwo);
    }

    protected void click(By locator) {
        waitUntilElementClickable(getElement(locator));
        Log.info(String.format("Click on the element with locator %s", locator));
        getElement(locator).click();
    }

    protected void click(WebElement element) {
        Log.info(String.format("Click on the %s", element));
        waitUntilElementClickable(element);
        element.click();
    }

    protected void fillInputField(By locator, String text) {
        Log.info(String.format("Filling field with locator %s with value %s", locator, text));
        click(locator);
        if (text != null){
            String existingText = getElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                getElement(locator).clear();
                getElement(locator).sendKeys(text);
            }
        }
    }

    protected void fillInputField(WebElement one, String text, Keys keys) {
        Log.info(String.format("Filling field %s with value %s and sendKeys", one, text, keys));
        waitUntilElementClickable(one);
        one.click();
        if (text != null){
            String existingText = one.getAttribute("value");
            if (!text.equals(existingText)) {
                one.clear();
                if (keys == null) {
                    one.sendKeys(text);
                } else {
                    one.sendKeys(text + keys);
                }
            }
        }
    }

    protected void selectOption(By selectLocator, String optionLocator, String first) {
        Log.info(String.format("Selecting option %s by locator %s in select by locator %s", first, optionLocator, selectLocator));
        click(selectLocator);
        click(LocatorHelper.getLocatorFromOneValue(optionLocator, first));
    }

    protected void selectOptionSpecific(By selectLocator, String optionLocator, String first, String second) {
        Log.info(String.format("Selecting option %s by locator %s in select by locator %s", second, optionLocator, selectLocator));
        click(selectLocator);
        click(LocatorHelper.getLocatorFromTwoValues(optionLocator, first, second));
    }

    protected void selectOptionByIndex(By selectLocator, String optionLocator, String first, int index) {
        Log.info(String.format("Selecting option %s with index %s by locator %s in select by locator %s", first, index, optionLocator, selectLocator));
        click(selectLocator);
        List<WebElement> options = driver.findElements(LocatorHelper.getLocatorFromOneValue(optionLocator, first));
        options.get(index).click();
    }

    public void waitUntilElementClickable(WebElement element) {
        Log.info(String.format("Waiting for the element to be clickable %s", element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilFrameAndSwitch(By locator) {
        Log.info(String.format("Waiting for the frame and switch %s", locator));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public Object executeJavaScript(String jsCode, WebElement element) {
        Log.info(String.format("Executing javascript %s <endOfScript> on the %s element", jsCode, element));
        return jsExecutor.executeScript(jsCode, element);
    }

    public void highlightElementJs(WebElement element) {
        Log.info(String.format("Highlighting element %s", element));
        executeJavaScript("arguments[0].style.backgroundColor='" + "yellow" + "'", element);
    }

    public void clickOnElementJs(WebElement element) {
        Log.info(String.format("Clicking on element using javascript %s", element));
        executeJavaScript("arguments[0].click()", element);
    }
}
