package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage 
{
	@FindBy(xpath="//*[@id='head-alert']//a")
	public WebElement ShopNowLink;
	
	@FindBy(xpath="//*[@id='head-alert']//*[@class='center']")
	public WebElement SalesInfo;

	
	
	
	

	@FindBy(xpath="//*[@class='featuredLinksBar']//a[contains(text(),'Help')]")
	public WebElement Help;
	
	@FindBy(xpath="//*[@class='featuredLinksBar']//a[contains(text(),'Track Order')]")
	public WebElement TrackOrder;
	
	@FindBy(xpath="//*[@class='featuredLinksBar']//a[contains(text(),'Become a Franchisee')]")
	public WebElement Franchise;
	
	@FindBy(xpath="//*[@class='featuredLinksBar']//a[contains(text(),'Find a Store')]")
	public WebElement FindaStore;
	
	@FindBy(xpath="//*[@class='featuredLinksBar']//a[contains(text(),'Bulk Orders')]")
	public WebElement BulkOrders;
	
	@FindBy(xpath="//*[@class='featuredLinksBar']//a[contains(text(),'UL Services')]")
	public WebElement ULServices;
	
	
	// ----- 
	
	
	@FindBy(xpath="//*[@class='header__topBar_sectionLeft']//a")
	public WebElement Logo;
	
	
	@FindBy(xpath="//*[@id='logo']//a")
	public WebElement LogoCart;
	
	@FindBy(id="search")
	public WebElement SearchBar;
	
	@FindBy(id="search_button")
	public WebElement SearchIconButton;
	
	@FindBy(id="header-icon-track-order")
	public WebElement TrackOrderIcon;
	
	@FindBy(id="header-icon-wishlist")
	public WebElement WishlistIcon;
	
	@FindBy(id="header-icon-cart")
	public WebElement CartIcon;
	
	@FindBy(xpath="//*[@id='header-icon-wishlist']//span[contains(@class,'badge-count')]")
	public WebElement WishlistCount;
	
	@FindBy(xpath="//*[@id='header-icon-cart']//span[contains(@class,'badge-count')]")
	public WebElement CartCount;
	
	@FindBy(xpath="//*[@class='header__topBarIconList_profile-icon']/span")
	public WebElement UserIcon;												// for hover only
	
	@FindBy(id="header-icon-profile")
	public WebElement Profile;
	
	@FindBy(id="header-icon-orders")
	public WebElement Orders;
	
	@FindBy(id="header-icon-vouchers")
	public WebElement Vochers;
	
	@FindBy(id="logout")
	public WebElement Logout;
	
	@FindBy(id="header-icon-login")
	public WebElement Login;
	
	@FindBy(id="header-icon-signup")
	public WebElement SignUp;

	// ---    for hover to expand menu list
	
	@FindBy(xpath="//*[contains(@class,'oasiscollectionunit')]")
	public WebElement OasisCollection;
	
	@FindBy(xpath="//*[contains(@class,'dealzoneunit')]")
	public WebElement DealZone;
	
	@FindBy(xpath="//*[contains(@class,'sofasunit')]")
	public WebElement SofasRecliners;
	
	@FindBy(xpath="//*[contains(@class,'livingunit')]")
	public WebElement Living;
	
	@FindBy(xpath="//*[contains(@class,'bedroomunit')]")
	public WebElement BedroomMattresses;
	
	@FindBy(xpath="//*[contains(@class,'diningunit')]")
	public WebElement Dining;
	
	@FindBy(xpath="//*[contains(@class,'storagefurnitureunit')]")
	public WebElement StorageFurniture;
	
	@FindBy(xpath="//*[contains(@class,'studyunit')]")
	public WebElement Study;
	
	@FindBy(xpath="//*[contains(@class,'lightingunit')]")
	public WebElement LightingDecor;
	
	@FindBy(xpath="//*[contains(@class,'interiorsunit')]")
	public WebElement Interiors;
	
	@FindBy(xpath="//*[contains(@class,'storesunit')]")
	public WebElement Stores;
	
	
	//------ for hover to expand sub menu list
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[1]//*[@class='sublist_item']/div/a")
	public List<WebElement> OasisCollectionSubMenu;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[2]//*[@class='sublist_item']/div/a")
	public  List<WebElement> DealZoneSubMenu;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[3]//*[@class='sublist_item']/div/a")
	public  List<WebElement> SofasReclinersSubMenu;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[4]//*[@class='sublist_item']/div/a")
	public  List<WebElement> LivingSubMenu;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[5]//*[@class='sublist_item']/div/a")
	public  List<WebElement> BedroomMattressesSubMenu;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[6]//*[@class='sublist_item']/div/a")
	public  List<WebElement> DiningSubMenu;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[7]//*[@class='sublist_item']/div/a")
	public  List<WebElement> StorageFurnitureSubMenu;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[8]//*[@class='sublist_item']/div/a")
	public  List<WebElement> StudySubMenu;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[9]//*[@class='sublist_item']/div/a")
	public  List<WebElement> LightingDecorSubMenu;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[10]//*[@class='sublist_item']/div/a")
	public  List<WebElement> InteriorsSubMenu;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[11]//*[@class='sublist_item']/div/a")
	public  List<WebElement> StoresSubMenu;
	
	// ---------	category info in apage
	
	@FindBy(xpath="//*[@class='withsubtext']")
	public WebElement productmenuheading;
	
	@FindBy(xpath="//*[@class='img-link' or @class='product-img']")
	public List<WebElement> subsublistimage;
	
	@FindBy(xpath="//*[@class='text-center']")
	public List<WebElement> catinfo;
	
	@FindBy(xpath="//*[@class='designs-count']")
	public List<WebElement> productcount;
		
	@FindBy(xpath="//*[@class='results-count']")
	public WebElement productcountforcategory;
	
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
	
	//------ for hover to expand sub-sub  list
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[1]//ul/li//a")
	public List<WebElement> OasisCollectionSM;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[2]//ul/li//a")
	public  List<WebElement> DealZoneSM;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[3]//ul/li//a")
	public  List<WebElement> SofasReclinersSM;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[4]//ul/li//a")
	public  List<WebElement> LivingSM;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[5]//ul/li//a")
	public  List<WebElement> BedroomMattressesSM;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[6]//ul/li//a")
	public  List<WebElement> DiningSM;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[7]//ul/li//a")
	public  List<WebElement> StorageFurnitureSM;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[8]//ul/li//a")
	public  List<WebElement> StudySM;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[9]//ul/li//a")
	public  List<WebElement> LightingDecorSM;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[10]//ul/li//a")
	public  List<WebElement> InteriorsSM;
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[11]//ul/li//a")
	public  List<WebElement> StoresSM;
	
	// --- footer links
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'About Us')]")
	public WebElement AboutUsFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Help')]")
	public WebElement HelpFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Blog')]")
	public WebElement BlogFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Inside UL')]")
	public WebElement InsideULFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Careers')]")
	public WebElement CareersFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Press')]")
	public WebElement PressFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Team')]")
	public WebElement TeamFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Privacy Policy')]")
	public WebElement PrivacyPolicyFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Fees and Payment')]")
	public WebElement FeesPaymentFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Shipping & Delivery')]")
	public WebElement ShippingDeliveryFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Terms and Conditions')]")
	public WebElement TermsandConditionsFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Warranty, Return and Refund')]")
	public WebElement WarrantyReturnRefundFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Contact Us')]")
	public WebElement ContactUsFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Visit Us')]")
	public WebElement VisitUsFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Buy In Bulk')]")
	public WebElement BuyInBulkFooter;
	
	@FindBy(xpath="//*[@id='footer-links']//a[contains(text(),'Refer & Earn')]")
	public WebElement ReferEarnFooter;
	
	@FindBy(xpath="//*[@id=\"footer-links\"]/div[1]/div[4]/ul/li[1]")
	public WebElement AddressDetailsFooter;
	
	@FindBy(xpath="//*[@id=\"footer-links\"]/div[1]/div[4]/ul/li[2]")
	public WebElement CINFooter;
	
	
	@FindBy(xpath="//*[@class='download-btns']//a")
	public List<WebElement> AppStoreFooter;
	
	@FindBy(xpath="//div[contains(@class,'copyright')]/span")
	public WebElement copyrightFooter;
	
	
	@FindBy(xpath="//*[contains(text(),'Delivering in:')]")
	public WebElement deliverytextFooter;
	
	@FindBy(xpath="//*[@class='city-wrap']/li")
	public WebElement deliverylocationsFooter;
	
	@FindBy(xpath="//*[@class='we-accept']")
	public List<WebElement> acceptpayments;
	
	
	//105
	
	
	// ---  
	
	@FindBy(xpath="//*[@id='footer-social']/li[1]/a[1]")
	public WebElement PhoneIcon;
	
	@FindBy(xpath="//*[@id='footer-social']/li[2]/a[1]")
	public WebElement EmailIcon;
	
	@FindBy(xpath="//*[@id='footer-social']/li[3]/a[1]")
	public WebElement FacebookIcon;
	@FindBy(xpath="//*[@id='footer-social']/li[4]/a[1]")
	public WebElement TwitterIcon;
	@FindBy(xpath="//*[@id='footer-social']/li[5]/a[1]")
	public WebElement PintrestIcon;
	@FindBy(xpath="//*[@id='footer-social']/li[6]/a[1]")
	public WebElement YoutubeIcon;
	@FindBy(xpath="//*[@id='footer-social']/li[7]/a[1]")
	public WebElement InstagramIcon;
	@FindBy(xpath="//*[@id='footer-social']/li[8]/a[1]")
	public WebElement LinkedinIcon;
	
	
	@FindBy(xpath="//a[contains(text(),'... More')]")
	public WebElement DeliveryLocationMoreLink;
	
	@FindBy(xpath="//*[@id='new-customer']/h1")
	public WebElement CreateAccountText;
	
	
	// search related info
	
	
	@FindBy(xpath="//*[@id='search-results']/div[3]")
	public WebElement NoproductsText;
	
	@FindBy(xpath="//*[@id='search-results']//h2/span")
	public WebElement SearchedInput;
	
	@FindBy(xpath="//*[contains(@class,'tt-menu')]//div/div/strong")   // names list
	public List<WebElement> AutoSugesstions;
	
	
	// slideshow in Home Page 
	
	@FindBy(xpath="//*[@id='homepage_slider']//*[contains(@class,'slick-prev-icon')]")
	public WebElement LeftArrow;
	
	@FindBy(xpath="//*[@id='homepage_slider']//*[contains(@class,'slick-next-icon')]")
	public WebElement RightArrow;
	
	@FindBy(xpath="//*[@id='homepage_slider']//*[contains(@class,'slick-slide')]/a")
	public List<WebElement> slides;
	
	@FindBy(xpath="//*[@id='homepage_slider']//*[@class='dots-on-slide']/li/button")
	public List<WebElement> SlideDots;    //5
	
	@FindBy(xpath="//*[@id='homepage_slider']//*[@class='slick-slide slick-active']")
	public WebElement ActiveSlide;
	
	@FindBy(xpath="//*[@class='personalized-component']//h4")    //--//*[@class='personalized-component']/div/div/a/h4
	public List<WebElement> ProductText;    //15 - products names - furniture range
	
	
	// Youtube Video related elements
	
	
	@FindBy(xpath="//*[@id='player']//*[@class='ytp-title-text']/a")
	public WebElement YoutubeVideoTitle;
	
	@FindBy(xpath="//*[@id='player']//div/*[contains(@class,'ytp-large-play-button')]")
	public WebElement PlayButton;
	
	@FindBy(xpath="//*[@id='player']//*[contains(@class,'html5-video-container')]/video")
	public WebElement Pause;
	
	@FindBy(xpath="//*[contains(@class,'ytp-watch-later-button')]")
	public WebElement WatchLaterButton;
	
	@FindBy(xpath="//*[contains(@class,'ytp-share-button')]")
	public WebElement ShareButton;
	
	@FindBy(xpath="//*[contains(@class,'ytp-share-panel-link')]")
	public WebElement ShareLink;
	
	@FindBy(xpath="//*[contains(@class,'ytp-share-panel-service-buttons')]/a")
	public List<WebElement> ShareSocial;
	
	@FindBy(xpath="//*[contains(@class,'ytp-share-panel-close')]")
	public WebElement ShareClose;
	
	@FindBy(xpath="//*[contains(@class,'ytp-share-panel-service-buttons')]/a[3]")
	public WebElement ShareMore;
	
	@FindBy(xpath="//*[contains(@class,'ytp-watermark')]")
	public WebElement YoutubeLogo;
	
	
	
	@FindBy(xpath="//h2[contains(text(),'Our Bestsellers')]")
	public WebElement BestsellerText;
	
	@FindBy(xpath="//h2[contains(text(),'Lounge Chairs')]/following::a[@class='block-link']")
	public List<WebElement> BestsellerCategories;
	
	@FindBy(xpath="//*[@id='content']/div[7]/div/div[1]/div[3]/a")
	public WebElement BedroomRangeButton;
	
	@FindBy(xpath="//*[@id='content']/div[7]/div/div[1]/div[5]/a")
	public WebElement BedroomRangeImage;
	
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
	
	@FindBy(xpath="//*[@class='range-products three-column']//h3")
	public List<WebElement> BMGNames;
	
	@FindBy(xpath="//*[@class='range-products three-column']//img")
	public List<WebElement> BMG;
	@FindBy(xpath="//*[@class='range-products three-column']//*[text()='Explore Now']")
	public List<WebElement> BMGExploreNow;
	
	// ---------   new arrivals
	
	@FindBy(xpath="//*[@class='personalized-component'][7]//*[text()='Shop Now']")
	public List<WebElement> ShopNow;  //6-13
	@FindBy(xpath="//*[@class='personalized-component'][7]//*[@class='product-list']//img")
	public List<WebElement> newproducts; // 6-13
		
	// ----   visit our stores	
	
	@FindBy(xpath="(//*[contains(@class,'icofont-left_arrow_rounded')])")
	public List<WebElement> StoreLeftArrow;   // last
	
	@FindBy(xpath="(//*[contains(@class,'icofont-right_arrow_rounded')])")
	public List<WebElement> StoreRightArrow; //last
	
	@FindBy(xpath="((//*[@class='product-list'])[8]/li/a[1])[1]")
	public WebElement hyderabad;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[10]/div/div/ul/div/div/li[2]/ul/li[1]/a/img")
	public WebElement Banglore;
	
	//------------- Recently revied section --------------------
	
	@FindBy(xpath="//*[text()='Recently Viewed']")
	public WebElement recentlyviewedtext;
	
	@FindBy(xpath="//*[@id='recently_viewed_items' or @id='top-recently-viewed']//*[@class='product-img']")
	public List<WebElement> rvProductImages;
	
	@FindBy(xpath="//*[@id='recently_viewed_items' or @id='top-recently-viewed']//*[@class='product-details']")
	public List<WebElement> rvProductNames;
	
	@FindBy(xpath="//*[@id='recently_viewed_items' or @id='top-recently-viewed']//*[contains(@class,'icofont-left_arrow_rounded')]")
	public WebElement rvleftarrow;
	@FindBy(xpath="//*[@id='recently_viewed_items' or @id='top-recently-viewed']//*[contains(@class,'icofont-right_arrow_rounded')]")
	public WebElement rvrightarrow;
	
		
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
//	
	
	
}
