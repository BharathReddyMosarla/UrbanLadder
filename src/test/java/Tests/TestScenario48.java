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
import Pages.WishlistPage;
import utilities.BaseClass;

public class TestScenario48 extends BaseClass
{
	public String productTitle;
	
	public void productdetailspage()
	{
		try 
		{
			//
			
			test=extent.createTest("Verifying product details page");
			test.log(Status.INFO,"Home page is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
			parent = driver.getWindowHandle();
			
			hover(homepageobject.Living);
			hover(homepageobject.LivingSM.get(0));
			click(homepageobject.LivingSM.get(0));
			hover(homepageobject.subsublistimage.get(2));
			click(homepageobject.subsublistimage.get(2));
			driver.close();
			switchToChildWindow();
			wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
			click(signuppageobject.close);		
			
			hover(productspageobject.ProductImages.get(0));
			productTitle = productspageobject.ProductNames.get(0).getText(); //---
			click(productspageobject.viewproductButtons.get(0));
			Assert.assertEquals(true, driver.getCurrentUrl().contains("products"));
			test.log(Status.PASS,"Selcted product Details Page is displayed");

			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "something went wrong: "+e.getMessage());
		}
	}
	//@Test
	public void case1() throws Exception
	{
		// 490-492, 494-499,502
		productdetailspage();
		try {
		test=extent.createTest("Verifying product details page functionality ");
		test.log(Status.INFO,"product details page is Displayed");
		
		SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
		ProductDetailsPage productdetailspageobject=PageFactory.initElements(driver, ProductDetailsPage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		
		
		String productName = productdetailspageobject.ProductName.getText(); 
		
		
		Assert.assertEquals(true, productdetailspageobject.ProductName.isDisplayed());
		test.log(Status.PASS,"product name is displayed :-  "+productName);
		
		Assert.assertEquals(true, productdetailspageobject.ProductCompany.isDisplayed());
		test.log(Status.PASS,"product company name is displayed :-  "+productdetailspageobject.ProductCompany.getText());
		
		Assert.assertEquals(true, productdetailspageobject.ProductImage.isDisplayed());
		test.log(Status.PASS,"product image  is displayed ");
		
		Assert.assertEquals(true, productdetailspageobject.AddToCartButton.isDisplayed());
		test.log(Status.PASS,"add to cartbutton  is displayed ");
		
		Assert.assertEquals(productTitle, productdetailspageobject.ProductName.getText());
		test.log(Status.PASS,"selected title and product title in this page are matced :-  "+productName);
		
		Assert.assertEquals(true, productdetailspageobject.warrentydetails.isDisplayed());
		test.log(Status.PASS,"warrenty details are displayed :- "+productdetailspageobject.warrentydetails.getText());
		
		Assert.assertEquals(true, productdetailspageobject.deliveryAddress.isDisplayed());
		test.log(Status.PASS,"delivery details are displayed :- "+productdetailspageobject.deliveryAddress.getText());
		
		
		click(productdetailspageobject.wishlisticonsignup);
		wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
		Assert.assertEquals(true,signuppageobject.close.isDisplayed());
		test.log(Status.PASS," login page is displayed");
		click(signuppageobject.close);		
		
		click(productdetailspageobject.AddToCartButton);
		Assert.assertEquals(true, driver.getCurrentUrl().contains("cart"));
		test.log(Status.PASS," cart page is displayed");
		Assert.assertEquals(productName.toLowerCase(), cartpageobject.ProductTitlesCart.get(0).getText().toLowerCase());
		test.log(Status.PASS,"cart page product title is match with selected product ");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "something went wrong: "+e.getMessage());
		}
	}
//	@Test
	public void case2()
	{
		test=extent.createTest("Verifying product details page functionality ");

		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		LoginPage loginpageobject=PageFactory.initElements(driver, LoginPage.class);
		ProductDetailsPage productdetailspageobject=PageFactory.initElements(driver, ProductDetailsPage.class);
		WishlistPage wishlistpageobject=PageFactory.initElements(driver, WishlistPage.class);
		ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);

		
		hover(homepageobject.UserIcon);
		test.log(Status.INFO,"User Icon is highlighted");
		
		click(homepageobject.Login);
		test.log(Status.INFO,"Navigate to Login Popup");
		
		enterData(loginpageobject.Email,config.getProperty("LoginEmail"));
		enterData(loginpageobject.Password,config.getProperty("LoginPassword"));
		test.log(Status.INFO,"Entered valid Login Details");
		
		click(loginpageobject.LoginButton);
		test.log(Status.INFO,"Navigate to Home Page");		
		
		hover(homepageobject.Living);
		hover(homepageobject.LivingSM.get(0));
		click(homepageobject.LivingSM.get(0));
		hover(homepageobject.subsublistimage.get(0));
		click(homepageobject.subsublistimage.get(0));
		driver.close();
		switchToChildWindow();	
		
		hover(productspageobject.ProductImages.get(0));
		click(productspageobject.viewproductButtons.get(0));
		
		
		
		test.log(Status.INFO,"product details page is Displayed");
		
		String count = wishlistpageobject.WishlistCount.getText();
		
		hover(productdetailspageobject.wishlisticonafterlogin);
		click(productdetailspageobject.wishlisticonafterlogin);
		
		String count1 = wishlistpageobject.WishlistCount.getText();
		
		Assert.assertEquals(count, count1);
		test.log(Status.PASS,"product is added to wishlist page: "+count+" = "+count1);
//		
	}
	
	
	@Test
	public void case3() throws Exception
	{
		// 500.501,503-511
		productdetailspage();
		try {
		test=extent.createTest("Verifying product details page functionality ");
		test.log(Status.INFO,"product details page is Displayed");
		
		ProductDetailsPage productdetailspageobject=PageFactory.initElements(driver, ProductDetailsPage.class);
	
		
		String citypincode =  productdetailspageobject.cityname.getText();
		String deliveryaddress = productdetailspageobject.deliveryAddress.getText();
		Assert.assertEquals(true, productdetailspageobject.cityname.isDisplayed());
		test.log(Status.PASS,"pincode field is displayed:  "+citypincode);
		
		Assert.assertEquals(true, productdetailspageobject.changellink.isDisplayed());
		test.log(Status.PASS,"change link is displayed");
		click(productdetailspageobject.changellink);
		//Thread.sleep(4000);
		enterData(productdetailspageobject.enterpincode,"500037");
		click(productdetailspageobject.checkbutton);
		Thread.sleep(4000);
		Assert.assertNotEquals(citypincode, productdetailspageobject.cityname.getText());
		test.log(Status.PASS,"pincode is changed based on input");
		Assert.assertNotEquals(deliveryaddress, productdetailspageobject.deliveryAddress.getText());
		test.log(Status.PASS,"delivery onformation is changed based on pincode address");
		
		
		for(int i=0;i<productdetailspageobject.tabsspecification.size();i++)
		{
			click(productdetailspageobject.tabsspecification.get(i));
			Assert.assertEquals(true, productdetailspageobject.tabsspecification.get(i).isDisplayed());
			test.log(Status.PASS,"specification title of a product: "+productdetailspageobject.tabsspecification.get(i).getText());
			Assert.assertEquals(true, productdetailspageobject.tabsspecificationcontent.get(i).isDisplayed());
			test.log(Status.PASS,"content is displayed for  a product specification:-  "+productdetailspageobject.tabsspecificationcontent.get(i).getText());
		}
		
		Assert.assertEquals(true, productdetailspageobject.review.isDisplayed());
		test.log(Status.PASS,"review:- "+ productdetailspageobject.review.getText());
		test.log(Status.PASS,"reviewer Name:- "+ productdetailspageobject.reviewername.getText());
		
		Assert.assertEquals(true, productdetailspageobject.dimensions.isDisplayed());
		test.log(Status.PASS," product dimestion image is displayed ");
		
		Assert.assertEquals(true, productdetailspageobject.similarproducts.isDisplayed());
		test.log(Status.PASS," similar product section is displayed ");
		
		Assert.assertEquals(true, productdetailspageobject.visitourstore.isDisplayed());
		test.log(Status.PASS," visit our store section is displayed ");
		
		hover( productdetailspageobject.AddtoCompareButton);
		Assert.assertEquals(true, productdetailspageobject.AddtoCompareButton.isDisplayed());
		test.log(Status.PASS," add to compare button is displayed ");
		
		click( productdetailspageobject.AddtoCompareButton);
		Thread.sleep(4000);
		Assert.assertEquals(true, productdetailspageobject.compare.isDisplayed());
		test.log(Status.PASS,"popup is visible with product recent we have click on addticompare button");
		
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "something went wrong: "+e.getMessage());
		}
	}	
	
}
