package test.java;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

public class TestConnexionFirefox {

    protected static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        String s = System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void VerifTest() {
        //lancement google
        System.out.println("lancement google...");
        driver.get("https://www.google.fr");
    }
//comment
    //autre commentaire
}