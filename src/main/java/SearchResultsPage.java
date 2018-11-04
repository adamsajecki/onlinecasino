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
    By loginWindowLocator = By.cssSelector(".login-component__wrapper");
    By usernameFieldLocator = By.cssSelector("#login-form-username");
    By passwordFieldLocator = By.cssSelector("#login-form-password");
    By loginButtonLocator = By.cssSelector(".sb-btn.sb-btn--expanded.sb-btn--success.sb-btn--normal.c-login-form__submit-button");


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

    public SearchResultsPage assertThatFullLoginWindowIsDisplayed() {
        Assert.assertTrue(driver.findElement(loginWindowLocator).isDisplayed());
        return this;
    }

    public SearchResultsPage assertThatUsernameFieldIsDisplayed() {
        Assert.assertTrue(driver.findElement(usernameFieldLocator).isDisplayed());
        return this;
    }

    public SearchResultsPage assertThatPasswordFieldIsDisplayed() {
        Assert.assertTrue(driver.findElement(passwordFieldLocator).isDisplayed());
        return this;
    }

    public SearchResultsPage assertThatLogInButtonIsDisplayed() {
        Assert.assertTrue(driver.findElement(loginButtonLocator).isDisplayed());
        return this;
    }


}
