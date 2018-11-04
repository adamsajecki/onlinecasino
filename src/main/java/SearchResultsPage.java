import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    By moreButtonLocator = By.xpath("//button[@data-test='tile-menu-button-more']");
    By playButtonLocator = By.cssSelector(".sc-EHOje.hGojEe");


    public SearchResultsPage hoverOverGameTile(String gameName) {
        new WebDriverWait(driver,10).until(ExpectedConditions.urlContains("search"));
        List<WebElement> listOfTiles = driver.findElements(By.cssSelector(".tile-cover__image"));
        Actions action = new Actions(driver);
        for(WebElement element : listOfTiles) {
            if(element.getAttribute("alt").equals(gameName)) {
                action.moveToElement(element).perform();
            }
        }
        return this;
    }

    public SearchResultsPage clickMoreButton() {
        driver.findElement(moreButtonLocator).click();
        return this;
    }

    public SearchResultsPage clickPlayButton() {
        driver.findElement(playButtonLocator).click();
        return this;
    }

    public SearchResultsPage validateIfFullLoginWindowIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.className("login-component__wrapper")).isDisplayed());
        return this;
    }
}
