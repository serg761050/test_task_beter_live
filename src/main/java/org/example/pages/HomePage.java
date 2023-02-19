package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

  @FindBy(xpath = "//iframe")
  private WebElement frame;

  @FindBy(xpath = "//div[text()='Bet On Teen Patti']")
  private WebElement tableTP;


  public HomePage() {
    super();
  }

  public void switchToIframe() {
    wait.until(ExpectedConditions.visibilityOf(frame));
    driver.switchTo().frame(frame);
  }

  public TablePage openTeenPattiTable() {
    switchToIframe();
    wait.until(ExpectedConditions.visibilityOf(tableTP));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tableTP);
    wait.until(ExpectedConditions.elementToBeClickable(tableTP));
    tableTP.click();
    return new TablePage();
  }

}
