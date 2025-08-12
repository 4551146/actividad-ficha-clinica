package cl.kibernum.actividadmodular5.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cl.kibernum.actividadmodular5.pages.FormPage;
import cl.kibernum.actividadmodular5.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FormSteps {

    private WebDriver driver;
    private FormPage formPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
        formPage = new FormPage(driver);
    }

    @After
    public void tearDown() {
        if(driver != null) {
        driver.quit();
        }
    }

    @Given("médico está en la página de para rellenar formulario registro de paciente")
    public void que_el_usuario_esta_en_la_pagina_de_registro_de_paciente() {
        try {
            File loginHTML = new File("src/test/resources/html/ficha.html");
            URL url = loginHTML.toURI().toURL();
            driver.get(url.toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cargar el archivo HTML", e);
            }
        }

    @When("completa datos del formulario:")
    public void completa_datos_formulario(DataTable dataTable) {
        // Convertir DataTable en un mapa clave-valor
        Map<String, String> datos = dataTable.asMap(String.class, String.class);

        String nombre = datos.get("nombre");
        String diagnostico = datos.get("diagnostico");
        int edad = Integer.parseInt(datos.get("edad"));
        String tratamiento = datos.get("tratamiento");

        formPage.llenarFormularioPaciente(nombre, diagnostico, edad, tratamiento);
    }

    @Then("se muestra mensaje de confirmación {string}")
    public void deberia_ver_mensaje_de_registro_exitoso(String mensajeRegistro) {
        String mensajeRegistroReal = formPage.getMensajeRegistro();
        assertTrue(mensajeRegistroReal.contains(mensajeRegistro), "Mensaje esperado: " + mensajeRegistro + ", pero se obtuvo: " + mensajeRegistroReal);
        
    }    

}
