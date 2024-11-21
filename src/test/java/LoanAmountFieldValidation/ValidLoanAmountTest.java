package LoanAmountFieldValidation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterPage;
import pages.LoginPage;
import pages.RequestLoanPage;
import static org.junit.Assert.assertEquals;


/**
 * This class contains tests that validate the loan amount request functionality
 * on the Parabank web application. It performs the following sequences:
 * setting up the WebDriver, registering a new user, logging in with the new user,
 * requesting a loan, and verifying the loan approval.
 */
public class ValidLoanAmountTest {

    private WebDriver driver;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private RequestLoanPage requestLoanPage;

    private static final String REGISTER_URL = "https://parabank.parasoft.com/parabank/register.htm";
    private static final String OVERVIEW_URL = "https://parabank.parasoft.com/parabank/overview.htm";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        requestLoanPage = new RequestLoanPage(driver);
    }

    @Test
    public void testValidLoanAmount() throws InterruptedException {
        // Registro
        driver.get(REGISTER_URL);
        registerPage.enterFirstName("John");
        registerPage.enterLastName("Doe");
        registerPage.enterStreet("123 Main St");
        registerPage.enterCity("Anytown");
        registerPage.enterState("CA");
        registerPage.enterZipCode("12345");
        registerPage.enterPhoneNumber("555-123-4567");
        registerPage.enterSSN("123-45-6789");
        registerPage.enterUsername("johndoe");
        registerPage.enterPassword("password123");
        registerPage.enterRepeatedPassword("password123");
        registerPage.clickRegister();

        // Login
        driver.get(REGISTER_URL);
        loginPage.enterUsername("johndoe");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();


        // Solicitar préstamo
        driver.get(OVERVIEW_URL);
        Thread.sleep(500); // Adjusted time to 10 seconds instead of 30
        By requestLoanLink = By.linkText("Request Loan");
        driver.findElement(requestLoanLink).click();
        Thread.sleep(500);
        requestLoanPage.enterLoanAmount("500");
        Thread.sleep(500);
        requestLoanPage.enterDownPayment("50");
        Thread.sleep(500);
        requestLoanPage.clickApplyButton();

        String errorMessage = requestLoanPage.retrieveSuccessMessage();
        assertEquals("Approved", errorMessage);
        Thread.sleep(1000);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}