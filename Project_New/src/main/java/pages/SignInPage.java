package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement emailOrPhoneNo;
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueButton ;
	@FindBy(xpath = "//input[@type = 'password']")
	private WebElement password ;
	@FindBy(xpath = "//input[@id = 'signInSubmit']")
	private WebElement signIn ;
	
	public SignInPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	public void enteremailOrPhoneNo(String userId)
	{
		emailOrPhoneNo.sendKeys(userId);
	}
	public void enterPassword(String userPassword)
	{
		password.sendKeys(userPassword);
	}
	public void clickOnContinue()
	{
		continueButton.click();
	}
	public void clickOnSignIn()
	{
		signIn.click();
	}
}
