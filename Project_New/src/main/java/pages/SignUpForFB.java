package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpForFB {
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstname;
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastname;
	@FindBy(xpath = "//input[@name='reg_email__']")
	private WebElement email ;
	@FindBy(xpath = "//input[@name='reg_passwd__']")
	private WebElement password ;
	@FindBy(xpath = "//select[@id='day']")
	private WebElement day ;
	@FindBy(xpath = "//select[@id='month']")
	private WebElement month ;
	@FindBy(xpath = "//select[@id='year']")
	private WebElement year ;
	@FindBy(xpath = "//input[@value='1']")
	private WebElement gender ;
	@FindBy(xpath = "//button[@name='websubmit']")
	private WebElement signup ;
	
	//Variable Initialization->Public Constructor->Page Factory
	public SignUpForFB (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterfirstname()
	{
		firstname.sendKeys("Sparsha");
	}
	public void enterlastname()
	{
		lastname.sendKeys("King");
	}
	public void enteremail()
	{
		email.sendKeys("sparshak31@gmail.com");
	}
	public void enterpassword()
	{
		password.sendKeys("Welcome@2024");
	}
	public void selectday()
	{
		Select s = new Select(day);
		s.selectByVisibleText("11");
	}
	public void selectmonth()
	{
		Select s = new Select(month);
		s.selectByVisibleText("Apr");
	}
	public void selectyear()
	{
		Select s = new Select(year);
		s.selectByVisibleText("1992");
	}
	public void clickongenderradiobutton()
	{
		gender.click();
	}
	public void clickonsignup()
	{
		signup.click();
	}
}
