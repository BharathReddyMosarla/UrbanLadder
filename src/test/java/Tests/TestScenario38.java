package Tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.AddressPage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.PaymentOptionsPage;
import Pages.PaymentPage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import Pages.SignUpPage;
import utilities.BaseClass;

public class TestScenario38 extends BaseClass
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
	
	//@Test
	public void case1()
	{
		try 
		{//390-398
			paymentpagedisplay();
			
			test=extent.createTest("Verify Payment Options Page Functionality");
			test.log(Status.INFO,"Payment page is Displayed");
			
			PaymentPage paymentpageobject=PageFactory.initElements(driver, PaymentPage.class);
			PaymentOptionsPage paymentoptionspageobject=PageFactory.initElements(driver, PaymentOptionsPage.class);
			
			wait.until(ExpectedConditions.visibilityOf(paymentpageobject.TotalPayableAmountPayment));
			String totalpayableamounttext=paymentpageobject.TotalPayableAmountPayment.getText();
			int totalpayableamount = Integer.parseInt(totalpayableamounttext.replaceAll("[₹,]", ""));
			test.log(Status.INFO,"total payable amount  note down  - payment page: "+totalpayableamount);
			
			String Email = paymentpageobject.EmailPayment.getText();
			String phone = paymentpageobject.MobileNumberPayment.getText();
			
			click(paymentpageobject.PlaceOrderButton);
			test.log(Status.INFO,"Navigate to Payment  Options");
			
			switchToFrameByWebElement(paymentoptionspageobject.POFrame);
			wait.until(ExpectedConditions.visibilityOf(paymentoptionspageobject.UrbanLadderText));
			
			String totalpayableamounttext1=paymentoptionspageobject.PriceSummary.getAttribute("data-value");
			int totalpayableamount1 = Integer.parseInt(totalpayableamounttext1.replaceAll("[₹,]", ""));
			test.log(Status.INFO,"total payable amount  note down  - payment options page: "+totalpayableamount1);
			
			
			Assert.assertEquals(totalpayableamount, totalpayableamount1);
			test.log(Status.PASS,"total payable amount in a payment options page is match with total payable amount in a payment page : "+totalpayableamount+" = "+totalpayableamount1);
			
			click(paymentoptionspageobject.editphoneemail);
			wait.until(ExpectedConditions.visibilityOf(paymentoptionspageobject.Email));
			
			Assert.assertEquals(Email, paymentoptionspageobject.Email.getAttribute("value"));
			test.log(Status.PASS,"Email address is same : "+Email);
			Assert.assertEquals(phone, paymentoptionspageobject.MobileNumber.getAttribute("value"));
			test.log(Status.PASS,"Phone number is same : "+phone);
			
			click(paymentoptionspageobject.ContinueButton);
			
			click(paymentoptionspageobject.Recommanded);
			screenshot("recommanded payment method");
			Assert.assertEquals("Recommended", paymentoptionspageobject.Recommanded.getText());
			test.log(Status.PASS,"recommanded option is visible and suggest payment method");
			
			test.log(Status.INFO,"No of Payment methods in a paymentoption popup : "+paymentoptionspageobject.Options.size());
			for(int i=0;i<paymentoptionspageobject.Options.size();i++)
			{
				Assert.assertEquals(true, paymentoptionspageobject.Options.get(i).isDisplayed());
				test.log(Status.PASS,"Payment method is displayed : "+paymentoptionspageobject.Options.get(i).getText());
			}
			
			click(paymentoptionspageobject.MoreOptionsButton);
			test.log(Status.INFO,"scroll up operation");
			Assert.assertEquals(true, paymentoptionspageobject.BacktoTopButton.isDisplayed());
			test.log(Status.PASS,"scrool to last payment method");
			click(paymentoptionspageobject.BacktoTopButton);
			test.log(Status.INFO,"scroll down operation");
			Assert.assertEquals(true, paymentoptionspageobject.MoreOptionsButton.isDisplayed());
			test.log(Status.PASS,"scrool to first payment method");
			
			click(paymentoptionspageobject.closepopup);
			test.log(Status.INFO,"closing the payment option popup");
			Assert.assertEquals(true, paymentoptionspageobject.ContinuePayment.isDisplayed());
			test.log(Status.PASS,"display confirmation pop up is displayed");
			click(paymentoptionspageobject.ContinuePayment);
			test.log(Status.INFO,"cancel the closing payment option popup");
			Assert.assertEquals(true, paymentoptionspageobject.UrbanLadderText.isDisplayed());
			test.log(Status.PASS,"payment options page displayed");
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong"+e.getMessage());
			screenshot("case1-38");
		}
		
		
	}
	@Test
	public void case2()
	{
		try 
		{//399
			paymentpagedisplay();
			
			test=extent.createTest("Verify Payment Options Page Functionality -2");
			test.log(Status.INFO,"Payment page is Displayed");
			
			PaymentPage paymentpageobject=PageFactory.initElements(driver, PaymentPage.class);
			PaymentOptionsPage paymentoptionspageobject=PageFactory.initElements(driver, PaymentOptionsPage.class);
			
			wait.until(ExpectedConditions.visibilityOf(paymentpageobject.TotalPayableAmountPayment));
			
			click(paymentpageobject.PlaceOrderButton);
			test.log(Status.INFO,"Navigate to Payment  Options");
	//		
			switchToFrameByWebElement(paymentoptionspageobject.POFrame);
			wait.until(ExpectedConditions.visibilityOf(paymentoptionspageobject.UrbanLadderText));
	
			click(paymentoptionspageobject.closepopup);
			test.log(Status.INFO,"closing the payment option popup");
			Assert.assertEquals(true, paymentoptionspageobject.YesExit.isDisplayed());
			test.log(Status.PASS,"display confirmation pop up is displayed");
			PageFactory.initElements(driver, paymentoptionspageobject);
			click(paymentoptionspageobject.YesExit);
			test.log(Status.INFO,"confirm the closing payment option popup");
			Thread.sleep(9000);
		//--
			switchToParentFrame();
			wait.until(ExpectedConditions.visibilityOf(paymentpageobject.PlaceOrderButton));
			Assert.assertEquals(true, paymentpageobject.PlaceOrderButton.isDisplayed());
			
			test.log(Status.PASS,"payment  page displayed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong"+e.getMessage());
			screenshot("case2-38");
		}


}

	

}
