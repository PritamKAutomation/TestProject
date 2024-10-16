package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
public static void main(String[] args)  {
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.facebook.com/login/");
		
		//Thread.sleep(5000);
		//driver.manage().window().maximize();
	
		LoginOrSignUpPage x = new LoginOrSignUpPage(driver);
//		x.sendUserName();
//		x.enterPassword();
//		x.clickOnLoginButton();
		//Thread.sleep(5000);
		//driver.close();
	}
}
