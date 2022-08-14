package com.learning.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PasteMainPage extends BasePage {

    public PasteMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(MAINPAGE_URL);
    }

    private static final String MAINPAGE_URL = "https://pastebin.com";

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlighting;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpiration;

    @FindBy(id = "postform-name")
    private WebElement nameTitle;

    @FindBy(css = "[type=submit]")
    private WebElement submitButton;

    //@FindBy(css = "[class=post-view]")
    @FindBy(className = "post-view")
    private WebElement blockAfterCreatingNewPaste;

    @FindBy(className = "li1")
    private List<WebElement> textWithCreatedPaste;

    public void fillNewPaste(String input) {
        fillInputField(By.id("postform-text"), input);
    }

    public void selectSyntaxHighlighting(String text) {
        syntaxHighlighting.click();
        click(By.xpath("//li[text()='" + text + "']"));
    }

    public void selectPasteExpiration(String text) {
        pasteExpiration.click();
        click(By.xpath("//li[text()='" + text + "']"));
    }

    public void fillNameTitle(String input) {
        fillInputField(nameTitle, input, null);
    }

    public void clickSubmit() {
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