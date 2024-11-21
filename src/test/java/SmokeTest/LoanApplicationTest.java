package SmokeTest;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterPage;
import pages.LoginPage;
import pages.RequestLoanPage;
import static org.junit.Assert.assertEquals;

/**
 * This class contains test cases for the Loan Application process on the ParaBank website.
 * It uses Selenium WebDriver to automate browser actions for testing the loan application workflow.
 *
 * The test involves the following stages:
 * 1. Registration of a new user
 * 2. Login with the registered user credentials
 * 3. Requesting a loan using the logged-in user's account
 *
 * Methods:
 * - setUp: Initializes the WebDriver and page objects before each test.
 * - testHappyPath: Tests the entire happy path from registration to loan approval.
 * - tearDown: Quits the WebDriver after each test.
 *
 * Constants:
 * - REGISTER_URL: The URL for the registration page.
 * - OVERVIEW_URL: The URL for the account overview page.
 *
 * Dependencies:
 * - WebDriver: Used for browser automation.
 * - RegisterPage: Page object for the registration page.
 * - LoginPage: Page object for the login page.
 * - RequestLoanPage: Page object for the loan request page.
 */
public class LoanApplicationTest {

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
    public void testHappyPath() throws InterruptedException {
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
        requestLoanPage.enterLoanAmount("300");
        Thread.sleep(500);
        requestLoanPage.enterDownPayment("50");
        Thread.sleep(500);
        requestLoanPage.clickApplyButton();

        String approvedMessage = requestLoanPage.retrieveSuccessMessage();
        assertEquals("Approved", approvedMessage);
    }

    @After
   public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        }
}

