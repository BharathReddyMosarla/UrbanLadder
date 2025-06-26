package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import utilities.BaseClass;

public class TestScenario24and25 extends BaseClass
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
	
	//@Test
	public void case1()
	{
		//256-261
		login();
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		ProfilePage profilepageobject=PageFactory.initElements(driver, ProfilePage.class);
			
		test=extent.createTest("Verify  profile page `Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");	
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Profile);
		test.log(Status.INFO,"Navigate to profile page");
		
		Assert.assertEquals("My Account", profilepageobject.myaccounttext.getText());
		test.log(Status.PASS,"profile page is Displayed");
		
		Assert.assertEquals(true, profilepageobject.nametext.isDisplayed());
		test.log(Status.PASS,"Name in profile page is Displayed");
		
		Assert.assertEquals(true, profilepageobject.emailtext.isDisplayed());
		test.log(Status.PASS,"Email in profile page is Displayed");
		
		Assert.assertEquals(true, profilepageobject.phnotext.isDisplayed());
		test.log(Status.PASS,"mobile number in profile page is Displayed");
		
		Assert.assertEquals(true, profilepageobject.passwordtext.getText().contains("*****"));
		test.log(Status.PASS,"password in profile page is Displayed");
		
		click(profilepageobject.editbutton);
		test.log(Status.INFO,"Enable fields to change data");
		
		Assert.assertEquals(true, profilepageobject.ChangePasswordLink.isDisplayed() && profilepageobject.Name.isDisplayed() && profilepageobject.MobileNumber.isDisplayed());
		test.log(Status.PASS,"fields are enabled and ready to change fields data");
	}
	//@Test
	public void case2()
	{
		//262
		login();
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		ProfilePage profilepageobject=PageFactory.initElements(driver, ProfilePage.class);
			
		test=extent.createTest("Verify  profile page `Functionality - valid data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");	
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Profile);
		test.log(Status.INFO,"Navigate to profile page");
		
		click(profilepageobject.editbutton);
		test.log(Status.INFO,"Enable fields to change data");
		
		profilepageobject.Name.clear();
		profilepageobject.MobileNumber.clear();
		
		enterData(profilepageobject.Name,config.getProperty("UpdateName"));
		enterData(profilepageobject.MobileNumber,config.getProperty("UpdatePhno"));
		test.log(Status.INFO,"enter updated valid data in fields");
		
		click(profilepageobject.UpdateButton);
		test.log(Status.INFO,"entered details are validated and update");
		
		Assert.assertEquals(config.getProperty("UpdateName"), profilepageobject.nametext.getText());
		test.log(Status.PASS,"Name is updated : "+config.getProperty("UpdateName"));
		
		Assert.assertEquals(config.getProperty("UpdatePhno"), profilepageobject.phnotext.getText());
		test.log(Status.PASS,"mobile number is updated : "+config.getProperty("UpdatePhno"));
		
	}
	@Test
	public void case3()
	{
		//263-264, 265(no automation), 266, 267(google),268
		login();
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		ProfilePage profilepageobject=PageFactory.initElements(driver, ProfilePage.class);
			
		test=extent.createTest("Verify  profile page `Functionality - invalid,null data and links, buttons").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");	
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Profile);
		test.log(Status.INFO,"Navigate to profile page");
		
		click(profilepageobject.editbutton);
		test.log(Status.INFO,"Enable fields to change data");
		//
		profilepageobject.Name.clear();
		profilepageobject.MobileNumber.clear();
		
		enterData(profilepageobject.Name,"645633£%@%@£@");
		enterData(profilepageobject.MobileNumber,"ncghjgdfshfdx");
		test.log(Status.INFO,"enter updated in valid data in fields");
		
		click(profilepageobject.UpdateButton);
		test.log(Status.INFO,"entered details are validated and display error messages");
		
		Assert.assertEquals("Please enter a valid number.", profilepageobject.PhnoError.getText());
		test.log(Status.PASS,"display error message below phone number field for invalid data ");
		//
		profilepageobject.Name.clear();
		profilepageobject.MobileNumber.clear();
		
		enterData(profilepageobject.Name,"");
		enterData(profilepageobject.MobileNumber,"");
		test.log(Status.INFO,"enter updated null data in fields");
		
		click(profilepageobject.UpdateButton);
		test.log(Status.INFO,"entered details are validated and display error messages");
		
		Assert.assertEquals("This field is required.", profilepageobject.NameError.getText());
		test.log(Status.PASS,"display error message below name field for null data ");
		
		//
		enterData(profilepageobject.Name,"Test");
		enterData(profilepageobject.MobileNumber,"1234567890");
		test.log(Status.INFO,"enter updated valid data in fields");
		
		click(profilepageobject.CancelButton);
		test.log(Status.INFO," clicked on cancel button and data cann't be updated ");
		
		Assert.assertNotEquals("Test", profilepageobject.nametext.getText());
		test.log(Status.PASS,"name data is not updated");
		
		Assert.assertNotEquals("1234567890", profilepageobject.phnotext.getText());
		test.log(Status.PASS," mobile number  data is not updated");
		//
		click(profilepageobject.editbutton);
		test.log(Status.INFO,"Enable fields to change data");
		
		click(profilepageobject.ChangePasswordLink);
		test.log(Status.INFO,"Enable password fields to update password");
		
		Assert.assertEquals(true, profilepageobject.Password.isEnabled());
		Assert.assertEquals(true, profilepageobject.ConfirmPassword.isEnabled());
		test.log(Status.PASS," password fields are displayed");
			
		
	}
	
}
