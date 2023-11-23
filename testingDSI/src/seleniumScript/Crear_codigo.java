package seleniumScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Crear_codigo {
	 // Selenium contiene una clase para trabajar con Chrome, añadimos nombre al objeto.
    // Chrome Driver contiene el código para interactuar con Chrome
    ChromeDriver driver;
    WebDriverWait wait;
    String url = "http://127.0.0.1:8000/login";

    // Método para invocar al navegador Chrome
    @BeforeClass
    public void invocarNavegador() {
        // Ruta donde se encuentra el ejecutable de ChromeDriver
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\William\\Desktop\\pruebas\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver(); // Inicializando el objeto
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize(); // Maximizando la ventana
        driver.get(url);
    }


    // Segundo caso de prueba para verificar el login
    @Test(priority = 0)
    public void verificarLoginDeGuru99Application() {
        // Para identificar elementos como el id, Selenium provee una interfaz llamada WebElement
        WebElement userId = driver.findElement(By.name("email")); // Locator
        WebElement userPassword = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        

        // Ejecución con el método sendKeys
        userId.sendKeys("cm18064@ues.edu.sv");
        userPassword.sendKeys("Minerva.23");
        loginButton.click();
        
        
        //WebElement btnCodigo = driver.findElement(By.id("btnGestionCodigos"));
        WebElement elementoPrincipal = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logo-sidebar1")));
        driver.get("http://127.0.0.1:8000/AdministrarCodigos/indexCodigos");
        WebElement crearcodigo = driver.findElement(By.id("creaCodigos"));
        crearcodigo.click();
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("swal2-popup")));

	     // Hacer clic en el botón "Si, crear"
	     WebElement siCrearButton = dialog.findElement(By.cssSelector(".swal2-confirm.swal2-styled.swal2-default-outline"));
	     siCrearButton.click();
	     
	     // Esperar a que aparezca el cuadro de diálogo de éxito
	     WebElement successDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("swal2-popup")));

	     // Hacer clic en el botón "OK" en el cuadro de diálogo de éxito
	     WebElement okButton = successDialog.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
	     okButton.click();
        
    }
    

    // Para cerrar el navegador después de todas las pruebas
    @AfterClass
    public void closeBrowser() {
        // Quit cierra todas las pestañas y close cierra únicamente la pestaña activa
        //driver.quit();
    }
}