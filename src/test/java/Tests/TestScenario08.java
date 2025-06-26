package Tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.NeedHelpBotPage;
import utilities.BaseClass;

public class TestScenario08 extends BaseClass
{
	@Test
	public void case1()
	{
		try
		{
			//130-136
			test=extent.createTest("Verifying chat bot functionality");
			test.log(Status.INFO,"Home page is Displayed");
			
			NeedHelpBotPage needhelpbotpageobject=PageFactory.initElements(driver, NeedHelpBotPage.class);
			
			
			switchToFrameByWebElement(needhelpbotpageobject.framebotelement);
			
			wait.until(ExpectedConditions.visibilityOf(needhelpbotpageobject.NeedHelpBot));
			
			Assert.assertEquals(true, needhelpbotpageobject.NeedHelpBot.isDisplayed());
			test.log(Status.PASS,"Need Help bot chat is displayed on HomePage");
			click(needhelpbotpageobject.NeedHelpBot);
			test.log(Status.INFO,"chat bot is expanded");
			
			switchToParentFrame();
			
			switchToFrameByNameOrId("haptik-xdk-main-view");
			
			Assert.assertEquals(true, needhelpbotpageobject.AppTitle.isDisplayed());
			test.log(Status.PASS," Application title is displayed : "+needhelpbotpageobject.AppTitle.getText());
			
			Assert.assertEquals(true, needhelpbotpageobject.Menu.isDisplayed());
			hover(needhelpbotpageobject.Menu);
			test.log(Status.PASS," Menu title is displayed  and Highlighted: "+needhelpbotpageobject.Menu.getText());
			
			click(needhelpbotpageobject.Menu);
			test.log(Status.INFO,"menu options are closed");
			
			Assert.assertEquals(true, needhelpbotpageobject.greetingmessage.isDisplayed());
			test.log(Status.PASS," greeting message is displayed in chat is : "+needhelpbotpageobject.greetingmessage.getText());
			
			click(needhelpbotpageobject.Menu);
			test.log(Status.INFO,"menu options are displayed");
			
			for(int i=0;i<needhelpbotpageobject.MenuOptions.size();i++)
			{
				Assert.assertEquals(true, needhelpbotpageobject.MenuOptions.get(i).isDisplayed());
				hover( needhelpbotpageobject.MenuOptions.get(i));
				test.log(Status.PASS," Menu Options  is highlighted and  displayed :"+i +" :- "+needhelpbotpageobject.MenuOptions.get(i).getText());
			}
			
			click( needhelpbotpageobject.MenuOptions.get(0));
			test.log(Status.INFO,"selctede  menu option:- "+needhelpbotpageobject.MenuOptions.get(0).getText());
			Thread.sleep(5000);
			for(int i=0;i<needhelpbotpageobject.MenuOptions.size();i++)
			{
				Assert.assertEquals(true, needhelpbotpageobject.SelectedQueryOptions.get(i).isDisplayed());
				hover( needhelpbotpageobject.SelectedQueryOptions.get(i));
				test.log(Status.PASS," selected Menu Option - options  is highlighted and  displayed :"+i +" :- "+needhelpbotpageobject.SelectedQueryOptions.get(i).getText());
			}
			
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Something Went Wrong "+e.getMessage());
		}
	}
	
}
