package com.learning.selenium.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static com.learning.selenium.tests.BaseTest.takesScreenshot;
import static com.learning.selenium.utils.StringUtils.getCurrentTimeAsString;

public class TestListener implements ITestListener {

  @Override
  public void onTestStart(ITestResult result) {
    Log.info(String.format("%s test case started", result.getName()));
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    Log.info(String.format("Test %s finished success ", result.getName()));
  }

  @Override
  public void onTestFailure(ITestResult result) {
    saveScreenshot();
    Log.info(String.format("Test %s failed ", result.getName()));
    Log.debug(String.format("Test failed with %s", result.getThrowable()));
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    saveScreenshot();
    Log.info(String.format("Test %s skipped ", result.getName()));
    Log.debug(String.format("Test %s skipped ", result.getThrowable()));
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    Log.info(String.format("Test %s failed but within success percentage ", result.getName()));
  }

  @Override
  public void onStart(ITestContext context) {
    Log.info(String.format("%s tests started", context.getName()));
  }

  @Override
  public void onFinish(ITestContext context) {
    Log.info(String.format("%s tests finished", context.getName()));
  }

  public void saveScreenshot() {
    File screenshotPath = null;
    File screenCapture = takesScreenshot.getScreenshotAs(OutputType.FILE);
    String filename = getCurrentTimeAsString() + ".png";
    try {
      screenshotPath = new File("./target/screenshots/" + filename);
      FileUtils.copyFile(screenCapture, screenshotPath);
    } catch (IOException e) {
      Log.error(String.format("Failed to save screen: %s", e.getLocalizedMessage()));
    }
    Log.info(String.format("Screen saved: <a href='%s' target='blank'>%s</a>",
        screenshotPath.getAbsolutePath(), filename));
  }
}
