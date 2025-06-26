package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import Pages.WishlistPage;
import utilities.BaseClass;

public class TestScenario23 extends BaseClass
{
	
	
	
	public void login()
	{
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		
		test=extent.createTest("Verify  login Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Login);
		test.log(Status.INFO,"Navigate to Login Popup");
		
		enterData(loginpageobject.Email,config.getProperty("LoginEmail"));
		enterData(loginpageobject.Password,config.getProperty("LoginPassword"));
		test.log(Status.INFO,"Entered valid Login Details");
		
		click(loginpageobject.LoginButton);
		test.log(Status.INFO,"Navigate to Home Page");
		
		Assert.assertEquals("https://www.urbanladder.com/", driver.getCurrentUrl());
		test.log(Status.PASS,"Login is Successfull");
	}
	
	
	
	
	//@Test
	public void case1()
	{
		//249, 250
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		WishlistPage wishlistpageobject=PageFactory.initElements(driver, WishlistPage.class);
			
		test=extent.createTest("Verify  wishlist page `Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
		login();
		
		click(homepageobject.WishlistIcon);
		test.log(Status.INFO,"Navigate to wishlist Page");
		
		Assert.assertEquals(true, driver.getCurrentUrl().contains("wishlist"));
		test.log(Status.PASS,"Wishlist page is displayed");
		
		
		Assert.assertEquals(wishlistpageobject.OopsMessage.getText(),"Oops! There are no items in your wishlist. Continue browsing and add some!");
		test.log(Status.PASS,"message is displayed");
		
		click(wishlistpageobject.ContinueBrowsingButton);
		test.log(Status.INFO,"Navigate to Home Page");
		
		Assert.assertEquals("https://www.urbanladder.com/", driver.getCurrentUrl());
		test.log(Status.PASS,"home page is displayed");
		
		
	
	}
	//@Test
	public void case2() throws Exception
	{
		//251, 252
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
		WishlistPage wishlistpageobject=PageFactory.initElements(driver, WishlistPage.class);
		ProductDetailsPage productdetailspageobject=PageFactory.initElements(driver, ProductDetailsPage.class);
		
		login();
		
		test=extent.createTest("Verify  wishlist page Functionality - products").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		parent = driver.getWindowHandle();
		
		
		click(homepageobject.WishlistIcon);
		test.log(Status.INFO,"Navigate to wishlist Page");
		
		Assert.assertEquals(true, driver.getCurrentUrl().contains("wishlist"));
		test.log(Status.PASS,"Wishlist page is displayed");
		
		
		enterData(homepageobject.SearchBar,"chair");
		click(homepageobject.SearchIconButton);
		test.log(Status.INFO,"Display searched Products");
		
		for(int i=0;i<3;i++)
		{
			hover(productspageobject.ProductImages.get(i));
			click(productspageobject.AddWishlistbuttons.get(i));
			test.log(Status.INFO,"products add to wishlist");
		}
		
		click(homepageobject.WishlistIcon);
		test.log(Status.INFO,"Navigate to wishlist Page");
		
		Thread.sleep(5000);
		
		int size =wishlistpageobject.ProductImages.size();
		String size1=wishlistpageobject.WishlistCount.getText();
		
		
		if(String.valueOf(size).equals(size1))
		{
			Assert.assertTrue(true);
			test.log(Status.PASS,"wishlist count is same as products in a wishlist page");
		}
		else
		{
			Assert.fail();
			test.log(Status.FAIL,"count is not matched");
			screenshot("notmatching");
		}
		
		String productname=wishlistpageobject.productnames.get(0).getText();
		
		click(wishlistpageobject.productnames.get(0));
		test.log(Status.INFO,"Navigate to selected product Page : "+productname);
		
		switchToChildWindow();
		
		Assert.assertEquals(productname, productdetailspageobject.ProductName.getText());
		test.log(Status.PASS,"selected product details page is displayed");
		
		driver.close();
		switchToParentWindow(parent);
		
	}
	//@Test
	public void case3() throws Exception
	{
		//253, 254
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
		WishlistPage wishlistpageobject=PageFactory.initElements(driver, WishlistPage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		login();
		
		test=extent.createTest("Verify  wishlist page Functionality - cart page").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		parent = driver.getWindowHandle();
		
		click(homepageobject.WishlistIcon);
		test.log(Status.INFO,"Navigate to wishlist Page");
		try {
		if(wishlistpageobject.OopsMessage.isDisplayed())
		{
			enterData(homepageobject.SearchBar,"chair");
			click(homepageobject.SearchIconButton);
			test.log(Status.INFO,"Display searched Products");
			
			for(int i=0;i<3;i++)
			{
				hover(productspageobject.ProductImages.get(i));
				click(productspageobject.AddWishlistbuttons.get(i));
				test.log(Status.INFO,"products add to wishlist");
			}
			
			click(homepageobject.WishlistIcon);
			test.log(Status.INFO,"Navigate to wishlist Page");
		}
		}catch(Exception e) {}
		String productname=wishlistpageobject.productnames.get(0).getText();
		hover(wishlistpageobject.productnames.get(0));
		click(wishlistpageobject.AddtoCartButton.get(0));
		test.log(Status.INFO,"Navigate to cart Page ");
		
		Assert.assertEquals("https://www.urbanladder.com/cart", driver.getCurrentUrl());
		test.log(Status.PASS," cart Page is displayed");
		
		for(int i=0;i<cartpageobject.ProductTitlesCart.size();i++)
		{
			System.out.println(productname);
			System.out.println(cartpageobject.ProductTitlesCart.get(i).getText());
			if(productname.toLowerCase().contains(cartpageobject.ProductTitlesCart.get(i).getText().toLowerCase()))
			{ 
				Assert.assertTrue(true);
				test.log(Status.PASS," Selected product is successfully added to Cart Page");
				break;
			}
		}
		
	}
	@Test
	public void case4() throws Exception
	{
		//255
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
		WishlistPage wishlistpageobject=PageFactory.initElements(driver, WishlistPage.class);
		
		login();
		
		test=extent.createTest("Verify  wishlist page Functionality - remove product").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		parent = driver.getWindowHandle();
		
		click(homepageobject.WishlistIcon);
		test.log(Status.INFO,"Navigate to wishlist Page");
		try {
		if(wishlistpageobject.OopsMessage.isDisplayed())
		{
			enterData(homepageobject.SearchBar,"chair");
			click(homepageobject.SearchIconButton);
			test.log(Status.INFO,"Display searched Products");
			
			for(int i=0;i<3;i++)
			{
				hover(productspageobject.ProductImages.get(i));
				click(productspageobject.AddWishlistbuttons.get(i));
				test.log(Status.INFO,"products add to wishlist");
			}
			
			click(homepageobject.WishlistIcon);
			test.log(Status.INFO,"Navigate to wishlist Page");
		}
		}catch(Exception e) {}
		
		String count = homepageobject.WishlistCount.getText();
		hover(wishlistpageobject.ProductImages.get(0));
		click(wishlistpageobject.AddWishlistbuttons.get(0));
		test.log(Status.INFO," remove the product from wishlist page");
		
		
		if(count.equals(homepageobject.WishlistCount.getText()))
		{
			Assert.assertTrue(true);
			test.log(Status.PASS," Selected products is removed from wishlist page");
		}
	
	}
}
