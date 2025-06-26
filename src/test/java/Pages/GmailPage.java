package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPage 
{
	
	public String url = "https://workspace.google.com/intl/en-US/gmail/";
	
	@FindBy(xpath="//*[@class='header__aside']//*[text()='Sign in']")
	public WebElement signinButton;
	
	@FindBy(xpath="//*[@id='identifierId']")
	public WebElement email;
	
	@FindBy(xpath="//*[text()='Next']")
	public WebElement NextButton;
	
	@FindBy(xpath="//*[@name='Passwd']")
	public WebElement password;
	
	@FindBy(xpath="//*[text()='Not now']")
	public WebElement notnow;
	
	@FindBy(xpath="//*[@id='gs_lc50']/input[1]")
	public WebElement  search;
	
	@FindBy(xpath="(//*[@class='Cp']//tbody)[2]/tr[1]/td[4]")
	public WebElement firstemail;
	
	@FindBy(xpath="//*[contains(text(),'www.urbanladder.com/password/')]")
	public WebElement passwordlink;
	
	
	//-----
	@FindBy(xpath="//*[@id='credential_picker_container']/iframe")
	public WebElement gmailframe;
	
	@FindBy(className="LgbsSe-bN97Pc")
	public WebElement continuebutton;
	
	@FindBy(id="close")
	public WebElement closeframe;
	
}
