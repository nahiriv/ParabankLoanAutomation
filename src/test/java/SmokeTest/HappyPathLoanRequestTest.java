package SmokeTest; // Adjust based on your package structure

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class HappyPathLoanRequestTest {

    private static final String LOGIN_URL = "https://parabank.parasoft.com/parabank/login.htm";
    private static final String OVERVIEW_URL = "https://parabank.parasoft.com/parabank/overview.htm";
    private static final String REQUEST_LOAN_URL = "https://parabank.parasoft.com/parabank/requestloan.htm";
    private static final String SUCCESS_MESSAGE = "Loan request has been successfully submitted.";

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testHappyPathLoanRequest() {
        // Login process
        driver.get(LOGIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("johndoe");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();

        // Navigate to overview page
        driver.get(OVERVIEW_URL);

        // Click on the "Request Loan" link
        By requestLoanLink = By.linkText("Request Loan");
        driver.findElement(requestLoanLink).click();

        // Wait for the Request Loan page to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe(REQUEST_LOAN_URL));

        // Fill in the loan details
        WebElement loanAmountField = driver.findElement(By.id("amount"));
        loanAmountField.sendKeys("5000");
        WebElement downPaymentField = driver.findElement(By.id("downPayment"));
        downPaymentField.sendKeys("1000");
        WebElement fromAccountDropDown = driver.findElement(By.id("fromAccountId"));
        fromAccountDropDown.sendKeys("12345"); // Assumes the user has an account with ID "12345"

        // Submit the loan request
        WebElement applyButton = driver.findElement(By.xpath("//input[@value='Apply Now']"));
        applyButton.click();

        // Verify successful submission
        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("title")));
        Assert.assertTrue("Loan request submission failed.", successMessage.getText().contains(SUCCESS_MESSAGE));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}