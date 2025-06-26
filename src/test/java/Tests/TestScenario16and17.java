package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.FindaStorePage;
import Pages.HomePage;

import utilities.BaseClass;

public class TestScenario16and17 extends BaseClass
{
	//@Test
	public void testcase1() 
	{
		//---196-198
		test=extent.createTest("Verify Find a Store Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		FindaStorePage findastorepageobject=PageFactory.initElements(driver, FindaStorePage.class);
		parent = driver.getWindowHandle();
		
		click(homepageobject.FindaStore);
		test.log(Status.INFO,"Navigate to Find a Store Page");
		
		for(int i=0;i<findastorepageobject.CityImages.size();i++)
		{
			hover(findastorepageobject.CityImages.get(i));
		}
		
		Assert.assertEquals(22, findastorepageobject.CityImages.size());
		test.log(Status.PASS,"All City Names are Displayed");
		
		for(int i=0;i<findastorepageobject.CityImages.size();i++)
		{
			click(findastorepageobject.CityImages.get(i));
			test.log(Status.INFO,"Navigate to City Furniture Stores Page");
			switchToChildWindow();
			
			Assert.assertEquals(true, driver.getCurrentUrl().contains("furniture-stores"));
			test.log(Status.PASS,"Selected City Furniture Stores Page");
			driver.close();
			switchToParentWindow(parent);
		}
		
	}
	//@Test
	public void testcase2() throws Exception 
	{
		//--- 199-202
		test=extent.createTest("Verify Find a Store - city store details Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		FindaStorePage findastorepageobject=PageFactory.initElements(driver, FindaStorePage.class);
		parent = driver.getWindowHandle();
		
		click(homepageobject.FindaStore);
		test.log(Status.INFO,"Navigate to Find a Store Page");
	
		click(findastorepageobject.CityImages.get(2));
		test.log(Status.INFO,"Navigate to Furniture City Page");
		
		switchToChildWindow();
		
		int size = findastorepageobject.NoofAreas.size();
		if(size>0)
		{
			Assert.assertTrue(true);
			test.log(Status.PASS,size+" : No of cities are Displayed ");
		}
	
		click(findastorepageobject.MoreLink);
		test.log(Status.INFO,"Display full paragraph");
		
		Assert.assertEquals(true, findastorepageobject.LessLink.isDisplayed());
		test.log(Status.PASS,"Less Link is Displayed");
		
		click(findastorepageobject.LessLink);
		test.log(Status.INFO,"Display firstline of paragraph");
		
		Assert.assertEquals(true, findastorepageobject.MoreLink.isDisplayed());
		test.log(Status.PASS,"More Link is Displayed");
		
		for(int i=0;i<4;i++)  //findastorepageobject.AllLinks.size()
		{
			String linktext=findastorepageobject.AllLinks.get(i).getText();
			click(findastorepageobject.AllLinks.get(i));
			test.log(Status.INFO,"select on link in a city page");
			Assert.assertEquals(true, driver.getCurrentUrl().contains(linktext.substring(0, 3)));
			test.log(Status.PASS,"links are redirected to related page : "+linktext);
			
			driver.navigate().back();
			
		}
		
		driver.close();
		switchToParentWindow(parent);
		
		
	
	}
	
	@Test
	public void testcase3() throws Exception 
	{
		//--- 203-206
		test=extent.createTest("Verify Find a Store - city store details - view details button Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		FindaStorePage findastorepageobject=PageFactory.initElements(driver, FindaStorePage.class);
		parent = driver.getWindowHandle();
		
		click(homepageobject.FindaStore);
		test.log(Status.INFO,"Navigate to Find a Store Page");
	
		click(findastorepageobject.CityImages.get(2));
		test.log(Status.INFO,"Navigate to Furniture City Page");
		
		switchToChildWindow();
		
		for(int i=0;i<findastorepageobject.ViewDetailsButton.size();i++)
		{
			String cityname=findastorepageobject.AreaNames.get(i).getText();
			
			hover(findastorepageobject.ViewDetailsButton.get(i));
			test.log(Status.INFO,"View Details Button is Highlighted");
			
			click(findastorepageobject.ViewDetailsButton.get(i));
			test.log(Status.INFO,"Navigate "+cityname+"Store details page");
			
			Assert.assertEquals(true, findastorepageobject.AreaStoreHeading.getText().contains(cityname.substring(0, 3)));
			test.log(Status.PASS,cityname+"Store details page is Displayed");
			
			driver.navigate().back();
			
		}
		
		for(int i=0;i<findastorepageobject.NoofAreas.size();i++)
		{
			String cityname=findastorepageobject.AreaNames.get(i).getText();
			
			hover(findastorepageobject.NoofAreas.get(i));
			test.log(Status.INFO,"Area Image is Highlighted");
			
			click(findastorepageobject.NoofAreas.get(i));
			test.log(Status.INFO,"Navigate "+cityname+"Store details page");
			
			Assert.assertEquals(true, findastorepageobject.AreaStoreHeading.getText().contains(cityname.substring(0, 3)));
			test.log(Status.PASS,cityname+"Store details page is Displayed");
			
			driver.navigate().back();
			
		}
		
		driver.close();
		switchToParentWindow(parent);
		
	}
}
