package com.learning.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class EdgeDriverFactory implements IWebDriverFactory {
    @Override
    public WebDriver createWebDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    @Override
    public RemoteWebDriver createRemoteWebDriver(String environment, ChromeOptions chromeOptions) {
        return null;
    }
}
