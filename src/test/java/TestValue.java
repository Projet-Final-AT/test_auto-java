package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class TestValue {

    private FirefoxDriver driver;

    @BeforeClass
    public void setUp() {
        String s = System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void valeursAverifier() {
        //Lancement du site
        driver.get("https://opensource-demo.orangehrmlive.com/indexphp.auth/login");

        //Remplissage des champs de la console de connexion en tant qu'admin
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        //Wait affichage page
        WebDriverWait waitPageWelcome = new WebDriverWait(driver,10);
        waitPageWelcome.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.id("welcome")))
        );

        //Vérification du titre de la page = OrangeHRM
        String pageTitle = driver.getTitle();
        assertEquals("OrangeHRM", pageTitle);
        System.out.println("Le titre de la page est : " + pageTitle);

        //Vérification affichage menu Welcome Admin
        WebElement elementMenuWelcome = driver.findElement(By.id("welcome"));
        String welcomeNomAdmin = elementMenuWelcome.getText();
        System.out.println("Le menu 'Welcome Admin' affiche : " + welcomeNomAdmin);

        //Cliquer sur Logout dans le menu déroulant
        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

        //Wait affichage page Login
        WebDriverWait waitPageLogin = new WebDriverWait(driver,10);
        waitPageLogin.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.id("btnLogin")))
        );

        //Vérifier que le bouton "Login" est affiché
        WebElement elementLogin = driver.findElement(By.id("btnLogin"));
        boolean loginPresence = elementLogin.isDisplayed();
        System.out.println("Le bouton 'Login' est affiché : " + loginPresence);

        //Vérifier que le lien "Forgot your password" est affiché et cliquable
        WebElement linkPassword = driver.findElement(By.linkText("Forgot your password?"));
        boolean forgotPassLinkPresence = linkPassword.isDisplayed();
        boolean forgotPassLinkEnabled = linkPassword.isEnabled();
        System.out.println("Le lien 'Forgot your password?' est affiché : " + forgotPassLinkPresence);
        System.out.println("Le lien 'Forgot your password?' est cliquable : " + forgotPassLinkEnabled);

    }

   @AfterClass
   public void TearDown() {
        //Fermeture du navigateur
        driver.quit();
    }

}

//comment