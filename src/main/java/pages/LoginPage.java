package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By username = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.xpath("//input[@value='Log In']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(this.loginButton).click();
    }
}