package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartDetailsPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;
import pages.SignInPage;
import pom.modules.RecommendedAccessoriesModule;

public class AmazonTestNGClass {

	private WebDriver driver;
	private HomePage homePage;
	private SignInPage signInPage;
	private SearchResultPage searchResultPage;
	private ProductDetailsPage productDetailsPage;
	private RecommendedAccessoriesModule recommendedAccessoriesModule;
	private CartDetailsPage cartDetailsPage;
	
	
	@BeforeClass
	void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@BeforeMethod
	void loginToAmazon() 
	{
		driver.get("https://www.amazon.in/");
		homePage = new HomePage(driver);
		homePage.clickOnloginButton();
		
		signInPage = new SignInPage(driver);
		signInPage.enteremailOrPhoneNo("9970085797");
		signInPage.clickOnContinue();
		signInPage.enterPassword("Sparsh@1436");
		signInPage.clickOnSignIn();
	}
	@Test
	void verifyAddToCart() throws InterruptedException
	{
		homePage = new HomePage(driver);
		homePage.enterProductName("Mobile");
		Thread.sleep(5000);
		homePage.clickOnFirstSuggesionOption();
		homePage.clickOnSearchButton();
		
		searchResultPage = new SearchResultPage(driver);
		searchResultPage.clickOnSelectItem();
		
		//Child Browser 
		List<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		productDetailsPage = new ProductDetailsPage(driver);
		String expectedProductName = productDetailsPage.getProductName();
		String expectedProductPrice = productDetailsPage.getProductPrice();
		productDetailsPage.clickOnAddToCart();
		
		
		Thread.sleep(5000);
		recommendedAccessoriesModule = new RecommendedAccessoriesModule(driver);
		recommendedAccessoriesModule.goToCartPage();
		
		//Cart Page
		 cartDetailsPage= new CartDetailsPage(driver);
		 Thread.sleep(3000);
	     String actualProductName = cartDetailsPage.getFirstProductName();
		 String actualProductPrice = cartDetailsPage.getfirstProductPrice();

			Assert.assertEquals(actualProductName, expectedProductName);
			Assert.assertEquals(actualProductPrice, expectedProductPrice);
		
	}
	@Test
	void verifyAddToCart1() throws InterruptedException
	{
		homePage = new HomePage(driver);
		homePage.enterProductName("tv");
		Thread.sleep(5000);
		homePage.clickOnFirstSuggesionOption();
		homePage.clickOnSearchButton();
		
		searchResultPage = new SearchResultPage(driver);
		searchResultPage.clickOnSelectItem();
		
		//Child Browser 
		List<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		productDetailsPage = new ProductDetailsPage(driver);
		String expectedProductName = productDetailsPage.getProductName();
		String expectedProductPrice = productDetailsPage.getProductPrice();
		productDetailsPage.clickOnAddToCart();
		
		
		Thread.sleep(5000);
		recommendedAccessoriesModule = new RecommendedAccessoriesModule(driver);
		recommendedAccessoriesModule.goToCartPage();
		
		//Cart Page
		 cartDetailsPage= new CartDetailsPage(driver);
		 Thread.sleep(3000);
	     String actualProductName = cartDetailsPage.getFirstProductName();
		 String actualProductPrice = cartDetailsPage.getfirstProductPrice();

			Assert.assertEquals(actualProductName, expectedProductName);
			Assert.assertEquals(actualProductPrice, expectedProductPrice);
		
	}
	@AfterMethod 
	void logoutFromAmazon() {
	homePage.clickOnlogoutButton();
	}
	
	@AfterClass
	void closeBrower() {
		driver.quit();
	}

}

