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

public class TestScenario41 extends BaseClass
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
		{//414-416,418,419
			//417,420,421 - is related to valid data - skipped
			
			paymentpagedisplay();
			
			test=extent.createTest("Verify Payment Options Page Functionality -upi");
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
			
			Assert.assertEquals(true, paymentoptionspageobject.UPI.isDisplayed());
			test.log(Status.PASS,"\"UPI\" payment option is displayed.");
			click(paymentoptionspageobject.UPI);
			test.log(Status.INFO,"Navigate to \"UPI\"  Option tab");
			Thread.sleep(3000);
			Assert.assertEquals(true, paymentoptionspageobject.upiqrtext.isDisplayed());
			test.log(Status.PASS,"\"UPI\" payment option displayed: QR code,upi fields, and etc,.");
			
			Assert.assertEquals(true, paymentoptionspageobject.QRCode.isDisplayed());
			test.log(Status.PASS,"QR code is displayed");
			screenshot("qrcode");
			
			Assert.assertEquals(true, paymentoptionspageobject.QRTimeout.isDisplayed());
			test.log(Status.PASS,"QR code timeout is displayed: "+paymentoptionspageobject.QRTimeout.getText());
			
			test.log(Status.INFO,"enter null data in upi id field");
			click(paymentoptionspageobject.Button);
			Thread.sleep(2000);
			Assert.assertEquals(true, paymentoptionspageobject.errorupimessage.isDisplayed());
			test.log(Status.PASS, "error message is displayed: "+paymentoptionspageobject.errorupimessage.getText());
			
			
			enterData(paymentoptionspageobject.UPIid,"fff");
			test.log(Status.INFO,"enter invalid upi id");
			click(paymentoptionspageobject.Button);
			Thread.sleep(4000);
			Assert.assertEquals(true, paymentoptionspageobject.errorupimessage.isDisplayed());
			test.log(Status.PASS, "error message is displayed: "+paymentoptionspageobject.errorupimessage.getText());

			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong : "+e.getMessage());
			screenshot("case1-41");
		}
		
	}

}
