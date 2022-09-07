package com.learning.selenium.pages.google;

import com.learning.selenium.model.ComputeEngine;
import com.learning.selenium.pages.BasePage;
import com.learning.selenium.pages.LocatorHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleCloudPricingCalcPage extends BasePage {

    public GoogleCloudPricingCalcPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void open() {
        driver.get("https://cloud.google.com/products/calculator");
    }

    private final By outerIframeLocator = By.xpath("//iframe[starts-with(@src, '/products/calculator/')]");
    private final By innerIframeLocator = By.cssSelector("[id=myFrame]");

    @FindBy(css = "div[title='Compute Engine']")
    private WebElement computeEngine;
    private final String inputFieldBaseLocator = "//label[contains(.,'%s')]/../input";
    private final String selectFieldBaseLocator = "//md-select[@ng-model='%s']";
    private final String selectOptionBaseLocator = ".//md-option//div[contains(., '%s')]";
    private final String selectOptionBaseLocatorSpecific = "//md-option[@*[contains(.,'%s')]]//div[contains(., '%s')]";

    private final By numberOfInstancesField = LocatorHelper.getLocatorFromOneValue(inputFieldBaseLocator, "Number of instances");
    private final By whatAreInstancesField = LocatorHelper.getLocatorFromOneValue(inputFieldBaseLocator, "What are these instances for?");
    private final String operatingSystemUnique = "listingCtrl.computeServer.os";
    private final By operatingSystem =  LocatorHelper.getLocatorFromOneValue(selectFieldBaseLocator, operatingSystemUnique);
    private final String provisioningModelUnique = "listingCtrl.computeServer.class";
    private final By provisioningModel = LocatorHelper.getLocatorFromOneValue(selectFieldBaseLocator, provisioningModelUnique);
    private final String seriesUnique = "listingCtrl.computeServer.series";
    private final By series = LocatorHelper.getLocatorFromOneValue(selectFieldBaseLocator, seriesUnique);
    private final String machineTypeUnique = "listingCtrl.computeServer.instance";
    private final By machineType = LocatorHelper.getLocatorFromOneValue(selectFieldBaseLocator, machineTypeUnique);

    @FindBy(xpath = "//*[contains(@aria-label, 'Add GPUs')]")
    private WebElement addGpus;
    private final String gpuTypeUnique = "listingCtrl.computeServer.gpuType";
    private final By gpuType = LocatorHelper.getLocatorFromOneValue(selectFieldBaseLocator, gpuTypeUnique);
    private final String numberOfGpusUnique = "listingCtrl.computeServer.gpuCount";
    private final By numberOfGpus = LocatorHelper.getLocatorFromOneValue(selectFieldBaseLocator, numberOfGpusUnique);
    private final String localSsdUnique = "listingCtrl.computeServer.ssd";
    private final By localSsd = LocatorHelper.getLocatorFromOneValue(selectFieldBaseLocator, localSsdUnique);
    private final String dataCenterLocationUnique = "listingCtrl.computeServer.location";
    private final String dataCenterLocationSelect = "computeServer";
    private final By dataCenterLocation = LocatorHelper.getLocatorFromOneValue(selectFieldBaseLocator, dataCenterLocationUnique);
    private final String commitedUsageUnique = "listingCtrl.computeServer.cud";
    private final By commitedUsage = LocatorHelper.getLocatorFromOneValue(selectFieldBaseLocator, commitedUsageUnique);

    @FindBy(xpath = "//*[contains(@aria-label, 'Add to Estimate')]")
    private WebElement addToEstimateButton;
    private By estimateSection = By.cssSelector(".cartitem");
    private By estimateSectionRows = By.cssSelector(".md-1-line");

    public GoogleCloudPricingCalcPage fillComputeEngine(ComputeEngine data) {
        //waitUntilFrameAndSwitch(outerIframeLocator);
        //waitUntilFrameAndSwitch(innerIframeLocator);
        fillInputField(numberOfInstancesField, data.getNumberOfInstances());
        fillInputField(whatAreInstancesField, data.getWhatAreInstances());
        selectOption(operatingSystem, selectOptionBaseLocator, data.getOperatingSystem());
        selectOption(provisioningModel, selectOptionBaseLocator, data.getProvisioningModel());
        selectOption(series, selectOptionBaseLocator, data.getSeries());
        selectOption(machineType, selectOptionBaseLocator, data.getMachineType());
        addGpus.click();
        selectOption(gpuType, selectOptionBaseLocator, data.getGpuType());
        selectOptionSpecific(numberOfGpus, selectOptionBaseLocatorSpecific, gpuTypeUnique, data.getNumberOfGpus());
        selectOption(localSsd, selectOptionBaseLocator, data.getLocalSsd());
        selectOptionSpecific(dataCenterLocation, selectOptionBaseLocatorSpecific, dataCenterLocationSelect, data.getDataCenterLocation());
        selectOptionByIndex(commitedUsage, selectOptionBaseLocator, data.getCommitedUsage(), 1);
        return this;
    }

    public GoogleCloudPricingCalcPage addToEstimate() {
        addToEstimateButton.click();
        return this;
    }

    public GoogleCloudPricingCalcPage activateComputeEngine() {
        waitUntilFrameAndSwitch(outerIframeLocator);
        waitUntilFrameAndSwitch(innerIframeLocator);
        computeEngine.click();
        return this;
    }

    public List<WebElement> getEstimateRows() {
        return getElementsByTwoSteps(estimateSection, estimateSectionRows);
    }
}
