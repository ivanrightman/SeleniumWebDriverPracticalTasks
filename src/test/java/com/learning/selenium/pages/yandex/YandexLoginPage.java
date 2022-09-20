package com.learning.selenium.pages.yandex;

import com.learning.selenium.pages.BasePage;
import com.learning.selenium.utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexLoginPage extends BasePage {

  private static final String LOGINPAGE_URL = "https://passport.yandex.com/";
  @FindBy(css = "[name=login]")
  private WebElement emailField;
  @FindBy(css = "[type=password]")
  private WebElement passwordField;
  @FindBy(css = "[type=submit]")
  private WebElement loginButton;
  @FindBy(xpath = "//div[contains(@class, 'PSHeader-User')]//img[contains(@class, 'user-pic__image')]")
  private WebElement header;

  public YandexLoginPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void open() {
    Log.info(String.format("Open %s page", LOGINPAGE_URL));
    driver.get(LOGINPAGE_URL);
  }

  public void clickLoginButton() {
    Log.info(String.format("Click login button"));
    click(loginButton);
  }

  public void logIn() {
    Log.info(String.format("Perform login"));
    fillInputField(emailField, "", null);
    clickLoginButton();
    fillInputField(passwordField, "", null);
    clickLoginButton();
    waitUntilElementClickable(header);
  }
}
