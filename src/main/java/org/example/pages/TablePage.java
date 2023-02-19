package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TablePage extends BasePage {
  @FindBy(xpath = "//div[@data-locator='balance-amount']")
  WebElement amount;

  @FindBy(xpath = "//span[@data-locator = 'table-limits-title']")
  WebElement title;

  @FindBy(xpath = "//div[@class='bettingPanel__undo-zZUfEm']")
  WebElement board;

  @FindBy(xpath = "//button[@data-locator = 'more-games-btn']")
  WebElement lobby;


  public TablePage() {
    super();
  }

  public double getAmount() {
    wait.until(ExpectedConditions.visibilityOf(amount));
    return Double.parseDouble(amount.getText()
        .substring(1).replaceAll(",", ""));
  }

  public String getTitle() {
    wait.until(ExpectedConditions.visibilityOf(title));
    return title.getText();
  }

  public boolean isPlayBoardVisible() {
    wait.until(ExpectedConditions.visibilityOf(board));
    return board.isDisplayed();
  }

  public TablePage openLobby() {
    wait.until(ExpectedConditions.visibilityOf(lobby)).click();
    return this;
  }

  public TablePage openTable(String tableName) {
    WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath(String.format("//div[text()= '%s']", tableName))));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", table);
    wait.until(ExpectedConditions.elementToBeClickable(table)).click();
    return this;
  }
}
