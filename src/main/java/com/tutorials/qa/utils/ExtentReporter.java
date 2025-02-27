package com.tutorials.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	public static ExtentReports generateExtentReport() {
		ExtentReports extentReport=new ExtentReports();
		
		File extentReportsFile=new File(System.getProperty("user.dir")+File.separator + 
                "test-output" + File.separator + "ExtentReport" + File.separator + 
                "extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportsFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialProject test automation results report.");
		sparkReporter.config().setDocumentTitle("TP automation report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentReport.attachReporter(sparkReporter);
		
		Properties configProp=new Properties();
		File configPropFile=new File(System.getProperty("user.dir") + File.separator + 
                "src" + File.separator + "main" + File.separator + 
                "java" + File.separator + "com" + File.separator + 
                "tutorialproject" + File.separator + "qa" + File.separator + 
                "config" + File.separator + "config.properties");
		try {
			FileInputStream file=new FileInputStream(configPropFile);
			configProp.load(file);
			}
			catch(Throwable e){
				e.printStackTrace();
			}

		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", configProp.getProperty("browser"));
		extentReport.setSystemInfo("Email", configProp.getProperty("validEmail"));
		extentReport.setSystemInfo("Password", configProp.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		return extentReport;
	}
}
