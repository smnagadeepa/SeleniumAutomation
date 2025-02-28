# Selenium 4 - Hybrid TestNG Framework  

## Overview  
This project is a Hybrid Test Automation Framework built using Selenium 4 and TestNG, with Git and GitHub integration. It provides a structured approach to automated testing by combining Data-Driven, Keyword-Driven, and Hybrid methodologies.  

## Project Structure 
TutorialProject/
├── src/main/java # Main source code
    ├── com.tutorialproject.qa.config # Configuration file
        ├── config.properties # Configuration properties
    ├── com.tutorialproject.qa.listeners # Listeners file
        ├── MyListeners.java # Listeners java code
    ├── com.tutorialproject.qa.pages # Pages
        ├── Account.java # Account related Page
        ├── AccountSuccess.java # Account Success Page 
        ├── HomePage.java # Home Page
        ├── LoginPage.java # Login Page
        ├── RegisterPage.java # Register Page
        ├── SearchPage.java # Search Page
    ├── com.tutorialproject.qa.tesdata # TestData file
        ├── testdata.properties # TestData Properties
        ├── tutorialProjectTestData.xlsx # ExcelSheet of TestData
    ├── com.tutorialproject.qa.utils # TestData file
        ├── ExtremeReporter.java # Contains ExtentReports
        ├── Utilites.java # Contains Utilities
├── src/test/java # Test scripts
    ├── com.tutorialproject.qa.base # Base class file
        ├── Base.java # Base class 
    ├── com.tutorialproject.qa.testcases # Contains Test Cases code
        ├── LoginTest.java # Contains login page test cases
        ├── RegisterTest.java # Contains register page test cases
        ├── SearchTest.java # Contains search page test cases
├── src/test/resource # resources
    ├── testng.xml # TestNG test suite
├── JRE System Library # Java JAr files
├── Maven Dependencies # Maven Dependencies JAr files
├── Screenshots # Screenshots of error pages
├── src file # SOurce file
    ├── main # main file
    ├── test # test file
├── test-output # Test reports and logs
    ├── ExtentReport # Stores ExtentReport
├── pom.xml # Page Object Model xml file
├── README.md # Project documentation

## Technologies Used  
- **Programming Language:** Java  
- **Automation Framework:** Selenium 4  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **Version Control:** Git & GitHub  

## Features  
- Cross-browser testing  
- Data-driven testing using Excel  
- Keyword-driven testing approach  
- Page Object Model (POM) implementation  
- Parallel execution using TestNG  
- Logging and Reporting with Extent Reports  

## Getting Started  

### Prerequisites  
Ensure the following are installed:  
- Java JDK 8 or higher  
- Apache Maven  
- Selenium WebDriver  
- TestNG  
- Git  

### Installation  
1. Clone the repository:  
   ```sh
   git clone https://github.com/your-repo/selenium-hybrid-framework.git
