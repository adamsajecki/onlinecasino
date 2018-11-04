import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {
    WebDriver driver = new ChromeDriver();

    MainPage mainPage = new MainPage(driver);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    String gameName = "Mayfair Roulette";

    private static StringBuilder builder = new StringBuilder();

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            super.succeeded(description);
            builder.append(description);
            builder.append(" PASSED");
            builder.append("\n");
        }

        @Override
        protected void failed(Throwable e, Description description) {
            super.failed(e, description);
            builder.append(description);
            builder.append(" FAILED");
            builder.append("\n");
        }
    };

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

    @AfterClass
    public static void printReport() {
        System.out.println(builder);
    }

}
