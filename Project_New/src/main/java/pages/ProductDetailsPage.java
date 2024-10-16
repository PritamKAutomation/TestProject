package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {

	@FindBy (xpath = "//h1[@id='title']/span")
	private WebElement productName;
	
	@FindBy (xpath = "(//span[@class='a-price-whole'])[6]")
	private WebElement productPrice;
	
	@FindBy (xpath = "(//input[@id='add-to-cart-button'])[2]")
	private WebElement addToCart;
	
	@FindBy (xpath = "//input[@id='buy-now-button']")
	private WebElement buyNow;
	
	@FindBy (xpath = "//select[@name='quantity']")
	private WebElement quantity;
	
	private WebDriver driver;
	
	public  ProductDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void goToFrame()
	{
		driver.switchTo().frame(buyNow);
	}
	public String getProductName()
	{
		return productName.getText().trim();
	}
	public String getProductPrice()
	{
		return productPrice.getText().trim();
	}
	public void clickOnAddToCart()
	{
		addToCart.click();
	}
	public void clickOnBuyNow()
	{
		buyNow.click();
	}
	public void selectQuantity(String noOfQuantity) 
	{
		Select select = new Select(quantity);
		select.selectByVisibleText(noOfQuantity);
	}
	
}
