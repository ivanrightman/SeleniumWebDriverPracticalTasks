package com.learning.selenium.tests;

import com.learning.selenium.app.Application;
import com.learning.selenium.driver.ChromeDriverFactory;
import com.learning.selenium.driver.CustomDriverDecorator;
import com.learning.selenium.driver.EdgeDriverFactory;
import com.learning.selenium.driver.FirefoxDriverFactory;
import com.learning.selenium.driver.IWebDriverFactory;
import com.learning.selenium.utils.Log;
import com.learning.selenium.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Listeners({TestListener.class})
public class BaseTest {

    private WebDriver driver;
    protected String envPropertyName = "local";
    public static TakesScreenshot takesScreenshot;
    public Actions actions;
    public Application app;

    @BeforeSuite
    public void start() {
        String browser = System.getProperty("browser", BrowserType.CHROME);
        String environment = System.getProperty("environment", envPropertyName);
        if ("".equals(environment) || "qa".equals(environment) || envPropertyName.equals(environment)) {
            if (browser.equals(BrowserType.FIREFOX)) {
                IWebDriverFactory factory = new FirefoxDriverFactory();
                driver = factory.createWebDriver();
            } else if (browser.equals(BrowserType.CHROME)) {
                IWebDriverFactory factory = new ChromeDriverFactory();
                driver = factory.createWebDriver();
                driver = new CustomDriverDecorator(driver);
            } else if (browser.equals(BrowserType.EDGE)) {
                IWebDriverFactory factory = new EdgeDriverFactory();
                driver = factory.createWebDriver();
            }
        } else {
            if (browser.equals(BrowserType.CHROME)) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.BROWSER_NAME, browser);
                chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, "MAC");
                IWebDriverFactory factory = new ChromeDriverFactory();
                try {
                    driver = factory.createRemoteWebDriver(environment, chromeOptions);
                } catch (MalformedURLException e) {
                    Log.error("Failed to create createRemoteWebDriver " + e);
                }
            } else {
                Log.debug("Unsupported browserName: " + browser);
                throw new IllegalArgumentException("Unsupported browserName: " + browser);
            }
        }
        app = new Application(driver, actions);
        takesScreenshot = (TakesScreenshot) driver;
    }

    @AfterSuite(enabled = true)
    public void stop() {
        driver.quit();
    }

    public boolean areElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public String getPageName() {
        return driver.getTitle();
    }

    public static Map<String, String> getKeyValuesFromWebElement(List<WebElement> webElements) {
        Map<String, String> keyValues = new HashMap<>();
        for (WebElement el : webElements) {
            String[] value = el.getText().split(":");
            if (value.length > 1) {
                keyValues.put(value[0].trim(), value[1].trim());
            }
        }
        return keyValues;
    }
}
