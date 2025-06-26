package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackOrderPage 

{
	
	
	
	
	@FindBy(name="orderNumber")
	public WebElement OrderNumber;
	
	@FindBy(name="phoneNumber")
	public WebElement PhoneNumber;
	
	@FindBy(xpath="//*[@class='awunb']/button")
	public WebElement SubmitButton;
	
	@FindBy(xpath="//*[@class='_2xfyo']/button")
	public WebElement LoginTrackAllOrders;
	
	@FindBy(xpath="//*[@class='_3JTxh']")
	public WebElement emptyordertext;
	
	
	@FindBy(xpath="//*[@class='_33bg3']")
	public WebElement OrderTextMessage;
	
	
//	@FindBy(id="")
//	public WebElement ;
//	@FindBy(id="")
//	public WebElement ;
//	@FindBy(id="")
//	public WebElement ;
//	
//	@FindBy(id="")
//	public WebElement ;
//	@FindBy(id="")
//	public WebElement ;
//	@FindBy(id="")
//	public WebElement ;
//	@FindBy(id="")
//	public WebElement ;
//	@FindBy(id="")
//	public WebElement ;
//	@FindBy(id="")
//	public WebElement ;
//	@FindBy(id="")
//	public WebElement ;

	
	
	
}
