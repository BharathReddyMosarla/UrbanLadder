package Tests;

import org.testng.annotations.Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Pages.HelpPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import Pages.SignUpPage;
import utilities.BaseClass;

public class TestScenario01and02and04and05 extends BaseClass
{
	
	
	@Test
	public void testcase1()
	{
		//1,2
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		HelpPage helppageobject=PageFactory.initElements(driver, HelpPage.class);
		
		test=extent.createTest("Verify Help Link").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		hover(homepageobject.Help);
		test.log(Status.INFO,"Help link is highlighted");
		
		Assert.assertEquals(true, homepageobject.Help.isDisplayed());
		test.log(Status.PASS,"Help link is Displayed");
		
		click(homepageobject.Help);
		test.log(Status.INFO,"Navigated to Help Page");
		
		Assert.assertEquals("Help | urbanladder.com", driver.getTitle());
		test.log(Status.PASS,"Help Page is Displayed");
		
		Assert.assertEquals("true",helppageobject.HelpTopics.get(0).isDisplayed());
		test.log(Status.PASS,"Help Topics are Displayed in Help Page");
	}
	//@Test
	public void testcase2()
	{
		//3,4
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		
		test=extent.createTest("Verify Track Order Link").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		hover(homepageobject.TrackOrder);
		test.log(Status.INFO,"Track Order link is highlighted");
		
		Assert.assertEquals(true, homepageobject.TrackOrder.isDisplayed());
		test.log(Status.PASS,"Track Order link is Displayed");
		
		click(homepageobject.TrackOrder);
		test.log(Status.INFO,"Navigated to Track Order Page");
		
		Assert.assertEquals("Track Order | Urbanladder", driver.getTitle());
		test.log(Status.PASS,"Track Order Page is Displayed");
			
	}
	//@Test
	public void testcase3()
	{
		//5,6
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		
		test=extent.createTest("Verify Find a Store Link").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		hover(homepageobject.FindaStore);
		test.log(Status.INFO,"Find a Store link is highlighted");
		
		Assert.assertEquals(true, homepageobject.FindaStore.isDisplayed());
		test.log(Status.PASS,"Find a Store link is Displayed");
		
		click(homepageobject.FindaStore);
		test.log(Status.INFO,"Navigated to Find a Store Page");
		
		
		Assert.assertEquals("City Pages - Urban Ladder", driver.getTitle());
		test.log(Status.PASS,"Find a Store Page is Displayed");
			
	}
	//@Test
	public void testcase4()
	{
		//7,8
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		
		
		test=extent.createTest("Verify Bulk Orders Link").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		hover(homepageobject.BulkOrders);
		test.log(Status.INFO,"Bulk Orders link is highlighted");
		
		Assert.assertEquals(true, homepageobject.BulkOrders.isDisplayed());
		test.log(Status.PASS,"Bulk Orders link is Displayed");
		
		click(homepageobject.BulkOrders);
		test.log(Status.INFO,"Navigated to Bulk Orders Page");

		Assert.assertEquals("Institutional Business Landing-Page - Urban Ladder", driver.getTitle());
		test.log(Status.PASS,"Bulk Orders Page is Displayed");
		
	}
	//@Test
	public void testcase5()
	{
		//9,10
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		
		
		test=extent.createTest("Verify UL Services Link").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		hover(homepageobject.ULServices);
		test.log(Status.INFO,"UL Services link is highlighted");
		
		Assert.assertEquals(true, homepageobject.ULServices.isDisplayed());
		test.log(Status.PASS,"UL Services link is Displayed");
		
		click(homepageobject.ULServices);
		test.log(Status.INFO,"Navigated to UL Services Page");

		Assert.assertEquals("UL Services - Urban Ladder", driver.getTitle());
		test.log(Status.PASS,"UL Services Page is Displayed");
		
	}
	//@Test
	public void testcase6()
	{
		//11,12
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		
		
		test=extent.createTest("Verify Track Order Icon").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		hover(homepageobject.TrackOrderIcon);
		test.log(Status.INFO,"Track Order Icon is highlighted");
		
		Assert.assertEquals(true, homepageobject.TrackOrderIcon.isDisplayed());
		test.log(Status.PASS,"Track Order Icon is Displayed");
		
		click(homepageobject.TrackOrderIcon);
		test.log(Status.INFO,"Navigated to Track Order Page");
		
		Assert.assertEquals("Track Order | Urbanladder", driver.getTitle());
		test.log(Status.PASS,"Track Order Page is Displayed");
		
	}
	//@Test
	public void testcase7()
	{
		//13-17
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		
		
		test=extent.createTest("Verify User Icon").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		Assert.assertEquals(true, homepageobject.UserIcon.isDisplayed());
		test.log(Status.PASS,"User Icon is Displayed");
		
		hover(homepageobject.Login);
		test.log(Status.INFO,"Login is highlighted in the List");
		
		Assert.assertEquals(true, homepageobject.Login.isDisplayed());
		test.log(Status.PASS,"Login is Displayed in the List");
		
		
		hover(homepageobject.SignUp);
		test.log(Status.INFO,"SignUp is highlighted in the List");
		
		
		Assert.assertEquals(true, homepageobject.SignUp.isDisplayed());
		test.log(Status.PASS,"Signup is Displayed in the List");
		
	}
//	@Test
	public void testcase8()
	{
		//18,19
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
		
		
		test=extent.createTest("Verify Login & Signup").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		Assert.assertEquals(true, homepageobject.UserIcon.isDisplayed());
		test.log(Status.PASS,"User Icon is Displayed");
		
		hover(homepageobject.Login);
		test.log(Status.INFO,"Login is highlighted in the List");
		
		Assert.assertEquals(true, homepageobject.Login.isDisplayed());
		test.log(Status.PASS,"Login is Displayed in the List");
		
		click(homepageobject.Login);
		test.log(Status.INFO,"Navigate to Login Popup");
		
		//hover(loginpageobject.LoginButton);
		wait.until(ExpectedConditions.visibilityOf(loginpageobject.LoginButton));
		
		Assert.assertEquals(true, loginpageobject.LoginButton.isDisplayed());
		test.log(Status.PASS,"Login PopUp is Displayed");
		
		click(loginpageobject.close);
		
		hover(homepageobject.UserIcon);
		hover(homepageobject.SignUp);
		test.log(Status.INFO,"SignUp is highlighted in the List");
		
		Assert.assertEquals(true, homepageobject.SignUp.isDisplayed());
		test.log(Status.PASS,"SignUp is Displayed in the List");
		
		click(homepageobject.SignUp);
		test.log(Status.INFO,"Navigate to SignUp Popup");
		
		//hover(signuppageobject.SignUpButton);
		wait.until(ExpectedConditions.visibilityOf(signuppageobject.SignUpButton));
		
		Assert.assertEquals(true, signuppageobject.SignUpButton.isDisplayed());
		test.log(Status.PASS,"SignUp PopUp is Displayed");
		
	}
	
	//@Test
	public void testcase9()
	{
		//20-22
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
					
		test=extent.createTest("Verify Wishlist Icon").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
		hover(homepageobject.WishlistIcon);
		test.log(Status.INFO,"Wishlist Icon is highlighted");
			
		Assert.assertEquals(true, homepageobject.WishlistIcon.isDisplayed());
		test.log(Status.PASS,"Wishlist Icon is Displayed");
		
		Assert.assertEquals("0",homepageobject.WishlistCount.getText() );
		test.log(Status.PASS,"Wishlist count is Zero");
		
		click(homepageobject.WishlistIcon);
		test.log(Status.INFO,"Navigated to Create an Account Page");
			
		Assert.assertEquals(true, homepageobject.CreateAccountText.isDisplayed());
		test.log(Status.PASS,"Create an Account || Signup Page is displayed");
			
	}
	//@Test
	public void testcase10()
	{
		//23-26
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
		ProductDetailsPage productdetailspageobject=PageFactory.initElements(driver, ProductDetailsPage.class);
		parent = driver.getWindowHandle();
						
		test=extent.createTest("Verify Cart Icon").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
		hover(homepageobject.CartIcon);
		test.log(Status.INFO,"Cart Icon is highlighted");
				
		Assert.assertEquals(true, homepageobject.CartIcon.isDisplayed());
		test.log(Status.PASS,"Cart Icon is Displayed");
			
		Assert.assertEquals("0",homepageobject.CartIcon.getText() );
		test.log(Status.PASS,"Cart count is Zero");
			
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigated to Cart Page");
				
		Assert.assertEquals("Shopping Cart - Urban Ladder", driver.getTitle());
		test.log(Status.PASS,"Cart Page is displayed");
				
		click(homepageobject.LogoCart);
		test.log(Status.INFO,"Navigated to Home Page");
		
		enterData(homepageobject.SearchBar,"chair");
		click(homepageobject.SearchIconButton);
		test.log(Status.INFO,"Display searched Products");
		
		click(productspageobject.ProductImages.get(0));
		test.log(Status.INFO,"selectd first product");
		
		switchToChildWindow();
		test.log(Status.INFO,"Navigated to new  window");
		
		hover(loginpageobject.close);
		click(loginpageobject.close);
		test.log(Status.INFO,"close the signup popup");
		
		click(productdetailspageobject.AddToCartButton);
		test.log(Status.INFO,"selected AddToCart Button and product is added to cart page");
		
		click(homepageobject.LogoCart);
		
		Assert.assertEquals("1",homepageobject.CartIcon.getText() );
		test.log(Status.PASS,"Cart count is One");
		driver.close();
		
		switchToParentWindow(parent);
		test.log(Status.INFO,"Navigated back to Old  window");
		
	}
	
	//@Test
	public void testcase11()
	{
		//37-39
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		parent = driver.getWindowHandle();
						
		test=extent.createTest("Verify Logo & Name ").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		Assert.assertEquals(true, homepageobject.Logo.isDisplayed());
		test.log(Status.PASS,"Logo and Name is Displayed");
		
		click(homepageobject.Help);
		
		click(homepageobject.Logo);
		test.log(Status.INFO,"Navigated  to Home Page");
		
		Assert.assertEquals("https://www.urbanladder.com/", driver.getCurrentUrl());
		test.log(Status.PASS,"Home Page is Displayed");
				
	}
	//@Test
		public void testcase12()
		{
			//40-42
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
			parent = driver.getWindowHandle();
							
			test=extent.createTest("Verify Search Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
			hover(homepageobject.SearchIconButton);
			Assert.assertEquals(true, homepageobject.SearchIconButton.isDisplayed());
			test.log(Status.PASS,"Search icon is Displayed");
			
			enterData(homepageobject.SearchBar,"chair");
			Assert.assertEquals("chair", homepageobject.SearchBar.getAttribute("value"));
			test.log(Status.PASS,"Searched text is Displayed");
			
			click(homepageobject.SearchIconButton);
			test.log(Status.INFO,"Display Searched input related products");
			
			Assert.assertEquals(true, productspageobject.ProductImages.get(0).isDisplayed());
			test.log(Status.PASS,"Products are Displayed");
		}
		//@Test
		public void testcase13()
		{
			// test cases 43,44
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			
			test=extent.createTest("Verify Search Functionality").assignCategory("Negative Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
			enterData(homepageobject.SearchBar,"qqqq");
			Assert.assertEquals("qqqq", homepageobject.SearchBar.getAttribute("value"));
			test.log(Status.PASS,"Searched text is Displayed");
			
			click(homepageobject.SearchIconButton);
			test.log(Status.INFO,"Display a message related searched input");
			
			Assert.assertEquals(true, homepageobject.NoproductsText.isDisplayed());
			test.log(Status.PASS,"No products found message is Displayed");
			String title = driver.getTitle();
			
			homepageobject.SearchBar.clear();
			test.log(Status.INFO,"Search field is empty");
			
			Assert.assertEquals(title,driver.getTitle());
			test.log(Status.PASS,"No action is Performed");
		}
		//@Test
		public void testcase14()
		{
			// test cases 45,46,47,48,49
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
					
			test=extent.createTest("Verify Autosuggestions Functionality").assignCategory("Negative Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			
			enterData(homepageobject.SearchBar,"bed");
			Assert.assertEquals("bed", homepageobject.SearchBar.getAttribute("value"));
			test.log(Status.PASS,"Searched text is Displayed");
			
			Assert.assertEquals(true, homepageobject.AutoSugesstions.get(0).isDisplayed());
			test.log(Status.PASS,"Auto Suggestions are Displayed");
			Assert.assertEquals(8, homepageobject.AutoSugesstions.size());
			test.log(Status.PASS,"Auto Suggestions count is Matched");
			
			homepageobject.SearchBar.clear();
			test.log(Status.INFO,"Search field is empty");
			
			enterData(homepageobject.SearchBar,"qqqq");
			test.log(Status.INFO,"Enter invalid data in search field as empty");
			
			click(homepageobject.SearchIconButton);
			test.log(Status.INFO,"Display a message related searched input");
			
			
			Assert.assertEquals(true, homepageobject.NoproductsText.isDisplayed());
			test.log(Status.PASS,"No Auto Suggestions are Displayed");
			click(homepageobject.NoproductsText);
			
			click(homepageobject.Logo);
			test.log(Status.INFO,"Navigate to Home page");
			
			enterData(homepageobject.SearchBar,"li");
			
			Assert.assertEquals(true, homepageobject.AutoSugesstions.get(0).isDisplayed());
			test.log(Status.PASS,"Auto Suggestions are Displayed");
			
			click(homepageobject.Logo);
			test.log(Status.INFO,"Navigate to Home page");
			
			enterData(homepageobject.SearchBar,"li"+Keys.ENTER);
			Assert.assertEquals(true, productspageobject.ProductImages.get(0).isDisplayed());
			test.log(Status.PASS,"Searched products are Displayed");
		}
	}
		
