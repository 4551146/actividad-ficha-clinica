package cl.kibernum.actividadmodular5.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cl.kibernum.actividadmodular5.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        if(driver != null) {
        driver.quit();
        }
    }

    @Given("médico está en la página de inicio de sesión")
    public void que_el_usuario_esta_en_la_pagina_de_login() {
    try {
        File loginHTML = new File("src/test/resources/html/index.html");
        URL url = loginHTML.toURI().toURL();
        driver.get(url.toString());
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error al cargar el archivo HTML", e);
        }
    }

    @When("ingresa su nombre de usuario {string} y contraseña {string} para iniciar sesión")
    public void ingresa_usuario_y_clave(String usuario, String password) {
        loginPage.login(usuario, password);
    }

    @Then("accede a la ficha clínica donde debería ver el formulario con el título {string}")
    public void deberia_ver_formulario(String tituloRegistro) {
        String lbRegistroPaciente = loginPage.getTituloRegistroPaciente();
        assertTrue(lbRegistroPaciente.contains(tituloRegistro), "Mensaje esperado: " + tituloRegistro + ", pero se obtuvo: " + lbRegistroPaciente);
        
    }

    // Login fallido

    

    @Then("debería mostrar mensaje de error {string}")
    public void deberia_ver_mensaje_de_error(String mensajeErrorEsperado) {
        String mensajeErrorReal = loginPage.errorLogin();
        assertTrue(mensajeErrorReal.contains(mensajeErrorEsperado), "Mensaje esperado: " + mensajeErrorEsperado + ", pero se obtuvo: " + mensajeErrorReal);
    }
  
}
