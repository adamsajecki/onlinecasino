import org.junit.Test;

public class LoginWindowDisplayTest extends MainTest {

    @Test
    public void LoginWindowIsDisplayed() {
        mainPage
                .clickMagnifierButton()
                .setSearchItem(gameName);
        searchResultsPage
                .hoverOverGameTile(gameName)
                .clickMoreButton()
                .clickPlayButton()
                .validateIfFullLoginWindowIsDisplayed();

    }
}
