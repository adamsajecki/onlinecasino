import org.junit.Test;

public class SearchResultsPageTest extends MainTest {

    @Test
    public void LoginWindowIsDisplayed() {
        mainPage
                .clickMagnifierButton()
                .setSearchItem(gameName)
                .hoverOverGameTile(gameName)
                .clickMoreButton()
                .clickPlayButton()
                .assertThatFullLoginWindowIsDisplayed()
                .assertThatUsernameFieldIsDisplayed()
                .assertThatPasswordFieldIsDisplayed()
                .assertThatLogInButtonIsDisplayed();

    }
}
