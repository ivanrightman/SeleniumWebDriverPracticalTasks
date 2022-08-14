package com.learning.selenium.tests;

import com.learning.selenium.model.Paste;
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
        Paste paste = new Paste()
                .withCodeToPaste("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force")
                .withHighlighting("Bash")
                .withExpiration("10 Minutes")
                .withName("how to gain dominance among developers");
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