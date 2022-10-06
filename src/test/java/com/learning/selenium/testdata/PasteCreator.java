package com.learning.selenium.testdata;

import com.learning.selenium.model.Paste;
import com.learning.selenium.utils.TestDataReader;

public class PasteCreator {

    private static Paste paste;
    private static final String codeToPaste = "testdata.paste.codetopaste";
    private static final String highlighting = "testdata.paste.highlighting";
    private static final String expiration = "testdata.paste.expiration";
    private static final String name = "testdata.paste.name";

    public static Paste getPasteInstanceFromProperty(String propertyName) {
        TestDataReader.readProperty(propertyName);
        paste = new Paste()
                .withCodeToPaste(TestDataReader.getFromProperty(codeToPaste))
                .withHighlighting(TestDataReader.getFromProperty(highlighting))
                .withExpiration(TestDataReader.getFromProperty(expiration))
                .withName(TestDataReader.getFromProperty(name));
        return paste;
    }

    public static Paste getPasteObjectInstance() {
        paste = new Paste()
                .withCodeToPaste("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force")
                .withHighlighting("Bash")
                .withExpiration("10 Minutes")
                .withName("how to gain dominance among developers");
        return paste;
    }
}
