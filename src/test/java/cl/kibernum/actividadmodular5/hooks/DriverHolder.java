package cl.kibernum.actividadmodular5.hooks;

import org.openqa.selenium.WebDriver;
 
public class DriverHolder {
  // almacena un webdriver por hilo, util para ejecución paralela
  private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
 
  public static void set(WebDriver webDriver) {
    driver.set(webDriver);
  }
 
  public static WebDriver get() {
    WebDriver webDriver = driver.get();
    if(webDriver == null) {
      throw new IllegalStateException("WebDriver no inicializado");
    }
    return webDriver;
  }
 
  // Eliminar el webdriver
  public static void remove() {
    driver.remove();
  }
}