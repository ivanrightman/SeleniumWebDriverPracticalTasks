package com.learning.selenium.pages.google;

import com.learning.selenium.pages.BasePage;
import com.learning.selenium.utils.LocatorHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.learning.selenium.utils.Log.info;


public class GoogleCloudSearchResultsPage extends BasePage {

    @FindBy(css = "[class=gsc-resultsbox-visible]")
    private WebElement searchResultsBlock;
    @FindBy(css = "a.gs-title b")
    private WebElement searchResultsList;
    private final String searchBaseLocator = "//b[contains(text(), '%s')]";

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void open() {
    }

    public void searchResultClick(String text) {
        info(String.format("Click on %s", text));
        waitUntilElementClickable(searchResultsBlock);
        WebElement searchFound = searchResultsList.findElement(LocatorHelper.getLocatorFromOneValue(searchBaseLocator, text));
        click(searchFound);
    }
}
