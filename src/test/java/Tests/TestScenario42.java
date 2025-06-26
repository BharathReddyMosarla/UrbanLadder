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

public class TestScenario42 extends BaseClass
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
	
	//@Test(priority=1)
	public void case1()
	{
		try
		{//422,424,425
			// is related to valid data - skipped
			
			paymentpagedisplay();
			
			test=extent.createTest("Verify Payment Options Page Functionality -card payments");
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
			
			Assert.assertEquals(true, paymentoptionspageobject.Cards.isDisplayed());
			test.log(Status.PASS,"\"Cards\" payment option is displayed.");
			click(paymentoptionspageobject.Cards);
			test.log(Status.INFO,"Navigate to \"Cards\"  Option tab");
			Thread.sleep(3000);
			
			test.log(Status.INFO,"enter null data in all card fields");
			click(paymentoptionspageobject.continueButton);
			Thread.sleep(4000);
			Assert.assertEquals(true, paymentoptionspageobject.errormessagecardname.isDisplayed());
			test.log(Status.PASS, "error message is displayed: "+paymentoptionspageobject.errormessagecardname.getText());
			
			enterData(paymentoptionspageobject.cardnumber,"7786745678456787");
			enterData(paymentoptionspageobject.cardexpiry,"1229");
			enterData(paymentoptionspageobject.cardcvv,"345");
			enterData(paymentoptionspageobject.cardname,"john paul");
			test.log(Status.INFO,"entered invalid data in card field");

			click(paymentoptionspageobject.continueButton);
			Thread.sleep(4000);
			Assert.assertEquals(true, paymentoptionspageobject.errormessagecardname.isDisplayed());
			test.log(Status.PASS, "error message is displayed: "+paymentoptionspageobject.errormessagecardname.getText());
			
			click(paymentoptionspageobject.closepopup);
			wait.until(ExpectedConditions.visibilityOf(paymentoptionspageobject.YesExit));		

			click(paymentoptionspageobject.YesExit);
			
			switchToParentFrame();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong : "+e.getMessage());
			screenshot("case1-42");
		}
		
	}	
	//@Test(priority=2)
	public void case2()
	{
		try
		{//423
			
			
		//	paymentpagedisplay();
			
			test=extent.createTest("Verify Payment Options Page Functionality -card payments - valid");
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
			
			Assert.assertEquals(true, paymentoptionspageobject.Cards.isDisplayed());
			test.log(Status.PASS,"\"Cards\" payment option is displayed.");
			click(paymentoptionspageobject.Cards);
			test.log(Status.INFO,"Navigate to \"Cards\"  Option tab");
			Thread.sleep(3000);
			
			enterData(paymentoptionspageobject.cardnumber,"4389760128472943");
			enterData(paymentoptionspageobject.cardexpiry,"0230");
			enterData(paymentoptionspageobject.cardcvv,"597");
			enterData(paymentoptionspageobject.cardname,"Mosarla Bharath Reddy");
			test.log(Status.INFO,"entered valid data in card field");
			
			Thread.sleep(2000);
			click(paymentoptionspageobject.continueButton);
			test.log(Status.INFO,"validating entered card details and asking for secure the card");
			Thread.sleep(4000);
			click(paymentoptionspageobject.maybelater);
			test.log(Status.INFO,"selecting not secure the card and displaying card and generating otp and dispaly otp fields");
			
			Thread.sleep(1000);
			screenshot("cardpic");
			test.log(Status.INFO,"storing card pic in screenshot folder for verification purpose: cardpic.png");
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong : "+e.getMessage());
			screenshot("case2-42");
		}
	}
	@Test
	public void case3()
	{
		try
		{//423,427
			// 426 is related to valid data and valid otp- skipped
			
			paymentpagedisplay();
			
			test=extent.createTest("Verify Payment Options Page Functionality -card payments - valid");
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
			
			Assert.assertEquals(true, paymentoptionspageobject.Cards.isDisplayed());
			test.log(Status.PASS,"\"Cards\" payment option is displayed.");
			click(paymentoptionspageobject.Cards);
			test.log(Status.INFO,"Navigate to \"Cards\"  Option tab");
			Thread.sleep(3000);
			
			enterData(paymentoptionspageobject.cardnumber,"4341580011206274");
			enterData(paymentoptionspageobject.cardexpiry,"0329");
			enterData(paymentoptionspageobject.cardcvv,"916");
			enterData(paymentoptionspageobject.cardname,"Mosarla Bharath Reddy");
			test.log(Status.INFO,"entered valid data in card field");
			
			Thread.sleep(2000);
			click(paymentoptionspageobject.continueButton);
			test.log(Status.INFO,"validating entered card details and asking for secure the card");
			Thread.sleep(4000);
			click(paymentoptionspageobject.maybelater);
			test.log(Status.INFO,"selecting not secure the card and displaying card and generating otp and dispaly otp fields");
			
			Thread.sleep(1000);
			screenshot("cardpicvalid");
			test.log(Status.INFO,"storing card pic in screenshot folder for verification purpose: cardpic.png");
			Thread.sleep(4000);
			test.log(Status.INFO,"--------------------------------------------");
			Assert.assertEquals(true, paymentoptionspageobject.otptext.isDisplayed());
			test.log(Status.PASS,"otp field is displayed");
			test.log(Status.INFO,""+paymentoptionspageobject.timeoutforsubmission.getText());
			test.log(Status.INFO,""+paymentoptionspageobject.otptext.getText());
			test.log(Status.INFO,""+paymentoptionspageobject.otpforcardtext.getText());
			test.log(Status.INFO,"resend otp time:- "+paymentoptionspageobject.resendtime.getText());
			
			enterData(paymentoptionspageobject.enterotp,"765898");
			test.log(Status.INFO,"entering invalid data");
			click(paymentoptionspageobject.continueotpbutton);
			Thread.sleep(4000);
			Assert.assertEquals(true, paymentoptionspageobject.errorotpmessagecard.isDisplayed());
			test.log(Status.PASS,"error message is displayced: "+paymentoptionspageobject.errorotpmessagecard.getText());
			
	
			
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong : "+e.getMessage());
			screenshot("case3-42");
		}
	}		

}
