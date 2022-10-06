package com.learning.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public interface IWebDriverFactory {
    WebDriver createWebDriver();

    RemoteWebDriver createRemoteWebDriver(String environment, ChromeOptions chromeOptions) throws MalformedURLException;

}
