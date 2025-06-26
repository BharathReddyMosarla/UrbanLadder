package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InteriorsPage 
{
	@FindBy(xpath="//*[contains(@class,'interiorsunit')]//li/div/a")
	public WebElement HomeInteriors;
	
	@FindBy(xpath="//*[contains(@class,'interiorsunit')]//li[1]/a")
	public WebElement FullHomeInteriors;
	@FindBy(xpath="//*[contains(@class,'interiorsunit')]//li[2]/a")
	public WebElement ModularKitchens;
	@FindBy(xpath="//*[contains(@class,'interiorsunit')]//li[3]/a")
	public WebElement ModularWardrobes;
	
	
	
	@FindBy(xpath="//*[contains(text(),'Quote!')]")
	public WebElement GetFreeQuoteText;
	
	@FindBy(xpath="(//*[@class='formsection']//*[@id='pincode'])[1]")
	public WebElement Pincode;
	@FindBy(xpath="(//*[@class='formsection']//*[@id='city'])[1]")
	public WebElement City;
	@FindBy(xpath="(//*[@class='formsection']//*[@id='firstname'])[1]")
	public WebElement Name;
	@FindBy(xpath="(//*[@class='formsection']//*[@id='phoneno'])[1]")
	public WebElement MobileNumber;
	@FindBy(xpath="(//*[@class='formsection']//*[@id='email_id'])[1]")
	public WebElement Email;
	@FindBy(xpath="(//*[@class='formsection']//*[@name='commit'])[1]")
	public WebElement NextButton;
	
	// modular kitchens and modular wardrobes - extra form
	@FindBy(xpath="(//*[@class='formsection']//*[@id='pincode'])[2]")
	public WebElement Pincode1;
	@FindBy(xpath="(//*[@class='formsection']//*[@id='city'])[2]")
	public WebElement City1;
	@FindBy(xpath="(//*[@class='formsection']//*[@id='firstname'])[2]")
	public WebElement Name1;
	@FindBy(xpath="(//*[@class='formsection']//*[@id='phoneno'])[2]")
	public WebElement MobileNumber1;
	@FindBy(xpath="(//*[@class='formsection']//*[@id='email_id'])[2]")
	public WebElement Email1;
	@FindBy(xpath="(//*[@class='formsection']//*[@name='commit'])[2]")
	public WebElement NextButton1;
	
	
	
	
	@FindBy(xpath="//*[text()='Book a Design Consultation']")
	public List<WebElement> BookdesignconsultationButton; //3,5
	
	@FindBy(xpath="//*[@title='Urban Interiors']/img")
	public List<WebElement> ImagesSamePage ;//3(new window)
	
	@FindBy(xpath="(//*[@for='pincode' and @class='error'])[1]")
	public WebElement PicodeError;
	@FindBy(xpath="(//*[@for='firstname' and @class='error'])[1]")
	public WebElement NameError;
	@FindBy(xpath="(//*[@for='phoneno' and @class='error'])[1]")
	public WebElement MobileNumberError;
	@FindBy(xpath="(//*[@for='email_id' and @class='error'])[1]")
	public WebElement EmailError;
	
	@FindBy(xpath="(//*[@for='pincode' and @class='error'])[2]")
	public WebElement PicodeError1;
	@FindBy(xpath="(//*[@for='firstname' and @class='error'])[2]")
	public WebElement NameError1;
	@FindBy(xpath="(//*[@for='phoneno' and @class='error'])[2]")
	public WebElement MobileNumberError1;
	@FindBy(xpath="(//*[@for='email_id' and @class='error'])[2]")
	public WebElement EmailError1;
	
	@FindBy(xpath="(//*[@class='message'])[1]")
	public WebElement NotAvailableMsg;
	@FindBy(xpath="(//*[@class='message'])[2]")
	public WebElement NotAvailableMsg1;
	
	@FindBy(xpath="//*[@class='htmlres error']//h1")
	public WebElement ErrorHtml;
	
	@FindBy(xpath="//*[@class='leadresponse']/h4[1]")
	public WebElement ThankuMsg;
	
	@FindBy(xpath="//*[@class='leadresponse']/a[1]")
	public WebElement ContinueWebsiteButton;
	@FindBy(xpath="//*[@class='leadresponse']/a[2]")
	public WebElement ProceedtoQuestionarieButton;
	
	// ---------------------- questonarie page ----------
	
	@FindBy(xpath="//*[@class='question']")
	public WebElement Question;
	
	@FindBy(xpath="//*[@name='requirement[answers_attributes][][answer]']")
	public List<WebElement> Options;
	
	@FindBy(xpath="//*[@class='option']/div")
	public List<WebElement> OptionsText;
	
	@FindBy(xpath="//*[@class='option']/img")
	public List<WebElement> OPtionsImage;
	
	@FindBy(xpath="//*[text()='Next']")
	public WebElement Next;
	
	@FindBy(xpath="//*[text()='Prev']")
	public WebElement Prev;
	
	@FindBy(xpath="//*[@class='quesmessage']")
	public WebElement ErrorMessage;
	
	@FindBy(xpath="//*[@class='requirements-form']//h4[@class='separator']")
	public WebElement ThankyouMessage;
	
	@FindBy(xpath="//*[@class='requirements-form']//h4[2]")
	public WebElement contactinfomessage;
	
	@FindBy(xpath="//*[text()='Responses']")
	public WebElement ResponsesButton;
	
	@FindBy(xpath="//*[text()='Submit']")
	public WebElement SubmitButton;
	
	@FindBy(xpath="//*[@class='progress-bar']")//style
	public WebElement progressbar;
	@FindBy(xpath="//*[@class='progress']")//data-progress
	public WebElement progress;
	
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
//	
//	@FindBy(xpath="")
//	public WebElement ;
//	@FindBy(xpath="")
//	public WebElement ;


}
