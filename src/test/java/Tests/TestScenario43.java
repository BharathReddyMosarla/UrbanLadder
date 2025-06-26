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

public class TestScenario43 extends BaseClass
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
	
	//@Test
	public void case1()
	{
		try
		{//428-431
			
			paymentpagedisplay();
			
			test=extent.createTest("Verify Payment Options Page Functionality - EMI payment options");
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
			
			Assert.assertEquals(true, paymentoptionspageobject.EMI.isDisplayed());
			test.log(Status.PASS,"\"EMI\" payment option is displayed.");
			click(paymentoptionspageobject.EMI);
			test.log(Status.INFO,"Navigate to \"EMI\"  Option tab");
			Thread.sleep(3000);
			
			
			Assert.assertEquals(true, paymentoptionspageobject.debitcardemi.isDisplayed());
			test.log(Status.PASS,"debit card emi option tab is displayed");
			click(paymentoptionspageobject.debitcardemi);
			Thread.sleep(3000);
			test.log(Status.INFO,"Navigate to debit card emi banks");
			test.log(Status.INFO,"********** debit card emi bank options **********");
			for(int i=0;i<paymentoptionspageobject.listemibanks.size();i++)
			{
				Thread.sleep(2000);
				test.log(Status.INFO,+(i+1)+" :"+paymentoptionspageobject.listemibanks.get(i).getText());
				
			}
			click(paymentoptionspageobject.back);
			
			Thread.sleep(3000);
			Assert.assertEquals(true, paymentoptionspageobject.cardlessemi.isDisplayed());
			test.log(Status.PASS," cardless emi option tab is displayed");
			click(paymentoptionspageobject.cardlessemi);
			Thread.sleep(3000);
			test.log(Status.INFO,"Navigate to cardless emi banks");
			test.log(Status.INFO,"**********  cardless emi bank options **********");
			for(int i=0;i<paymentoptionspageobject.listemibanks.size();i++)
			{
				Thread.sleep(2000);
				test.log(Status.INFO,+(i+1)+" :"+paymentoptionspageobject.listemibanks.get(i).getText());
			
			}
			click(paymentoptionspageobject.back);
			
			
			Thread.sleep(3000);
			Assert.assertEquals(true, paymentoptionspageobject.creditcardemi.isDisplayed());
			test.log(Status.PASS,"credit card emi option tab is displayed");
			click(paymentoptionspageobject.creditcardemi);
			Thread.sleep(3000);
			test.log(Status.INFO,"Navigate to credit card emi banks");
			test.log(Status.INFO,"********** credit card emi bank options *********");
			for(int i=0;i<paymentoptionspageobject.listemibanks.size();i++)
			{
				Thread.sleep(1000);
				hover(paymentoptionspageobject.listemibanks.get(i));
				test.log(Status.INFO,+(i+1)+" : "+paymentoptionspageobject.listemibanks.get(i).getText());
			}
			
			for(int i=0;i<5;i++)
			{
				Thread.sleep(3000);
				hover(paymentoptionspageobject.listemibanks.get(i));
				click(paymentoptionspageobject.listemibanks.get(i));
				test.log(Status.INFO,"------ emi options for "+(i+1)+" : "+paymentoptionspageobject.listemibanks.get(i).getText()+"+-------");

				for(int j=0;j<paymentoptionspageobject.emiplansforbank.size();j++)
				{
					Thread.sleep(3000);
					hover(paymentoptionspageobject.emiplansforbank.get(j));
					test.log(Status.INFO,+(j+1)+" :"+paymentoptionspageobject.emiplansforbank.get(j).getText());
					test.log(Status.INFO,""+paymentoptionspageobject.emiplansforbankintrest.get(j).getText());
				}	
				hover(paymentoptionspageobject.listemibanks.get(i));
				click(paymentoptionspageobject.listemibanks.get(i));
				test.log(Status.INFO,"--------------------------------------------------");
			}
			click(paymentoptionspageobject.back);
			

			
			
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong : "+e.getMessage());
			screenshot("case1-43");
		}
	}

	//@Test
	public void case2()
	{
		try
		{//432-435
			
			paymentpagedisplay();
			
			test=extent.createTest("Verify Payment Options Page Functionality - Netbanking payment options");
			test.log(Status.INFO,"Payment page is Displayed");
			
			PaymentPage paymentpageobject=PageFactory.initElements(driver, PaymentPage.class);
			PaymentOptionsPage paymentoptionspageobject=PageFactory.initElements(driver, PaymentOptionsPage.class);
			parent = driver.getWindowHandle();
			wait.until(ExpectedConditions.visibilityOf(paymentpageobject.PlaceOrderButton));		
			click(paymentpageobject.PlaceOrderButton);
			test.log(Status.INFO,"Navigate to Payment  Options");		
			switchToFrameByWebElement(paymentoptionspageobject.POFrame);
			wait.until(ExpectedConditions.visibilityOf(paymentoptionspageobject.UrbanLadderText));
			wait.until(ExpectedConditions.visibilityOf(paymentoptionspageobject.PriceSummary));
			Thread.sleep(3000);
			
			Assert.assertEquals(true, paymentoptionspageobject.Netbanking.isDisplayed());
			test.log(Status.PASS,"\"Netbanking\" payment option is displayed.");
			click(paymentoptionspageobject.Netbanking);
			test.log(Status.INFO,"Navigate to \"Netbanking\"  Option tab");
			Thread.sleep(3000);
			
			test.log(Status.INFO,"********** Suggested Banks list in Netbanking *********");
			for(int i=0;i<paymentoptionspageobject.suggestedbanks.size();i++)
			{
				hover(paymentoptionspageobject.suggestedbanks.get(i));
				test.log(Status.INFO,+(i+1)+" :"+paymentoptionspageobject.suggestedbanks.get(i).getText());

			}
			
			test.log(Status.INFO,"********** All Banks list in Netbanking *********");
			for(int i=0;i<paymentoptionspageobject.allbanks.size();i++)
			{
				hover(paymentoptionspageobject.allbanks.get(i));
				test.log(Status.INFO,+(i+1)+" :"+paymentoptionspageobject.allbanks.get(i).getText());

			}
			String bankname="sbi";
			enterData(paymentoptionspageobject.banksearch,bankname);
			test.log(Status.INFO,"Entered valid bank search input : "+bankname);
			test.log(Status.INFO,"********** searched bank list in Netbanking *********");
			for(int i=0;i<paymentoptionspageobject.searchbankresults.size();i++)
			{
				hover(paymentoptionspageobject.searchbankresults.get(i));
				test.log(Status.INFO,+(i+1)+" :"+paymentoptionspageobject.searchbankresults.get(i).getText());

			}
			
			enterData(paymentoptionspageobject.banksearch,"abc");
			test.log(Status.INFO,"Entered invalid bank search input ");
			Assert.assertEquals(true, paymentoptionspageobject.errormessagebank.isDisplayed());
			test.log(Status.PASS,"error message: "+paymentoptionspageobject.errormessagebank.getText());
			
			click(paymentoptionspageobject.Wallet);
			click(paymentoptionspageobject.Netbanking);
			click(paymentoptionspageobject.allbanks.get(0));
			test.log(Status.INFO,"select on first bank and redirected to selected bank page:- "+paymentoptionspageobject.allbanks.get(0).getText());
			switchToChildWindow();
			Thread.sleep(8000);
			String bankurl=driver.getCurrentUrl();
			test.log(Status.PASS, "Bank URL: " + bankurl.substring(0, Math.min(30, bankurl.length())));

			driver.close();
			
			switchToParentWindow(parent);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong : "+e.getMessage());
			screenshot("case2-43");
		}
	}
	@Test
	public void case3()
	{
		try
		{//436,437
			
			paymentpagedisplay();
			
			test=extent.createTest("Verify Payment Options Page Functionality - Wallet payment options");
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
			
			Assert.assertEquals(true, paymentoptionspageobject.Wallet.isDisplayed());
			test.log(Status.PASS,"\"Wallet\" payment option is displayed.");
			click(paymentoptionspageobject.Wallet);
			test.log(Status.INFO,"Navigate to \"Wallet\"  Option tab");
			Thread.sleep(3000);
			
			test.log(Status.INFO,"********** all wallet options *********");
			for(int i=0;i<paymentoptionspageobject.allwalletoptions.size();i++)
			{
				hover(paymentoptionspageobject.allwalletoptions.get(i));
				test.log(Status.INFO,+(i+1)+" :"+paymentoptionspageobject.allwalletoptions.get(i).getText());

			}
			
			click(paymentoptionspageobject.allwalletoptions.get(0));
			test.log(Status.INFO,"select on first wallet and redirected to selected wallet page:- "+paymentoptionspageobject.allwalletoptions.get(0).getText());
			switchToChildWindow();
			Thread.sleep(8000);
			String walleturl=driver.getCurrentUrl();
			test.log(Status.PASS, "wallet URL: " + walleturl.substring(0, Math.min(30, walleturl.length())));

			driver.close();
			
			switchToParentWindow(parent);
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong : "+e.getMessage());
			screenshot("case3-43");
		}
	}
//	@Test
	public void case4()
	{
		try
		{//438,439
			
			paymentpagedisplay();
			
			test=extent.createTest("Verify Payment Options Page Functionality - PayLater payment options");
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
			
			Assert.assertEquals(true, paymentoptionspageobject.PayLater.isDisplayed());
			test.log(Status.PASS,"\"PayLater\" payment option is displayed.");
			click(paymentoptionspageobject.PayLater);
			test.log(Status.INFO,"Navigate to \"PayLater\"  Option tab");
			Thread.sleep(3000);
			
			test.log(Status.INFO,"********** all PayLater options *********");
			for(int i=0;i<paymentoptionspageobject.allpaylateroptions.size();i++)
			{
				hover(paymentoptionspageobject.allpaylateroptions.get(i));
				test.log(Status.INFO,+(i+1)+" :"+paymentoptionspageobject.allpaylateroptions.get(i).getText());

			}
			
			click(paymentoptionspageobject.allpaylateroptions.get(0));
			test.log(Status.INFO,"select on first paylater option and display otp fields:  "+paymentoptionspageobject.allpaylateroptions.get(0).getText());
			Thread.sleep(3000);
			screenshot("otpfielddisplay");
			

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong : "+e.getMessage());
			screenshot("case4-43");
		}
	}
}
