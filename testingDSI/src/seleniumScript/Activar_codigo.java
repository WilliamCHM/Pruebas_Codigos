package seleniumScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activar_codigo {
	 // Selenium contiene una clase para trabajar con Chrome, añadimos nombre al objeto.
    // Chrome Driver contiene el código para interactuar con Chrome
    ChromeDriver driver;
    String url = "http://127.0.0.1:8000/login";
    WebDriverWait wait;

    // Método para invocar al navegador Chrome
    @BeforeClass
    public void invocarNavegador() {
        // Ruta donde se encuentra el ejecutable de ChromeDriver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\William\\Desktop\\pruebas\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver(); // Inicializando el objeto
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize(); // Maximizando la ventana
        driver.get(url);
    }


    // Segundo caso de prueba para verificar el login
    @Test(priority = 0)
    public void verificarLoginDeGuru99Application() {
        // Para identificar elementos como el id, Selenium provee una interfaz llamada WebElement
        driver.get("http://127.0.0.1:8000/registro-docente"); // Locator
        
        WebElement correo = driver.findElement(By.id("correo")); // Locator
        WebElement codigo = driver.findElement(By.id("codigo"));
        WebElement btnenviar = driver.findElement(By.id("btnFindByCorreo"));
        
        correo.sendKeys("isp12345@ues.edu.sv");
        codigo.sendKeys("71NMHF");
        btnenviar.click();
        
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("swal2-popup")));
        WebElement botonEstoySeguro = dialog.findElement(By.className("swal2-confirm"));
        botonEstoySeguro.click();
    }

    // Para cerrar el navegador después de todas las pruebas
    @AfterClass
    public void closeBrowser() {
        // Quit cierra todas las pestañas y close cierra únicamente la pestaña activa
        //driver.quit();
    }
}




