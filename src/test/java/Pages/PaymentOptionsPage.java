package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentOptionsPage 
{
	@FindBy(xpath="//*[@class='razorpay-checkout-frame']")
	public WebElement POFrame;
	
	@FindBy(xpath="//*[@id='merchant-identity']//*[text()='Urban Ladder']")
	public WebElement UrbanLadderText;
	
	@FindBy(xpath="//*[@id='overview-container']//*[@class='p-4']/div[2]/h3[1]")
	public WebElement PriceSummary;
	
	@FindBy(xpath="//*[contains(text(),'Using as')]")
	public WebElement editphoneemail;
	

	
	@FindBy(name="email")
	public WebElement Email;
	
	@FindBy(name="contact")
	public WebElement MobileNumber;
	
	@FindBy(xpath="//*[@id='contact-submit']/button")
	public WebElement ContinueButton;
	
	@FindBy(xpath="//*[text()='Payment Options']")
	public WebElement PaymentsOptionText;
	
	@FindBy(xpath="//*[@id='nav-sidebar']//span/span")
	public List<WebElement> Options ; //8
	
	@FindBy(xpath="//*[@id='nav-sidebar']//span/span[text()='Recommended']")
	public WebElement Recommanded;
	@FindBy(xpath="//*[@id='nav-sidebar']//span/span[text()='Pay with axio']")
	public WebElement PaywithAxio;
	@FindBy(xpath="//*[@id='nav-sidebar']//span/span[text()='UPI']")
	public WebElement UPI;
	@FindBy(xpath="//*[@id='nav-sidebar']//span/span[text()='Cards']")
	public WebElement Cards;
	@FindBy(xpath="//*[@id='nav-sidebar']//span/span[text()='EMI']")
	public WebElement EMI;
	@FindBy(xpath="//*[@id='nav-sidebar']//span/span[text()='Netbanking']")
	public WebElement Netbanking;
	@FindBy(xpath="//*[@id='nav-sidebar']//span/span[text()='Wallet']")
	public WebElement Wallet;
	@FindBy(xpath="//*[@id='nav-sidebar']//span/span[text()='Pay Later']")
	public WebElement PayLater;
	
	
	@FindBy(xpath="//*[@id='nav-sidebar']//span[text()='More options']")
	public WebElement MoreOptionsButton;
	
	@FindBy(xpath="//span[text()='Back to top']")
	public WebElement BacktoTopButton;
	
	
	@FindBy(xpath="//*[@id='main-container']//button[contains(@title,'Close')]")
	public WebElement closepopup;
	
	@FindBy(xpath="//*[text()='Continue to payment']")
	public WebElement ContinuePayment;
	
	@FindBy(xpath="//button[@data-testid='confirm-positive']")
	public WebElement YesExit;
	
	@FindBy(xpath="//*[@class='truncate']")
	public WebElement bankofferslink;
	@FindBy(xpath="//*[@class='mb-4']")
	public List<WebElement> bankoffers; //display
	@FindBy(xpath="//*[@class='flex']//*[contains(@class,'mt-1')]")
	public List<WebElement> bankoffersamount;
	

	@FindBy(xpath="//*[text()='Apply']")
	public List<WebElement> bankapplybutton;
	
	@FindBy(xpath="//*[text()='Remove']")
	public WebElement bankremovebutton ;
	@FindBy(xpath="//*[@class='p-4']//h3[1]")
	public WebElement finalprice;
	@FindBy(xpath="//*[@class='p-4']//h4")
	public WebElement actualprice;
	@FindBy(xpath="//button[contains(@class,'absolute')]")
	public WebElement bankclose;
	
	// pay with axio
	
	@FindBy(xpath="//*[text()='Axio']")
	public WebElement AxioButton;
	@FindBy(xpath="//*[text()='Enter OTP to check eligibility']")
	public WebElement textotppopup;
	@FindBy(xpath="//*[contains(@id,'otp')]")
	public List<WebElement> otpfields;
	@FindBy(id="error_otp")
	public WebElement errorotpmessage;
	@FindBy(xpath="//*[@class='only:m-auto']/span")
	public WebElement resendtime;
	@FindBy(xpath="//*[@class='only:m-auto']/button")
	public WebElement resendotp;
	@FindBy(xpath="//*[text()='Eligibility OTP failed']")
	public WebElement failedotp;
	
	// upi payment option 
	
	@FindBy(xpath="//*[text()='UPI QR']")
	public WebElement upiqrtext;
	@FindBy(xpath="//*[@name='form']//button[@class='false']")
	public WebElement QRCode;
	@FindBy(xpath="(//*[@class='animate-fade-in']//div/span[1])[1]")
	public WebElement QRTimeout;
	
	@FindBy(xpath="//*[@name='vpa']")
	public WebElement UPIid;
	@FindBy(id="error_vpa")
	public WebElement errorupimessage;
	@FindBy(xpath="//*[@name='button']")
	public WebElement Button;
	
	// card payment options
	
	@FindBy(name="card.number")
	public WebElement cardnumber;
	@FindBy(name="card.expiry")
	public WebElement cardexpiry;
	@FindBy(name="card.cvv")
	public WebElement cardcvv;
	@FindBy(name="card.name")
	public WebElement cardname;
	
	@FindBy(id="error_card.name")
	public WebElement errormessagecardname;
	@FindBy(xpath="//*[@name='button']")
	public WebElement continueButton;
	
	@FindBy(name="pay_without_saving_card")
	public WebElement maybelater;
	@FindBy(name="pay_and_save_card")
	public WebElement yessecuremycard;
	
	@FindBy(xpath="//form[@name='otp']/div[1]")
	public WebElement otptext;
	@FindBy(xpath="//form[@name='otp']/div[2]")
	public WebElement otpforcardtext;
	@FindBy(xpath="//form[@name='otp']//input")
	public WebElement enterotp;
	@FindBy(xpath="//form[@name='otp']//button[@name='button']")
	public WebElement continueotpbutton;
	@FindBy(xpath="//*[@id='error_otp']")
	public WebElement errorotpmessagecard;
	@FindBy(xpath="//*[@class='z-[60]']//p")
	public WebElement timeoutforsubmission;
	//resendtime
	
	// EMI payment options
	
	@FindBy(xpath="//*[text()='Credit Card']")
	public WebElement creditcardemi;
	@FindBy(xpath="//*[text()='Debit Card']")
	public WebElement debitcardemi;
	@FindBy(xpath="//*[text()='Cardless and Others']")
	public WebElement cardlessemi;
	@FindBy(xpath="//*[@name='form']//div/p")
	public List<WebElement> listemibanks;
	@FindBy(xpath="//*[@id='main-container']//button[@title='Go back']")
	public WebElement back;	
	@FindBy(xpath="//*[contains(@class,'mb-2') and contains(@data-testid,'emi-plan')]//p[1]")
	public List<WebElement> emiplansforbank;
	@FindBy(xpath="//*[contains(@class,'mb-2') and contains(@data-testid,'emi-plan')]//p[2]")
	public List<WebElement> emiplansforbankintrest;
	
	// Netbanking payment options
	
	@FindBy(xpath="//*[@name='bank']")
	public WebElement banksearch;
	@FindBy(xpath="//*[@class='animate-fade-in']//p")
	public WebElement errormessagebank;
	@FindBy(xpath="//*[text()='Search Results']/following::div//*[contains(@class,'mx-4')]//span")
	public List<WebElement> searchbankresults;
	@FindBy(xpath="//*[@name='netbankingForm'][1]//*[contains(@class,'mx-4')]/span")
	public List<WebElement> suggestedbanks;
	@FindBy(xpath="//*[@name='netbankingForm'][2]//*[contains(@class,'mx-4')]/span")
	public List<WebElement> allbanks;

	// wallet payment options

	@FindBy(xpath="//*[text()='All Wallet Options']/following::div//*[contains(@class,'mx-4')]/span")
	public  List<WebElement> allwalletoptions ;
	
	// paylater payment options

		@FindBy(xpath="//*[text()='Pay Later']/following::div//*[contains(@class,'mx-4')]/span")
		public  List<WebElement> allpaylateroptions ;
	@FindBy(xpath="//form[@name='otp']/div")
	public  List<WebElement>  paylaterotptext;
	
	
	
	
	
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
