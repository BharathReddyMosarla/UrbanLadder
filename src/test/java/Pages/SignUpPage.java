package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage 
{
	@FindBy(xpath="//*[@class='login-message']")
	public WebElement PopUpConfirm;
	
	@FindBy(xpath="//*[@name='signup_form']/*[@id='spree_user_email']")
	public WebElement Email;
	
	@FindBy(xpath="//*[@name='signup_form']//*[@id='spree_user_password'][2]")
	public WebElement Password;
	
	@FindBy(xpath="//*[@name='signup_form']//*[text()='Show Password']")
	public WebElement ShowPassword;
	
	@FindBy(xpath="//*[@name='signup_form']//*[text()='Hide Password']")
	public WebElement HidePassword;
	
	@FindBy(xpath="//*[@name='signup_form']/*[@name='commit']")
	public WebElement SignUpButton;
	
	@FindBy(xpath="//*[text()='Log-in']")
	public WebElement LoginLink;
	
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
	
	@FindBy(xpath="//*[@class='error' and @for='spree_user_email']")
	public WebElement emailerror;
	
	@FindBy(xpath="//*[@class='error' and @for='spree_user_password']")
	public WebElement passworderror;
	
	@FindBy(xpath="//*[@id='ulerrors']/ul/li")
	public WebElement existingerror;
	

	
}
