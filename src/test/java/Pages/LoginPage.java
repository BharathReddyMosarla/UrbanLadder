package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class LoginPage 
{
	@FindBy(xpath="//*[@class='login-message']")
	public WebElement PopUpConfirm;
	
	@FindBy(xpath="//*[@name='login_form']//*[@id='spree_user_email']")
	public WebElement Email;
	
	@FindBy(xpath="//*[@name='login_form']//*[@id='spree_user_password']")
	public WebElement Password;
	
	@FindBy(xpath="//*[@name='login_form']//*[text()='Forgot Password?']")
	public WebElement ForgotPasswordLink;
	
	@FindBy(xpath="//*[@name='login_form']/*[@name='commit']")
	public WebElement LoginButton;
	
	@FindBy(xpath="//*[text()='Sign-up']")
	public WebElement SignupLink;
	
	@FindBy(xpath="//*[@id='authentication_popup']//*[contains(text(),'Close')]")
	public WebElement close;
	
	@FindBy(xpath="//*[@id='authentication_popup']//*[contains(text(),'Terms of Service')]")
	public WebElement TermsOfServiceLink;
	
	
	@FindBy(xpath="//*[@id='authentication_popup']//*[contains(text(),'Privacy & Legal Policy')]")
	public WebElement PrivacyLegalPolicyLink;
	
	@FindBy(xpath="//*[@id='facebook_login']")
	public WebElement FaceBookButton;
	
	@FindBy(xpath="//*[@id='google_login']")
	public WebElement GoogleButton;

	
	
	@FindBy(xpath="//*[@class='account-vouchers-wrap']/h3")
	public WebElement Vochertext;
	
	@FindBy(xpath="//*[@class='_2QSEL']/li[2]/div/button")
	public WebElement UserIcon;												// for hover only
	
	@FindBy(xpath="//*[@class='_2QSEL']/li[2]/div/div/ul/li[1]/a")
	public WebElement Profile;
	
	@FindBy(xpath="//*[@class='_2QSEL']/li[2]/div/div/ul/li[2]/a")
	public WebElement Orders;
	
	@FindBy(xpath="//*[@class='_2QSEL']/li[2]/div/div/ul/li[3]/a")
	public WebElement Vochers;
	
	@FindBy(xpath="//*[@class='_2QSEL']/li[2]/div/div/ul/li[4]/a")
	public WebElement Logout;
	
	@FindBy(xpath="//*[@id='existing-customer']/div/div")
	public WebElement existingerror;
	
	
	@FindBy(xpath="//*[@name='forgot_password_form']//*[@id='spree_user_email']")
	public WebElement recoveryEmail;
	
	@FindBy(xpath="//*[@name='forgot_password_form']//*[@name='commit']")
	public WebElement SubmitButton;
	
	@FindBy(xpath="//*[@id='forgot-password']/div[1]")
	public WebElement message;
	
	
	
	
	
	
	
	
	
	
	
	
}
