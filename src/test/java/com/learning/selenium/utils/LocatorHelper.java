package com.learning.selenium.utils;

import org.openqa.selenium.By;

public class LocatorHelper {
    public static By getLocatorFromOneValue(String pattern, String value) {
        return By.xpath(String.format(pattern, value));
    }

    public static By getLocatorFromTwoValues(String pattern, String first, String second) {
        return By.xpath(String.format(pattern, first, second));
    }
}
