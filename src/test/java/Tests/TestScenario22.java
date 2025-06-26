package Tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.GmailPage;
import Pages.HomePage;
import Pages.LoginPage;
import utilities.BaseClass;

public class TestScenario22 extends BaseClass
{
	@Test
	public void case1() throws Exception
	{
		
		//chrome
		
		test=extent.createTest("Verify forgot password Functionality");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		GmailPage gmailpageobject=PageFactory.initElements(driver, GmailPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Login);
		test.log(Status.INFO,"Navigate to Login Popup");
				
		click(loginpageobject.ForgotPasswordLink);
		test.log(Status.INFO,"Navigate to  ResetPassword Page");
		
		enterData(loginpageobject.recoveryEmail,"testurbanladderstg@gmail.com");
		click(loginpageobject.SubmitButton);
		test.log(Status.INFO,"validating the email address fo recovery password");
				
		Assert.assertEquals(true, loginpageobject.message.isDisplayed());
		test.log(Status.PASS,"message is displayed:- "+loginpageobject.message.getText());
		
		driver.get(gmailpageobject.url);
		test.log(Status.INFO,"navigate gmail page");	
		
		click(gmailpageobject.signinButton);
		
		enterData(gmailpageobject.email,"testurbanladderstg@gmail.com");
		click(gmailpageobject.NextButton);
		
		enterData(gmailpageobject.password,"Welcome@2024");
		click(gmailpageobject.NextButton);
				
		Thread.sleep(5000);
		
	}
	//@Test
	public void case2() throws Exception
	{
		
		
		
		test=extent.createTest("Verify forgot password Functionality");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		GmailPage gmailpageobject=PageFactory.initElements(driver, GmailPage.class);
		parent = driver.getWindowHandle();
		
		try {
		wait.until(ExpectedConditions.visibilityOf(gmailpageobject.gmailframe));
		switchToFrameByWebElement(gmailpageobject.gmailframe);
		click(gmailpageobject.closeframe);
		}catch(Exception e) {}
		switchToParentFrame();
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Login);
		test.log(Status.INFO,"Navigate to Login Popup");
				
		wait.until(ExpectedConditions.visibilityOf(loginpageobject.ForgotPasswordLink));
		click(loginpageobject.ForgotPasswordLink);
		test.log(Status.INFO,"Navigate to  ResetPassword Page");
		Thread.sleep(5000);
		enterData(loginpageobject.recoveryEmail,"testurbanladderstg@gmail.com");
		click(loginpageobject.SubmitButton);
		test.log(Status.INFO,"validating the email address fo recovery password");
				
		Assert.assertEquals(true, loginpageobject.message.isDisplayed());
		test.log(Status.PASS,"message is displayed:- "+loginpageobject.message.getText());
		
		driver.get(gmailpageobject.url);
		test.log(Status.INFO,"navigate gmail page");	
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(gmailpageobject.signinButton));
		click(gmailpageobject.signinButton);
		test.log(Status.INFO,"gmail field is visible");
		
		wait.until(ExpectedConditions.visibilityOf(gmailpageobject.email));
		enterData(gmailpageobject.email,"testurbanladderstg@gmail.com");
		click(gmailpageobject.NextButton);
		
		enterData(gmailpageobject.password,"Welcome@2024");
		click(gmailpageobject.NextButton);
				
		Thread.sleep(5000);
		
	}
//	@Test
	public void case3() throws Exception
	{
		
		// safari
		
		test=extent.createTest("Verify forgot password Functionality");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		GmailPage gmailpageobject=PageFactory.initElements(driver, GmailPage.class);
		parent = driver.getWindowHandle();
		
		try {
		wait.until(ExpectedConditions.visibilityOf(gmailpageobject.gmailframe));
		switchToFrameByWebElement(gmailpageobject.gmailframe);
		click(gmailpageobject.continuebutton);
		Thread.sleep(5000);
		switchToChildWindow();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(gmailpageobject.email));
		enterData(gmailpageobject.email,"testurbanladderstg@gmail.com");
		click(gmailpageobject.NextButton);
		test.log(Status.INFO,"password field is visible");
		Thread.sleep(5000);
		
		//driver.close();
		switchToParentWindow(parent);
		}catch(Exception e) {}
		
	
	}
}
