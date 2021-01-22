package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TestConnexion {

    @Test
    public void setUp() throws Exception
    {
        //Ajout du chemin driver
        String s = System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        //Initialisation de l'instance du driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Démarrage du navigateur
        driver.get("https://google.fr");
    }

//commentaire
    //autre commentaire
    //new comment encore !


}


