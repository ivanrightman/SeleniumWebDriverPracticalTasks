package com.learning.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final int WAIT_TIMEOUT_SECONDS = 15;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        PageFactory.initElements(driver, this);
    }

    protected abstract void open();

    protected WebElement getElementByTwoSteps(By locatorOne, By locatorTwo) {
        WebElement elementOne = getElement(locatorOne);
        return elementOne.findElement(locatorTwo);
    }

    protected WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> getElementsByTwoSteps(By locatorOne, By locatorTwo) {
        WebElement elementOne = getElement(locatorOne);
        return elementOne.findElements(locatorTwo);
    }

    protected void click(By locator) {
        waitUntilElementClickable(getElement(locator));
        getElement(locator).click();
    }

    protected void fillInputField(By locator, String text) {
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
        click(selectLocator);
        click(LocatorHelper.getLocatorFromOneValue(optionLocator, first));
    }

    protected void selectOptionSpecific(By selectLocator, String optionLocator, String first, String second) {
        click(selectLocator);
        click(LocatorHelper.getLocatorFromTwoValues(optionLocator, first, second));
    }

    protected void selectOptionByIndex(By selectLocator, String optionLocator, String first, int index) {
        click(selectLocator);
        List<WebElement> options = driver.findElements(LocatorHelper.getLocatorFromOneValue(optionLocator, first));
        options.get(index).click();
    }

    public void waitUntilElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilFrameAndSwitch(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
}
