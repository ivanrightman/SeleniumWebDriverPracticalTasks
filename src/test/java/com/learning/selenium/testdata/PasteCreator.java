package com.learning.selenium.testdata;

import com.learning.selenium.model.Paste;
import com.learning.selenium.utils.TestDataReader;

public class PasteCreator {

  private static String codeToPaste = "testdata.paste.codetopaste";
  private static String highlighting = "testdata.paste.highlighting";
  private static String expiration = "testdata.paste.expiration";
  private static String name = "testdata.paste.name";

  public static Paste pasteFromProperty(String propertyName) {
    TestDataReader.readProperty(propertyName);
    return new Paste()
        .withCodeToPaste(TestDataReader.getFromProperty(codeToPaste))
        .withHighlighting(TestDataReader.getFromProperty(highlighting))
        .withExpiration(TestDataReader.getFromProperty(expiration))
        .withName(TestDataReader.getFromProperty(name));
  }

  public static Paste pasteObject() {
    return new Paste()
        .withCodeToPaste("git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force")
        .withHighlighting("Bash")
        .withExpiration("10 Minutes")
        .withName("how to gain dominance among developers");
  }
}
