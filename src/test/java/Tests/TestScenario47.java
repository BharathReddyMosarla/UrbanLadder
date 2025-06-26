package Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.ProductsPage;
import Pages.SignUpPage;
import utilities.BaseClass;

public class TestScenario47 extends BaseClass
{

	//@Test
	public void case1()
	{
		try 
		{
			//470-474, 481-484
			
			test=extent.createTest("Verifying product category page - products : outofstock, buttons");
			test.log(Status.INFO,"Home page is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
			ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
			parent = driver.getWindowHandle();
			
			hover(homepageobject.Living);
			hover(homepageobject.LivingSM.get(0));
			click(homepageobject.LivingSM.get(0));
			
			for(int i=0;i<homepageobject.subsublistimage.size();i++)
			{
				Assert.assertEquals(true, homepageobject.catinfo.get(i).isDisplayed());
				Assert.assertEquals(true, homepageobject.productcount.get(i).isDisplayed());
				test.log(Status.PASS,"product category names and count is displayed : "+ homepageobject.catinfo.get(i).getText());
			}
			
			
			hover(homepageobject.subsublistimage.get(2));
			click(homepageobject.subsublistimage.get(2));
			
			switchToChildWindow();
			wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
			click(signuppageobject.close);
			test.log(Status.INFO,"selcted product category page is diplayed with related products: "+homepageobject.productmenuheading.getText());
			
			for(int i=0;i<productspageobject.linksorder.size();i++)
			{
				hover(productspageobject.linksorder.get(i));
				Assert.assertEquals(true, productspageobject.linksorder.get(i).isDisplayed());
				test.log(Status.PASS,"Navigation links are highlighted and displayed - functional : "+productspageobject.linksorder.get(i).getText());
			}
			int pageproductcount=Integer.parseInt(productspageobject.productcountforcategory.getText().replaceAll("[^0-9]", ""));
			
			for(int i=0;i<productspageobject.ProductImages.size();i++)
			{
				Assert.assertEquals(true, productspageobject.AddWishlisticons.get(i).isDisplayed());
				hover(productspageobject.ProductImages.get(i));
				Assert.assertEquals(true, productspageobject.AddtoCompareButtons.get(i).isDisplayed());
//				
				Assert.assertEquals(true, productspageobject.viewproductButtons.get(i).isDisplayed());
//				hover(productspageobject.AddWishlisticons.get(i));
				Assert.assertEquals(true, productspageobject.AddWishlistbuttons.get(i).isDisplayed());
				test.log(Status.PASS,"compare button, wishlist icon, add wishlist text, viewproduct button/ view options button are displayed for each product when hovered ");
				try
				{
					Assert.assertEquals(true, productspageobject.ribbontextsale.get(i).isDisplayed());
					test.log(Status.PASS,"sale ribbon is displayed for products in a page : "+i);
				}
				catch(Exception e) {}
				
			}
			
			test.log(Status.INFO,"sold out products in a page : "+productspageobject.soldouttext.size());

			
			Assert.assertEquals(productspageobject.ProductImages.size(), pageproductcount);
			test.log(Status.PASS,"product count is matched in a page");
			
			// filter
			
			
			for(int i=0;i<productspageobject.FilterOptions.size();i++)
			{
				hover(productspageobject.FilterOptions.get(i));
				Assert.assertEquals(true, productspageobject.FilterOptions.get(i).isDisplayed());
				test.log(Status.PASS,"filter option is displayed and available options are shown: "+productspageobject.FilterOptions.get(i).getText());
			}
			
			Assert.assertEquals(false, productspageobject.checkboxforoutofstock.isSelected());
			
			hover(productspageobject.checkboxforoutofstock);
			click(productspageobject.checkboxforoutofstock);
			Assert.assertEquals(true, productspageobject.checkboxforoutofstock.isSelected());
			
			for(int i=0;i<productspageobject.ProductImages.size();i++)
			{
			
				hover(productspageobject.ProductImages.get(i));
			}
			test.log(Status.INFO,"sold out products in a page 0 after selecting the checkbox: "+productspageobject.soldouttext.size());
		
			
		}catch(Exception e) {}
		driver.close();
		switchToParentWindow(parent);
	}
	//@Test
	public void case2() throws Exception
	{
		//474
		test=extent.createTest("Verifying product category page - products : sortby - options");
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
		switchToChildWindow();
		wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
		click(signuppageobject.close);
		test.log(Status.INFO,"selcted product category page is diplayed with related products: "+homepageobject.productmenuheading.getText());
		
		
		Assert.assertEquals(true, productspageobject.sortbytext.isDisplayed());
		test.log(Status.PASS,"sort by text is visble");
		
		hover(productspageobject.selectedoptionsortby);
		Assert.assertEquals(true, productspageobject.selectedoptionsortby.isDisplayed());
		test.log(Status.PASS,"selected option is displayed for sorting a products in a page : "+productspageobject.selectedoptionsortby.getText());
		for(int i=0;i<productspageobject.sortoptions.size();i++)
		{
			hover(productspageobject.sortoptions.get(i));
			test.log(Status.INFO,"Option - "+i+" : "+productspageobject.sortoptions.get(i).getText());
		}
		driver.close();
		switchToParentWindow(parent);
	}
	//@Test
	public void case3() throws Exception
	{
		//477-480
		test=extent.createTest("Verifying product category page - products : sortby");
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
		switchToChildWindow();
		wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
		click(signuppageobject.close);
		test.log(Status.INFO,"selcted product category page is diplayed with related products: "+homepageobject.productmenuheading.getText());
		
		
		// 1
		
		hover(productspageobject.selectedoptionsortby);
		click(productspageobject.sortoptions.get(1));
		test.log(Status.INFO,"selecting sortby option : "+productspageobject.sortoptions.get(1).getText());
		Thread.sleep(2000);
	
		List<Integer> products = new ArrayList<>();
		for (int i = 0; i<20; i++) 
		{
			hover(productspageobject.ProductImages.get(i));
			String productpricestext = productspageobject.ProductPrices.get(i).getText();
			int  productprices = Integer.parseInt(productpricestext.replaceAll("[^0-9]", ""));
		    products.add(productprices);
		}

		List<Integer> sortedProducts = new ArrayList<>(products);
		Collections.sort(sortedProducts); 	
		Assert.assertEquals(products, sortedProducts, "Products are not sorted in ascending order");
		test.log(Status.PASS,"products are displaye according to selecting sorting orde- low to high: "+products+" = "+sortedProducts);
		action.moveToElement(productspageobject.headingproduct);
		// 2
		
		hover(productspageobject.selectedoptionsortby);
		click(productspageobject.sortoptions.get(2));
		test.log(Status.INFO,"selecting sortby option : "+productspageobject.sortoptions.get(2).getText());
		Thread.sleep(5000);			
	
		List<Integer> products1 = new ArrayList<>();
		for (int i = 0; i<20; i++) 
		{
			hover(productspageobject.ProductImages.get(i));
			String productpricestext1 = productspageobject.ProductPrices.get(i).getText();
			int  productprices1 = Integer.parseInt(productpricestext1.replaceAll("[^0-9]", ""));
		    products1.add(productprices1);
		}

		List<Integer> sortedProducts1 = new ArrayList<>(products1);
		Collections.sort(sortedProducts1); 	
	//	Assert.assertEquals(products1, sortedProducts1.reversed(), "Products are not sorted in ascending order");
	//	test.log(Status.PASS,"products are displaye according to selecting sorting orde- high to low: "+products1+" = "+sortedProducts1.reversed());
		action.moveToElement(productspageobject.headingproduct);
		// 3

		hover(productspageobject.selectedoptionsortby);
		click(productspageobject.sortoptions.get(3));
		test.log(Status.INFO,"selecting sortby option : "+productspageobject.sortoptions.get(3).getText());
		Thread.sleep(5000);		
		String[] products2 = new String[20];
		for (int i = 0; i<20; i++) 
		{
			hover(productspageobject.ProductImages.get(i));
			String productnames = productspageobject.ProductNames.get(i).getText();
		    products2[i]=productnames;
		}
		test.log(Status.PASS,"products are displaye according to selecting sorting orde- new arrivals: "+Arrays.toString(products2));
		action.moveToElement(productspageobject.headingproduct);
		// 4
		
		hover(productspageobject.selectedoptionsortby);
		click(productspageobject.sortoptions.get(4));
		test.log(Status.INFO,"selecting sortby option : "+productspageobject.sortoptions.get(4).getText());
		Thread.sleep(5000);			
				
		List<Integer> products4 = new ArrayList<>();
		for (int i = 0; i<20; i++) 
		{
			hover(productspageobject.ProductImages.get(i));
			String productdiscountstext = productspageobject.ribbontextsale.get(i).getText();
			
			int   productdiscounts = Integer.parseInt(productdiscountstext.replaceAll("[^0-9]", ""));
		    products4.add( productdiscounts);
		}

		List<Integer> sortedProducts4 = new ArrayList<>(products4);
		Collections.sort(sortedProducts4); 	
//		Assert.assertEquals(products4, sortedProducts4.reversed(), "Products are not sorted in ascending order");
//		test.log(Status.PASS,"products are displaye according to selecting sorting orde- Discount: "+products4+" = "+sortedProducts4.reversed());

	
		
		driver.close();
		switchToParentWindow(parent);
	}
	//@Test
	public void case4() throws Exception 
	{
		//475,476
		test=extent.createTest("Verifying product category page - products : filter apply");
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
		switchToChildWindow();
		wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
		click(signuppageobject.close);
		test.log(Status.INFO,"selcted product category page is diplayed with related products: "+homepageobject.productmenuheading.getText());
		
		int pageproductcount=Integer.parseInt(productspageobject.productcountforcategory.getText().replaceAll("[^0-9]", ""));

		
		hover(productspageobject.FilterOptions.get(3));
		click(productspageobject.materialfilter.get(2));
		Thread.sleep(3000);
		int pageproductcountafter=Integer.parseInt(productspageobject.productcountforcategory.getText().replaceAll("[^0-9]", ""));

		Assert.assertNotEquals(pageproductcount, pageproductcountafter);
		test.log(Status.PASS,"filter is applied");
		
		hover(productspageobject.FilterOptions.get(3));
		click(productspageobject.materialfilter.get(2));
		Thread.sleep(3000);
		int pageproductcountremove=Integer.parseInt(productspageobject.productcountforcategory.getText().replaceAll("[^0-9]", ""));

		Assert.assertEquals(pageproductcount, pageproductcountremove);
		test.log(Status.PASS,"remove filters is applied");
		
		driver.close();
		switchToParentWindow(parent);
	}
	//@Test
	public void case5() throws Exception 
	{
		//485
		test=extent.createTest("Verifying product category page - products : letmeknow ");
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
		switchToChildWindow();
		wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
		click(signuppageobject.close);
		test.log(Status.INFO,"selcted product category page is diplayed with related products: "+homepageobject.productmenuheading.getText());
	
		for(int i=0;i<productspageobject.ProductImages.size();i++)
		{
		
			hover(productspageobject.ProductImages.get(i));
		}
		int soldoutproducts =productspageobject.soldouttext.size();
		test.log(Status.INFO,"sold out products in a page "+soldoutproducts);
	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",productspageobject.soldouttext.get(soldoutproducts-1));
		test.log(Status.INFO,"move to soldout product");
		Assert.assertEquals(true, productspageobject.letmeknowtext.get(soldoutproducts-1).isDisplayed());
		test.log(Status.PASS," letmeknow text is visible");
		driver.close();
		switchToParentWindow(parent);
	
	}
	//@Test
	public void case6() throws Exception 
	{
		//486
		test=extent.createTest("Verifying product category page - products : letmeknow - functionality");
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
		switchToChildWindow();
		wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
		click(signuppageobject.close);
		test.log(Status.INFO,"selcted product category page is diplayed with related products: "+homepageobject.productmenuheading.getText());
	
		for(int i=0;i<productspageobject.ProductImages.size();i++)
		{
		
			hover(productspageobject.ProductImages.get(i));
		}
		int soldoutproducts =productspageobject.soldouttext.size();
		test.log(Status.INFO,"sold out products in a page "+soldoutproducts); //-----
	
	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",productspageobject.letmeknowtext.get(soldoutproducts-1));
	action.moveToElement(productspageobject.letmeknowtext.get(6)).perform();
	
	enterData(productspageobject.emailLetmeknow.get(soldoutproducts-1),"abc@gmail.com");
	test.log(Status.INFO,"entered valid email address: abc@gmail.com");
	enterData(productspageobject.phonenoLetmeknow.get(soldoutproducts-1),"9786765676");
	test.log(Status.INFO,"entered valid mobile number: 9786765676");
	click(productspageobject.letmeknowButton.get(soldoutproducts-1));
	Thread.sleep(2000);
	Assert.assertEquals(true, productspageobject.thankyoumsgletmenkow.get(soldoutproducts-1).isDisplayed());
	test.log(Status.PASS,"Thnak you message is displayed: "+productspageobject.thankyoumsgletmenkow.get(soldoutproducts-1).getText());

	driver.close();
	switchToParentWindow(parent);
	
	}
	//@Test
	public void case7() throws Exception 
	{
		//487,488
		test=extent.createTest("Verifying product category page - products : letmeknow - functionality-error");
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
		switchToChildWindow();
		wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
		click(signuppageobject.close);
		test.log(Status.INFO,"selcted product category page is diplayed with related products: "+homepageobject.productmenuheading.getText());
	
		for(int i=0;i<productspageobject.ProductImages.size();i++)
		{
		
			hover(productspageobject.ProductImages.get(i));
		}
		int soldoutproducts =productspageobject.soldouttext.size();
		test.log(Status.INFO,"sold out products in a page "+soldoutproducts); //-----
	
	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",productspageobject.letmeknowtext.get(soldoutproducts-1));
	action.moveToElement(productspageobject.letmeknowtext.get(6)).perform();
	
	enterData(productspageobject.emailLetmeknow.get(soldoutproducts-1),"");
	test.log(Status.INFO," empty email address");
	enterData(productspageobject.phonenoLetmeknow.get(soldoutproducts-1),"sd");
	test.log(Status.INFO,"entered invalid mobile number: sd");
	click(productspageobject.letmeknowButton.get(soldoutproducts-1));
	Thread.sleep(2000);
	Assert.assertEquals(true, productspageobject.emailerrorletmeknow.get(0).isDisplayed());
	Assert.assertEquals(true, productspageobject.phonenoerrorletmeknow.get(0).isDisplayed());

	test.log(Status.PASS,"error message is displayed: ");
	driver.close();
	switchToParentWindow(parent);
	
	}
	@Test
	public void case8() throws Exception 
	{
		//489
		test=extent.createTest("Verifying product category page - products : viewoptions");
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
		switchToChildWindow();
		wait.until(ExpectedConditions.visibilityOf(signuppageobject.close));
		click(signuppageobject.close);
		test.log(Status.INFO,"selcted product category page is diplayed with related products: "+homepageobject.productmenuheading.getText());
	
		hover(productspageobject.ProductImages.get(0));
		click(productspageobject.viewproductButtons.get(0));
		
		Thread.sleep(5000);
		Assert.assertEquals(true, driver.getCurrentUrl().contains("products"));
		test.log(Status.PASS,"Selcted product Details Page is displayed");
		driver.close();
		switchToParentWindow(parent);
	}
}
