package com.learning.selenium.gherkin;

import com.learning.selenium.app.Application;
import com.learning.selenium.driver.ChromeDriverFactory;
import com.learning.selenium.driver.CustomDriverDecorator;
import com.learning.selenium.driver.EdgeDriverFactory;
import com.learning.selenium.driver.FirefoxDriverFactory;
import com.learning.selenium.driver.IWebDriverFactory;
import com.learning.selenium.utils.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

import java.net.MalformedURLException;

public class DriverHook {

  private WebDriver driver;
  protected String envPropertyName = "local";
  public static TakesScreenshot takesScreenshot;
  public Actions actions;
  public static Application app;

  @Before
  public void start() {
    String browser = System.getProperty("browser", BrowserType.CHROME);
    String environment = System.getProperty("environment", envPropertyName);
    if ("".equals(environment) || "qa".equals(environment) || envPropertyName.equals(environment)) {
      if (browser.equals(BrowserType.FIREFOX)){
        IWebDriverFactory factory = new FirefoxDriverFactory();
        driver = factory.createWebDriver();
      } else if (browser.equals(BrowserType.CHROME)) {
        IWebDriverFactory factory = new ChromeDriverFactory();
        driver = factory.createWebDriver();
      } else if (browser.equals(BrowserType.EDGE)) {
        IWebDriverFactory factory = new EdgeDriverFactory();
        driver = factory.createWebDriver();
      }
    } else {
      if (browser.equals(BrowserType.CHROME)) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.BROWSER_NAME, browser);
        chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, "MAC");
        IWebDriverFactory factory = new ChromeDriverFactory();
        try {
          driver = factory.createRemoteWebDriver(environment, chromeOptions);
        } catch (MalformedURLException e) {
          Log.error("Failed to create createRemoteWebDriver " + e);
        }
      } else {
        Log.debug("Unsupported browserName: " + browser);
        throw new IllegalArgumentException("Unsupported browserName: " + browser);
      }
    }
    app = new Application(driver, actions);
    takesScreenshot = (TakesScreenshot) driver;
  }

  @After
  public void stop(Scenario scenario) {
    takeScreenshot(scenario);
    driver.quit();
  }

  private void takeScreenshot(Scenario scenario) {
    if (scenario.isFailed()) {
      if (driver instanceof TakesScreenshot) {
        scenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png", "Screenshot");
      }
    }
  }
}
