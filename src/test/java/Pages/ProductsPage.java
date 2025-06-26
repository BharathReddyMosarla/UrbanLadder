package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage 
{
	
	@FindBy(xpath="//*[@class='inline']/li//a/span")
	public  List<WebElement> linksorder;
	
	@FindBy(xpath="//*[@class='results-count']")
	public WebElement productcountforcategory;
	
	// ------------   filters
	
	@FindBy(xpath="//*[@class='filters-list-wrapper']//*[@class='gname']")
	public List<WebElement> FilterOptions; //hover 
	
	@FindBy(xpath="//*[@name='filters[material][]']")
	public List<WebElement> materialfilter;
	@FindBy(xpath="//*[@name='filters[has_storage][]']")
	public List<WebElement> storagefilter;
	
	@FindBy(xpath="//*[text()='In Stock Only']")
	public WebElement stockonlytext;
	
	@FindBy(xpath="//*[@name='filters[availability][]']")
	public WebElement checkboxforoutofstock;
	
	@FindBy(xpath="//*[@for='filters_availability_In_Stock_Only']")
	public WebElement outofstocktext;
	
	@FindBy(xpath="//*[@class='sort-box']//*[@class='page-label']")
	public WebElement sortbytext;
	
	@FindBy(xpath="//*[@class='sort-box']//*[@class='gname']/span")
	public WebElement selectedoptionsortby;
	
	@FindBy(xpath="//*[@class='sort-box']//*[@class='sortoptions']/li")
	public List<WebElement> sortoptions;
//	@FindBy(xpath="")
//	public WebElement ;
	
	
	
	
	
	
	@FindBy(xpath="//*[@class='withsubtext']")
	public WebElement headingproduct;
	
	@FindBy(xpath="//*[@id='content']//*[@class='product-img']")
	public List<WebElement> ProductImages;
	
	@FindBy(xpath="//*[@class='name']")
	public List<WebElement> ProductNames;
	
	@FindBy(xpath="//*[@class='price-number']/span")
	public List<WebElement> ProductPrices;
	
	
	
	@FindBy(xpath="//*[contains(@class,'wishproduct')]")
	public List<WebElement> AddWishlisticons;
	
	@FindBy(xpath="//*[@class='wishtext']")
	public List<WebElement> AddWishlistbuttons;
	
	@FindBy(xpath="//*[text()='Add to Compare']")
	public List<WebElement> AddtoCompareButtons;
	
	@FindBy(xpath="//*[text()='View Product' or text()='View 2 options']")
	public List<WebElement> viewproductButtons;
	
	// -- ribbon
	
	@FindBy(xpath="//*[@class='listing-discount-ribbon-content']")
	public List<WebElement> ribbontextsale;
	
	@FindBy(xpath="//*[contains(@class,'list_product_status')]")
	public List<WebElement> soldouttext; //hover --> letmeknow
	@FindBy(xpath="//*[contains(@class,'outofstock_text')]")
	public List<WebElement> letmeknowtext;
	
	@FindBy(xpath="//*[@class='productbox']//*[@class='form-validate']/*[@id='email_id']")
	public List<WebElement> emailLetmeknow;
	
	@FindBy(xpath="//*[@class='productbox']//*[@class='form-validate']/*[@id='phoneno']")
	public List<WebElement> phonenoLetmeknow;
	
	@FindBy(xpath="//*[@class='productbox']//*[@class='form-validate']/*[@name='commit']")
	public List<WebElement> letmeknowButton;
	
	@FindBy(xpath="//*[contains(@class,'after_submit_soldout')]")
	public List<WebElement> thankyoumsgletmenkow;
	@FindBy(xpath="//*[@for='email_id' and @class='error']")
	public List<WebElement> emailerrorletmeknow;
	@FindBy(xpath="//*[@for='phoneno' and @class='error']")
	public List<WebElement> phonenoerrorletmeknow;
	
	
	
	
	// --     compare   ------------
	@FindBy(xpath="//*[@class='prod-name']")
	public List<WebElement> products;//2
	
	@FindBy(xpath="//*[@class='compare-error-message']//*[contains(@class,'message-content')]")
	public WebElement errormessage;
	
	@FindBy(xpath="//*[text()=' Got It ']")
	public WebElement gotit;
	
	@FindBy(xpath="//*[@id='compare-cta']")
	public WebElement compare;
	
	@FindBy(xpath="//*[@class='remove-prod-cta']/span")
	public List<WebElement> closecomparepop; //2
	
	@FindBy(xpath="//*[@class='modal-title']//span[contains(text(),'Compare')]")
	public WebElement comparetext;
	
	
//	
	@FindBy(xpath="(//*[@class='icofont-cross'])[2]")
	public WebElement closepop2;
	
	// compare page elements ---------
	
	@FindBy(xpath="(//div[@class='name']/div[@class='prod-name'])[1]")
	public WebElement product1;
	@FindBy(xpath="(//div[@class='name']/div[@class='prod-name'])[2]")
	public WebElement product2;
	@FindBy(xpath="(//div[@class='prop-value'])[1]")
	public WebElement product1price;
	@FindBy(xpath="(//div[@class='prop-value'])[2]")
	public WebElement product2price;
	
	@FindBy(xpath="//*[@class='row row-centered no-padding comparable-props-wrapper']//*[@class='prop-label']")
	public List<WebElement> head; //by2
	@FindBy(xpath="//*[@class='row row-centered no-padding comparable-props-wrapper']//*[@class='prop-value']")
	public List<WebElement> info;  //by2
	
	
	
	
	
	
	
	// ----------- browser popular categories
	
	@FindBy(xpath="//*[contains(text(),'Browse Popular')]")
	public WebElement browsepopluarcattext;
	
	@FindBy(xpath="//*[@class='product-name']")
	public List<WebElement> bpcProductnames;
	
	@FindBy(xpath="//*[@id='content']//h1")
	public WebElement bpcproductpageheading;
	

//	
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
	
	
}
