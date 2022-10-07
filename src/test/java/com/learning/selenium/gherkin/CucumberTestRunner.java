package com.learning.selenium.gherkin;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "classpath:features",
    plugin = {"pretty", "html:report.html", "com.epam.reportportal.cucumber.ScenarioReporter"},
    monochrome = true,
    glue = "com.learning.selenium.gherkin"
    )
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
