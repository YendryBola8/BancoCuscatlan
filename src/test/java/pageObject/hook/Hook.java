package pageObject.hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Hook {

    public WebDriver driver;
    public Utility util;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/Chrome/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        util = new Utility(driver);
    }

    @AfterTest // Para cerrar el navegador y driver
    public void close(){
        driver.close();
        driver.quit();
    }

}
