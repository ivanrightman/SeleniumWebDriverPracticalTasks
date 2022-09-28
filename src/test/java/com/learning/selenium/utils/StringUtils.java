package com.learning.selenium.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class StringUtils {
  public static String getCurrentTimeAsString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
    return ZonedDateTime.now().format(formatter);
  }

  public static String getCurrentDateAsString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
    return ZonedDateTime.now().format(formatter);
  }
}
