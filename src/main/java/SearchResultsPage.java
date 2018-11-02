import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchResultsPage {
    WebDriver driver;
    private String xpathToSearchedTile;
    private WebElement searchedTile;
    private WebElement moreButton;
    private WebElement playButton;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultsPage hoverOverGameTile(String gameName) {
        xpathToSearchedTile = "//section[@class='page__content search__content']//img[contains(@alt,'" + gameName +"')]";
        searchedTile = driver.findElement(By.xpath(xpathToSearchedTile));
        Actions action = new Actions(driver);
        action.moveToElement(searchedTile).perform();
        return this;
    }

    public SearchResultsPage clickMoreButton() {
        moreButton = driver.findElement(By.xpath("//button[@data-test='tile-menu-button-more']"));
        moreButton.click();
        return this;
    }

    public SearchResultsPage clickPlayButton() {
        playButton = driver.findElement(By.xpath("//button[@data-test='tile-details-button-play']"));
        playButton.click();
        return this;
    }

    public SearchResultsPage validateIfFullLoginWindowIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.className("login-component__wrapper")).isDisplayed());
        return this;
    }
}
