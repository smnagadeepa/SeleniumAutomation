package com.tutorialproject.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccess {
	WebDriver driver;
	
	@FindBy(css="div[id='content'] h1")
	private WebElement AccountSuccessHeading;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement AccountExists;
	
	public AccountSuccess(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String SuccessHeading() {
		return AccountSuccessHeading.getText();
	}
	
	public String AccountExists() {
		return AccountExists.getText();
	}
}
