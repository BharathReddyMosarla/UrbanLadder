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

public class TestScenario35 extends BaseClass
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
		//359-362
		search("table");
		try {
		test=extent.createTest("Verify the billing address checkbox is displayed on the address page.<br>"
				+ "Verify checking the billing address checkbox hides all billing address fields.<br>"
				+ "Verify unchecking the billing address checkbox displays all billing address fields.<br>"
				+ "Verify the billing address fields data is the same as the shipping address after unchecking the checkbox, once all shipping address details are entered. ");
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
		
		String 	SAEmail ="abc@gmail.com",
				SAPincode = "500037",
				SAAddress = "manchester, london",
				SAFirstName ="john",
				SALastName = "paul",
				SAMobileNumber ="9784678938";
		
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
		
		Assert.assertEquals(true, addresspageobject.SAasBAcheckbox.isSelected());
		test.log(Status.PASS,"checkbox is selected by default");
		
		click(addresspageobject.SAasBAcheckbox);
		test.log(Status.INFO,"unchecked the chceckbox - billing address fields are displayed");
		Assert.assertEquals(true, addresspageobject.BAFirstName.isDisplayed());
		test.log(Status.PASS,"billing address all fields are displayed");
		
		click(addresspageobject.SAasBAcheckbox);
		test.log(Status.INFO,"select the checkbox - billing address fields are hidden");
		Assert.assertEquals(true, addresspageobject.SAasBAcheckbox.isSelected());
		test.log(Status.PASS,"checkbox is selected and billing address are hidden ");
		
		wait.until(ExpectedConditions.elementToBeClickable(addresspageobject.SaveContinueButton));
		click(addresspageobject.SaveContinueButton);
		wait.until(ExpectedConditions.visibilityOf(paymentpageobject.PlaceOrderButton));
		click(cartpageobject.AddressLink);
		click(addresspageobject.SAasBAcheckbox);
		test.log(Status.INFO,"unchecked the chceckbox - billing address fields are displayed");	
		
		Assert.assertEquals(SAPincode, addresspageobject.BAPincode.getAttribute("value"));
		Assert.assertEquals(SAAddress, addresspageobject.BAAddress.getAttribute("value"));
		Assert.assertEquals(SAFirstName, addresspageobject.BAFirstName.getAttribute("value"));
		Assert.assertEquals(SALastName, addresspageobject.BALastName.getAttribute("value"));
		Assert.assertEquals(SAMobileNumber, addresspageobject.BAMobileNumber.getAttribute("value"));
		test.log(Status.PASS,"Shipping address fields and billing address fields data is same");
		
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case1-35");
		}
	}
	
	//@Test
	public void case2( ) 
	{
		//363-365
		search("table");
		try {
		test=extent.createTest("Verify the billing address functionality works with valid data.<br>"
				+ "Verify the billing address functionality displays an error for invalid data.<br>"
				+ "Verify the billing address functionality displays an error for null data. ");
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
		
		String 	SAEmail ="abc@gmail.com",
				SAPincode = "500037",
				SAAddress = "manchester, london",
				SAFirstName ="john",
				SALastName = "paul",
				SAMobileNumber ="9784678938";
		enterData(addresspageobject.SAEmail,SAEmail);
		test.log(Status.INFO," enterd  valid SA email : "+SAEmail);
		enterData(addresspageobject.SAPincode,SAPincode);
		test.log(Status.INFO," enterd  valid SA pincode : "+SAPincode);
		enterData(addresspageobject.SAAddress,SAAddress);
		test.log(Status.INFO," enterd  valid SA address : "+SAAddress);
		enterData(addresspageobject.SAFirstName,SAFirstName);
		test.log(Status.INFO," enterd  valid SA firstname : "+SAFirstName);
		enterData(addresspageobject.SALastName,SALastName);
		test.log(Status.INFO," enterd  valid SA lastname : "+SALastName);
		enterData(addresspageobject.SAMobileNumber,SAMobileNumber);
		test.log(Status.INFO," enterd  valid SA phonenumber : "+SAMobileNumber);
		test.log(Status.INFO,"validating enterd  valid data - SA");
		
		click(addresspageobject.SAasBAcheckbox);
		test.log(Status.INFO,"unchecked the chceckbox - billing address fields are displayed");
		
		click(addresspageobject.SaveContinueButton);
		test.log(Status.INFO,"validating the billing address fileds - as all fields are empty ");
		
		Assert.assertEquals("This field is required.", addresspageobject.BAFirstNameError.getText());
		Assert.assertEquals("This field is required.", addresspageobject.BALastNameError.getText());
		Assert.assertEquals("This field is required.", addresspageobject.BAAddressError.getText());
		Assert.assertEquals("This field is required.", addresspageobject.BAPincodeError.getText());
		Assert.assertEquals("Please enter a valid 10 digit mobile number", addresspageobject.BAMobileNumberError.getText());
		test.log(Status.PASS,"This field is required - this error message is displayed for all billing address fields are empty");
		
		enterData(addresspageobject.BAPincode,"dfhdh");
		test.log(Status.INFO," enterd  invalid BA pincode : dfhdh");
		enterData(addresspageobject.BAAddress,"2345@5%£");
		test.log(Status.INFO," enterd  invalid BA address : 2345@5%£");
		enterData(addresspageobject.BAFirstName,"2345@5%£");
		test.log(Status.INFO," enterd  invalid BA firstname : 2345@5%£");
		enterData(addresspageobject.BALastName,"2345@5%£");
		test.log(Status.INFO," enterd  invalid BA lastname : 2345@5%£");
		enterData(addresspageobject.BAMobileNumber,"dfhdh");
		test.log(Status.INFO," enterd  invalid BA phonenumber : dfhdh ");
		test.log(Status.INFO,"validating enterd  invalid data - BA");
		
		Assert.assertEquals("Please enter a valid pincode", addresspageobject.BAPincodeError.getText());
		Assert.assertEquals("Please enter a valid 10 digit mobile number", addresspageobject.BAMobileNumberError.getText());
		test.log(Status.PASS,"  error message is displayed for all billing address fields are invalid data");
		
		String 	BAPincode = "500054",
				BAAddress = "Blackpool, England",
				BAFirstName ="chris",
				BALastName = "worell",
				BAMobileNumber ="6789389784";
		addresspageobject.BAPincode.clear();
		addresspageobject.BAAddress.clear();
		addresspageobject.BAFirstName.clear();
		addresspageobject.BALastName.clear();
		addresspageobject.BAMobileNumber.clear();
		
		enterData(addresspageobject.BAPincode,BAPincode);
		test.log(Status.INFO," enterd  valid BA pincode : "+BAPincode);
		enterData(addresspageobject.BAAddress,BAAddress);
		test.log(Status.INFO," enterd  valid BA address : "+BAAddress);
		enterData(addresspageobject.BAFirstName,BAFirstName);
		test.log(Status.INFO," enterd  valid BA firstname : "+BAFirstName);
		enterData(addresspageobject.BALastName,BALastName);
		test.log(Status.INFO," enterd  valid BA lastname : "+BALastName);
		enterData(addresspageobject.BAMobileNumber,BAMobileNumber);
		test.log(Status.INFO," enterd  valid BA phonenumber : "+BAMobileNumber);
		test.log(Status.INFO,"validating enterd  valid data - BA");
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(addresspageobject.SaveContinueButton));
		click(addresspageobject.SaveContinueButton);
		test.log(Status.INFO,"validating the billing address fileds - as all fields are valid data ");
		wait.until(ExpectedConditions.visibilityOf(paymentpageobject.PlaceOrderButton));
		Assert.assertEquals("https://www.urbanladder.com/checkout/payment", driver.getCurrentUrl());
		test.log(Status.PASS,"Payment Page is Displayed");
	
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case1-35");
		}
	}
	

}
