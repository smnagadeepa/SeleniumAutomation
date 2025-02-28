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
3. **Run Tests via Jenkins**
   - Schedule periodic test runs using **Triggers**.
   - Select Build Periodically under Triggers section in Jenkins.
   - Save and Apply changes will save the recent changes
   - Build Now will run all the TestCases.
---

## Git & GitHub Workflow
**For Lead**
1. Open git repositories and create new git repository.  
2. Navigate to local directory > Team > Share Project 
3. Team > Add to Index - will reach the staging area
4. Team > commit - will reach the local repository 
5. Team > Remote > Push
   - Give the copied URL of newly created git repository.
   - Give username and and secret token.
   - Select Master Branch > Add Spec
 6. Finish by providing the username and password(password is generated by generating the token - https://github.com/settings/tokens)
 7. GitHub repository link is shared accorss team and GitHub account of Tester shoulb be added as collaborator(send invite to tester).

**For Tester - Clone** 
 1. To clone the GitHub repository tester should accept the invitation sent by team lead and then import the repository to the local workspace.
 2. Update some changes in the existng file 
 3. To commite updates
    - Team > Add to Index
    - Git repository > Branches > Switch to New Branch
    - Team > Commit (this commit will go to new branch)
 4. Finish by providing the username and password(password is generated by generating the token - https://github.com/settings/tokens) to Push the new branch.
 5. Check whether code is pushed to the branch and create Pull request.

**Pull the code**
1. Go to Pull requests tab.
2. Merge the changes to the Main branch.

### **GitHub and Jenkins integration**
**Run Tests via Jenkins periodically**
   - Install Maven plugin on Jenkins
   - Create Maven Project Job
   - Select Git under SourceCode Management
     - Add repository URL
   - Select Build Periodically and add the timings under Triggers section in Jenkins.
   - Save and Apply changes will save the recent changes
   - Build Now will run all the TestCases.

## Contributors
- Nagadeepa S M - https://github.com/smnagadeepa

