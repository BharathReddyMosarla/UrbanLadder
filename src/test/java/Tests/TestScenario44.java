package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.HomePage;
import Pages.InteriorsPage;
import utilities.BaseClass;

public class TestScenario44 extends BaseClass
{
	//@Test
	public void case1()
	{
		try 
		{//440-448
			test=extent.createTest("Verify interior page - form functionality ");
			test.log(Status.INFO,"Home page is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			InteriorsPage interiorspageobject=PageFactory.initElements(driver, InteriorsPage.class);
			
			hover(homepageobject.Interiors);
			test.log(Status.INFO,"Highlight the Interiors menu");
			hover(interiorspageobject.HomeInteriors);	
			click(interiorspageobject.HomeInteriors);
			test.log(Status.INFO,"Navigate to Interiors Page");
			Assert.assertTrue( interiorspageobject.GetFreeQuoteText.isDisplayed());
			test.log(Status.PASS,"Selected Interior Page is Displayed");
			
			String Pincoden="503111",
				Namen="John",
				MobileNumbern="9843556456",
				Emailn="john@gmail.com";
			
			enterData(interiorspageobject.Pincode,Pincoden);
			enterData(interiorspageobject.Name,Namen);
			enterData(interiorspageobject.MobileNumber,MobileNumbern);
			enterData(interiorspageobject.Email,Emailn);
			test.log(Status.INFO,"entered valid pincode and unavailable location");
			
			Thread.sleep(2000);
			Assert.assertFalse(interiorspageobject.NextButton.isEnabled());
			test.log(Status.PASS,"nextbutton is disabled");
			Assert.assertEquals("Sorry, we are currently not available at your location.We'll keep you posted when we serve your area", interiorspageobject.NotAvailableMsg.getText());
			test.log(Status.PASS,"not available message is displayed for valid pincode: "+Pincoden);
			
			
			interiorspageobject.Pincode.clear();
			interiorspageobject.Name.clear();
			interiorspageobject.MobileNumber.clear();
			interiorspageobject.Email.clear();
			
			String Pincodeiv="dgdg",
					Nameiv="d345",
					MobileNumberiv="ddf",
					Emailiv="jocom";
				
				enterData(interiorspageobject.Pincode,Pincodeiv);
				enterData(interiorspageobject.Name,Nameiv);
				enterData(interiorspageobject.MobileNumber,MobileNumberiv);
				enterData(interiorspageobject.Email,Emailiv);
				click(interiorspageobject.NextButton);
				test.log(Status.INFO,"entered invalid data");
				
			Assert.assertEquals("Please enter a valid 6 digit pincode", interiorspageobject.PicodeError.getText());
			test.log(Status.PASS,"error message is displayed for invalid pincode: "+Pincodeiv);
			Assert.assertEquals("Please enter a valid 10 digit number", interiorspageobject.MobileNumberError.getText());
			test.log(Status.PASS,"error message is displayed for invalid mobilenumber: "+MobileNumberiv);
			Assert.assertEquals("Please enter a valid e-mail address", interiorspageobject.EmailError.getText());
			test.log(Status.PASS,"error message is displayed for invalid email: "+Emailiv);			
			
			interiorspageobject.Pincode.clear();
			interiorspageobject.Name.clear();
			interiorspageobject.MobileNumber.clear();
			interiorspageobject.Email.clear();
			

			click(interiorspageobject.NextButton);
			test.log(Status.INFO,"entered null data");
					
			Assert.assertEquals("Please enter a valid 6 digit pincode", interiorspageobject.PicodeError.getText());
			test.log(Status.PASS,"error message is displayed for null data-  pincode ");
//			wait.until(ExpectedConditions.visibilityOf(interiorspageobject.NameError));
//			Assert.assertEquals("Please enter a valid name", interiorspageobject.NameError.getText());
			test.log(Status.PASS,"error message is displayed for null data-  Name ");
			Assert.assertEquals("Please enter a valid 10 digit number", interiorspageobject.MobileNumberError.getText());
			test.log(Status.PASS,"error message is displayed for null data-  mobile number ");
			Assert.assertEquals("Please enter a valid e-mail address", interiorspageobject.EmailError.getText());
			test.log(Status.PASS,"error message is displayed for null data-  email ");
			
			
			String Pincode="500001",
					Name="John",
					MobileNumber="9843556456",
					Email="john@gmail.com";
				
				enterData(interiorspageobject.Pincode,Pincode);
				enterData(interiorspageobject.Name,Name);
				enterData(interiorspageobject.MobileNumber,MobileNumber);
				enterData(interiorspageobject.Email,Email);	
				
				Assert.assertEquals(interiorspageobject.Pincode.isDisplayed(), true);
				test.log(Status.PASS,"pincode is visible"+interiorspageobject.Pincode.getText());
				Assert.assertEquals(interiorspageobject.City.isDisplayed(), true);
				test.log(Status.PASS,"city name is visible based on pincode"+interiorspageobject.City.getText());
				Assert.assertEquals("true", interiorspageobject.City.getAttribute("readonly"));
				test.log(Status.PASS,"city field is disabled");
				
				click(interiorspageobject.NextButton);
				test.log(Status.INFO,"entered valid data");
				
				
			Assert.assertEquals("Thank you for booking a design consultation.", interiorspageobject.ThankuMsg.getText());
			String OrderId=driver.getCurrentUrl().split("/")[4];
			test.log(Status.PASS,"Thank you Message is displayed and orderid : "+OrderId);
			
			
			Assert.assertTrue(interiorspageobject.ContinueWebsiteButton.isDisplayed());
			test.log(Status.PASS,"continue website button is displayed");
			Assert.assertTrue(interiorspageobject.ProceedtoQuestionarieButton.isDisplayed());
			test.log(Status.PASS,"proceed questionarie button is displayed");
			click(interiorspageobject.ContinueWebsiteButton);
			test.log(Status.INFO,"navigate to home page");
			Assert.assertTrue(homepageobject.CartIcon.isDisplayed());
			test.log(Status.PASS,"home page is displayed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			screenshot("case1-44");
		}
	}
	//@Test
	public void case2()
	{
		try 
		{//449
			test=extent.createTest("Verifying navigation to qutionarie page ");
			test.log(Status.INFO,"Home page is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			InteriorsPage interiorspageobject=PageFactory.initElements(driver, InteriorsPage.class);
			
			hover(homepageobject.Interiors);
			test.log(Status.INFO,"Highlight the Interiors menu");
			hover(interiorspageobject.ModularWardrobes);	
			click(interiorspageobject.ModularWardrobes);
			test.log(Status.INFO,"Navigate to Interiors Page");
			Assert.assertTrue( interiorspageobject.GetFreeQuoteText.isDisplayed());
			test.log(Status.PASS,"Selected Interior Page is Displayed");			
			
			
			String Pincode="500001",
					Name="John",
					MobileNumber="9843556456",
					Email="john@gmail.com";
				hover(interiorspageobject.Pincode);
				enterData(interiorspageobject.Pincode,Pincode);
				enterData(interiorspageobject.Name,Name);
				enterData(interiorspageobject.MobileNumber,MobileNumber);
				enterData(interiorspageobject.Email,Email);	
				test.log(Status.INFO,"entered valid data");
				
				hover(interiorspageobject.NextButton);
				click(interiorspageobject.NextButton);
				
				
				Assert.assertEquals("Thank you for booking a design consultation.", interiorspageobject.ThankuMsg.getText());
				String OrderId=driver.getCurrentUrl().split("/")[4];
				test.log(Status.PASS,"Thank you Message is displayed and orderid : "+OrderId);
				
				click(interiorspageobject.ProceedtoQuestionarieButton);
				test.log(Status.INFO,"navigate to questionarie page");
				
				Assert.assertEquals(true, driver.getCurrentUrl().contains("requirements-questionnaire"));
				test.log(Status.PASS," questionarie page is disolayed");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			screenshot("case2-44");
		}
	}
	//@Test
	public void case3()
	{
		try 
		{//450
			test=extent.createTest("Verify links - kitchen, wardrobe ");
			test.log(Status.INFO,"Home page is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			InteriorsPage interiorspageobject=PageFactory.initElements(driver, InteriorsPage.class);
			
			hover(homepageobject.Interiors);
			test.log(Status.INFO,"Highlight the Interiors menu");
			hover(interiorspageobject.ModularWardrobes);	
			click(interiorspageobject.ModularWardrobes);
			test.log(Status.INFO,"Navigate to Interiors Page");
			Assert.assertTrue( interiorspageobject.GetFreeQuoteText.isDisplayed());
			test.log(Status.PASS,"Selected Interior Page is Displayed");
			
			for(int i=0;i<interiorspageobject.BookdesignconsultationButton.size();i++)
			{
				hover(interiorspageobject.BookdesignconsultationButton.get(i));
				click(interiorspageobject.BookdesignconsultationButton.get(i));
				Assert.assertEquals(true, interiorspageobject.NextButton1.isDisplayed());
				test.log(Status.PASS,"after click on buttons cursor move to get a quote fields at bottom");
			}
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			screenshot("case3-44");
		}
	}
	@Test
	public void case4()
	{
		try 
		{//451,452,453
			test=extent.createTest("Verify interior page - form functionality ");
			test.log(Status.INFO,"Home page is Displayed");
			
			HomePage homepageobject=PageFactory.initElements(driver, HomePage.class);
			InteriorsPage interiorspageobject=PageFactory.initElements(driver, InteriorsPage.class);
			parent = driver.getWindowHandle();
			hover(homepageobject.Interiors);
			test.log(Status.INFO,"Highlight the Interiors menu");
			hover(interiorspageobject.HomeInteriors);	
			click(interiorspageobject.HomeInteriors);
			test.log(Status.INFO,"Navigate to Interiors Page");
			Assert.assertTrue( interiorspageobject.GetFreeQuoteText.isDisplayed());
			test.log(Status.PASS,"Selected Interior Page is Displayed");
			
			

			for(int i=0;i<interiorspageobject.ImagesSamePage.size();i++)
			{
				hover(interiorspageobject.ImagesSamePage.get(i));
				click(interiorspageobject.ImagesSamePage.get(i));
				
				switchToChildWindow();
				Assert.assertEquals(true, driver.getCurrentUrl().contains("interior-design"));
				test.log(Status.PASS,"interior page is displayed");
				driver.close();
				switchToParentWindow(parent);
			}
			
			
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, e.getMessage());
			screenshot("case4-44");
		}
	}
	
			
}
