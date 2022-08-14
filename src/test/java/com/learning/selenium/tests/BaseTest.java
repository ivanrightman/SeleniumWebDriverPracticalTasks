package com.learning.selenium.tests;

import com.learning.selenium.app.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseTest {

    public Application app;

    @BeforeSuite
    public void start() {
        app = new Application();
    }

    @AfterSuite (enabled = true)
    public void stop() {
        app.stop();
    }

    public boolean areElementsPresent(By locator) {
        return app.driver.findElements(locator).size() > 0;
    }

    public String getPageName() {
        return app.driver.getTitle();
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