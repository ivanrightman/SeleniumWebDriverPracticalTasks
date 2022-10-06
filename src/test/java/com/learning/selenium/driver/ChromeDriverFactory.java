package com.learning.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverFactory implements IWebDriverFactory {

    @Override
    public WebDriver createWebDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Override
    public RemoteWebDriver createRemoteWebDriver(String environment, ChromeOptions chromeOptions) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        return new RemoteWebDriver(new URL(environment), chromeOptions);
    }
}
