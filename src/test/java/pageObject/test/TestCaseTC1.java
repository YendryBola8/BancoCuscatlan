package pageObject.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.hook.Hook;
import pageObject.pages.HomePage;
import pageObject.pages.PageTutorialProgramacion;
import pageObject.pages.PageWikiSelenium;
import pageObject.pages.PageWikipedia;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TestCaseTC1 extends Hook {

    String buscarWikipedia = "Wikipedia";                                       // 1.
    String urlHomeWikipedia = "https://www.wikipedia.org/";                     // 2.
    String urlHomeWikipedia2 = "WWW.Wikipedia.com";                             // 3.
    String buscarSelenium = "Selenium";                                         // 4.
    String site2;                                                               // 5. && // 6.
    String urlHomeGoogle="https://www.google.com";
    JavascriptExecutor js;
    Screenshot screenshot;


    @Test
    public void primerTest() throws InterruptedException, IOException {

        HomePage homePageVar = new HomePage(driver);

        PageWikipedia PageWikipedia = new PageWikipedia(driver);
        PageWikiSelenium PageWikiSelenium = new PageWikiSelenium(driver);
        PageTutorialProgramacion PageTutorialProgramacion;
        ArrayList<String> tabs;

        /*********************************** 1. Buscar Wikipedia en navegador  ****************************************/
        //
        this.driver.get(urlHomeGoogle);
        Assert.assertTrue(util.getUrl(urlHomeGoogle));
        Assert.assertTrue(util.getTitle("Google"));
        homePageVar.enterGoogleSearch(buscarWikipedia);         // Escribir Wikipedia
        homePageVar.clickEnter();
        Assert.assertTrue(util.getTitle("Wikipedia - Buscar con Google"));
        //screenshot = new AShot()
         //       .shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        //ImageIO.write(screenshot.getImage(), "jpg", new File("src/test/resources/test1.jpg"));
        //
        /***************************** 2. Hacer clic en enlace relacionado a la url www.wikipedia.com  ****************/
        //
        homePageVar.clickWikipedia(urlHomeWikipedia);
        //
        /********************************** 3. Verificar el sitio WWW.Wikipedia.com ***********************************/
        //
        // Assert.assertTrue(util.getUrl(urlHomeWikipedia2));
        // Pendiente... no lo entiendo ? ¿http://www.wikipedia.com/?
        Assert.assertTrue(util.getUrl(urlHomeWikipedia));
       // screenshot = new AShot()
         //       .shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        //ImageIO.write(screenshot.getImage(), "jpg", new File("src/test/resources/test2.jpg"));
        /****************************** 4. Dentro de la página Wikipedia Buscar Selenium ******************************/
        //
        PageWikipedia.BuscarSearch(buscarSelenium);
        PageWikipedia.clickButtonSearch();
        Assert.assertTrue(util.getTitle("Selenium - Wikipedia, la enciclopedia libre"));
       // screenshot = new AShot()
       //         .shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        //ImageIO.write(screenshot.getImage(), "jpg", new File("src/test/resources/test3.jpg"));
        //
        /************************ 5. Seleccionar el ultimo enlace externo. Abrirá una segunda pestaña *****************/
        //
        site2 = PageWikiSelenium.selecctEnlace();
        this.js = PageWikiSelenium.clickEnlaceLastExterno(this.js);
        tabs = new ArrayList<String>(driver.getWindowHandles());
        //
        /**************************** 6. Ya en la segunda pestaña verificar sitio *************************************/
        //
        PageTutorialProgramacion = new PageTutorialProgramacion(driver, tabs, site2);
        //  Error esta fallando ya que redirecciona a otra pagina
        // Assert.assertTrue(util.getUrl(site2));
        //
        /************************* 7. verificar el texto dentro del apartado introducción *****************************/
        //
        Assert.assertEquals("Introducción",PageTutorialProgramacion.ImprimirTextIntroducion());
        //screenshot = new AShot()
              //  .shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        Assert.assertEquals("Selenium es un set de herramienta desarrolladas en java para automatización de tareas en navegadores orientadas al testing de páginas web.", PageTutorialProgramacion.ImprimirTextParrafo());
       // ImageIO.write(screenshot.getImage(), "jpg", new File("src/test/resources/test4.jpg"));
        driver.close();
        driver.switchTo().window(tabs.get(0));
        /**************************************************************************************************************/
    }
}
