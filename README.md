# 📈 Parabank Loan Information Extractor

A Java project utilizing **Selenium WebDriver** to automate user interactions with the Parabank demo site, including registration, login, and loan request functionality. 🌐

## 💼 Representative Test Cases

This project includes thorough testing of the following representative test cases to ensure robust functionality:

1. **Request Loan: Navigation from Main Menu (high priority)**:
   - Ensures that navigation to the loan request page from the main menu is functioning correctly.

2. **Request Loan: Successfully Applying for a Loan (high priority)**:
   - Tests the process of successfully applying for a loan with valid input data.

3. **Request Loan: Loan Amount Field Validation (medium priority)**:
   - Verifies that the loan amount field correctly validates user input, ensuring that only acceptable values are submitted.

## 🗂️ Project Structure
```bash
ParabankLoan/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org.example/
│   │           └── Main.java
│   │           └── pages/
│   │               ├── LoginPage.java
│   │               ├── RegisterPage.java
│   │               └── RequestLoanPage.java
│   │               
│   └── test/
│       └── java/
│           └── LoanAmountFieldValidation/
│               ├── ValidLoanEP.java
│                   └── ... (additional test cases)
│           └── LoanAmountFieldValidation/
├── pom.xml
└── README.md


## 🛠️ Requirements

- **Java 8 or higher** ☕
- **Selenium WebDriver** 🌍
- **ChromeDriver** 🔍
- **JUnit** (for testing) 🧪
- **Maven** (for dependency management) 📦

## 📦 Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your_username/ParabankLoan.git
   ```
2. **Navigate to the project directory:**
   ```bash
   cd ParabankLoan
   ```
3. **Ensure Selenium dependencies are included in your `pom.xml`:**
   ```xml
   <dependencies>
       <!-- Add your dependencies here -->
       <dependency>
           <groupId>org.seleniumhq.selenium</groupId>
           <artifactId>selenium-java</artifactId>
           <version>4.1.2</version>
       </dependency>
       <dependency>
           <groupId>junit</groupId>
           <artifactId>junit</artifactId>
           <version>4.13.2</version>
           <scope>test</scope>
       </dependency>
       <!-- Add other necessary dependencies -->
   </dependencies>
   ```

