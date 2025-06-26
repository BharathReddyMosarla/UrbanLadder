package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;

import utilities.BaseClass;

public class TestScenario28 extends BaseClass
{
	
	public void search(String product) throws Exception
	{
		test=extent.createTest("search a product");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
		parent = driver.getWindowHandle();
		
		enterData(homepageobject.SearchBar,product);
		click(homepageobject.SearchIconButton);
		test.log(Status.INFO,"Display searched Products");
		
		click(productspageobject.ProductImages.get(0));
		test.log(Status.INFO,"selectd first product");
		Thread.sleep(1000);
		switchToChildWindow();
		test.log(Status.INFO,"Navigated to new  window");
		driver.close();
		switchToParentWindow(parent);
		
		click(homepageobject.Logo);
//		try {
//		click(signuppageobject.close);}catch(Exception e) {Assert.fail();
//		test.log(Status.FAIL,"somthing went wrong : "+ e.getMessage());
//		screenshot("recently viewed");}
//		click(homepageobject.Logo);
	}
	
	@Test
	public void case1() throws Exception
	{
		// 276-279
		search("chair");
		search("bed");
		search("table");
		search("lamp");
		search("study");
		search("mirror");
		
		
		test=extent.createTest("Verify recently reviewed section").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		try {
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		ProductDetailsPage productdetailspageobject=PageFactory.initElements(driver, ProductDetailsPage.class);
		
		parent = driver.getWindowHandle();
		
		hover(homepageobject.recentlyviewedtext);
		Assert.assertEquals(true, homepageobject.recentlyviewedtext.isDisplayed());
		test.log(Status.PASS,"Recently viewd section is visble in home page");
		String product ="";
		try {
		hover(homepageobject.rvProductImages.get(5));
		 product=homepageobject.rvProductNames.get(5).getText();
		click(homepageobject.rvProductImages.get(5));
		test.log(Status.INFO,"navigate to selected product page");
		}catch(Exception e) 
		{
			hover(homepageobject.rvrightarrow);
			click(homepageobject.rvrightarrow);
			test.log(Status.INFO,"scroll products to left");
			hover(homepageobject.rvProductImages.get(5));
			 product=homepageobject.rvProductNames.get(5).getText();
			click(homepageobject.rvProductImages.get(5));
			test.log(Status.INFO,"navigate to selected product page");
		}
		
		switchToChildWindow();
		test.log(Status.INFO,"Navigated to new  window");
		String product1=productdetailspageobject.ProductName.getText();System.out.println(product1);
		
		Assert.assertEquals(product.toLowerCase(), product1.toLowerCase());
		test.log(Status.PASS,"selected produts are redirected to product page");
		}
		catch(Exception e)
		{
			Assert.fail();
			test.log(Status.FAIL,"somthing went wrong : "+ e.getMessage());
			screenshot("recently viewed");
			
		}
		
		
	}
	//@Test
		public void case2() throws Exception
		{
		//280-281
		//282(already covers in first test cases)
		
			test=extent.createTest("Verify browse popular category section").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
			test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
			try 
			{
				HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);			
				ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
				parent = driver.getWindowHandle();
				
				enterData(homepageobject.SearchBar,"table");
				click(homepageobject.SearchIconButton);
				test.log(Status.INFO,"Display searched Products");
				
				hover(homepageobject.AddressDetailsFooter);
				
				hover(productspageobject.browsepopluarcattext);
				Assert.assertEquals(true, productspageobject.browsepopluarcattext.isDisplayed());
				test.log(Status.PASS,"browse popular category section is visible");
				
				if(productspageobject.bpcProductnames.size()>0)
				{
					String product=productspageobject.bpcProductnames.get(0).getText();
					hover(productspageobject.bpcProductnames.get(0));
					click(productspageobject.bpcProductnames.get(0));
					test.log(Status.INFO,"navigate to selected product page");
					String product1=productspageobject.bpcproductpageheading.getText();
				//	Assert.assertEquals(product.toLowerCase(), product1.toLowerCase());
					Assert.assertEquals(true, product1.contains(product));
					test.log(Status.PASS,"selected produts are redirected to product page");
				}
				
				
			}catch(Exception e)
			{
				Assert.fail();
				test.log(Status.FAIL,"somthing went wrong : "+ e.getMessage());
				screenshot("recently viewed");
				
			}
			
		}

}
