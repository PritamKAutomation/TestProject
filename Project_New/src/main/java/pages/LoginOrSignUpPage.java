package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginOrSignUpPage {

	@FindBy (xpath = "//input[contains(@aria-label,'Email')]")
	private WebElement userName;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath = "//button[text()='Log in']")
	private WebElement loginButton;

	public  LoginOrSignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		//acttions =  new Actions(driver);
	}

	public void sendUserName()
	{
		userName.sendKeys("pritamkumbhar28@gmail.com");
	}
	public void enterPassword()
	{
		password.sendKeys("Sparsh@1436");
	}
	public void clickOnLoginButton1()
	{
		loginButton.click();
	}
    public void login()
	{
		userName.sendKeys("sparshak31@gmail.com");
		password.sendKeys("sparshak31@gmail.com");
		loginButton.click();
		
	}
	
}

