package test;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AddToCart;
import pages.HomePage;




public class Amazon {
	private WebDriver driver;
	private AddToCart addToCart ;
	private HomePage homePage;
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
	void launchBrowser() {
		driver = new ChromeDriver();
		
	}

	@BeforeMethod
	void beforemethod() throws InterruptedException {
		driver.get("https://www.amazon.in/?tag=googmantxtmob170-21&ascsubtag=_k_CjwKCAjwgfm3BhBeEiwAFfxrG-tf-0fEFN8AaMHkf6cuU0CPv1ZBEd-zk4uUsE4SKsBtVYvQyTeVOxoC9wkQAvD_BwE_k_");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
		
		
		AddToCart addToCart = new AddToCart(driver);
		addToCart.enterfieldkeywords();
		Thread.sleep(5000);

		addToCart.clickonsearch();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView(true);",addToCart);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(5000);
		addToCart.clickonaddtocart();
		Thread.sleep(5000);
		addToCart.clickongotocart();
		Thread.sleep(5000);
		addToCart.proceedToRetailCheckout();
		Thread.sleep(5000);
		addToCart.enterusername();
		Thread.sleep(5000);
		addToCart.clickoncontinue();
		Thread.sleep(5000);
		addToCart.enterpassword();
		Thread.sleep(5000);
		addToCart.clickonsignIn();
}
	@Test
	void test_A()
	{
//		addToCart.clickonsearch();
//		if(driver.getCurrentUrl().equals("https://www.amazon.in/s?k=oneplus&crid=1FODSB8J74HCV&sprefix=onepl%2Caps%2C205&ref=nb_sb_ss_w_hit-vc-lth_oneplus_k1_2_5 ")) {
		System.out.println("Pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
	}
	
	@AfterMethod
	void aftermethod() {
		homePage = new HomePage(driver);
		//homePage.logout();
	}
	@AfterClass
	void removePOM() {
		
		homePage = null;
//		signInPage = null;
//	    searchResultPage = null;
//	    productDetailsPage = null;
//	    recommendedAccessoriesModule = null;
//	    cartDetailsPage = null;
	    System.gc();
	}
	@AfterTest
	void closedBrowser()
	{
		driver.quit();
	}
	//@AfterClass
//	void afterclass() {
//		
//		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
//		//driver.quit();
//	}

}
