package org.example.pages.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

  private final Properties properties = new Properties();

  private final String url;

  private final String login;

  private final String password;

  public PropertiesLoader() {
    loadPropertiesFile();
    this.url = getConfigParameter("url");
    this.login = getConfigParameter("login");
    this.password = getConfigParameter("password");
  }

  private void loadPropertiesFile() {
    try (InputStream propertyStream = PropertiesLoader.class.getResourceAsStream( "/config.properties")) {
      properties.load(propertyStream);
    } catch (IOException e) {
      throw new RuntimeException("An error occurred while loading config.properties", e);
    }
  }

  private String getConfigParameter(String key) {
    return getConfigParameter(key, null);
  }

  private String getConfigParameter(String key, String defaultValue) {
    String value = properties.getProperty(key);
    if (value == null) {
      if (defaultValue != null) {
        return defaultValue;
      }
      throw new RuntimeException("Configuration value not found for key '" + key + "'");
    }
    return value;
  }

  public String getUrl() {
    return url;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }
}
