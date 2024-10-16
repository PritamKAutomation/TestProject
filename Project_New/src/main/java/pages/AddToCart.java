package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
	@FindBy(xpath = "//input[@name='field-keywords']")
	private WebElement fieldkeywords;
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement search ;
	@FindBy(xpath = "//button[@id='a-autoid-1-announce']")
	private WebElement addtocart ;
	@FindBy(xpath = "(//a[@class ='a-button-text'])[1]")
	private WebElement gotocart ;
	@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	private WebElement proceedToRetailCheckout ;
	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement ap_email;
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement submit ;
	@FindBy(xpath = "//input[@type = 'password']")
	private WebElement password ;
	@FindBy(xpath = "//input[@id = 'signInSubmit']")
	private WebElement signIn ;
	
	


public AddToCart (WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
	
public void enterfieldkeywords()
{
	fieldkeywords.sendKeys("oneplus");
}
public void enterusername()
{
	ap_email.sendKeys("9970085797");
}
public void enterpassword()
{
	password.sendKeys("Sparsh@1436");
}
public void clickonsignIn()
{
	signIn.click();
}
public void clickoncontinue()
{
	submit.click();
}
public void clickonsearch()
{
	search.click();
}
public void clickonaddtocart()
{
	addtocart.click();
}
public void clickongotocart()
{
	gotocart.click();
}
public void proceedToRetailCheckout()
{
	proceedToRetailCheckout.click();
}
}
