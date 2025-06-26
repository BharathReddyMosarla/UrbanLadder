package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage 
{
	@FindBy(xpath="//*[@class='message']")
	public WebElement OopsMessage;
	
	
	@FindBy(xpath="//*[text()='Continue Browsing']")
	public WebElement ContinueBrowsingButton;
	
	
	@FindBy(xpath="//*[@class='product-img']")
	public List<WebElement> ProductImages;
	
	@FindBy(xpath="//*[@id='header-icon-wishlist']//span[contains(@class,'badge-count')]")
	public WebElement WishlistCount;
	
	@FindBy(xpath="//*[@class='name']")
	public List<WebElement> productnames;
	
	
	@FindBy(xpath="//*[@id='add-to-cart-button']")
	public List<WebElement> AddtoCartButton;
	
	@FindBy(xpath="//*[@class='wishtext']")
	public List<WebElement> AddWishlistbuttons;
	
	
}
