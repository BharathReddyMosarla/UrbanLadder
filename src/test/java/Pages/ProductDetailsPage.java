package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage 
{
	@FindBy(xpath="(//*[@id='add-to-cart-button'])[2]")
	public WebElement AddToCartButton;
	
	@FindBy(xpath="//*[@id='product-images']//*[contains(@class,'current')]/*[@class='product-title']")
	public WebElement ProductName;
	
	
	@FindBy(xpath="//*[@class='brand-tag-name']/*[@class='product_brand_name']/div/div")
	public WebElement ProductCompany;
	
	@FindBy(xpath="//*[@class='zoomContainer']")
	public WebElement ProductImage;
	
	@FindBy(xpath="(//*[@class='wishtext'])[2]")
	public WebElement wishlisticonsignup;
	
	@FindBy(xpath="(//*[@class='wishtext'])[1]")
	public WebElement wishlisticonafterlogin;
	
	@FindBy(xpath="//*[@class='warranty-details']//b")
	public WebElement warrentydetails;
	

	@FindBy(xpath="(//*[contains(@class,'pincode-delivery')]//*[contains(@class,'delivery-date')]/b)[2]")
	public WebElement deliveryAddress;
	
	@FindBy(xpath="(//*[text()='Change'])[2]")
	public WebElement changellink;
	
	@FindBy(xpath="(//*[@class='city-name text'])[2]")
	public WebElement cityname;
	
	@FindBy(xpath="(//*[@class='user-pincode'])[2]")
	public WebElement enterpincode;
	
	@FindBy(xpath="(//*[text()='CHECK'])[2]")
	public WebElement checkbutton;
	
	@FindBy(xpath="//*[@class='product-property-title']")
	public List<WebElement> tabsspecification ;
	
	@FindBy(xpath="//*[@class='tabs-content']/div")
	public List<WebElement> tabsspecificationcontent ;
	
	@FindBy(xpath="(//*[@class='featured-testimonial']/p)[1]")
	public WebElement review;
	@FindBy(xpath="(//*[@class='featured-testimonial']/p)[2]/*[@class='name']")
	public WebElement reviewername;
	
	@FindBy(xpath="(//*[text()='Product Dimensions'])[3]")
	public WebElement dimensions;
	
	@FindBy(xpath="//*[text()='Similar Products']")
	public WebElement similarproducts;
	
	@FindBy(xpath="//*[text()='Visit our Stores']")
	public WebElement visitourstore;
	
	@FindBy(xpath="//*[contains(@class,'add-to-compare')]/span[2]")                 //*[text()='Add To Compare']
	public WebElement AddtoCompareButton;
	
	@FindBy(xpath="//*[@id='compare-cta']")
	public WebElement compare;
	
//	@FindBy(xpath="")
//	public WebElement;
//	@FindBy(xpath="")
//	public WebElement;

}
