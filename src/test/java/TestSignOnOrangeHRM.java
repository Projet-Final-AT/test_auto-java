package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class TestSignOnOrangeHRM {

    private FirefoxDriver driver;

    @BeforeClass
    public void setUp() {
        String s = System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void ConnectAccount() {
        //Lancement du site
        driver.get("https://opensource-demo.orangehrmlive.com");

        //Remplissage des champs de la console de connexion en tant qu'admin
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        //Attente affichage page avec onglet PIM
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.id("menu_pim_viewPimModule")))
        );

        //Ajout d'un nouvel employé
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        driver.findElement(By.id("firstName")).sendKeys("Jean");
        driver.findElement(By.id("middleName")).sendKeys("Philippe");
        driver.findElement(By.id("lastName")).sendKeys("Dupont");

        //Attente de l'affichage du formulaire
        wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.id("btnSave")))
        );

        //Création des détails de connexion
        driver.findElement(By.id("chkLogin")).click();
        driver.findElement(By.id("user_name")).sendKeys("JDupont");
        driver.findElement(By.id("user_password")).sendKeys("P1P2P3P4");
        driver.findElement(By.id("re_password")).sendKeys("P1P2P3P4");
        driver.findElement(By.id("btnSave")).click();

        //Attente de l'affichage de la page
        wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.id("btnSave")))
        );

        //Déconnexion de l'admin
        driver.findElement(By.id("welcome")).click();
    }

    @AfterClass
    public void TearDown() {
        //Fermeture du navigateur
        driver.quit();
    }

}
//commentaire2
