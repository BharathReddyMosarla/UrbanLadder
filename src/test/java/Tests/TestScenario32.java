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

public class TestScenario32 extends BaseClass
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
	//@Test
	public void case1()
	{
		//318-321
		search("chair");
		try {
		test=extent.createTest("Cart page Functionality - coupons popup");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		hover(cartpageobject.ApplyCouponButtonCart);
		click(cartpageobject.ApplyCouponButtonCart);
		test.log(Status.INFO,"display to coupon popup in a Page");
		
		
		for(int i=0;i<cartpageobject.CouponCodes.size();i++)
		{
			Assert.assertEquals(true, cartpageobject.CouponCodes.get(i).isDisplayed());
			test.log(Status.PASS,"Coupon code is visible : "+cartpageobject.CouponCodes.get(i).getText());
			Assert.assertEquals(true, cartpageobject.ApplyCouponButtons.get(i).isDisplayed());
			test.log(Status.PASS,"Apply Coupon button is visible  for : "+cartpageobject.ApplyCouponButtons.get(i).getAttribute("value"));
			Assert.assertEquals(true, cartpageobject.CouponTitleDescs.get(i).isDisplayed());
			test.log(Status.PASS,"Coupon description is visible : "+cartpageobject.CouponTitleDescs.get(i).getText());
			click(cartpageobject.TCs.get(i));
			Assert.assertEquals(true, cartpageobject.TCTexts.get(i).isDisplayed());
			test.log(Status.PASS,"terms and condition text is visible "+cartpageobject.TCTexts.get(i).getText());
			click(cartpageobject.TCCloses.get(i));	
		}	
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case1-32");
		}
	}
//	@Test
	public void case2()
	{
		//322
		search("chair");
		try {
		test=extent.createTest("Cart page Functionality - coupons search - valid and existing");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		hover(cartpageobject.ApplyCouponButtonCart);
		click(cartpageobject.ApplyCouponButtonCart);
		test.log(Status.INFO,"display to coupon popup in a Page");
		
		enterData(cartpageobject.SearchCouponcode,"flat5");
		click(cartpageobject.ApplyButton);
		test.log(Status.INFO,"validating the coupon");
		
		hover(cartpageobject.CouponSuccessfullMessage);
		Assert.assertEquals(true, cartpageobject.CouponSuccessfullMessage.isDisplayed());
		test.log(Status.PASS,"confirmation message is displayed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case2-32");
		}
	}
	//@Test
	public void case3() throws Exception
	{
		//323
		search("chair");
		try {
		test=extent.createTest("Cart page Functionality - coupons search -  non-existing");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		hover(cartpageobject.ApplyCouponButtonCart);
		click(cartpageobject.ApplyCouponButtonCart);
		test.log(Status.INFO,"display to coupon popup in a Page");
		
		enterData(cartpageobject.SearchCouponcode,"flat555");
		click(cartpageobject.ApplyButton);
		test.log(Status.INFO,"validating the coupon");
		
		Thread.sleep(5000);
		Assert.assertEquals("This coupon you entered doesn't exist. Please try again.", cartpageobject.CouponError.getText());
		test.log(Status.PASS,"Error message is displayed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case3-32");
		}
	}
//	@Test
	public void case4() throws Exception
	{
		//324, 325
		search("chair");
		try {
		test=extent.createTest("Cart page Functionality - coupons search - invalid, empty ");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		hover(cartpageobject.ApplyCouponButtonCart);
		click(cartpageobject.ApplyCouponButtonCart);
		test.log(Status.INFO,"display to coupon popup in a Page");
		
		cartpageobject.SearchCouponcode.clear();
		Assert.assertEquals(false,cartpageobject.ApplyButton.isEnabled());
		test.log(Status.PASS,"Apply button is disabled when seach field is empty - verified");
				
		cartpageobject.SearchCouponcode.clear();
		enterData(cartpageobject.SearchCouponcode,"jgsfgfs");
		click(cartpageobject.ApplyButton);
		test.log(Status.INFO,"validating the coupon");
		
		Thread.sleep(5000);
		Assert.assertEquals("This coupon you entered doesn't exist. Please try again.", cartpageobject.CouponError.getText());
		test.log(Status.PASS,"Error message is displayed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case4-32");
		}
	}
	
	//@Test
	public void case5()
	{
		//326. 327, 328
		search("chair");
		try {
		test=extent.createTest("Cart page Functionality - apply coupons");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		hover(cartpageobject.ApplyCouponButtonCart);
		click(cartpageobject.ApplyCouponButtonCart);
		test.log(Status.INFO,"display to coupon popup in a Page");
		
		String couponcode = cartpageobject.CouponCodes.get(0).getText();
		
		click(cartpageobject.ApplyCouponButtons.get(0));
		test.log(Status.INFO,"select and validating the available coupon : "+couponcode);
		hover(cartpageobject.CouponSuccessfullMessage);
		Assert.assertEquals(couponcode, cartpageobject.AppliedPromoCode.getText());
		test.log(Status.PASS,"applied coupon code is successfull : "+couponcode);
		click(cartpageobject.SuccessPopupClose);
		test.log(Status.INFO,"popup is close");
		Assert.assertEquals(couponcode, cartpageobject.AfterApplyPromocodeText.getText());
		test.log(Status.PASS,"apply coupon code is visible on cart page : "+couponcode); //327
		
		click(cartpageobject.RemoveAppliedCoupon);
		test.log(Status.INFO,"removing applied coupon ");
		Assert.assertEquals("", cartpageobject.AfterApplyPromocodeText.getText());
		test.log(Status.PASS,"apply coupon code is removed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case5-32");
		}
	}
	//@Test
	public void case6()
	{
		//329
		search("chair");
		try {
		test=extent.createTest("Cart page Functionality - apply coupons - discounts verified");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		String discounttext = cartpageobject.DiscountsCart.getText();
		int discount = Integer.parseInt(discounttext.replaceAll("[₹,-]", ""));
		test.log(Status.INFO,"discount amount  note down before applying coupon "+discount);
		
		hover(cartpageobject.ApplyCouponButtonCart);
		click(cartpageobject.ApplyCouponButtonCart);
		test.log(Status.INFO,"display to coupon popup in a Page");
		
		String couponcode = cartpageobject.CouponCodes.get(0).getText();
		
		click(cartpageobject.ApplyCouponButtons.get(0));
		test.log(Status.INFO,"select and validating the available coupon : "+couponcode);
		hover(cartpageobject.CouponSuccessfullMessage);
		Assert.assertEquals(couponcode, cartpageobject.AppliedPromoCode.getText());
		test.log(Status.PASS,"applied coupon code is successfull : "+couponcode);
		click(cartpageobject.SuccessPopupClose);
		test.log(Status.INFO,"popup is close");
		Assert.assertEquals(couponcode, cartpageobject.AfterApplyPromocodeText.getText());
		test.log(Status.PASS,"apply coupon code is visible on cart page : "+couponcode); 
		
		String discounttext1 = cartpageobject.DiscountsCart.getText();
		int discount1 = Integer.parseInt(discounttext1.replaceAll("[₹,-]", ""));
		test.log(Status.INFO,"discount amount  note down after applying coupon "+discount1);
		
		int diff = discount1-discount;
		Assert.assertNotEquals(discount1, discount);
		test.log(Status.PASS,"discount is applied to total amount and amount is add to discounts,  applied discount is : "+diff);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case6-32");
		}
		
	}
	//@Test
	public void case7()
	{
		//330,331
		search("chair");
		try {
		test=extent.createTest("Cart page Functionality - cart total(actual prices) and discount total details verified (with out coupon) ");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		int actualprice=0, finalprice =0;
		
		for(int i=0;i<cartpageobject.ProductImagesCart.size();i++)
		{
			String actualtext=cartpageobject.StrikePriceCart.get(i).getText();
			actualprice += Integer.parseInt(actualtext.replaceAll("[₹,]", ""));
			test.log(Status.INFO,"adding actual prices(strike-off) of all products in acart page : "+actualprice);
		}
		
		String carttotaltext=cartpageobject.CartTotalCart.getText();
		int carttotal = Integer.parseInt(carttotaltext.replaceAll("[₹,]", ""));
		test.log(Status.INFO,"cart total amount  note down  "+carttotal);
	
		Assert.assertEquals(actualprice, carttotal);
		test.log(Status.PASS,"amount is verified "+actualprice+"="+carttotal);
		
		for(int i=0;i<cartpageobject.ProductImagesCart.size();i++)
		{
			String finaltext=cartpageobject.FinalPriceCart.get(i).getText();
			finalprice += Integer.parseInt(finaltext.replaceAll("[₹,]", ""));
			test.log(Status.INFO,"adding final prices of all products in a cart page : "+finalprice);

		}
		
		int discountcal = carttotal-finalprice;
		
		String discounttext=cartpageobject.DiscountsCart.getText();
		int discount = Integer.parseInt(discounttext.replaceAll("[₹,-]", ""));
		test.log(Status.INFO,"discount amount  note down  "+discount);
		
		Assert.assertEquals(discountcal, discount);
		test.log(Status.PASS,"discount amount is verified "+discountcal+"="+discount);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case7-32");
		}
	}
	//@Test
	public void case8()
	{
		//332
		search("chair");
		try {
		test=extent.createTest("Cart page Functionality - apply coupons - discount total amount verified ");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		hover(cartpageobject.ApplyCouponButtonCart);
		click(cartpageobject.ApplyCouponButtonCart);
		test.log(Status.INFO,"display to coupon popup in a Page");
		
		enterData(cartpageobject.SearchCouponcode,"flat5");
		click(cartpageobject.ApplyButton);
		test.log(Status.INFO,"validating the coupon");
		
		hover(cartpageobject.CouponSuccessfullMessage);
		Assert.assertEquals(true, cartpageobject.CouponSuccessfullMessage.isDisplayed());
		test.log(Status.PASS,"confirmation message is displayed");
		
		click(cartpageobject.SuccessPopupClose);
		test.log(Status.INFO,"popup is close");
		
		int finalprice=0;
		
		for(int i=0;i<cartpageobject.ProductImagesCart.size();i++)
		{
			String finaltext=cartpageobject.FinalPriceCart.get(i).getText();
			finalprice += Integer.parseInt(finaltext.replaceAll("[₹,]", ""));
			test.log(Status.INFO,"adding final prices of all products in a cart page : "+finalprice);

		}
		
		String carttotaltext=cartpageobject.CartTotalCart.getText();
		int carttotal = Integer.parseInt(carttotaltext.replaceAll("[₹,]", ""));
		test.log(Status.INFO,"cart total amount  note down  "+carttotal);
		
		String coupondiscounttext = cartpageobject.AfterApplyPromocodeamountText.getText();
		int coupondiscount = Integer.parseInt(coupondiscounttext.replaceAll("[^0-9]", ""));
		test.log(Status.INFO,"applied coupon amount  note down  "+coupondiscount);
		
		String discounttext=cartpageobject.DiscountsCart.getText();
		int discount = Integer.parseInt(discounttext.replaceAll("[₹,-]", ""));
		test.log(Status.INFO,"discount amount  note down  "+discount);
		
		Assert.assertEquals(discount, carttotal-finalprice+coupondiscount);
		test.log(Status.PASS,"discount amount is verified "+(carttotal-finalprice+coupondiscount)+"="+discount);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case8-32");
		}
		}
	@Test
	public void case9()
	{
		//333,334
		search("chair");
		try {
		test=extent.createTest("Cart page Functionality - apply coupons -  totalpayable amount and booking amount verified ");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		CartPage cartpageobject=PageFactory.initElements(driver, CartPage.class);
		parent = driver.getWindowHandle();
		
		hover(homepageobject.CartIcon);
		click(homepageobject.CartIcon);
		test.log(Status.INFO,"Navigate to Cart Page");
		
		hover(cartpageobject.ApplyCouponButtonCart);
		click(cartpageobject.ApplyCouponButtonCart);
		test.log(Status.INFO,"display to coupon popup in a Page");
		
		enterData(cartpageobject.SearchCouponcode,"flat5");
		click(cartpageobject.ApplyButton);
		test.log(Status.INFO,"validating the coupon");
		
		hover(cartpageobject.CouponSuccessfullMessage);
		Assert.assertEquals(true, cartpageobject.CouponSuccessfullMessage.isDisplayed());
		test.log(Status.PASS,"confirmation message is displayed");
		
		click(cartpageobject.SuccessPopupClose);
		test.log(Status.INFO,"popup is close");
		
		String carttotaltext=cartpageobject.CartTotalCart.getText();
		int carttotal = Integer.parseInt(carttotaltext.replaceAll("[₹,]", ""));
		test.log(Status.INFO,"cart total amount  note down  "+carttotal);
		
		String discounttext=cartpageobject.DiscountsCart.getText();
		int discount = Integer.parseInt(discounttext.replaceAll("[₹,-]", ""));
		test.log(Status.INFO,"discount amount  note down  "+discount);
		
		String deliverychargestext=cartpageobject.DeliveryChargesCart.getText();
		int deliverycharges = Integer.parseInt(deliverychargestext.replaceAll("[₹,-]", ""));
		test.log(Status.INFO,"delivery charges amount  note down  "+deliverycharges);
		
		String totalpayableamounttext=cartpageobject.TotalPayableAmountCart.getText();
		int totalpayableamount = Integer.parseInt(totalpayableamounttext.replaceAll("[₹,]", ""));
		test.log(Status.INFO,"total payable amount  note down  "+totalpayableamount);
		
		String bookingamounttext=cartpageobject.BookingAmountCart.getText();
		int bookingamount = Integer.parseInt(bookingamounttext.replaceAll("[₹,]", ""));
		test.log(Status.INFO,"booking amount  note down  "+bookingamount);
		
		
		Assert.assertEquals(totalpayableamount, carttotal-discount+deliverycharges);
		test.log(Status.PASS," total payable amount is verified : "+(carttotal-discount+deliverycharges)+"="+totalpayableamount);
	
		Assert.assertEquals(totalpayableamount, bookingamount);
		test.log(Status.PASS," total payable amount is same as booking amount : "+totalpayableamount+"="+bookingamount);
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Somthing went Wrong");
			screenshot("case9-32");
		}
	}
		
	
}
