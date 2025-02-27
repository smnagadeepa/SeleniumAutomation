package com.tutorialproject.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.tutorialproject.qa.base.Base;
import com.tutorialproject.qa.pages.Account;
import com.tutorialproject.qa.pages.HomePage;
import com.tutorialproject.qa.pages.LoginPage;
import com.tutorials.qa.utils.Utilities;

public class LoginTest extends Base {
	
	public LoginTest() {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginPage;
	Account accountPage;
	
	@BeforeMethod
	public void SetUp() {
		driver=browserOpenURL(prop.getProperty("browser"));
		HomePage homePage=new HomePage(driver);
		loginPage=homePage.navigateToLogin();
	}
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] supplyData() {
		Object[][] data= Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	@Test(priority=1, dataProvider="supplyData")
	public void loginWithValidCredentials(String email,String password) {
		accountPage=loginPage.login(email, password);
		Assert.assertTrue(accountPage.getExpectedMessage(),"Edit your account information.");
	}
		
	@Test(priority=2)
	public void loginWithInvalidCredentials() {
		accountPage=loginPage.login(Utilities.emailWithTimestamp(), dataProps.getProperty("invalidPassword"));
		Assert.assertTrue(accountPage.getInvalidText().contains(dataProps.getProperty("emailPasswordNoMatch")), "Expected warning message is not displyed");
	}
	
	@Test(priority=3)
	public void loginWithInvalidEmail() {
		accountPage=loginPage.login(Utilities.emailWithTimestamp(), prop.getProperty("validPassword"));
		Assert.assertTrue(accountPage.getInvalidText().contains(dataProps.getProperty("emailPasswordNoMatch")), "Expected warning message is not displyed");
	}
	
	@Test(priority=4)
	public void loginWithInvalidPassword() {
		accountPage=loginPage.login(prop.getProperty("validEmail"), dataProps.getProperty("invalidPassword"));
		Assert.assertTrue(accountPage.getInvalidText().contains(dataProps.getProperty("emailPasswordNoMatch")), "Expected warning message is not displyed");
	}
	
	@Test(priority=5)
	public void loginWithNoCredentials() {
		accountPage=loginPage.loginClick();
		Assert.assertTrue(accountPage.getInvalidText().contains(dataProps.getProperty("emailPasswordNoMatch")), "Expected warning message is not displyed");
	}
}