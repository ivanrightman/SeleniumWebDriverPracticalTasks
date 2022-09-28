package com.learning.selenium.tests;

import com.learning.selenium.app.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseTest {

    public WebDriver driver;
    public Actions actions;
    public Application app;

    @BeforeSuite
    public void start() {
        String browser = BrowserType.CHROME;
        String seleniumServer = "http://localhost:4444/wd/hub";
        if ("".equals(seleniumServer)) {
            if (browser.equals(BrowserType.FIREFOX)){
                driver = new FirefoxDriver();
            } else if (browser.equals(BrowserType.CHROME)) {
                driver = new ChromeDriver();
            } else if (browser.equals(BrowserType.EDGE)) {
                driver = new EdgeDriver();
            }
        } else {
            if (browser.equals(BrowserType.CHROME)) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.BROWSER_NAME, browser);
                chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, "MAC");
                try {
                    driver = new RemoteWebDriver(new URL(seleniumServer), chromeOptions);
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
            } else {
                throw new IllegalArgumentException("Unsupported browserName: " + browser);
            }
        }
        app = new Application(driver, actions);
    }

    @AfterSuite (enabled = true)
    public void stop() {
        driver.quit();
    }

    public boolean areElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public String getPageName() {
        return driver.getTitle();
    }

    public Map<String, String> getKeyValuesFromWebElement(List<WebElement> webElements) {
        Map<String, String>  keyValues = new HashMap<>();
        for (WebElement el : webElements) {
            String[] value = el.getText().split(":");
            if (value.length > 1) {
                keyValues.put(value[0].trim(), value[1].trim());
            }
        }
        return keyValues;
    }
}
