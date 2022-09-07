package com.learning.selenium.app;

import com.learning.selenium.pages.google.GoogleCloudHeader;
import com.learning.selenium.pages.google.GoogleCloudMainPage;
import com.learning.selenium.pages.google.GoogleCloudPricingCalcPage;
import com.learning.selenium.pages.google.GoogleCloudSearchResultsPage;
import com.learning.selenium.pages.pastebin.PasteMainPage;
import com.learning.selenium.pages.yandex.YandexDiskPage;
import com.learning.selenium.pages.yandex.YandexLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Application {

    public WebDriver driver;
    public Actions actions;
    private PasteMainPage pasteMainPage;
    private GoogleCloudMainPage googleCloudMainPage;
    private GoogleCloudHeader googleCloudHeader;
    private GoogleCloudSearchResultsPage googleCloudSearchResultsPage;
    private GoogleCloudPricingCalcPage googleCloudPricingCalcPage;
    private YandexLoginPage yandexLoginPage;
    private YandexDiskPage yandexDiskPage;

    public Application(String browser, String seleniumServer) {
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
        pasteMainPage = new PasteMainPage(driver);
        googleCloudMainPage = new GoogleCloudMainPage(driver);
        googleCloudHeader = new GoogleCloudHeader(driver);
        googleCloudSearchResultsPage = new GoogleCloudSearchResultsPage(driver);
        googleCloudPricingCalcPage = new GoogleCloudPricingCalcPage(driver);
        yandexLoginPage = new YandexLoginPage(driver);
        actions = new Actions(driver);
        yandexDiskPage = new YandexDiskPage(driver, actions);
    }

    public void stop() {
        driver.quit();
    }

    public PasteMainPage pasteMainPage() {
        return pasteMainPage;
    }

    public GoogleCloudMainPage googleCloudMainPage() {
        return googleCloudMainPage;
    }

    public GoogleCloudHeader googleCloudHeader() {
        return googleCloudHeader;
    }

    public GoogleCloudSearchResultsPage googleCloudSearchResultsPage() {
        return googleCloudSearchResultsPage;
    }

    public GoogleCloudPricingCalcPage googleCloudPricingCalcPage() {
        return googleCloudPricingCalcPage;
    }

    public YandexLoginPage yandexLoginPage() {
        return yandexLoginPage;
    }

    public YandexDiskPage yandexDiskPage() {
        return yandexDiskPage;
    }
}
