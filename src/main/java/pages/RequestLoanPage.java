package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Represents the Request Loan page of the Parabank web and provides methods to interact with the loan application form.
 */
public class RequestLoanPage {
    private WebDriver driver;

    private By loanAmountField = By.id("amount");
    private By downPaymentField = By.id("downPayment");
    private By fromAccountDropDown = By.id("fromAccountId");
    private By applyButton = By.xpath("//input[@value='Apply Now']");
    private By successMessageDivId = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[2]/table/tbody/tr[3]/td[2]");
    private By errorMessageDivId = By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[3]/h1");

    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLoanAmount(String amount) {
        driver.findElement(loanAmountField).sendKeys(amount);
    }

    public void enterDownPayment(String downPayment) {
        driver.findElement(downPaymentField).sendKeys(downPayment);
    }

    public void selectFromAccount(String accountId) {
        driver.findElement(fromAccountDropDown).sendKeys(accountId);
    }

    public void clickApplyButton() {
        driver.findElement(applyButton).click();
    }

    public String retrieveSuccessMessage() {
        // Usar WebDriverWait para esperar a que el elemento sea visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessageDivId)
        );

        // Recuperar el texto del elemento WebElement
        String successMessage = successMessageElement.getText();

        // Imprimir el mensaje de éxito a la consola
        System.out.println("Status: " + successMessage);
        return successMessage;
    }

    public String retrieveErrorMessage() {
        // Usar WebDriverWait para esperar a que el elemento sea visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessageDivId)
        );

        // Recuperar el texto del elemento WebElement
        String errorMessage = errorMessageElement.getText();

        // Imprimir el mensaje de éxito a la consola
        System.out.println("Status: " + errorMessage);
        return errorMessage;
    }
}