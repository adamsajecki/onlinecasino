import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {
    WebDriver driver = new ChromeDriver();

    MainPage mainPage = new MainPage(driver);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    String gameName = "Mayfair Roulette";

    @Before
    public void openOnlineCasino() {
        mainPage.openMainPage();
    }

    @After
    public void closeBrowser() throws Exception {
        Thread.sleep(5000);
        driver.quit();
        // POZBYĆ SIĘ SLEEP I EXCEPTION!!!!!!!!!!!!!!!!!!
    }

}
