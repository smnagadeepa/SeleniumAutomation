package com.tutorialproject.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
		WebDriver driver;
		@FindBy(id="input-firstname")
		private WebElement enterFirstName;
		
		@FindBy(id="input-lastname")
		private WebElement enterLastName;
		
		@FindBy(id="input-email")
		private WebElement enterEmail;
		
		@FindBy(id="input-telephone")
		private WebElement enterTelephone;
		
		@FindBy(id="input-password")
		private WebElement enterPassword;
		
		@FindBy(id="input-confirm")
		private WebElement enterConfirmPassword;
		
		@FindBy(css="input[value='1'][name='newsletter']")
		private WebElement newsLetter;
		
		@FindBy(name="agree")
		private WebElement policy;
		
		@FindBy(css="input[value='Continue']")
		private WebElement continueRegistration;
		
		@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
		private WebElement PrivacyMessage;
		
		@FindBy(xpath="//input[contains(@id,'input-firstname')]/following-sibling::div")
		private WebElement FirstNameMessage;
		
		@FindBy(xpath="//input[contains(@id,'input-lastname')]/following-sibling::div")
		private WebElement LastNameMessage;
		
		@FindBy(xpath="//input[contains(@id,'input-email')]/following-sibling::div")
		private WebElement EmailMessage;

		@FindBy(xpath="//input[contains(@id,'input-telephone')]/following-sibling::div")
		private WebElement TelephoneMessage;
		
		@FindBy(xpath="//input[contains(@id,'input-password')]/following-sibling::div")
		private WebElement PasswordMessage;
		
		public RegisterPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public void enterfirstName(String firstName) {
			enterFirstName.sendKeys(firstName);
		}
		
		public void enterLastName(String lastName) {
			enterLastName.sendKeys(lastName);
		}
		
		public void enterEmail(String email) {
			enterEmail.sendKeys(email);
		}
		
		public void enterTelephone(String telephone) {
			enterTelephone.sendKeys(telephone);
		}
		
		public void enterPassword(String password) {
			enterPassword.sendKeys(password);
		}
		
		public void enterConfirmPassword(String confirmPassword) {
			enterConfirmPassword.sendKeys(confirmPassword);
		}
		
		public void newsLetter() {
			newsLetter.click();
		}
		
		public void policy() {
			policy.click();
		}
		
		public AccountSuccess continueRegistration() {
			continueRegistration.click();
			return new AccountSuccess(driver);
		}
		
		public AccountSuccess MandatoryForRegister(String firstName, String lastName, String email, String telephone, String password, String confirmPassword){
			enterFirstName.sendKeys(firstName);
			enterLastName.sendKeys(lastName);
			enterEmail.sendKeys(email);
			enterTelephone.sendKeys(telephone);
			enterPassword.sendKeys(password);
			enterConfirmPassword.sendKeys(confirmPassword);
			policy.click();
			continueRegistration.click();
			return new AccountSuccess(driver);
		}
		
		public AccountSuccess AllFieldsForRegister(String firstName, String lastName, String email, String telephone, String password, String confirmPassword){
			enterFirstName.sendKeys(firstName);
			enterLastName.sendKeys(lastName);
			enterEmail.sendKeys(email);
			enterTelephone.sendKeys(telephone);
			enterPassword.sendKeys(password);
			enterConfirmPassword.sendKeys(confirmPassword);
			newsLetter.click();
			policy.click();
			continueRegistration.click();
			return new AccountSuccess(driver);
		}
		
		public String PrivacyMessage() {
			return PrivacyMessage.getText();
		}
		
		public String FistNameMessage() {
			return FirstNameMessage.getText();
		}
		
		public String LastNameMessage() {
			return LastNameMessage.getText();
		}
		
		public String EmailMessage() {
			return EmailMessage.getText();
		}
		
		public String TelephoneMessage() {
			return TelephoneMessage.getText();
		}
		
		public String PasswordMessage() {
			return PasswordMessage.getText();
		}
		
		public boolean WarningMessages(String expectedPrivacyMessage, String expectedFirstNameMessage, String expectedLastNameMessage, String expectedEmailMessage, String expectedTelephoneMessage, String expectedPasswordMessage){
			boolean privacyStatus=PrivacyMessage.getText().contains(expectedPrivacyMessage);
			boolean firstNameStatus=FirstNameMessage.getText().contains(expectedFirstNameMessage);
			boolean lastNameStatus=LastNameMessage.getText().contains(expectedLastNameMessage);
			boolean emailStatus=EmailMessage.getText().contains(expectedEmailMessage);
			boolean telephoneStatus=TelephoneMessage.getText().contains(expectedTelephoneMessage);
			boolean passwordStatus=PasswordMessage.getText().contains(expectedPasswordMessage);
			return privacyStatus && firstNameStatus && lastNameStatus && emailStatus && telephoneStatus && passwordStatus;
		}
	}
