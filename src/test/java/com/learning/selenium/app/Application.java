package com.learning.selenium.app;

import com.learning.selenium.pages.google.GoogleCloudHeader;
import com.learning.selenium.pages.google.GoogleCloudMainPage;
import com.learning.selenium.pages.google.GoogleCloudPricingCalcPage;
import com.learning.selenium.pages.google.GoogleCloudSearchResultsPage;
import com.learning.selenium.pages.pastebin.PasteMainPage;
import com.learning.selenium.pages.yandex.YandexDiskPage;
import com.learning.selenium.pages.yandex.YandexLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Application {

    private final PasteMainPage pasteMainPage;
    private final GoogleCloudMainPage googleCloudMainPage;
    private final GoogleCloudHeader googleCloudHeader;
    private final GoogleCloudSearchResultsPage googleCloudSearchResultsPage;
    private final GoogleCloudPricingCalcPage googleCloudPricingCalcPage;
    private final YandexLoginPage yandexLoginPage;
    private final YandexDiskPage yandexDiskPage;

    public Application(WebDriver driver, Actions actions) {
        pasteMainPage = new PasteMainPage(driver);
        googleCloudMainPage = new GoogleCloudMainPage(driver);
        googleCloudHeader = new GoogleCloudHeader(driver);
        googleCloudSearchResultsPage = new GoogleCloudSearchResultsPage(driver);
        googleCloudPricingCalcPage = new GoogleCloudPricingCalcPage(driver);
        yandexLoginPage = new YandexLoginPage(driver);
        actions = new Actions(driver);
        yandexDiskPage = new YandexDiskPage(driver, actions);
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

    public YandexLoginPage yandexLoginPage() {
        return yandexLoginPage;
    }

    public YandexDiskPage yandexDiskPage() {
        return yandexDiskPage;
    }
}
