package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import utilities.BaseClass;

public class TestScenario20 extends BaseClass
{
	//@Test
	public void case1()
	{
		//226
			test=extent.createTest("Verify  Login `Functionality - valid data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
			
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
	public void case2()
	{
		//227
			test=extent.createTest("Verify  Login `Functionality - invalid data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
			SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);

			hover(homepageobject.UserIcon);
			test.log(Status.INFO,"User Icon is highlighted");
			
			click(homepageobject.Login);
			test.log(Status.INFO,"Navigate to Login Popup");
			
			enterData(loginpageobject.Email,config.getProperty("InvalidEmail"));
			enterData(loginpageobject.Password,config.getProperty("InvalidPassword"));
			test.log(Status.INFO,"Entered invalid Login Details");
			
			click(loginpageobject.LoginButton);
			test.log(Status.INFO,"show error message for email address");
			
			Assert.assertEquals("Please enter a valid email address.",signuppageobject.emailerror.getText() );
			test.log(Status.PASS,"error message for email is displayed");
				
	}
	//@Test
	public void case3() throws Exception
	{
		//228
			test=extent.createTest("Verify  Login `Functionality - non existing user data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		

			hover(homepageobject.UserIcon);
			test.log(Status.INFO,"User Icon is highlighted");
			
			click(homepageobject.Login);
			test.log(Status.INFO,"Navigate to Login Popup");
			
			enterData(loginpageobject.Email,config.getProperty("validEmail"));
			enterData(loginpageobject.Password,config.getProperty("InvalidPassword"));
			test.log(Status.INFO,"Entered non existing user Login Details");
			
			click(loginpageobject.LoginButton);
			test.log(Status.INFO,"show error message ");
			
			Assert.assertEquals("The email or password you entered is incorrect. Please try again.",loginpageobject.existingerror.getText() );
			test.log(Status.PASS,"error message for email and password is displayed");
				
	}
	
	//@Test
	public void case4() 
	{
		// 229
		test=extent.createTest("Verify  Login Functionality - null data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Login);
		test.log(Status.INFO,"Navigate to Login Popup");
		
		enterData(loginpageobject.Email,"");
		enterData(loginpageobject.Password,"");
		test.log(Status.INFO,"leave as empty Login Details");
		
		click(loginpageobject.LoginButton);
		test.log(Status.INFO,"show error message ");
		
		Assert.assertEquals("This field is required.",signuppageobject.emailerror.getText() );
		test.log(Status.PASS,"field required error message for email is displayed");
		
		Assert.assertEquals("This field is required.",signuppageobject.passworderror.getText() );
		test.log(Status.PASS,"field required  error message for password is displayed");
		
	}
//	@Test
	public void case5() 
	{
		// 230, 231
		test=extent.createTest("Verify  Login Functionality -signup link and reset password").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Login);
		test.log(Status.INFO,"Navigate to Login Popup");
		
		
		click(loginpageobject.SignupLink);
		test.log(Status.INFO,"Navigate to Signup Popup details");
		
		Assert.assertEquals(true, signuppageobject.SignUpButton.isDisplayed());
		test.log(Status.PASS,"Signup Popup details page is displayed");
		screenshot("signuppageconfirmation");
		
		click(signuppageobject.LoginLink);
		test.log(Status.INFO,"Navigate to login Popup details");
		
		click(loginpageobject.ForgotPasswordLink);
		test.log(Status.INFO,"Navigate to resetpassword page");
		Assert.assertEquals(true, driver.getCurrentUrl().contains("esetpassword"));
		test.log(Status.PASS," resetpassword page is displayed");
		
	}
	// @Test
	public void case6() throws Exception
	{
		//232,233
			test=extent.createTest("Verify  Login `Functionality - 10 failed attempts data").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
			
			hover(homepageobject.UserIcon);
			test.log(Status.INFO,"User Icon is highlighted");
			
			click(homepageobject.Login);
			test.log(Status.INFO,"Navigate to Login Popup");
			
			enterData(loginpageobject.Email,config.getProperty("LoginEmail"));
			enterData(loginpageobject.Password,config.getProperty("InvalidPassword"));
			test.log(Status.INFO,"Entered invalid Login Details");
			
			click(loginpageobject.LoginButton);
			test.log(Status.INFO,"Navigate login Page");
			
			Assert.assertEquals("The email or password you entered is incorrect. Please try again.",loginpageobject.existingerror.getText() );
			test.log(Status.PASS,"error message for email and password is displayed");
			
			for(int i=0;i<10;i++)
			{
				hover(loginpageobject.Email);
				enterData(loginpageobject.Email,config.getProperty("LoginEmail"));
				enterData(loginpageobject.Password,config.getProperty("InvalidPassword"));
				test.log(Status.INFO,"Entered invalid Login Details");
				
				click(loginpageobject.LoginButton);
				test.log(Status.INFO,"Navigate login Page");
				
				Assert.assertEquals("The email or password you entered is incorrect. Please try again.",loginpageobject.existingerror.getText() );
				test.log(Status.PASS,"error message for email and password is displayed");
			}
			
	}
	
	@Test
	public void case7() throws Exception
	{
		//234-237
			test=extent.createTest("Verify  Login `Functionality - butons and links").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
			
			hover(homepageobject.UserIcon);
			test.log(Status.INFO,"User Icon is highlighted");
			
			click(homepageobject.Login);
			test.log(Status.INFO,"Navigate to Login Popup");
			
			click(loginpageobject.FaceBookButton);
			test.log(Status.INFO,"Navigate to facebook  page");
			
			Assert.assertEquals(true, driver.getCurrentUrl().contains("facebook"));
			test.log(Status.PASS,"Navigate to facebbook page");
			
			driver.navigate().back();
			hover(homepageobject.UserIcon);
			test.log(Status.INFO,"User Icon is highlighted");
			
			click(homepageobject.Login);
			test.log(Status.INFO,"Navigate to Login Popup");
			
			click(loginpageobject.GoogleButton);
			test.log(Status.INFO,"Navigate to google signin  page");
			
			Assert.assertEquals(true, driver.getCurrentUrl().contains("account"));
			test.log(Status.PASS,"Navigate to google sognin page");
			
			driver.navigate().back();
			hover(homepageobject.UserIcon);
			test.log(Status.INFO,"User Icon is highlighted");
			
			click(homepageobject.Login);
			test.log(Status.INFO,"Navigate to Login Popup");
			
			click(loginpageobject.PrivacyLegalPolicyLink);
			test.log(Status.INFO,"Navigate to privacy policy  page");
			
			Assert.assertEquals(true, driver.getCurrentUrl().contains("privacy"));
			test.log(Status.PASS,"privacy policy page id displayed");
			
			hover(homepageobject.UserIcon);
			test.log(Status.INFO,"User Icon is highlighted");
			
			click(homepageobject.Login);
			test.log(Status.INFO,"Navigate to Login Popup");
			
			click(loginpageobject.TermsOfServiceLink);
			test.log(Status.INFO,"Navigate to terms and condition page");
			
			Assert.assertEquals(true, driver.getCurrentUrl().contains("terms"));
			test.log(Status.PASS," terms and condition page is displayed");
			
	}
	
}
