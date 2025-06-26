package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindaStorePage 
{
	@FindBy(xpath="//*[@id='page_content']//a/img")
	public List<WebElement> CityImages; //22  //class
	

	
	
	
	
	
	
	
	// ----- furniture stores in city pages
	
	@FindBy(xpath="//*[@class='_2Bed4']/a[text()='Furniture Home']")
	public WebElement FurnitureHomeLink;
	
	@FindBy(xpath="//*[@class='_2Bed4']/a[text()='Stores']")
	public WebElement StoresLink;
	
	@FindBy(xpath="(//*[contains(@class,'_2Bed4')]/a)[3]")
	public WebElement StoreCityLink;
	
	@FindBy(xpath="//*[@class='_3oCTi']/a")
	public List<WebElement> NoofAreas;    // areas in a city page
	
	@FindBy(xpath="//*[text()='View Details']")
	public List<WebElement> ViewDetailsButton;
	
	
	@FindBy(xpath="//*[text()='More']")
	public WebElement MoreLink;
	
	@FindBy(xpath="//*[text()='Less']")
	public WebElement LessLink;
	
	@FindBy(xpath="//*[@class='_12wcw']/h3")
	public List<WebElement> AreaNames;
	
	@FindBy(xpath="//*[@class='TR7HO']//li/a")
	public List<WebElement> AllLinks;
	
	@FindBy(xpath="//*[@class='withsubtext']")
	public WebElement linkheading;
	
	@FindBy(xpath="//*[@id='store-details']/h1")
	public WebElement AreaStoreHeading;
	

	
	
	// -- full store details page
	
	
	@FindBy(xpath="//*[@class='detail']")
	public WebElement Address;
	
	@FindBy(xpath="//*[@class='detail']/div[2]")
	public WebElement pincodeinfo;
	
	@FindBy(xpath="//*[@class='contact-details']/div[1]/a")
	public WebElement phonenumber;
	
	@FindBy(xpath="//*[@class='contact-details']/div[2]/a")
	public WebElement email;
	
	@FindBy(xpath="//*[@class='info-section']/div/div/span")
	public WebElement workinghours;
	
	@FindBy(xpath="//*[@class='get-location']/a")
	public WebElement ViewonGooglemapsButton;
	
	@FindBy(xpath="//*[@id='store-details']/p/a")
	public WebElement Requestacallback;
	
	 
	@FindBy(xpath="//*[@class='gmnoprint']/div/button[1]")
	public WebElement Zoomin;
	
	@FindBy(xpath="//*[@class='gmnoprint']/div/button[2]")
	public WebElement Zoomout;
	
	@FindBy(xpath="//*[@class='google-maps-link']/a")
	public WebElement viewlargermap;
	
	@FindBy(xpath="//*[@class='address']")
	public WebElement mapaddress;
	
	@FindBy(xpath="//*[@class='review-box']/a")
	public WebElement reviews;
	
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
	
	
	
	
	
	
}
