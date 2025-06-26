package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NeedHelpBotPage 
{
	
	
	
	@FindBy(xpath="//*[@class='xdk-iframe']")
	public WebElement framebotelement;
	
	@FindBy(xpath="//*[@class='minimized-view-v2-icon ']")
	public WebElement NeedHelpBot;
	
	@FindBy(id="Page-1")
	public WebElement closebot;
	
	
	
	
	@FindBy(xpath="//*[@class='header-v2-top-left-text-title']")
	public WebElement AppTitle;
	
	@FindBy(xpath="//*[contains(@class,'taskbox-new-CTA')]/span[1]")
	public WebElement Menu;
	
	@FindBy(xpath="//*[contains(@class,'taskbox-new-CTA active')]")
	public WebElement MenuActive;
	
	@FindBy(xpath="//*[contains(@class,'hsl-bubble-text')]")
	public WebElement greetingmessage;

	@FindBy(xpath="//*[@class='taskbox-new-tasks']//*[@class='task-new-title']")
	public List<WebElement> MenuOptions;
	
	@FindBy(xpath="//*[contains(@class,'hsl-actionable')]/span")
	public List<WebElement> SelectedQueryOptions;
	
	@FindBy(xpath="//*[contains(@class,'hsl-form-subtitle')]")
	public WebElement Workinghours;
	
	@FindBy(xpath="//*[@class='hsl-form-elements']//input")
	public List<WebElement> InputFields; //3
	
	@FindBy(xpath="//*[text()='SEND']")
	public WebElement SendButton;
	
	@FindBy(xpath="//*[@class='hsl-form-element-error-message']")
	public List<WebElement>  errormessages;
	
	@FindBy(xpath="//*[contains(@class,'hsl-bubble-text')]")
	public List<WebElement> messages;
	
	@FindBy(xpath="//*[contains(@class,'system-message-text')]")
	public List<WebElement> status;
	
	@FindBy(xpath="//*[contains(@class,'quick-reply-option-text')]")
	public List<WebElement> yesorno;  // rating
	
	@FindBy(xpath="//*[contains(text(),'the queue. Please wait while we assign an agent to you.')]")
	public WebElement queue;
	
	@FindBy(xpath="//*[@class='actions']")
	public WebElement attachfile;
	
	@FindBy(id="composerv2-text-area")
	public WebElement searchfield;
	
	@FindBy(xpath="//*[@class='composerv2-icon right  ']")
	public WebElement activesendbutton;
	
	@FindBy(xpath="//*[@class='composerv2-icon right disabled ']")
	public WebElement disablesendbutton;
	
	@FindBy(xpath="//*[contains(@class,'hsl-button-text')]")
	public List<WebElement>in_validmsg;
	
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
	
//	

}
