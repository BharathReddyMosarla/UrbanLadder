package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPage 
{
	
	
	@FindBy(id="help-center-search-input")
	public WebElement SearchBar;
	
	@FindBy(xpath="//*[contains(@class,'help-center-search-icon')]")
	public WebElement SearchIconButton;
	
	@FindBy(xpath="//*[@class='topics']/li/a")
	public List<WebElement> HelpTopics;
	
	
	@FindBy(xpath="//*[@class='entries-title']")
	public WebElement SelectedHelpTopicHeading;
	
	@FindBy(xpath="//*[@id='content']//*[@class='key']")
	public WebElement searchresultinput;
	
	@FindBy(xpath="//*[@id='content']//*[@class='entries-title']")
	public WebElement searchresulttext;
	
	@FindBy(xpath="//*[@id='content']//*[@class='tt-menu']/div/div")
	public List<WebElement> autosugesstions;
	
	@FindBy(xpath="//*[@class='help-center-title']")
	public WebElement titletext;
	
	@FindBy(xpath="//*[@class='contact-us-suggestion']")
	public WebElement sugginvalidtext;
	
	@FindBy(xpath="//*[@class='contact-us-suggestion']/a")
	public WebElement contactuslink;
	
	@FindBy(xpath="//*[@class='topic-title inverted highlight']")
	public WebElement highlighthelptopic;
	
	
	
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
