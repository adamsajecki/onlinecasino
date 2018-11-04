import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;
    private String websiteAddress = "https://vegas.williamhill.com/";


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By magnifierButtonLocator = By.cssSelector(".btn-search-magnifier");
    By searchBoxLocator = By.cssSelector(".sc-dxgOiQ.cHTTOm");

    public MainPage openMainPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(websiteAddress);
        return this;
    }

    public MainPage clickMagnifierButton() {
        driver.findElement(magnifierButtonLocator).click();
        return this;
    }

    public SearchResultsPage setSearchItem(String searchedItem) {
        driver.findElement(searchBoxLocator).sendKeys(searchedItem);
        return new SearchResultsPage(driver);
    }
}
