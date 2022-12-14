package com.learning.selenium.pages.yandex;

import com.learning.selenium.pages.BasePage;
import com.learning.selenium.utils.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YandexDiskPage extends BasePage {

    private static final String DISKPAGE_URL = "https://disk.yandex.com/";
    @FindBy(xpath = "//a[contains(@class, 'button_login')]")
    private WebElement signInButton;
    @FindBy(xpath = "//span[@id='/disk']")
    private WebElement foldersNav;
    @FindBy(xpath = "//div[@class='listing__items']//div[contains(@class, 'listing-item_type')]")
    protected List<WebElement> foldersElements;
    @FindBy(xpath = "//div[contains(@class, 'listing-item_type_dir js-prevent-drag')]")
    private WebElement trash;
    private final String elementToTrashLocator = "//div[@class='listing__items']//div[contains(@aria-label, '%s')]";
    @FindBy(xpath = "//div[contains(@class, 'popup__actions-menu')]//div[@role='group']")
    private List<WebElement> contextMenu;
    @FindBy(css = "[value=delete]")
    private WebElement contextMenuDelete;

    public YandexDiskPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    @Override
    public void open() {
        driver.get(DISKPAGE_URL);
    }

    public void clickSignInButton() {
        click(signInButton);
    }

    public boolean isSignInDisplayed() {
        return signInButton.isDisplayed();
    }

    public void dragAndDropIntoTrash(String fileName) {
        Log.info(String.format("Drag and drop %s into trash", fileName));
        //WebElement victim = getElement(getLocatorFromOneValue(elementToTrashLocator, fileName));
        //actions
        //.moveToElement(victim)
        //.moveByOffset(5,-100) //to click not in the middle of the element but on the folder icon
        //.clickAndHold()
        //.moveToElement(trash)
        //.release()
        //.perform();
        for (WebElement el : foldersElements) {
            if (el.getText().equals(fileName)) {
                actions
                        .dragAndDrop(el, trash)
                        .perform();
            }
        }
        highlightAndClickOnTrashIcon();
    }

    private void selectAllInFoldersWithActionsMac() {
        Log.info(String.format("Selecting all files in folders"));
        for (WebElement el : foldersElements) {
            if (!el.equals(trash)) {
                actions
                        .moveToElement(el)
                        .keyDown(Keys.COMMAND)
                        .click()
                        .perform();
            }
        }
    }

    private void selectAllInFoldersWithActionsWin() {
        Log.info(String.format("Selecting all files in folders"));
        for (WebElement el : foldersElements) {
            if (!el.equals(trash)) {
                actions
                        .moveToElement(el)
                        .keyDown(Keys.CONTROL)
                        .click()
                        .perform();
            }
        }
    }

    public void selectAllAndDeleteWithActions() {
        Log.info(String.format("Selecting all files in folders and delete"));
        selectAllInFoldersWithActionsMac();
        actions
                .contextClick()
                .perform();
        actions
                .click(contextMenuDelete)
                .perform();
    }

    public void highlightAndClickOnTrashIcon() {
        highlightElementJs(trash);
        clickOnElementJs(trash);
    }
}
