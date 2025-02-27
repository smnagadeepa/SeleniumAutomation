package com.tutorialproject.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(id="input-email")
	private WebElement emailAddress;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(css="input[value='Login']")
	private WebElement clickOnLogin;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void enterEmailAddress(String emailText) {
		emailAddress.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public Account loginClick() {
		clickOnLogin.click();
		return new Account(driver);
	}
	
	public Account login(String emailText, String passwordText) {
		emailAddress.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		clickOnLogin.click();
		return new Account(driver);
	}
}
