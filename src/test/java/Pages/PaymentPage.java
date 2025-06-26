package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage 
{
	@FindBy(xpath="//*[@id='checkout-summary']//*[@class='product-name']")
	public List<WebElement> ProductTitlesPayment; // start from 1 index , 0- is null
	
	@FindBy(xpath="//*[@id='checkout-summary']//*[@class='product-qty']/b")
	public List<WebElement> QuantityPayment;
	
	@FindBy(xpath="//*[@id='checkout-summary']//*[@class='order-total']/span")
	public WebElement CartTotalPayment;
	
	@FindBy(xpath="//*[@id='checkout-summary']//*[@class='discounts']/span")
	public WebElement DiscountsPayment;
		
	@FindBy(xpath="//*[@id='checkout-summary']//*[@class='delivery-charge']/span")
	public WebElement DeliveryChargesPayment;
	
	@FindBy(xpath="//*[@id='checkout-summary']//*[contains(@class,'grand-total')]/span")
	public WebElement TotalPayableAmountPayment;
	
	@FindBy(xpath="//*[@id='rzpAffordabilityMainFrame']")
	public WebElement EMIFrameId;  // bywebelement
	
	@FindBy(xpath="//*[text()='View plans']")
	public WebElement ViewPlansCart;
	
	@FindBy(xpath="//*[text()='View options']")
	public WebElement ViewOptionsCart;
	
	
	
	@FindBy(xpath="//*[@class='payment-method-name']")
	public WebElement PaymentMethodText;
	
	@FindBy(id="order_payments_attributes__payment_method_id_32")
	public WebElement PaymentMethodradiobutton;
	
	@FindBy(xpath="//*[@class='item-title']")
	public WebElement RedeemGiftCard;
	
	@FindBy(id="code")
	public WebElement GiftCardCode;
	
	@FindBy(id="pin")
	public WebElement Pin;
	
	@FindBy(id="gift-card-redeem")
	public WebElement RedeemGiftCardButton;
	
	@FindBy(id="gift-card-message")
	public WebElement GiftCardCodeError;
	
	@FindBy(xpath="//*[@id='checkout_form_payment']/div[3]/p/strong[1]")
	public WebElement EmailPayment;
	
	@FindBy(xpath="//*[@id='checkout_form_payment']/div[3]/p/strong[2]")
	public WebElement MobileNumberPayment;
	
	@FindBy(xpath="//*[@id='checkout_form_payment']//*[@name='commit']")
	public WebElement PlaceOrderButton;
	
	@FindBy(xpath="//*[@class='terms-and-conditions']/p/a[1]")
	public WebElement PrivacyPolicyLink;
	
	@FindBy(xpath="//*[@class='terms-and-conditions']/p/a[2]")
	public WebElement TermsConditionsLink;
	
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
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;

}
