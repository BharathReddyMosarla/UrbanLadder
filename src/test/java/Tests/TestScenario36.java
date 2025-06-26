package Tests;

import java.util.Arrays;

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

public class TestScenario36 extends BaseClass
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
				
		
	@Test
	public void case1()
	{
		search("chair");
		
		try 
		{//366
			test=extent.createTest("Verify the \"Cart\" link redirects to the cart page.");
			test.log(Status.INFO,"Payment page is Displayed");
			
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
			
			click(cartpageobject.CartLink);
			Assert.assertEquals("https://www.urbanladder.com/cart", driver.getCurrentUrl());
			test.log(Status.PASS,"Cart Page is Displayed");
				
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case1-36");
		}
	
	}
	//@Test
	public void case2()
	{
		search("chair");
		
		try 
		{//367
			test=extent.createTest("Verify the \"Address\" link redirects to the address page.");
			test.log(Status.INFO,"Payment page is Displayed");
			
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
			
			click(cartpageobject.AddressLink);
			Assert.assertEquals("https://www.urbanladder.com/checkout/address", driver.getCurrentUrl());
			test.log(Status.PASS,"Address Page is Displayed");
				
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case2-36");
		}
	
	}
	//@Test
	public void case3()
	{
		search("chair");
		
		try 
		{//368 - 369
			test=extent.createTest("Verify the \"Payment\" link redirects to the same page (payment page).<br>"
					+ "Verify all order summary details are displayed correctly on the payment page.");
			test.log(Status.INFO,"Payment page is Displayed");
			
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
			
			click(cartpageobject.PaymentLink);
			Assert.assertEquals("https://www.urbanladder.com/checkout/payment", driver.getCurrentUrl());
			test.log(Status.PASS,"Payment Page is Displayed");
			
			for(int i=0;i<paymentpageobject.QuantityPayment.size();i++)
			{
				Assert.assertEquals(true, paymentpageobject.ProductTitlesPayment.get(i+1).isDisplayed());
				Assert.assertEquals(true, paymentpageobject.QuantityPayment.get(i).isDisplayed());
				test.log(Status.PASS,"product names and quantity is displayed");
			}
			
				
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case3-36");
		}
	
	}
	//@Test
	public void case4()
	{
		search("chair");
		search("table");
		
		try 
		{//370-382
			test=extent.createTest("Verify quantity,productanames, ordertotal, discount amount, delivery charges, total payable amont, emailid, mobilenumber <br>"
					+ "compare with cart page and payment page, comapre with address page and payment page <br>"
					+ "verify default payment method and ");
			test.log(Status.INFO,"Payment page is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
			AddressPage addresspageobject=PageFactory.initElements(driver, AddressPage.class);
			PaymentPage paymentpageobject=PageFactory.initElements(driver, PaymentPage.class);
			PaymentOptionsPage paymentoptionspageobject=PageFactory.initElements(driver, PaymentOptionsPage.class);
			
			parent = driver.getWindowHandle();
			
			hover(homepageobject.CartIcon);
			click(homepageobject.CartIcon);
			test.log(Status.INFO,"Navigate to Cart Page");
			
			String quantitycart[]=new String[cartpageobject.ProductImagesCart.size()];
			String productnamecart[]=new String[cartpageobject.ProductImagesCart.size()];
			for(int i=0;i<cartpageobject.ProductImagesCart.size();i++)
			{
				 quantitycart[i]=cartpageobject.QuantityCart.get(i).getAttribute("value");
				test.log(Status.INFO,"add quantity of a product to quantity array -  cart page: "+Arrays.toString(quantitycart));
				 productnamecart[i]=cartpageobject.ProductTitlesCart.get(i).getText();
				test.log(Status.INFO,"add product names  to product name array -  cart page: "+Arrays.toString(productnamecart));
			}
			String carttotaltext=cartpageobject.CartTotalCart.getText();
			int carttotal = Integer.parseInt(carttotaltext.replaceAll("[₹,]", ""));
			test.log(Status.INFO,"cart total amount  note down - cart page: "+carttotal);
			
			String discounttext=cartpageobject.DiscountsCart.getText();
			int discount = Integer.parseInt(discounttext.replaceAll("[₹,-]", ""));
			test.log(Status.INFO,"discount amount  note down - cart page: "+discount);
			
			String deliverychargestext=cartpageobject.DeliveryChargesCart.getText();
			int deliverycharges = Integer.parseInt(deliverychargestext.replaceAll("[₹,-]", ""));
			test.log(Status.INFO,"delivery charges amount  note down - cart page: "+deliverycharges);
			
			String totalpayableamounttext=cartpageobject.TotalPayableAmountCart.getText();
			int totalpayableamount = Integer.parseInt(totalpayableamounttext.replaceAll("[₹,]", ""));
			test.log(Status.INFO,"total payable amount  note down - cart page: "+totalpayableamount);

			String Pincode = cartpageobject.Pincode.getText();
			
			hover(cartpageobject.CheckoutButton);
			click(cartpageobject.CheckoutButton);
			test.log(Status.INFO,"Navigate to Address Page");
			test.log(Status.INFO,"pincode from cart page: "+Pincode);
			
			
			String 	SAEmail ="abc@gmail.com",
					SAPincode = Pincode,
					SAAddress = "manchester, london",
					SAFirstName ="john",
					SALastName = "paul",
					SAMobileNumber ="9784678938";
			
			
			wait.until(ExpectedConditions.visibilityOf(addresspageobject.CartTotalAddress));
			
			String quantityaddress[]=new String[addresspageobject.QuantityAddress.size()];
			String productnameaddress[]=new String[addresspageobject.QuantityAddress.size()];
			for(int i=0;i<addresspageobject.QuantityAddress.size();i++)
			{	
				quantityaddress[i]=addresspageobject.QuantityAddress.get(i).getText();
				test.log(Status.INFO,"add quantity of a product to quantity array -  Address page: "+Arrays.toString(quantityaddress));
				productnameaddress[i]=addresspageobject.ProductTitlesAddress.get(i+1).getText();
				test.log(Status.INFO,"add product names  to product name array -  Address page: "+Arrays.toString(productnameaddress));
			}
			
			String carttotaltext1=addresspageobject.CartTotalAddress.getText();
			int carttotal1 = Integer.parseInt(carttotaltext1.replaceAll("[₹,]", ""));
			test.log(Status.INFO,"cart total amount  note down - Address page: "+carttotal1);
			
			String discounttext1=addresspageobject.DiscountsAddress.getText();
			int discount1 = Integer.parseInt(discounttext1.replaceAll("[₹,-]", "").replace(".0", ""));
			test.log(Status.INFO,"discount amount  note down  - Address page: "+discount1);
			
			String deliverychargestext1=addresspageobject.DeliveryChargesAddress.getText();
			int deliverycharges1 = Integer.parseInt(deliverychargestext1.replaceAll("[₹,-]", ""));
			test.log(Status.INFO,"delivery charges amount  note down  - Address page: "+deliverycharges1);
			
			String totalpayableamounttext1=addresspageobject.TotalPayableAmountAddress.getText();
			int totalpayableamount1 = Integer.parseInt(totalpayableamounttext1.replaceAll("[₹,]", ""));
			test.log(Status.INFO,"total payable amount  note down  - Address page: "+totalpayableamount1);

			enterData(addresspageobject.SAEmail,SAEmail);
			test.log(Status.INFO," enterd  valid email : "+SAEmail);
			enterData(addresspageobject.SAPincode,SAPincode);
			test.log(Status.INFO," enterd  valid pincode : "+SAPincode);
			enterData(addresspageobject.SAAddress,SAAddress);
			test.log(Status.INFO," enterd  valid address : "+SAAddress);
			enterData(addresspageobject.SAFirstName,SAFirstName);
			test.log(Status.INFO," enterd  valid firstname : "+SAFirstName);
			enterData(addresspageobject.SALastName,SALastName);
			test.log(Status.INFO," enterd  valid lastname : "+SALastName);
			enterData(addresspageobject.SAMobileNumber,SAMobileNumber);
			test.log(Status.INFO," enterd  valid phonenumber : "+SAMobileNumber);
			test.log(Status.INFO,"validating enterd  valid data");
			
			wait.until(ExpectedConditions.elementToBeClickable(addresspageobject.SaveContinueButton));
			click(addresspageobject.SaveContinueButton);
			test.log(Status.INFO,"Navigate to Payment Page");
			wait.until(ExpectedConditions.visibilityOf(paymentpageobject.PlaceOrderButton));
			Assert.assertEquals("https://www.urbanladder.com/checkout/payment", driver.getCurrentUrl());
			test.log(Status.PASS,"Payment Page is Displayed");
	
			String quantitypayment[]=new String[paymentpageobject.QuantityPayment.size()];
			String productnamepayment[]=new String[paymentpageobject.QuantityPayment.size()];
			for(int i=0;i<paymentpageobject.QuantityPayment.size();i++)
			{	
				quantitypayment[i]=paymentpageobject.QuantityPayment.get(i).getText();
				test.log(Status.INFO,"add quantity of a product to quantity array -  payment page: "+Arrays.toString(quantitypayment));
				productnamepayment[i]=paymentpageobject.ProductTitlesPayment.get(i+1).getText();
				test.log(Status.INFO,"add product names  to product name array -  payment page: "+Arrays.toString(productnamepayment));
			}
			
			String carttotaltext2=paymentpageobject.CartTotalPayment.getText();
			int carttotal2 = Integer.parseInt(carttotaltext2.replaceAll("[₹,]", ""));
			test.log(Status.INFO,"cart total amount  note down - payment page: "+carttotal2);
			
			String discounttext2=paymentpageobject.DiscountsPayment.getText();
			int discount2 = Integer.parseInt(discounttext2.replaceAll("[₹,-]", "").replace(".0", ""));
			test.log(Status.INFO,"discount amount  note down  - payment page: "+discount2);
			
			String deliverychargestext2=paymentpageobject.DeliveryChargesPayment.getText();
			int deliverycharges2 = Integer.parseInt(deliverychargestext2.replaceAll("[₹,-]", ""));
			test.log(Status.INFO,"delivery charges amount  note down  - payment page: "+deliverycharges2);
			
			String totalpayableamounttext2=paymentpageobject.TotalPayableAmountPayment.getText();
			int totalpayableamount2 = Integer.parseInt(totalpayableamounttext2.replaceAll("[₹,]", ""));
			test.log(Status.INFO,"total payable amount  note down  - payment page: "+totalpayableamount2);

			Assert.assertEquals(true, Arrays.equals(quantitypayment, quantityaddress));
			test.log(Status.PASS,"quantity of a products in a payment page is match with quantity of a products in address page: "+Arrays.toString(quantitypayment)+" = "+Arrays.toString(quantityaddress));
			Assert.assertEquals(true, Arrays.equals(quantitypayment, quantitycart));
			test.log(Status.PASS,"quantity of a products in a payment page is match with quantity of a products in cart page: "+Arrays.toString(quantitypayment)+" = "+Arrays.toString(quantitycart));
			Assert.assertEquals(true, Arrays.equals(productnamepayment, productnameaddress));
			test.log(Status.PASS," product names in a payment page is match with product names in address page: "+Arrays.toString(productnamepayment)+" = "+Arrays.toString(productnameaddress));
			Assert.assertEquals(true, Arrays.equals(productnamepayment, productnamecart));
			test.log(Status.PASS," product names in a payment page is match with product names in cart page: "+Arrays.toString(productnamepayment)+" = "+Arrays.toString(productnamecart));
			
			Assert.assertEquals(carttotal2, carttotal);
			test.log(Status.PASS,"cart total in a payment page is match with cart total in a cart page :  "+carttotal2+" = "+carttotal);
			Assert.assertEquals(carttotal2, carttotal1);
			test.log(Status.PASS,"cart total in a payment page is match with cart total in a address page :  "+carttotal2+" = "+carttotal1);

			Assert.assertEquals(discount2, discount);
			test.log(Status.PASS,"discount amount in a payment page is match with discount amount in a cart page :  "+discount2+" = "+discount);
			Assert.assertEquals(discount2, discount1);
			test.log(Status.PASS,"discount amount in a payment page is match with discount amount in a address page :  "+discount2+" = "+discount1);

			Assert.assertEquals(deliverycharges2, deliverycharges);
			test.log(Status.PASS,"delivery charges in a payment page is match with delivery charges in a cart page :  "+deliverycharges2+" = "+deliverycharges);
			Assert.assertEquals(deliverycharges2, deliverycharges1);
			test.log(Status.PASS,"delivery charges in a payment page is match with delivery charges in a address page :  "+deliverycharges2+" = "+deliverycharges);

			Assert.assertEquals(totalpayableamount2, totalpayableamount);
			test.log(Status.PASS,"total payable amount in a payment page is match with total payable amount in a cart page :  "+totalpayableamount2+" = "+totalpayableamount);
			Assert.assertEquals(totalpayableamount2, totalpayableamount1);
			test.log(Status.PASS,"total payable amount in a payment page is match with total payable amount in a address page :  "+totalpayableamount2+" = "+totalpayableamount1);

			Assert.assertEquals(true, paymentpageobject.EmailPayment.isDisplayed());
			test.log(Status.PASS,"email id is displayed in a payment page");
			Assert.assertEquals(true, paymentpageobject.MobileNumberPayment.isDisplayed());
			test.log(Status.PASS,"mobile number is displayed in a payment page");
			
			Assert.assertEquals(SAEmail, paymentpageobject.EmailPayment.getText());
			test.log(Status.PASS,"email address in a payment page is match with email address in address page :  "+paymentpageobject.EmailPayment.getText()+" = "+SAEmail);
			Assert.assertEquals(SAMobileNumber, paymentpageobject.MobileNumberPayment.getText());
			test.log(Status.PASS,"mobile number in a payment page is match with mobile number in address page :  "+paymentpageobject.MobileNumberPayment.getText()+" = "+SAMobileNumber);

			
			Assert.assertEquals(true, paymentpageobject.PaymentMethodradiobutton.isSelected());
			test.log(Status.PASS,"default payment method is selected : "+paymentpageobject.PaymentMethodText.getText());
			
		//	wait.until(ExpectedConditions.elementToBeClickable(paymentpageobject.PlaceOrderButton));
			click(paymentpageobject.PlaceOrderButton);
			test.log(Status.INFO," display payment options popup");
			
			switchToFrameByWebElement(paymentoptionspageobject.POFrame);
			wait.until(ExpectedConditions.visibilityOf(paymentoptionspageobject.PaymentsOptionText));
			Assert.assertEquals("Payment Options", paymentoptionspageobject.PaymentsOptionText.getText());
			test.log(Status.PASS,"payment options popup is displayed");
			}
			catch(Exception e)
			{
				test.log(Status.FAIL,e.getMessage());
				screenshot("case3-36");
			}
		
		}

	

}
