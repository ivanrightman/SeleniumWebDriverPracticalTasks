package com.learning.selenium.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

  private static final Properties properties = new Properties();

  public static void readProperty(String fileName) {
    try {
      properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", fileName))));
    } catch (IOException e) {
      Log.error(String.format("Failed to read property %s", e.getLocalizedMessage()));
    }
    Log.info("Property read");
  }

  public static String getFromProperty(String propertyName) {
    return properties.getProperty(propertyName);
  }
}
