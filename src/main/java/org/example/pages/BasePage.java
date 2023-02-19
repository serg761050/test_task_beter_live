package org.example.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  static WebDriver driver = new ChromeDriver();

  static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

  public BasePage() {
    PageFactory.initElements(driver, this);
  }

  public static void closeDriver() {
    driver.quit();
  }
}
