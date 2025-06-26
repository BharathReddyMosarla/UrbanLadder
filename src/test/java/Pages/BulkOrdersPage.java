package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BulkOrdersPage 
{
	//@FindBy(xpath="(//*[@class='Xb9hP']/input)[1]")
	@FindBy(xpath="(//*[@id='mG61Hd']//*[@class='Xb9hP'][1]/input)[1]")
	public WebElement Name;
	
	@FindBy(xpath="(//*[@class='Xb9hP']/input)[2]")
	public WebElement PhoneNumber;
	
	@FindBy(xpath="(//*[@class='Xb9hP']/input)[3]")
	public WebElement City;
	
	@FindBy(xpath="(//*[@class='Xb9hP']/input)[4]")
	public WebElement Email;
	
	@FindBy(xpath="//span[text()='Next']")
	public WebElement NextButton;
	
	@FindBy(xpath="//div[@id='i3']//span")
	public WebElement NameError;
	
	@FindBy(xpath="//div[@id='i8']//span")
	public WebElement PhoneError;
	
	@FindBy(xpath="//div[@id='i13']//span")
	public WebElement CityError;
	
	@FindBy(xpath="//div[@id='i18']//span")
	public WebElement EmailError;
	
	@FindBy(xpath="//div[@id='lpd4pf']")
	public WebElement PageNumber;
	
	@FindBy(xpath="//*[text()='Clear form']")
	public WebElement ClearFormButton;
	
	@FindBy(xpath="(//*[text()='Clear form'])[3]")
	public WebElement PopupClearFormButton;
	
	@FindBy(xpath="(//*[text()='Cancel'])[2]")
	public WebElement PopupcancelButton;
	
	
	
	@FindBy(xpath="//*[@class='SG0AAe']//*[contains(@class,'AB7Lab')]")
	public List<WebElement> RadioButtons;  //4
	
	@FindBy(xpath="//*[@class='JGptt']/input")
	public WebElement othertext;
	
	@FindBy(xpath="//div[@class='Xb9hP']/input")
	public WebElement lookingforField;
	
	@FindBy(xpath="//span[text()='Submit']")
	public WebElement SubmitButton;
	
	@FindBy(xpath="//span[@class='RHiWt']")
	public List<WebElement> ErrorMessages; //2

	@FindBy(xpath="//*[@class='lRwqcd']//span[text()='Back']")
	public WebElement BackButton;
	
	@FindBy(xpath="//div[@class='bEJm0e']/div/div")
	public WebElement ProgressBar;  //style
	
	@FindBy(xpath="//div[@class='bEJm0e']/div[2]")
	public WebElement Progresspage;  
	
	@FindBy(xpath="//a[text()='Switch account']")
	public WebElement SwitchAccountlink;
	
	@FindBy(xpath="//*[text()='Sign in to Google']")
	public WebElement SigninLink;
	
	@FindBy(xpath="//*[text()='Learn more']")
	public WebElement LearnMoreLink;
	
	
	@FindBy(xpath="//*[@class='EbMsme']")
	public WebElement EmailAddress;
	
	@FindBy(xpath="(//*[text()='Continue without signing in'])[2]")
	public WebElement popupwithoutsignin;
	
	@FindBy(xpath="(//*[text()='Sign in'])[2]")
	public WebElement popupwithsignin;
	
	@FindBy(xpath="//*[@class='vHW8K']")
	public WebElement ConfirmMessage;
	
	@FindBy(xpath="//*[@id='page_content']/p/iframe")
	public WebElement formframe;
}
