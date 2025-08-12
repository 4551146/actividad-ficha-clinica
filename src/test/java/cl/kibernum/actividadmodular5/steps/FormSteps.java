package cl.kibernum.actividadmodular5.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cl.kibernum.actividadmodular5.pages.FormPage;
import cl.kibernum.actividadmodular5.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FormSteps {

    private WebDriver driver;
    private FormPage formPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        formPage = new FormPage(driver);
    }

    @After
    public void tearDown() {
        if(driver != null) {
        driver.quit();
        }
    }

}
