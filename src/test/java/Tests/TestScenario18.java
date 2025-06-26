package Tests;

import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.FindaStorePage;
import Pages.HomePage;
import utilities.BaseClass;

public class TestScenario18 extends BaseClass
{
	//@Test
	public void testcase1() throws Exception 
	{
		//--- 207-210
		test=extent.createTest("Verify Find a Store - city store details  Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		FindaStorePage findastorepageobject=PageFactory.initElements(driver, FindaStorePage.class);
		parent = driver.getWindowHandle();
		
		click(homepageobject.FindaStore);
		test.log(Status.INFO,"Navigate to Find a Store Page");
	
		click(findastorepageobject.CityImages.get(2));
		test.log(Status.INFO,"Navigate to Furniture City Page");
		
		switchToChildWindow();
		//for(int i=0;i<findastorepageobject.ViewDetailsButton.size();i++)
		//{
			String cityname=findastorepageobject.AreaNames.get(0).getText();
			
			hover(findastorepageobject.ViewDetailsButton.get(0));
			test.log(Status.INFO,"View Details Button is Highlighted");
			
			click(findastorepageobject.ViewDetailsButton.get(0));
			test.log(Status.INFO,"Navigate "+cityname+" Store details page");
			
			Assert.assertEquals(true, findastorepageobject.AreaStoreHeading.getText().contains(cityname.substring(0, 3)));
			test.log(Status.PASS,cityname+" Store details page is Displayed");
	
		//	break;	
		//}
			
		
		Assert.assertEquals(true, findastorepageobject.Address.isDisplayed());
		test.log(Status.PASS,"Store Address is Displayed in a page : "+findastorepageobject.Address.getText());
		
		Assert.assertEquals(true, findastorepageobject.phonenumber.getText().contains("+91"));
		test.log(Status.PASS,"Store Phone Number is Displayed in a page : "+findastorepageobject.phonenumber.getText());
		
		Assert.assertEquals(true, findastorepageobject.email.getText().contains("urbanladder"));
		test.log(Status.PASS,"Store Email Address is Displayed in a page : "+findastorepageobject.email.getText());
		
		Assert.assertEquals(true, findastorepageobject.workinghours.getText().contains("AM"));
		test.log(Status.PASS,"Store working hours is Displayed in a page : "+findastorepageobject.workinghours.getText());
		
		driver.close();
		switchToParentWindow(parent);
	}
	//@Test
	public void testcase2() throws Exception 
	{
		//--- 211-212
		test = extent.createTest("Verify Find a Store - city store details - links Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");

		test.log(Status.INFO, "Urban Ladder Web Application HomePage is Displayed");

		HomePage homepageobject = PageFactory.initElements(driver, HomePage.class);
		FindaStorePage findastorepageobject = PageFactory.initElements(driver, FindaStorePage.class);

		String parentWindow = driver.getWindowHandle();

		click(homepageobject.FindaStore);
		test.log(Status.INFO, "Navigated to Find a Store Page");

		click(findastorepageobject.CityImages.get(2));
		test.log(Status.INFO, "Clicked on City Image - Navigated to Furniture City Page");

		// Switch to child window (Furniture stores in a City)
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) 
		{
		    if (!handle.equals(parentWindow)) 
		    {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		String cityWindow = driver.getWindowHandle();

		
		//for (int i = 0; i < findastorepageobject.ViewDetailsButton.size(); i++) {
		    String cityName = findastorepageobject.AreaNames.get(0).getText();

		    hover(findastorepageobject.ViewDetailsButton.get(0));
		    test.log(Status.INFO, "Hovered on View Details Button for " + cityName);

		    click(findastorepageobject.ViewDetailsButton.get(0));
		    test.log(Status.INFO, "Navigated to " + cityName + " Store Details Page");

		    Assert.assertTrue(findastorepageobject.AreaStoreHeading.getText().contains(cityName.substring(0, 3)));
		    test.log(Status.PASS, cityName + " Store details page is Displayed");
		  //  break;
		//}

		
		click(findastorepageobject.ViewonGooglemapsButton);
		test.log(Status.INFO, "Navigate to Google Maps page");

		// Switch to Google Maps window
		Set<String> allWindows = driver.getWindowHandles();
		for (String handle : allWindows) {
		    if (!handle.equals(parentWindow) && !handle.equals(cityWindow)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		
		Assert.assertTrue(driver.getCurrentUrl().contains("map"));
		test.log(Status.PASS, "Google Map page is displayed");

		// Close Google Maps tab
		driver.close();

		// Switch back to city window and close it
		driver.switchTo().window(cityWindow);
		
		click(findastorepageobject.Requestacallback);
		test.log(Status.INFO, "Navigate to request call back google form page'");
		
		
		// Switch to Google Maps window
		Set<String> allWindows1 = driver.getWindowHandles();
		for (String handle : allWindows1) {
		    if (!handle.equals(parentWindow) && !handle.equals(cityWindow)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("form"));
		test.log(Status.PASS, "Google form page is displayed");
		
		driver.close();
		
		// Switch back to city window and close it
		driver.switchTo().window(cityWindow);
		driver.close();
		

		// Switch back to parent (main) window
		driver.switchTo().window(parentWindow);

		
	}
	//@Test
	public void testcase3() throws Exception 
	{
		//--- 213-216
		test=extent.createTest("Verify Find a Store - city store details  Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		FindaStorePage findastorepageobject=PageFactory.initElements(driver, FindaStorePage.class);
		parent = driver.getWindowHandle();
		
		click(homepageobject.FindaStore);
		test.log(Status.INFO,"Navigate to Find a Store Page");
	
		click(findastorepageobject.CityImages.get(2));
		test.log(Status.INFO,"Navigate to Furniture City Page");
		
		// Switch to child window (Furniture stores in a City)
				Set<String> windowHandles = driver.getWindowHandles();
				for (String handle : windowHandles) 
				{
				    if (!handle.equals(parent)) 
				    {
				        driver.switchTo().window(handle);
				        break;
				    }
				}
				String cityWindow = driver.getWindowHandle();
				
		//for(int i=0;i<findastorepageobject.ViewDetailsButton.size();i++)
		//{
			String cityname=findastorepageobject.AreaNames.get(0).getText();
			
			hover(findastorepageobject.ViewDetailsButton.get(0));
			test.log(Status.INFO,"View Details Button is Highlighted");
			
			click(findastorepageobject.ViewDetailsButton.get(0));
			test.log(Status.INFO,"Navigate "+cityname+" Store details page");
			
			Assert.assertEquals(true, findastorepageobject.AreaStoreHeading.getText().contains(cityname.substring(0, 3)));
			test.log(Status.PASS,cityname+" Store details page is Displayed");
	
			//break;	
		//}
		
		switchToFrameByIndex(0);
		
		click(findastorepageobject.Zoomin);test.log(Status.INFO,"Zoom in the google maps");
		click(findastorepageobject.Zoomin);test.log(Status.INFO,"Zoom in the google maps");
		
		click(findastorepageobject.Zoomout);test.log(Status.INFO,"Zoom out the google maps");
		click(findastorepageobject.Zoomout);test.log(Status.INFO,"Zoom out the google maps");

		Assert.assertEquals(true, findastorepageobject.mapaddress.isDisplayed());
		test.log(Status.PASS, "Google Map Address is Verified");
		
		click(findastorepageobject.viewlargermap);
		test.log(Status.INFO,"Navigate to  google maps page");
		
		Set<String> allWindows = driver.getWindowHandles();
		for (String handle : allWindows) {
		    if (!handle.equals(parent) && !handle.equals(cityWindow)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("map"));
		test.log(Status.PASS, "Google Map page is displayed");

		// Close Google Maps tab
		driver.close();

		// Switch back to city window and close it
		driver.switchTo().window(cityWindow);
driver.close();
		

		// Switch back to parent (main) window
		driver.switchTo().window(parent);
		
		
	}
	@Test
	public void testcase4() throws Exception 
	{
		//--- 217
		test=extent.createTest("Verify Find a Store - city store details  Functionality").assignCategory("Positive Testing").assignAuthor("Bharath Reddy");
		test.log(Status.INFO,"Urban Ladder Web Application HomePage is Displayed");
				
		HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
		FindaStorePage findastorepageobject=PageFactory.initElements(driver, FindaStorePage.class);
		parent = driver.getWindowHandle();
		
		click(homepageobject.FindaStore);
		test.log(Status.INFO,"Navigate to Find a Store Page");
	
		click(findastorepageobject.CityImages.get(2));
		test.log(Status.INFO,"Navigate to Furniture City Page");
		
		// Switch to child window (Furniture stores in a City)
				Set<String> windowHandles = driver.getWindowHandles();
				for (String handle : windowHandles) 
				{
				    if (!handle.equals(parent)) 
				    {
				        driver.switchTo().window(handle);
				        break;
				    }
				}
				String cityWindow = driver.getWindowHandle();
				
		
			String cityname=findastorepageobject.AreaNames.get(0).getText();
			
			hover(findastorepageobject.ViewDetailsButton.get(0));
			test.log(Status.INFO,"View Details Button is Highlighted");
			
			click(findastorepageobject.ViewDetailsButton.get(0));
			test.log(Status.INFO,"Navigate "+cityname+" Store details page");
			
			Assert.assertEquals(true, findastorepageobject.AreaStoreHeading.getText().contains(cityname.substring(0, 3)));
			test.log(Status.PASS,cityname+" Store details page is Displayed");
	
			
		
		switchToFrameByIndex(0);
		
		click(findastorepageobject.reviews);
		test.log(Status.INFO,"Navigate to  google review page");
		
		Set<String> allWindows = driver.getWindowHandles();
		for (String handle : allWindows) {
		    if (!handle.equals(parent) && !handle.equals(cityWindow)) {
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("search"));
		test.log(Status.PASS, "Google page with Google Review Popup is displayed");

		// Close Google Maps tab
		driver.close();

		// Switch back to city window and close it
		driver.switchTo().window(cityWindow);
driver.close();
		

		// Switch back to parent (main) window
		driver.switchTo().window(parent);
		
		
	}

}
