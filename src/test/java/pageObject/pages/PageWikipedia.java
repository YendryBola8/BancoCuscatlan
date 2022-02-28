package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PageWikipedia {

    WebDriver driver;

    // Locator for field
    private By inputSearch = By.id("searchInput");
    private By buttonSearch = By.cssSelector("//button[@class='pure-button pure-button-primary-progressive']");
    //   #typeahead-suggestions


    public PageWikipedia(WebDriver driver) {
        this.driver = driver;
    }

    public void BuscarSearch(String nameSelenium){
        this.driver.findElement(inputSearch).sendKeys(nameSelenium);
    }

    public void clickButtonSearch(){
        this.driver.findElement(inputSearch).sendKeys(Keys.RETURN);
    }
}
