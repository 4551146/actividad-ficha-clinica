package cl.kibernum.actividadmodular5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Localizadores

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By btnLogin = By.xpath("//div[@type = 'submit']//div");
    private By lbRegistroPaciente = By.xpath("//h2[text()='Registro de Paciente']");
    private By errorMessage = By.id("login-message");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String errorLogin(){ //Obtiene mensaje de error
        return driver.findElement(errorMessage).getText(); 
    }

    public void login(String usuario, String password) {
        driver.findElement(usernameField).sendKeys(usuario);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(btnLogin).click();
    }

    public String getTituloRegistroPaciente(){
        return driver.findElement(lbRegistroPaciente).getText();
    }

    
}
