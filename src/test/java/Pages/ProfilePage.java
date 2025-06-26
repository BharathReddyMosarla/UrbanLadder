package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage 
{
	@FindBy(xpath="//*[@class='account_header']")
	public WebElement myaccounttext;
	
	@FindBy(xpath="(//*[@id='account-summary']//*[@class='profile-value'])[1]")
	public WebElement nametext;
	@FindBy(xpath="(//*[@id='account-summary']//*[@class='profile-value'])[2]")
	public WebElement emailtext;
	@FindBy(xpath="(//*[@id='account-summary']//*[@class='profile-value'])[3]")
	public WebElement phnotext;
	@FindBy(xpath="(//*[@id='account-summary']//*[contains(@class,'profile-value')])[4]")
	public WebElement passwordtext;
	
	
	@FindBy(xpath="//*[@id='edit']")
	public WebElement editbutton;
	
	@FindBy(id="user_name")
	public WebElement Name;
	
	@FindBy(id="user_mobile")
	public WebElement MobileNumber;
	
	@FindBy(id="change_password")
	public WebElement ChangePasswordLink;
	
	@FindBy(id="user_password")
	public WebElement Password;
	
	@FindBy(id="user_password_confirmation")
	public WebElement ConfirmPassword;
	
	@FindBy(xpath="//*[@class='error' and @for='user_name']")
	public WebElement NameError;
	@FindBy(xpath="//*[@class='error' and @for='user_mobile']")
	public WebElement PhnoError;
	@FindBy(xpath="//*[@class='error' and @for='user_password']")
	public WebElement PasswordError;
	@FindBy(xpath="//*[@class='error' and @for='user_password_confirmation']")
	public WebElement ConfirmPasswordError;
	
	@FindBy(xpath="//*[@name='commit' and @value='Update']")
	public WebElement UpdateButton;
	
	@FindBy(id="cancel")
	public WebElement CancelButton;
	
	@FindBy(xpath="//*[text()='Account updated']")
	public WebElement updatemessage;
	
	
	@FindBy(className="no-voucher")
	public WebElement emptyvochermessage;
	

}
