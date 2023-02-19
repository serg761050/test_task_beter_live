package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

  @FindBy(id = "mui-1")
  private WebElement loginField;

  @FindBy(id = "mui-2")
  private WebElement passwordField;

  @FindBy(id = "mui-6")
  private WebElement lobbyButton;

  public LoginPage() {
    super();
  }

  public LoginPage open(String url) {
    driver.get(url);
    driver.manage().window().maximize();
    return this;
  }

  public HomePage login(String login, String password){
    loginField.sendKeys(login);
    passwordField.sendKeys((password));
    lobbyButton.click();
    return new HomePage();
  }




}
