package com.learning.selenium.pages.google;

import com.learning.selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleCloudSearchResultsPage extends BasePage {

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void open() {
    }

    @FindBy(css = "[class=gsc-resultsbox-visible]")
    private WebElement searchResultsBlock;

    @FindBy(css = "a.gs-title b")
    private List<WebElement> searchResultsList;

    public void searchResultClick(String text) {
        waitUntilElementClickable(searchResultsBlock);
        for (WebElement el : searchResultsList) {
            if (el.getText().equals(text)) {
                el.click();
                break;
            }
        }
    }
}
