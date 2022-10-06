package com.learning.selenium.tests;

import com.learning.selenium.model.Paste;
import com.learning.selenium.testdata.PasteCreator;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PasteTests extends BaseTest {

    @Test
    public void createNewPaste() {
        app.pasteMainPage().open();
        app.pasteMainPage().fillNewPaste("Hello from WebDriver");
        app.pasteMainPage().selectPasteExpiration("10 Minutes");
        app.pasteMainPage().fillNameTitle("helloweb");
    }

    @Test
    public void createNewPasteTest() {
        Paste paste = PasteCreator.getPasteInstanceFromProperty(envPropertyName);
        app.pasteMainPage().open();
        app.pasteMainPage().fillNewPaste(paste.getCodeToPaste());
        app.pasteMainPage().selectSyntaxHighlighting(paste.getHighlighting());
        app.pasteMainPage().selectPasteExpiration(paste.getExpiration());
        app.pasteMainPage().fillNameTitle(paste.getName());
        app.pasteMainPage().clickSubmit();
        assertTrue(getPageName().startsWith(paste.getName()));
        assertTrue(areElementsPresent(By.cssSelector("ol.bash")));
        assertEquals(app.pasteMainPage().getTextFromCreatedPaste(), paste.getCodeToPaste());
    }
}
