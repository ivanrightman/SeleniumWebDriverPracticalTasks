package com.learning.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class FirefoxDriverFactory implements IWebDriverFactory {
    @Override
    public WebDriver createWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @Override
    public RemoteWebDriver createRemoteWebDriver(String environment, ChromeOptions chromeOptions) {
        return null;
    }
}
