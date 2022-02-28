package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class PageWikiSelenium {

    WebDriver driver;

    private By hrefLastEnlace = By.xpath("//ul[4]/li[2]/a");

    public PageWikiSelenium(WebDriver driver) {
        this.driver = driver;
    }

    public String selecctEnlace(){
        return this.driver.findElement(hrefLastEnlace).getAttribute("href");
    }

    public JavascriptExecutor clickEnlaceLastExterno(JavascriptExecutor js) throws InterruptedException {
        js = (JavascriptExecutor) this.driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        ((JavascriptExecutor)driver).executeScript("window.open()");
        return js;
    }
}
