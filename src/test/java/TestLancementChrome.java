package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLancementChrome {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        String s = System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void VerifTest() throws InterruptedException {
        //lancement du site
        System.out.println("Lancement de Orange HRM");
        driver.get("https://opensource-demo.orangehrmlive.com");
        Thread.sleep(5000);
    }


     @AfterClass
     public static void TearDown() {
         //Fermeture du navigateur et clôture de l'instance
         driver.quit();
     }

}
//comment