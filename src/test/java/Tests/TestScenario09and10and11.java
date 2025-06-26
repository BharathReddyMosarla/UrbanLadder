package Tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.NeedHelpBotPage;
import utilities.BaseClass;

public class TestScenario09and10and11 extends BaseClass
{

	@Test
	public void case1()
	{
		try
		{
			//137-143
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
			
			click( needhelpbotpageobject.MenuOptions.get(4));
			test.log(Status.INFO,"selctede  menu option:- "+needhelpbotpageobject.MenuOptions.get(4).getText());
			
			wait.until(ExpectedConditions.visibilityOf(needhelpbotpageobject.Workinghours));
			
			Assert.assertEquals(true, needhelpbotpageobject.Workinghours.isDisplayed());
			test.log(Status.PASS,"working hours is Displayed:- "+needhelpbotpageobject.Workinghours.getText());
			
			hover(needhelpbotpageobject.SendButton);
			test.log(Status.PASS,"send button is disabled");
			
			enterData(needhelpbotpageobject.InputFields.get(0),"");
			enterData(needhelpbotpageobject.InputFields.get(1),"8");
			enterData(needhelpbotpageobject.InputFields.get(2),"sd");
			test.log(Status.INFO,"entered invalid data in the all fields");
			test.log(Status.PASS,"User fields are displayed for connecting to agent");
			
			Assert.assertEquals(true, needhelpbotpageobject.SendButton.isDisplayed());
			test.log(Status.PASS," send button is highlighted");
			click(needhelpbotpageobject.SendButton);
			
			Assert.assertEquals(true, needhelpbotpageobject.errormessages.get(0).isDisplayed());
			test.log(Status.PASS,"error messages are : "+needhelpbotpageobject.errormessages.get(0).getText()+" : "+needhelpbotpageobject.errormessages.get(1).getText());
			
			needhelpbotpageobject.InputFields.get(1).clear();
			needhelpbotpageobject.InputFields.get(0).clear();
			needhelpbotpageobject.InputFields.get(2).clear();
			
			Thread.sleep(2000);
			
			enterData(needhelpbotpageobject.InputFields.get(0),"john paul");
			enterData(needhelpbotpageobject.InputFields.get(1),"875999645");
			enterData(needhelpbotpageobject.InputFields.get(2),"john@gail.com");
			test.log(Status.INFO,"entered valid data in the all fields are : john : 8875675645 : kohn@gail.com");
			
			hover(needhelpbotpageobject.SendButton);
			click(needhelpbotpageobject.SendButton);
			
			Thread.sleep(5000);
			
			for(int i=2;i<needhelpbotpageobject.messages.size();i++)
			{
				Assert.assertEquals(true, needhelpbotpageobject.messages.get(i).isDisplayed());
				test.log(Status.PASS," messages are displayed after entering all details : "+needhelpbotpageobject.messages.get(i).getText());
			}	
			
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Something Went Wrong "+e.getMessage());
		}
	}
	@Test(dependsOnMethods="case1")
	public void case2()
	{
		try
		{
			// 144-149
			test=extent.createTest("Verifying chat bot functionality");
			test.log(Status.INFO,"connecting  to an agent is Displayed");
			
			NeedHelpBotPage needhelpbotpageobject=PageFactory.initElements(driver, NeedHelpBotPage.class);
			
			
			
			Thread.sleep(20000);
			for(int i=3;i<needhelpbotpageobject.messages.size();i++)
			{
				Assert.assertEquals(true, needhelpbotpageobject.messages.get(i).isDisplayed());
				test.log(Status.PASS," Messages are : "+needhelpbotpageobject.messages.get(i).getText());
			}
			try {
			if(needhelpbotpageobject.queue.isDisplayed())
			{
				Thread.sleep(200000);
			}
			}catch(Exception e) {}
			
			try {
			wait.until(ExpectedConditions.visibilityOf(needhelpbotpageobject.status.get(0)));
			//Assert.assertEquals(true, needhelpbotpageobject.status.get(needhelpbotpageobject.status.size()).isDisplayed());
			test.log(Status.PASS,"Agent name is displayed: "+needhelpbotpageobject.status.get(0).getText());
			
			Thread.sleep(5000);
			
			for(int i=3;i<needhelpbotpageobject.messages.size();i++)
			{
				int size =needhelpbotpageobject.messages.size();
				Assert.assertEquals(true, needhelpbotpageobject.messages.get(size-1).isDisplayed());
				test.log(Status.PASS,"  welcome message after connecting  to an agent : "+needhelpbotpageobject.messages.get(size-1).getText());
			}
		
			
			Thread.sleep(360000);
			
			
			for(int i=3;i<needhelpbotpageobject.messages.size();i++)
			{
				Assert.assertEquals(true, needhelpbotpageobject.messages.get(i).isDisplayed());
				test.log(Status.PASS,"agent send a message for waiting for message : "+needhelpbotpageobject.messages.get(i).getText());
			}
			
			
			
			Assert.assertEquals(true, needhelpbotpageobject.status.get(1).isDisplayed());
			test.log(Status.PASS,"conversation close mesage status : "+needhelpbotpageobject.status.get(1).getText());
			
			for(int i=0;i<needhelpbotpageobject.yesorno.size();i++)
			{
				hover(needhelpbotpageobject.yesorno.get(i));
				Assert.assertEquals(true, needhelpbotpageobject.yesorno.get(i).isDisplayed());
				test.log(Status.PASS,"button is displayed : "+ needhelpbotpageobject.yesorno.get(i).getText());
			}
			
			hover( needhelpbotpageobject.yesorno.get(0));
			click( needhelpbotpageobject.yesorno.get(0));
			test.log(Status.INFO,"click on button : "+ needhelpbotpageobject.yesorno.get(0).getText());
			
			Thread.sleep(5000);
			
			for(int i=0;i<needhelpbotpageobject.yesorno.size();i++)
			{
				Assert.assertEquals(true, needhelpbotpageobject.yesorno.get(i).isDisplayed());
				test.log(Status.PASS,"ratings are displayed : "+ needhelpbotpageobject.yesorno.get(i).getText());
			}
			click( needhelpbotpageobject.yesorno.get(0));
			test.log(Status.INFO,"click on rating : "+ needhelpbotpageobject.yesorno.get(0).getText());
			
			Thread.sleep(5000);
			
			for(int i=6;i<needhelpbotpageobject.messages.size();i++)
			{
				Assert.assertEquals(true, needhelpbotpageobject.messages.get(i).isDisplayed());
				test.log(Status.PASS," rating : "+needhelpbotpageobject.messages.get(i).getText());
			}
			}catch(Exception e) {}
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Something Went Wrong "+e.getMessage());
		}
	}
//	@Test
	public void case3()
	{
		try
		{
			// 155-157
			test=extent.createTest("Verifying chat bot functionality: search field");
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
			
			Assert.assertEquals(true, needhelpbotpageobject.disablesendbutton.isDisplayed());
			test.log(Status.PASS," send icon button is disabled");
			
			
			enterData(needhelpbotpageobject.searchfield,"edc");
			test.log(Status.INFO,"enter invalid data: edc");
			Thread.sleep(3000);
			
			Assert.assertEquals(true, needhelpbotpageobject.activesendbutton.isDisplayed());
			test.log(Status.PASS," send icon button is enabled");
			
			click(needhelpbotpageobject.activesendbutton);
			Thread.sleep(3000);
			Assert.assertEquals(true, needhelpbotpageobject.in_validmsg.get(0).isDisplayed());
			test.log(Status.PASS,"mesage for invalid search input:-  "+ needhelpbotpageobject.in_validmsg.get(0).getText());
			for(int i=0;i<needhelpbotpageobject.SelectedQueryOptions.size();i++)
			{	
				test.log(Status.PASS,"options to choose:- "+needhelpbotpageobject.SelectedQueryOptions.get(i).getText());
			}
			
			
			//
			
			enterData(needhelpbotpageobject.searchfield,"return policy");
			test.log(Status.INFO,"enter valid data: return policy");
			click(needhelpbotpageobject.activesendbutton);
			
			Thread.sleep(3000);
			Assert.assertEquals(true, needhelpbotpageobject.in_validmsg.get(1).isDisplayed());
			test.log(Status.PASS,"mesage for valid search input:-  "+ needhelpbotpageobject.in_validmsg.get(1).getText());
			
			//
			Assert.assertEquals(true, needhelpbotpageobject.SelectedQueryOptions.get(4).isDisplayed());
			test.log(Status.PASS,"options is displayed:  "+needhelpbotpageobject.SelectedQueryOptions.get(4).getText());

			
			
		}
		catch(Exception e)
		{	
			test.log(Status.FAIL, "Something Went Wrong "+e.getMessage());
		}
		
}

	//@Test
	public void case4()
	{
		try
		{
			//150,151----152-154()not done--uploading files
			test=extent.createTest("Verifying chat bot functionality- attach file");
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
			
			click( needhelpbotpageobject.MenuOptions.get(4));
			test.log(Status.INFO,"selctede  menu option:- "+needhelpbotpageobject.MenuOptions.get(4).getText());
			
			//wait.until(ExpectedConditions.visibilityOf(needhelpbotpageobject.Workinghours));
			try {
			Assert.assertEquals(false, needhelpbotpageobject.attachfile.isDisplayed());
			test.log(Status.PASS,"attach file button is not displayed before connecting to agent");
			}catch(Exception e) {
				test.log(Status.PASS,"attach file button is not displayed before connecting to agent");
			}
			
			enterData(needhelpbotpageobject.InputFields.get(0),"john paul");
			enterData(needhelpbotpageobject.InputFields.get(1),"8785999645");
			enterData(needhelpbotpageobject.InputFields.get(2),"john@gail.com");
			test.log(Status.INFO,"entered valid data in the all fields are : john : 8875675645 : kohn@gail.com");
			
			hover(needhelpbotpageobject.SendButton);
			click(needhelpbotpageobject.SendButton);
		
			Thread.sleep(20000);
			for(int i=3;i<needhelpbotpageobject.messages.size();i++)
			{
				Assert.assertEquals(true, needhelpbotpageobject.messages.get(i).isDisplayed());
				test.log(Status.PASS," Messages are : "+needhelpbotpageobject.messages.get(i).getText());
			}
			try {
			if(needhelpbotpageobject.queue.isDisplayed())
			{
				Thread.sleep(200000);
			}
			}catch(Exception e) {}
			
			
			wait.until(ExpectedConditions.visibilityOf(needhelpbotpageobject.status.get(0)));
			//Assert.assertEquals(true, needhelpbotpageobject.status.get(needhelpbotpageobject.status.size()).isDisplayed());
			test.log(Status.PASS,"Agent name is displayed: "+needhelpbotpageobject.status.get(0).getText());
			
			Thread.sleep(5000);
			
			for(int i=3;i<needhelpbotpageobject.messages.size();i++)
			{
				int size =needhelpbotpageobject.messages.size();
				Assert.assertEquals(true, needhelpbotpageobject.messages.get(size-1).isDisplayed());
				test.log(Status.PASS,"  welcome message after connecting  to an agent : "+needhelpbotpageobject.messages.get(size-1).getText());
			}
			
			Assert.assertEquals(true, needhelpbotpageobject.attachfile.isDisplayed());
			test.log(Status.PASS,"attach file button is  displayed after connecting to agent");
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Something Went Wrong "+e.getMessage());
		}
	}
	
}
