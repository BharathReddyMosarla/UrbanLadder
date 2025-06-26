package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage 
{
	@FindBy(name="order[email]")
	public WebElement SAEmail;
	
	@FindBy(id="order_ship_address_attributes_zipcode")
	public WebElement SAPincode;
	
	@FindBy(id="order_ship_address_attributes_address1")
	public WebElement SAAddress;
	
	@FindBy(id="city_state")
	public WebElement SACityState;
	
	@FindBy(id="order_ship_address_attributes_firstname")
	public WebElement SAFirstName;
	
	@FindBy(id="order_ship_address_attributes_lastname")
	public WebElement SALastName;
	
	@FindBy(id="order_ship_address_attributes_phone")
	public WebElement SAMobileNumber;
	
	@FindBy(id="order_use_shipping")
	public WebElement SAasBAcheckbox;
	
	@FindBy(id="order_bill_address_attributes_firstname")
	public WebElement BAFirstName;
	
	@FindBy(id="order_bill_address_attributes_lastname")
	public WebElement BALastName;
	
	@FindBy(id="order_bill_address_attributes_zipcode")
	public WebElement BAPincode;
	
	@FindBy(id="bill_city_state")
	public WebElement BACityState;
	
	@FindBy(id="order_bill_address_attributes_address1")
	public WebElement BAAddress;
	
	@FindBy(id="order_bill_address_attributes_phone")
	public WebElement BAMobileNumber;
	
	@FindBy(id="order_bill_address_attributes_country_id")
	public WebElement BACountry;  // select  by visibletext "India"
	
	@FindBy(id="gstin")
	public WebElement GSTIN;
	
	@FindBy(xpath="//*[@class='error' and @for='order[email]' or @for='order_email']")
	public WebElement SAEmailError;
	
	@FindBy(xpath="//*[@class='error' and @for='order_ship_address_attributes_zipcode']")
	public WebElement SAPincodeError;
	
	@FindBy(xpath="//*[@class='error' and @for='order_ship_address_attributes_address1']")
	public WebElement SAAddressError;
	
	@FindBy(xpath="//*[@class='error' and @for='order_ship_address_attributes_firstname']")
	public WebElement SAFirstNameError;
	
	@FindBy(xpath="//*[@class='error' and @for='order_ship_address_attributes_lastname']")
	public WebElement SALastNameError;
	
	@FindBy(xpath="//*[@class='error' and @for='order_ship_address_attributes_phone']")
	public WebElement SAMobileNumberError;
	
	@FindBy(xpath="//*[@class='error' and @for='order_bill_address_attributes_firstname']")
	public WebElement BAFirstNameError;
	
	@FindBy(xpath="//*[@class='error' and @for='order_bill_address_attributes_lastname']")
	public WebElement BALastNameError;
	
	@FindBy(xpath="//*[@class='error' and @for='order_bill_address_attributes_address1']")
	public WebElement BAAddressError;
	
	@FindBy(xpath="//*[@class='error' and @for='order_bill_address_attributes_zipcode']")
	public WebElement BAPincodeError;
	
	@FindBy(xpath="//*[@class='error' and @for='order_bill_address_attributes_phone']")
	public WebElement BAMobileNumberError;
	
	@FindBy(xpath="//*[@class='error' and @for='gstin']")
	public WebElement GSTINError;
	
	@FindBy(xpath="//*[text()='Know More']")
	public WebElement KnowmoreLink;
	
	@FindBy(xpath="//*[@class='serviceability-condition']")
	public List<WebElement> knowMoreTexts;
	
	@FindBy(xpath="//*[@class='tooltip']/span")
	public WebElement KnowmoreClose;
	
	
	
	@FindBy(xpath="//*[@id='checkout-summary']//*[@class='product-name']")
	public List<WebElement> ProductTitlesAddress; // start from 1 index , 0- is null
	
	@FindBy(xpath="//*[@id='checkout-summary']//*[@class='product-qty']/b")
	public List<WebElement> QuantityAddress;
	
	@FindBy(xpath="//*[@id='checkout-summary']//*[@class='order-total']/span")
	public WebElement CartTotalAddress;
	
	@FindBy(xpath="//*[@id='checkout-summary']//*[@class='discounts']/span")
	public WebElement DiscountsAddress;
		
	@FindBy(xpath="//*[@id='checkout-summary']//*[@class='delivery-charge']/span")
	public WebElement DeliveryChargesAddress;
	
	@FindBy(xpath="//*[@id='checkout-summary']//*[contains(@class,'grand-total')]/span")
	public WebElement TotalPayableAmountAddress;
	
	@FindBy(xpath="//*[@id='not_serviceable_snippet']/p")
	public WebElement NotServiceError;
	
	
	@FindBy(id="address-form-submit")
	public WebElement SaveContinueButton;
	
	
	// frame elements
	
	@FindBy(xpath="//*[@id='rzpAffordabilityMainFrame']")
	public WebElement EMIFrameId;  // bywebelement
	
	
	@FindBy(xpath="//*[text()='View plans']")
	public WebElement ViewPlansCart;
	
	@FindBy(xpath="//*[text()='View options']")
	public WebElement ViewOptionsCart;
	
	


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
