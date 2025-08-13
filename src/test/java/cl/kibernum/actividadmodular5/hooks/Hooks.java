package cl.kibernum.actividadmodular5.hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.nio.file.Files;

public class Hooks {

     @Before
    public void setUp() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        DriverHolder.set(driver);
    }


    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverHolder.get();
        if (scenario.isFailed()) {
            byte[] shot = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
            scenario.attach(shot, "image/png", scenario.getName());
        }
        String id = scenario.getId(); 
        String nombreArchivo = "EjecucionCompleta_" + id.replaceAll("[^a-zA-Z0-9-_]", "_");
        tomarSnapshot(nombreArchivo);
        driver.quit();
        DriverHolder.remove();
    }

    private void tomarSnapshot(String nombre) {
        try {
            File screenshot = ((TakesScreenshot) DriverHolder.get()).getScreenshotAs(OutputType.FILE);
            Files.createDirectories(Paths.get("target/screenshots"));
            String fileName = "target/screenshots/" + nombre + ".png";
            Files.copy(screenshot.toPath(), Paths.get(fileName), java.nio.file.StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al tomar snapshot: " + e.getMessage());
        }
    }
    
}
