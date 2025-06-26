package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.LoginPage;

import Pages.WishlistPage;
import utilities.BaseClass;

public class TestScenario03  extends BaseClass
{
	//27-36
	//@Test
	public void case1()
	{
		test=extent.createTest("Verify After Login User Options").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
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
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		
		hover(homepageobject.Profile);
		test.log(Status.INFO,"Profile list is highlighted");
		
		hover(homepageobject.Vochers);
		test.log(Status.INFO,"Vochers list is highlighted");
		
		hover(homepageobject.Orders);
		test.log(Status.INFO,"Orders list is highlighted");
		
		hover(homepageobject.Logout);
		test.log(Status.INFO,"Logout list is highlighted");
		
		
		hover(homepageobject.UserIcon);
		click(homepageobject.Profile);
		test.log(Status.INFO,"Navigate to Profile page"); 
		
		Assert.assertEquals("My Account - Urban Ladder", driver.getTitle());
		test.log(Status.PASS,"Profile Page is Displayed");
		
		hover(homepageobject.UserIcon);
		click(homepageobject.Vochers);
		test.log(Status.INFO,"Navigate to Vochers page");
		
		Assert.assertEquals(true, loginpageobject.Vochertext.isDisplayed());
		test.log(Status.PASS,"Vochers Page is Displayed");
		
		hover(homepageobject.UserIcon);
		click(homepageobject.Orders);
		test.log(Status.INFO,"Navigate to Orders page");
		
		Assert.assertEquals("My Orders | Urbanladder", driver.getTitle());
		test.log(Status.PASS,"Orders Page is Displayed");
		
		
		hover(homepageobject.UserIcon);
		click(homepageobject.Logout);
		test.log(Status.INFO,"Navigate to Home page");
		
		Assert.assertEquals("https://www.urbanladder.com/", driver.getCurrentUrl());
		test.log(Status.PASS,"Home Page is Displayed");
		
	}
	@Test
	public void case2()
	{
		test=extent.createTest("Verify After Login Wishlist Icon").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		WishlistPage wishlistpageobject=PageFactory.initElements(driver, WishlistPage.class);
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Login);
		test.log(Status.INFO,"Navigate to Login Popup");
		
		enterData(loginpageobject.Email,config.getProperty("LoginEmail"));
		enterData(loginpageobject.Password,config.getProperty("LoginPassword"));
		test.log(Status.INFO,"Entered valid Login Details");
		
		click(loginpageobject.LoginButton);
		test.log(Status.INFO,"Navigate to Home Page");
		
		Assert.assertEquals(true, homepageobject.WishlistCount.isDisplayed());
		test.log(Status.PASS,"Wishlist count is Displayed and Default value is 0");
		
		click(homepageobject.WishlistIcon);
		test.log(Status.INFO,"Navigate to Wishlist page");
		
		Assert.assertEquals(true, wishlistpageobject.OopsMessage.isDisplayed());
		test.log(Status.PASS,"Wishlist Page is Displayed");
		
	}

}


