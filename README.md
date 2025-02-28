# Selenium 4 - Hybrid TestNG Framework

## Overview
This project is a Hybrid Test Automation Framework built using Selenium 4 and TestNG, with Git and GitHub integration. It provides a structured approach to automated testing by combining Data-Driven, Keyword-Driven, and Hybrid methodologies.

## Project Structure

```
TutorialProject/
 ├── src/main/java                  # Main source code
 │   ├── com.tutorialproject.qa.config  # Configuration file
 │   │   ├── config.properties      # Configuration properties
 │   ├── com.tutorialproject.qa.listeners  # Listeners file
 │   │   ├── MyListeners.java       # Listeners Java code
 │   ├── com.tutorialproject.qa.pages  # Pages
 │   │   ├── Account.java           # Account related Page
 │   │   ├── AccountSuccess.java    # Account Success Page
 │   │   ├── HomePage.java          # Home Page
 │   │   ├── LoginPage.java         # Login Page
 │   │   ├── RegisterPage.java      # Register Page
 │   │   ├── SearchPage.java        # Search Page
 │   ├── com.tutorialproject.qa.testdata  # TestData file
 │   │   ├── testdata.properties    # TestData Properties
 │   │   ├── tutorialProjectTestData.xlsx  # ExcelSheet of TestData
 │   ├── com.tutorialproject.qa.utils  # Utility files
 │   │   ├── ExtremeReporter.java   # Contains ExtentReports
 │   │   ├── Utilities.java         # Contains Utilities
 ├── src/test/java                   # Test scripts
 │   ├── com.tutorialproject.qa.base  # Base class file
 │   │   ├── Base.java              # Base class
 │   ├── com.tutorialproject.qa.testcases  # Contains Test Cases code
 │   │   ├── LoginTest.java         # Login Page test cases
 │   │   ├── RegisterTest.java      # Register Page test cases
 │   │   ├── SearchTest.java        # Search Page test cases
 ├── src/test/resources              # Resources
 │   ├── testng.xml                  # TestNG test suite
 ├── JRE System Library               # Java JAR files
 ├── Maven Dependencies               # Maven Dependencies JAR files
 ├── Screenshots                      # Screenshots of error pages
 ├── test-output                      # Test reports and logs
 │   ├── ExtentReport                 # Stores Extent Report
 ├── pom.xml                           # Project Object Model XML file
 ├── README.md                         # Project documentation
```

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

## 1. Setting Up the Framework

### **Create a Maven Project**
- Use `maven-archetype-quickstart`.
- Add the following dependencies in `pom.xml`:
  - **TestNG** (`org.testng:testng`)
  - **Selenium Java** (`org.seleniumhq.selenium:selenium-java`)
  - **Extent Reports** for test reporting
- Remove JUnit dependencies (if present).

### **Install TestNG Plugin in Eclipse**
- Go to **Maven Repository** and add TestNG Library to pom.xml file.
 
---
 
## 2. Automating Test Cases
 
### **Login Test Cases:**
- Login with **valid credentials**
- Login with **invalid credentials**
- Login with **invalid email and valid password**
- Login with **valid email and invalid password**
- Login with **empty fields**
 
### **Register Test Cases:**

- Register **with mandatory fields**
- Register **with all fields**
- Register with **duplicate email**
- Register with **empty fields**
  
### **Create Utility & Base Classes:**
- **Utility Class:** Manages reusable functions(`generateEmailWithTimeStampMethod()` is moved).
- **Base Class:** Handles browser setup (initializing browser and opening application URL).

---
 
## 3. Running & Managing Test Cases
 
### **Run Tests in Batch:**
- Use `testng.xml` for batch execution.
- Organize test files under `src/test/resources`.

### **Remove Hardcoding:**
- Store browser, URL, and credentials in `config.properties`.
- Read data using `testdata.properties` class.
 
### **Implement Data-Driven Testing:**
- Store test data in Excel (`TutorialsNinjaTestData.xlsx`).
- Use **Apache POI** to read data dynamically.
 
---
 
## 4. Optimizing & Enhancing the Framework
 
### **Implement Page Object Model (POM) & Page Factory:**
- **POM:** Create separate **Page classes** for Login, Registration, etc.
- **Page Factory:** Use `@FindBy` for locating elements and `PageFactory.initElements(driver, this)` for initializing elements automatically.
 
### **Reduce Redundant Code:**
- Move browser setup, URL initialization, and common functions to **Base Class**.
 
### **Implement Listeners:**
- Capture screenshots on test failures using `ITestListener`.
 
---
 
## 5. Extent Reports & Logging
 
### **Generate Extent Reports:**
1. Configure Extent Reports in the ExtentReport Class in Utils package.
2. Embed screenshots for failed test cases:
   ```java
   String screenshotPath = "path/to/screenshot.png";

   test.addScreenCaptureFromPath(screenshotPath);
   ```
3. Auto-launching extent report after test execution.
 
---
 
## 6. Jenkins Integration
 
### **Install & Run Jenkins:**
- Download Jenkin.war file.
- Run Jenkins using:
  ```sh
  java -jar jenkins.war 
  ```
- Open Jenkins in a browser: `http://localhost:8080/`.
- To run Jenkins at different port:  `java -jar jenkins.war --httpPort=9192`.

### **Configure Jenkins for Test Execution:**
1. **Install Plugins:** TestNG.
2. **Create a Job:**
   - Choose **Freestyle Project**.
   - Enter description.
   - Under build steps
     - Invoke Top-Level Maven targets
     - Maven Version - MAVEN_HOME
     - Goal - (path of the project)
3. **Run Tests via Jenkins:**
   - Configure **Maven Goals:**
     ```sh
     clean test
     ```
   - Schedule periodic test runs using **cron jobs**.
---

### Installation
1. Navigate to the working project directory:  
   ```sh
   cd selenium-hybrid-framework
   ```
2. Navigate to the working project directory:  
   ```sh
   cd selenium-hybrid-framework
   ```  
3. Install dependencies:  
   ```sh
   mvn clean install
   ```  

### Running the Tests
- Run all tests using TestNG:  
  ```sh
  mvn test
  ```  
- Execute a specific test suite:  
  ```sh
  mvn test -DsuiteXmlFile=testng.xml
  ```  

### Test Reports
- TestNG reports: `test-output/index.html`  
- Extent reports: `test-output/ExtentReport.html`  

## Git & GitHub Workflow
1. Clone repository: `git clone <repo-url>`  
2. Create a new branch: `git checkout -b feature-branch`  
3. Commit changes: `git commit -m "Your commit message"`  
4. Push changes: `git push origin feature-branch`  
5. Create a Pull Request (PR) on GitHub  

## Contributors
- Nagadeepa S M - https://github.com/smnagadeepa

