package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SignUpForFB;

public class FB_SignUp {

	private WebDriver driver;
	private SignUpForFB signUpForFB ;
	private HomePage homePage;
	
	@BeforeClass
	void launchBrowser() {
		driver = new ChromeDriver();
	}

	@BeforeMethod
	void beforemethod() throws InterruptedException {
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		signUpForFB= new SignUpForFB(driver);
		
		signUpForFB.enterfirstname();
		signUpForFB.enterlastname();
		signUpForFB.selectday();
		signUpForFB.selectmonth();
		signUpForFB.selectyear();
		signUpForFB.clickongenderradiobutton();
		signUpForFB.enteremail();
		signUpForFB.enterpassword();
		Thread.sleep(5000);
		signUpForFB.clickonsignup();
	}
	
	@Test
	void test_A()
	{
		signUpForFB.clickonsignup();
		if(driver.getCurrentUrl().equals("Actual URL Home Page ")) {
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}
	
	@AfterMethod
	void aftermethod() {
		homePage = new HomePage(driver);
		//homePage.logout();
	}
	@AfterClass
	void afterclass() {
		
		driver.quit(); 	 	
	}
}
