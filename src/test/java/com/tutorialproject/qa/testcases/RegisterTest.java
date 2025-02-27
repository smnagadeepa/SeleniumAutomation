package com.tutorialproject.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialproject.qa.base.Base;
import com.tutorialproject.qa.pages.AccountSuccess;
import com.tutorialproject.qa.pages.HomePage;
import com.tutorialproject.qa.pages.RegisterPage;
import com.tutorials.qa.utils.Utilities;
import org.openqa.selenium.WebDriver;

public class RegisterTest extends Base{
	
	public RegisterTest() {
		super();
	}
	
	public WebDriver driver;
	RegisterPage registerPage;
	AccountSuccess accountSuccess;
	
	@BeforeMethod
	public void SetUp() {
		driver=browserOpenURL(prop.getProperty("browser"));
		HomePage homePage=new HomePage(driver);
		registerPage=homePage.navigateToRegister();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void registerWithAllCredentials() {
		accountSuccess=registerPage.AllFieldsForRegister(dataProps.getProperty("firstName"), dataProps.getProperty("lastName"), Utilities.emailWithTimestamp(), dataProps.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertEquals(accountSuccess.SuccessHeading(), dataProps.getProperty("accountCreationSuccess"), "Account Success Page is not Displayed");
	} 
	
	@Test(priority=2)
	public void registerWithOnlyMandatoryCredentials() {
		accountSuccess=registerPage.MandatoryForRegister(dataProps.getProperty("firstName"), dataProps.getProperty("lastName"), Utilities.emailWithTimestamp(), dataProps.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertEquals(accountSuccess.SuccessHeading(), dataProps.getProperty("accountCreationSuccess"), "Account Success Page is not Displayed");
	}
	
	@Test(priority=3)
	public void alreadyRegistered() {
		accountSuccess=registerPage.AllFieldsForRegister(dataProps.getProperty("firstName"), dataProps.getProperty("lastName"), prop.getProperty("validEmail"), dataProps.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertEquals(accountSuccess.AccountExists(), dataProps.getProperty("alreadyRegistered"), "Account Success Page is not Displayed");
	}
	
	@Test(priority=4)
	public void registerWithoutAnyDetails() {
		accountSuccess=registerPage.continueRegistration();
		Assert.assertTrue(registerPage.WarningMessages(dataProps.getProperty("enterDetails"), dataProps.getProperty("enterFirstName"), dataProps.getProperty("enterLastName"), dataProps.getProperty("enterEmail"), 
				dataProps.getProperty("enterTelephone"), dataProps.getProperty("enterPassword")),"Warning message (s) is/are not displayed!");
	}

	
}
