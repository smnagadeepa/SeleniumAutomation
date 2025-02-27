//Nagadeepa Added New Comment.
//I have added few more details and this may be helpful for the project.
package com.tutorialproject.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialproject.qa.base.Base;
import com.tutorialproject.qa.pages.HomePage;
import com.tutorialproject.qa.pages.SearchPage;

public class SearchTest extends Base {
	
	public SearchTest() {
		super();
	}
	
	public WebDriver driver;
	SearchPage searchPage;	
	HomePage homePage;
	
	@BeforeMethod
	public void SetUp() {
		driver=browserOpenURL(prop.getProperty("browser"));
		homePage=new HomePage(driver);
	}
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void searchWithExistingProduct() {
		searchPage=homePage.inputAndSearch(prop.getProperty("existingItem"));
		Assert.assertTrue(searchPage.DisplayValidSearch());
	}
	
	@Test(priority=2)
	public void searchWithNonExistingProduct() {
		searchPage=homePage.inputAndSearch(prop.getProperty("NonExistingItem"));
		Assert.assertEquals(searchPage.SearchInputWarning(),dataProps.getProperty("nonExistingSearchWarning"),"No product after search is found");
	}
	
	@Test(priority=3,dependsOnMethods= {"searchWithNonExistingProduct","searchWithExistingProduct"})
	public void searchWithNotingEntered() {
		searchPage=homePage.searchButtonClick();
		Assert.assertEquals(searchPage.NoInputWarning(),dataProps.getProperty("nonExistingSearchWarning"),"No product after search is found");
	}	
}
