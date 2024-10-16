package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginOrSignUpPage;

public class FB_Login {
	
	private WebDriver driver;
	private LoginOrSignUpPage loginOrSignUpPage ;
	private HomePage homePage;
	
	@BeforeClass
	void launchbrowser() {
		driver = new ChromeDriver();
	}

	@BeforeMethod
	void LoggingToApplication() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		loginOrSignUpPage= new LoginOrSignUpPage(driver);
		loginOrSignUpPage.sendUserName();
		loginOrSignUpPage.enterPassword();
		
	}
	
	@Test
	void test_A()
	{
		loginOrSignUpPage.clickOnLoginButton1();
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
