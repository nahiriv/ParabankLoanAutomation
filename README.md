# 🚀 SeleniumInfoExtractor

A Java project that utilizes **Selenium WebDriver** to extract valuable information from a web page. This program logs into a demo site and retrieves data such as total balance, available credit, and details of recent transactions. 📊

## 🛠️ Requirements

- **Java 8 or higher** ☕
- **Selenium WebDriver** 🌍
- **ChromeDriver** 🔍
- **Maven** (for dependency management) 📦

## 📥 Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your_username/SeleniumInfoExtractor.git
   ```

2. Navigate to the project directory:
   ```bash
   cd SeleniumInfoExtractor
   ```

3. For using Maven, ensure you include the necessary Selenium dependencies in your pom.xml. 📄

## 🎮 Usage
1. Open the demo site:
Go to https://demo.applitools.com/ in your browser.

2. Log in:
Use any username and password (e.g., myName, 123). 🔑

3. Compile and run the program:
  ```bash
  javac ExtractInfo.java
  java ExtractInfo
  ```

4. The program will launch the browser, log in, and display the results in the console. 💻

## ✨ Features
-Total Balance & Credit Available:
Prints the total balance and available credit in the format $xxxx, excluding percentages. 💵

-Recent Transactions:
Displays recent transactions with their Description, Status, and Amount for each. 📃




