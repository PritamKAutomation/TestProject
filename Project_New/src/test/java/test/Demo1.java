package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.SignUpForFB;

public class Demo1 {

public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/login/");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		Thread.sleep(5000);
		SignUpForFB signUpForFB = new SignUpForFB(driver);
		signUpForFB.enteremail();
		signUpForFB.enterfirstname();
		signUpForFB.enterlastname();
		signUpForFB.enterpassword();
		signUpForFB.clickongenderradiobutton();
		signUpForFB.clickonsignup();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		Thread.sleep(5000);
}
}
