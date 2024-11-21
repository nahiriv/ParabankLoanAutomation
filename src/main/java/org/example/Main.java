package org.example;

import pages.RegisterPage;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RequestLoanPage;


public class Main {

    public static final String REGISTER_URL = "https://parabank.parasoft.com/parabank/register.htm";
    public static final String OVERVIEW_URL = "https://parabank.parasoft.com/parabank/overview.htm"; // Added overview URL

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();

            // Maximize the browser window
            driver.manage().window().maximize();

            // Registration process
            driver.get(REGISTER_URL);
            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.enterFirstName("rauw");
            registerPage.enterLastName("alejandro");
            registerPage.enterStreet("123 Main St");
            registerPage.enterCity("Anytown");
            registerPage.enterState("CA");
            registerPage.enterZipCode("12345");
            registerPage.enterPhoneNumber("555-123-4567");
            registerPage.enterSSN("123-45-6789");
            registerPage.enterUsername("rauw");
            registerPage.enterPassword("password123");
            registerPage.enterRepeatedPassword("password123");
            registerPage.clickRegister();

            // Login process
            driver.get(REGISTER_URL); // Corrected URL to login
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUsername("rauw");
            loginPage.enterPassword("password123");
            loginPage.clickLogin();

            // Navigate to overview page
            driver.get(OVERVIEW_URL);

            // Click on the loan part (assume the "Loan" link has an ID 'loanLink')
            By requestLoanLink = By.linkText("Request Loan");
            driver.findElement(requestLoanLink).click();
            // Wait for 10 seconds

            RequestLoanPage requestLoanPage = new RequestLoanPage(driver);
            requestLoanPage.enterLoanAmount("100");
            requestLoanPage.enterDownPayment("80");
            requestLoanPage.clickApplyButton();
            Thread.sleep(20000); // Adjusted time to 10 seconds instead of 30

            // Retrieve and print the success message
            String successMessage = driver.findElement(By.id("loanRequestApproved")).getText();
            System.out.println("Success Message: " + successMessage);

            Thread.sleep(20000); // Adjusted time to 10 seconds instead of 30
        } catch (Exception e) {
            e.printStackTrace(); // Improved error handling
        } finally {
            if (driver != null) {
                driver.quit(); // Ensure driver is closed properly
            }        }
    }
}