package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TrackOrderPage;
import utilities.BaseClass;

public class TestScenario14 extends BaseClass
{
	//@Test
	public void testcase1() 
	{
		//---170, 171
		test=extent.createTest("Verify Track Orders Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		TrackOrderPage trackorderspageobject=PageFactory.initElements(driver, TrackOrderPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Login);
		test.log(Status.INFO,"Navigate to Login Popup");
		
		enterData(loginpageobject.Email,config.getProperty("LoginEmail"));
		enterData(loginpageobject.Password,config.getProperty("LoginPassword"));
		test.log(Status.INFO,"Entered valid Login Details");
		
		click(loginpageobject.LoginButton);
		test.log(Status.INFO,"Navigate to Home Page");
		
		click(homepageobject.TrackOrder);
		test.log(Status.INFO,"Navigate to Track Orders Page");
		
		Assert.assertEquals("WE ARE YET TO RECEIVE YOUR FIRST ORDER", trackorderspageobject.emptyordertext.getText());
		test.log(Status.PASS,"Display a message such as --  We are yet to receive your first order");
		
		// for test case 170 need order details in past orders in page
	}
	
	//@Test
	public void testcase2() 
	{
		//---172, 173
		test=extent.createTest("Verify Track Orders Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		TrackOrderPage trackorderspageobject=PageFactory.initElements(driver, TrackOrderPage.class);
		parent = driver.getWindowHandle();
		
		click(homepageobject.TrackOrder);
		test.log(Status.INFO,"Navigate to Track Orders Page");
		
		hover(trackorderspageobject.LoginTrackAllOrders);
		test.log(Status.INFO," Login To Track All Your Orders Button is highlighted");
		
		click(trackorderspageobject.LoginTrackAllOrders);
		test.log(Status.INFO," Navigate to login page");
		
		Assert.assertEquals(true, loginpageobject.LoginButton.isDisplayed());
		test.log(Status.PASS, "Login Page is Displayed");
		
	}
	
	//@Test
	public void testcase3() 
	{
		//---174, 175, 176
		test=extent.createTest("Verify Track Orders Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		TrackOrderPage trackorderspageobject=PageFactory.initElements(driver, TrackOrderPage.class);
		parent = driver.getWindowHandle();
		
		click(homepageobject.TrackOrder);
		test.log(Status.INFO,"Navigate to Track Orders Page");
		
		enterData(trackorderspageobject.OrderNumber,"86757567hdffdd");
		enterData(trackorderspageobject.PhoneNumber,"9856545678");
		
		click(trackorderspageobject.SubmitButton);
		test.log(Status.INFO,"give order status information");
		
		Assert.assertEquals("Order not found. If you have just placed the order, tracking information will be available after an hour.", trackorderspageobject.OrderTextMessage.getText());
		test.log(Status.PASS, "Text Message is Displayed regarding entered order number");
	}
	@Test
	public void testcase4() throws Exception 
	{
		//---177, 178
		test=extent.createTest("Verify Track Orders Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		TrackOrderPage trackorderspageobject=PageFactory.initElements(driver, TrackOrderPage.class);
		parent = driver.getWindowHandle();
		
		click(homepageobject.TrackOrder);
		test.log(Status.INFO,"Navigate to Track Orders Page");
		
		enterData(trackorderspageobject.OrderNumber,"");
		enterData(trackorderspageobject.PhoneNumber,"");
		
		click(trackorderspageobject.SubmitButton);Thread.sleep(1000);
		test.log(Status.INFO,"display validations on all fields");
		screenshot("validation1");
		
		enterData(trackorderspageobject.OrderNumber,"86757567hdffdd");
		enterData(trackorderspageobject.PhoneNumber,"985678");
		
		click(trackorderspageobject.SubmitButton);Thread.sleep(1000);
		test.log(Status.INFO,"display validations on phone fields");
		screenshot("validation2");
	
	}
	

}
