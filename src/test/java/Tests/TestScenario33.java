package Tests;

import java.util.Arrays;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.AddressPage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import Pages.SignUpPage;
import utilities.BaseClass;

public class TestScenario33 extends BaseClass
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
			screenshot("searchaproduct");
		}
	}
	
	@Test
	public void case1() throws Exception 
	{
		//335-338
		search("chair");
		try {
		test = extent.createTest("Verify the \"Cart\" link redirects to the cart page.<br>" +
                "Verify the \"Address\" link redirects to the same address page.<br>" +
                "Verify the \"Payment\" link is disabled when navigating on the address page.<br>" +
                "Verify the \"Save and Continue\" button redirects to the Payment page after entering all valid details.");
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
		
		Assert.assertEquals("https://www.urbanladder.com/checkout/address", driver.getCurrentUrl());
		test.log(Status.PASS,"Address Page is Visible");
		
		hover(cartpageobject.CartLink);
		click(cartpageobject.CartLink);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		Assert.assertEquals("https://www.urbanladder.com/cart", driver.getCurrentUrl());
		test.log(Status.PASS,"Cart Page is Visible");
		
		hover(cartpageobject.CheckoutButton);
		click(cartpageobject.CheckoutButton);
		test.log(Status.INFO,"Navigate to Address Page");
		
		hover(cartpageobject.AddressLink);
		click(cartpageobject.AddressLink);
		test.log(Status.INFO,"refresh the  address Page");
		
		Assert.assertEquals("https://www.urbanladder.com/checkout/address", driver.getCurrentUrl());
		test.log(Status.PASS,"Address Page is Visible");
		
		click(cartpageobject.PaymentLink);
		test.log(Status.INFO,"try to click on payment link");

		Assert.assertEquals(true, driver.getCurrentUrl().contains("checkout/address"));
		test.log(Status.PASS," Address Page is Displayed and  Payment Link is Disabled");
		
		enterData(addresspageobject.SAEmail,"abc@gmail.com");
		enterData(addresspageobject.SAPincode,"500037");
		enterData(addresspageobject.SAAddress,"haff awjgjwbas jagfj");
		enterData(addresspageobject.SAFirstName,"john");
		enterData(addresspageobject.SALastName,"paul");
		enterData(addresspageobject.SAMobileNumber,"9784678938");
		test.log(Status.INFO,"validating enterd data");
		
		hover(addresspageobject.SaveContinueButton);
		click(addresspageobject.SaveContinueButton);
		test.log(Status.INFO,"Navigate to payment page");
		Thread.sleep(2000);
		Assert.assertEquals("https://www.urbanladder.com/checkout/payment", driver.getCurrentUrl());
		test.log(Status.PASS,"Payment Page is Visible");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case1-33");
		}
	}
//	@Test
	public void case2() 
	{
		//339-345
		search("chair");
		search("table");
		try {
		test = extent.createTest(" Verify the product details are displayed in the order summary column.<br>"
				+ "Verify the quantity of each product in the order summary matches the cart page product quantity.<br>"
				+ "Verify the product name of each product in the order summary matches the cart page product name.<br>"
				+ "Verify the order total in the order summary matches the cart page order total.<br>"
				+ "Verify the discounts in the order summary match the cart page discounts.<br>"
				+ "Verify the delivery charges in the order summary match the cart page delivery charges.<br>"
				+ "Verify the total payable amount in the order summary matches the cart page total payable amount.");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		AddressPage addresspageobject=PageFactory.initElements(driver, AddressPage.class);
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
		
		hover(cartpageobject.CheckoutButton);
		click(cartpageobject.CheckoutButton);
		test.log(Status.INFO,"Navigate to Address Page");
		
		Assert.assertEquals("https://www.urbanladder.com/checkout/address", driver.getCurrentUrl());
		test.log(Status.PASS,"Address Page is Visible");
		
		String quantityaddress[]=new String[addresspageobject.QuantityAddress.size()];
		String productnameaddress[]=new String[addresspageobject.QuantityAddress.size()];
		for(int i=0;i<addresspageobject.QuantityAddress.size();i++)
		{
			Assert.assertEquals(true, addresspageobject.ProductTitlesAddress.get(i+1).isDisplayed());
			test.log(Status.PASS,"product name is display in address page");
			Assert.assertEquals(true, addresspageobject.QuantityAddress.get(i).isDisplayed());
			test.log(Status.PASS,"quantity for product is display in address page");
			
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
		
		
		Assert.assertEquals(true,Arrays.equals(quantityaddress, quantitycart) ); 
		test.log(Status.PASS,"quantity of a products in address page will be same as quantity of a products in cart page : "+Arrays.toString(quantityaddress)+" = "+Arrays.toString(quantitycart));
		Assert.assertEquals(true,Arrays.equals(productnameaddress, productnamecart));
		test.log(Status.PASS,"product names in address page will be same as product names in cart page : "+Arrays.toString(productnameaddress)+" = "+Arrays.toString(productnamecart));

		Assert.assertEquals(carttotal1, carttotal);
		test.log(Status.PASS,"cart total in address page will be same as cart total  in cart page : "+carttotal1+" = "+carttotal);
		Assert.assertEquals(discount1, discount);
		test.log(Status.PASS,"discount amount in address page will be same as discount amount  in cart page : "+discount+" = "+discount1);
		Assert.assertEquals(deliverycharges1, deliverycharges);
		test.log(Status.PASS,"delivery charges in address page will be same as delivery charges  in cart page : "+deliverycharges1+" = "+deliverycharges);
		Assert.assertEquals(totalpayableamount1, totalpayableamount);
		test.log(Status.PASS,"total payable amount in address page will be same astotal payable amount  in cart page : "+totalpayableamount1+" = "+totalpayableamount);
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case2-33");
		}
	}
	
	
	
	
	
}
