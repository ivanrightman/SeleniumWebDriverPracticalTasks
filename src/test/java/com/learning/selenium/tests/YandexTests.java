package com.learning.selenium.tests;

import org.testng.annotations.Test;

public class YandexTests extends BaseTest {

    @Test
    public void yandexDiskTest() {
        app.yandexDiskPage().open();
        app.yandexDiskPage().clickSignInButton();
        app.yandexLoginPage().logIn();
        app.yandexDiskPage().dragAndDropIntoTrash("New folder");
        app.yandexDiskPage().selectAllAndDeleteWithActions();
    }
}
