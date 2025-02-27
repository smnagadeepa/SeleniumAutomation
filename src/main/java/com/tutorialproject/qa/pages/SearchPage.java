package com.tutorialproject.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement SearchInputWarning;
	
	@FindBy(xpath="//h2/following-sibling::p")
	private WebElement NoInputWarning;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean DisplayValidSearch() {
		return validHPProduct.isDisplayed();
	}
	
	public String SearchInputWarning() {
		return SearchInputWarning.getText();
	}
	
	public String NoInputWarning() {
		return NoInputWarning.getText();
	}
}
