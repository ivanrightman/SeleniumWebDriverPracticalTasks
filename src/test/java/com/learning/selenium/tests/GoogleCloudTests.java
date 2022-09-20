package com.learning.selenium.tests;

import com.learning.selenium.model.ComputeEngine;
import com.learning.selenium.testdata.ComputeEngineCreator;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class GoogleCloudTests extends BaseTest {

    @Test
    public void computeEngineTest() {
        ComputeEngine computeEngine = ComputeEngineCreator.computeEngineFromProperty(envPropertyName);
        String search = "Google Cloud Pricing Calculator";
        app.googleCloudMainPage().open();
        app.googleCloudHeader().search(search);
        app.googleCloudSearchResultsPage().searchResultClick(search);
        app.googleCloudPricingCalcPage().activateComputeEngine();
        app.googleCloudPricingCalcPage().fillComputeEngine(computeEngine);
        app.googleCloudPricingCalcPage().addToEstimate();
        List<WebElement> currentEstimateRows = app.googleCloudPricingCalcPage().getEstimateRows();
        Map<String, String> currentEstimateRowsMap = getKeyValuesFromWebElement(currentEstimateRows);
        String expectedPrice = "1,288.70";
        assertTrue(currentEstimateRowsMap.get("Provisioning model").contains(computeEngine.getProvisioningModel()));
        assertTrue(currentEstimateRowsMap.get("Instance type").contains(computeEngine.getMachineType()));
        assertTrue(currentEstimateRowsMap.get("Region").contains(computeEngine.getDataCenterLocation()));
        assertTrue(currentEstimateRowsMap.get("Local SSD").contains(computeEngine.getLocalSsd()));
        assertTrue(currentEstimateRowsMap.get("Estimated Component Cost").contains(expectedPrice));
    }
}
