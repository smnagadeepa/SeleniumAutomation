package com.tutorialproject.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account {
	WebDriver driver;
	
	@FindBy(linkText="Edit your account information")
	private WebElement AccountStatus;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement InvalidText;
	
	public Account(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getExpectedMessage() {
		return AccountStatus.isDisplayed();
	}
	
	public String getInvalidText() {
		return InvalidText.getText();
	}
}
