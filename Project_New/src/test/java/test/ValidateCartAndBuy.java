package test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CartDetailsPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;
import pages.SignInPage;
import pom.modules.RecommendedAccessoriesModule;
import utils.Utility;

public class ValidateCartAndBuy {

	private WebDriver driver;
	private HomePage homePage;
	private SignInPage signInPage;
	private SearchResultPage searchResultPage;
	private ProductDetailsPage productDetailsPage;
	private RecommendedAccessoriesModule recommendedAccessoriesModule;
	private CartDetailsPage cartDetailsPage;
	private List<String> browserAddress;
	
	@Parameters("browser")
	@BeforeTest
	void launchbrowser(String expectedBrowser)
	{
		System.out.println("expectedBrowser");
		if (expectedBrowser.equals("Chrome"))
		{
			driver =new ChromeDriver();
		}
		if (expectedBrowser.equals("Firefox"))
		{
			driver =new FirefoxDriver();
		}
		if (expectedBrowser.equals("Edge"))
		{
			driver =new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@BeforeClass
	void initializePOM() {
		
		homePage = new HomePage(driver);
		signInPage = new SignInPage(driver);
		searchResultPage = new SearchResultPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		recommendedAccessoriesModule = new RecommendedAccessoriesModule(driver);
		cartDetailsPage= new CartDetailsPage(driver);
	}
	
	@BeforeMethod
	void loginToAmazon() throws EncryptedDocumentException, IOException 
	{
		driver.get("https://www.amazon.in/");
		homePage.clickOnloginButton();
		signInPage.enteremailOrPhoneNo(Utility.getDataFromExcel( "sheet1", 0,0));
		signInPage.clickOnContinue();
		signInPage.enterPassword(Utility.getDataFromExcel( "sheet1", 0,1));
		signInPage.clickOnSignIn();
	}
	
	@Test
	void verifyAddToCart() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		homePage.enterProductName(Utility.getDataFromExcel("sheet1", 0,2));
		Thread.sleep(5000);
		homePage.clickOnFirstSuggesionOption();
		homePage.clickOnSearchButton();
		searchResultPage.clickOnSelectItem();
		
		//Child Browser 
		browserAddress = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(browserAddress.get(1));
		
		
		String expectedProductName = productDetailsPage.getProductName();
		String expectedProductPrice = productDetailsPage.getProductPrice();
		//productDetailsPage.scrollUntilAddToCartButton();
		productDetailsPage.selectQuantity("3");
		productDetailsPage.clickOnAddToCart();
		
		
		Thread.sleep(5000);
		recommendedAccessoriesModule = new RecommendedAccessoriesModule(driver);
		recommendedAccessoriesModule.goToCartPage();
		
		//Cart Page
		 
	     String actualProductName = cartDetailsPage.getFirstProductName();
		 String actualProductPrice = cartDetailsPage.getfirstProductPrice();
		 String actualQuantity = cartDetailsPage.getQuantity();
		 
		    SoftAssert softAssert = new SoftAssert();
			Assert.assertEquals(actualProductName, expectedProductName);
			Assert.assertEquals(actualProductPrice, expectedProductPrice);
			softAssert.assertEquals(actualQuantity, "3");
			softAssert.assertAll();
			
	}
	@AfterMethod 
	void logoutFromAmazon() {
		
	cartDetailsPage.deleteProductFromCart();	
	driver.close();
	driver.switchTo().window(browserAddress.get(0));
	homePage.clickOnlogoutButton();
	}
	
	@AfterClass
	void removePOM() {
		
		homePage = null;
		signInPage = null;
	    searchResultPage = null;
	    productDetailsPage = null;
	    recommendedAccessoriesModule = null;
	    cartDetailsPage = null;
	    System.gc();
	}
	@AfterTest
	void closedBrowser()
	{
		driver.quit();
	}
}
