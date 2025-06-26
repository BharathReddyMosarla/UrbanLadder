package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage 
{
	
// header section
	
	@FindBy(xpath="//*[contains(@class,'featuredLinksBar')]//a[contains(text(),'Help')]")
	public WebElement HelpLink;
	
	@FindBy(xpath="//*[contains(@class,'featuredLinksBar')]//a[contains(text(),'Track Order')]")
	public WebElement TrackOrderLink;
	
	@FindBy(xpath="//*[@id='account-logged-out' ]//a[text()='Track Order']")
	public WebElement TrackOrderLogout;
	
	@FindBy(xpath="//*[@id='account-logged-in']//a[text()='Track Order']")
	public WebElement TrackOrderLogin;
	
	@FindBy(xpath="//*[@id='account-logged-out' ]//a[text()='Log-in']")
	public WebElement Login;
	
	@FindBy(xpath="//*[@id='account-logged-out' ]//a[text()='Sign-up']")
	public WebElement Signup;
	
	@FindBy(xpath="//*[@id='account-logged-in']//a[text()='Wishlist']")
	public WebElement Wishlist;
	
	@FindBy(xpath="//*[contains(text(),'My Account')]")
	public WebElement MyAccount;
	
	
	@FindBy(xpath="//*[@id='user_links']//*[text()='Profile']")
	public WebElement MAProfile;
	
	@FindBy(xpath="//*[@id='user_links']//*[text()='Orders']")
	public WebElement MAOrders;
	
	@FindBy(xpath="//*[@id='user_links']//*[text()='Wishlist']")
	public WebElement MAWishlist;
	
	@FindBy(xpath="//*[@id='user_links']//*[text()='Vouchers']")
	public WebElement MAVochers;
	
	@FindBy(xpath="//*[@id='user_links']//*[text()='Logout']")
	public WebElement MALogout;
	
	// Links
	
	@FindBy(xpath="//*[text()='1. Cart']")
	public WebElement CartLink;
	
	@FindBy(xpath="//*[text()='2. Address']")
	public WebElement AddressLink;
	
	@FindBy(xpath="//*[text()='3. Payment']")
	public WebElement PaymentLink;
	
	
	// ------ 1. Cart page
	
	@FindBy(xpath="//*[@class='empty_msg' ]")
	public WebElement EmptyMessage;
	
	@FindBy(xpath="(//*[text()='Continue shopping'])[1]")
	public WebElement ContinueShoppingButton;
	
	@FindBy(xpath="//*[@id='subtotal']//*[text()='Continue shopping' ]")
	public WebElement OptContinueShoppingButton;
	
	@FindBy(xpath="//*[@id='subtotal']//*[@id='checkout-link']")
	public WebElement OptCheckoutButton;
	
	@FindBy(xpath="(//*[@id='checkout-link'])[1]")
	public WebElement CheckoutButton;
	
	@FindBy(xpath="//*[text()='Change Pincode']")
	public WebElement ChangePincodeLink;
	
	@FindBy(xpath="//*[@class='city']")
	public WebElement City;
	@FindBy(xpath="//*[@class='pincode']")
	public WebElement Pincode;
	
	@FindBy(className="user-pincode")
	public WebElement EnterPincode;
	
	@FindBy(xpath="//*[text()='CHECK']")
	public WebElement CheckButton;
	
	@FindBy(xpath="//*[@class='pincode-sla']//*[@class='error']")
	public WebElement PincodeError;
	
	@FindBy(xpath="//*[@class='not_serviceable']/p")
	public WebElement NotServiceError;
	
	
	@FindBy(xpath="//*[text()='Know More']")
	public WebElement KnowmoreLink;
	
	@FindBy(xpath="//*[@class='message']/li/span[1]")
	public WebElement knowmoretext;
	
	@FindBy(xpath="//*[@class='tooltip']/span")
	public WebElement KnowmoreClose;
	
	@FindBy(xpath="//*[@class='delivery-charge__conditions']/li")
	public WebElement Knowmoretext1;
	
	@FindBy(xpath="//*[text()='Explore all offers']")
	public WebElement ExploreOffersButton;
	
	@FindBy(xpath="//*[@id='line_items']//*[@class='cart_image']/a")
	public List<WebElement> ProductImagesCart;
	
	@FindBy(xpath="//*[@id='line_items']//*[@class='product-title']/a")
	public  List<WebElement> ProductTitlesCart;
	
	@FindBy(xpath="//*[@id='line_items']//*[@class='product-variants']")
	public  List<WebElement> ProductVariantCart;
	
	@FindBy(xpath="//*[@id='line_items']//*[contains(@class,'trust')]/span[2]")
	public  List<WebElement> ProductTrustTextCart;
	
	@FindBy(xpath="//*[@id='line_items']//*[contains(@class,'add-to-wishlist')]")
	public  List<WebElement> AddWishlistButtonCart;
	
	@FindBy(xpath="//*[@id='line_items']//*[@class='delivery-date']")
	public  List<WebElement> DeliverydateCart;
	
	@FindBy(xpath="//*[@id='line_items']//*[@id='select_0_quantity']")
	public  List<WebElement> QuantityCart; // select 1-10
	
	@FindBy(xpath="//*[@id='line_items']//*[@class='strike-price']")
	public  List<WebElement> StrikePriceCart;
	
	@FindBy(xpath="//*[@id='line_items']//*[@class='final-price']")
	public  List<WebElement> FinalPriceCart;    // main price
	
	@FindBy(xpath="//*[@id='line_items']//*[@class='delete-item']")
	public  List<WebElement> DeleteItemCart;
	
	@FindBy(xpath="//*[@id='line_items']//*[@class='promotion-info']")
	public  List<WebElement> PromotionInfoCart;

	@FindBy(xpath="//*[@class='coupon_content']/*[contains(text(),'Apply Coupon and Save Extra')]")
	public WebElement ApplyCouponButtonCart;
	
	@FindBy(xpath="//*[@class='promotion-code']")
	public WebElement AfterApplyPromocodeText;
	
	@FindBy(xpath="//*[@class='applied-coupon-link']//*[@class='small-text']/span")
	public WebElement AfterApplyPromocodeamountText;
	
	@FindBy(xpath="(//*[@class='coupon-section']//*[@class='icofont-cross_thin'])[1]")
	public WebElement RemoveAppliedCoupon;
	
	@FindBy(xpath="(//*[@id='subtotal']//*[@class='order-amt'])[1]")
	public WebElement CartTotalCart;
	
	@FindBy(xpath="(//*[@id='subtotal']//*[@class='order-amt'])[2]")
	public WebElement DiscountsCart;
	
	@FindBy(xpath="(//*[@id='subtotal']//*[contains(@class,'delivery-charge')])[2]")
	public WebElement DeliveryChargesCart;
	
	@FindBy(xpath="//*[@id='subtotal']//*[@class='total-amt']")
	public WebElement TotalPayableAmountCart;
	
	@FindBy(xpath="//*[@id='subtotal']//*[@class='amt-order']/div[2]")
	public WebElement BookingAmountCart;
	
	@FindBy(xpath="//*[@id='rzpAffordabilityMainFrame']")
	public WebElement EMIFrameId;  // bywebelement
	
	
	@FindBy(xpath="//*[text()='View plans']")
	public WebElement ViewPlansCart;
	
	@FindBy(xpath="//*[text()='View options']")
	public WebElement ViewOptionsCart;
	
	// ---- coupons popup-------
	
	@FindBy(xpath="//*[@class='coupon-show']//*[@class='name']")
	public WebElement AvailableCouponText;
	
	@FindBy(xpath="//*[@class='coupon-show']//*[@class='cross-coupon']")
	public WebElement AvailableCouponClose;
	
	@FindBy(xpath="//*[@class='coupon-show']//*[@id='order_coupon_code']")
	public WebElement SearchCouponcode;
	
	@FindBy(xpath="//*[@class='coupon-show']//*[@id='apply-coupon-button']")
	public WebElement ApplyButton;
	
	@FindBy(xpath="//*[@class='coupon-show']//*[@class='coupon-error']")
	public WebElement CouponError;
	
	@FindBy(xpath="//*[@class='coupon-show']//*[@id='coupon_tickets']//*[@class='left']")
	public List<WebElement> CouponCodes;
	
	@FindBy(xpath="//*[@class='coupon-show']//*[@id='coupon_tickets']//*[@class='coupon-apply-button']")
	public List< WebElement> ApplyCouponButtons;  //value = coupon code
	
	@FindBy(xpath="//*[@class='coupon-show']//*[@id='coupon_tickets']//*[@class='coupon_title']")
	public List< WebElement> CouponTitleDescs;
	
	@FindBy(xpath="//*[@class='coupon-show']//*[@id='coupon_tickets']//*[@class='description_small']")
	public List< WebElement> ConditionforCoupons;
	
	@FindBy(xpath="//*[@class='coupon-show']//*[@id='coupon_tickets']//*[@class='terms_and_condition']")
	public List< WebElement> TCs;
	
	@FindBy(xpath="//*[@class='coupon-show']//*[@id='coupon_tickets']//*[contains(@class,'icofont-cross_thin')]")
	public List<WebElement> TCCloses;
	
	@FindBy(xpath="//*[@class='coupon-show']//*[@id='coupon_tickets']//*[@class='show-hide']")
	public List<WebElement> TCTexts;
	
	
	// popup coupons After
	
	@FindBy(xpath="//*[@class='promotion_code']")
	public WebElement AppliedPromoCode;
	
	@FindBy(xpath="//*[@class='success-show']/div[2]/div[2]")
	public WebElement CouponSuccessfullMessage;
	
	@FindBy(xpath="//*[@class='success-show']//*[@class='cross-popup-on-success']")
	public WebElement SuccessPopupClose;
	
	
	

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
	

}
