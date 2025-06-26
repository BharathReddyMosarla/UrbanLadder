package Tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import Pages.SignUpPage;
import utilities.BaseClass;

public class TestScenario30and31 extends BaseClass
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
		click(signuppageobject.close);}catch(Exception e) {}
		hover(homepageobject.Logo);
		click(homepageobject.Logo);
	}
	
	//@Test
	public void case1() 
	{
		search("chair");
		// 301-308
		test=extent.createTest("Verify Cart functionality - valid pincode ").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		ProductDetailsPage productdetailspageobject=PageFactory.initElements(driver, ProductDetailsPage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		String date = cartpageobject.DeliverydateCart.get(0).getText();
		String charges= cartpageobject.DeliveryChargesCart.getText();
		
		click(cartpageobject.ChangePincodeLink);
		test.log(Status.INFO,"pincode field is enabled");
		cartpageobject.EnterPincode.clear();
		enterData(cartpageobject.EnterPincode,"503145");
		test.log(Status.INFO,"entered valid pincode but not available");
		click(cartpageobject.CheckButton);
		test.log(Status.INFO,"validateing pincode");
		wait.until(ExpectedConditions.visibilityOf(cartpageobject.NotServiceError));
		Assert.assertEquals("Some products in your cart are either out of stock or not serviceable on your pincode. Please remove those from the cart page to proceed.", cartpageobject.NotServiceError.getText());
		test.log(Status.PASS,"not servicable message is displayed");
				
		click(cartpageobject.ChangePincodeLink);
		test.log(Status.INFO,"pincode field is enabled");
		cartpageobject.EnterPincode.clear();
		enterData(cartpageobject.EnterPincode,"500037");
		test.log(Status.INFO,"entered valid pincode and available");
		click(cartpageobject.CheckButton);
		test.log(Status.INFO,"validateing pincode");
		wait.until(ExpectedConditions.visibilityOf(cartpageobject.knowmoretext));
		Assert.assertEquals(true, cartpageobject.knowmoretext.isDisplayed());
		test.log(Status.PASS,"know more text is displayed for valid and available pincode");
		
		String date1 = cartpageobject.DeliverydateCart.get(0).getText();
		String charges1=cartpageobject.DeliveryChargesCart.getText();
		
		if(date.equals(date1))
		{
			test.log(Status.INFO,date+" : delivery dates are not changed");
		}
		else
		{
			test.log(Status.INFO,date+" : delivery dates are changed to : "+date1);
		}
		if(charges.equals(charges1))
		{
			test.log(Status.INFO,charges1+" : delivery charges are not changed");
		}
		else
		{
			test.log(Status.INFO,charges+" : delivery charges are changed to : "+charges1);
		}
		
				
		click(cartpageobject.ChangePincodeLink);
		test.log(Status.INFO,"pincode field is enabled");
		cartpageobject.EnterPincode.clear();
		enterData(cartpageobject.EnterPincode,"dgdfgd");
		test.log(Status.INFO,"entered invalid pincode");
		click(cartpageobject.CheckButton);
		test.log(Status.INFO,"validateing pincode");
		click(cartpageobject.ChangePincodeLink);
		wait.until(ExpectedConditions.visibilityOf(cartpageobject.PincodeError));
		Assert.assertEquals(true, cartpageobject.PincodeError.isDisplayed());
		test.log(Status.PASS,"invalid pincode text is displayed");
		
		for(int i=0; i<cartpageobject.ProductImagesCart.size();i++)
		{
			Assert.assertEquals(true, cartpageobject.ProductImagesCart.get(i).isDisplayed());
			test.log(Status.PASS,"product image is displayed");
			Assert.assertEquals(true, cartpageobject.ProductTitlesCart.get(i).isDisplayed());
			test.log(Status.PASS,"product name is displayed");
		}
		
		String productname=cartpageobject.ProductTitlesCart.get(0).getText();
		click(cartpageobject.ProductImagesCart.get(0));
		test.log(Status.INFO,"navigate to selected product details page");
		switchToChildWindow();
		Assert.assertEquals(productname.toLowerCase(), productdetailspageobject.ProductName.getText().toLowerCase());
		test.log(Status.PASS,"product name is matched with seleted product in cart page");
		driver.close();
		switchToParentWindow(parent);
	}
	@Test
	public void case2()
	{
		search("chair");
		// 309-310
		test=extent.createTest("Verify Cart functionality ").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		for(int i=0; i<cartpageobject.ProductImagesCart.size();i++)
		{
			Assert.assertEquals(true,cartpageobject.AddWishlistButtonCart.get(i).isDisplayed());
			test.log(Status.INFO,"Add wishlist button is visible on product image");
		}
	
		click(cartpageobject.AddWishlistButtonCart.get(0));
		wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
		Assert.assertEquals(true, signuppageobject.close.isDisplayed());
		
		
	}
	//@Test
	public void case3()
	{
		//311
		test=extent.createTest("Verify Cart functionality  ").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		ProductDetailsPage productdetailspageobject=PageFactory.initElements(driver, ProductDetailsPage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);

		parent = driver.getWindowHandle();
		//----------------
		click(homepageobject.Logo);
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Login);
		test.log(Status.INFO,"Navigate to Login Popup");
		
		enterData(loginpageobject.Email,config.getProperty("LoginEmail"));
		enterData(loginpageobject.Password,"Arrow@a9d");
		test.log(Status.INFO,"Entered valid Login Details");
		
		click(loginpageobject.LoginButton);
		test.log(Status.INFO,"Navigate to Home Page");
		//--------------------
		
			hover(homepageobject.CartIcon);
			click(homepageobject.CartIcon);
			test.log(Status.INFO,"Navigate to Cart Page");
			try {
			if(cartpageobject.EmptyMessage.isDisplayed())
			{
				click(homepageobject.Logo);
				enterData(homepageobject.SearchBar,"chair");
				click(homepageobject.SearchIconButton);
				test.log(Status.INFO,"Display searched Products");
				
				click(productspageobject.ProductImages.get(0));
				test.log(Status.INFO,"selectd first product");
				//Thread.sleep(1000);
				switchToChildWindow();
				test.log(Status.INFO,"Navigated to new  window");
				click(productdetailspageobject.AddToCartButton);
				hover(cartpageobject.CheckoutButton);
				driver.close();
				switchToParentWindow(parent);
				click(homepageobject.Logo);
				
				hover(homepageobject.CartIcon);
				click(homepageobject.CartIcon);
				test.log(Status.INFO,"Navigate to Cart Page");
			}}catch(Exception e) {}

			System.out.println(cartpageobject.ProductImagesCart.size());
		
		for(int i=0; i<cartpageobject.ProductImagesCart.size();i++)
		{
			Assert.assertEquals(true,cartpageobject.AddWishlistButtonCart.get(i).isDisplayed());
			test.log(Status.INFO,"Add wishlist button is visible on product image");
		}
		for(int i=0; i<cartpageobject.ProductImagesCart.size();i++)
		{
		click(cartpageobject.AddWishlistButtonCart.get(0));
		test.log(Status.INFO,"product move to wishlist page");
		}
		Assert.assertEquals(true, cartpageobject.EmptyMessage.isDisplayed());
		test.log(Status.PASS," cart page is empty");	
	}
	//@Test
	public void case4()
	{
		search("chair");
		search("table");
		//312-317
		test=extent.createTest("Verify Cart functionality  ").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
	

		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		for(int i=0; i<cartpageobject.ProductImagesCart.size();i++)
		{
			Assert.assertEquals(true,cartpageobject.DeliverydateCart.get(i).isDisplayed());
			Assert.assertEquals(true, cartpageobject.DeliverydateCart.get(i).getText().contains("By"));
			test.log(Status.PASS,cartpageobject.DeliverydateCart.get(i).getText()+" : delivery date is visible ");
		}
		for(int i=0; i<cartpageobject.ProductImagesCart.size();i++)
		{
			Assert.assertEquals(true,cartpageobject.QuantityCart.get(i).isDisplayed());
			test.log(Status.PASS,"Quantity field is displayed");
			selectByIndex(cartpageobject.QuantityCart.get(i),4);
			test.log(Status.INFO,cartpageobject.QuantityCart.get(i).getAttribute("value")+" : Qunatity");
			selectByIndex(cartpageobject.QuantityCart.get(i),0);
			test.log(Status.INFO,cartpageobject.QuantityCart.get(i).getAttribute("value")+" : Qunatity");
			selectByIndex(cartpageobject.QuantityCart.get(i),9);
			test.log(Status.INFO,cartpageobject.QuantityCart.get(i).getAttribute("value")+" : Qunatity");
		}
		for(int i=0; i<cartpageobject.ProductImagesCart.size();i++)
		{
			int totalactualprice = 0;
			selectByIndex(cartpageobject.QuantityCart.get(i),0);
			String finalpricetext=cartpageobject.FinalPriceCart.get(i).getText();
			int finalprice = Integer.parseInt(finalpricetext.replaceAll("[₹,]", ""));
			
			selectByIndex(cartpageobject.QuantityCart.get(i),2);
			String quantitytext=cartpageobject.QuantityCart.get(i).getAttribute("value");
			String finalpricetext1=cartpageobject.FinalPriceCart.get(i).getText();
			int totalfinalprice = Integer.parseInt(finalpricetext1.replaceAll("[₹,]", ""));
			
			int quantity = Integer.parseInt(quantitytext);
			if(finalprice*quantity==totalfinalprice+1 || finalprice*quantity==totalfinalprice)
			{
				Assert.assertTrue(true);
				test.log(Status.PASS,"Total price is calculated as price*quantity : "+totalfinalprice+" = "+finalprice*quantity);
			}
			try 
			{
				String finalactualtext1=cartpageobject.StrikePriceCart.get(i).getText();
				totalactualprice = Integer.parseInt(finalactualtext1.replaceAll("[₹,]", ""));
				
				double discountAmount =  totalactualprice-totalfinalprice ;
				double percentage = (discountAmount/totalactualprice)*100;
				// need to check sale percentage
			Assert.assertEquals(true, cartpageobject.PromotionInfoCart.get(i).getText().contains(String.valueOf(Math.round(percentage))));
				test.log(Status.PASS,"Diffent amounts"+totalactualprice+"-"+totalfinalprice+"="+discountAmount
						+ "Sale percentagearound for this product is "+(int) Math.round(percentage)+"%");
			
			}catch(Exception e)
			{
				int discountAmount = totalactualprice ;
				int percentage = discountAmount;
			
				test.log(Status.PASS," No discount on his product: "+percentage);
				
			}
		
		}
		
	}
	
	

}
