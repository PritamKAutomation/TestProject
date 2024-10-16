package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CancelOrder {
	
	@FindBy(xpath = "//span[@class='nav-action-inner']")
	private WebElement account ;
	@FindBy(xpath = "//a[@id='nav-orders']")
	private WebElement orders ;
	@FindBy(xpath = "//a[@id='a-autoid-3-announce']")
	private WebElement viewdetails ;
	@FindBy(xpath = "//a[@id='Cancel-items_1']")
	private WebElement cancel ;
	@FindBy(xpath = "//select[@name='cancel.reason']")
	private WebElement cancelreason ;
	@FindBy(xpath = "//input[@name='cq.submit']")
	private WebElement cancelorder ;
	
	public CancelOrder (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickonaccount()
	{
		account.click();
	}
	public void clickonorders()
	{
		orders.click();
	}
	public void clickonviewdetails()
	{
		 viewdetails.click();
	}
	public void clickoncancel()
	{
		cancel.click();
	}
	public void clickoncancelorder()
	{
		cancelorder.click();
	}
	
	public void selectcancelreason()
	{
		Select s = new Select(cancelreason);
		s.selectByValue("foundCheaper");
	}
}

