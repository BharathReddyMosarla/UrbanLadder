package Tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.AddressPage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.PaymentOptionsPage;
import Pages.PaymentPage;
import utilities.BaseClass;

public class TestScenario40 extends BaseClass
{
	public void login() 
	{
		try {
		test=extent.createTest("login to user - cart have products");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
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
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,e.getMessage());
			screenshot("login");
		}
	}

	public void dataSA()
	{
		AddressPage addresspageobject=PageFactory.initElements(driver, AddressPage.class);
		
		String 	SAPincode = "500037",
				SAAddress = "manchester, london",
				SAFirstName ="john",
				SALastName = "paul",
				SAMobileNumber ="9784678938";
					//	SAEmail ="abc@gmail.com"
		
		//enterData(addresspageobject.SAEmail,SAEmail);
	//	test.log(Status.INFO," enterd  valid email : "+SAEmail);
		enterData(addresspageobject.SAPincode,SAPincode);
//		test.log(Status.INFO," enterd  valid pincode : "+SAPincode);
		enterData(addresspageobject.SAAddress,SAAddress);
//		test.log(Status.INFO," enterd  valid address : "+SAAddress);
		enterData(addresspageobject.SAFirstName,SAFirstName);
//		test.log(Status.INFO," enterd  valid firstname : "+SAFirstName);
		enterData(addresspageobject.SALastName,SALastName);
//		test.log(Status.INFO," enterd  valid lastname : "+SALastName);
		enterData(addresspageobject.SAMobileNumber,SAMobileNumber);
//		test.log(Status.INFO," enterd  valid phonenumber : "+SAMobileNumber);
		test.log(Status.INFO,"validating enterd  valid data");
	}
				

	public void paymentpagedisplay()
	{
		
		login();
		try 
		{
			test=extent.createTest("Verify payment page ");
			test.log(Status.INFO,"Home page is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
			AddressPage addresspageobject=PageFactory.initElements(driver, AddressPage.class);
			PaymentPage paymentpageobject=PageFactory.initElements(driver, PaymentPage.class);
			
			parent = driver.getWindowHandle();
			
			hover(homepageobject.CartIcon);
			click(homepageobject.CartIcon);
			test.log(Status.INFO,"Navigate to Cart Page");
			
			hover(cartpageobject.CheckoutButton);
			click(cartpageobject.CheckoutButton);
			test.log(Status.INFO,"Navigate to Address Page");
			
			dataSA();
			
			wait.until(ExpectedConditions.elementToBeClickable(addresspageobject.SaveContinueButton));
			hover(addresspageobject.SaveContinueButton);
			click(addresspageobject.SaveContinueButton);
			test.log(Status.INFO,"Navigate to Payment Page");
			wait.until(ExpectedConditions.visibilityOf(paymentpageobject.PlaceOrderButton));
			Assert.assertEquals("https://www.urbanladder.com/checkout/payment", driver.getCurrentUrl());
			test.log(Status.PASS,"Payment Page is Displayed");
						
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong : "+e.getMessage());
			screenshot("paymentpagedisplay");
		}
	}
	
	@Test
	public void case1()
	{
		try
		{
			//404-407, 410-413
			//408,409 is related to valid data - skipped
			paymentpagedisplay();
			
			test=extent.createTest("Verify Payment Options Page Functionality -pay with axio");
			test.log(Status.INFO,"Payment page is Displayed");
			
			PaymentPage paymentpageobject=PageFactory.initElements(driver, PaymentPage.class);
			PaymentOptionsPage paymentoptionspageobject=PageFactory.initElements(driver, PaymentOptionsPage.class);
			
			wait.until(ExpectedConditions.visibilityOf(paymentpageobject.PlaceOrderButton));		
			click(paymentpageobject.PlaceOrderButton);
			test.log(Status.INFO,"Navigate to Payment  Options");		
			switchToFrameByWebElement(paymentoptionspageobject.POFrame);
			wait.until(ExpectedConditions.visibilityOf(paymentoptionspageobject.UrbanLadderText));
			wait.until(ExpectedConditions.visibilityOf(paymentoptionspageobject.PriceSummary));
			Thread.sleep(3000);
			
			Assert.assertEquals(true, paymentoptionspageobject.PaywithAxio.isDisplayed());
			test.log(Status.PASS,"\"Pay with Axio\" payment option is displayed.");
			click(paymentoptionspageobject.PaywithAxio);
			test.log(Status.INFO,"Navigate to \"Pay with Axio\"  Option tab");
			Thread.sleep(3000);
			Assert.assertEquals(true, paymentoptionspageobject.AxioButton.isDisplayed());
			test.log(Status.PASS,"\"Pay with Axio\" payment option tab contains axio button");
			
			hover(paymentoptionspageobject.AxioButton);
			test.log(Status.INFO,"axio button is highlighted");
			click(paymentoptionspageobject.AxioButton);
			test.log(Status.INFO,"after click on axio button , application will sent an otp  to a mobile number of registered with application");
			
			
			try 
			{
				Assert.assertEquals(true, paymentoptionspageobject.failedotp.isDisplayed());
				test.log(Status.FAIL,"otp sent is failed"+paymentoptionspageobject.failedotp.getText());
			}
			catch(Exception e)
			{
				
			}
			wait.until(ExpectedConditions.visibilityOf(paymentoptionspageobject.textotppopup));
			Assert.assertEquals(true, paymentoptionspageobject.textotppopup.isDisplayed());
			test.log(Status.PASS,"popup page is displayed with otp field Message-: "+paymentoptionspageobject.textotppopup.getText());
			Assert.assertEquals(true, paymentoptionspageobject.resendtime.isDisplayed());
			test.log(Status.PASS,"time is displayed for resend otp: "+paymentoptionspageobject.resendtime.getText());

			Thread.sleep(11000);
			wait.until(ExpectedConditions.visibilityOf(paymentoptionspageobject.resendotp));
			
			Assert.assertEquals(true, paymentoptionspageobject.resendotp.isDisplayed());
			test.log(Status.PASS,"resend otp link is displayed after: 30s");
			
			for(int i=0;i<paymentoptionspageobject.otpfields.size();i++)
			{
				enterData(paymentoptionspageobject.otpfields.get(i),""+i);
			}
			test.log(Status.INFO,"entering invalid otp");
			Thread.sleep(2000);
			Assert.assertEquals(true, paymentoptionspageobject.errorotpmessage.isDisplayed());
			test.log(Status.PASS,"error message is displayed: "+paymentoptionspageobject.errorotpmessage.getText());
			
			click(paymentoptionspageobject.resendotp);
			test.log(Status.INFO,"click on resend otp to generate new otp to registered mobile number");
			
			for(int i=0;i<paymentoptionspageobject.otpfields.size();i++)
			{
				enterData(paymentoptionspageobject.otpfields.get(i),""+i);
			}
			test.log(Status.INFO,"entered first otp");
			Thread.sleep(2000);
			Assert.assertEquals(true, paymentoptionspageobject.errorotpmessage.isDisplayed());
			test.log(Status.PASS,"error message is displayed after enetering first otp: "+paymentoptionspageobject.errorotpmessage.getText());
			
			
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong : "+e.getMessage());
			screenshot("case1-40");
		}
		
		
	}

}
