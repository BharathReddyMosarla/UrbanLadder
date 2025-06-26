package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import utilities.BaseClass;

public class TestScenario19  extends BaseClass
{
	//@Test
	public void case1() 
	{
		// 218, 225(need to check gmail)
		test=extent.createTest("Verify Signup Functionality - valid data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.SignUp);
		test.log(Status.INFO,"Navigate to Signup Popup");
		
		enterData(signuppageobject.Email,config.getProperty("validEmail")); // need to update email address
		enterData(signuppageobject.Password,config.getProperty("validPassword")); 
		test.log(Status.INFO,"Entered valid Signup Details");
		
		click(signuppageobject.SignUpButton);
		test.log(Status.INFO,"Navigate to Home Page");
		
		Assert.assertEquals("https://www.urbanladder.com/", driver.getCurrentUrl());
		test.log(Status.PASS,"Sign up is Successfull");
	}
	//@Test
	public void case2() 
	{
		//219
		test=extent.createTest("Verify Signup Functionality - Invalid data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.SignUp);
		test.log(Status.INFO,"Navigate to Signup Popup");
		
		enterData(signuppageobject.Email,config.getProperty("InvalidEmail"));
		enterData(signuppageobject.Password,config.getProperty("InvalidPassword"));
		test.log(Status.INFO,"Entered invalid Signup Details");
		
		click(signuppageobject.SignUpButton);
		test.log(Status.INFO,"show error messages");
		
		Assert.assertEquals("Please enter a valid email address.",signuppageobject.emailerror.getText() );
		test.log(Status.PASS,"error message for email is displayed");
		
		Assert.assertEquals("Password must contain at least 8 characters including at least one lowercase letter, one number and one special character with no spaces.",signuppageobject.passworderror.getText() );
		test.log(Status.PASS,"error message for password is displayed");
		
	}
	//@Test
	public void case3() 
	{
		//220
		test=extent.createTest("Verify Signup Functionality - existing data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.SignUp);
		test.log(Status.INFO,"Navigate to Signup Popup");
		
		enterData(signuppageobject.Email,config.getProperty("ExistingEmail"));
		enterData(signuppageobject.Password,config.getProperty("ExistingPassword"));
		test.log(Status.INFO,"Entered Existing Signup Details");
		
		click(signuppageobject.SignUpButton);
		test.log(Status.INFO,"show existing error message");
		
		Assert.assertEquals("Email has already been taken",signuppageobject.existingerror.getText() );
		test.log(Status.PASS,"error message for existing email is displayed");
			
	}
	//@Test
	public void case4() 
	{
		//221
		test=extent.createTest("Verify Signup Functionality - null data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
		
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.SignUp);
		test.log(Status.INFO,"Navigate to Signup Popup");
		
		enterData(signuppageobject.Email,"");
		enterData(signuppageobject.Password,"");
		test.log(Status.INFO,"leave as empty Signup Details");
		
		click(signuppageobject.SignUpButton);
		test.log(Status.INFO,"show required error messages");
		
		Assert.assertEquals("This field is required.",signuppageobject.emailerror.getText() );
		test.log(Status.PASS,"field required error message for email is displayed");
		
		Assert.assertEquals("This field is required.",signuppageobject.passworderror.getText() );
		test.log(Status.PASS,"field required  error message for password is displayed");
		
	}
	@Test
		public void case5() 
		{
		// 222-224
			test=extent.createTest("Verify Signup Functionality - links ").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
			LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);

			
			hover(homepageobject.UserIcon);
			test.log(Status.INFO,"User Icon is highlighted");
			
			click(homepageobject.SignUp);
			test.log(Status.INFO,"Navigate to Signup Popup");
			
		//	enterData(signuppageobject.Email,config.getProperty("validEmail")); // need to update email address
			enterData(signuppageobject.Password,config.getProperty("validPassword")); 
			test.log(Status.INFO,"Entered data for Signup Details");
			
			
			click(signuppageobject.ShowPassword);
			test.log(Status.INFO,"password is displayed");
			
			Assert.assertEquals(true, signuppageobject.HidePassword.isDisplayed());
			test.log(Status.PASS,"password is displayed and hide password is displayed");
			screenshot("showingpassword");
			click(signuppageobject.HidePassword);
			test.log(Status.INFO,"password is hide");
			
			Assert.assertEquals(true, signuppageobject.ShowPassword.isDisplayed());
			test.log(Status.PASS,"password is hide and show password is displayed");
			screenshot("hidingpassword");
			click(signuppageobject.LoginLink);
			test.log(Status.INFO,"Navigate to login Popup details");
			
			Assert.assertEquals(true, loginpageobject.LoginButton.isDisplayed());
			test.log(Status.PASS,"login Popup details page is displayed");
			screenshot("loginpageconfirmation");
			
		
		}
}
