package com.learning.selenium.tests;

import com.learning.selenium.model.ComputeEngine;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class GoogleCloudTests extends BaseTest {

    @Test
    public void computeEngineTest() {
        ComputeEngine computeEngine = new ComputeEngine()
                .withNumberOfInstances("4")
                .withOperatingSystem("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL")
                .withProvisioningModel("Regular")
                .withSeries("N1")
                .withMachineType("n1-standard-8")
                .withGpuType("NVIDIA Tesla V100")
                .withNumberOfGpus("1")
                .withLocalSsd("2x375")
                .withDataCenterLocation("Frankfurt")
                .withCommitedUsage("1 Year");
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