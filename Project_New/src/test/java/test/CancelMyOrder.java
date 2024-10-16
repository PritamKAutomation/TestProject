package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AddToCart;
import pages.CancelOrder;
import pages.HomePage;

public class CancelMyOrder {

	private WebDriver driver;
	private CancelOrder cancelOrder ;
	@BeforeClass
	void launchBrowser() {
		driver = new ChromeDriver();
	}
		@BeforeMethod
		void beforemethod() throws InterruptedException {
			driver.get("https://www.amazon.in/");
			Thread.sleep(5000);
			driver.manage().window().maximize();
			
			CancelOrder cancelOrder = new CancelOrder(driver);
			
			
			cancelOrder.clickonorders();
			AddToCart addToCart = new AddToCart(driver);
			addToCart.enterusername();
			addToCart.clickoncontinue();
			Thread.sleep(5000);
			addToCart.enterpassword();
			Thread.sleep(5000);
			addToCart.clickonsignIn();
			Thread.sleep(5000);
			cancelOrder.clickonviewdetails();
			Thread.sleep(5000);
			cancelOrder.clickoncancel();
			Thread.sleep(5000);
			cancelOrder.selectcancelreason();
			Thread.sleep(5000);
			cancelOrder.clickoncancelorder();
}

		@Test
		void test_A()
		{
//			addToCart.clickonsearch();
//			if(driver.getCurrentUrl().equals("https://www.amazon.in/s?k=oneplus&crid=1FODSB8J74HCV&sprefix=onepl%2Caps%2C205&ref=nb_sb_ss_w_hit-vc-lth_oneplus_k1_2_5 ")) {
			System.out.println("Pass");
//			}
//			else
//			{
//				System.out.println("Fail");
//			}
		}
		
		@AfterMethod
		void aftermethod() {
//			homePage = new HomePage(driver);
//			homePage.logout();
		}
		@AfterClass
		void afterclass() {
			
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			//driver.quit();
		}

}
