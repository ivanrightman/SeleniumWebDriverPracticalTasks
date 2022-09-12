package com.learning.selenium.pages.google;

import com.learning.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class GoogleCloudMainPage extends BasePage {

    private static final String MAINPAGE_URL = "https://cloud.google.com/";

    public GoogleCloudMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(MAINPAGE_URL);
    }
}
