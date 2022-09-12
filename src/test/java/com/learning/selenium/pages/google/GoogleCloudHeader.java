package com.learning.selenium.pages.google;

import com.learning.selenium.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHeader extends BasePage {

    @FindBy(className = "devsite-top-logo-row")
    private WebElement header;
    @FindBy(css = "[name=q]")
    private WebElement searchButton;

    public GoogleCloudHeader(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void open() {
    }

    public void search(String text) {
        fillInputField(searchButton, text, Keys.ENTER);
    }
}
