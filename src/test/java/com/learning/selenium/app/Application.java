package com.learning.selenium.app;

import com.learning.selenium.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {

    public WebDriver driver;
    private PasteMainPage pasteMainPage;
    private GoogleCloudMainPage googleCloudMainPage;
    private GoogleCloudHeader googleCloudHeader;
    private GoogleCloudSearchResultsPage googleCloudSearchResultsPage;
    private GoogleCloudPricingCalcPage googleCloudPricingCalcPage;

    public Application() {
        driver = new ChromeDriver();
        pasteMainPage = new PasteMainPage(driver);
        googleCloudMainPage = new GoogleCloudMainPage(driver);
        googleCloudHeader = new GoogleCloudHeader(driver);
        googleCloudSearchResultsPage = new GoogleCloudSearchResultsPage(driver);
        googleCloudPricingCalcPage = new GoogleCloudPricingCalcPage(driver);
    }

    public void stop() {
        driver.quit();
    }

    public PasteMainPage pasteMainPage() {
        return pasteMainPage;
    }

    public GoogleCloudMainPage googleCloudMainPage() {
        return googleCloudMainPage;
    }
    public GoogleCloudHeader googleCloudHeader() {
        return googleCloudHeader;
    }

    public GoogleCloudSearchResultsPage googleCloudSearchResultsPage() {
        return googleCloudSearchResultsPage;
    }

    public GoogleCloudPricingCalcPage googleCloudPricingCalcPage() {
        return googleCloudPricingCalcPage;
    }
}
