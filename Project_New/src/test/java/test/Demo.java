package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginOrSignUpPage;

public class Demo {
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.facebook.com/login/");
		
		Thread.sleep(5000);
		driver.manage().window().maximize();
	
		LoginOrSignUpPage loginOrSignUpPage= new LoginOrSignUpPage(driver);
		loginOrSignUpPage.sendUserName();
		loginOrSignUpPage.enterPassword();
		loginOrSignUpPage.clickOnLoginButton1();
		loginOrSignUpPage.login();
		
		Thread.sleep(5000);
		//driver.close();
	}
}
