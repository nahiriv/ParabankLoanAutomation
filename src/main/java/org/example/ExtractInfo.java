package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ExtractInfo {
    public static void main(String[] args) {
        // Inicializa el WebDriver y abre la página
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.applitools.com/");

        // Encuentra los campos de usuario y contraseña y el botón de inicio de sesión
        WebElement userNameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("log-in"));

        // Interactúa con los elementos para iniciar sesión
        userNameField.sendKeys("Nahir");
        passwordField.sendKeys("cambiar123");
        // Espera un momento para permitir que la página cargue
        try {
            Thread.sleep(3000); // Espera 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        submitButton.click();

        try {
            Thread.sleep(3000); // Espera 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Obtiene y muestra el saldo total
        WebElement totalBalance = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]/div[2]/span[1]"));
        System.out.println("Saldo Total: " + totalBalance.getText());

        // Obtiene y muestra el crédito disponible
        WebElement creditAvailable = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div[1]/div[2]/div/div/div/div[2]/div[2]"));
        System.out.println("Crédito Disponible: " + creditAvailable.getText());

        // Encuentra la tabla por su clase
        WebElement table = driver.findElement(By.className("table-padded"));

        // Encuentra todas las filas de la tabla
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Imprime el encabezado de la tabla
        System.out.println("\nDatos de la Tabla:");
        System.out.printf("%-20s %-20s %-20s\n", "Description", "Category", "Amount"); // Ajusta según tus columnas
        System.out.println("--------------------------------------------------------");



        for (WebElement row : rows) {
            // Encuentra todas las celdas en la fila
            List<WebElement> cells = row.findElements(By.tagName("td"));

            for (int i=2; i<cells.size();i++) {
                System.out.printf("%-20s", cells.get(i).getText());
            }
            System.out.println();
        }

        // Cierra el navegador
        driver.quit();
    }
}
