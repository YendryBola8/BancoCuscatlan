package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class PageTutorialProgramacion {

    WebDriver driver;

    private By hIntro = By.xpath("//h2[contains(text(),'Introducción')]");

    private By parrafoIntro = By.xpath("//p[contains(text(),'herramienta desarrolladas en java para automatización')]");

    public PageTutorialProgramacion(WebDriver driver, ArrayList<String> tabs, String site){
        this.driver = driver;
        this.driver.switchTo().window(tabs.get(1));
        this.driver.get(site);
    }

    public String ImprimirTextIntroducion(){
      return this.driver.findElement(hIntro).getText();
    }

    public String ImprimirTextParrafo(){
        return this.driver.findElement(parrafoIntro).getText();
    }
}
