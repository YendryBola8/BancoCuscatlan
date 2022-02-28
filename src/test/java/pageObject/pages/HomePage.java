package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    // Locator for field
    private By nameGoogleSearch = By.name("q");
    private By linkWikipedia = By.linkText("Wikipedia");
    private By linkWikipediaLista = By.partialLinkText("Wikipedia");
    // private By linkWikipedia = By.linkText("WWW.Wikipedia.com");
    private By linkSiguiente = By.id("pnnext");


    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterGoogleSearch(String GoogleSearch) {
        this.driver.findElement(nameGoogleSearch).sendKeys(GoogleSearch);
    }

    public void clickEnter(){
        this.driver.findElement(nameGoogleSearch).sendKeys(Keys.RETURN);
    }

    public void clickWikipedia(String urlHomeWikipedia){
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].scrollIntoView();", this.driver.findElement(linkWikipediaLista));
        this.driver.findElement(By.xpath("//a[@href='"+urlHomeWikipedia+"']")).click();
    }

}
