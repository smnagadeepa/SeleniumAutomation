package com.tutorialproject.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorials.qa.utils.Utilities;

public class Base {
    WebDriver driver;
    public Properties prop;
    public Properties dataProps;

    public Base() {
        prop = new Properties();
        dataProps = new Properties();
        
        // File paths for properties files
        String configFilePath = System.getProperty("user.dir") + File.separator + 
                                "src" + File.separator + "main" + File.separator + 
                                "java" + File.separator + "com" + File.separator + 
                                "tutorialproject" + File.separator + "qa" + File.separator + 
                                "config" + File.separator + "config.properties";
        
        String dataFilePath = System.getProperty("user.dir") + File.separator + 
                              "src" + File.separator + "main" + File.separator + 
                              "java" + File.separator + "com" + File.separator + 
                              "tutorialproject" + File.separator + "qa" + File.separator + 
                              "testdata" + File.separator + "testdata.properties";
        
        // Load properties
        loadProperties(prop, configFilePath, "Config");
        loadProperties(dataProps, dataFilePath, "Test Data");
    }

    private void loadProperties(Properties properties, String filePath, String fileType) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException(fileType + " properties file not found: " + filePath);
        }

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + fileType + " properties file: " + filePath, e);
        }
    }

    public WebDriver browserOpenURL(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
        driver.get(prop.getProperty("url")); // Load URL from config.properties
        return driver;
    }

    // Method to get test data values
    public String getTestData(String key) {
        return dataProps.getProperty(key);
    }
}
