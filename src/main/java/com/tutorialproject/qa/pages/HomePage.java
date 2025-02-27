package com.tutorialproject.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(css="a[title='My Account']")
	private WebElement myAccountDropDown;
	
	@FindBy(linkText="Login")
	private WebElement loginClick;
	
	@FindBy(linkText="Register")
	private WebElement clickOnRegister;
	
	@FindBy(xpath="//div[contains(@id,'search')]/input")
	private WebElement searchInput;
	
	@FindBy(xpath="//div[contains(@id,'search')]/descendant::button")
	private WebElement searchButtonClick;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void clickOnMyAccount() {
		myAccountDropDown.click();
	}
	
	public LoginPage selectLogin() {
		loginClick.click();
		return new LoginPage(driver);
	}
	
	public LoginPage navigateToLogin() {
		myAccountDropDown.click();
		loginClick.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegister() {
		clickOnRegister.click();
		return new RegisterPage(driver);
	}
	
	public RegisterPage navigateToRegister() {
		myAccountDropDown.click();
		clickOnRegister.click();
		return new RegisterPage(driver);
	}
	
	public void searchProductInput(String productName) {
		searchInput.sendKeys(productName);
	}
	
	public SearchPage searchButtonClick() {
		searchButtonClick.click();
		return new SearchPage(driver);
	}
	
	public SearchPage inputAndSearch(String productText) {
		searchInput.sendKeys(productText);
		searchButtonClick.click();
		return new SearchPage(driver);
	}
}

