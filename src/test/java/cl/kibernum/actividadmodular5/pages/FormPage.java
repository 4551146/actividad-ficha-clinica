package cl.kibernum.actividadmodular5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {
    
    private WebDriver driver;

    private By nameField = By.id("nombre");
    private By diagnosticField = By.id("diagnostico");
    private By ageField = By.id("edad");
    private By treatmentField = By.id("tratamiento");
    private By btnSave = By.xpath("//button[text()='Guardar Ficha']");
    private By lbFichaRegistrada = By.id("record-message");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void llenarFormularioPaciente(String nombrePaciente, String diagnostico, int edad, String tratamiento) {
        driver.findElement(nameField).sendKeys(nombrePaciente);
        driver.findElement(diagnosticField).sendKeys(diagnostico);
        driver.findElement(ageField).sendKeys(String.valueOf(edad));
        if(tratamiento != null){
            driver.findElement(treatmentField).sendKeys(tratamiento);
        }
        driver.findElement(btnSave).click();
    }

    public String getMensajeRegistro(){
        return driver.findElement(lbFichaRegistrada).getText();
    }
}
