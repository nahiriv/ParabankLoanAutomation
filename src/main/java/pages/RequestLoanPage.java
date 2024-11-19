package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestLoanPage {
    private WebDriver driver;

    private By loanAmountField = By.id("amount");
    private By downPaymentField = By.id("downPayment");
    private By fromAccountDropDown = By.id("fromAccountId");
    private By applyButton = By.xpath("//input[@value='Apply Now']");
    private By successMessageDivId = By.cssSelector("div#loanRequestApproved > p");

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
        return driver.findElement(successMessageDivId).getText();
    }
}