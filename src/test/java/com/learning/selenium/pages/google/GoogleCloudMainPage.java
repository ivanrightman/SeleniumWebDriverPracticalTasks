package com.learning.selenium.pages.google;

import com.learning.selenium.pages.BasePage;
import com.learning.selenium.utils.Log;
import org.openqa.selenium.WebDriver;

public class GoogleCloudMainPage extends BasePage {

    private static final String MAINPAGE_URL = "https://cloud.google.com/";

    public GoogleCloudMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        Log.info(String.format("Open %s page", MAINPAGE_URL));
        driver.get(MAINPAGE_URL);
    }
}
