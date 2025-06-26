package Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import utilities.BaseClass;

public class GenericMethods extends BaseClass
{
	public void search(String product) 
	{
		test=extent.createTest("search a product");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
		
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		
		enterData(homepageobject.SearchBar,product);
		click(homepageobject.SearchIconButton);
		test.log(Status.INFO,"Display searched Products");
	}
	public void selectProduct(int index)
	{
		ProductsPage productspageobject=PageFactory.initElements(driver, ProductsPage.class);
		
		click(productspageobject.ProductImages.get(index));
		test.log(Status.INFO,"select product");
		switchToChildWindow();
		test.log(Status.INFO,"Navigated to new  window");
		
	}
	public void addToCart(int index)
	{
		ProductDetailsPage productdetailsspageobject=PageFactory.initElements(driver, ProductDetailsPage.class);
		click(productdetailsspageobject.AddToCartButton);
	}
		
		
	public void popClose()
	{
		try 
		{
			SignUpPage signuppageobject=PageFactory.initElements(driver, SignUpPage.class);
			hover(signuppageobject.close);
			click(signuppageobject.close);
		}
		catch(Exception e) 
		{
			Assert.fail();
			test.log(Status.FAIL,"somthing went wrong : "+ e.getMessage());
			screenshot("recently viewed");
		}
			
	}
	

}
