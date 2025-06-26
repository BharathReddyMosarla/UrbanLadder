package Tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.AddressPage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.PaymentPage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import Pages.SignUpPage;
import utilities.BaseClass;

public class TestScenario37 extends BaseClass
{
	public void search(String product) 
	{
		try {
		test=extent.createTest("search a product");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
		ProductDetailsPage productdetailsspageobject=PageFactory.initElements(driver, ProductDetailsPage.class);
		SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		enterData(homepageobject.SearchBar,product);
		click(homepageobject.SearchIconButton);
		test.log(Status.INFO,"Display searched Products");
		
		click(productspageobject.ProductImages.get(0));
		test.log(Status.INFO,"selectd first product");
		//Thread.sleep(1000);
		switchToChildWindow();
		test.log(Status.INFO,"Navigated to new  window");
		click(productdetailsspageobject.AddToCartButton);
		hover(cartpageobject.CheckoutButton);
		driver.close();
		switchToParentWindow(parent);
		
		//hover(homepageobject.Logo);
		try 
		{
		hover(signuppageobject.close);
		click(signuppageobject.close);}catch(Exception e) {}
		hover(homepageobject.Logo);
		click(homepageobject.Logo);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL,e.getMessage());
			screenshot("search a product");
		}
	}

	public void dataSA()
	{
		AddressPage addresspageobject=PageFactory.initElements(driver, AddressPage.class);
		String 	SAEmail ="abc@gmail.com",
				SAPincode = "500037",
				SAAddress = "manchester, london",
				SAFirstName ="john",
				SALastName = "paul",
				SAMobileNumber ="9784678938";
		
		enterData(addresspageobject.SAEmail,SAEmail);
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
		search("chair");
		
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
			click(addresspageobject.SaveContinueButton);
			test.log(Status.INFO,"Navigate to Payment Page");
			wait.until(ExpectedConditions.visibilityOf(paymentpageobject.PlaceOrderButton));
			Assert.assertEquals("https://www.urbanladder.com/checkout/payment", driver.getCurrentUrl());
			test.log(Status.PASS,"Payment Page is Displayed");
						
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("paymentpagedisplay");
		}
	}
	
	@Test
	public void case1()
	{
		try 
		{//383-389
			paymentpagedisplay();
			
			test=extent.createTest("Verify Gift Card Functionality");
			test.log(Status.INFO,"Payment page is Displayed");
			PaymentPage paymentpageobject=PageFactory.initElements(driver, PaymentPage.class);
			
			Assert.assertEquals("Redeem Gift Card", paymentpageobject.RedeemGiftCard.getText());
			test.log(Status.PASS,"redeem gift card section is Displayed in a page");
			
			click(paymentpageobject.RedeemGiftCard);
			test.log(Status.INFO,"expands the redeem giftcard section");
			Assert.assertEquals(true, paymentpageobject.GiftCardCode.isDisplayed());
			test.log(Status.PASS,"giftcard, pin fields are displayed under redeem gift card section");
			
			hover(paymentpageobject.RedeemGiftCardButton);
			test.log(Status.PASS,"redeem gift card button is highlighted");
			
			click(paymentpageobject.RedeemGiftCard);
			test.log(Status.INFO,"close the redeem giftcard section");
			Assert.assertEquals(false, paymentpageobject.GiftCardCode.isSelected());
			test.log(Status.PASS,"close the redeem giftcard section");
			
			click(paymentpageobject.RedeemGiftCard);
			test.log(Status.INFO,"expands the redeem giftcard section");
		
//			enterData(paymentpageobject.GiftCardCode,"SDFG2HG2G4H2");
//			test.log(Status.INFO,"entered valid giftcard number");
//			enterData(paymentpageobject.Pin,"345");
//			test.log(Status.INFO,"entered valid pin number");
//			click(paymentpageobject.RedeemGiftCardButton);
//			test.log(Status.INFO," validating enterd valid data");
			
			enterData(paymentpageobject.GiftCardCode,"SDFG2HG2G4H2");
			test.log(Status.INFO,"entered invalid giftcard number");
			enterData(paymentpageobject.Pin,"345");
			test.log(Status.INFO,"entered invalid pin number");
			click(paymentpageobject.RedeemGiftCardButton);
			test.log(Status.INFO," validating enterd invalid data");
			wait.until(ExpectedConditions.visibilityOf(paymentpageobject.GiftCardCodeError));
			Assert.assertEquals("Does not look like a valid Gift Card/Pin combination.", paymentpageobject.GiftCardCodeError.getText());
			test.log(Status.PASS,"Error message is displayed for invalid data");
			
			
			click(paymentpageobject.RedeemGiftCardButton);
			test.log(Status.INFO," validating empty data");
			wait.until(ExpectedConditions.visibilityOf(paymentpageobject.GiftCardCodeError));
			Assert.assertEquals("Please enter your Gift Card code and pin", paymentpageobject.GiftCardCodeError.getText());
			test.log(Status.PASS,"Error message is displayed for empty data");
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong"+e.getMessage());
			screenshot("case1-37");
		}
		
		
	}
	
	

}
