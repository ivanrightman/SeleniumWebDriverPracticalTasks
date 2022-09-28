package com.learning.selenium.pages.pastebin;

import com.learning.selenium.pages.BasePage;
import com.learning.selenium.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PasteMainPage extends BasePage {

    private static final String MAINPAGE_URL = "https://pastebin.com";
    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlighting;
    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpiration;
    @FindBy(id = "postform-name")
    private WebElement nameTitle;
    @FindBy(css = "[type=submit]")
    private WebElement submitButton;
    @FindBy(className = "post-view")
    private WebElement blockAfterCreatingNewPaste;
    @FindBy(className = "li1")
    private List<WebElement> textWithCreatedPaste;

    public PasteMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        Log.info(String.format("Open %s page", MAINPAGE_URL));
        driver.get(MAINPAGE_URL);
    }

    public void fillNewPaste(String input) {
        Log.info(String.format("Filling new paste with input ", input));
        fillInputField(By.id("postform-text"), input);
    }

    public void selectSyntaxHighlighting(String text) {
        Log.info(String.format("Select syntax highlighting"));
        syntaxHighlighting.click();
        click(By.xpath("//li[text()='" + text + "']"));
    }

    public void selectPasteExpiration(String text) {
        Log.info(String.format("Select paste expiration "));
        pasteExpiration.click();
        click(By.xpath("//li[text()='" + text + "']"));
    }

    public void fillNameTitle(String input) {
        Log.info(String.format("Filling name title "));
        fillInputField(nameTitle, input, null);
    }

    public void clickSubmit() {
        Log.info(String.format("Click Submit "));
        submitButton.click();
        wait.until(ExpectedConditions.visibilityOf(blockAfterCreatingNewPaste));
    }

    public String getTextFromCreatedPaste() {
        StringBuilder combined = new StringBuilder();
        for (int i = 0; i < textWithCreatedPaste.size(); i++) {
            if (i + 1 < textWithCreatedPaste.size()) {
                combined.append(textWithCreatedPaste.get(i).getText())
                        .append("\n");
            } else {
                combined.append(textWithCreatedPaste.get(i).getText());
            }
        }
        return combined.toString();
    }
}
