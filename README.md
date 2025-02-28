# Selenium 4 - Hybrid TestNG Framework  

## Overview  
This project is a Hybrid Test Automation Framework built using Selenium 4 and TestNG, with Git and GitHub integration. It provides a structured approach to automated testing by combining Data-Driven, Keyword-Driven, and Hybrid methodologies.  

## Project Structure 
TutorialProject/
 ├── src/main/java                  # Main source code
 │   ├── com.tutorialproject.qa.config   
 │   │   ├── config.properties       # Configuration properties
 │   ├── com.tutorialproject.qa.listeners
 │   │   ├── MyListeners.java        # Listeners Java code
 │   ├── com.tutorialproject.qa.pages
 │   │   ├── Account.java            # Account related Page
 │   │   ├── AccountSuccess.java     # Account Success Page
 │   │   ├── HomePage.java           # Home Page
 │   │   ├── LoginPage.java          # Login Page
 │   │   ├── RegisterPage.java       # Register Page
 │   │   ├── SearchPage.java         # Search Page
 │   ├── com.tutorialproject.qa.testdata
 │   │   ├── testdata.properties     # Test Data Properties
 │   │   ├── tutorialProjectTestData.xlsx  # Excel Sheet for Test Data
 │   ├── com.tutorialproject.qa.utils
 │   │   ├── ExtremeReporter.java    # Contains ExtentReports
 │   │   ├── Utilities.java          # Contains Utilities
 ├── src/test/java                   # Test scripts
 │   ├── com.tutorialproject.qa.base
 │   │   ├── Base.java               # Base class
 │   ├── com.tutorialproject.qa.testcases
 │   │   ├── LoginTest.java          # Login Page test cases
 │   │   ├── RegisterTest.java       # Register Page test cases
 │   │   ├── SearchTest.java         # Search Page test cases
 ├── src/test/resources              # Resources
 │   ├── testng.xml                  # TestNG test suite
 ├── JRE System Library               # Java JAR files
 ├── Maven Dependencies               # Maven Dependencies JAR files
 ├── Screenshots                      # Screenshots of error pages
 ├── test-output                      # Test reports and logs
 │   ├── ExtentReport                 # Stores Extent Report
 ├── pom.xml                           # Page Object Model XML file
 ├── README.md                         # Project documentation

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
