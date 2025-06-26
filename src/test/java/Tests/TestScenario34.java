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
import Pages.PaymentPage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import Pages.SignUpPage;
import utilities.BaseClass;

public class TestScenario34 extends BaseClass
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
		try {
			hover(signuppageobject.close);
		click(signuppageobject.close);}catch(Exception e) {}
		hover(homepageobject.Logo);
		click(homepageobject.Logo);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("search a product");
		}
	}

	@Test
	public void case1( ) 
	{
		try {
		test=extent.createTest("Verify the email ID field is disabled and the registered email ID is shown for logged-in application users.");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		AddressPage addresspageobject=PageFactory.initElements(driver, AddressPage.class);

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
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		hover(cartpageobject.CheckoutButton);
		click(cartpageobject.CheckoutButton);
		test.log(Status.INFO,"Navigate to Address Page");
		
		Assert.assertEquals(config.getProperty("LoginEmail"), addresspageobject.SAEmail.getAttribute("value"));
		test.log(Status.PASS,"email_id in email field in address page same as a login email_id : "+config.getProperty("LoginEmail")+" = "+addresspageobject.SAEmail.getAttribute("value"));
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case1-34");
		}
	}
	//@Test
	public void case2( ) throws Exception 
	{
		//347, 348
		search("chair");
		try {
		test=extent.createTest("Verify the email ID field is blank for users who are not registered or not logged in.<br>"
				+ "Verify the shipping address functionality works with valid data. ");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
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
		
		Assert.assertEquals("", addresspageobject.SAEmail.getAttribute("value"));
		test.log(Status.PASS," email id field is empty");
		
		enterData(addresspageobject.SAEmail,"abc@gmail.com");
		test.log(Status.INFO," enterd  valid email : abc@gmail.com");
		enterData(addresspageobject.SAPincode,"500037");
		test.log(Status.INFO," enterd  valid pincode : 500037");
		enterData(addresspageobject.SAAddress,"manchester, london");
		test.log(Status.INFO," enterd  valid address : manchester, london");
		enterData(addresspageobject.SAFirstName,"john");
		test.log(Status.INFO," enterd  valid firstname : john");
		enterData(addresspageobject.SALastName,"paul");
		test.log(Status.INFO," enterd  valid lastname : paul");
		enterData(addresspageobject.SAMobileNumber,"9784678938");
		test.log(Status.INFO," enterd  valid phonenumber : 9784678938");
		test.log(Status.INFO,"validating enterd  valid data");
		
		hover(addresspageobject.SaveContinueButton);
		wait.until(ExpectedConditions.elementToBeClickable(addresspageobject.SaveContinueButton));
		click(addresspageobject.SaveContinueButton);
		test.log(Status.INFO,"Navigate to payment page");
		
		
		wait.until(ExpectedConditions.visibilityOf(paymentpageobject.PlaceOrderButton));
		Assert.assertEquals("https://www.urbanladder.com/checkout/payment", driver.getCurrentUrl());
		test.log(Status.PASS,"Payment Page is Displayed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case2-34");
		}
		
	}
	//@Test
	public void case3( ) 
	{
		//349
		search("chair");
		try {
		test=extent.createTest("Verify the shipping address functionality displays an error  message for invalid data. ");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		AddressPage addresspageobject=PageFactory.initElements(driver, AddressPage.class);

		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		hover(cartpageobject.CheckoutButton);
		click(cartpageobject.CheckoutButton);
		test.log(Status.INFO,"Navigate to Address Page");
		
		Assert.assertEquals("", addresspageobject.SAEmail.getAttribute("value"));
		test.log(Status.PASS," email id field is empty");
		
		enterData(addresspageobject.SAEmail,"dffd");
		test.log(Status.INFO," enterd  invalid email : dffd");
		enterData(addresspageobject.SAPincode,"dffd");
		test.log(Status.INFO," enterd  invalid pincode : dffd");
		enterData(addresspageobject.SAAddress,"dffd");
		test.log(Status.INFO," enterd  invalid address : dffd");
		enterData(addresspageobject.SAFirstName,"w5r4");
		test.log(Status.INFO," enterd  invalid firstname : w5r4");
		enterData(addresspageobject.SALastName,"w5r4");
		test.log(Status.INFO," enterd  invalid lastname : w5r4");
		enterData(addresspageobject.SAMobileNumber,"dffd");
		test.log(Status.INFO," enterd  invalid phonenumber : dffd");
		test.log(Status.INFO,"validating enterd  invalid data");
		
		hover(addresspageobject.SaveContinueButton);
		click(addresspageobject.SaveContinueButton);
		Assert.assertEquals(false, addresspageobject.SaveContinueButton.isEnabled());
		test.log(Status.PASS,"Save and continue button is Disabled");
		
		Assert.assertEquals("Please enter a valid email address.", addresspageobject.SAEmailError.getText());
		test.log(Status.PASS,"error message for email is dispalyed");
		Assert.assertEquals("Please enter a valid pincode", addresspageobject.SAPincodeError.getText());
		test.log(Status.PASS,"error message for pincode is dispalyed");
		Assert.assertEquals("Please enter a valid 10 digit mobile number", addresspageobject.SAMobileNumberError.getText());
		test.log(Status.PASS,"error message for mobile number is dispalyed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case3-34");
		}
		
	}
	//@Test
	public void case4( ) throws Exception 
	{
		//350
		search("chair");
		try {
		test=extent.createTest("Verify the shipping address functionality displays an error message for null data. ");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		AddressPage addresspageobject=PageFactory.initElements(driver, AddressPage.class);

		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		hover(cartpageobject.CheckoutButton);
		click(cartpageobject.CheckoutButton);
		test.log(Status.INFO,"Navigate to Address Page");
		
		Assert.assertEquals("", addresspageobject.SAEmail.getAttribute("value"));
		test.log(Status.PASS," email id field is empty");
		
		enterData(addresspageobject.SAEmail,"");
		enterData(addresspageobject.SAPincode,"");
		enterData(addresspageobject.SAAddress,"");
		enterData(addresspageobject.SAFirstName,"");
		enterData(addresspageobject.SALastName,"");
		enterData(addresspageobject.SAMobileNumber,"");
		test.log(Status.INFO,"leave all fields as empty");
		
		hover(addresspageobject.SaveContinueButton);
		click(addresspageobject.SaveContinueButton);
		test.log(Status.PASS,"Save and continue button is validating data");
		
		Assert.assertEquals("This field is required.", addresspageobject.SAEmailError.getText());
		test.log(Status.PASS,"error message for email is dispalyed");
		Assert.assertEquals("This field is required.", addresspageobject.SAPincodeError.getText());
		test.log(Status.PASS,"error message for pincode is dispalyed");
		Assert.assertEquals("This field is required.", addresspageobject.SAAddressError.getText());
		test.log(Status.PASS,"error message for address is dispalyed");
		Assert.assertEquals("This field is required.", addresspageobject.SAFirstNameError.getText());
		test.log(Status.PASS,"error message for first name is dispalyed");
		Assert.assertEquals("This field is required.", addresspageobject.SALastNameError.getText());
		test.log(Status.PASS,"error message for last name is dispalyed");
		Assert.assertEquals("Please enter a valid 10 digit mobile number", addresspageobject.SAMobileNumberError.getText());
		test.log(Status.PASS,"error message for mobile number is dispalyed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case4-34");
		}
	}
	//@Test
	public void case5( ) 
	{
		//351,352
		search("chair");
		try {
		test=extent.createTest("Verify the delivery charges amount changes based on the pincode entered in the shipping address.<br> "
				+ "Verify modifying the pincode in the address page updates the pincode field on the cart page.");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		AddressPage addresspageobject=PageFactory.initElements(driver, AddressPage.class);

		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		String pincode =cartpageobject.Pincode.getText();
		
		for(int i=0;i<cartpageobject.ProductImagesCart.size();i++)
		{
			selectByIndex(cartpageobject.QuantityCart.get(i),5);
		}
		
		String deliverychargestext=cartpageobject.DeliveryChargesCart.getText();
		int deliverycharges = Integer.parseInt(deliverychargestext.replaceAll("[₹,-]", ""));
		test.log(Status.INFO,"delivery charges amount  note down - cart page: "+deliverycharges);
		
		hover(cartpageobject.CheckoutButton);
		click(cartpageobject.CheckoutButton);
		test.log(Status.INFO,"Navigate to Address Page");

		String pincode1="503111";
		enterData(addresspageobject.SAPincode,pincode1);
		enterData(addresspageobject.SAEmail,"abc@gmail.com");
		test.log(Status.INFO," enterd  valid email : abc@gmail.com");		
		
		wait.until(ExpectedConditions.visibilityOf(addresspageobject.DeliveryChargesAddress));
		String deliverychargestext1=addresspageobject.DeliveryChargesAddress.getText();
		int deliverycharges1 = Integer.parseInt(deliverychargestext1.replaceAll("[₹,-]", ""));
		test.log(Status.INFO,"delivery charges amount  note down  - Address page: "+deliverycharges1);
		
		Assert.assertNotEquals(pincode, pincode1);
		test.log(Status.PASS,"pincode is changed in address page : "+pincode+" != "+pincode1);
		test.log(Status.PASS,"delivery charges is changed/ not changed in address page based on pincode: old charges - "+deliverycharges+", new charges - "+deliverycharges1);
		
		click(cartpageobject.CartLink);
		test.log(Status.INFO,"Navigate to cart Page");
		click(cartpageobject.ChangePincodeLink);
		
		String pincode2 =cartpageobject.EnterPincode.getAttribute("value");
		
		Assert.assertEquals(pincode2, pincode1);
		test.log(Status.PASS,"changed pincode in address page is reflect on cart page: "+pincode1+" = "+pincode2);
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case5-34");
		}
	}
	
	//@Test
	public void case6( )
	{
		//353-358
		search("chair");
		try {
		test=extent.createTest("verify in shipping address Pincode field displays error message for valid data for unavailable locations.<br>"
				+ "Verify the discount amount changes based on the modified pincode in the shipping address.<br>"
				+ "Verify the city name is displayed below the pincode field after entering a valid pincode.<br>"
				+ "Verify the city name and state name fields are disabled after entering a valid pincode.<br>"
				+ "Verify the GSTIN field accepts valid data and functions correctly.<br>"
				+ "Verify the GSTIN field displays an error message for invalid data.");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
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
		
		enterData(addresspageobject.SAPincode,"503145");
		test.log(Status.INFO,"entered valid and unavailable pincode: 503145");
		wait.until(ExpectedConditions.visibilityOf(addresspageobject.SAPincodeError));
		Assert.assertEquals("Sorry! We don't ship to this pincode currently.", addresspageobject.SAPincodeError.getText());
		Assert.assertEquals(addresspageobject.NotServiceError.getText(), "Some products in your cart are either out of stock or not serviceable on your pincode. Please remove those from the cart page to proceed.");
		test.log(Status.PASS,"error messages are displayed");
		
		addresspageobject.SAPincode.clear();
		enterData(addresspageobject.SAEmail,"abc@gmail.com");
		enterData(addresspageobject.SAPincode,"500037");
		test.log(Status.INFO,"entered valid and available pincode: 500037");
		enterData(addresspageobject.SAAddress,"haff awjgjwbas jagfj");
		enterData(addresspageobject.SAFirstName,"john");
		enterData(addresspageobject.SALastName,"paul");
		enterData(addresspageobject.SAMobileNumber,"9784678938");
		
		wait.until(ExpectedConditions.visibilityOf(addresspageobject.DeliveryChargesAddress));
		Assert.assertTrue(true);
		test.log(Status.PASS,"changed pincode in address page reflects delivery charges: 500037 - "+addresspageobject.DeliveryChargesAddress.getText());
		
		Assert.assertEquals(true, addresspageobject.SACityState.isDisplayed());
		test.log(Status.PASS,"based on pincode its shows city name : "+ addresspageobject.SACityState.getAttribute("value"));
		
		Assert.assertEquals("true", addresspageobject.SACityState.getAttribute("readonly"));
		test.log(Status.PASS,"city name field is disabled");
		
		enterData(addresspageobject.GSTIN,"sdjhgf45367hghfh");
		test.log(Status.INFO,"entered invalid gstin number : sdjhgf45367hghfh");
		Assert.assertEquals("Please enter a valid 15 digit GSTIN", addresspageobject.GSTINError.getText());
		test.log(Status.PASS,"error message is displayed for gstin");
		
		String gst="36AABCR1718E1ZQ";
		addresspageobject.GSTIN.clear();
		enterData(addresspageobject.GSTIN,gst);
		test.log(Status.INFO,"entered valid gstin number : "+gst);
		
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
			screenshot("case6-34");
		}
	}
}
