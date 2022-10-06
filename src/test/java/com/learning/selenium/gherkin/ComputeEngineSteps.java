package com.learning.selenium.gherkin;

import com.learning.selenium.model.ComputeEngine;
import com.learning.selenium.testdata.ComputeEngineCreator;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static com.learning.selenium.gherkin.DriverHook.app;
import static com.learning.selenium.tests.BaseTest.getKeyValuesFromWebElement;
import static org.testng.Assert.assertTrue;

public class ComputeEngineSteps {


  @When("^user opens google cloud pricing calculator$")
  public void openComputeEngineCalculator() {
    app.googleCloudPricingCalcPage().open();
  }

  @When("^user fills compute engine$")
  public void fillComputeEngine() {
    ComputeEngine computeEngine = ComputeEngineCreator.getComputeEngineInstance();
    app.googleCloudPricingCalcPage().activateComputeEngine();
    app.googleCloudPricingCalcPage().fillComputeEngine(computeEngine);
  }

  @When("^user adds to estimate$")
  public void addToEstimate() {
    app.googleCloudPricingCalcPage().addToEstimate();
  }

  // ================== Validations ==================

  @Then("^user verifies price is (.+)$")
  public void verifyPriceIs(String price) {
    Map<String, String> currentEstimateRowsMap = getCurrentEstimateRows();
    assertTrue(currentEstimateRowsMap.get("Estimated Component Cost").contains(price));
  }

  @Then("^user verifies (.+) tabs are displayed$")
  public void verifyTabsAreDisplayed(String tab) {
    assertTrue(app.googleCloudPricingCalcPage().isOptionInHeaderDisplayed(tab));
  }

  private Map<String, String> getCurrentEstimateRows() {
    List<WebElement> currentEstimateRows = app.googleCloudPricingCalcPage().getEstimateRows();
    return getKeyValuesFromWebElement(currentEstimateRows);
  }
}
