package cl.kibernum.actividadmodular5.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;

import cl.kibernum.actividadmodular5.hooks.DriverHolder;
import cl.kibernum.actividadmodular5.pages.FormPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;

public class FormSteps {

    private WebDriver driver;
    private FormPage formPage;

    @Before
    public void init() {
        this.driver = DriverHolder.get();
        this.formPage = new FormPage(driver);
    }

    @Given("médico está en la página de para rellenar formulario registro de paciente")
    public void que_el_usuario_esta_en_la_pagina_de_registro_de_paciente() {
        try {
            driver.get("https://clinica-modular.netlify.app/");
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
        List<String> lista = Arrays.asList(mensajeRegistro.split("/"));
        String mensajeRegistroReal = formPage.getMensajeRegistro();
            for (String err : lista) {
                assertTrue(mensajeRegistroReal.contains(err), "Mensaje esperado: " + mensajeRegistro + ", pero se obtuvo: " + mensajeRegistroReal);
            }
    }    

}
