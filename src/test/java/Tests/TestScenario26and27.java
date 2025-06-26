package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import utilities.BaseClass;

public class TestScenario26and27 extends BaseClass
{
	public void login()
	{
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		
		test=extent.createTest("Verify  login page Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Login);
		test.log(Status.INFO,"Navigate to Login Popup");
		
		enterData(loginpageobject.Email,config.getProperty("LoginEmail"));
		enterData(loginpageobject.Password,config.getProperty("LoginPassword"));
		test.log(Status.INFO,"Entered valid Login Details");
		
		click(loginpageobject.LoginButton);
		test.log(Status.INFO,"Navigate to Home Page");
		
		Assert.assertEquals("https://www.urbanladder.com/", driver.getCurrentUrl());
		test.log(Status.PASS,"Login is Successfull");
	}
	
	@Test
	public void case1()
	{
		//269-272
		login();
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		ProfilePage profilepageobject=PageFactory.initElements(driver, ProfilePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
			
		test=extent.createTest("Verify  profile page `Functionality - invalid,null data and links, buttons").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");	
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Profile);
		test.log(Status.INFO,"Navigate to profile page");
		
		click(profilepageobject.editbutton);
		test.log(Status.INFO,"Enable fields to change data");
		
		click(profilepageobject.ChangePasswordLink);
		test.log(Status.INFO,"Enable password fields to update password");
	//	
		enterData(profilepageobject.Password,config.getProperty("UpdatePassword"));
		enterData(profilepageobject.ConfirmPassword,config.getProperty("UpdatePassword"));
		test.log(Status.INFO,"Entered valid data ");
		
		click(profilepageobject.UpdateButton);
		test.log(Status.INFO,"Navigate to confirmation page wirh login details");
		
		Assert.assertEquals("Account updated", profilepageobject.updatemessage.getText());
		test.log(Status.PASS," password is updated : "+config.getProperty("UpdatePassword"));
		
		enterData(loginpageobject.Email,config.getProperty("LoginEmail"));
		enterData(loginpageobject.Password,config.getProperty("UpdatePassword"));
		test.log(Status.INFO,"Entered valid Login Details");
		
		click(loginpageobject.LoginButton);
		test.log(Status.INFO,"Navigate to profile Page");
		
		Assert.assertEquals("My Account", profilepageobject.myaccounttext.getText());
		test.log(Status.PASS,"profile page is Displayed and password is successfull updated and verified");
//
		click(profilepageobject.editbutton);
		test.log(Status.INFO,"Enable fields to change data");
		
		click(profilepageobject.ChangePasswordLink);
		test.log(Status.INFO,"Enable password fields to update password");
		
		enterData(profilepageobject.Password,config.getProperty("UpdatePassword"));
		enterData(profilepageobject.ConfirmPassword,config.getProperty("LoginPassword"));
		test.log(Status.INFO,"Entered mismatched data for password fields ");
		click(profilepageobject.UpdateButton);
		Assert.assertEquals("Please enter the same value again.", profilepageobject.ConfirmPasswordError.getText());
		test.log(Status.PASS,"mismatch error message is displayed");
//
		profilepageobject.Password.clear();
		profilepageobject.ConfirmPassword.clear();
		enterData(profilepageobject.Password,"sdjgfshfghg");
		enterData(profilepageobject.ConfirmPassword,"sdjgfshfghg");
		test.log(Status.INFO,"Entered invalid data ");
		click(profilepageobject.UpdateButton);
		Assert.assertEquals( profilepageobject.PasswordError.getText(),"Password must contain at least 8 characters including at least one lowercase letter, one number and one special character with no spaces.");
		test.log(Status.PASS,"password error message is displayed");
		
//
		profilepageobject.Password.clear();
		profilepageobject.ConfirmPassword.clear();
		enterData(profilepageobject.Password,"");
		enterData(profilepageobject.ConfirmPassword,"");
		test.log(Status.INFO,"Entered null data ");
		click(profilepageobject.UpdateButton);
		Assert.assertEquals("This field is required.", profilepageobject.ConfirmPasswordError.getText());
		test.log(Status.PASS,"error message for Confirmation password  is displayed");
		
		Assert.assertEquals( profilepageobject.PasswordError.getText(),"This field is required.");
		test.log(Status.PASS,"password error message is displayed");
		
		
	}
	@Test
	public void case2()
	{
		//274-275
		login();
		test=extent.createTest("Verify  vochers page `Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");	
		
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		ProfilePage profilepageobject=PageFactory.initElements(driver, ProfilePage.class);
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Vochers);
		test.log(Status.INFO,"Navigate to vochers page");
		
		Assert.assertEquals("https://www.urbanladder.com/vouchers", driver.getCurrentUrl());
		test.log(Status.PASS,"  vochers page is displayed");
		
		Assert.assertEquals("You don't seem to have any Voucher as of now.", profilepageobject.emptyvochermessage.getText());
		test.log(Status.PASS,"  no vochers message is displayed");
	}
	
}
