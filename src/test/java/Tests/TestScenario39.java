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

public class TestScenario39 extends BaseClass
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
		{//400-403
			paymentpagedisplay();
			
			test=extent.createTest("Verify Payment Options Page Functionality -bank offers");
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
			
			click(paymentoptionspageobject.bankofferslink);
			test.log(Status.INFO,"Navigate to bank offers  popup");	
			wait.until(ExpectedConditions.visibilityOfAllElements(paymentoptionspageobject.bankoffers));
			
			for(int i=0;i<paymentoptionspageobject.bankoffers.size();i++)
			{
				hover(paymentoptionspageobject.bankoffers.get(i));
				test.log(Status.PASS,"bank offer is displayed");
			}
			click(paymentoptionspageobject.bankclose);
			test.log(Status.INFO," bank offers  popup is closed");	
			
			double beforefinalprice = Double.parseDouble(paymentoptionspageobject.finalprice.getAttribute("data-value").replace("₹", "").replace(",", "").trim());
			test.log(Status.INFO,"final price before applying anything:-  "+beforefinalprice);
			
			click(paymentoptionspageobject.bankofferslink);
			test.log(Status.INFO,"Navigate to bank offers  popup");	
			//wait.until(ExpectedConditions.visibilityOfAllElements(paymentoptionspageobject.bankoffers));
			
			
			Thread.sleep(3000);
			hover(paymentoptionspageobject.bankoffers.get(1));
			double discountpice = Double.parseDouble(paymentoptionspageobject.bankoffersamount.get(1).getText().replaceAll("[a-zA-Z]", "").replace("₹", "").replace(",", "").trim());
			test.log(Status.PASS,"applied bank offers didcount amount:- "+discountpice);
			click(paymentoptionspageobject.bankapplybutton.get(1));
			test.log(Status.INFO,"applying a first bank offer apply button");
			
			Thread.sleep(5000);
			click(paymentoptionspageobject.bankofferslink);
			hover(paymentoptionspageobject.bankoffers.get(1));
			click(paymentoptionspageobject.bankapplybutton.get(1));
			Thread.sleep(5000);
			double afterfinalprice = Double.parseDouble(paymentoptionspageobject.finalprice.getAttribute("data-value").replace("₹", "").replace(",", "").trim());
			test.log(Status.INFO,"final price after applying bank offer:-  "+afterfinalprice);
			double afteractualprice = Double.parseDouble(paymentoptionspageobject.actualprice.getText().replace("₹", "").replace(",", "").trim());
			test.log(Status.INFO,"actual price after applying bank offer:-  "+afteractualprice);

			
			Assert.assertEquals(beforefinalprice, afteractualprice);
			test.log(Status.PASS,"actual price is matched even after applying the bank offer: "+beforefinalprice +" = "+afteractualprice);
			Assert.assertEquals((afteractualprice)-(afterfinalprice), discountpice);
			test.log(Status.PASS,"discount amount is verified:  "+discountpice+" = "+afteractualprice+" - "+afterfinalprice);
			
			click(paymentoptionspageobject.bankofferslink);
			test.log(Status.INFO,"Navigate to bank offers  popup");	
			Assert.assertEquals(true, paymentoptionspageobject.bankremovebutton.isDisplayed());
			test.log(Status.PASS,"remove button is displayed for appyed bank offer tag");
			
			click(paymentoptionspageobject.bankremovebutton);
			test.log(Status.INFO,"removing applyed bank offers in popup");	
			Thread.sleep(3000);
			double removefinalprice = Double.parseDouble(paymentoptionspageobject.finalprice.getAttribute("data-value").replace("₹", "").replace(",", "").trim());

			
			Assert.assertEquals(beforefinalprice, removefinalprice);
			test.log(Status.PASS,"before applying bank offer price and after removing bankoffer price is matched: "+beforefinalprice+" = "+removefinalprice);
		
			click(paymentoptionspageobject.closepopup);
			click(paymentoptionspageobject.YesExit);
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong"+e.getMessage());
			screenshot("case1-39");
		}
		
	}
	//@Test
	public void case2()
	{
		try
		{
			paymentpagedisplay();
			test=extent.createTest("Verify Payment Options Page Functionality - bank offers2");
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
			
			
			
			click(paymentoptionspageobject.bankofferslink);
			test.log(Status.INFO,"Navigate to bank offers  popup");	
			
			for(int i=0;i<paymentoptionspageobject.bankapplybutton.size();i++)
			{
				hover(paymentoptionspageobject.bankapplybutton.get(i));
				Thread.sleep(2000);
				click(paymentoptionspageobject.bankapplybutton.get(i));
				Thread.sleep(2000);
				click(paymentoptionspageobject.bankofferslink);
				Thread.sleep(2000);
				try {
				hover(paymentoptionspageobject.bankremovebutton);
				Thread.sleep(2000);
				Assert.assertEquals(true, paymentoptionspageobject.bankremovebutton.isDisplayed());
				test.log(Status.PASS,"at a time we can apply only one offer"+i);
				Thread.sleep(3000);
				}catch(Exception e)
				{}
				Thread.sleep(2000);
			}
			
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong"+e.getMessage());
			screenshot("case2-39");
		}
	}
	

}
