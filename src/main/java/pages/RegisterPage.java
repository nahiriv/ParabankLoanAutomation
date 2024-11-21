package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the registration page and provides methods for interacting
 * with the registration form of the Parabank web application.
 */
public class RegisterPage {

    private WebDriver driver;

    private By firstName = By.id("customer.firstName");
    private By lastName = By.id("customer.lastName");
    private By street = By.id("customer.address.street");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phoneNumber = By.id("customer.phoneNumber");
    private By ssn = By.id("customer.ssn");
    private By username = By.id("customer.username");
    private By password = By.id("customer.password");
    private By repeatedPassword = By.id("repeatedPassword");
    private By registerButton = By.xpath("//input[@value='Register']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(this.firstName).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(this.lastName).sendKeys(lastName);
    }

    public void enterStreet(String street) {
        driver.findElement(this.street).sendKeys(street);
    }

    public void enterCity(String city) {
        driver.findElement(this.city).sendKeys(city);
    }

    public void enterState(String state) {
        driver.findElement(this.state).sendKeys(state);
    }

    public void enterZipCode(String zipCode) {
        driver.findElement(this.zipCode).sendKeys(zipCode);
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(this.phoneNumber).sendKeys(phoneNumber);
    }

    public void enterSSN(String ssn) {
        driver.findElement(this.ssn).sendKeys(ssn);
    }

    public void enterUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void enterRepeatedPassword(String repeatedPassword) {
        driver.findElement(this.repeatedPassword).sendKeys(repeatedPassword);
    }

    public void clickRegister() {
        driver.findElement(this.registerButton).click();
    }
}
