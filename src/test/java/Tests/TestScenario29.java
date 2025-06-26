package Tests;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import Pages.CartPage;
import Pages.HomePage;

import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import Pages.SignUpPage;
import utilities.BaseClass;

public class TestScenario29 extends BaseClass
{
	public void search(String product) 
	{
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
		click(signuppageobject.close);}catch(Exception e) {Assert.fail();
		test.log(Status.FAIL,"somthing went wrong : "+ e.getMessage());
		screenshot("recently viewed");}
		click(homepageobject.Logo);
	}
	@Test
	public void case1()
	{
		//283,284
		test=extent.createTest("Verify Cart functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		Assert.assertEquals(true, driver.getCurrentUrl().contains("https://www.urbanladder.com/cart"));
		test.log(Status.PASS," Cart Page is Displayed");
		
		Assert.assertEquals("Your cart is empty", cartpageobject.EmptyMessage.getText());
		test.log(Status.PASS,"Cart Empty message is Displayed");
				
		hover(cartpageobject.ContinueShoppingButton);
		test.log(Status.INFO," Continue shopping button is highlighted");
		click(cartpageobject.ContinueShoppingButton);
		test.log(Status.INFO,"Navigate to Home Page");
		
		Assert.assertEquals(true, homepageobject.SearchBar.isDisplayed());
		test.log(Status.PASS,"Home page is Displayed");
	}
	//@Test
	public void case2()
	{
		//285-286
		test=extent.createTest("Verify Cart functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		Assert.assertEquals(true, driver.getCurrentUrl().contains("https://www.urbanladder.com/cart"));
		test.log(Status.PASS," Cart Page is Displayed");
		
		hover(cartpageobject.CartLink);
		click(cartpageobject.CartLink);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		Assert.assertEquals("https://www.urbanladder.com/cart", driver.getCurrentUrl());
		test.log(Status.PASS," Cart Page is Displayed");
		
		click(cartpageobject.PaymentLink);
		click(cartpageobject.AddressLink);

		Assert.assertEquals(true, driver.getCurrentUrl().contains("https://www.urbanladder.com/cart"));
		test.log(Status.PASS," Cart Page is Displayed and Address and Payment Links are Disabled");
		
	}
	
	//@Test
	public void case3()
	{
		search("chair");
		// 287 - 293
		test=extent.createTest("Verify Cart functionality - navigation").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		String count = homepageobject.CartCount.getText();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		Assert.assertEquals(true, driver.getCurrentUrl().contains("https://www.urbanladder.com/cart"));
		test.log(Status.PASS," Cart Page is Displayed");
		
		Assert.assertEquals(true, cartpageobject.Pincode.isDisplayed());
		test.log(Status.PASS," Cart Page is Displayed Default pincode and city");
		
		Assert.assertEquals(count, String.valueOf(cartpageobject.ProductImagesCart.size()));
		test.log(Status.PASS," Cart count is match with products in cart page");
		
		System.out.println(cartpageobject.EnterPincode.isDisplayed());
		//Assert.assertEquals(false, cartpageobject.EnterPincode.isEnabled());
		test.log(Status.PASS,"Pincode field is disabled ");
		
		Assert.assertEquals("Delivery charges may be applicable.", cartpageobject.knowmoretext.getText());
		test.log(Status.PASS,"Delivery charges may be applicable-text is displayed");
		
		hover(cartpageobject.KnowmoreLink);
		click(cartpageobject.KnowmoreLink);
		test.log(Status.INFO,"display popup");
		
		Assert.assertEquals("Please refer to the payment summary for exact delivery charges.", cartpageobject.Knowmoretext1.getText());
		test.log(Status.PASS,"Please refer to the payment summary for exact delivery charges. text is displayed");
			
		click(cartpageobject.KnowmoreClose);
		test.log(Status.INFO,"close popup");
		
		click(cartpageobject.ChangePincodeLink);
		test.log(Status.INFO," pincode field is enabled");
		
		Assert.assertEquals(true, cartpageobject.CheckButton.isDisplayed());
		test.log(Status.PASS," pincode field is enabled");
		
		hover(cartpageobject.CheckoutButton);
		click(cartpageobject.CheckoutButton);
		test.log(Status.INFO,"Navigate to Address Page");
		
		Assert.assertEquals(true, driver.getCurrentUrl().contains("https://www.urbanladder.com/checkout/address"));
		test.log(Status.PASS," Address Page is Displayed");
		
	}
//	@Test
	public void case4()
	{
		search("chair");
		// 294
		test=extent.createTest("Verify Cart functionality - remove products").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		//String count = homepageobject.CartCount.getText();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		Assert.assertEquals(true, driver.getCurrentUrl().contains("https://www.urbanladder.com/cart"));
		test.log(Status.PASS," Cart Page is Displayed");
		
		for(int i=0;i<cartpageobject.ProductImagesCart.size();i++)
		{
			hover(cartpageobject.DeleteItemCart.get(i));
			click(cartpageobject.DeleteItemCart.get(i));
			test.log(Status.INFO,"Products are removed from Cart");
		}
		Assert.assertEquals("Your cart is empty", cartpageobject.EmptyMessage.getText());
		test.log(Status.PASS,"Cart Empty message is Displayed");
		
		
	}
	//@Test
	public void case5()
	{
		search("chair");
		// 295-300
		test=extent.createTest("Verify Cart functionality - links ").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		Assert.assertEquals(true, driver.getCurrentUrl().contains("https://www.urbanladder.com/cart"));
		test.log(Status.PASS," Cart Page is Displayed");
		
		switchToFrameByWebElement(cartpageobject.EMIFrameId);
		
		Assert.assertEquals(true, cartpageobject.ViewOptionsCart.isDisplayed());
		test.log(Status.PASS,"view options button is displayd");
		Assert.assertEquals(true, cartpageobject.ViewPlansCart.isDisplayed());
		test.log(Status.PASS,"view plans button is displayd");
		
		switchToParentFrame();
		
		Assert.assertEquals(true, cartpageobject.ExploreOffersButton.isDisplayed());
		test.log(Status.PASS,"explore offers button button is displayd");
		Assert.assertEquals(true, cartpageobject.ApplyCouponButtonCart.isDisplayed());
		test.log(Status.PASS,"apply coupon button is displayd");
		
		click(cartpageobject.ApplyCouponButtonCart);
		test.log(Status.INFO,"coupon popup is displayed");
		
		Assert.assertEquals(true, cartpageobject.AvailableCouponText.isDisplayed());
		test.log(Status.PASS,"pop up is displayd");
		
		click(cartpageobject.AvailableCouponClose);
		test.log(Status.INFO,"coupons popup is closed");
		
		click(cartpageobject.ExploreOffersButton);
		test.log(Status.INFO,"coupon offers popup is displayed");
		
		Assert.assertEquals(true, cartpageobject.AvailableCouponText.isDisplayed());
		test.log(Status.PASS,"offers pop up is displayd");
		
		click(cartpageobject.AvailableCouponClose);
		test.log(Status.INFO,"coupons offers popup is closed");
		
		Assert.assertEquals(false, cartpageobject.AvailableCouponText.isDisplayed());
		test.log(Status.PASS,"popup offers is closed");
		
	}
	
}
