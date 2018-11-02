import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MainPage {
    WebDriver driver;
    private String websiteAddress = "https://vegas.williamhill.com/";
    private WebElement magnifierButton;
    private WebElement searchBox;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(websiteAddress);
        return this;
    }

    public MainPage clickMagnifierButton() {
        magnifierButton = driver.findElement(By.className("btn-search-magnifier"));
        magnifierButton.click();
        return this;
    }

    public MainPage setSearchItem(String searchedItem) {
        searchBox = driver.findElement(By.xpath("//input[@class='sc-dxgOiQ cHTTOm']"));
        searchBox.sendKeys(searchedItem);
        return this;
    }
}
