import static org.example.pages.BasePage.closeDriver;

import org.apache.log4j.Logger;
import org.example.pages.LoginPage;
import org.example.pages.TablePage;
import org.example.pages.utils.PropertiesLoader;
import org.testng.Assert;
import org.testng.annotations.*;

public class MainTest {
  PropertiesLoader propertiesLoader = new PropertiesLoader();

  public static final Logger logger = Logger.getLogger(MainTest.class);

  @BeforeTest
  public void beforeTest() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
  }

  @AfterTest
  public void afterTest() {
    closeDriver();
  }

  @Test
  public void test() {
    LoginPage loginPage = new LoginPage();

    TablePage teenPattiTable = loginPage
        .open(propertiesLoader.getUrl())
        .login(propertiesLoader.getLogin(), propertiesLoader.getPassword())
        .openTeenPattiTable();

    Assert.assertTrue(teenPattiTable.getAmount() > 0);
    logger.info("The player's balance is greater than zero.");
    Assert.assertEquals(teenPattiTable.getTitle(), "Bet On Teen Patti");
    logger.info("The table name matches \"Bet On Teen Patti\".");
    Assert.assertTrue(teenPattiTable.isPlayBoardVisible());
    logger.info("The game board is present on the screen.");

    TablePage tablePage = teenPattiTable
        .openLobby()
        .openTable("Live Blackjack 4")
        .openLobby()
        .openTable("Parimatch Gravity Blackjack");

    Assert.assertEquals(tablePage.getTitle(), "Parimatch Gravity Blackjack");
    logger.info("The table name matches \"Parimatch Gravity Blackjack\".");
  }
}
