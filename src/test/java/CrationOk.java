package test.java;

        import org.openqa.selenium.By;
        import org.openqa.selenium.Dimension;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

        import java.util.concurrent.TimeUnit;

        import static org.testng.Assert.assertEquals;


public class CrationOk {
    private FirefoxDriver driver;
    @BeforeClass
    public void setUp() {
        String s = System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testCreation() {
        //ouverture navigateur

        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
        }

        // connexion en tant qu'admin

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        // Accès menu PIM

        driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b")).click();
        // aller sur Add employee

        driver.findElement(By.id("menu_pim_addEmployee")).click();
        //Verification du titre de la page

        assertEquals(driver.getTitle(),("OrangeHRM"));
        //Saisie des infos salarié

        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("Peter");
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).sendKeys("Cooper");

        //driver.findElement(By.cssSelector ("#photofile")).click();
        //driver.findElement(By.cssSelector ("#photofile")).sendKeys("C:\\Users\\HP EliteBook\\Pictures\\Photo Jane Higgins.jpg");

        //creation données connexion

        driver.findElement(By.id("chkLogin")).click();
        driver.findElement(By.id("user_name")).sendKeys("pcooper");
        driver.findElement(By.id("user_password")).sendKeys("Test@1234");
        driver.findElement(By.id("re_password")).sendKeys("Test@1234");
        driver.findElement(By.id("btnSave")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Verification que le salarié est créé


        assertEquals(driver.findElement(By.cssSelector("#pdMainContainer h1")).getText(),("Personal Details"));
    }
    @AfterClass
    public void tearDown() {
        System.out.println(" L'utilisateur ferme le navigateur ");
        //Fermeture du navigateur
        driver.quit();
    }
}

