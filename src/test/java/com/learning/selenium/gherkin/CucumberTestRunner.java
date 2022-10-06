package com.learning.selenium.gherkin;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "classpath:features",
    plugin = {"pretty", "html:target/cucumber-report"},
    monochrome = true,
    glue = "com.learning.selenium"
    )
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
